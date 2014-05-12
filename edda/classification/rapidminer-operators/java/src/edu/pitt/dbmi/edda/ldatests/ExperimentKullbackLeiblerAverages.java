package edu.pitt.dbmi.edda.ldatests;

import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.Instance;

public class ExperimentKullbackLeiblerAverages extends Experiment {
	
	public ExperimentKullbackLeiblerAverages(Experiment copyExperiment) {
		super(copyExperiment);
	}

	@Override
	protected void initialize() {
		;	
	}

	@Override
	protected double calculateIncludeDistance(double[] testProbabilities) {
		return averageSymmetricKullbackLeiblerOverTarget(testProbabilities, "include");
	}

	@Override
	protected double calculateExcludeDistance(double[] testProbabilities) {
		return averageSymmetricKullbackLeiblerOverTarget(testProbabilities, "exclude");
	}
	
	private double averageSymmetricKullbackLeiblerOverTarget(double[] testTopicProbs, String targetLabel) {
		int numberOfRows = model.getData().size();
		double resultKlDivergence = -1.0d;
		double sumOfKlDivergences = 0.0d;
		double numberOfKlDivergences = 0.0d;
		for (int row = 0; row < numberOfRows; row++) {
			TopicInferencer inferencer = model.getInferencer();
			Instance instance = model.getData().get(row).instance;
			final double[] trainTopicProbs = TopicModelUtils.inferTopicForInstance(
					inferencer, instance);
			String label = instance.getTarget().toString();
			label = chompComma(label);
			if (label.equals(targetLabel)) {
				double klDivergence = CalculationsKullbackLeibler.tryCalculateSymmetricKullbackLeiblerDivergence(trainTopicProbs, testTopicProbs);
				if (klDivergence >= 0.0d) {
					sumOfKlDivergences += klDivergence;
					numberOfKlDivergences += 1.0d;
				}
			}
		}
		if (numberOfKlDivergences > 0.0d) {
			resultKlDivergence = sumOfKlDivergences / numberOfKlDivergences;
		}
		return resultKlDivergence;

	}
	


}
