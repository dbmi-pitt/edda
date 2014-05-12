package edu.pitt.dbmi.edda.ldatests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import cc.mallet.topics.WorkerRunnable;
import cc.mallet.types.Dirichlet;
import cc.mallet.types.LabelAlphabet;
import cc.mallet.util.Randoms;

public class MalletTopicModelRunner extends cc.mallet.topics.ParallelTopicModel {

	private static final long serialVersionUID = -2798652877036129176L;

	private WorkerRunnable[] runnables = new WorkerRunnable[1];
	
	private int iteration = 1;
	
	private int numberOfModelBuildingIterations = numIterations;
	
	private int numberOfNonTrialIterations = 10;
	
	private ArrayList<Double> probabilities = new ArrayList<Double>();
	
	private int numberOfSampledProbabilities = 100;
	
	private double logLikelihood = 0.0d;

	public static void main(String[] args) {
		MalletTopicModelRunner malletTopicModelRunner = new MalletTopicModelRunner(
				30);
		try {
			malletTopicModelRunner.estimate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MalletTopicModelRunner(int numberOfTopics) {
		super(numberOfTopics);
	}

	public MalletTopicModelRunner(int numberOfTopics, double alphaSum,
			double beta) {
		super(numberOfTopics, alphaSum, beta);
	}

	public MalletTopicModelRunner(LabelAlphabet topicAlphabet, double alphaSum,
			double beta) {
		super(topicAlphabet, alphaSum, beta);
	}

	public void estimate() throws IOException {
		int docsPerThread = data.size();
		int offset = 0;
		Randoms random = deriveRandomSeed();
		runnables[0] = new WorkerRunnable(numTopics, alpha, alphaSum, beta,
				random, data, typeTopicCounts, tokensPerTopic, offset,
				docsPerThread);
		runnables[0].initializeAlphaStatistics(docLengthCounts.length);
		runnables[0].makeOnlyThread();
		iterativelyInferModel();
		while (probabilities.size() < numberOfSampledProbabilities) {
			iterativelySampleForLogLikelihoodCalcuation();
		}
		logLikelihood = (new HarmonicMeanCalculator()).harmonicMean(probabilities);
		
	}

	private void iterativelySampleForLogLikelihoodCalcuation() {
		int iterationBoundry = iteration + numberOfNonTrialIterations;
		for (; iteration <= iterationBoundry; iteration++) {
			runnables[0].run();
		}
		int[] etaTopics = runnables[0].getTokensPerTopic();
		int[][] phi = runnables[0].getTypeTopicCounts();
		int W = phi.length;
		double topicCoefficient =  Dirichlet.logGammaStirling(beta * W) - (W *  Dirichlet.logGammaStirling(beta));
		double topicProduct = 0.0d;
		for (int topicIdx = 1; topicIdx <= numTopics; topicIdx++) {
			double termTopicProduct = calculateTermTopicProduct(phi, topicIdx, W);
			double topicAssignments = Dirichlet.logGammaStirling(etaTopics[topicIdx-1] + W * beta) ;
			topicProduct += topicCoefficient + termTopicProduct - topicAssignments ;
		}
		probabilities.add(new Double(topicProduct));
	}
	
	private double calculateTermTopicProduct(int[][] phi, int topicIdx, int W) {
		double numerator = 0.0d;
		for (int termIdx = 0; termIdx < W; termIdx++) {
			int[] etaTermTopics = phi[termIdx];
			int etaTermTopic = decodeSparsePhiTermTopicAssignmentsValue(topicIdx, etaTermTopics);
		    numerator += Dirichlet.logGammaStirling(etaTermTopic + beta);
		}
		return numerator;
	}
	
	private int decodeSparsePhiTermTopicAssignmentsValue(int searchTopic, int[] sparsePhiTermTopicAssignments) {
			int numberOfAssignments = 0;
		    for (int idx = 0; idx < sparsePhiTermTopicAssignments.length; idx++) {
		    	int currentTopic = sparsePhiTermTopicAssignments[idx] & topicMask;
		    	if (currentTopic == searchTopic) {
		    		numberOfAssignments = sparsePhiTermTopicAssignments[idx] >> topicBits;
		    		break;
		    	}
		    }
		    return numberOfAssignments;
	}

	private void iterativelyInferModel() throws IOException {
		for (;iteration <= numberOfModelBuildingIterations; iteration++) {
			long iterationStart = System.currentTimeMillis();
			displayIterationPreDiagnostic(iteration);
			if (iteration > burninPeriod && optimizeInterval != 0
					&& iteration % saveSampleInterval == 0) {
				runnables[0].collectAlphaStatistics();
			}
			runnables[0].run();
			displayIterationPostDiagnostic(iterationStart, iteration);
		}
	}

	private void displayIterationPreDiagnostic(int iteration) throws IOException {
		if (showTopicsInterval != 0 && iteration != 0
				&& iteration % showTopicsInterval == 0) {
			logger.info("\n" + displayTopWords(wordsPerTopic, false));
		}
		if (saveStateInterval != 0 && iteration % saveStateInterval == 0) {
			this.printState(new File(stateFilename + '.' + iteration));
		}
		if (saveModelInterval != 0 && iteration % saveModelInterval == 0) {
			this.write(new File(modelFilename + '.' + iteration));
		}
	}
	
	private void displayIterationPostDiagnostic(long iterationStart, int iteration) {
		long elapsedMillis = System.currentTimeMillis() - iterationStart;
		if (elapsedMillis < 1000) {
			logger.fine(elapsedMillis + "ms ");
		}
		else {
			logger.fine((elapsedMillis/1000) + "s ");
		}   

		if (iteration > burninPeriod && optimizeInterval != 0 &&
			iteration % optimizeInterval == 0) {
			optimizeAlpha(runnables);
			optimizeBeta(runnables);
			logger.fine("[O " + (System.currentTimeMillis() - iterationStart) + "] ");
		}
		
		if (iteration % 10 == 0) {
			if (printLogLikelihood) {
				logger.info ("<" + iteration + "> LL/token: " + formatter.format(modelLogLikelihood() / totalTokens));
			}
			else {
				logger.info ("<" + iteration + ">");
			}
		}
	}

	private Randoms deriveRandomSeed() {
		Randoms random = null;
		if (randomSeed == -1) {
			random = new Randoms();
		} else {
			random = new Randoms(randomSeed);
		}
		return random;
	}
	
	public int getNumberOfModelBuildingIterations() {
		return numberOfModelBuildingIterations;
	}

	public void setNumberOfModelBuildingIterations(
			int numberOfModelBuildingIterations) {
		this.numIterations =
		this.numberOfModelBuildingIterations = numberOfModelBuildingIterations;
	}

	public int getNumberOfNonTrialIterations() {
		return numberOfNonTrialIterations;
	}

	public void setNumberOfNonTrialIterations(int numberOfNonTrialIterations) {
		this.numberOfNonTrialIterations = numberOfNonTrialIterations;
	}

	public int getNumberOfSampledProbabilities() {
		return numberOfSampledProbabilities;
	}

	public void setNumberOfSampledProbabilities(int numberOfSampledProbabilities) {
		this.numberOfSampledProbabilities = numberOfSampledProbabilities;
	}
	
	public double getLogLikelihood() {
		return logLikelihood;
	}

	public void setLogLikelihood(double logLikelihood) {
		this.logLikelihood = logLikelihood;
	}


}
