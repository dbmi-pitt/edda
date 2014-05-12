package edu.pitt.dbmi.edda.ldatests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import cc.mallet.topics.MarginalProbEstimator;
import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.InstanceList;
import edu.pitt.dbmi.edda.util.FileUtils;

public class TopicNumberEstimator {

	private static final Logger logger = Logger
			.getLogger(TopicNumberEstimator.class);

	public static final String outputDirectoryPath = "C:\\Users\\kjm84\\Desktop\\edda_tm_opt_130116";

	public static final String CONST_COMBINED_TARGET = "combined";
//	public static final String CONST_INCLUDE_TARGET = "include";
//	public static final String CONST_EXCLUDE_TARGET = "exclude";
	
//	private final String[] dataInputSubSets = {"amelo",
//			"galactomannan", "malaria", "flu", "organ_transplant" };
//
//	private final String[] dataOutputSubSets = {"amelo", "galacto",
//			"malaria", "flu", "transplant" };
	
	private final String[] dataInputSubSets = {"flu", "organ_transplant"};

	private final String[] dataOutputSubSets = {"flu", "transplant" };

//	private final String[] targetLabelSubSets = { CONST_COMBINED_TARGET,
//			CONST_INCLUDE_TARGET, CONST_EXCLUDE_TARGET };
	private final String[] targetLabelSubSets = { CONST_COMBINED_TARGET };

	protected final int numTopics = 3;
	protected final int numThreads = 1;
	protected final int numIterations = 1500;
	protected final int burnInPeriod = 25;

	protected final int numberOfParticles = 10;
	protected final boolean isReSampling = false;

	protected String goldSetPath;

	protected InstanceList goldSet;
	protected TargetCacher goldTargets;

	protected final int[] topicTrialsCombined = { 5, 10, 20, 30, 50, 75, 100,
			150 };

	protected final int[] topicTrialsInclude = { 1, 2, 3, 5, 7, 9, 12, 15 };

	protected final int[] topicTrialsExclude = { 6, 11, 21, 31, 51, 76, 101,
			151 };

	 protected final int[] topicTrialsInterim = { 1, 2, 3, 4, 5, 10, 20, 30, 50,
	 75, 100, 150, 200 } ;
	 
	 protected final int[] topicTrialsFinal = {1000, 1300, 1600, 1900, 2200, 2500} ;


	protected int[] topicTrials = topicTrialsFinal;

	protected final double[] logLikelihoods = new double[topicTrials.length];

	protected double maxLogLikelihood;
	protected int maxLogLikelihoodIndex;

	protected final LdaPipeLine pipeLine = new LdaPipeLine();

	protected int randomSeed = (new Random()).nextInt();

	protected File outputDirectory;

	protected final HashMap<String, Integer> bestTopicNumbers = new HashMap<String, Integer>();

	public static void main(String[] args) {
		new TopicNumberEstimator();
	}

