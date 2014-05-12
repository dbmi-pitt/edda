package edu.pitt.dbmi.edda.operator.c45bayes;

import java.util.HashSet;
import java.util.LinkedList;

import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.learner.SimpleBinaryPredictionModel;

import edu.pitt.dbmi.edda.operator.c45bayes.bayes.Classifier;
import edu.pitt.dbmi.edda.operator.c45bayes.c45.DecisionTreeNode;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Experiment;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Gene;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Specimen;
import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Well;

public class C45BayesModel extends SimpleBinaryPredictionModel {

	private static final long serialVersionUID = 1L;

	public static final String CONST_C45_BAYES_MODEL_CLS_INCLUDE = "include";
	public static final String CONST_C45_BAYES_MODEL_CLS_EXCLUDE = "exclude";

	public static final String CONST_C45_BAYES_MODEL_FTR_LOW = "Low";
	public static final String CONST_C45_BAYES_MODEL_FTR_AVG = "Average";
	public static final String CONST_C45_BAYES_MODEL_FTR_HGH = "High";

	public static final String[] clsOutcomes = {
			CONST_C45_BAYES_MODEL_CLS_INCLUDE,
			CONST_C45_BAYES_MODEL_CLS_EXCLUDE };

	public static final String[] featureOutcomes = {
			CONST_C45_BAYES_MODEL_FTR_LOW, CONST_C45_BAYES_MODEL_FTR_AVG,
			CONST_C45_BAYES_MODEL_FTR_HGH };

	private ExampleSet exampleSet;

	private double threshold;

	private Experiment experiment;

	private Classifier classifier;

	private final HashSet<Gene> highGainDiscriminators = new HashSet<Gene>();

	private int maximumNumberOfDiscriminatingFeatures = 15;

	public C45BayesModel(ExampleSet exampleSet, double threshold) {
		super(exampleSet, threshold);
		this.exampleSet = exampleSet;
		this.setThreshold(threshold);
	}

	public void train() {
		createExperiment();
		experiment.calculateWellStatitics();
		experiment.nominalizeWellsWithMeanCutoff();
		System.out.println("Experiment Information: \n" + experiment);
		buildPartialDecisionTree();
		displayDiscrimintingGenes();
		classifier = buildBayesianClassifier();
		classifier.train();
	}

	@Override
	public double predict(Example example) throws OperatorException {
		Specimen testSpecimen = experiment
				.buildSpecimenFromTestExample(example);
		experiment
				.nominalizeWellForSpecimenWithMeanCutoff(testSpecimen);
		StringBuffer sb = new StringBuffer();
		for (Gene gene : highGainDiscriminators) {
			Well well = experiment.findWellForGene(testSpecimen, gene);
			sb.append("[" + gene.getName() + " = " + well.getNominalValue() + "] ");
		}
		if (testSpecimen.getId()==11) {
			System.out.println("Looking at 11");
		}
		String predictionCls = classifier.classifyTestSpecimen(testSpecimen);
		String actualCls = testSpecimen.getOverAllOutcome();
		if (!actualCls.equals(predictionCls)) {
			System.out.println("Specimen #" + testSpecimen.getId() + " " + sb.toString() + " [actual = " + actualCls + "] [prediction is "
					+ predictionCls + "]");
		}
		if (predictionCls.equals(CONST_C45_BAYES_MODEL_CLS_EXCLUDE)) {
			return 0.0;
		} else if (predictionCls.equals(CONST_C45_BAYES_MODEL_CLS_INCLUDE)) {
			return 1.0;
		} else {
			throw new OperatorException(predictionCls + " is UNKOWN");
		}

	}

	private void createExperiment() {
		Experiment.clearInstance();
		experiment = Experiment.getInstance(exampleSet);
	}

	private void displayDiscrimintingGenes() {
		System.out.println("High Gain Discriminators Are: ");
		for (Gene gene : highGainDiscriminators) {
			System.out.println("\t" + gene.getName());
		}
	}

	private void buildPartialDecisionTree() {
		final LinkedList<DecisionTreeNode> breadthFirstSearchList = new LinkedList<DecisionTreeNode>();
		DecisionTreeNode rootNode = new DecisionTreeNode();
		rootNode.setExperiment(experiment);
		rootNode.setSamples(experiment.getSpecimens());
		breadthFirstSearchList.addLast(rootNode);
		while (true) {
			if (breadthFirstSearchList.isEmpty()) {
				break;
			} else if (highGainDiscriminators.size() > maximumNumberOfDiscriminatingFeatures) {
				break;
			} else {
				DecisionTreeNode currentNode = breadthFirstSearchList
						.removeFirst();
				currentNode.execute();
				if (currentNode.getHighGainFeature() != null) {
					highGainDiscriminators
							.add(currentNode.getHighGainFeature());
					for (DecisionTreeNode child : currentNode.getChildren()) {
						breadthFirstSearchList.addLast(child);
					}
				}
			}
		}
	}

	private Classifier buildBayesianClassifier() {
		final Classifier classifier = new Classifier();
		classifier.setExperiment(experiment);
		classifier.setFeatures(highGainDiscriminators);

		return classifier;
	}

	public String toString() {
		return classifier.toString();
	}

	public ExampleSet getExampleSet() {
		return exampleSet;
	}

	public void setExampleSet(ExampleSet exampleSet) {
		this.exampleSet = exampleSet;
	}

	public double getThreshold() {
		return threshold;
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	public int getMaximumNumberOfDiscriminatingFeatures() {
		return maximumNumberOfDiscriminatingFeatures;
	}

	public void setMaximumNumberOfDiscriminatingFeatures(
			int maximumNumberOfDiscriminatingFeatures) {
		this.maximumNumberOfDiscriminatingFeatures = maximumNumberOfDiscriminatingFeatures;
	}

}
