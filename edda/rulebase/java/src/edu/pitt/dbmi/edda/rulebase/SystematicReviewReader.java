package edu.pitt.dbmi.edda.rulebase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.pitt.dbmi.edda.rulebase.bagawords.BagOfWordsClassifier;
import edu.pitt.dbmi.edda.rulebase.document.Citation;
import edu.pitt.dbmi.edda.rulebase.document.SystematicReview;

public class SystematicReviewReader {

	private final String CONST_RESULTS_PATH = "C:\\Users\\kjm84\\Desktop\\Results.tsv";
	
	private final Experiment experiment = new Experiment();
	private final ReferenceFilerCacher referenceFilerCacher = new ReferenceFilerCacher();
	
	private final SystematicReview systematicReview = new SystematicReview();
	private final SystematicReviewCacher systematicReviewCache = new SystematicReviewCacher();

	private final BagOfWordsClassifier bagOfWordsClassifier = new BagOfWordsClassifier();
	
	private final List<Identifiable> workingMemoryDataQueue = new ArrayList<Identifiable>();
	private Iterator<Identifiable> workingMemoryDataQueueIterator;

	public static void main(String[] args) {
		SystematicReviewReader srReader = new SystematicReviewReader();
		srReader.pullSrAndCitations();
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

	public void pullSrAndCitations() {
		try {
			systematicReview.setDomain("Transplant");
			workingMemoryDataQueue.add(systematicReview);
			cacheReferenceFilerOutput();
			cachePicoResultsFile();
			workingMemoryDataQueue.add(bagOfWordsClassifier.getBagOfWordsEvidence());
			workingMemoryDataQueueIterator = workingMemoryDataQueue.iterator();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void analyzeExperiment() {
		for (Citation citation : referenceFilerCacher.getCitations()) {
			if (citation.getPartition().equals("test")) {
				experiment.tallyCitation(citation);
			}
		}
		System.out.println(experiment);
	}

	private void cacheReferenceFilerOutput() throws IOException {
		referenceFilerCacher.setSystematicReview(systematicReview);
		referenceFilerCacher.cache();
		workingMemoryDataQueue.addAll(referenceFilerCacher.getCitations());
	}
	
	private void cachePicoResultsFile() throws IOException {
		String resultsAsString = Utilities.readFileToString(CONST_RESULTS_PATH);
		String[] lines = resultsAsString.split("\n");
		boolean isHeader = true;
		for (String line : lines) {
			if (isHeader) {
				isHeader = false;
				continue;
			}
			String[] fields = line.split("\t");
			int fdx = 0;
			if (fields.length > 0) systematicReviewCache.setReportPath(fields[fdx++]);
			if (fields.length > 1) systematicReviewCache.setStudyDesign(fields[fdx++]);
			if (fields.length > 2) systematicReviewCache.setPublicationType(fields[fdx++]);
			if (fields.length > 3) systematicReviewCache.setInterventionComparator(fields[fdx++]);
			if (fields.length > 4) systematicReviewCache.setOutComePopulation(fields[fdx++]);
			systematicReviewCache.cache();
			System.out.println(systematicReviewCache);
			systematicReviewCache.reset();
		}
		workingMemoryDataQueue.add(systematicReviewCache.getCachedPublicationType());
		workingMemoryDataQueue.add(systematicReviewCache.getCachedStudyDesign());
		workingMemoryDataQueue.add(systematicReviewCache.getCachedOutcomePopulation());
		workingMemoryDataQueue.add(systematicReviewCache.getCachedInterventionComparator());
	}
	
	public void classifyCitation(Citation citation) {
		
		citation.cacheContent();
	
		bagOfWordsClassifier.getBagOfWordsEvidence().setCitationId(citation.getId());
		bagOfWordsClassifier.setCitation(citation);
		bagOfWordsClassifier.classify();
		
		systematicReviewCache.setCitation(citation);
		systematicReviewCache.classify();
		
		citation.setContent("NA");
	}

	public Identifiable nextIdentifiable() {
		return (workingMemoryDataQueueIterator.hasNext()) ? workingMemoryDataQueueIterator
				.next() : null;
	}
	
	public Experiment getExperiment() {
		return experiment;
	}
	
	public BagOfWordsClassifier getBagOfWordsClassifier() {
		return bagOfWordsClassifier;
	}

}
