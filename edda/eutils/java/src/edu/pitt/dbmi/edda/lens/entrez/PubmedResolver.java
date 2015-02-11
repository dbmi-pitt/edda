package edu.pitt.dbmi.edda.lens.entrez;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import edu.pitt.dbmi.edda.lens.entrez.efetch.EntrezEfetchPubmedAgent;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed.AbstractEvaluator;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed.ArticleIdList;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed.MeshEvaluator;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed.PubmedArticle;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed.PubmedArticleSet;
import edu.pitt.dbmi.edda.lens.entrez.esearch.EntrezEsearchAgent;

public class PubmedResolver {

	private String studyDirectoryPath = "C:\\Users\\kjm84\\Desktop\\tanja_eutils_studies";

	private String runDirectoryPath = "NA";

	private File studyDirectory;
	private File runDirectory;
	private File pmcFile;
	private File pmidFile;
	private File noMeshFile;
	private File noAbstractFile;
	private File noFetchedFile;
	private File runFile;

	private Date timeStart;
	private Date timeStop;

	private int processingThreshold = 500;

	private MeshEvaluator meshEvaluator = new MeshEvaluator();
	private AbstractEvaluator abstractEvaluator = new AbstractEvaluator();

	private boolean isAppending = true;

	private int numberOfPmcs;
	private int numberOfPmids;
	private int numberOfDois;
	private int numberOfPiis;

