package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DescriptorName {
	
	private String majorTopicYN;
	private String content;

	public String getMajorTopicYN() {
		return majorTopicYN;
	}
	public void setMajorTopicYN(String majorTopicYN) {
		this.majorTopicYN = majorTopicYN;
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
