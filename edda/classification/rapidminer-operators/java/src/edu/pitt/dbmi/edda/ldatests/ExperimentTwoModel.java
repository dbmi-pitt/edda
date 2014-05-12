package edu.pitt.dbmi.edda.ldatests;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.Instance;
import cc.mallet.types.InstanceList;

public abstract class ExperimentTwoModel {
	
	private static final Logger logger = Logger
			.getLogger(ExperimentTwoModel.class);
	
	public static final String CONST_INCLUDE_TARGET = "include";
	public static final String CONST_EXCLUDE_TARGET = "exclude";
	
	protected final int numTopics = 9;
	
	protected final LdaPipeLine pipeLine = new LdaPipeLine();
	protected final PerformanceMeasure performanceMeasure = new PerformanceMeasure();
	
	protected int randomSeed;
	
	protected String goldSetPath;
	protected String testSetPath;
	protected boolean isSupervised;
	
	protected InstanceList goldExcludeSet;
	protected InstanceList goldIncludeSet;
	protected InstanceList testSet;
	protected TargetCacher testTargets;
	
	protected ParallelTopicModel excludeModel;
	
	protected ParallelTopicModel includeModel;
	
	public ExperimentTwoModel() {
		logger.debug("constructed an " + getClass().getName()) ;
	}
	
	public ExperimentTwoModel(ExperimentTwoModel copyExperiment) {
		setExcludeModel(copyExperiment.getExcludeModel());
		setIncludeModel(copyExperiment.getIncludeModel());
		setGoldExcludeSet(copyExperiment.getGoldExcludeSet());
		setGoldIncludeSet(copyExperiment.getGoldIncludeSet());
		setTestSet(copyExperiment.getTestSet());
		setTestTargets(copyExperiment.getTestTargets());
	}
	
	public void execute() {
		
		try {
		
			if (excludeModel == null) {
				buildGoldExcludeSet();
				buildGoldIncludeSet();
				buildTestSet();
				excludeModel = buildAndEstimateTopicModel(goldExcludeSet);
				includeModel = buildAndEstimateTopicModel(goldIncludeSet);
			}
			
			Iterator<Instance> testSetIterator = testSet.iterator();
			
			initialize();
			
			while (true) {

				if (!testSetIterator.hasNext()) {
					break;
				}

				Instance testInstance = testSetIterator.next();
				
				TopicInferencer excludeInferencer = excludeModel.getInferencer();
				double[] testProbsAgainstExcludeModel = excludeInferencer.getSampledDistribution(
						testInstance, 10, 1, 5);
				TopicInferencer includeInferencer = includeModel.getInferencer();
				double[] testProbsAgainstIncludeModel = includeInferencer.getSampledDistribution(
						testInstance, 10, 1, 5);
				double excludeDistance = calculateExcludeDistance(testProbsAgainstExcludeModel);
				double includeDistance = calculateIncludeDistance(testProbsAgainstIncludeModel);
				
				String predictedTarget = CONST_INCLUDE_TARGET;
				if (excludeDistance < includeDistance) {
					predictedTarget = CONST_EXCLUDE_TARGET;
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

	private void buildGoldExcludeSet() throws LdaException {
		InstanceListReaderDirect goldReader = new InstanceListReaderDirect();
		goldReader.setOneInstancePerLineFilePath(goldSetPath);
		goldReader.setPipeLine(pipeLine.getSerialPipe());
		goldReader.setIncludingClassifications(isSupervised);
		goldReader.setTargetLabelFilter(CONST_EXCLUDE_TARGET);
		goldReader.readInstances();
		goldExcludeSet = goldReader.getInstances();
	}
	
	private void buildGoldIncludeSet() throws LdaException {
		InstanceListReaderDirect goldReader = new InstanceListReaderDirect();
		goldReader.setOneInstancePerLineFilePath(goldSetPath);
		goldReader.setPipeLine(pipeLine.getSerialPipe());
		goldReader.setIncludingClassifications(isSupervised);
		goldReader.setTargetLabelFilter(CONST_INCLUDE_TARGET);
		goldReader.readInstances();
		goldIncludeSet = goldReader.getInstances();
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
			model.setNumThreads(2);

			// Run the model for 50 iterations and stop (this is for testing only,
			// for real applications, use 1000 to 2000 iterations)
			model.setNumIterations(500);
			
//			model.setTopicDisplay(2000, 0);
			
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
		System.out.println(sb.toString());

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
	
	public InstanceList getGoldSet() {
		return goldExcludeSet;
	}

	public void setGoldSet(InstanceList goldSet) {
		this.goldExcludeSet = goldSet;
	}

	public InstanceList getTestSet() {
		return testSet;
	}

	public void setTestSet(InstanceList testSet) {
		this.testSet = testSet;
	}

	public TargetCacher getTestTargets() {
		return testTargets;
	}

	public void setTestTargets(TargetCacher testTargets) {
		this.testTargets = testTargets;
	}
	
	public InstanceList getGoldExcludeSet() {
		return goldExcludeSet;
	}

	public void setGoldExcludeSet(InstanceList goldExcludeSet) {
		this.goldExcludeSet = goldExcludeSet;
	}

	public InstanceList getGoldIncludeSet() {
		return goldIncludeSet;
	}

	public void setGoldIncludeSet(InstanceList goldIncludeSet) {
		this.goldIncludeSet = goldIncludeSet;
	}

	public ParallelTopicModel getExcludeModel() {
		return excludeModel;
	}

	public void setExcludeModel(ParallelTopicModel excludeModel) {
		this.excludeModel = excludeModel;
	}

	public ParallelTopicModel getIncludeModel() {
		return includeModel;
	}

	public void setIncludeModel(ParallelTopicModel includeModel) {
		this.includeModel = includeModel;
	}

}
