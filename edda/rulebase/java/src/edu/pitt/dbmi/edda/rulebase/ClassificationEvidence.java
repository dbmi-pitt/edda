package edu.pitt.dbmi.edda.rulebase;

import edu.pitt.dbmi.edda.rulebase.document.Citation;

public class ClassificationEvidence extends Identifiable {

	private static final long serialVersionUID = 1L;
	
	/*
	 * At this point we are considering the preponderance of 
	 * positive evidence for the positive (include) state
	 */
	protected Integer citationId = 0;
	protected String citationKey = null;
	protected String polarity = "absent";
	protected Integer weight = 0;
	protected Citation citation;
	
	public Integer getCitationId() {
		return citationId;
	}
	public void setCitationId(Integer citationId) {
		this.citationId = citationId;
	}
	public String getCitationKey() {
		return citationKey;
	}
	public void setCitationKey(String citationKey) {
		this.citationKey = citationKey;
	}
	public String getPolarity() {
		return polarity;
	}
	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public void scoreWithCitation(Citation citation) {
		this.citation = citation;
		citationId = citation.getId();
	}
	public void reset() {
		citationId = 0;
		polarity = "absent";
		weight = 0;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("citation id = " + getCitationId() + "\n");
		sb.append("citation key = " + getCitationKey() + "\n");
		sb.append("polarity = " + getPolarity() + "\n");
		sb.append("weight = " + getWeight() + "\n");
		return sb.toString();
	}
}
