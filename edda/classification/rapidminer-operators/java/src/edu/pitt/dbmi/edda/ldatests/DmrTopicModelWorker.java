package edu.pitt.dbmi.edda.ldatests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import cc.mallet.pipe.CharSequence2TokenSequence;
import cc.mallet.pipe.Input2CharSequence;
import cc.mallet.pipe.Pipe;
import cc.mallet.pipe.PrintInputAndTarget;
import cc.mallet.pipe.SerialPipes;
import cc.mallet.pipe.Target2Label;
import cc.mallet.pipe.TokenSequence2FeatureSequence;
import cc.mallet.pipe.TokenSequenceLowercase;
import cc.mallet.pipe.TokenSequenceRemoveNonAlpha;
import cc.mallet.pipe.TokenSequenceRemoveStopwords;
import cc.mallet.topics.DMRTopicModel;
import cc.mallet.topics.tui.DMRLoader;
import cc.mallet.types.InstanceList;

import com.rapidminer.example.ExampleSet;

public class DmrTopicModelWorker {

	private List<String[]> labelDirectoryPairs;

	private DMRTopicModel dmrTopicModel;
	
	private int numTopics = 10;
	
	private double alpha = 1.0;
	
	private double beta = 0.01;
	
	private int numberOfIterations = 5000;
	
	private int burnInPeriod = 500;
	
	private int numberOfThreads = 1;

	private ExampleSet outgoingExampleSet;
	
	private boolean isBalancingInstances = false;
	
	private boolean isGeneratingDiagnostics = false;

	public static void main(String args[]) {
		new DmrTopicModelWorker();
	}

	public DmrTopicModelWorker() {
			buildPipe();
			process();
	}
	
	@SuppressWarnings("deprecation")
	public void process() {
		
		try {
			
			File tgtDirectory = new File("C:\\edda\\data\\drm_easy");
			File wordsFile = new File(tgtDirectory, "A_words.txt");
			File featuresFile = new File(tgtDirectory, "A_features.txt");
			File instancesFile = new File(tgtDirectory, "A_instances.ser");
			
			DMRLoader dmrLoader = new DMRLoader();
			dmrLoader.load(wordsFile, featuresFile, instancesFile);
			
	        InstanceList training = InstanceList.load (instancesFile);
	        
			wordsFile = new File(tgtDirectory, "B_words.txt");
			featuresFile = new File(tgtDirectory, "B_features.txt");
			instancesFile = new File(tgtDirectory, "B_instances.ser");
			dmrLoader.load(wordsFile, featuresFile, instancesFile);
	        
			InstanceList testing = InstanceList.load (instancesFile);

	        setNumTopics(30);

	        DMRTopicModel lda = new DMRTopicModel (numTopics);
//	        LDAStream lda = new LDAStream (numTopics);
			lda.setOptimizeInterval(50);
			lda.setTopicDisplay(30, 10);
			lda.addInstances(training);
			lda.setTestingInstances(testing);
			lda.estimate();
			
//			lda.inferenceOneByOne(50);
			
			lda.printDocumentTopics(new File(tgtDirectory, "topics.gz"));
			lda.printTopWords(new File(tgtDirectory, "topwords.txt"), 10, true);
			lda.printState(new File(tgtDirectory, "state.gz"));
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	private Pipe buildPipe() {

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
		Pattern tokenPattern = Pattern.compile("[\\p{L}\\p{N}_]+");
		tokenPattern = Pattern.compile("\\p{L}{3,}");

		// Tokenize raw strings
		pipeList.add(new CharSequence2TokenSequence(tokenPattern));
		
		//
		// Remove tokens that contain non-alphabetic characters.
		//
		pipeList.add(new TokenSequenceRemoveNonAlpha());

		// Normalize all tokens to all lowercase
		pipeList.add(new TokenSequenceLowercase());

		// Remove stopwords from a standard English stoplist.
		// options: [case sensitive] [mark deletions]
		pipeList.add(new TokenSequenceRemoveStopwords(false, false));
		
		
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
		pipeList.add(new PrintInputAndTarget());

		return new SerialPipes(pipeList);
	}



	
	public DMRTopicModel getDMRTopicModel() {
		return dmrTopicModel;
	}

	public void setDMRTopicModel(DMRTopicModel parallelTopicModel) {
		this.dmrTopicModel = parallelTopicModel;
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

	public boolean isBalancingInstances() {
		return isBalancingInstances;
	}

	public void setBalancingInstances(boolean isBalancingInstances) {
		this.isBalancingInstances = isBalancingInstances;
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


}
