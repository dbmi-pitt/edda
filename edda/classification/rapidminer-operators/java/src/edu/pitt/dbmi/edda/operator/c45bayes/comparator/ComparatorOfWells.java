package edu.pitt.dbmi.edda.operator.c45bayes.comparator;

import java.util.Comparator;

import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Well;

public class ComparatorOfWells implements Comparator<Well> {

	public int compare(Well wellOne, Well wellTwo) {
		int result = 0 ;
		if (wellOne.getAverageValue() <= wellTwo.getAverageValue()) {
			result = -1 ;
		}
		else if (wellOne.getAverageValue() >= wellTwo.getAverageValue()) {
			result = 1 ;
		}
		return result ;
	}

}
