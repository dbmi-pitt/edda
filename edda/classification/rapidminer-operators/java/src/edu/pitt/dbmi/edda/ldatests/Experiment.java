package edu.pitt.dbmi.edda.ldatests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.Alphabet;
import cc.mallet.types.IDSorter;
import cc.mallet.types.Instance;
import cc.mallet.types.InstanceList;

public abstract class Experiment {
	
	private static final Logger logger = Logger
			.getLogger(Experiment.class);
	
	public static final String CONST_EXCLUDE_TARGET = "exclude";
	public static final String CONST_INCLUDE_TARGET = "include";
	
	protected final int numTopics = 30;
	protected final int numThreads = 3;
	protected final int numIterations = 2000;
	protected final int burnInPeriod = 500;
	
	protected final LdaPipeLine pipeLine = new LdaPipeLine();
	protected final PerformanceMeasure performanceMeasure = new PerformanceMeasure();
	
	protected int randomSeed;
	
	protected String goldSetPath;
	protected String testSetPath;
	protected boolean isSupervised;
	
	protected InstanceList goldSet;
	protected InstanceList testSet;
	protected TargetCacher goldTargets;
	protected TargetCacher testTargets;
	
	protected ParallelTopicModel model;
	
	public Experiment() {
		logger.setLevel(Level.DEBUG);
		logger.debug("constructed an " + getClass().getName()) ;
	}
	
	public Experiment(Experiment copyExperiment) {
		logger.setLevel(Level.DEBUG);
		setModel(copyExperiment.getModel());
		setGoldSet(copyExperiment.getGoldSet());
		setGoldTargets(copyExperiment.getGoldTargets());
		setTestSet(copyExperiment.getTestSet());
		setTestTargets(copyExperiment.getTestTargets());
		logger.debug("constructed an " + getClass().getName()) ;
	}
	
	public void execute() {
		
		try {
		
			if (model == null) {
				buildGoldSet();
				buildTestSet();
				model = buildAndEstimateTopicModel(goldSet);
			}
			
			Iterator<Instance> testSetIterator = testSet.iterator();
			
			initialize();
			
			while (true) {

				if (!testSetIterator.hasNext()) {
					break;
				}

				Instance testInstance = testSetIterator.next();
				
				TopicInferencer inferencer = model.getInferencer();
				double[] testProbabilities = inferencer.getSampledDistribution(
						testInstance, 10, 1, 5);
			
				double excludeDistance = calculateExcludeDistance(testProbabilities);
				double includeDistance = calculateIncludeDistance(testProbabilities);
				
				String predictedTarget = CONST_EXCLUDE_TARGET;
				if (includeDistance < excludeDistance) {
					predictedTarget = CONST_INCLUDE_TARGET;
				}

				String actualTarget = testTargets.fetchTargetForInstance(testInstance);
				
				if (actualTarget.equals(CONST_INCLUDE_TARGET)
						&& predictedTarget.equals(CONST_INCLUDE_TARGET)) {
					performanceMeasure.tp += 1.0d;
				} else if (actualTarget.equals(CONST_EXCLUDE_TARGET)
						&& predictedTarget.equals(CONST_INCLUDE_TARGET)) {
					performanceMeasure.fp += 1.0d;
				} else if (actualTarget.equals(CONST_INCLUDE_TARGET)
						&& predictedTarget.equals(CONST_EXCLUDE_TARGET)) {
					performanceMeasure.fn += 1.0d;
				} else if (actualTarget.equals(CONST_EXCLUDE_TARGET)
						&& predictedTarget.equals(CONST_EXCLUDE_TARGET)) {
					performanceMeasure.tn += 1.0d;
				}

			}
			
		}
		catch (LdaException ldaException) {
			ldaException.printStackTrace();
		}
		
		
	}
	
	private void buildTestSet() throws LdaException {
		InstanceListReaderDirect testReader = new InstanceListReaderDirect();
		testReader.setOneInstancePerLineFilePath(testSetPath);
		testReader.setPipeLine(pipeLine.getSerialPipe());
		testReader.setIncludingClassifications(false);
		testReader.readInstances();
		testSet = testReader.getInstances();
		testTargets = testReader.getTargetCacher();
	}

