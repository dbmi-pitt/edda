package edu.pitt.dbmi.edda.operator.ldaop;

import org.apache.commons.lang.StringUtils;

import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.Instance;

public class TopicModelUtils {

	public static String buildColumnNameForTopic(int topicIndex) {
		String formattedTopicIndex = StringUtils.leftPad(topicIndex+"", 5, "0");
		return "topic_" + formattedTopicIndex + "";
	}
	
	public static String formatIndex(int topicIndex) {
		return StringUtils.leftPad(topicIndex+"", 5, "0");
	}
	
	public static String buildKey(int row, int col) {
		String rowPart = TopicModelUtils.formatIndex(row);
		String colPart = TopicModelUtils.formatIndex(col);
		return rowPart + ":" + colPart;
	}
	
	public static double[] inferTopicForInstance(TopicInferencer inferencer, Instance instance, boolean isIterating) {
		int numberOfIterations = 0;
		int thinning = 0;
		int burnIn = 0;
		if (isIterating) {
			numberOfIterations = 10;
			thinning = 1;
			burnIn = 5;
		}
		
		final double[] topicProbs = inferencer.getSampledDistribution(instance, numberOfIterations,
				thinning, burnIn);
		return topicProbs;
	}
	
	public static String delimit(String inputString) {
		String delimiter = " ";
		String outputString = delimiter + inputString.substring(1, inputString.length());
		outputString = outputString.substring(0, outputString.length()-1) + ",";
		return outputString;
	}
	
	
	
}
