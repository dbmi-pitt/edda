package edu.pitt.dbmi.edda.operator.c45bayes.partition;

import java.util.ArrayList;

import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Specimen;

public class SamplePartitionFromClses extends SamplePartition {

	@Override
	protected String getPartitionNameFromSample(Specimen sample) {
		return sample.getOverAllOutcome() ;
	}

	@Override
	public double calculateEntropy() {
		double sumOverClses = 0.0d ;
		if (unPartitionedSamples.size() > 0) {
			double numberOfSamplesTotal = (double) unPartitionedSamples.size() ;
			for (String partitionName : partitionNames) {
				ArrayList<Specimen> partition = partitionedSamples.get(partitionName) ;
				if (partition.size() > 0) {
					double numberOfSamplesInCls = (double) partition.size() ;
					double probabilityOfCls = numberOfSamplesInCls / numberOfSamplesTotal ;
					sumOverClses += probabilityOfCls * Math.log(probabilityOfCls) ;
				}
			}
			sumOverClses *= -1.0d ;
		}
		
		return sumOverClses ;
	}
	
}
