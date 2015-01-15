package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ArticleIdList {
	
	private Collection<ArticleId> articleIds = new ArrayList<ArticleId>();

	public Collection<ArticleId> getArticleIds() {
		return articleIds;
	}

	public void addArticleId(ArticleId articleId) {
		articleIds.add(articleId);
	}
	
	public String getPmc() {
		return getIdByName("pmc");
	}

	public String getPmid() {
		return getIdByName("pubmed");
	}
	
	public String getDoi() {
		return getIdByName("doi");
	}
	
	public String getPii() {
		return getIdByName("ppi");
	}
	
	public String getIdByName(String idName) {
		String id = "NA";
		for (ArticleId articleId : articleIds) {
			if (articleId.getIdType() != null && articleId.getIdType().equals(idName)) {
				id = articleId.getContent();
			}
		}
		return id;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
