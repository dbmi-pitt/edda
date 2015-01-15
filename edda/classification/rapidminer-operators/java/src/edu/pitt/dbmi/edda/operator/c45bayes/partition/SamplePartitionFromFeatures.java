package edu.pitt.dbmi.edda.operator.c45bayes.partition;

import java.util.ArrayList;

import edu.pitt.dbmi.edda.operator.c45bayes.C45BayesModel;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Experiment;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Gene;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Specimen;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Well;

public class SamplePartitionFromFeatures extends SamplePartition {
	
	private Gene feature ;
	
	@Override
	public double calculateEntropy() {
		double numberOfSamplesTotal = (double) unPartitionedSamples.size() ;
		double sumOverClses = 0.0d ;
		for (String partitionName : partitionNames) {
			ArrayList<Specimen> partition = partitionedSamples.get(partitionName) ;
			double numberOfSamplesInFeaturePartition = (double) partition.size() ;
			double partitionWeight = numberOfSamplesInFeaturePartition /  numberOfSamplesTotal ;
			SamplePartitionFromClses samplePartitionFromClses = new SamplePartitionFromClses() ;
			samplePartitionFromClses.setPartitionNames(C45BayesModel.clsOutcomes) ;
			samplePartitionFromClses.setUnPartitionedSamples(partition) ;
			samplePartitionFromClses.execute();
			sumOverClses += partitionWeight * samplePartitionFromClses.calculateEntropy() ;
		}
		return sumOverClses ;
	}

	@Override
	protected String getPartitionNameFromSample(Specimen sample) {
		Well wellForGene = Experiment.getInstance(null).findWellForGene(sample, feature) ;
		return wellForGene.getNominalValue() ;
	}
	
	public Gene getFeature() {
		return feature;
	}

	public void setFeature(Gene feature) {
		this.feature = feature;
	}

	

	

}
