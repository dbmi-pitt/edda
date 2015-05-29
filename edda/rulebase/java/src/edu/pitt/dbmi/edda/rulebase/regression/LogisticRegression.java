package edu.pitt.dbmi.edda.rulebase.regression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

import edu.pitt.dbmi.edda.rulebase.Experiment;
import edu.pitt.dbmi.edda.rulebase.Identifiable;
import edu.pitt.dbmi.edda.rulebase.ReferenceFilerCacher;
import edu.pitt.dbmi.edda.rulebase.SystematicReviewReader;
import edu.pitt.dbmi.edda.rulebase.document.Citation;

public class LogisticRegression {

	private final HashMap<String, Theta> mappedThetas = new HashMap<String, Theta>();

	private TreeSet<Theta> increasingThetas = new TreeSet<Theta>(
			new Comparator<Theta>() {
				@Override
				public int compare(Theta arg0, Theta arg1) {
					return (arg0.getImpact() <= arg1.getImpact()) ? -1 : 1;
				}
			});

	private Collection<Citation> citations = null;

	private ArrayList<Instance> instances = new ArrayList<Instance>();

	private final Random randomGenerator = new Random(1024);

	private double totalIncludes = 0.0d;
	private double totalExcludes = 0.0d;

	private int igCutOff = 40;

	private double cost = Double.MAX_VALUE;

	private double learningRate = 0.05;

	private int iteration = 0;

	private double costSimilarityThreshold = 0.0001;
	private int maxIterationThreshold = 2000;

	public static void main(String[] args) {
		SystematicReviewReader srReader = new SystematicReviewReader();
		srReader.pullSrAndCitations(true);
		final ArrayList<Citation> testingCitations = new ArrayList<Citation>();
		final ArrayList<Citation> trainingCitations = new ArrayList<Citation>();
		final ArrayList<Citation> includes = new ArrayList<Citation>();
		final ArrayList<Citation> excludes = new ArrayList<Citation>();
		while (true) {
			Identifiable identifiable = srReader.nextIdentifiable();
			if (identifiable == null) {
				break;
			} else if (identifiable instanceof Citation) {
				Citation citation = (Citation) identifiable;
				testingCitations.add(citation);
				if (citation.getActualClassification().equals("include")
						&& includes.size() < 200) {
					includes.add(citation);
				}
				if (citation.getActualClassification().equals("exclude")
						&& excludes.size() < 200) {
					excludes.add(citation);
				}
			}
		}
		trainingCitations.clear();
		trainingCitations.addAll(includes);
		trainingCitations.addAll(excludes);
		LogisticRegression logisticRegression = new LogisticRegression();
		logisticRegression.setCitations(trainingCitations);
		logisticRegression.train();
	
		ReferenceFilerCacher testSetCacher = new ReferenceFilerCacher();
		testSetCacher.setSystematicReview(srReader.getSystematicReview());
		testSetCacher.setPicoManager(srReader.getPicoManager());
		testSetCacher.useTestingData();
		testSetCacher.cache();
		
		Experiment experiment = new Experiment();
		
		int citationsClassified = 0;
		for (Citation citation : testingCitations) {
			if (citationsClassified % 50 == 0) {
				System.out.println("Classifying citation #" + citation.getId());
				logisticRegression.classify(citation);
				experiment.tallyCitation(citation);
			}
			citationsClassified++;
		}
		System.out.println(experiment);
	}

	public LogisticRegression() {
	}

	public void train() {
		System.out.println("Logistic Regression: Performing IG Pruning..");
		igPrune();

		System.out
				.println("Logistic Regression: Performing Logistic Gradient Descent..");
		boolean isDiverged = false;
		double nextCost = calculateCost();
		while (!isDiverged && iteration < getMaxIterationThreshold()) {
			if (iteration % 100 == 0) {
				System.out.println("Iteration " + iteration + " (" + cost
						+ ", " + nextCost + ") ==> " + isDiverged);
			}
			isDiverged = checkCostDivergence(cost, nextCost);
			adjustThetas();
			cost = nextCost;
			nextCost = calculateCost();
			iteration++;
		}

		reportThetas();
	}

