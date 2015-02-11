package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pmc;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ArticleId {
	
	private String pubIdType;
	private String pubId;
	
	public String getPubIdType() {
		return pubIdType;
	}


	public void setPubIdType(String pubIdType) {
		this.pubIdType = pubIdType;
	}


	public String getPubId() {
		return pubId;
	}


	public void setPubId(String pubId) {
		this.pubId = pubId;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
