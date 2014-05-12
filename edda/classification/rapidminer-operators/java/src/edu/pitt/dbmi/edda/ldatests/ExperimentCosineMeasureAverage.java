package edu.pitt.dbmi.edda.ldatests;

import cc.mallet.types.Instance;

public class ExperimentCosineMeasureAverage extends Experiment {

	public ExperimentCosineMeasureAverage() {
		;
	}

	public ExperimentCosineMeasureAverage(Experiment copyExperiment) {
		super(copyExperiment);
	}

	@Override
	protected void initialize() {
		;
	}

	@Override
	protected double calculateIncludeDistance(double[] testProbabilities) {
		return averageCosineOverTarget(testProbabilities,
				Experiment.CONST_INCLUDE_TARGET);
	}

	@Override
	protected double calculateExcludeDistance(double[] testProbabilities) {
		return averageCosineOverTarget(testProbabilities,
				Experiment.CONST_EXCLUDE_TARGET);
	}

	private double averageCosineOverTarget(double[] testTopicProbs,
			String targetLabel) {
		int numberOfRows = model.getData().size();
		double resultDivergence = -1.0d;
		double sumOfDivergences = 0.0d;
		double numberOfDivergences = 0.0d;
		for (int row = 0; row < numberOfRows; row++) {
			Instance instance = model.getData().get(row).instance;
			final double[] trainTopicProbs = TopicModelUtils
					.inferTopicForInstance(model.getInferencer(), instance);
			String label = goldTargets.fetchTargetForInstance(instance);
			if (label.equals(targetLabel)) {
				double divergence = calculateCosineDivergence(trainTopicProbs,
						testTopicProbs);
				if (divergence >= 0.0d) {
					sumOfDivergences += divergence;
					numberOfDivergences += 1.0d;
				}
			}
		}
		resultDivergence = Math.abs(sumOfDivergences / numberOfDivergences);

		return resultDivergence;

	}

	private double calculateCosineDivergence(double[] pValues, double[] qValues) {
		double cosineDivergence = 0.0d;
		double crossProductSum = 0.0d;
		double pSquaredSum = 0.0d;
		double qSquaredSum = 0.0d;
		for (int jdx = 0; jdx < pValues.length; jdx++) {
			double pValue = pValues[jdx];
			double qValue = qValues[jdx];
			crossProductSum += pValue * qValue;
			pSquaredSum += pValue * pValue;
			qSquaredSum += qValue * qValue;
		}
		double pSquaredSumRoot = Math.pow(pSquaredSum, 0.5d);
		double qSquaredSumRoot = Math.pow(qSquaredSum, 0.5d);
		double denominator = pSquaredSumRoot * qSquaredSumRoot;
		cosineDivergence = crossProductSum / denominator;
		return cosineDivergence;
	}

}
