package edu.pitt.dbmi.edda.operator.ldaop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import java.util.logging.Logger;

import cc.mallet.pipe.Pipe;
import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.IDSorter;
import cc.mallet.types.Instance;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.learner.SimpleBinaryPredictionModel;

public class TopicModelAdapter extends SimpleBinaryPredictionModel {

	private static final long serialVersionUID = 7307611030011692827L;

	private ParallelTopicModel parallelTopicModel;
	
	private Pipe pipe;
	
	private static final Logger logger = Logger
			.getLogger(TopicModelAdapter.class.getPackage().getName());

	private int numberOfRows = 0;
	private int numberOfCols = 0;
	private double excludeCount = 0.0d;
	private double includeCount = 0.0d;
	private double[] medianExcludeProbabilities;
	private double[] medianIncludeProbabilities;
	private double[] averageExcludeProbabilities;
	private double[] averageIncludeProbabilities;

	private Attribute labelAttribute;

	private int numberMostProbableWordsForDisplay;

	public TopicModelAdapter(ParallelTopicModel parallelTopicModel,
			ExampleSet trainingSet) {
		super(trainingSet, 0.5d);
		
		logger.fine("Constructing a TopicModelAdapter");

		labelAttribute = trainingSet.getAttributes().getLabel();

		this.parallelTopicModel = parallelTopicModel;

		numberOfRows = parallelTopicModel.getData().size();
		numberOfCols = parallelTopicModel.getNumTopics();
		
		calculateAverageDivergences();
		
		calculateMediumDivergences();
		
	}
	
	private void calculateMediumDivergences() {
		
		int excludeRows = (int) excludeCount; // calculated for averages
		int includeRows = (int) includeCount;
		
		medianExcludeProbabilities = calculateMedians("exclude", excludeRows);
		medianIncludeProbabilities = calculateMedians("include", includeRows);
		
		displayVector("Median exclude probs", medianExcludeProbabilities);
		displayVector("Median include probs", medianIncludeProbabilities);
		
	}
	
	private double[] calculateMedians(String targetLabel, int targetRows) {
		final ArrayList<ArrayList<Double>> targetFilteredMatrix = createTargetFilteredMatrix(targetRows) ;
		TopicInferencer inferencer = parallelTopicModel.getInferencer();
		int targetRow = 0;
		for (int row = 0; row < numberOfRows; row++) {
			Instance instance = parallelTopicModel.getData().get(row).instance;
			String label = instance.getTarget().toString();
			if (label.equals(targetLabel)) {
				final double[] topicProbs = TopicModelUtils
						.inferTopicForInstance(inferencer, instance, false);
				for (int col = 0; col < numberOfCols; col++) {
					targetFilteredMatrix.get(col).set(targetRow, new Double(topicProbs[col]));
				}
				targetRow++;
			}
		}
		final double[] resultMedians = new double[numberOfCols];
		for (int col = 0; col < numberOfCols; col++) {
			 resultMedians[col] = median(targetFilteredMatrix.get(col));
		}
		return resultMedians;
	}
	
	private ArrayList<ArrayList<Double>> createTargetFilteredMatrix(int targetRows) {
		final ArrayList<ArrayList<Double>> targetFilteredMatrix = new ArrayList<ArrayList<Double>>(numberOfCols);
		for (int col = 0; col < numberOfCols; col++) {
			targetFilteredMatrix.add(makeZeroList(targetRows));
		}
		return targetFilteredMatrix;
		
	}

	private ArrayList<Double> makeZeroList(int size) {
		final ArrayList<Double> zeros = new ArrayList<Double>();
		for (int idx = 0; idx < size; idx++) {
			zeros.add(new Double(0.0d));
		}
		return zeros;
	}
	
	@SuppressWarnings("unused")
	private int countRowsWithLabel(String targetLabel) {
		int numberOfInstancesWithLabel = 0;
		int numberOfRows = parallelTopicModel.getData().size();
		for (int row = 0; row < numberOfRows; row++) {
			Instance instance = parallelTopicModel.getData().get(row).instance;
			String label = instance.getTarget().toString();
			if (label.equals(targetLabel)) {
				numberOfInstancesWithLabel++;
			}
		}
		return numberOfInstancesWithLabel;
	}
	
