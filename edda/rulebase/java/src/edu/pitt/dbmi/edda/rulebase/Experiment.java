package edu.pitt.dbmi.edda.rulebase;

import edu.pitt.dbmi.edda.rulebase.document.Citation;

public class Experiment extends Identifiable {

	private static final long serialVersionUID = 1L;

	private String trainingSetPartition = "train";
	private String testSetPartition = "test";
	private Integer truePositives = 0;
	private Integer falsePositives = 0;
	private Integer trueNegatives = 0;
	private Integer falseNegatives = 0;

	public static void main(String[] args) {
		Experiment e = new Experiment();
		System.out.println(e);
	}

	public String getTrainingSetPartition() {
		return trainingSetPartition;
	}

	public void setTrainingSetPartition(String trainingSetPartition) {
		this.trainingSetPartition = trainingSetPartition;
	}

	public String getTestSetPartition() {
		return testSetPartition;
	}

	public void setTestSetPartition(String testSetPartition) {
		this.testSetPartition = testSetPartition;
	}

	public Integer getTruePositives() {
		return truePositives;
	}

	public void setTruePositives(Integer truePositives) {
		this.truePositives = truePositives;
	}

	public Integer getFalsePositives() {
		return falsePositives;
	}

	public void setFalsePositives(Integer falsePositives) {
		this.falsePositives = falsePositives;
	}

	public Integer getTrueNegatives() {
		return trueNegatives;
	}

	public void setTrueNegatives(Integer trueNegatives) {
		this.trueNegatives = trueNegatives;
	}

	public Integer getFalseNegatives() {
		return falseNegatives;
	}

	public void setFalseNegatives(Integer falseNegatives) {
		this.falseNegatives = falseNegatives;
	}

	public void tallyCitation(Citation citation) {
		if (citation.getActualClassification().equals("include")
				&& citation.getPredictedClassification().equals("include")) {
			setTruePositives(new Integer(getTruePositives().intValue() + 1));
		} else if (citation.getActualClassification().equals("exclude")
				&& citation.getPredictedClassification().equals("include")) {
			setFalsePositives(new Integer(getFalsePositives().intValue() + 1));
		} else if (citation.getActualClassification().equals("include")
				&& citation.getPredictedClassification().equals("exclude")) {
			setFalseNegatives(new Integer(getFalseNegatives().intValue() + 1));
		} else if (citation.getActualClassification().equals("exclude")
				&& citation.getPredictedClassification().equals("exclude")) {
			setTrueNegatives(new Integer(getTrueNegatives().intValue() + 1));
		} else {
			System.out.println("Unexpected condition "
					+ citation.getActualClassification());
		}
	}
	
	public Double getPrecision() {
		double tp = truePositives.doubleValue();
		double fp = falsePositives.doubleValue();
		return (tp + fp > 0.0d) ? new Double(tp / (tp + fp)) : new Double(0.0d);
	}
	
	public Double getRecall() {
		double tp = truePositives.doubleValue();
		double fn = falseNegatives.doubleValue();
		return (tp + fn > 0.0d) ? new Double(tp / (tp + fn)) : new Double(0.0d);
	}

	public Double getSensitivity() {
		double tp = truePositives.doubleValue();
		double fn = falseNegatives.doubleValue();
		return (tp + fn > 0.0d) ? new Double(tp / (tp + fn)) : new Double(0.0d);
	}

	public Double getSpecificity() {
		double tn = trueNegatives.doubleValue();
		double fp = falsePositives.doubleValue();
		return (tn + fp > 0.0d) ? new Double(tn / (tn + fp)) : new Double(0.0d);
	}
	
	public Double getClassificationError() {
		double tn = trueNegatives.doubleValue();
		double fp = falsePositives.doubleValue();
		double tp = truePositives.doubleValue();
		double fn = falseNegatives.doubleValue();
		return (tp + fp + tn + fn > 0.0d) ? new Double((fp + fn) / (tp + fp + tn + fn)) : 0.0d ;
	}

	public String toString() {
		return String.format(
				"tp: %5d fp: %5d tn: %5d fn: %5d %n" + 
				"sens: %4.2f spec: %4.2f %n" +
				"prec: %4.2f reca: %4.2f %n" +
				"classificaton error: %4.2f",
				truePositives, falsePositives, trueNegatives, falseNegatives,
				getSensitivity(), getSpecificity(),
				getPrecision(), getRecall(),getClassificationError());
	}
}
