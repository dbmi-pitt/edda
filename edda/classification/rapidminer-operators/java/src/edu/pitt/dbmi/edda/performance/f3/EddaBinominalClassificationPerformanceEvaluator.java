package edu.pitt.dbmi.edda.performance.f3;

import java.util.ArrayList;
import java.util.List;

import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.performance.BinaryClassificationPerformance;
import com.rapidminer.operator.performance.BinominalClassificationPerformanceEvaluator;
import com.rapidminer.operator.performance.PerformanceCriterion;

public class EddaBinominalClassificationPerformanceEvaluator extends
		BinominalClassificationPerformanceEvaluator {

	public EddaBinominalClassificationPerformanceEvaluator(
			OperatorDescription description) {
		super(description);
	}
	
	@Override
	public List<PerformanceCriterion> getCriteria() {
		List<PerformanceCriterion> performanceCriteria = super.getCriteria();
		List<PerformanceCriterion> newPerformanceCriteria = new ArrayList<PerformanceCriterion>();
		for (PerformanceCriterion performanceCriterion : performanceCriteria) {
			if (!(performanceCriterion instanceof BinaryClassificationPerformance)) {
				newPerformanceCriteria.add(performanceCriterion);
			}
		}
		// binary classification criteria
		for (int i = 0; i < EddaBinaryClassificationPerformance.NAMES.length; i++) {
			newPerformanceCriteria.add(new EddaBinaryClassificationPerformance(i));
		}
		return newPerformanceCriteria;
	}

}
