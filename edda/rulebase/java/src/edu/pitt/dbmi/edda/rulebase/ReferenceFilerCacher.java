package edu.pitt.dbmi.edda.rulebase;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.pitt.dbmi.edda.rulebase.document.Citation;
import edu.pitt.dbmi.edda.rulebase.document.SystematicReview;
import edu.pitt.dbmi.edda.rulebase.pico.PicoEvidence;
import edu.pitt.dbmi.edda.rulebase.pico.PicoManager;

public class ReferenceFilerCacher {
	
	private final String CONST_REF_FILER_PATH = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output\\5050_2xTitles\\TRAIN_data";
//	private final String CONST_REF_FILER_PATH = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output";
	private SystematicReview systematicReview;
	private PicoManager picoManager;
	private final List<Citation> citations = new ArrayList<Citation>();
	private List<Citation> trainingIncludes = new ArrayList<Citation>();
	private List<Citation> trainingExcludes =  new ArrayList<Citation>();
	private List<Citation> testingIncludes = new ArrayList<Citation>();
	private List<Citation> testingExcludes = new ArrayList<Citation>();
	
	public void cache() {
		tryCache();
	}

	private void tryCache() {
		
		System.out.println("ReferenceFilerCacher begins caching...");
		
		Collection<File> files = gatherFiles(new File(CONST_REF_FILER_PATH));

	
		for (File file : files) {
			processFile(file);
		}
		System.out.println("#include set size is " + trainingIncludes.size());
		System.out.println("#exclude set size is " + trainingExcludes.size());
		
		Random random = new Random(1024); // keep it the same for a while
	
		Double numIncs = Double.valueOf(trainingIncludes.size());
		int incFoldSize = (int) Math.ceil(numIncs.doubleValue() / 10.0d);
		Collections.shuffle(trainingIncludes, random);
		testingIncludes.addAll(trainingIncludes.subList(0, incFoldSize));
		trainingIncludes = trainingIncludes.subList(incFoldSize, trainingIncludes.size());
		
		Double numExcs = Double.valueOf(trainingExcludes.size());
		int excFoldSize = (int) Math.ceil(numExcs.doubleValue() / 10.0d);
		Collections.shuffle(trainingExcludes, random);
		testingExcludes.addAll(trainingExcludes.subList(0, excFoldSize));
		trainingExcludes = trainingExcludes.subList(excFoldSize, trainingExcludes.size());
	
		establishCitationPartitions();
		
		System.out.println("ReferenceFilerCacher finishes caching...");
	}
	
	private void processFile(File file) {
		try {
			Citation citation = new Citation();
			citation.setSystematicReviewId(systematicReview.getId());
			citation.setCitationKey(file.getName());
			citation.setPath(file.getAbsolutePath());
			String citationKey = citation.getCitationKey();
			Collection<PicoEvidence> evidence = picoManager.reportEvidence(citationKey);
			if (evidence == null || evidence.size() == 0) {
				System.err.println("No evidence found for citation " + citation.getCitationKey());
			}
			else {
				citation.setPicoEvidence(evidence);
			}
			
			establishCitationActualClassification(file.getAbsolutePath(), citation);
			if (citation.getActualClassification().equals("include")) {
				trainingIncludes.add(citation);
			}
			else {
				trainingExcludes.add(citation);
			}
		}
		catch (Exception x) {
			x.printStackTrace();
		}

		
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
	
	private void establishCitationActualClassification(String absolutePath,
			Citation citation) {
		if (absolutePath.contains("_N_")) {
			citation.setActualClassification("exclude");
		} else if (absolutePath.contains("_Y_")) {
			citation.setActualClassification("include");
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

	public void setPicoManager(PicoManager picoManager) {
		this.picoManager = picoManager;
	}

	public void setSystematicReview(SystematicReview systematicReview) {
		this.systematicReview = systematicReview;
	}

	
}
