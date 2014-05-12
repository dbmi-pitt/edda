package edu.pitt.dbmi.edda.operator.ldaop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import cc.mallet.pipe.CharSequence2TokenSequence;
import cc.mallet.pipe.Input2CharSequence;
import cc.mallet.pipe.Pipe;
import cc.mallet.pipe.PrintInputAndTarget;
import cc.mallet.pipe.SerialPipes;
import cc.mallet.pipe.Target2Label;
import cc.mallet.pipe.TokenSequence2FeatureSequence;
import cc.mallet.topics.DMRTopicModel;
import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.Instance;
import cc.mallet.types.InstanceList;
import cc.mallet.types.Label;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.OperatorException;

public class TopicModelWorker {
	
	private final static Logger logger = Logger.getLogger(TopicModelWorker.class .getName()); 
	
	private ExampleSet inputExampleSet;

	private List<String[]> labelDirectoryPairs;

	private InstanceList instances;
	
	private TopicModelAdapter topicModelAdapter;
	
	private ParallelTopicModel topicModel;
	
	private int numTopics = 10;
	
	private double alpha = 1.0;
	
	private double beta = 0.01;
	
	private int numberOfIterations = 5000;
	
	private int burnInPeriod = 500;
	
	private int numberOfThreads = 1;
	
	private int randomSeed = 10;
	
	private int optimizeInterval = 10;
	
	private boolean isSymmetricAlpha = true;
	
	private int temperingInterval = 0;
	
	private int inferencerIterations = 0;
	
	private int inferencerThinning = 0;
	
	private int inferencerBurnInPeriod = 0;

	private ExampleSet outgoingExampleSet;
	
	private boolean isOutputingDocumentThetas = true;
	
	private boolean isOutputingKulbachLeiblerDivergences = false;
	
	private int numberMostProbableWordsForDisplay = 10;

	private boolean isGeneratingDiagnostics = false;

	public static void main(String args[]) {
		new TopicModelWorker();
	}

	public TopicModelWorker() {
	}
	