	private void classify(Citation citation) {
		Instance instance = new Instance();
		instance.setCitation(citation);
		instance.initialize();
		instance.setThetas(mappedThetas);
		double hTheta = instance.calculateHtheta();
		if (hTheta > 0.5d) {
			citation.setPredictedClassification("include");
		} else {
			citation.setPredictedClassification("exclude");
		}
	}

	private boolean checkCostDivergence(double costOne, double costTwo) {
		boolean result = Math.abs(costOne - costTwo) < getCostSimilarityThreshold();
		return result;
	}

	private void adjustThetas() {
		for (Theta theta : mappedThetas.values()) {
			double partialWrtTheta = 0.0d;
			double m = 0.0d;
			for (Instance instance : instances) {
				partialWrtTheta += instance.getMarginalGradient(theta);
				m += 1.0d;
			}
			theta.setValue(theta.getValue()
					- (learningRate * (partialWrtTheta / m)));
		}
	}

	private double calculateCost() {
		double costAccumulator = 0.0d;
		double m = 0.0d;
		for (Instance instance : instances) {
			instance.setThetas(mappedThetas);
			costAccumulator += instance.calculateMarginalCost();
			m += 1.0d;
		}
		return -(costAccumulator / m);
	}

	private void igPrune() {
		initializeInstances();
		System.out.println("Finished initializing instances");
		totalIncludesAndExcludes();
		System.out.println("Finished totaling incs: " + totalIncludes
				+ " excs: " + totalExcludes);
		initializeThetas();
		System.out.println("Finished initializing thetas");
		pruneThetas();
		System.out.println("Finished pruning thetas");
	}

	private void reportThetas() {
		for (Theta theta : mappedThetas.values()) {
			System.out.println(theta);
		}
	}

	private void initializeInstances() {
		for (Citation citation : citations) {
			Instance instance = new Instance();
			instance.setCitation(citation);
			instance.initialize();
			instances.add(instance);
			if (instances.size() % 100 == 0) {
				System.out.println("Generated " + instances.size()
						+ " instances");
			}
		}
	}

	private void initializeThetas() {
		for (Instance instance : instances) {
			for (String term : instance.getTerms()) {
				if (mappedThetas.get(term) == null) {
					Theta theta = new Theta();
					theta.setTerm(term);
					theta.setValue(randomGenerator.nextDouble());
					mappedThetas.put(term, theta);
				}
				Theta theta = mappedThetas.get(term);
				if (instance.getY() > 0.0d) {
					theta.incrementIncludes();
				} else {
					theta.incrementExcludes();
				}
			}
		}
	}

	private void pruneThetas() {
		for (Theta theta : mappedThetas.values()) {
			theta.setTotalIncludes(totalIncludes);
			theta.setTotalExcludes(totalExcludes);
			theta.calculate();
		}
		increasingThetas.addAll(mappedThetas.values());
		mappedThetas.clear();
		for (Iterator<Theta> iterator = increasingThetas.iterator(); iterator
				.hasNext();) {
			Theta theta = iterator.next();
			mappedThetas.put(theta.getTerm(), theta);
			if (mappedThetas.size() > igCutOff) {
				break;
			}
		}
		// for (Iterator<Theta> iterator =
		// decreasingThetas.descendingIterator(); iterator
		// .hasNext();) {
		// Theta theta = iterator.next();
		// mappedThetas.put(theta.getTerm(), theta);
		// if (mappedThetas.size() > igCutOff) {
		// break;
		// }
		// }
	}

	private void totalIncludesAndExcludes() {
		for (Instance instance : instances) {
			if (instance.getY() > 0.0d) {
				totalIncludes = totalIncludes + 1.0d;
			} else {
				totalExcludes = totalExcludes + 1.0d;
			}
		}
	}

	public void addCitation(Citation citation) {
		citations.add(citation);
	}

	public void setCitations(Collection<Citation> citations) {
		this.citations = citations;
	}

	public void clearCitations() {
		citations.clear();
	}

	public double getCostSimilarityThreshold() {
		return costSimilarityThreshold;
	}

	public void setCostSimilarityThreshold(double costSimilarityThreshold) {
		this.costSimilarityThreshold = costSimilarityThreshold;
	}

	public int getMaxIterationThreshold() {
		return maxIterationThreshold;
	}

	public void setMaxIterationThreshold(int maxIterationThreshold) {
		this.maxIterationThreshold = maxIterationThreshold;
	}

}