	public static void main(String[] args) {
		PubmedResolver pubmedResolver = new PubmedResolver();
		try {
			if (args.length == 1) {
				pubmedResolver.setRunDirectoryPath(args[0]);
				pubmedResolver.execute();
			}
			else {
				System.err.println("Must enter a pmc run directory.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void execute() throws IOException {

		timeStart = new Date();

		establishSourcesAndSinks();

		FileInputStream fis = new FileInputStream(pmcFile);
		BufferedReader in = new BufferedReader(new InputStreamReader(fis));
		String line = null;

		final List<String> pubMedIds = new ArrayList<String>();
		while ((line = in.readLine()) != null) {
			String pmid = extractPmidFromLine(line);
			if (pmid.equals("NA")) {
				System.err.println(line);
			} else {
				pubMedIds.add(pmid);
				if (pubMedIds.size() >= processingThreshold) {
					processPubMedIdBatch(pubMedIds);
					pubMedIds.clear();
				}
			}
		}

		in.close();
		
		timeStop = new Date();

		writeRuntimeStatistics();

	}
	
	private void processPubMedIdBatch(List<String> pubMedIds)
			throws IOException {
		
		reportUniqueIdNumber(pubMedIds);

		String idListAsString = StringUtils.join(pubMedIds, ",");

		EntrezEsearchAgent eSearchAgent = new EntrezEsearchAgent();
		eSearchAgent.setHttpSearcher(new HttpSearcher());
		eSearchAgent.setDatabase("pubmed");
		eSearchAgent.setQuery(idListAsString);
		eSearchAgent.setUsingHistory(true);
		System.out.println(eSearchAgent.getQuery());
		eSearchAgent.execute();

		int numberToFetch = Integer.valueOf(eSearchAgent.getEsearchResult()
				.getCount());

		EntrezEfetchPubmedAgent eFetchAgent = new EntrezEfetchPubmedAgent();
		eFetchAgent.setDatabase("pubmed");
		eFetchAgent.setHttpSearcher(new HttpSearcher());
		eFetchAgent.setQueryKey(eSearchAgent.getEsearchResult().getQueryKey());
		eFetchAgent.setRetStart("0");
		eFetchAgent.setRetMax("" + numberToFetch);
		eFetchAgent.setRetMode("xml");
		eFetchAgent.setRetType(null);
		eFetchAgent.setWebEnv(eSearchAgent.getEsearchResult().getWebEnv());
		eFetchAgent.execute();

		PubmedArticleSet pubmedArticleSet = eFetchAgent.getPubmedArticleSet();
		List<String> fetchedPubMedIds = new ArrayList<String>();
		for (PubmedArticle pubmedArticle : pubmedArticleSet.getPubmedArticles()) {
			if (!pubmedArticle.getArticleIdList().getPmid().equals("NA")) {
				fetchedPubMedIds.add(pubmedArticle.getArticleIdList().getPmid());
			}
			String idOutput = formatTitleAndIds(pubmedArticle);
			tallyIds(pubmedArticle);
			meshEvaluator.evaluate(pubmedArticle);
			String meshOutput = meshEvaluator.toString();
			abstractEvaluator.evaluate(pubmedArticle);
			String abstractOutput = abstractEvaluator.toString();
			String fullOutput = idOutput + meshOutput + abstractOutput;
			FileUtils.write(pmidFile, fullOutput, isAppending);
			if (!meshEvaluator.hasMeshHeadings()) {
				FileUtils.write(noMeshFile, fullOutput, isAppending);
			}
			if (!abstractEvaluator.hasAbstract()) {
				FileUtils.write(noAbstractFile, fullOutput, isAppending);
			}
		}
		reportUniqueIdNumber(fetchedPubMedIds);
		for (String searchedPmid : pubMedIds) {
			if (!fetchedPubMedIds.contains(searchedPmid)) {
				FileUtils.write(noFetchedFile, searchedPmid + "\n", isAppending);
			}
		}
	}

	private void establishSourcesAndSinks() {
		studyDirectory = new File(studyDirectoryPath);
		runDirectory = new File(studyDirectory, getRunDirectoryPath());
		pmcFile = new File(runDirectory, "pmc.csv");
		
		pmidFile = new File(runDirectory, "pmid.csv");
		noMeshFile = new File(runDirectory, "nomesh.csv");
		noFetchedFile = new File(runDirectory, "nofetched.txt");
		noAbstractFile = new File(runDirectory, "noabs.csv");
		runFile = new File(runDirectory, "pmidrun.txt");
		FileUtils.deleteQuietly(pmidFile);
		FileUtils.deleteQuietly(noMeshFile);
		FileUtils.deleteQuietly(noAbstractFile);
		FileUtils.deleteQuietly(noFetchedFile);
		FileUtils.deleteQuietly(runFile);
	}

	private String extractPmidFromLine(String line) {
		String pmid = "NA";
		Pattern pattern = Pattern.compile(",(\\d+),(\\d+),");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			pmid = matcher.group(2);
			break;
		}
		return pmid;
	}

	
	
	private void reportUniqueIdNumber(List<String> pubMedIds) {
		final HashSet<String> uniquePubMedIds = new HashSet<String>();
		uniquePubMedIds.addAll(pubMedIds);
		System.out.println("Number unique: " + uniquePubMedIds.size() + "\nNumber total: " + pubMedIds.size());
	}

	private void writeRuntimeStatistics() throws IOException {
		ElapsedTimeCalculator durationCalculator = new ElapsedTimeCalculator();
		durationCalculator.setStartDate(timeStart);
		durationCalculator.setStopDate(timeStop);
		durationCalculator.execute();
		FileUtils.write(runFile, "Runtime is " + durationCalculator + "\n", isAppending);
		FileUtils.write(runFile, " numberOfPmcs = " + numberOfPmcs + "\n", isAppending);
		FileUtils.write(runFile, " numberOfPmids = " + numberOfPmids + "\n", isAppending);
		FileUtils.write(runFile, " numberOfDois = " + numberOfDois + "\n", isAppending);
		FileUtils.write(runFile, " numberOfPiis = " + numberOfPiis + "\n", isAppending);
		FileUtils.write(runFile,
				" numberWithMesh = " + meshEvaluator.getNumberWithMesh() + "\n", isAppending);
		FileUtils.write(runFile,
				" numberWithNoMesh = " + meshEvaluator.getNumberWithNoMesh() + "\n",isAppending);
		FileUtils.write(
				runFile,
				" numberWithAbstracts = "
						+ abstractEvaluator.getNumberWithAbstracts() + "\n",isAppending);
		FileUtils.write(runFile, " numberWithStructuredAbstracts = "
				+ abstractEvaluator.getNumberWithStructuredAbstracts() + "\n",isAppending);
		FileUtils.write(runFile, " numberWithUnstructuredAbstracts = "
				+ abstractEvaluator.getNumberWithUnstructuredAbstracts() + "\n",isAppending);
	}

	
	private String formatTitleAndIds(PubmedArticle pubmedArticle) {
		String title = pubmedArticle.getArticleTitle().getTitle();
		title = title.replaceAll("\n", " ");
		ArticleIdList articleIdList = pubmedArticle.getArticleIdList();
		return String.format("%s%npmc=%s,pmid=%s,doi=%s,pii=%s%n", title,
				articleIdList.getPmc(), articleIdList.getPmid(),
				articleIdList.getDoi(), articleIdList.getPii());
	}

	private void tallyIds(PubmedArticle pubmedArticle) {
		ArticleIdList articleIdList = pubmedArticle.getArticleIdList();
		numberOfPmcs = (!articleIdList.getPmc().equals("NA")) ? numberOfPmcs + 1
				: numberOfPmcs;
		numberOfPmids = (!articleIdList.getPmid().equals("NA")) ? numberOfPmids + 1
				: numberOfPmids;
		numberOfDois = (!articleIdList.getDoi().equals("NA")) ? numberOfDois + 1
				: numberOfDois;
		numberOfPiis = (!articleIdList.getPii().equals("NA")) ? numberOfPiis + 1
				: numberOfPiis;
	}

	public String getRunDirectoryPath() {
		return runDirectoryPath;
	}

	public void setRunDirectoryPath(String runDirectoryPath) {
		this.runDirectoryPath = runDirectoryPath;
	}

}
