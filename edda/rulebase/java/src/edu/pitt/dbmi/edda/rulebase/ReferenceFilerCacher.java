package edu.pitt.dbmi.edda.rulebase;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.pitt.dbmi.edda.rulebase.document.Citation;
import edu.pitt.dbmi.edda.rulebase.document.SystematicReview;

public class ReferenceFilerCacher {
	
	private final String CONST_REF_FILER_PATH = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output";
	private SystematicReview systematicReview;
	private final List<Citation> citations = new ArrayList<Citation>();
	private List<Citation> trainingIncludes = new ArrayList<Citation>();
	private List<Citation> trainingExcludes =  new ArrayList<Citation>();
	private List<Citation> testingIncludes = new ArrayList<Citation>();
	private List<Citation> testingExcludes = new ArrayList<Citation>();
	
	
	public void cache() {
		tryCache();
	}

	private void tryCache() {
		
		Collection<File> files = gatherFiles(new File(CONST_REF_FILER_PATH));
		Citation citation = null;
	
		for (File file : files) {
			citation = new Citation();
			citation.setSystematicReviewId(systematicReview.getId());
			citation.setPath(file.getAbsolutePath());
			establishCitationAuthenticClassification(file.getAbsolutePath(), citation);
			if (citation.getAuthenticClassification().equals("include")) {
				trainingIncludes.add(citation);
			}
			else {
				trainingExcludes.add(citation);
			}
		}
		
		Random random = new Random(1024); // keep it the same for a while
	
		Double numIncs = Double.valueOf(trainingIncludes.size());
		int incFoldSize = (int) Math.ceil(numIncs.doubleValue());
		Collections.shuffle(trainingIncludes, random);
		testingIncludes.addAll(trainingIncludes.subList(0, incFoldSize));
		trainingIncludes = trainingIncludes.subList(incFoldSize, trainingIncludes.size());
		
		Double numExcs = Double.valueOf(trainingExcludes.size());
		int excFoldSize = (int) Math.ceil(numExcs.doubleValue());
		Collections.shuffle(trainingExcludes, random);
		testingExcludes.addAll(trainingExcludes.subList(0, excFoldSize));
		trainingExcludes = trainingExcludes.subList(excFoldSize, trainingExcludes.size());
	
		establishCitationPartitions();
	}
	
	private void establishCitationPartitions() {
		for (Citation citation : this.trainingIncludes) {
			citation.setPartition("train");
			citations.add(citation);
		}
		for (Citation citation : this.trainingExcludes) {
			citation.setPartition("train");
			citations.add(citation);
		}
		for (Citation citation : this.testingIncludes) {
			citation.setPartition("test");
			citations.add(citation);
		}
		for (Citation citation : this.testingExcludes) {
			citation.setPartition("test");
			citations.add(citation);
		}
	}
	
	@SuppressWarnings("unused")
	private void establishCitationPartition(String absolutePath,
			Citation citation) {
		if (absolutePath.contains("_train")) {
			citation.setPartition("train");
		} else if (absolutePath.contains("_test")) {
			citation.setPartition("test");
		}
	}
	
	private void establishCitationAuthenticClassification(String absolutePath,
			Citation citation) {
		if (absolutePath.contains("_N_")) {
			citation.setAuthenticClassification("exclude");
		} else if (absolutePath.contains("_Y_")) {
			citation.setAuthenticClassification("include");
		}
	}
	
	private List<File> gatherFiles(File f) {
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
	
	public List<Citation> getCitations() {
		return citations;
	}

	public void setSystematicReview(SystematicReview systematicReview) {
		this.systematicReview = systematicReview;
	}

	
}
