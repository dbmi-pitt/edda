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

import cc.mallet.types.InstanceList;
import edu.pitt.dbmi.edda.util.FileUtils;

public class TopicModelEstimatorWithHarmonicMeans {

	private static final Logger logger = Logger
			.getLogger(TopicModelEstimatorWithHarmonicMeans.class);

	public static final String outputDirectoryPath = "C:\\Users\\kjm84\\Desktop\\edda_tm_output3";

	public static final String CONST_COMBINED_TARGET = "combined";
	public static final String CONST_INCLUDE_TARGET = "include";
	public static final String CONST_EXCLUDE_TARGET = "exclude";

	// private final String[] dataSubSets = { "easy", "AMELO", "malaria",
	// "galactomannanen", "influenza", "transplant" };
	//
	private final String[] dataInputSubSets = { "easy", "amelo",
			"galactomannan", "malaria", "flu", "organ_transplant" };

	private final String[] dataOutputSubSets = { "easy", "amelo", "galacto",
			"malaria", "flu", "transplant" };

	private final String[] targetLabelSubSets = { CONST_COMBINED_TARGET,
			CONST_INCLUDE_TARGET, CONST_EXCLUDE_TARGET };

	protected final int numTopics = 3;
	protected final int numThreads = 1;
	protected final int numIterations = 500;
	protected final int burnInPeriod = 50;

	protected final int numberOfParticles = 10;
	protected final boolean isReSampling = true;

	protected String goldSetPath;

	protected InstanceList goldSet;
	protected TargetCacher goldTargets;

	// protected final int[] topicTrials = { 50, 100, 200, 300, 400,
	// 500,
	// 600, 1000 };

	protected final int[] topicTrialsCombined = { 5, 10, 20, 30, 50, 75, 100,
			150 };

	protected final int[] topicTrialsInclude = { 1, 2, 3, 5, 7, 9, 12, 15 };

	protected final int[] topicTrialsExclude = { 6, 11, 21, 31, 51, 76, 101,
			151 };
	
	protected final int[] topicTrialsTest = {  31,  101,
			151 };


	 protected final int[] topicTrialsFinal = { 1, 2, 3, 4, 5, 10, 20, 30, 50,
	 75, 100, 150, 200 } ;

//	protected final int[] topicTrialsFinal = { 10, 20, 30, 50,
//			75, 100, 150, 200 };

	protected int[] topicTrials = topicTrialsFinal;

	// protected final int[] topicTrials = { 30, 40, 50, 60, 70, 80, 90,
	// 100 };

	protected final double[] logLikelihoods = new double[topicTrials.length];

	protected double maxLogLikelihood;
	protected int maxLogLikelihoodIndex;

	protected final LdaPipeLine pipeLine = new LdaPipeLine();

	protected int randomSeed = (new Random()).nextInt();

	protected File outputDirectory;

	protected final HashMap<String, Integer> bestTopicNumbers = new HashMap<String, Integer>();

	public static void main(String[] args) {
		new TopicModelEstimatorWithHarmonicMeans();
	}

	public TopicModelEstimatorWithHarmonicMeans() {

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
		goldSetPath = "T:\\EDDA\\DATA\\"
				+ dataSubSet
				+ "\\Tokenizer_Output\\5050_2xTitles_tokenized\\A_data\\TopicModelInput.csv";

	}
	
	private void estimateModel(String dataSubSet, String targetLabel)
			throws LdaException {
		buildGoldSet(targetLabel);
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

	private MalletTopicModelRunner buildAndEstimateTopicModel(
			InstanceList instances, int numberOfTopics,
			int currentTopicTrialIndex) throws LdaException {

		MalletTopicModelRunner model = null;

		try {

			// Create a model with T topics, alpha_t = 50 / T, beta_w = 0.1
			double alpha = 50.0d / (double) numberOfTopics;
			double beta = 0.1d;

			logger.info("Building model T = " + numberOfTopics + " alpha = "
					+ alpha + " beta = " + beta);
			model = new MalletTopicModelRunner(numberOfTopics, alpha, beta);

			model.setRandomSeed(randomSeed);

			model.addInstances(instances);

			model.setNumberOfModelBuildingIterations(numIterations);
			model.setNumberOfNonTrialIterations(10);
			model.setNumberOfSampledProbabilities(10);

			model.estimate();

			double logLikelihood = model.getLogLikelihood();
			
			logger.info("T = " + numberOfTopics + " logLikelihood = "
					+ logLikelihood);

			logLikelihoods[currentTopicTrialIndex] = logLikelihood;

			if (logLikelihood > maxLogLikelihood) {
				maxLogLikelihoodIndex = currentTopicTrialIndex;
				maxLogLikelihood = logLikelihood;
			}
			

		} catch (IOException e) {
			throw new LdaException(e);
		}

		return model;
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
