package edu.pitt.dbmi.edda.rulebase.document;

import edu.pitt.dbmi.edda.rulebase.Identifiable;

public class Word extends Identifiable {

	private static final long serialVersionUID = 1L;
	
	private String text;
	private Integer weight;

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
