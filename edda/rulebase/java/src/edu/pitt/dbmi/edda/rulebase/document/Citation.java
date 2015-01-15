package edu.pitt.dbmi.edda.rulebase.document;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.pitt.dbmi.edda.rulebase.Identifiable;
import edu.pitt.dbmi.edda.rulebase.Utilities;
import edu.pitt.dbmi.edda.rulebase.pico.PicoEvidence;

public class Citation extends Identifiable {

	private static final long serialVersionUID = 1L;

	private Integer systematicReviewId = -1;
	private String citationKey;
	private String path = "NA";
	private String partition = "NA";
	private String actualClassification = "NA";
	private String predictedClassification = "NA";
	private Integer weight = 0;
	
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
	
	public void setPicoEvidence(Collection<PicoEvidence> picoEvidence) {
		this.picoEvidence.clear();
		if (picoEvidence != null) {
			this.picoEvidence.addAll(picoEvidence);
		}
	}

	public Collection<PicoEvidence> getPicoEvidence() {
		return picoEvidence;
	}
	
	public void iterateEvidence() {
		picoEvidenceIterator = picoEvidence.iterator();
	}
	
	public PicoEvidence nextPicoEvidence() {
		return picoEvidenceIterator.hasNext() ?
				picoEvidenceIterator.next()
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
		sb.append("\tactualClassification " + getActualClassification()
				+ "\n");
		sb.append("\tpredictedClassification " + getPredictedClassification()
				+ "\n");
		return sb.toString();
	}

}
