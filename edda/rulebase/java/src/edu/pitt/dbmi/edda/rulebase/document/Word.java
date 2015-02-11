package edu.pitt.dbmi.edda.rulebase.document;

import edu.pitt.dbmi.edda.rulebase.Identifiable;

public class Word extends Identifiable {

	private static final long serialVersionUID = 1L;
	
	private String text;
	private Integer frequencyApartitionInclude = 0;
	private Integer frequencyApartitionExclude = 0;
	private Integer frequencyBpartitionInclude = 0;
	private Integer frequencyBpartitionExclude = 0;
	private Integer frequencyApartition = 0;
	private Integer frequencyBpartition = 0;
	private Integer frequency = 0;
	private Integer rank = 0;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getFrequencyApartitionInclude() {
		return frequencyApartitionInclude;
	}
	public void setFrequencyApartitionInclude(Integer frequencyApartitionInclude) {
		this.frequencyApartitionInclude = frequencyApartitionInclude;
	}
	public Integer getFrequencyApartitionExclude() {
		return frequencyApartitionExclude;
	}
	public void setFrequencyApartitionExclude(Integer frequencyApartitionExclude) {
		this.frequencyApartitionExclude = frequencyApartitionExclude;
	}
	public Integer getFrequencyBpartitionInclude() {
		return frequencyBpartitionInclude;
	}
	public void setFrequencyBpartitionInclude(Integer frequencyBpartitionInclude) {
		this.frequencyBpartitionInclude = frequencyBpartitionInclude;
	}
	public Integer getFrequencyBpartitionExclude() {
		return frequencyBpartitionExclude;
	}
	public void setFrequencyBpartitionExclude(Integer frequencyBpartitionExclude) {
		this.frequencyBpartitionExclude = frequencyBpartitionExclude;
	}
	public Integer getFrequencyApartition() {
		return frequencyApartition;
	}
	public void setFrequencyApartition(Integer frequencyApartition) {
		this.frequencyApartition = frequencyApartition;
	}
	public Integer getFrequencyBpartition() {
		return frequencyBpartition;
	}
	public void setFrequencyBpartition(Integer frequencyBpartition) {
		this.frequencyBpartition = frequencyBpartition;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getRank() {
		return rank;
	}

	
}
