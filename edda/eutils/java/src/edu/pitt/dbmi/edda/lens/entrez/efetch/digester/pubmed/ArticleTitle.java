package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ArticleTitle {
	
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	

}
