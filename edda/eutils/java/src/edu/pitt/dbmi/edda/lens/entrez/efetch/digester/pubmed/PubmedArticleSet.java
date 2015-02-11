package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class PubmedArticleSet {
	
	private final Collection<PubmedArticle> pubmedArticles = new ArrayList<PubmedArticle>();
	
	public PubmedArticleSet() {
	}
	
	public Collection<PubmedArticle> getPubmedArticles() {
		return pubmedArticles;
	}
	
	public void addPubmedArticle(PubmedArticle pubmedArticle) {
		pubmedArticles.add(pubmedArticle);
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
