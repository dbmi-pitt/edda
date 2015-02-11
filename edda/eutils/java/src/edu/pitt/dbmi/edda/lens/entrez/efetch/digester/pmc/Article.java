package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pmc;

public class Article {
	
	private ArticleMeta articleMeta;

	public ArticleMeta getArticleMeta() {
		return articleMeta;
	}

	public void setArticleMeta(ArticleMeta articleMeta) {
		articleMeta.mapIds();
		this.articleMeta = articleMeta;
	}

}
