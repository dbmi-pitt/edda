package edu.pitt.dbmi.edda.rulebase.document;

import java.io.File;

import edu.pitt.dbmi.edda.rulebase.Identifiable;
import edu.pitt.dbmi.edda.rulebase.Utilities;

public class Citation extends Identifiable {

	private static final long serialVersionUID = 1L;

	private Integer systematicReviewId;
	private String path;
	private String partition;
	private String authenticClassification;
	private String predictedClassification;
	private Integer weight;

	private transient String content;
	
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

	public void cacheContent() {
		File file = new File(getPath());
		String filePath = file.getAbsolutePath();
		String content = Utilities.readFileToString(filePath);
		setContent(content);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Calling gatherWordOccurences for citation\n ");
		sb.append("  partition " + getPartition() + "\n");
		sb.append("  authenticClassification " + getAuthenticClassification()
				+ "\n");
		return sb.toString();
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

}
