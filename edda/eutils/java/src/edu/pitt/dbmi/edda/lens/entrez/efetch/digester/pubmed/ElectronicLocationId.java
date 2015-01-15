package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ElectronicLocationId {
	
	private String eIdType;
	private String validYN;
	private String content;
	
	public String geteIdType() {
		return eIdType;
	}
	public void seteIdType(String eIdType) {
		this.eIdType = eIdType;
	}
	public String getValidYN() {
		return validYN;
	}
	public void setValidYN(String validYN) {
		this.validYN = validYN;
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