	public TopicNumberEstimator() {

		logger.setLevel(Level.DEBUG);

		try {

			bestTopicNumbers.clear();

			cleanAndMakeOutputDirectory();

			calculateAndWriteIndividualLogLikelihoods();

			writeBestTopicNumberSummary();

		} catch (LdaException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void calculateAndWriteIndividualLogLikelihoods()
			throws LdaException, FileNotFoundException, IOException {
		int idx = 0;
		for (String dataSubSet : dataInputSubSets) {
			buildGoldSetPathName(dataSubSet);
			for (String targetLabel : targetLabelSubSets) {
				logger.info("Running evaluation for " + goldSetPath
						+ " target = " + targetLabel);
				// estimateModelTest(dataSubSet, targetLabel);

				estimateModel(dataSubSet, targetLabel);
				logger.info("\nLog Likelihood Data: \n"
						+ displayVector(logLikelihoods));
				String outputSubSet = dataOutputSubSets[idx];
				writeLikelihoodsFile(outputSubSet, targetLabel);
			}
			idx++;
		}

	}

	private void cleanAndMakeOutputDirectory() {
		outputDirectory = new File(outputDirectoryPath);
		if (outputDirectory.exists() && outputDirectory.isDirectory()) {
			FileUtils.deleteDir(outputDirectory);
			delay();
			outputDirectory = new File(outputDirectoryPath);
		}
		outputDirectory.mkdir();

	}

	private void delay() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void buildGoldSetPathName(String dataSubSet) {
		goldSetPath = "T:\\EDDA\\WORKSPACE\\KEVIN\\data\\NEW_BASELINE_CSV_FILES\\"
				+ dataSubSet
				+ "\\TopicModelInput.csv";
	}



	private void estimateModel(String dataSubSet, String targetLabel)
			throws LdaException {
		buildGoldSet(targetLabel);
		// assignTopicTrials(targetLabel) ;
		maxLogLikelihood = Integer.MIN_VALUE;
		maxLogLikelihoodIndex = -1;
		for (int idx = 0; idx < topicTrials.length; idx++) {
			int topicTrial = topicTrials[idx];
			buildAndEstimateTopicModel(goldSet, topicTrial, idx);
		}
		String key = dataSubSet + ":" + targetLabel;
		Integer bestTopicNumber = topicTrials[maxLogLikelihoodIndex];
		bestTopicNumbers.put(key, bestTopicNumber);
	}



	private String displayVector(double[] values) {
		StringBuffer sb = new StringBuffer();
		for (double value : values) {
			sb.append(value + ", ");

		}
		sb = sb.deleteCharAt(sb.length() - 1);
		sb = sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	private ParallelTopicModel buildAndEstimateTopicModel(
			InstanceList instances, int numberOfTopics,
			int currentTopicTrialIndex) throws LdaException {

		ParallelTopicModel model = null;

		try {

			// Create a model with T topics, alpha_t = 50 / T, beta_w = 0.1
			double alpha = 50.0d / (double) numberOfTopics;
			double beta = 0.1d;
			
			logger.info("Building model T = " + numberOfTopics + " alpha = "
					+ alpha + " beta = " + beta);
			model = new ParallelTopicModel(numberOfTopics, alpha, beta);

			model.setRandomSeed(randomSeed);

			model.addInstances(instances);

			// Use two parallel samplers, which each look at one half the corpus
			// and
			// combine
			// statistics after every iteration.
			model.setNumThreads(numThreads);

			// Run the model for 50 iterations and stop (this is for testing
			// only,
			// for real applications, use 1000 to 2000 iterations)
			model.setNumIterations(numIterations);

			model.setOptimizeInterval(10);

			model.setTopicDisplay(0, 0);

			model.estimate();
			
			estimateLogLikelihood(instances, model, numberOfTopics, currentTopicTrialIndex);

		} catch (IOException e) {
			throw new LdaException(e);
		}

		return model;
	}

	private void estimateLogLikelihood(InstanceList instances, ParallelTopicModel model, int numberOfTopics, int currentTopicTrialIndex) {
		
		logger.info("Entering esitmateLogLikeLikelihood\n");
		
		MarginalProbEstimator evaluator = model.getProbEstimator();

		double logLikelihood = evaluator.evaluateLeftToRight(instances,
				numberOfParticles, isReSampling, null);
		
		logger.info("T = " + numberOfTopics + " logLikelihood = "
				+ logLikelihood);

		logLikelihoods[currentTopicTrialIndex] = logLikelihood;

		if (logLikelihood > maxLogLikelihood) {
			maxLogLikelihoodIndex = currentTopicTrialIndex;
			maxLogLikelihood = logLikelihood;
		}
		
		logger.info("Exiting esitmateLogLikeLikelihood\n");

	}

	private void buildGoldSet(String targetLabelFilter) throws LdaException {
		InstanceListReaderDirect goldReader = new InstanceListReaderDirect();
		goldReader.setOneInstancePerLineFilePath(goldSetPath);
		goldReader.setPipeLine(pipeLine.getSerialPipe());
		goldReader.setIncludingClassifications(true);
		if (!targetLabelFilter.equals(CONST_COMBINED_TARGET)) {
			goldReader.setTargetLabelFilter(targetLabelFilter);
		}
		goldReader.readInstances();
		goldSet = goldReader.getInstances();
		goldTargets = goldReader.getTargetCacher();
	}

	private void writeLikelihoodsFile(String currentDataSet, String currentMode)
			throws FileNotFoundException, IOException {
		String fileName = currentDataSet.toLowerCase() + "_"
				+ currentMode.toLowerCase() + ".csv";
		File outputFile = new File(outputDirectory, fileName);
		System.out.println("Trying to create file "
				+ outputFile.getAbsolutePath());
		outputFile.createNewFile();
		BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));

		output.append(",,Log Likelihood");
		output.newLine();
		int idx = 0;
		for (int topicTrial : topicTrials) {
			double logLikelihood = logLikelihoods[idx];
			if (idx == maxLogLikelihoodIndex) {
				output.append("*," + topicTrial + "," + logLikelihood);
			} else {
				output.append("," + topicTrial + "," + logLikelihood);
			}
			output.newLine();
			idx++;
		}
		output.close();

	}
	
//	@SuppressWarnings("unused")
//	private int[] assignTopicTrials(String targetLabel) {
//		if (targetLabel.equals(CONST_COMBINED_TARGET)) {
//			topicTrials = topicTrialsCombined;
//		} else if (targetLabel.equals(CONST_INCLUDE_TARGET)) {
//			topicTrials = topicTrialsInclude;
//		} else if (targetLabel.equals(CONST_EXCLUDE_TARGET)) {
//			topicTrials = topicTrialsExclude;
//		}
//		return topicTrials;
//
//	}
	
	@SuppressWarnings("unused")
	private void estimateModelTest(String dataSubSet, String targetLabel)
			throws LdaException {
		buildGoldSet(targetLabel);
		System.out.println("Estimating " + goldSet.size() + " instances from "
				+ dataSubSet + " with class of " + targetLabel);
	}

	private void writeBestTopicNumberSummary() throws FileNotFoundException,
			IOException {
		String fileName = "summary.csv";
		File outputFile = new File(outputDirectory, fileName);
		outputFile.createNewFile();
		BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
		output.append("DataSet,Combined,Include,Exclude");
		output.newLine();
		for (String dataSubSet : dataInputSubSets) {
			output.append(dataSubSet);
			for (String targetLabel : targetLabelSubSets) {
				String key = dataSubSet + ":" + targetLabel;
				Integer bestTopicNumber = bestTopicNumbers.get(key);
				output.append("," + bestTopicNumber);
			}
			output.newLine();
		}
		output.close();
	}

}
