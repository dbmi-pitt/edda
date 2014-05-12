package edu.pitt.dbmi.edda.operator.c45bayes.pojos;

import java.io.Serializable;

public class Specimen implements Serializable {

	private static final long serialVersionUID = 1L;
	private static long specimenIndex = 0L ;
	private static Object newSpecimenObject = new Object();
	public static Specimen newSpecimen() {
		synchronized(newSpecimenObject) {
			Specimen specimen = new Specimen() ;
			specimen.setId(specimenIndex);
			specimenIndex++;
			return specimen;
		}
	}
	
	private Long id;
	private String overAllOutcome;

	private Specimen() {
		;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOverAllOutcome() {
		return overAllOutcome;
	}

	public void setOverAllOutcome(String overAllOutcome) {
		this.overAllOutcome = overAllOutcome;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append("\nSpecimen:\n") ;
		return sb.toString() ;
	}

}
