package edu.pitt.dbmi.edda.lens.entrez;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import edu.pitt.dbmi.edda.lens.entrez.efetch.EntrezEfetchPmcAgent;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pmc.Article;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pmc.ArticleMeta;
import edu.pitt.dbmi.edda.lens.entrez.esearch.EntrezEsearchAgent;

public class PmcResolver {

	private String studyDirectoryPath = "C:\\Users\\kjm84\\Desktop\\tanja_eutils_studies";

	private String runDirectoryPath;

	private int processingThreshold = 50;

	private File studyDirectory;
	private File runDirectory;

	private File pmcIdsFile;
	private File pmcOutFile;
	private File pmcErrFile;
	private File pmcLogFile;

	private BufferedInputStream pmcIdsStream;
	private BufferedOutputStream pmcOutStream;
	private BufferedOutputStream pmcErrStream;
	private BufferedOutputStream pmcLogStream;

	private Date timeStart;
	private Date timeStop;

	private int numberToFetch = -1;
	private int numberOfPmcs = 0;
	private int numberOfPmids = 0;
	private int numberOfDois = 0;
	private int numberOfPiis = 0;

	public static void main(String[] args) {
		PmcResolver pmcResolver = new PmcResolver();
		try {
			if (args.length == 1) {
				pmcResolver.setRunDirectoryPath(args[0]);
				pmcResolver.execute();
			} else {
				System.err.println("Must enter a pmc run directory.");
			}
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void execute() throws IOException {

		establishSourcesAndSinks();

		timeStart = new Date();

		String pmcId = null;

		final List<String> pmcIds = new ArrayList<String>();

		StringBuffer pmcIdBuffer = new StringBuffer();
		while (pmcIdsStream.available() > 0) {
			char c = (char) pmcIdsStream.read();
			if (Character.isDigit(c)) {
				pmcIdBuffer.append(c);
			} else if (c == '\n') {
				pmcIds.add(pmcIdBuffer.toString());
				pmcIdBuffer = new StringBuffer();
				if (pmcIds.size() >= processingThreshold) {
					processPmcIdBatch(pmcIds);
					pmcIds.clear();
				}
			}
		}

		timeStop = new Date();
		ElapsedTimeCalculator durationCalculator = new ElapsedTimeCalculator();
		durationCalculator.setStartDate(timeStart);
		durationCalculator.setStopDate(timeStop);
		durationCalculator.execute();
		pmcLogStream.write(("Runtime is " + durationCalculator + "\n")
				.getBytes());
		pmcLogStream.write(("Number to fetch = " + numberToFetch + "\n")
				.getBytes());
		pmcLogStream.write(( "Number pmcs = " + numberOfPmcs + "\n")
				.getBytes());
		pmcLogStream.write(("Number pmids = " + numberOfPmids + "\n")
				.getBytes());
		pmcLogStream.write(("Number dois = " + numberOfDois + "\n")
				.getBytes());
		pmcLogStream.write(("Number piis = " + numberOfPiis + "\n")
				.getBytes());

		closeSourcesAndSinks();

	}

	private void processPmcIdBatch(List<String> pmcIds) throws IOException {

		String idListAsString = StringUtils.join(pmcIds, ",");

		EntrezEsearchAgent eSearchAgent = new EntrezEsearchAgent();
		eSearchAgent.setHttpSearcher(new HttpSearcher());
		eSearchAgent.setDatabase("pmc");
		eSearchAgent.setQuery(idListAsString);
		eSearchAgent.setUsingHistory(true);
		System.out.println(eSearchAgent.getQuery());
		eSearchAgent.execute();

		EntrezEfetchPmcAgent eFetchAgent = new EntrezEfetchPmcAgent();
		eFetchAgent.setDatabase("pmc");
		eFetchAgent.setHttpSearcher(new HttpSearcher());
		eFetchAgent.setWebEnv(eSearchAgent.getEsearchResult().getWebEnv());
		eFetchAgent.setQueryKey(eSearchAgent.getEsearchResult().getQueryKey());
		eFetchAgent.setRetMax(processingThreshold + "");
		eFetchAgent.setRetMode("xml");
		eFetchAgent.setRetStart("0");
		eFetchAgent.setRetType(null);
		eFetchAgent.executeArticles();
		Collection<Article> articals = eFetchAgent.getArticles();
		processArticles(articals);

	}

	private void processArticles(Collection<Article> articals)
			throws IOException {
		for (Article art : articals) {
			ArticleMeta artMeta = art.getArticleMeta();
			String title = artMeta.getArticleTitle();
			title = title.replaceAll("\n", " ");
			String pmc = artMeta.getPmcId();
			String pmid = artMeta.getPubmedId();
			String doi = artMeta.getDoiId();
			String pii = artMeta.getPublisherItemIdentifier();
			numberOfPmcs = (!pmc.equals("NA")) ? numberOfPmcs + 1
					: numberOfPmcs;
			numberOfPmids = (!pmid.equals("NA")) ? numberOfPmids + 1
					: numberOfPmids;
			numberOfDois = (!doi.equals("NA")) ? numberOfDois + 1
					: numberOfDois;
			numberOfPiis = (!pii.equals("NA")) ? numberOfPiis + 1
					: numberOfPiis;
			String fileLine = String.format("%s,%s,%s,%s%n", title, pmc, pmid,
					doi);
			if (pmid.equals("NA")) {
				pmcErrStream.write(fileLine.getBytes());
			} else {
				pmcOutStream.write(fileLine.getBytes());
			}
		}
	}

	private void establishSourcesAndSinks() throws FileNotFoundException {
		studyDirectory = new File(studyDirectoryPath);
		runDirectory = new File(studyDirectory, getRunDirectoryPath());

		pmcIdsFile = new File(runDirectory, "pmc_ids.csv");

		pmcOutFile = new File(runDirectory, "pmc_out.txt");
		pmcErrFile = new File(runDirectory, "pmc_err.txt");
		pmcLogFile = new File(runDirectory, "pmc_log.txt");
		FileUtils.deleteQuietly(pmcOutFile);
		FileUtils.deleteQuietly(pmcErrFile);
		FileUtils.deleteQuietly(pmcLogFile);

		pmcIdsStream = new BufferedInputStream(new FileInputStream(pmcIdsFile));
		pmcOutStream = new BufferedOutputStream(
				new FileOutputStream(pmcOutFile));
		pmcErrStream = new BufferedOutputStream(
				new FileOutputStream(pmcErrFile));
		pmcLogStream = new BufferedOutputStream(
				new FileOutputStream(pmcLogFile));
	}

	private void closeSourcesAndSinks() throws IOException {
		pmcIdsStream.close();
		pmcOutStream.close();
		pmcErrStream.close();
		pmcLogStream.close();
	}

	public String getRunDirectoryPath() {
		return runDirectoryPath;
	}

	public void setRunDirectoryPath(String runDirectoryPath) {
		this.runDirectoryPath = runDirectoryPath;
	}

	public int getProcessingThreshold() {
		return processingThreshold;
	}

	public void setProcessingThreshold(int processingThreshold) {
		this.processingThreshold = processingThreshold;
	}

}
