package edu.pitt.dbmi.edda.ldatests;

import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.Instance;

public class ExperimentKullbackLeiblerMinimum extends Experiment {
	
	public ExperimentKullbackLeiblerMinimum(Experiment copyExperiment) {
		super(copyExperiment);
	}

	@Override
	protected void initialize() {
		;	
	}

	@Override
	protected double calculateIncludeDistance(double[] testProbabilities) {
		return minimizeSymmetricKullbackLeiblerOverTarget(testProbabilities, "include");
	}

	@Override
	protected double calculateExcludeDistance(double[] testProbabilities) {
		return minimizeSymmetricKullbackLeiblerOverTarget(testProbabilities, "exclude");
	}
	
	private double minimizeSymmetricKullbackLeiblerOverTarget(double[] testTopicProbs, String targetLabel) {
		int numberOfRows = model.getData().size();
		double resultKlDivergence = Double.MAX_VALUE;
		for (int row = 0; row < numberOfRows; row++) {
			TopicInferencer inferencer = model.getInferencer();
			Instance instance = model.getData().get(row).instance;
			final double[] trainTopicProbs = TopicModelUtils.inferTopicForInstance(
					inferencer, instance);
			String label = instance.getTarget().toString();
			label = chompComma(label);
			if (label.equals(targetLabel)) {
				double klDivergence = tryCalculateSymmetricKullbackLeiblerDivergence(trainTopicProbs, testTopicProbs);
				if (klDivergence >= 0.0d) {
					if (klDivergence < resultKlDivergence) {
						resultKlDivergence = klDivergence;
					}
				}
			}
		}
		return resultKlDivergence;
	}
	
	private double tryCalculateSymmetricKullbackLeiblerDivergence(double[] pValues, double[] qValues) {
		double klDivergence = 0.0d;
		try {
			klDivergence = calculateSymmetricKullbackLeiblerDivergence(pValues, qValues);
		} catch (Exception x) {
			System.err.println("tryCalculateSymmetricKullbackLeiblerDivergence threw an exception.");
			klDivergence = -1.0d;
		}
		return klDivergence;
	}

	/**
	 * Symmetric Kullback Leibler (KL) divergence
	 * 
	 * KL divergence is asymmetric and in many applications, it is convenient to
	 * apply a symmetric measure based on KL divergence:
	 */
	private double calculateSymmetricKullbackLeiblerDivergence(
			double[] pValues, double[] qValues) {
		return 0.5d * ( calculateKullbackLeiblerDivergence(pValues, qValues)
				+ calculateKullbackLeiblerDivergence(qValues, pValues) );
	}

	/**
	 * Kullback Leibler (KL) divergence
	 * 
	 * A standard function to measure the difference or divergence between two
	 * distributions p and q is the
	 */
	private double calculateKullbackLeiblerDivergence(double[] pValues,
			double[] qValues) {
		double klDivergence = 0.0d;
		for (int jdx = 0; jdx < pValues.length; jdx++) {
			double p = pValues[jdx];
			double q = qValues[jdx];
			klDivergence += p * Math.log(p / q);
		}
		return klDivergence;
	}

}
