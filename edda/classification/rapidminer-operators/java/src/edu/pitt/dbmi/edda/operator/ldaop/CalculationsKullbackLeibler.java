package edu.pitt.dbmi.edda.operator.ldaop;

import java.util.logging.Logger;

public class CalculationsKullbackLeibler {
	
	private final static Logger logger = Logger.getLogger(CalculationsKullbackLeibler.class .getName()); 
	
	public static double tryCalculateSymmetricKullbackLeiblerDivergence(double[] pValues, double[] qValues) {
		double klDivergence = 0.0d;
		try {
			klDivergence = calculateSymmetricKullbackLeiblerDivergence(pValues, qValues);
		} catch (Exception x) {
			logger.severe("tryCalculateSymmetricKullbackLeiblerDivergence threw an exception.");
			klDivergence = -1.0d;
		}
		return klDivergence;
	}

	/**
	 * Symmetric Kullback Leibler (KL) divergence
	 * 
	 * KL divergence is asymmetric and in many applications, it is convenient to
	 * apply a symmetric measure based on KL divergence:
	 */
	public static double calculateSymmetricKullbackLeiblerDivergence(
			double[] pValues, double[] qValues) {
		return 0.5d * ( calculateKullbackLeiblerDivergence(pValues, qValues)
				+ calculateKullbackLeiblerDivergence(qValues, pValues) );
	}

	/**
	 * Kullback Leibler (KL) divergence
	 * 
	 * A standard function to measure the difference or divergence between two
	 * distributions p and q is the
	 */
	public static double calculateKullbackLeiblerDivergence(double[] pValues,
			double[] qValues) {
		double klDivergence = 0.0d;
		for (int jdx = 0; jdx < pValues.length; jdx++) {
			double p = pValues[jdx];
			double q = qValues[jdx];
			klDivergence += p * Math.log(p / q);
		}
		return klDivergence;
	}

}
