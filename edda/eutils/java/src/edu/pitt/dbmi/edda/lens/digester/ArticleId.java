package edu.pitt.dbmi.edda.lens.digester;

public class ArticleId {
	
	
	private String value;

	public String fetchValue() {
		return value;
	}

	public void injectValue(String value) {
		this.value = value;
	}
	
	private String articleIdType;

	public String getArticleIdType() {
		return articleIdType;
	}

	public void setArticleIdType(String articleIdType) {
		this.articleIdType = articleIdType;
	}


	public String toString() {
		return getArticleIdType() + ":" + fetchValue();
	}


}
