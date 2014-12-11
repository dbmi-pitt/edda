package edu.pitt.dbmi.edda.rulebase;

public class ClassificationEvidence extends Identifiable {

	private static final long serialVersionUID = 1L;
	
	/*
	 * At this point we are considering the preponderance of 
	 * positive evidence for the positive (include) state
	 */
	protected Integer citationId = 0;
	protected Integer category = 0;
	protected Integer weight = 0;
	
	public Integer getCitationId() {
		return citationId;
	}
	public void setCitationId(Integer citationId) {
		this.citationId = citationId;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public void reset() {
		citationId = 0;
		category = 0;
		weight = 0;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("citation id = " + getCitationId() + "\n");
		sb.append("category = " + getCategory() + "\n");
		sb.append("weight = " + getWeight() + "\n");
		return sb.toString();
	}
}
