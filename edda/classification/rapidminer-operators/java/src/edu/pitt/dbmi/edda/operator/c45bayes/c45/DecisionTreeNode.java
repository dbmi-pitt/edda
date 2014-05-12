package edu.pitt.dbmi.edda.operator.c45bayes.c45;

import java.util.ArrayList;
import java.util.Collection;

import edu.pitt.dbmi.edda.operator.c45bayes.C45BayesModel;
import edu.pitt.dbmi.edda.operator.c45bayes.partition.SamplePartitionFromClses;
import edu.pitt.dbmi.edda.operator.c45bayes.partition.SamplePartitionFromFeatures;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Experiment;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Gene;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Specimen;

public class DecisionTreeNode {
	
	private Experiment experiment;
	
	private ArrayList<Specimen> samples = new ArrayList<Specimen>() ;
	
	private ArrayList<Gene> exclusionGenes = new ArrayList<Gene>() ;
	private Gene highGainFeature = null ;
	private double highGainFeatureInformationGain = Double.MIN_VALUE ;
	private ArrayList<DecisionTreeNode> children = new ArrayList<DecisionTreeNode>() ;
	
	public DecisionTreeNode() {
	}
	
	public void execute() {
		calculateMaxGainFeature() ;
		if (highGainFeature != null) {
			SamplePartitionFromFeatures partitionByFeature = partitionByFeature(highGainFeature) ;
			for (String featurePartition : C45BayesModel.featureOutcomes) {
				DecisionTreeNode childNode = buildChildNode(partitionByFeature, featurePartition) ;
				children.add(childNode) ;
			}
		}
	}
	
	private DecisionTreeNode buildChildNode(SamplePartitionFromFeatures partitionByFeature, String featurePartition) {
		final DecisionTreeNode childNode = new DecisionTreeNode() ;
		childNode.setExperiment(experiment) ;
		ArrayList<Specimen> samplePartition = partitionByFeature.getPartition(featurePartition) ;
		childNode.setSamples(samplePartition) ;
		final ArrayList<Gene> childExclusionGenes = new ArrayList<Gene>() ;
		childExclusionGenes.addAll(exclusionGenes) ;
		childExclusionGenes.add(highGainFeature) ;
		childNode.addExclusionGenes(childExclusionGenes) ;
		return childNode ;
	}

	private void calculateMaxGainFeature() {
		SamplePartitionFromClses samplesPartitionedByClass = partitionByCls() ;
		if (samplesPartitionedByClass.isHomogenious()) {
//			System.out.println("Homogeneous Node discovered, processing aborted...") ;
		}
		else {
			double clsBasedEntropy = samplesPartitionedByClass.calculateEntropy() ;
			int totalGenesProcessed = 0 ;
	     	for (Gene feature : experiment.getGenes().values()) {
				if (isExclusionFeature(feature)) {
					continue ;
				}
				if (totalGenesProcessed % 100 == 0) {
//					System.out.println("Processed " + totalGenesProcessed + " genes") ;
				}
				SamplePartitionFromFeatures partitionByFeature = partitionByFeature(feature) ;
				double featureBasedEntropy = partitionByFeature.calculateEntropy() ;
				double informationGain = clsBasedEntropy - featureBasedEntropy ;
				if (informationGain <= highGainFeatureInformationGain && informationGain >= highGainFeatureInformationGain) {
				}
				else if (informationGain > highGainFeatureInformationGain) {
					swapHighInformationGainGene(feature, informationGain) ;
				}
				totalGenesProcessed++;
			}
		}
	}
	
	private void swapHighInformationGainGene(Gene feature, double informationGain) {
		StringBuffer sb = new StringBuffer() ;
		if (highGainFeature == null) {
			sb.append("Old Max: ()\n") ;
		}
		else {
			sb.append("Old Max: (" + highGainFeature.getName() + ", " + highGainFeatureInformationGain + ")\n") ;
		}
		
		sb.append("New Max: (" + feature.getName() + ", " + informationGain+ ")\n") ;
		System.out.println("\n" + sb.toString() + "\n") ;
		highGainFeatureInformationGain = informationGain ;
		highGainFeature = feature ;
	}

	private boolean isExclusionFeature(Gene feature) {
		boolean result = false ;
		for (Gene exclusionFeature : exclusionGenes) {
			if (feature.getName().equals(exclusionFeature.getName())) {
				result = true ;
				break ;
			}
		}
		return result;
	}

	private SamplePartitionFromClses partitionByCls() {
		final SamplePartitionFromClses samplesPartitionedByClass = new SamplePartitionFromClses() ;
		samplesPartitionedByClass.setUnPartitionedSamples(samples) ;
		samplesPartitionedByClass.setPartitionNames(C45BayesModel.clsOutcomes) ;
		samplesPartitionedByClass.execute();
		return samplesPartitionedByClass ;
	}
	
	private SamplePartitionFromFeatures partitionByFeature(Gene feature) {
		final SamplePartitionFromFeatures samplesPartitionedByFeature = new SamplePartitionFromFeatures() ;
		samplesPartitionedByFeature.setUnPartitionedSamples(samples) ;
		samplesPartitionedByFeature.setPartitionNames(C45BayesModel.featureOutcomes) ;
		samplesPartitionedByFeature.setFeature(feature) ;
		samplesPartitionedByFeature.execute();
		return samplesPartitionedByFeature ;
	}
	
	private void addExclusionGenes(ArrayList<Gene> exclusionGenes) {
		exclusionGenes.addAll(exclusionGenes) ;
	}
	
	public Experiment getExperiment() {
		return experiment;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}
	
	public ArrayList<Specimen> getSamples() {
		return samples;
	}

	public void setSamples(ArrayList<Specimen> samples) {
		this.samples = samples;
	}
	
	public Gene getHighGainFeature() {
		return highGainFeature;
	}

	public Collection<DecisionTreeNode> getChildren() {
		return children ;
	}
	
}
	