	@SuppressWarnings("unused")
	private double calculateMedian(int col, String targetLabel) {
		TreeSet<IDSorter> sortedRowValuesInColumn = new TreeSet<IDSorter>();
		int numberOfRows = parallelTopicModel.getData().size();
		for (int row = 0; row < numberOfRows; row++) {
			Instance instance = parallelTopicModel.getData().get(row).instance;
			String label = instance.getTarget().toString();
			if (label.equals(targetLabel)) {
				TopicInferencer inferencer = parallelTopicModel.getInferencer();
				final double[] topicProbs = TopicModelUtils
						.inferTopicForInstance(inferencer, instance, false);
				IDSorter colValue = new IDSorter(
						sortedRowValuesInColumn.size(), topicProbs[col]);
				sortedRowValuesInColumn.add(colValue);
			}
		}
		return median(toArray(sortedRowValuesInColumn));
	}

	private double median(double[] data) {
		if (data.length % 2 == 0) {
			return (data[(data.length / 2) - 1] + data[data.length / 2]) / 2.0;
		} else {
			return data[data.length / 2];
		}
	}
	
	private double median(ArrayList<Double> data) {
		Collections.sort(data);
		if (data.size() % 2 == 0) {
			double lowBoundary = data.get((data.size() / 2) - 1);
			double highBoundary = data.get(data.size() / 2) ;
			return (lowBoundary + highBoundary) / 2.0;
		} else {
			return data.get(data.size() / 2);
		}
	}
	
	private double[] toArray(TreeSet<IDSorter> sortedValues) {
		final double[] result = new double[sortedValues.size()];
		int idx = 0;
		for (IDSorter idSorter : sortedValues) {
			result[idx++] = idSorter.getWeight();
		}
		return result;
	}
	
	private void calculateAverageDivergences() {
	
		averageExcludeProbabilities = new double[numberOfCols];
		averageIncludeProbabilities = new double[numberOfCols];

		for (int row = 0; row < numberOfRows; row++) {
			TopicInferencer inferencer = parallelTopicModel.getInferencer();
			Instance instance = parallelTopicModel.getData().get(row).instance;
			final double[] topicProbs = TopicModelUtils.inferTopicForInstance(
					inferencer, instance, false);
			String label = instance.getTarget().toString();
			if (label.startsWith("e")) {
				for (int col = 0; col < numberOfCols; col++) {
					averageExcludeProbabilities[col] += topicProbs[col];
				}
				excludeCount += 1.0d;
			} else {
				for (int col = 0; col < numberOfCols; col++) {
					averageIncludeProbabilities[col] += topicProbs[col];
				}
				includeCount += 1.0d;
			}
		}

		for (int col = 0; col < numberOfCols; col++) {
			averageExcludeProbabilities[col] /= excludeCount;
			averageIncludeProbabilities[col] /= includeCount;
		}

		displayVector("Average exclude probs", averageExcludeProbabilities);
		displayVector("Average include probs", averageIncludeProbabilities);
	}
	
	

	private void displayVector(String name, double[] v) {
		StringBuffer sb = new StringBuffer();
		sb.append(name + ":");
		for (int idx = 0; idx < v.length; idx++) {
			sb.append(v[idx] + ", ");
		}
		sb.append("\n");
		logger.fine(sb.toString());

	}

	public ParallelTopicModel getParallelTopicModel() {
		return parallelTopicModel;
	}
	
	private double[] extractTopicProbsFromExample(Example example) {
		double[] topicProbs = new double[numberOfCols];
		int col = 0;
		String nextAttributeName = TopicModelUtils.buildColumnNameForTopic(col);
		for (Attribute attribute : example.getAttributes()) {
			String attributeName = attribute.getName();
			if (attributeName.equals(nextAttributeName)) {
				double value = example.getValue(attribute);
				topicProbs[col] = value;
				col++;
				nextAttributeName = TopicModelUtils
						.buildColumnNameForTopic(col);
			}
		}
		return topicProbs;
	}

