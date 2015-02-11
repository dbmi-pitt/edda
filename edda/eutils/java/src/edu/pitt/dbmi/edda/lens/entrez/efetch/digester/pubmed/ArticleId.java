package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ArticleId {
	
//	   <ArticleId IdType="doi">10.1097/01.bor.0000434671.77891.9a</ArticleId>
//     <ArticleId IdType="pii">00002281-201311000-00015</ArticleId>
//     <ArticleId IdType="pubmed">24067381</ArticleId>
//     <ArticleId IdType="pmc">PMC4196838</ArticleId>
	
	private String idType;
	private String content;
	
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
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
