package edu.pitt.dbmi.edda.ldatests;

import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.Instance;

public class ExperimentEuclideanAgainstAverages extends Experiment {
	
	private double[] averageExcludeProbabilities = new double[numTopics];
	private double[] averageIncludeProbabilities = new double[numTopics];
	private double excludeCount = 0.0d;
	private double includeCount = 0.0d;
	
	public ExperimentEuclideanAgainstAverages() {
		;
	}
	
	public ExperimentEuclideanAgainstAverages(Experiment experiment) {
		super(experiment);
	}
	
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
	protected double calculateExcludeDistance(double[] testProbabilities) {
		return calculateDistance(testProbabilities, averageExcludeProbabilities);
	}

	@Override
	protected double calculateIncludeDistance(double[] testProbabilities) {
		return calculateDistance(testProbabilities, averageIncludeProbabilities);
	}

	private double calculateDistance(double[] a, double[] b) {
		double distance = 0.0d;
		for (int col = 0; col < a.length; col++) {
			double t1 = a[col] - b[col];
			double t2 = t1 * t1;
			distance += t2;
		}
		distance = Math.sqrt(distance);
		return distance;
	}

}
