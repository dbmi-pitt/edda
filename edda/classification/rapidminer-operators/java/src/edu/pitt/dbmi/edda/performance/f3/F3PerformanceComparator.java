package edu.pitt.dbmi.edda.performance.f3;

// edu.pitt.dbmi.revipure.operator.F3PerformanceComparator

import com.rapidminer.operator.performance.BinaryClassificationPerformance;
import com.rapidminer.operator.performance.PerformanceComparator;
import com.rapidminer.operator.performance.PerformanceVector;

public class F3PerformanceComparator implements PerformanceComparator {

	private static final long serialVersionUID = -5124969291806764799L;

	@Override
	public int compare(PerformanceVector pv1, PerformanceVector pv2) {
		
		String recallName = BinaryClassificationPerformance.NAMES[BinaryClassificationPerformance.RECALL];
		String precisionName = BinaryClassificationPerformance.NAMES[BinaryClassificationPerformance.PRECISION];

		
		Double recallOne = pv1.getCriterion(recallName).getAverage();
		Double precisionOne = pv1.getCriterion(precisionName).getAverage();
		
		Double recallTwo = pv2.getCriterion(recallName).getAverage();
		Double precisionTwo = pv2.getCriterion(precisionName).getAverage();
		
		
		Double F3One = (10.0d * precisionOne * recallOne) / (9 * precisionOne + recallOne) ;
		
		Double F3Two = (10.0d * precisionTwo * recallTwo) / (9 * precisionTwo + recallTwo) ;

		
		if (F3Two > F3One) {
			System.out.println("F3 Comparison: SetOne: " + F3One + " vs SetTwo: " + F3Two + " ==> SetTwo") ;
			return 1;
		}
		else {
			System.out.println("F3 Comparison: SetOne: " + F3One + " vs SetTwo: " + F3Two + " ==> SetOne") ;
			return -1;
		}
	}


}