	public void process() throws OperatorException {
		
		try {

			establishTopicModelAdapter();
		
			generateOutgoingExampleSet();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void establishTopicModelAdapter() throws IOException {
		if (topicModelAdapter == null) {
			topicModelAdapter = buildTopicModelAdapter();
		}
		else {
			topicModel = topicModelAdapter.getParallelTopicModel();
			instances = generateInstances(topicModelAdapter.getPipe());
		}
	}
	
	private void generateOutgoingExampleSet() {
		if (isOutputingDocumentThetas() && isOutputingKulbachLeiblerDivergences()) {
			AttributeBuilder attributeBuilder = new AttributeBuilderBoth();
			attributeBuilder.setTopicModelAdapter(topicModelAdapter);
			outgoingExampleSet = buildExampleSet(attributeBuilder);
		}
		else if (isOutputingDocumentThetas()) {
			AttributeBuilder attributeBuilder = new AttributeBuilderThetas();
			attributeBuilder.setTopicModelAdapter(topicModelAdapter);
			outgoingExampleSet = buildExampleSet(attributeBuilder);
		}
		else if (isOutputingKulbachLeiblerDivergences) {
			AttributeBuilder attributeBuilder = new AttributeBuilderKulbackLeibler();
			attributeBuilder.setTopicModelAdapter(topicModelAdapter);
			outgoingExampleSet = buildExampleSet(attributeBuilder);
		} 
	}
	
	private TopicModelAdapter buildTopicModelAdapter() throws IOException {
		Pipe pipe = buildPipe();
		instances = generateInstances(pipe);
		topicModel = buildModel();
		topicModel.addInstances(instances);
		topicModel.estimate();
		displayAveragesAcrossLabels();
		
		AttributeBuilder attributeBuilder = new AttributeBuilderThetas();
		attributeBuilder.setTopicModel(topicModel);
		ExampleSet thetaExampleSet = buildExampleSet(attributeBuilder);
		TopicModelAdapter topicModelAdapter = new TopicModelAdapter(
				topicModel,
				thetaExampleSet);
		topicModelAdapter.setPipe(pipe);
		topicModelAdapter.setNumberMostProbableWordsForDisplay(getNumberMostProbableWordsForDisplay());
		return topicModelAdapter;
	}
	
	private ParallelTopicModel buildModel() {
		final ParallelTopicModel model = new ParallelTopicModel(getNumTopics(), alpha, beta);
		model.printLogLikelihood = false;
		model.setNumThreads(getNumberOfThreads());
		model.setNumIterations(getNumberOfIterations());
		model.setBurninPeriod(getBurnInPeriod());
		model.setRandomSeed(getRandomSeed());
		model.setOptimizeInterval(getOptimizeInterval());
		model.setSymmetricAlpha(isSymmetricAlpha());
		model.setTemperingInterval(getTemperingInterval());
		
		if (!isGeneratingDiagnostics()) {
			model.setTopicDisplay(0,0);
		}
		else {
			model.setTopicDisplay(getNumTopics(), getNumTopics());
		}
		
		return model;
	}
	
	private ExampleSet buildExampleSet(AttributeBuilder attributeBuilder) {
		attributeBuilder.setInstances(instances);
		attributeBuilder.setInferencerIterations(getInferencerIterations());
		attributeBuilder.setInferencerThinning(getInferencerThinning());
		attributeBuilder.setInferencerBurnInPeriod(getInferencerBurnInPeriod());
		attributeBuilder.setGeneratingDiagnostics(isGeneratingDiagnostics());
		attributeBuilder.createAttributes();
		return attributeBuilder.getExampleSet();
	}
	
	public Pipe buildPipe() {

		ArrayList<Pipe> pipeList = new ArrayList<Pipe>();

		// Read data from File objects
		pipeList.add(new Input2CharSequence("UTF-8"));

		// Regular expression for what constitutes a token.
		// This pattern includes Unicode letters, Unicode numbers,
		// and the underscore character. Alternatives:
		// "\\S+" (anything not whitespace)
		// "\\w+" ( A-Z, a-z, 0-9, _ )
		// "[\\p{L}\\p{N}_]+|[\\p{P}]+" (a group of only letters and numbers OR
		// a group of only punctuation marks)
		// "[\\p{L}\\p{N}_]+" letters, numbers and underscores
		// "\\p{L}{3,}" three or more letters.
		Pattern tokenPattern = Pattern.compile("\\S+");

		// Tokenize raw strings
		pipeList.add(new CharSequence2TokenSequence(tokenPattern));
		
		//
		// Remove tokens that contain non-alphabetic characters.
		//
		// pipeList.add(new TokenSequenceRemoveNonAlpha());

		// Normalize all tokens to all lowercase
		// pipeList.add(new TokenSequenceLowercase());

		// Remove stopwords from a standard English stoplist.
		// options: [case sensitive] [mark deletions]
		// pipeList.add(new TokenSequenceRemoveStopwords(false, false));
		
		// Rather than storing tokens as strings, convert
		// them to integers by looking them up in an alphabet.
		pipeList.add(new TokenSequence2FeatureSequence());

		// Do the same thing for the "target" field:
		// convert a class label string to a Label object,
		// which has an index in a Label alphabet.
		pipeList.add(new Target2Label());

		// Now convert the sequence of features to a sparse vector,
		// mapping feature IDs to counts.
		// This breaks the topic modeling.  Don't do it.
		// pipeList.add(new FeatureSequence2FeatureVector());

		// Print out the features and the label
		if (isGeneratingDiagnostics()) {
			pipeList.add(new PrintInputAndTarget());
		}
		
		return new SerialPipes(pipeList);
	}


	private void displayAveragesAcrossLabels() {
		double totalExcludes = 0.0d;
		double totalIncludes = 0.0d;
		final double[] runningAverageExcludes = new double[topicModel.getNumTopics()];
		final double[] runningAverageIncludes = new double[topicModel.getNumTopics()];
		int documentIndex = 0;
		for (Instance instance : instances) {
			Label clsLabel = (Label) instance.getTarget();
			String clsLabelString = clsLabel.toString();
			if (clsLabelString.equals("exclude")) {
				totalExcludes += 1.0d;
				double[] topicDistribution = topicModel.getTopicProbabilities(documentIndex);
				for (int topicIndex = 0; topicIndex < topicModel.getNumTopics(); topicIndex++) {
					runningAverageExcludes[topicIndex] += topicDistribution[topicIndex];
				}
			}
			else if (clsLabelString.equals("include")) {
				totalIncludes += 1.0d;
				double[] topicDistribution = topicModel.getTopicProbabilities(documentIndex);
				for (int topicIndex = 0; topicIndex < topicModel.getNumTopics(); topicIndex++) {
					runningAverageIncludes[topicIndex] += topicDistribution[topicIndex];
				}
			}
			documentIndex++;
			
		}
		
		for (int topicIndex = 0; topicIndex < topicModel.getNumTopics(); topicIndex++) {
			runningAverageExcludes[topicIndex] /= totalExcludes;
		}
		
		Formatter out = new Formatter(new StringBuilder(), Locale.US);
		out.format("Average Topic Probabilities over %s class\n", "exclude");
		for (int topicIndex = 0; topicIndex < topicModel.getNumTopics(); topicIndex++) {
			out.format("%.3f ", runningAverageExcludes[topicIndex] );
		}
		logger.fine(out.toString());
		
		for (int topicIndex = 0; topicIndex < topicModel.getNumTopics(); topicIndex++) {
			runningAverageIncludes[topicIndex] /= totalIncludes;
		}
		
		out = new Formatter(new StringBuilder(), Locale.US);
		out.format("Average Topic Probabilities over %s class\n", "include");
		for (int topicIndex = 0; topicIndex < topicModel.getNumTopics(); topicIndex++) {
			out.format("%.3f ", runningAverageIncludes[topicIndex] );
		}
		logger.fine(out.toString());
		
	}
	
	public InstanceList generateInstances(Pipe pipe) {
		InstanceList result = null;
		if (inputExampleSet != null) {
			result = readExampleSet(pipe);
		}
		else {
			result = readDirectories(pipe);
		}
		return result;
	}

	public InstanceList readDirectories(Pipe pipe) {
		boolean isSortingDirectory = false;
		boolean isBalancingInstances = false;
		FileIterator iterator = new FileIterator(labelDirectoryPairs, isSortingDirectory, isBalancingInstances);
		InstanceList instances = new InstanceList(pipe);
		instances.addThruPipe(iterator);
		return instances;
	}
	
	public InstanceList readExampleSet(Pipe pipe) {
		ExampleSetIterator iterator = new ExampleSetIterator(inputExampleSet);
		InstanceList instances = new InstanceList(pipe);
		instances.addThruPipe(iterator);
		return instances;
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	private void estimateDirichletParameters(InstanceList training) {
		try {
			int numTopics = 10;
			DMRTopicModel dmr = new DMRTopicModel(numTopics);
			dmr.addInstances(training);
			dmr.estimate();
			dmr.writeParameters(new File("dmr.parameters"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ParallelTopicModel getTopicModel() {
		return topicModel;
	}

	public void setTopicModel(ParallelTopicModel parallelTopicModel) {
		this.topicModel = parallelTopicModel;
	}

	public boolean isGeneratingDiagnostics() {
		return isGeneratingDiagnostics;
	}

	public void setGeneratingDiagnostics(boolean isGeneratingDiagnostics) {
		this.isGeneratingDiagnostics = isGeneratingDiagnostics;
	}

	public List<String[]> getLabelDirectoryPairs() {
		return labelDirectoryPairs;
	}

	public void setLabelDirectoryPairs(List<String[]> labelDirectoryPairs) {
		this.labelDirectoryPairs = labelDirectoryPairs;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getBeta() {
		return beta;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public int getNumTopics() {
		return numTopics;
	}

	public void setNumTopics(int numTopics) {
		this.numTopics = numTopics;
	}

	public ExampleSet getOutgoingExampleSet() {
		return outgoingExampleSet;
	}

	public int getNumberMostProbableWordsForDisplay() {
		return numberMostProbableWordsForDisplay;
	}

	public void setNumberMostProbableWordsForDisplay(int numberMostProbableWordsForDisplay) {
		this.numberMostProbableWordsForDisplay = numberMostProbableWordsForDisplay;
	}

	public int getNumberOfIterations() {
		return numberOfIterations;
	}

	public void setNumberOfIterations(int numberOfIterations) {
		this.numberOfIterations = numberOfIterations;
	}

	public int getBurnInPeriod() {
		return burnInPeriod;
	}

	public void setBurnInPeriod(int burnInPeriod) {
		this.burnInPeriod = burnInPeriod;
	}

	public int getNumberOfThreads() {
		return numberOfThreads;
	}

	public void setNumberOfThreads(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}

	public boolean isOutputingDocumentThetas() {
		return isOutputingDocumentThetas;
	}

	public void setOutputingDocumentThetas(boolean isOutputingDocumentThetas) {
		this.isOutputingDocumentThetas = isOutputingDocumentThetas;
	}

	public boolean isOutputingKulbachLeiblerDivergences() {
		return isOutputingKulbachLeiblerDivergences;
	}

	public void setOutputingKulbachLeiblerDivergences(
			boolean isOutputingKulbachLeiblerDivergences) {
		this.isOutputingKulbachLeiblerDivergences = isOutputingKulbachLeiblerDivergences;
	}
	
	public TopicModelAdapter getTopicModelAdapter() {
		return topicModelAdapter;
	}

	public void setTopicModelAdapter(TopicModelAdapter topicModelAdapter) {
		this.topicModelAdapter = topicModelAdapter;
	}

	public int getOptimizeInterval() {
		return optimizeInterval;
	}

	public void setOptimizeInterval(int optimizeInterval) {
		this.optimizeInterval = optimizeInterval;
	}

	public int getRandomSeed() {
		return randomSeed;
	}

	public void setRandomSeed(int randomSeed) {
		this.randomSeed = randomSeed;
	}

	public boolean isSymmetricAlpha() {
		return isSymmetricAlpha;
	}

	public void setSymmetricAlpha(boolean isSymmetricAlpha) {
		this.isSymmetricAlpha = isSymmetricAlpha;
	}

	public int getTemperingInterval() {
		return temperingInterval;
	}

	public void setTemperingInterval(int temperingInterval) {
		this.temperingInterval = temperingInterval;
	}

	public int getInferencerIterations() {
		return inferencerIterations;
	}

	public void setInferencerIterations(int inferencerIterations) {
		this.inferencerIterations = inferencerIterations;
	}

	public int getInferencerThinning() {
		return inferencerThinning;
	}

	public void setInferencerThinning(int inferencerThinning) {
		this.inferencerThinning = inferencerThinning;
	}

	public int getInferencerBurnInPeriod() {
		return inferencerBurnInPeriod;
	}

	public void setInferencerBurnInPeriod(int inferencerBurnInPeriod) {
		this.inferencerBurnInPeriod = inferencerBurnInPeriod;
	}

	public void setInputExampleSet(ExampleSet inputExampleSet) {
		this.inputExampleSet = inputExampleSet;
	}


}
