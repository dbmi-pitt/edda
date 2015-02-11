package edu.pitt.dbmi.edda.operator.c45bayes.partition;

import java.util.ArrayList;
import java.util.HashMap;

import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Specimen;

public abstract class SamplePartition {
	
	protected ArrayList<Specimen> unPartitionedSamples ;
	
	protected HashMap<String, ArrayList<Specimen>> partitionedSamples = null ;
	
	protected String[] partitionNames = null ;
	
	public SamplePartition() {
		;
	}
	
	protected abstract String getPartitionNameFromSample(Specimen sample) ;
	
	protected abstract double calculateEntropy() ;
	
	public void execute() {
		partitionedSamples = buildEmptySamplePartitionFromNameArray(partitionNames) ;
		partition() ;
	}
	
	public boolean isHomogenious() {
		int nonZeroSizedPartitions = 0 ;
		for (String partitionName : partitionNames) {
			if (partitionedSamples.get(partitionName).size() > 0) {
				nonZeroSizedPartitions++ ;
			}
		}
		return nonZeroSizedPartitions == 1 ;
	}
	
	private void partition() {
		try {
			for (Specimen sample : unPartitionedSamples) {
				String partitionName = getPartitionNameFromSample(sample) ;
				ArrayList<Specimen> partition = this.partitionedSamples.get(partitionName) ;
				if (partition != null) {
					partition.add(sample) ;
				}
			}
		}
		catch (Exception x) {
			x.printStackTrace() ;
		}
		
	}
	
	private HashMap<String, ArrayList<Specimen>> buildEmptySamplePartitionFromNameArray(String[] partitionNames) {
		final HashMap<String, ArrayList<Specimen>> partitions = new HashMap<String, ArrayList<Specimen>>() ;
		for (String partitionName : partitionNames) {
			partitions.put(partitionName, new ArrayList<Specimen>()) ;
		}
		return partitions ;
	}
	
	public ArrayList<Specimen> getUnPartitionedSamples() {
		return unPartitionedSamples;
	}

	public void setUnPartitionedSamples(ArrayList<Specimen> unPartitionedSamples) {
		this.unPartitionedSamples = unPartitionedSamples;
	}
	
	public ArrayList<Specimen> getPartition(String partitionName) {
		return this.partitionedSamples.get(partitionName) ;
	}

	public String[] getPartitionNames() {
		return partitionNames;
	}

	public void setPartitionNames(String[] partitionNames) {
		this.partitionNames = partitionNames;
	}
	
	
}
