package edu.pitt.dbmi.edda.ldatests;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import cc.mallet.types.IDSorter;

import cc.mallet.types.Instance;

public class ExperimentTallyAgainstMeans extends Experiment {
	
	private static final Logger logger = Logger
			.getLogger(ExperimentTallyAgainstMeans.class);
	
	private double[] averageExcludeProbabilities = new double[numTopics];
	private double[] averageIncludeProbabilities = new double[numTopics];
	private double[] stdExcludeProbabilities = new double[numTopics];
	private double[] stdIncludeProbabilities = new double[numTopics];
	private double excludeCount = 0.0d;
	private double includeCount = 0.0d;
	
	private final TreeSet<IDSorter> divergences = new TreeSet<IDSorter>() ;
	
	public ExperimentTallyAgainstMeans() {
		logger.setLevel(Level.DEBUG);
	}
	
	public ExperimentTallyAgainstMeans(Experiment copyExperiment) {
		super(copyExperiment);
		logger.setLevel(Level.DEBUG);
	}

	@Override
	protected void initialize() {
		
		int numberOfRows = model.getData().size();
		int numberOfCols = numTopics;
	
		calculateMeans(numberOfRows, numberOfCols);
		
		calculateStds(numberOfRows, numberOfCols);
		
		calculateMaxMeanDivergence(numberOfCols);
	
		displayIntermediateResults();

	}
	
	private void calculateMaxMeanDivergence(int numberOfCols) {
		SortedSet<IDSorter> ascendingDivergences = new TreeSet<IDSorter>() ;
		for (int col = 0; col < numberOfCols; col++) {
			double weight = 1.0 - Math.abs(averageIncludeProbabilities[col] - averageExcludeProbabilities[col]);
			IDSorter idSorter = new IDSorter(col, weight);
			ascendingDivergences.add(idSorter);
		}
		divergences.clear();
		for (int idx = 0; idx < 5 ; idx++) {
			IDSorter greatestDivergence = ascendingDivergences.first();
			divergences.add(greatestDivergence);
			ascendingDivergences = ascendingDivergences.tailSet(greatestDivergence);
		}
		
	}

	private void displayIntermediateResults() {
		displayVector("Average exclude probs", averageExcludeProbabilities);
		displayVector("Average include probs", averageIncludeProbabilities);
		displayVector("Standard deviation exclude probs", stdExcludeProbabilities);
		displayVector("Standard deviation  include probs", stdIncludeProbabilities);
	}

	private void calculateStds(int numberOfRows, int numberOfCols) {
		for (int row = 0; row < numberOfRows; row++) {
			Instance instance = model.getData().get(row).instance;
			final double[] topicProbs = TopicModelUtils.inferTopicForInstance(
					model.getInferencer(), instance);
			String label = goldTargets.fetchTargetForInstance(instance);
			if (label.startsWith("e")) {
				for (int col = 0; col < numberOfCols; col++) {
					stdExcludeProbabilities[col] = Math.pow(topicProbs[col] - averageExcludeProbabilities[col], 2.0d) ;
				}
			} else {
				for (int col = 0; col < numberOfCols; col++) {
					stdIncludeProbabilities[col] = Math.pow(topicProbs[col] - averageIncludeProbabilities[col], 2.0d) ;
				}
			}
		}
		for (int col = 0; col < numberOfCols; col++) {
			stdExcludeProbabilities[col] = Math.pow(stdExcludeProbabilities[col] / (excludeCount - 1.0d), 0.5d);
			stdIncludeProbabilities[col] = Math.pow(stdIncludeProbabilities[col] / (includeCount - 1.0d), 0.5d);
		}
		
	}

	protected void calculateMeans(int numberOfRows, int numberOfCols) {
		for (int row = 0; row < numberOfRows; row++) {
			Instance instance = model.getData().get(row).instance;
			final double[] topicProbs = TopicModelUtils.inferTopicForInstance(
					model.getInferencer(), instance);
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
	}
	

	@Override
	protected double calculateExcludeDistance(double[] testProbabilities) {
		double distance = 0.0d;
		Iterator<IDSorter> divergencesIterator = divergences.iterator();
		while (divergencesIterator.hasNext()) {
			IDSorter idSorter = divergencesIterator.next();
			int idx = idSorter.getID();
			double test = testProbabilities[idx];
			double mean = averageExcludeProbabilities[idx];
			double std = stdExcludeProbabilities[idx];
			distance += Math.abs(test - mean) / std;
		}
		return distance;
	}

	@Override
	protected double calculateIncludeDistance(double[] testProbabilities) {
		double distance = 0.0d;
		Iterator<IDSorter> divergencesIterator = divergences.iterator();
		while (divergencesIterator.hasNext()) {
			IDSorter idSorter = divergencesIterator.next();
			int idx = idSorter.getID();
			double test = testProbabilities[idx];
			double mean = averageIncludeProbabilities[idx];
			double std = stdIncludeProbabilities[idx];
			distance += Math.abs(test - mean) / std;
		}
		return distance;
	}

	protected double calculateNumberOfStdsFromMean(double test, double mean, double std) {
		double lower = mean - std;
		double upper = mean + std;
		double iteration = 1.0d;
		while (true) {
			if (test >= lower && test <= upper) {
				break;
			}
			 lower = lower - std;
			 upper = upper + std;
			 iteration += 1.0d;
		}
		return iteration;
	}

}
