package edu.pitt.dbmi.edda.ldatests;

public class ExperimentTwoModelSumProbs extends ExperimentTwoModel {

	public ExperimentTwoModelSumProbs() {
	}

	public ExperimentTwoModelSumProbs(ExperimentTwoModel experiment) {
		super(experiment);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected double calculateIncludeDistance(double[] testProbabilities) {
		return sum(testProbabilities);
	}

	@Override
	protected double calculateExcludeDistance(double[] testProbabilities) {
		return sum(testProbabilities);
	}
	
	private double sum(double[] values) {
		double sum = 0.0d;
		for (double value : values) {
			sum += value;
		}
		return sum;
	}

}
