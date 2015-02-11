package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class PubmedArticle {
	
	private String pmid;
	private ArticleTitle articleTitle;
	private Abstract articleAbstract;
	private ElectronicLocationId electronicLocationId;
	private String language;
	private MeshHeadingList meshHeadingList;
	private ArticleIdList articleIdList;
	
	public String getPmid() {
		return pmid;
	}
	public void setPmid(String pmid) {
		this.pmid = pmid;
	}
	public ArticleTitle getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(ArticleTitle articleTitle) {
		this.articleTitle = articleTitle;
	}
	public Abstract getArticleAbstract() {
		return articleAbstract;
	}
	public void setArticleAbstract(Abstract articleAbstract) {
		this.articleAbstract = articleAbstract;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public MeshHeadingList getMeshHeadingList() {
		return meshHeadingList;
	}
	public void setMeshHeadingList(MeshHeadingList meshHeadingList) {
		this.meshHeadingList = meshHeadingList;
	}
	public ArticleIdList getArticleIdList() {
		return articleIdList;
	}
	public void setArticleIdList(ArticleIdList articleIdList) {
		this.articleIdList = articleIdList;
	}
	public ElectronicLocationId getElectronicLocationId() {
		return electronicLocationId;
	}
	public void setElectronicLocationId(ElectronicLocationId electronicLocationId) {
		this.electronicLocationId = electronicLocationId;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
