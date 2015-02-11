package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Abstract {
	
	private final Collection<AbstractText> abtractTexts = new ArrayList<AbstractText>();

	public Collection<AbstractText> getAbstractTexts() {
		return abtractTexts;
	}
	
	public void addAbstractText(AbstractText abstractText) {
		abtractTexts.add(abstractText);
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


}
