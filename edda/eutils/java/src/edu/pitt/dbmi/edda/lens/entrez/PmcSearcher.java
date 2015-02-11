package edu.pitt.dbmi.edda.lens.entrez;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import edu.pitt.dbmi.edda.lens.entrez.efetch.EntrezEfetchPmcAgent;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pmc.Article;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pmc.ArticleMeta;
import edu.pitt.dbmi.edda.lens.entrez.esearch.EntrezEsearchAgent;

public class PmcSearcher {

	private String studyDirectoryPath = "C:\\Users\\kjm84\\Desktop\\tanja_eutils_studies";

	private File studyDirectory;
	private File runDirectory;
	private File pmcFile;
	private File errFile;
	private File runFile;

	private Date timeStart;
	private Date timeStop;

	private int returnBatchSize = 50;
	private int numberToFetch = -1;
	private boolean isAppending = true;

	private int numberOfPmcs = 0;
	private int numberOfPmids = 0;
	private int numberOfDois = 0;
	private int numberOfPiis = 0;

	public static void main(String[] args) {
		PmcSearcher pmcSearcher = new PmcSearcher();
		try {
			pmcSearcher.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void execute() throws IOException {

		timeStart = new Date();

		establishSourcesAndSinks();

		EntrezEsearchAgent eSearchAgent = new EntrezEsearchAgent();
		eSearchAgent.setHttpSearcher(new HttpSearcher());
		eSearchAgent.setDatabase("pmc");
		String tanjaPmcQuery = "2009/10/12[PubDate]:2014/10/10[PubDate]+AND+humans+[MeSH+Terms]+AND+open+access+[filter]";
		eSearchAgent.setQuery(tanjaPmcQuery);
		eSearchAgent.setUsingHistory(true);
		eSearchAgent.execute();

		EntrezEfetchPmcAgent eFetchAgent = new EntrezEfetchPmcAgent();
		eFetchAgent.setDatabase("pmc");
		eFetchAgent.setHttpSearcher(new HttpSearcher());
		eFetchAgent.setQueryKey(eSearchAgent.getEsearchResult().getQueryKey());
		eFetchAgent.setRetMax(returnBatchSize + "");
		eFetchAgent.setRetMode("xml");
		eFetchAgent.setRetStart("0");
		eFetchAgent.setRetType(null);
		eFetchAgent.setWebEnv(eSearchAgent.getEsearchResult().getWebEnv());

		numberToFetch = Integer.valueOf(eSearchAgent.getEsearchResult()
				.getCount());
		int fetchedSoFar = 0;
		for (int rdx = 0; rdx < numberToFetch; rdx += returnBatchSize) {
			eFetchAgent.setRetStart(rdx + "");
			eFetchAgent.execute();
			Collection<Article> articals = eFetchAgent.getArticles();
			fetchedSoFar += articals.size();
			processArticles(articals);
		}
		if (fetchedSoFar < numberToFetch) {
			eFetchAgent.setRetStart(fetchedSoFar + "");
			eFetchAgent.execute();
			Collection<Article> articals = eFetchAgent.getArticles();
			fetchedSoFar += articals.size();
			processArticles(articals);
		}

		timeStop = new Date();
		ElapsedTimeCalculator durationCalculator = new ElapsedTimeCalculator();
		durationCalculator.setStartDate(timeStart);
		durationCalculator.setStopDate(timeStop);
		durationCalculator.execute();
		FileUtils.write(runFile, "Runtime is " + durationCalculator + "\n",
				isAppending);
		FileUtils.write(runFile, "Number to fetch = " + numberToFetch + "\n",
				isAppending);
		FileUtils.write(runFile, "Number articles fetched = " + fetchedSoFar
				+ "\n", isAppending);
		FileUtils.write(runFile, "Number pmcs = " + numberOfPmcs + "\n",
				isAppending);
		FileUtils.write(runFile, "Number pmids = " + numberOfPmids + "\n",
				isAppending);
		FileUtils.write(runFile, "Number dois = " + numberOfDois + "\n",
				isAppending);
		FileUtils.write(runFile, "Number piis = " + numberOfPiis + "\n",
				isAppending);
	}

	private void processArticles(Collection<Article> articals)
			throws IOException {
		for (Article art : articals) {
			ArticleMeta artMeta = art.getArticleMeta();
			if ( artMeta == null) {
				System.err.println("Error missing article meta");
				continue;
			}
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
				FileUtils.write(errFile, fileLine, isAppending);
			} else {
				FileUtils.write(pmcFile, fileLine, isAppending);
			}
		}

	}

	private void establishSourcesAndSinks() {
		studyDirectory = new File(studyDirectoryPath);
		runDirectory = new File(studyDirectory, stringifyDate(timeStart));
		runDirectory.mkdir();
		pmcFile = new File(runDirectory, "pmc.csv");
		errFile = new File(runDirectory, "err.csv");
		runFile = new File(runDirectory, "run.txt");

	}

	private String stringifyDate(Date srcDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(srcDate);
	}

}
