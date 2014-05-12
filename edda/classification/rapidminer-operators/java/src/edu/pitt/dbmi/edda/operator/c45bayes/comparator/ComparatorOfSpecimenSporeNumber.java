package edu.pitt.dbmi.edda.operator.c45bayes.comparator;

import java.util.Comparator;

import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Specimen;

public class ComparatorOfSpecimenSporeNumber implements Comparator<Specimen> {
	public int compare(Specimen o1, Specimen o2) {	
		int comparison = o1.getId().compareTo(o2.getId()) ;
		return comparison ;
	}
}
