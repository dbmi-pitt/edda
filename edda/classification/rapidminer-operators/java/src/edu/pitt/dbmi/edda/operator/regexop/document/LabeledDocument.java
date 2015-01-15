package edu.pitt.dbmi.edda.operator.regexop.document;

import java.io.File;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.edda.util.FileUtils;

public class LabeledDocument implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String label;
	public File file;
	public transient String documentContent;
	public int numberOfSpaceTokens = 1;
	public Integer documentNumber;
	public String key;
	public Boolean isUsingAbstractsOnly = false;
	
	public LabeledDocument() {
	}
	
	public String getContent() {
		if (this.documentContent == null) {
			this.documentContent = FileUtils.getContents(this.file);
			if (isUsingAbstractsOnly) {
				this.documentContent = extractAbstractFromContent(this.documentContent);
			}
			this.numberOfSpaceTokens = Math.max(countSpaceTokens(this.documentContent), 1) ;
		}
		return this.documentContent;
	}
	
	public void clearContent() {
		this.documentContent = null;
	}

	private String extractAbstractFromContent(String documentContent) {
		int abstractIdx = documentContent.indexOf("AB  -") ;
		if (abstractIdx == -1) {
			abstractIdx++;
		}
		else {
			abstractIdx += "AB  -".length();
		}
		return documentContent.substring(abstractIdx,documentContent.length()) ;
	}
	
	private int countSpaceTokens(String documentContent) {
		int numberOfSpaceTokens = 0;
		Pattern pattern = Pattern.compile("\\s+", Pattern.DOTALL
				| Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(documentContent);
		while (matcher.find()) {
			numberOfSpaceTokens++;
		}
		return numberOfSpaceTokens;
	}
	
	
	public String toString() {
		return this.label + " ==> " + file.getName();
	}
	
}
