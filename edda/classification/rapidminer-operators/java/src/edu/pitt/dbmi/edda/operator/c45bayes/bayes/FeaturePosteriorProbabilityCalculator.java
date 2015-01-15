package edu.pitt.dbmi.edda.operator.c45bayes.bayes;

import java.util.ArrayList;
import java.util.HashMap;

import edu.pitt.dbmi.edda.operator.c45bayes.C45BayesModel;
import edu.pitt.dbmi.edda.operator.c45bayes.partition.SamplePartitionFromFeatures;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Experiment;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Gene;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Specimen;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Well;

public class FeaturePosteriorProbabilityCalculator {

	private String clsName;

	private Gene feature;

	private ArrayList<Specimen> trainingSamples;

	private HashMap<String, Double> probabilities = new HashMap<String, Double>();

	public FeaturePosteriorProbabilityCalculator() {
		;
	}

	public void train() {
		SamplePartitionFromFeatures featurePartitions = partitionByFeature(feature);
		double totalNumberOfSamples = (double) trainingSamples.size();
		for (String featureOutcome : C45BayesModel.featureOutcomes) {
			double totalNumberOfSamplesWithOutcome = (double) featurePartitions
					.getPartition(featureOutcome).size();
			double priorProbabilityOfOutcome = totalNumberOfSamplesWithOutcome
					/ totalNumberOfSamples;
			probabilities.put(featureOutcome, new Double(
					priorProbabilityOfOutcome));
		}
	}

	private SamplePartitionFromFeatures partitionByFeature(Gene feature) {
		final SamplePartitionFromFeatures samplesPartitionedByFeature = new SamplePartitionFromFeatures();
		samplesPartitionedByFeature.setUnPartitionedSamples(trainingSamples);
		samplesPartitionedByFeature
				.setPartitionNames(C45BayesModel.featureOutcomes);
		samplesPartitionedByFeature.setFeature(feature);
		samplesPartitionedByFeature.execute();
		return samplesPartitionedByFeature;
	}

	public double calculateProbability(Specimen sample) {
		Well well = Experiment.getInstance(null).findWellForGene(sample,
				feature);
		String featureOutcome = well.getNominalValue();
		double probability = probabilities.get(featureOutcome);
		return probability;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public Gene getFeature() {
		return feature;
	}

	public void setFeature(Gene feature) {
		this.feature = feature;
	}

	public ArrayList<Specimen> getSamples() {
		return trainingSamples;
	}

	public void setSamples(ArrayList<Specimen> samples) {
		this.trainingSamples = samples;
	}

	public HashMap<String, Double> getProbabilities() {
		return probabilities;
	}

	public void setProbabilities(HashMap<String, Double> probabilities) {
		this.probabilities = probabilities;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (String conditionalFeature : probabilities.keySet()) {
			sb.append("Pr( " + feature.getName() + " = " + conditionalFeature + " | " + clsName + " ) = "
					+ probabilities.get(conditionalFeature));
			sb.append("\n\t");
		}
		return sb.toString();
	}

}
