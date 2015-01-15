package edu.pitt.dbmi.edda.lens.entrez;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import edu.pitt.dbmi.edda.lens.entrez.efetch.EntrezEfetchPmcAgent;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.idlist.Id;
import edu.pitt.dbmi.edda.lens.entrez.esearch.EntrezEsearchAgent;

public class PmcIdSearcher {

	private String studyDirectoryPath = "C:\\Users\\kjm84\\Desktop\\tanja_eutils_studies";

	private File studyDirectory;
	private File runDirectory;
	private File outFile;
	private File logFile;
	private File errFile;

	private Date timeStart;
	private Date timeStop;

	private int returnBatchSize = 5000;
	private boolean isAppending = true;

	public static void main(String[] args) {
		PmcIdSearcher pmcSearcher = new PmcIdSearcher();
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

		int expectedNumberOfRecords = Integer.valueOf(eSearchAgent
				.getEsearchResult().getCount());
		FileUtils.write(logFile, "Expecting " + expectedNumberOfRecords + "\n",
				isAppending);
		System.out.println("Expecting " + expectedNumberOfRecords);

		System.out.println(eSearchAgent.getEsearchResult().getQueryKey());
		System.out.println(eSearchAgent.getEsearchResult().getWebEnv());

		EntrezEfetchPmcAgent eFetchAgent = new EntrezEfetchPmcAgent();

		eFetchAgent.setDatabase("pmc");
		eFetchAgent.setHttpSearcher(new HttpSearcher());
		eFetchAgent.setQueryKey(eSearchAgent.getEsearchResult().getQueryKey());
		eFetchAgent.setRetMax(returnBatchSize + "");
		eFetchAgent.setRetMode("xml");
		eFetchAgent.setRetStart("0");
		eFetchAgent.setRetType("uilist");
		eFetchAgent.setWebEnv(eSearchAgent.getEsearchResult().getWebEnv());

		final List<Id> allPmids = new ArrayList<Id>();
		final List<Id> iterationPmids = new ArrayList<Id>();
		do {
			int goalBoundary = new Integer(eFetchAgent.getRetStart()).intValue() + returnBatchSize;
			System.out.println("Searching between " + eFetchAgent.getRetStart() + " and " + goalBoundary);
			iterationPmids.clear();
			eFetchAgent.execute();
			iterationPmids.addAll(eFetchAgent.getIds());
			allPmids.addAll(eFetchAgent.getIds());
			eFetchAgent.setRetStart(allPmids.size()+"");
		} while (allPmids.size() < expectedNumberOfRecords && !iterationPmids.isEmpty());

		reportPmids(allPmids);

		timeStop = new Date();
		ElapsedTimeCalculator durationCalculator = new ElapsedTimeCalculator();
		durationCalculator.setStartDate(timeStart);
		durationCalculator.setStopDate(timeStop);
		durationCalculator.execute();
		FileUtils.write(logFile, "Runtime is " + durationCalculator + "\n",
				isAppending);
		FileUtils.write(errFile, "No errors reported.");
	}

	private void reportPmids(List<Id> allPmids) throws IOException {
		FileOutputStream fos = new FileOutputStream(outFile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		for (Id pmid : allPmids) {
			String pmidOutput = String.format("%s%n", pmid);
			bos.write(pmidOutput.getBytes());
		}
		bos.close();
	}

	private void establishSourcesAndSinks() {
		studyDirectory = new File(studyDirectoryPath);
		runDirectory = new File(studyDirectory, stringifyDate(timeStart));
		runDirectory.mkdir();
		outFile = new File(runDirectory, "pmc_id_out.csv");
		errFile = new File(runDirectory, "pmc_id_err.csv");
		logFile = new File(runDirectory, "pmc_id_log.txt");
	}

	private String stringifyDate(Date srcDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(srcDate);
	}

}
