package edu.pitt.dbmi.edda.rulebase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.edda.pico.PICOExtractor;
import edu.pitt.dbmi.edda.rulebase.document.Citation;
import edu.pitt.dbmi.edda.rulebase.document.SystematicReview;
import edu.pitt.dbmi.edda.rulebase.pico.PicoEvidence;

public class SystematicReviewReader {

	private final Experiment experiment = new Experiment();
	private final ReferenceFilerCacher referenceFilerCacher = new ReferenceFilerCacher();
	
	private final SystematicReview systematicReview = new SystematicReview();

	private final List<Identifiable> workingMemoryDataQueue = new ArrayList<Identifiable>();
	private Iterator<Identifiable> workingMemoryDataQueueIterator;

	private final MentionEvidence mpaEvidence = new MentionEvidence();
	
	private PICOExtractor picoManager = null;
	
	public static void main(String[] args) {
		SystematicReviewReader srReader = new SystematicReviewReader();
		srReader.pullSrAndCitations();
		while (true) {
			Identifiable identifiable = srReader.nextIdentifiable();
			if (identifiable == null) {
				break;
			}
			else if (identifiable instanceof Citation) {
				Citation citation = (Citation) identifiable;
				if (citation.getCitationKey().equals("TRANSPLANT10001_FULL.txt")) {
					String citationKey = citation.getCitationKey();
					System.out.println(citationKey);
					citation.iterateEvidence();
					PicoEvidence evidence = citation.nextPicoEvidence();
					while (evidence != null) {
						
							System.out.println(evidence);
										
						evidence = citation.nextPicoEvidence();
					}
				}
			}	
		}
	}

	public SystematicReviewReader() {
	}

	public void pullSrAndCitations() {
		try {
			systematicReview.setDomain("Transplant");
			workingMemoryDataQueue.add(systematicReview);
			cachePicoResultsFile();
			cacheReferenceFilerOutput();
			
//			workingMemoryDataQueue.add(bagOfWordsClassifier);
//			workingMemoryDataQueue.add(mpaEvidence);
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
		referenceFilerCacher.setPicoManager(picoManager);
		referenceFilerCacher.useTrainingData();
//		referenceFilerCacher.useTestingData();
		referenceFilerCacher.cache();
		workingMemoryDataQueue.addAll(referenceFilerCacher.getTestingIncludes());
		workingMemoryDataQueue.addAll(referenceFilerCacher.getTestingExcludes());
	}
	
	private void cachePicoResultsFile() throws IOException {
//		File dataDirectory = new File("C:\\Users\\kjm84\\git\\edda\\edda\\pico\\data");
		File dataDirectory = new File("C:\\Users\\kjm84\\git\\edda\\edda\\pico\\data");
		File templateFile = new File(dataDirectory,"OrganTransplant.template");
		try {
			picoManager = new PICOExtractor(templateFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findMphEvidence(Citation citation) {
		
		mpaEvidence.setMention("mpa");
		mpaEvidence.setCitationId(citation.getId());
	
		StringBuilder sb = new StringBuilder();
		sb.append("Acide mycophenolique|");
		sb.append("Acido micofenolico|");
		sb.append("Lilly-68618|");
		sb.append("Ly 68618|");
		sb.append("MPA|");
		sb.append("Acidum mycophenolicum|");
		sb.append("Mycophenolic Acid|");
		sb.append("Myfortic|");
		sb.append("mycophenolate");
		
		int patternParams = Pattern.CASE_INSENSITIVE;
		patternParams |= Pattern.DOTALL;
		patternParams |= Pattern.MULTILINE;
		Pattern p = Pattern.compile(sb.toString(), patternParams);
		
		Matcher matcher = p.matcher(citation.getContent());
		int weight = 0;
		while (matcher.find()) {
			weight++;
		}
		mpaEvidence.setWeight(weight);
		if (weight > 0) {
			mpaEvidence.setPolarity("present");
		}
		else {
			mpaEvidence.setPolarity("absent");
		}
	}

	public Identifiable nextIdentifiable() {
		return (workingMemoryDataQueueIterator.hasNext()) ? workingMemoryDataQueueIterator
				.next() : null;
	}
	
	public Experiment getExperiment() {
		return experiment;
	}

	public SystematicReview getSystematicReview() {
		return systematicReview;
	}

	public PICOExtractor getPicoManager() {
		return picoManager;
	}

}
