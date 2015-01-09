package edu.pitt.dbmi.edda.ldatests;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.IDSorter;
import cc.mallet.types.InstanceList;
import edu.pitt.dbmi.edda.util.FileUtils;

public class MostProbableWordReporter {

	private static final Logger logger = Logger
			.getLogger(MostProbableWordReporter.class);

	public static final String outputDirectoryPath = "T:\\EDDA\\WORKSPACE\\KEVIN\\topic_model_analysis\\wordsPerTopics";

	public static final String CONST_INCLUDE_TARGET = "include";
	public static final String CONST_EXCLUDE_TARGET = "exclude";

	private static final int CONST_NUM_WORDS_TO_DISPLAY = 5;

	private final String[] dataInputSubSets = { "amelo",
			"galactomannan", "malaria", "flu", "organ_transplant", "easy" };

	private final String[] targetLabelSubSets = { CONST_INCLUDE_TARGET,
			CONST_EXCLUDE_TARGET };

	protected final int numThreads = 1;
	protected final int numIterations = 100;
	protected final int burnInPeriod = 10;

	protected String goldSetPath;

	protected InstanceList goldSet;
	protected TargetCacher goldTargets;

	protected final int[] topicsExcludePerDataSet = {  20, 20, 20, 30, 30, 20 };
	protected final int[] topicsIncludePerDataSet = { 2, 2, 2, 3, 4, 20 };

	protected int[] topicsPerDataSet;

	protected final LdaPipeLine pipeLine = new LdaPipeLine();

	protected int randomSeed = (new Random()).nextInt();

	protected File outputDirectory;
	
	protected BufferedWriter writer;
	
	protected final Comparator<RankedWord> rankedWordComparator = new Comparator<RankedWord>() {
		public int compare(RankedWord o1, RankedWord o2) {
			if (o1.getProbability() > o2.getProbability()) {
				return -1;
			} else {
				return 1;
			}
		}
	};

	protected final HashMap<String, RankedWord> maximumProbabilities = new HashMap<String, RankedWord>();
	protected final TreeSet<RankedWord> descendingProbabilites = new TreeSet<RankedWord>(rankedWordComparator);
	
	protected RankedWord[][] phi;
	
	public static void main(String[] args) {
		new MostProbableWordReporter();
	}