	public double predictWithKlDivergenceAgainstMeans(Example example) throws OperatorException {
		double[] topicProbs = extractTopicProbsFromExample(example);
		displayVector(pullLabelFromExample(example), topicProbs);
		double excludeDistance = calculateDistance(topicProbs,
				averageExcludeProbabilities);
		double includeDistance = calculateDistance(topicProbs,
				averageIncludeProbabilities);
		double result = (excludeDistance < includeDistance) ? 0.0d : 1.0d;
		String nominalResult = (excludeDistance < includeDistance) ? "EXCLUDE" : "INCLUDE";
		logger.fine("\n\tExclude Distance: " + excludeDistance);
		logger.fine("\n\tInclude Distance: " + includeDistance);
		logger.fine("\n\tResult: " + nominalResult);
		return result;
	}
	
	@Override
	public double predict(Example example) throws OperatorException {
		double[] topicProbs = extractTopicProbsFromExample(example);
		displayVector(pullLabelFromExample(example), topicProbs);
		double excludeDistance = calculateExcludeDistance(topicProbs);
		double includeDistance = calculateIncludeDistance(topicProbs);
		double result = (excludeDistance < includeDistance) ? 0.0d : 1.0d;
		String nominalResult = (excludeDistance < includeDistance) ? "EXCLUDE" : "INCLUDE";
		logger.fine("\n\tExclude Distance: " + excludeDistance);
		logger.fine("\n\tInclude Distance: " + includeDistance);
		logger.fine("\n\tResult: " + nominalResult);
		return result;

	}

	private String pullLabelFromExample(Example example) {
		String label = "unknown";
		try {
			label = example.getNominalValue(labelAttribute);
		} catch (Exception x) {
			;
		}
		return label;
	}
	
	public double getExcludeDistance(Example example) {
		double[] topicProbs = extractTopicProbsFromExample(example);
		return calculateExcludeDistance(topicProbs);
	}
	
	public double getIncludeDistance(Example example) {
		double[] topicProbs = extractTopicProbsFromExample(example);
		return calculateIncludeDistance(topicProbs);
	}
	
	public double calculateIncludeDistance(double[] testProbabilities) {
		return CalculationsKullbackLeibler
				.tryCalculateSymmetricKullbackLeiblerDivergence(
						testProbabilities, medianIncludeProbabilities);
	}


	public double calculateExcludeDistance(double[] testProbabilities) {
		return CalculationsKullbackLeibler
				.tryCalculateSymmetricKullbackLeiblerDivergence(
						testProbabilities, medianExcludeProbabilities);
	}

	private double calculateDistance(double[] a, double[] b) {
		double distance = 0.0d;
		for (int col = 0; col < a.length; col++) {
			double t1 = a[col] - b[col];
			double t2 = t1 * t1;
			distance += t2;
		}
		distance = Math.sqrt(distance);
		return distance;
	}

	public void setNumberMostProbableWordsForDisplay(
			int numberMostProbableWordsForDisplay) {
		logger.fine("Entering setNumberMostProbableWordsForDisplay: " + numberMostProbableWordsForDisplay) ;
		this.numberMostProbableWordsForDisplay = numberMostProbableWordsForDisplay;
		if (parallelTopicModel != null) {
			int alphabetSize = parallelTopicModel.getAlphabet().size();
			this.numberMostProbableWordsForDisplay = Math.min(numberMostProbableWordsForDisplay, alphabetSize);
		}
		logger.fine("Existing setNumberMostProbableWordsForDisplay: " + this.numberMostProbableWordsForDisplay) ;
	}
	
	public int getNumberMostProbableWordsForDisplay() {
		return numberMostProbableWordsForDisplay;
	}

	public Pipe getPipe() {
		return pipe;
	}

	public void setPipe(Pipe pipe) {
		this.pipe = pipe;
	}
	
	
	
}
