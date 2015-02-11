package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pmc;

import java.util.ArrayList;
import java.util.HashMap;

public class ArticleMeta {

	private final HashMap<String, String> articleIdMap = new HashMap<String, String>();
	private final ArrayList<ArticleId> articleIdArray = new ArrayList<ArticleId>();
	private String articleTitle;
	
	public ArticleMeta() {
		setPmcId("NA");
		setPubmedId("NA");
		setDoiId("NA");
		setPublisherItemIdentifier("NA");
	}

	public void addArticleId(ArticleId articleId) {
		articleIdArray.add(articleId);
	}

	public void mapIds() {
		for (ArticleId articleId : articleIdArray) {
			articleIdMap.put(articleId.getPubIdType(), articleId.getPubId());
		}
	}

	public String getPmcId() {
		return articleIdMap.get("pmc");
	}

	public String getDoiId() {
		return articleIdMap.get("doi");
	}

	public String getPubmedId() {
		return articleIdMap.get("pmid");
	}

	public String getPublisherItemIdentifier() {
		return articleIdMap.get("pii");
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public void setPmcId(String pmc) {
		articleIdMap.put("pmc", pmc);
	}

	public void setDoiId(String doi) {
		articleIdMap.put("doi", doi);
	}

	public void setPubmedId(String pmid) {
		articleIdMap.put("pmid", pmid);
	}

	public void setPublisherItemIdentifier(String pii) {
		articleIdMap.put("pii", pii);
	}

}
