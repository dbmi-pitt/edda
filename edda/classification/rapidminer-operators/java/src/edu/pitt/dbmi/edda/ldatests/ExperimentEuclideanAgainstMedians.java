package edu.pitt.dbmi.edda.ldatests;

import java.util.TreeSet;

import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.IDSorter;
import cc.mallet.types.Instance;

public class ExperimentEuclideanAgainstMedians extends Experiment {
	
	private double[] medianExcludeProbabilities = new double[numTopics];
	private double[] medianIncludeProbabilities = new double[numTopics];
	
	public ExperimentEuclideanAgainstMedians() {
		;
	}
	
	public ExperimentEuclideanAgainstMedians(Experiment copyExperiment) {
		super(copyExperiment);
	}

	@Override
	protected void initialize() {
		int numberOfCols = numTopics;
		for (int col = 0; col < numberOfCols; col++) {
			medianExcludeProbabilities[col] += calculateMedian(col,
					Experiment.CONST_EXCLUDE_TARGET);
			medianIncludeProbabilities[col] += calculateMedian(col,
					Experiment.CONST_INCLUDE_TARGET);
		}
		displayVector("Median exclude probs", medianExcludeProbabilities);
		displayVector("Median include probs", medianIncludeProbabilities);

	}
	
	private double calculateMedian(int col, String targetLabel) {
		TreeSet<IDSorter> sortedRowValuesInColumn = new TreeSet<IDSorter>();
		int numberOfRows = model.getData().size();
		for (int row = 0; row < numberOfRows; row++) {
			Instance instance = model.getData().get(row).instance;
			String label = goldTargets.fetchTargetForInstance(instance);
			if (label.equals(targetLabel)) {
				TopicInferencer inferencer = model.getInferencer();
				final double[] topicProbs = TopicModelUtils
						.inferTopicForInstance(inferencer, instance);
				IDSorter colValue = new IDSorter(
						sortedRowValuesInColumn.size(), topicProbs[col]);
				sortedRowValuesInColumn.add(colValue);
			}
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
	protected double calculateExcludeDistance(double[] testProbabilities) {
		return calculateDistance(testProbabilities,  medianExcludeProbabilities);
	}

	@Override
	protected double calculateIncludeDistance(double[] testProbabilities) {
		return calculateDistance(testProbabilities,  medianIncludeProbabilities);
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
