package edu.pitt.dbmi.edda.operator.c45bayes.bayes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import edu.pitt.dbmi.edda.operator.c45bayes.C45BayesModel;
import edu.pitt.dbmi.edda.operator.c45bayes.partition.SamplePartitionFromClses;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Experiment;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Gene;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Specimen;

public class Classifier implements Serializable {

	private static final long serialVersionUID = 1L;

	private final HashMap<String, ClsPriorProbabilityCalculator> clses = new HashMap<String, ClsPriorProbabilityCalculator>();

	private Experiment experiment;

	private HashSet<Gene> features;

	public Classifier() {
		;
	}

	public void train() {
		ArrayList<Specimen> samples = experiment.getSpecimens();
		trainClassifier(samples);
	}

	public String classifyTestSpecimen(Specimen sample) {
		double maximumProbability = -1.0d;
		String predictedOutcome = null;
		for (String clsOutcome : C45BayesModel.clsOutcomes) {
			ClsPriorProbabilityCalculator clsCalc = clses.get(clsOutcome);
			double probability = clsCalc.calculateProbabilityFor(sample);
			if (probability >= maximumProbability) {
				maximumProbability = probability;
				predictedOutcome = clsOutcome;
			}
		}
		return predictedOutcome;
	}

	public String findOutcomeForSample(Specimen sample) {
		return sample.getOverAllOutcome();
	}

	private void trainClassifier(ArrayList<Specimen> trainingSamples) {
		SamplePartitionFromClses trainingClsPartition = partitionByCls(trainingSamples);
		calculatePriors(trainingClsPartition, trainingSamples);
		calculatePosteriors(trainingClsPartition);
	}

	private void calculatePriors(SamplePartitionFromClses trainingClsPartition,
			ArrayList<Specimen> trainingSamples) {
		double totalNumberOfTrainingSamples = (double) trainingSamples.size();
		for (String clsOutcome : C45BayesModel.clsOutcomes) {
			double totalNumberOfSamplesWithOutcome = (double) trainingClsPartition
					.getPartition(clsOutcome).size();
			double priorProbabilityOfOutcome = totalNumberOfSamplesWithOutcome
					/ totalNumberOfTrainingSamples;
			ClsPriorProbabilityCalculator clsPriorProbabilityCalculator = new ClsPriorProbabilityCalculator();
			clsPriorProbabilityCalculator.setClsName(clsOutcome);
			clsPriorProbabilityCalculator
					.setProbability(priorProbabilityOfOutcome);
			clses.put(clsPriorProbabilityCalculator.getClsName(),
					clsPriorProbabilityCalculator);
		}
	}

	private void calculatePosteriors(
			SamplePartitionFromClses trainingClsPartition) {
		for (String clsOutcome : C45BayesModel.clsOutcomes) {
			ClsPriorProbabilityCalculator clsCalculator = clses.get(clsOutcome);
			clsCalculator.setFeatures(features);
			clsCalculator.train(trainingClsPartition.getPartition(clsOutcome));
		}
	}

	private SamplePartitionFromClses partitionByCls(ArrayList<Specimen> samples) {
		final SamplePartitionFromClses samplesPartitionedByClass = new SamplePartitionFromClses();
		samplesPartitionedByClass.setUnPartitionedSamples(samples);
		samplesPartitionedByClass.setPartitionNames(C45BayesModel.clsOutcomes);
		samplesPartitionedByClass.execute();
		return samplesPartitionedByClass;
	}

	public Experiment getExperiment() {
		return experiment;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}

	public HashSet<Gene> getFeatures() {
		return features;
	}

	public void setFeatures(HashSet<Gene> highGainDiscriminators) {
		this.features = highGainDiscriminators;
	}

	

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n\n");
		for (ClsPriorProbabilityCalculator clsCalc : clses.values()) {
			sb.append(clsCalc.toString() + "\n");
		}
		return sb.toString();
	}
}
