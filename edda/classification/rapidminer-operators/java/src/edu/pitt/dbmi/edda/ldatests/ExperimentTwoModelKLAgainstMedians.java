package edu.pitt.dbmi.edda.ldatests;

import java.util.TreeSet;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.IDSorter;
import cc.mallet.types.Instance;

public class ExperimentTwoModelKLAgainstMedians extends ExperimentTwoModel {

	private double[] medianExcludeProbabilities = new double[numTopics];
	private double[] medianIncludeProbabilities = new double[numTopics];

	public ExperimentTwoModelKLAgainstMedians() {
	}

	public ExperimentTwoModelKLAgainstMedians(ExperimentTwoModel experiment) {
		super(experiment);
	}

	@Override
	protected void initialize() {
		int numberOfCols = numTopics;
		for (int col = 0; col < numberOfCols; col++) {
			medianExcludeProbabilities[col] += calculateMedian(excludeModel,
					col);
			medianIncludeProbabilities[col] += calculateMedian(includeModel,
					col);
		}
		displayVector("Median exclude probs", medianExcludeProbabilities);
		displayVector("Median include probs", medianIncludeProbabilities);
	}

	private double calculateMedian(ParallelTopicModel model, int col) {
		TreeSet<IDSorter> sortedRowValuesInColumn = new TreeSet<IDSorter>();
		int numberOfRows = model.getData().size();
		for (int row = 0; row < numberOfRows; row++) {
			Instance instance = model.getData().get(row).instance;
			TopicInferencer inferencer = model.getInferencer();
			final double[] topicProbs = TopicModelUtils.inferTopicForInstance(
					inferencer, instance);
			IDSorter colValue = new IDSorter(sortedRowValuesInColumn.size(),
					topicProbs[col]);
			sortedRowValuesInColumn.add(colValue);
		}
		return median(toArray(sortedRowValuesInColumn));
	}

	private double median(double[] data) {
		if (data.length % 2 == 0) {
			return (data[(data.length / 2) - 1] + data[data.length / 2]) / 2.0;
		} else {
			return data[data.length / 2];
		}
	}

	private double[] toArray(TreeSet<IDSorter> sortedValues) {
		final double[] result = new double[sortedValues.size()];
		int idx = 0;
		for (IDSorter idSorter : sortedValues) {
			result[idx++] = idSorter.getWeight();
		}
		return result;
	}

	@Override
	protected double calculateIncludeDistance(double[] testProbabilities) {
		return CalculationsKullbackLeibler
				.tryCalculateSymmetricKullbackLeiblerDivergence(
						testProbabilities, medianIncludeProbabilities);
	}

	@Override
	protected double calculateExcludeDistance(double[] testProbabilities) {
		return CalculationsKullbackLeibler
				.tryCalculateSymmetricKullbackLeiblerDivergence(
						testProbabilities, medianExcludeProbabilities);
	}

}
