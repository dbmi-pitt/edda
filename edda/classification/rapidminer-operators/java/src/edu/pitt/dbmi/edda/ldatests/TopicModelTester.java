package edu.pitt.dbmi.edda.ldatests;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

// Each line has three fields, separated by commas. 
// This is a standard Mallet format. For more information, see the importing data guide.
// The first field is a name for the document. The second field could contain a document label, as in a classification task, 
// but for this example we won't use that field. It is therefore set to a meaningless placeholder value. 
// The third field contains the full text of the document, with no newline characters.

public class TopicModelTester {

	private static final Logger logger = Logger
			.getLogger(TopicModelTester.class);
	
	private final String[] dataSubSets = { "easy", "ameloblastoma", "malaria", "galactomannanen", "influenza", "transplant" } ;
//	private final String[] dataSubSets = { "easy", "ameloblastoma"} ;
//	private final String[] dataSubSets = { "easy"} ;
	
	private final Class<?>[] experiments = {
//			ExperimentCosineMeasureAverage.class,
//			ExperimentEuclideanAgainstAverages.class,
//			ExperimentEuclideanAgainstMedians.class,
//			ExperimentKLAgainstAverages.class,
			ExperimentKLAgainstMedians.class,
//			ExperimentKullbackLeiblerAverages.class,
//			ExperimentKullbackLeiblerMinimum.class,
//			ExperimentTallyAgainstMeans.class
//			ExperimentTallyAgainstMedians.class
	} ;
	
	
	private final Random generator = new Random();
	private final int randomSeed = generator.nextInt();

	public static void main(String[] args) throws Exception {
		new TopicModelTester();
	}

	public TopicModelTester() {

		logger.setLevel(Level.DEBUG);

		try {
			
			for (String dataSubSet : dataSubSets) {
				String aSetPath = "C:\\edda\\data\\comprehensive\\" + dataSubSet + "\\run002\\A_para.txt";
				String bSetPath = "C:\\edda\\data\\comprehensive\\" + dataSubSet + "\\run002\\B_para.txt";
//				String aSetPath = "C:\\edda\\data\\overfit\\" + dataSubSet + "\\run002\\A_para.txt";
//				String bSetPath = "C:\\edda\\data\\overfit\\" + dataSubSet + "\\run002\\A_para.txt";
				runSupervisedModel(aSetPath, bSetPath);
				runSupervisedModel(bSetPath, aSetPath);
			}

		
		} catch (LdaException e) {
			e.printStackTrace();
		}

	}
	
	private Experiment buildExperimentBasedOnExistingExperiment(Class<?> experimentCls, Experiment copyExperiment) throws LdaException {
		Experiment result = null;
		try {
			Class<?>[] constructorSignature = { Experiment.class } ;
			Constructor<?> constructor = experimentCls.getConstructor(constructorSignature);
			Object[] constructorParameters = { copyExperiment } ;
			result = (Experiment) constructor.newInstance(constructorParameters) ;
		} catch (SecurityException e) {
			throw new LdaException(e);
		} catch (NoSuchMethodException e) {
			throw new LdaException(e);
		} catch (IllegalArgumentException e) {
			throw new LdaException(e);
		} catch (InstantiationException e) {
			throw new LdaException(e);
		} catch (IllegalAccessException e) {
			throw new LdaException(e);
		} catch (InvocationTargetException e) {
			throw new LdaException(e);
		}
		return result;
	}

	private void runSupervisedModel(String goldSetPath, String testSetPath)
			throws LdaException {

		logger.debug("Gold: " + goldSetPath);
		logger.debug("Test: " + testSetPath);

		logger.debug("\nBuilding Supervised TopicModel:\n\n");
//		
		Experiment experiment = new ExperimentKLAgainstMedians();
		experiment.setGoldSetPath(goldSetPath);
		experiment.setTestSetPath(testSetPath);
		experiment.setModel(null);
		experiment.setSupervised(true);
		experiment.setRandomSeed(randomSeed);
		experiment.execute();
		
//		for (Class<?> experimentCls : experiments) {
//			experiment = buildExperimentBasedOnExistingExperiment(experimentCls, experiment) ;
//			experiment.execute();
//			logger.debug("\n\n\n" + experimentCls.getSimpleName() + "\n\n\n");
//			logger.debug(experiment);
//		}
		
	}

	private void runUnSupervisedModel(String goldSetPath, String testSetPath)
			throws IOException {

		logger.debug("Gold: " + goldSetPath);
		logger.debug("Test: " + testSetPath);
		logger.debug("\nBuilding Un Supervised TopicModel:\n\n");
		Experiment experiment = new ExperimentEuclideanAgainstAverages();
		experiment.setGoldSetPath(goldSetPath);
		experiment.setTestSetPath(testSetPath);
		experiment.setModel(null);
		experiment.setSupervised(false);
		experiment.setRandomSeed(randomSeed);
		experiment.execute();
		logger.debug("\n\nPerformance based on Euclidean Distance Measure:");
		logger.debug(experiment);

		Experiment experimentKl = new ExperimentKullbackLeiblerAverages(
				experiment);
		experimentKl.execute();
		logger.debug("\n\nPerformance based on Kullback Leibler Divergence Measure (Averages):\n");
		logger.debug(experimentKl);

		experimentKl = new ExperimentKullbackLeiblerMinimum(experiment);
		experimentKl.execute();
		logger.debug("\n\nPerformance based on Kullback Leibler Divergence Measure (Minimum):\n");

		logger.debug(experimentKl);

		experimentKl = new ExperimentCosineMeasureAverage(experiment);
		experimentKl.execute();
		logger.debug("\n\nPerformance based on Cosine Divergence Measure:\n");
		logger.debug(experimentKl);

	}

	
}