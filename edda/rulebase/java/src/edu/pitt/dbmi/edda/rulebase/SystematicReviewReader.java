package edu.pitt.dbmi.edda.rulebase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import edu.pitt.dbmi.edda.rulebase.document.Citation;
import edu.pitt.dbmi.edda.rulebase.document.SystematicReview;
import edu.pitt.dbmi.edda.rulebase.document.Word;

public class SystematicReviewReader {

	private final String CONST_REF_FILER_PATH = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output";
	private final String CONST_RESULTS_PATH = "C:\\Users\\kjm84\\Desktop\\Results.csv";

	private final SystematicReview systematicReview = new SystematicReview();
	private final List<Citation> citations = new ArrayList<Citation>();
	private final HashMap<String, Word> alphabet = new HashMap<String, Word>();

	private final List<Identifiable> workingMemoryDataQueue = new ArrayList<Identifiable>();
	private Iterator<Identifiable> workingMemoryDataQueueIterator;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SystematicReviewReader srReader = new SystematicReviewReader();
		srReader.execute();
		while (true) {
			Identifiable identifiable = srReader.nextIdentifiable();
			if (identifiable == null) {
				break;
			}
			System.out.println(identifiable);
		}
	}

	public SystematicReviewReader() {
	}

	public void execute() {
		systematicReview.setDomain("TRANSPLANT");
		cacheReferenceFilerOutput();
		// cachePicoResultsFile();
	}

	private void cacheReferenceFilerOutput() {
		Collection<File> files = gatherFiles(new File(CONST_REF_FILER_PATH));
		Citation citation = null;
		for (File file : files) {
			String absolutePath = file.getAbsolutePath();
			if (absolutePath.contains("FULL")) {
				citation = new Citation();
				citation.setSystematicReviewId(systematicReview.getId());
				citation.setPath(absolutePath);
				citations.add(citation);
				if (absolutePath.contains("_train")) {
					citation.setPartition("A");
				} else if (absolutePath.contains("_test")) {
					citation.setPartition("B");
				}
				if (absolutePath.contains("_N_")) {
					citation.setAuthenticClassification("exclude");
				} else if (absolutePath.contains("_Y_")) {
					citation.setAuthenticClassification("include");
				}
			}
		}

		workingMemoryDataQueue.add(systematicReview);
		workingMemoryDataQueue.addAll(citations);
		workingMemoryDataQueueIterator = workingMemoryDataQueue.iterator();
		citations.clear();
	}

	private List<File> gatherFiles(File f) {
		System.out.println("gatherFiles: " + f.getAbsolutePath());
		final List<File> files = new ArrayList<File>();
		if (f.isDirectory()) {
			String[] filenames = f.list();
			for (String filename : filenames) {
				if (!filename.matches("^T[AI]_[YN].*$")) {
					files.addAll(gatherFiles(new File(f, filename)));
				}
			}
		} else if (f.isFile() && f.getAbsolutePath().contains("FULL")
				&& f.getAbsolutePath().endsWith(".txt")) {
			files.add(f);
		}
		return files;
	}

	public Identifiable nextIdentifiable() {
		return (workingMemoryDataQueueIterator.hasNext()) ? workingMemoryDataQueueIterator
				.next() : null;
	}

	private void cachePicoResultsFile() throws IOException {
		String resultsAsString = readFileToString(CONST_RESULTS_PATH);
		String[] lines = resultsAsString.split("\n");
		boolean isHeader = true;
		for (String line : lines) {
			if (isHeader) {
				isHeader = false;
				continue;
			}
			SystematicReviewCache result = new SystematicReviewCache();
			String[] fields = line.split("\t");
			int fdx = 0;
			result.setReportPath(fields[fdx++]);
			result.setStudyDesign(fields[fdx++]);
			result.setPublicationType(fields[fdx++]);
			result.setOutComePopulation(fields[fdx++]);
			result.setInterventionComparator(fields[fdx++]);
			result.cache();
			System.out.println(result);
		}
	}

	private String readFileToString(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		return stringBuilder.toString();
	}

}
