package edu.pitt.dbmi.edda.rulebase.regression;

import java.io.Serializable;

public class Theta implements Comparable<Theta>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String term;
	private double value = 0.0d;
	private double includes = 0.0d;
	private double excludes = 0.0d;
	private double totalIncludes = 0.0d;
	private double totalExcludes = 0.0d;
	private double includeRatio = 0.0d;
	private double excludeRatio = 0.0d;
	private double impact = 0.0d;
	
	public static void main(String[] args) {
		double[] freqs = new double[3];
		freqs[0] = 4;
		freqs[1] = 3;
		freqs[2] = 3;
		Theta theta = new Theta();
		double entropy = theta.computeEntropy(freqs);
		System.out.println(entropy);
	}
	
	public Theta() {
		;
	}
	
	public void calculate() {
		// Fudge factor is no longer used
		includeRatio = (totalIncludes > 0.0d) ? includes / totalIncludes : 0.0d;
		excludeRatio = (totalExcludes > 0.0d) ? excludes / totalExcludes : 0.0d;
		setImpact(includeRatio - excludeRatio);
		
		// Use InfoGain instead
		setImpact(computeInformationGain());
	}
	
	private double computeInformationGain() {
		
		double ig = 0.0d;
	
		// Entropy total
		double[] freqs = new double[2];
		freqs[0] = totalIncludes;
		freqs[1] = totalExcludes;
		double eTotal = computeEntropy(freqs);
		
		// Theta = "present"
		double total = totalIncludes + totalExcludes;
		double thetaPresentIncludes = includes;
		double thetaPresentExcludes = excludes;
		double thetaPresentTotal = thetaPresentIncludes + thetaPresentExcludes;
		double thetaPresentPercent = thetaPresentTotal / total;
		freqs[0] = thetaPresentIncludes;
		freqs[1] = thetaPresentExcludes;
		double thetaPresentEntropy = computeEntropy(freqs);
		
		// Theta = "missing"
		double thetaMissingIncludes = totalIncludes - includes;
		double thetaMissingExcludes = totalExcludes - excludes;
		double thetaMissingTotal = thetaMissingIncludes + thetaMissingExcludes;
		double thetaMissingPercent = thetaMissingTotal / total;
		freqs[0] = thetaMissingIncludes;
		freqs[1] = thetaPresentExcludes;
		double thetaMissingEntropy = computeEntropy(freqs);
		
		ig = eTotal;
		ig -= thetaPresentPercent * thetaPresentEntropy;
		ig -= thetaMissingPercent * thetaMissingEntropy;
		return ig;
	}
	
	private double computeEntropy(double[] freqs) {
		double entropy = 0.0;
		double t = 0.0d;
		for (double f : freqs) {
			t += f;
		}
		if (t > 0.0d) {			
			for (double f : freqs) {
				if (f == 0) continue;
				double p = f/t;
				entropy -= p * log2(p);
			}
		}
		return entropy;
	}
	
	private double log2(double num) {
		return (Math.log(num)/Math.log(2));
	} 
	

	@Override
	public int compareTo(Theta o) {
		return getTerm().compareTo(o.getTerm());
	}


	public double getExcludes() {
		return excludes;
	}

	public void setExcludes(double excludes) {
		this.excludes = excludes;
	}

	public double getIncludes() {
		return includes;
	}

	public void setIncludes(double includes) {
		this.includes = includes;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public void incrementIncludes() {
		includes = includes + 1;
	}
	
	public void incrementExcludes() {
		excludes = excludes + 1;
	}

	public double getTotalIncludes() {
		return totalIncludes;
	}

	public void setTotalIncludes(double totalIncludes) {
		this.totalIncludes = totalIncludes;
	}

	public double getTotalExcludes() {
		return totalExcludes;
	}

	public void setTotalExcludes(double totalExcludes) {
		this.totalExcludes = totalExcludes;
	}

	public double getImpact() {
		return impact;
	}

	public void setImpact(double impact) {
		this.impact = impact;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName() + ":\n");
		sb.append("\tterm = " + getTerm() + "\n");
		sb.append("\timpact = " + getImpact() + "\n");
		sb.append("\tvalue = " + getValue());
		return sb.toString();		
	}
	
	

}
