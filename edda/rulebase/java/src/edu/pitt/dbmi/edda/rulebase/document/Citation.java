package edu.pitt.dbmi.edda.rulebase.document;

import edu.pitt.dbmi.edda.rulebase.Identifiable;

public class Citation extends Identifiable {

	private static final long serialVersionUID = 1L;

	private Integer systematicReviewId;
	private String path;
	private String partition;
	private String authenticClassification;
	private String predictedClassification;
	private Integer weight;
	
	public void setSystematicReviewId(Integer systematicReviewId) {
		this.systematicReviewId = systematicReviewId;
	}
	public Integer getSystematicReviewId() {
		return systematicReviewId;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	public String getPartition() {
		return partition;
	}
	public void setPartition(String partition) {
		this.partition = partition;
	}
	public String getAuthenticClassification() {
		return authenticClassification;
	}
	public void setAuthenticClassification(String authenticClassification) {
		this.authenticClassification = authenticClassification;
	}
	public String getPredictedClassification() {
		return predictedClassification;
	}
	public void setPredictedClassification(String predictedClassification) {
		this.predictedClassification = predictedClassification;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
}
