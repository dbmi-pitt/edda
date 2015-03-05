package edu.pitt.dbmi.edda.rulebase.pico;

import edu.pitt.dbmi.edda.rulebase.ClassificationEvidence;

public class PicoEvidence extends ClassificationEvidence {

	private static final long serialVersionUID = 1L;

	protected String picoCategory;
	protected String picoTerm;
	protected int ancestryDepth = 0;
	
	public PicoEvidence() {
	}
	
	public String getPicoCategory() {
		return picoCategory;
	}

	public void setPicoCategory(String picoCategory) {
		this.picoCategory = picoCategory;
	}

	public String getPicoTerm() {
		return picoTerm;
	}

	public void setPicoTerm(String picoTerm) {
		this.picoTerm = picoTerm;
	}
	
	public int getAncestryDepth() {
		return ancestryDepth;
	}

	public void setAncestryDepth(int ancestryDepth) {
		this.ancestryDepth = ancestryDepth;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("citation id = " + getCitationId() + "\n");
		sb.append("citationKey = " + getCitationKey() + "\n");
		sb.append("picoCategory = " + getPicoCategory() + "\n");
		sb.append("picoPicoTerm = " + getPicoTerm() + "\n");
		sb.append("polarity = " + getPolarity() + "\n");
		sb.append("ancestryDepth = " + getAncestryDepth() + "\n");
		sb.append("weight = " + getWeight() + "\n");
		return sb.toString();
	}

}
