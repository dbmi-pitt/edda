package edu.pitt.dbmi.edda.ldatests;

import java.util.TreeSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.IDSorter;
import cc.mallet.types.Instance;

public class ExperimentTallyAgainstMedians extends Experiment {
	
	private static final Logger logger = Logger
			.getLogger(ExperimentTallyAgainstMedians.class);
	
	private double[] medianExcludeProbabilities = new double[numTopics];
	private double[] medianIncludeProbabilities = new double[numTopics];
	private double averageMedianSeparation = 0.0d;
	
	public ExperimentTallyAgainstMedians() {
		logger.setLevel(Level.DEBUG);
	}
	
	public ExperimentTallyAgainstMedians(Experiment copyExperiment) {
		super(copyExperiment);
		logger.setLevel(Level.DEBUG);
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
		
		calculateAverageMedianSeparation();
		
		logger.debug("Average median separation is " + averageMedianSeparation);

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
	
	private void calculateAverageMedianSeparation() {
		double sum = 0.0d;
		for (int col = 0; col < numTopics; col++) {
			sum += Math.abs(medianExcludeProbabilities[col] -
			medianIncludeProbabilities[col]);
		}
		averageMedianSeparation = sum / numTopics;
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
//		displayVector("calculateExcludeDistance", testProbabilities);
		double tally = 0.0d;
		for (int idx = 0 ; idx < testProbabilities.length; idx++) {
			double test = testProbabilities[idx];
			double exclude = medianExcludeProbabilities[idx];
			double include = medianIncludeProbabilities[idx];
			double test2excludeDistance = Math.abs(test - exclude);
			double test2includeDistance = Math.abs(test - include);
			double dist = test2excludeDistance - test2includeDistance;
			if ( dist > averageMedianSeparation) {
				tally += 1.0d;
			}
		}
		double result = (tally > 0.0d) ? (1.0d / tally) : 2.0d;
		return result;
	}

	@Override
	protected double calculateIncludeDistance(double[] testProbabilities) {
//		displayVector("calculateIncludeDistance", testProbabilities);
		double tally = 0.0d;
		for (int idx = 0 ; idx < testProbabilities.length; idx++) {
			double test = testProbabilities[idx];
			double exclude = medianExcludeProbabilities[idx];
			double include = medianIncludeProbabilities[idx];
			double test2excludeDistance = Math.abs(test - exclude);
			double test2includeDistance = Math.abs(test - include);
			double dist = test2includeDistance - test2excludeDistance;
			if ( dist > averageMedianSeparation) {
				tally += 1.0d;
			}
		}
		double result = (tally > 0.0d) ? (1.0d / tally) : 2.0d;
		return result;
	}


}
