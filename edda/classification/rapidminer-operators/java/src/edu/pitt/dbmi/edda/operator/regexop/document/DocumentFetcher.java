package edu.pitt.dbmi.edda.operator.regexop.document;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class DocumentFetcher {

	private List<String[]> labelDirectoryPairs;
	
	private final ArrayList<LabeledDocument> labeledDocuments = new ArrayList<LabeledDocument>();
	
	private Iterator<LabeledDocument> labeledDocumentIterator;
	
	private int totalNumberOfDocuments = 0;
	
	private boolean isUsingAbstractsOnly = false ;
	
	public DocumentFetcher() {
		;
	}
	
	public DocumentFetcher(List<String[]> labelDirectoryPairs) {
		this.labelDirectoryPairs = labelDirectoryPairs;
	}
	
	public void establishLabeledDocuments() {
		for (String[] pair : labelDirectoryPairs) {
			String label = pair[0];
			String path = pair[1];
			File currentDir = new File(path) ;
			File[] fileArray = currentDir.listFiles();
			if (fileArray != null) {
				Iterator<File> fileIterator = Arrays.asList(fileArray).iterator();
				while (fileIterator.hasNext()) {
					LabeledDocument labeledDocument = new LabeledDocument();
					labeledDocument.documentNumber = totalNumberOfDocuments++;
					labeledDocument.key = StringUtils.leftPad(labeledDocument.documentNumber+"", 10, "0") + ":";
					labeledDocument.label = label;
					labeledDocument.file = fileIterator.next();
					labeledDocument.isUsingAbstractsOnly = isUsingAbstractsOnly();
					this.labeledDocuments.add(labeledDocument) ;
				}
			}
		}
	}

	public void startIteration() {
		this.labeledDocumentIterator = this.labeledDocuments.iterator();
	}

	public LabeledDocument getNext() {
		if (this.labeledDocumentIterator.hasNext()) {
			return this.labeledDocumentIterator.next();
		}
		else {
			return null;
		}
	}
	
	public int getTotalNumberOfDocuments() {
		return totalNumberOfDocuments;
	}
	
	private HashMap<String, Double> tallyLabeledClasses() {
		final HashMap<String, Double> result = new HashMap<String, Double>();
		for (LabeledDocument labeledDocument : this.labeledDocuments) {
			Double amount = result.get(labeledDocument.label) ;
			if (amount == null) {
				result.put(labeledDocument.label, new Double(1.0d)) ;
			}
			else {
				result.put(labeledDocument.label, new Double(amount + 1.0d)) ;
			}
		}
		return result;
	}
	
	public boolean isUsingAbstractsOnly() {
		return isUsingAbstractsOnly;
	}

	public void setUsingAbstractsOnly(boolean isUsingAbstractsOnly) {
		this.isUsingAbstractsOnly = isUsingAbstractsOnly;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append("\nDocumentFetcher:\n");
		HashMap<String, Double> labeledClassSums = tallyLabeledClasses();
		for (String label : labeledClassSums.keySet()) {
			sb.append("\t" + label + " has " + labeledClassSums.get(label) + " documents.\n") ;
		}
		return sb.toString();
	}

}
