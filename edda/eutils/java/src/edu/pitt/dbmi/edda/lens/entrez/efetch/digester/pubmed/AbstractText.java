package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AbstractText {
	
	private String label = "PURPOSE OF REVIEW";
	private String nlmCategory = "OBJECTIVE";
	private String content;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getNlmCategory() {
		return nlmCategory;
	}
	public void setNlmCategory(String nlmCategory) {
		this.nlmCategory = nlmCategory;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
