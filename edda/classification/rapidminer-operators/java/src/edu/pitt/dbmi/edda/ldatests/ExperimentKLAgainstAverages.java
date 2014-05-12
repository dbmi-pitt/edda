package edu.pitt.dbmi.edda.ldatests;

import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.Instance;

public class ExperimentKLAgainstAverages extends Experiment {
	
	public ExperimentKLAgainstAverages() {
	}
	
	public ExperimentKLAgainstAverages(Experiment experiment) {
		super(experiment);
	}

	private double[] averageExcludeProbabilities = new double[numTopics];
	private double[] averageIncludeProbabilities = new double[numTopics];
	private double excludeCount = 0.0d;
	private double includeCount = 0.0d;
	
	@Override
	protected void initialize() {
		int numberOfRows = model.getData().size();
		int numberOfCols = numTopics;
		for (int row = 0; row < numberOfRows; row++) {
			TopicInferencer inferencer = model.getInferencer();
			Instance instance = model.getData().get(row).instance;
			final double[] topicProbs = TopicModelUtils.inferTopicForInstance(
					inferencer, instance);
			String label = goldTargets.fetchTargetForInstance(instance);
			if (label.startsWith("e")) {
				for (int col = 0; col < numberOfCols; col++) {
					averageExcludeProbabilities[col] += topicProbs[col];
				}
				excludeCount += 1.0d;
			} else {
				for (int col = 0; col < numberOfCols; col++) {
					averageIncludeProbabilities[col] += topicProbs[col];
				}
				includeCount += 1.0d;
			}
		}

		for (int col = 0; col < numberOfCols; col++) {
			averageExcludeProbabilities[col] /= excludeCount;
			averageIncludeProbabilities[col] /= includeCount;
		}

		displayVector("Average exclude probs", averageExcludeProbabilities);
		displayVector("Average include probs", averageIncludeProbabilities);
		
	}

	@Override
	protected double calculateIncludeDistance(double[] testProbabilities) {
		return CalculationsKullbackLeibler.tryCalculateSymmetricKullbackLeiblerDivergence(testProbabilities,  averageIncludeProbabilities);
	}

	@Override
	protected double calculateExcludeDistance(double[] testProbabilities) {
		return CalculationsKullbackLeibler.tryCalculateSymmetricKullbackLeiblerDivergence(testProbabilities,  averageExcludeProbabilities);
	}

}