	public MostProbableWordReporter() {

		logger.setLevel(Level.DEBUG);

		try {

			cleanAndMakeOutputDirectory();
			
			calculateMostProbableWords();
			
			writer.flush();
			writer.close();

		} catch (LdaException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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

	private void calculateMostProbableWords() throws LdaException,
			FileNotFoundException, IOException {
		FileWriter phiFile = new FileWriter(new File(outputDirectory, "phi.csv"));
		writer = new BufferedWriter(phiFile);
		for (int dataSetIdx = 0; dataSetIdx < dataInputSubSets.length; dataSetIdx++) {
			String dataSubSet = dataInputSubSets[dataSetIdx];
			buildGoldSetPathName(dataSubSet);
			for (String targetLabel : targetLabelSubSets) {
				logger.info("Running evaluation for " + goldSetPath
						+ " target = " + targetLabel);
				writer.append("\n\n" + dataSubSet
						+ "," + targetLabel + "\n");
				buildGoldSet(targetLabel);
				int numberOfTopics = getTopicsPerDataSet(targetLabel)[dataSetIdx];
				buildAndEstimateTopicModel(goldSet, numberOfTopics, dataSetIdx);
			}
		}
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

			displayMaximumProbabilities(model);

		} catch (IOException e) {
			throw new LdaException(e);
		}

		return model;
	}
	
//	

	
	
	private void displayMaximumProbabilities(ParallelTopicModel model) throws IOException {	
		
		phi = new RankedWord[CONST_NUM_WORDS_TO_DISPLAY][model.getNumTopics()];
		
		ArrayList<TreeSet<IDSorter>> allWords =	model.getSortedWords() ;
		int topicIdx = 0;
		for (TreeSet<IDSorter> allTopicWords : allWords) {
			processTopicWords(model, topicIdx, allTopicWords);
			topicIdx++;
		}
		
		displayMatrix(model);
		
	}
	
	
	
	private void displayMatrix(ParallelTopicModel model) throws IOException {
		StringBuffer sb = new StringBuffer() ;
		sb.append("\n");
		sb.append("\n");
		sb.append(buildHeader(model));
		sb.append("\n");
		sb.append("\n");
		for (int row = 0; row < phi.length; row++) {
			for (int col = 0; col < phi[row].length; col++) {
				sb.append(phi[row][col]);
			}
			sb.append("\n");
		}
		logger.info(sb.toString());
		writer.append(sb.toString());
	}
	
	private void processTopicWords(ParallelTopicModel model, int topicIndex, TreeSet<IDSorter> allTopicWords) {
		clearCaches();
		int numberOfAssignments = sumOverTopicAssignments(allTopicWords);
		for (IDSorter weightedWordPointer : allTopicWords) {
		    RankedWord rankedWord = new RankedWord();
		    rankedWord.setWord((String) model.getAlphabet().lookupObject(weightedWordPointer.getID()));
		    rankedWord.setProbability(new Double(weightedWordPointer.getWeight()) / new Double(numberOfAssignments));
		    RankedWord existingRankedWord = maximumProbabilities.get(rankedWord.getWord());
		    if (existingRankedWord == null || existingRankedWord.getProbability() < rankedWord.getProbability()) {
		    	maximumProbabilities.put(rankedWord.getWord(), rankedWord);
		    }
		}
		final TreeSet<RankedWord> descendingProbabilites = new TreeSet<RankedWord>(rankedWordComparator);
		descendingProbabilites.addAll(maximumProbabilities.values());
		Iterator<RankedWord> wordIterator = descendingProbabilites.iterator();
		String topicLabel = TopicModelUtils.buildColumnNameForTopic(topicIndex);
		int wordsVisited = 0;
		StringBuffer sb = new StringBuffer() ;
		sb.append("Topic " + topicLabel + ";");
		while (wordIterator.hasNext() && wordsVisited < CONST_NUM_WORDS_TO_DISPLAY) {
			RankedWord rankedWord = wordIterator.next();
			phi[wordsVisited][topicIndex] = rankedWord;
			wordsVisited++;
		}
		logger.info(sb.toString());
	}

	

	private int[] getTopicsPerDataSet(String targetLabel) {
		if (targetLabel.equals(CONST_INCLUDE_TARGET)) {
			return topicsIncludePerDataSet;
		} else if (targetLabel.equals(CONST_EXCLUDE_TARGET)) {
			return topicsExcludePerDataSet;
		} else {
			return (int[]) null;
		}
	}

	private void clearCaches() {
		maximumProbabilities.clear();
		descendingProbabilites.clear();
	}

	
	private int sumOverTopicAssignments(TreeSet<IDSorter> allTopicWords) {
		int accumulator = 0;
		for (IDSorter weightedWordPointer : allTopicWords) {   
		    accumulator += weightedWordPointer.getWeight();
		}
		return accumulator;
	}

	private void buildGoldSetPathName(String dataSubSet) {
		goldSetPath = "T:\\EDDA\\DATA\\"
				+ dataSubSet
				+ "\\Tokenizer_Output\\5050_2xTitles_tokenized\\A_data\\TopicModelInput.csv";

	}
	
	private void buildGoldSet(String targetLabelFilter) throws LdaException {
		InstanceListReaderDirect goldReader = new InstanceListReaderDirect();
		goldReader.setOneInstancePerLineFilePath(goldSetPath);
		goldReader.setPipeLine(pipeLine.getSerialPipe());
		goldReader.setIncludingClassifications(true);
		goldReader.setTargetLabelFilter(targetLabelFilter);
		goldReader.readInstances();
		goldSet = goldReader.getInstances();
		goldTargets = goldReader.getTargetCacher();
	}

	private String buildHeader(ParallelTopicModel model) {
		int headerColSpan = RankedWord.getOutputSpan();
		String header = "";
		for (int topicModelIdx = 0 ; topicModelIdx < model.getNumTopics(); topicModelIdx++) {
			String topicHeader = " " + TopicModelUtils.buildColumnNameForTopic(topicModelIdx) ;
			header += TopicModelUtils.delimit(StringUtils.rightPad(topicHeader, headerColSpan));
		}
		return header;
	}


}
