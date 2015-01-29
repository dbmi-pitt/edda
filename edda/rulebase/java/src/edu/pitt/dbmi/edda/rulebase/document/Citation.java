package edu.pitt.dbmi.edda.rulebase.document;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.pitt.dbmi.edda.pico.PICOExtractor;
import edu.pitt.dbmi.edda.rulebase.Identifiable;
import edu.pitt.dbmi.edda.rulebase.Utilities;
import edu.pitt.dbmi.edda.rulebase.pico.PicoEvidence;
import edu.pitt.dbmi.nlp.noble.terminology.TerminologyException;

public class Citation extends Identifiable {

	private static final long serialVersionUID = 1L;

	private Integer systematicReviewId = -1;
	private String citationKey;
	private String path = "NA";
	private String partition = "NA";
	private String actualClassification = "NA";
	private String predictedClassification = "NA";
	private Integer weight = 0;
	
	private PICOExtractor picoExtractor;

	private Collection<PicoEvidence> picoEvidence = new ArrayList<PicoEvidence>();
	private Iterator<PicoEvidence> picoEvidenceIterator;

	private transient String content;

	public Citation() {
		;
	}

	public void setSystematicReviewId(Integer systematicReviewId) {
		this.systematicReviewId = systematicReviewId;
	}

	public Integer getSystematicReviewId() {
		return systematicReviewId;
	}

	public void setCitationKey(String citationKey) {
		this.citationKey = citationKey;
	}

	public String getCitationKey() {
		return citationKey;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPartition(String partition) {
		this.partition = partition;
	}

	public String getPartition() {
		return partition;
	}

	public void setActualClassification(String actualClassification) {
		this.actualClassification = actualClassification;
	}

	public String getActualClassification() {
		return actualClassification;
	}

	public void setPredictedClassification(String predictedClassification) {
		this.predictedClassification = predictedClassification;
	}

	public String getPredictedClassification() {
		return predictedClassification;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setPicoEvidence(Map<String, List<String>> evidence) {
		picoEvidence.clear();
		if (evidence != null) {
			for (String picoCategory : evidence.keySet()) {
				List<String> terms = evidence.get(picoCategory);
				for (String picoTerm : terms) {
					PicoEvidence picoAtomicEvidence = new PicoEvidence();
					picoAtomicEvidence.setCitationId(getId());
					picoAtomicEvidence.setPicoCategory(picoCategory);
					picoAtomicEvidence.setPicoTerm(picoTerm.toLowerCase());
					picoAtomicEvidence.setPolarity("present");
					picoAtomicEvidence.setWeight(1);
//					System.out.println("Adding PicoAtomicEvidence:\n" + picoAtomicEvidence.toString());
					picoEvidence.add(picoAtomicEvidence);
				}
			}
		}
	}

	public Collection<PicoEvidence> getPicoEvidence() {
		return picoEvidence;
	}
	
	private void extractPicoEvidence() {
		try {
			String citationContent = getContent();
			Map<String, List<String>> evidence = picoExtractor.processDocument(citationContent);
			if (evidence == null || evidence.size() == 0) {
				System.err.println("No evidence found for citation " + getCitationKey());
			}
			else {
				setPicoEvidence(evidence);
			}
			setContent("NA");	
		} catch (TerminologyException e) {
			e.printStackTrace();
		}
		
	}

	public void iterateEvidence() {
		if (picoEvidence.isEmpty()) {
			extractPicoEvidence();
		}
		picoEvidenceIterator = picoEvidence.iterator();
	}

	public PicoEvidence nextPicoEvidence() {
		return picoEvidenceIterator.hasNext() ? picoEvidenceIterator.next()
				: null;
	}

	public void cacheContent() {
		File file = new File(getPath());
		String filePath = file.getAbsolutePath();
		String content = Utilities.readFileToString(filePath);
		setContent(content);
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		if (content == null || content.equals("NA")) {
			cacheContent();
		}
		return content;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Citation\n ");
		sb.append("\tid: " + getId() + "\n");
		sb.append("\tcitationKey: " + getCitationKey() + "\n");
		sb.append("\tpartition: " + getPartition() + "\n");
		sb.append("\tactualClassification " + getActualClassification() + "\n");
		sb.append("\tpredictedClassification " + getPredictedClassification()
				+ "\n");
		return sb.toString();
	}

	public void setPicoExtractor(PICOExtractor picoExtractor) {
		this.picoExtractor = picoExtractor;
	}

	public PICOExtractor getPicoExtractor() {
		return picoExtractor;
	}

}
