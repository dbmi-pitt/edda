package edu.pitt.dbmi.edda.rulebase.regression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import edu.pitt.dbmi.edda.rulebase.document.Citation;
import edu.pitt.dbmi.edda.rulebase.pico.PicoEvidence;

public class Instance {
	
	private Citation citation;
	
	private double y = 0.0d;
	private double hTheta = 0.0d;
	private double error = 0.0d;
	
	private final TreeSet<String> terms = new TreeSet<String>();
	private final HashMap<String, Theta> thetas = new HashMap<String, Theta>();

	private final double presentFactor = 10.0d;
	private final double missingFactor = 0.01d;
	
	public Instance() {
		;
	}
	
	public void initialize() {
		citation.cacheContent();
		citation.iterateEvidence();
		PicoEvidence evidence = citation.nextPicoEvidence();
		while (evidence != null) {
			if (evidence.getAncestryDepth() == 0) {
				terms.add(evidence.getPicoTerm());
			}
			evidence = citation.nextPicoEvidence();
		}
		String actualClassification = citation.getActualClassification();
		if (actualClassification.equals("include")) {
			setY(1.0d);
		}
		else {
			setY(0.0d);
		}
	}

	public void setCitation(Citation citation) {
		this.citation = citation;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void setThetas(HashMap<String, Theta> newThetas) {
		thetas.clear();
		thetas.putAll(newThetas);
	}
	
	public double calculateMarginalCost() {
		hTheta = calculateHtheta();
		error = hTheta - getY();
		return (getY() * zeroSafeLog(hTheta)) + ((1.0d - getY()) *  zeroSafeLog(1.0d - hTheta));
	}
	
	private double zeroSafeLog(double x) {
		return (x <= 0.0d) ? 0.0d : Math.log(x); 
	}
	
	public double getMarginalGradient(Theta theta) {
		return (terms.contains(theta.getTerm())) ? error : 0.0d;
	}
	
	public double calculateHtheta() {
		double thetaSum = 0.0d;
		for (Theta theta : thetas.values()) {
			if (terms.contains(theta.getTerm())) {
				thetaSum += presentFactor * theta.getValue();
			}
			else {
				thetaSum += missingFactor * theta.getValue();
			}
		}
		return sigmoid(thetaSum);
	}
	
	public double calculateHthetaOriginal() {
		double thetaSum = 0.0d;
		for (String term : terms) {
			Theta theta = thetas.get(term);
			thetaSum = (theta != null) ? thetaSum + theta.getValue() : thetaSum;
		}
		return sigmoid(thetaSum);
	}
	
	private double sigmoid(double x) {
		return 1.0d / (1.0d + Math.exp(-x));
	}
	
	public ArrayList<String> getTerms() {
		final ArrayList<String> sortedTerms = new ArrayList<String>();
		sortedTerms.addAll(terms);
		return sortedTerms;
	}
	

}