	private void buildGoldSet() throws LdaException {
		InstanceListReaderDirect goldReader = new InstanceListReaderDirect();
		goldReader.setOneInstancePerLineFilePath(goldSetPath);
		goldReader.setPipeLine(pipeLine.getSerialPipe());
		goldReader.setIncludingClassifications(isSupervised);
		goldReader.readInstances();
		goldSet = goldReader.getInstances();
		goldTargets = goldReader.getTargetCacher();
	}

	protected abstract void initialize() ;
	
	protected abstract double calculateIncludeDistance(double[] testProbabilities) ;

	protected abstract double calculateExcludeDistance(double[] testProbabilities) ;

	private ParallelTopicModel buildAndEstimateTopicModel(InstanceList instances)
			throws LdaException {
	
		ParallelTopicModel model = null;
		
		try {
			// Create a model with 100 topics, alpha_t = 0.01, beta_w = 0.01
			// Note that the first parameter is passed as the sum over topics, while
			// the second is
			model = new ParallelTopicModel(numTopics, 1.0, 0.01);
			
			model.setRandomSeed(randomSeed);

			model.addInstances(instances);

			// Use two parallel samplers, which each look at one half the corpus and
			// combine
			// statistics after every iteration.
			model.setNumThreads(numThreads);

			// Run the model for 50 iterations and stop (this is for testing only,
			// for real applications, use 1000 to 2000 iterations)
			model.setNumIterations(numIterations);
			
			model.setOptimizeInterval(10);
			
			model.setTopicDisplay(numTopics, numTopics);
			
			model.estimate();

		}
		catch (IOException e) {
			throw new LdaException(e);
		}
		
		return model;
	}
	
	protected String chompComma(String src) {
		return (src == null) ? src : src.replaceAll(",$", "");
	}
	
	protected void displayVector(String name, double[] v) {
		StringBuffer sb = new StringBuffer();
		sb.append(name + ":");
		for (int idx = 0; idx < v.length; idx++) {
			sb.append(v[idx] + ", ");
		}
		sb.append("\n");
		logger.debug("\n" + sb.toString());

	}
	
	public String toString() {
		return performanceMeasure.toString();
	}
	
	public void setRandomSeed(int randomSeed) {
		this.randomSeed = randomSeed;
	}
	
	public void setSupervised(boolean isSupervised) {
		this.isSupervised = isSupervised;
	}
	
	public void setGoldSetPath(String goldSetPath) {
		this.goldSetPath = goldSetPath;
	}

	public void setTestSetPath(String testSetPath) {
		this.testSetPath = testSetPath;
	}
	
	public ParallelTopicModel getModel() {
		return model;
	}

	public void setModel(ParallelTopicModel model) {
		this.model = model;
	}
	
	public InstanceList getGoldSet() {
		return goldSet;
	}

	public void setGoldSet(InstanceList goldSet) {
		this.goldSet = goldSet;
	}

	public InstanceList getTestSet() {
		return testSet;
	}

	public void setTestSet(InstanceList testSet) {
		this.testSet = testSet;
	}

	public TargetCacher getGoldTargets() {
		return goldTargets;
	}

	public void setGoldTargets(TargetCacher goldTargets) {
		this.goldTargets = goldTargets;
	}

	public TargetCacher getTestTargets() {
		return testTargets;
	}

	public void setTestTargets(TargetCacher testTargets) {
		this.testTargets = testTargets;
	}
	
	@SuppressWarnings("unused")
	private InstanceList buildGenerativeTestingInstances() {
		// Create a new instance with high probability of topic 0
		StringBuilder topicZeroText = new StringBuilder();
		Alphabet dataAlphabet = goldSet.getDataAlphabet();
		ArrayList<TreeSet<IDSorter>> topicSortedWords = model.getSortedWords();
		Iterator<IDSorter> iterator = topicSortedWords.get(0).iterator();
		int rank = 0;
		while (iterator.hasNext() && rank < 5) {
			IDSorter idCountPair = iterator.next();
			topicZeroText.append(dataAlphabet.lookupObject(idCountPair.getID())
					+ " ");
			rank++;
		}
		// Create a new instance named "test instance" with empty target and
		// source fields.
		InstanceList testing = new InstanceList(goldSet.getPipe());
		testing.addThruPipe(new Instance(topicZeroText.toString(), null,
				"test instance", null));

		return testing;
	}


}
