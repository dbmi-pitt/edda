package edu.pitt.dbmi.edda.rulebase.pico;

import edu.pitt.dbmi.edda.rulebase.Identifiable;

public class DocumentTerm extends Identifiable {

	private static final long serialVersionUID = 1L;
	
	protected Integer documentId;
	protected String term = "NA";
	
	public Integer getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}


}
