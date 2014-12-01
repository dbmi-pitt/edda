package edu.pitt.dbmi.edda.rulebase.document;

public class WordOccurence {

	private Integer containerId;
	private Integer wordId;
	private Integer frequency;
	
	public Integer getContainerId() {
		return containerId;
	}
	public void setContainerId(Integer containerId) {
		this.containerId = containerId;
	}
	public Integer getWordId() {
		return wordId;
	}
	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
}
