package edu.pitt.dbmi.edda.rulebase;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.pitt.dbmi.edda.pico.PICOExtractor;
import edu.pitt.dbmi.edda.rulebase.document.Citation;
import edu.pitt.dbmi.edda.rulebase.document.SystematicReview;

public class ReferenceFilerCacher {
	
	public final String CONST_REF_FILER_TRAIN_PATH = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output\\5050_2xTitles\\TRAIN_data";
	public final String CONST_REF_FILER_TEST_PATH = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output\\5050_2xTitles\\TEST_data";
	private SystematicReview systematicReview;
	private PICOExtractor picoExtractor;
	private List<Citation> partitionIncludes = new ArrayList<Citation>();
	private List<Citation> partitionExcludes =  new ArrayList<Citation>();
	private final List<Citation> citations = new ArrayList<Citation>();
	private List<Citation> trainingIncludes = new ArrayList<Citation>();
	private List<Citation> trainingExcludes =  new ArrayList<Citation>();
	private List<Citation> testingIncludes = new ArrayList<Citation>();
	private List<Citation> testingExcludes = new ArrayList<Citation>();	
	private String dataPath = CONST_REF_FILER_TEST_PATH;
	private boolean isMultiFold = false;
	
	public void cache() {
		tryCache();
	}

	private void tryCache() {
		
		System.out.println("ReferenceFilerCacher begins caching...");
		
		Collection<File> files = gatherFiles(new File(dataPath));

		int numberCitationsProcessed = 0;
		for (File file : files) {
			classifyFile(file);
			if (numberCitationsProcessed % 100 == 0) {
				System.out.println("Determined actual classification for " + numberCitationsProcessed + " citations.");
			}
			numberCitationsProcessed++;
		}
		System.out.println("#include set size is " + partitionIncludes.size());
		System.out.println("#exclude set size is " + partitionExcludes.size());
		
		if (isMultiFold) {
			prepareMultiFoldRun();
		}
		else {
			prepareFullPassRun();
		}
		
		establishCitationPartitions();
		
		System.out.println("ReferenceFilerCacher finishes caching...");
	}
	
	private void prepareFullPassRun() {
		testingIncludes.addAll(partitionIncludes);
		testingExcludes.addAll(partitionExcludes);
	}

	private void classifyFile(File file) {
		try {
			Citation citation = new Citation();
			citation.setSystematicReviewId(systematicReview.getId());
			citation.setCitationKey(file.getName());
			citation.setPath(file.getAbsolutePath());
			citation.setPicoExtractor(picoExtractor);
			establishCitationActualClassification(file.getAbsolutePath(), citation);
			if (citation.getActualClassification().equals("include")) {
				partitionIncludes.add(citation);
			}
			else {
				partitionExcludes.add(citation);
			}
		}
		catch (Exception x) {
			x.printStackTrace();
		}	
	}
	
	private void prepareMultiFoldRun() {
		Random random = new Random(1024); // keep it the same for a while
		
		Double numIncs = Double.valueOf(partitionIncludes.size());
		int incFoldSize = (int) Math.ceil(numIncs.doubleValue() / 10.0d);
		Collections.shuffle(partitionIncludes, random);
		testingIncludes.addAll(partitionIncludes.subList(0, incFoldSize));
		trainingIncludes = partitionIncludes.subList(incFoldSize, partitionIncludes.size());
		
		Double numExcs = Double.valueOf(partitionExcludes.size());
		int excFoldSize = (int) Math.ceil(numExcs.doubleValue() / 10.0d);
		Collections.shuffle(partitionExcludes, random);
		testingExcludes.addAll(partitionExcludes.subList(0, excFoldSize));
		trainingExcludes = partitionExcludes.subList(excFoldSize, partitionExcludes.size());
	
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

	public void setPicoManager(PICOExtractor picoExtractor) {
		this.picoExtractor = picoExtractor;
	}

	public void setSystematicReview(SystematicReview systematicReview) {
		this.systematicReview = systematicReview;
	}

	public List<Citation> getTestingIncludes() {
		return testingIncludes;
	}

	public void setTestingIncludes(List<Citation> testingIncludes) {
		this.testingIncludes = testingIncludes;
	}

	public List<Citation> getTestingExcludes() {
		return testingExcludes;
	}

	public void setTestingExcludes(List<Citation> testingExcludes) {
		this.testingExcludes = testingExcludes;
	}
	
	public boolean isMultiFold() {
		return isMultiFold;
	}

	public void setMultiFold(boolean isMultiFold) {
		this.isMultiFold = isMultiFold;
	}

	public void useTrainingData() {
		dataPath = CONST_REF_FILER_TRAIN_PATH;
	}
	
	public void useTestingData() {
		dataPath = CONST_REF_FILER_TEST_PATH;
	}

	
}
