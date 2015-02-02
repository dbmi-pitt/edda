package edu.pitt.dbmi.edda.rulebase.document;

import edu.pitt.dbmi.edda.rulebase.Identifiable;

// Ameloblastoma, Flu,  Galactomannan, Maleria, Transplant

public class SystematicReview extends Identifiable {
	
	private static final long serialVersionUID = 1L;
	
	private String domain;

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDomain() {
		return domain;
	}

}
