package edu.pitt.dbmi.edda.operator.c45bayes.bayes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Gene;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Specimen;

public class ClsPriorProbabilityCalculator {
	
	private String clsName;

	private double probability;
	
	private HashSet<Gene> features;
	
	private HashMap<String, FeaturePosteriorProbabilityCalculator> fCalcs = new HashMap<String, FeaturePosteriorProbabilityCalculator>() ;
		
	public ClsPriorProbabilityCalculator() {
		;
	}
	
	public void train(ArrayList<Specimen> trainingSamples) {
		for (Gene feature : features) {
			FeaturePosteriorProbabilityCalculator fCalc = new FeaturePosteriorProbabilityCalculator() ;
			fCalc.setClsName(clsName);
			fCalcs.put(feature.getName(), fCalc) ;
			fCalc.setFeature(feature) ;
			fCalc.setSamples(trainingSamples) ;
			fCalc.train();
		}
	}
	
	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	public void setFeatures(HashSet<Gene> features) {
		this.features = features ;
		
	}

	public double calculateProbabilityFor(Specimen sample) {
		double probability = getProbability() ;
		for (FeaturePosteriorProbabilityCalculator fCalc : fCalcs.values()) {
			probability *= fCalc.calculateProbability(sample) ;
		}
		return probability;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Pr( " + clsName + " ) = " + probability);
		sb.append("\n");
		for (FeaturePosteriorProbabilityCalculator fCalc : fCalcs.values()) {
			sb.append("\t"  + fCalc.toString() + "\n");
		}
		return sb.toString();
	}
	
}
