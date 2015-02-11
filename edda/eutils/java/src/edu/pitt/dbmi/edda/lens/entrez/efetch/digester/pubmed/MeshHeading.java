package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class MeshHeading {
	
	private DescriptorName descriptorName;
	private Collection<QualifierName> qualifierNames = new ArrayList<QualifierName>();
	public DescriptorName getDescriptorName() {
		return descriptorName;
	}
	public void setDescriptorName(DescriptorName descriptorName) {
		this.descriptorName = descriptorName;
	}
	public Collection<QualifierName> getQualifierNames() {
		return qualifierNames;
	}
	public void addQualifierName(QualifierName qualifierName) {
		qualifierNames.add(qualifierName);
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	

}
