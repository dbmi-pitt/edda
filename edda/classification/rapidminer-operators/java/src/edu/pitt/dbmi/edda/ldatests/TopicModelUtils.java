package edu.pitt.dbmi.edda.ldatests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.Instance;

public class TopicModelUtils {

	public static String buildColumnNameForTopic(int topicIndex) {
		String formattedTopicIndex = StringUtils.leftPad(topicIndex + "", 5,
				"0");
		return "topic<" + formattedTopicIndex + ">";
	}

	public static String formatIndex(int topicIndex) {
		return StringUtils.leftPad(topicIndex + "", 5, "0");
	}

	public static String buildKey(int row, int col) {
		String rowPart = TopicModelUtils.formatIndex(row);
		String colPart = TopicModelUtils.formatIndex(col);
		return rowPart + ":" + colPart;
	}

	public static double[] inferTopicForInstance(TopicInferencer inferencer,
			Instance instance) {
		int numberOfIterations = 0;
		int thinning = 0;
		int burnIn = 0;
		final double[] topicProbs = inferencer.getSampledDistribution(instance,
				numberOfIterations, thinning, burnIn);
		return topicProbs;
	}
	
	public static double[] inferTopicForInstanceWithIterations(TopicInferencer inferencer,
			Instance instance) {
		int numberOfIterations = 10;
		int thinning = 1;
		int burnIn = 5;
		final double[] topicProbs = inferencer.getSampledDistribution(instance,
				numberOfIterations, thinning, burnIn);
		return topicProbs;
	}
	
	private int[] findZeroIndices(double[] values) {
		ArrayList<Integer> zeroIndicesArray = new ArrayList<Integer>();
		for (int jdx = 0; jdx < values.length; jdx++) {
			double value = values[jdx];
			if (value <= 0.0d && value >= 0.0d) {
				zeroIndicesArray.add(new Integer(jdx));
			}
		}
		int[] zeroIndices = new int[zeroIndicesArray.size()];
		int jdx = 0;
		for (Integer zeroIndex : zeroIndicesArray) {
			zeroIndices[jdx] = zeroIndex;
			jdx++;
		}
		return zeroIndices;
	}

	public static  double[] eliminateZeros(double[] values, int[] zeroIndices) {
		double[] filteredValues = new double[0];
		int numberRemainingValues = values.length - zeroIndices.length;
		if (numberRemainingValues <= 0) {
			filteredValues = values;
		} else {
			filteredValues = new double[numberRemainingValues];
			int nextFilteredIdx = 0;
			ArrayList<Integer> zeroIndicesArray = convertArrayToArrayList(zeroIndices);
			for (int currentValuesIdx = 0; currentValuesIdx < values.length; currentValuesIdx++) {
				if (!zeroIndicesArray.contains(currentValuesIdx)) {
					filteredValues[nextFilteredIdx] = values[currentValuesIdx];
					nextFilteredIdx++;
				}
			}
		}
		return filteredValues;
	}

	public static  ArrayList<Integer> convertArrayToArrayList(int[] values) {
		ArrayList<Integer> integerArrayList = new ArrayList<Integer>(
				values.length);
		for (int jdx : values) {
			integerArrayList.add(jdx);
		}
		return integerArrayList;
	}

	public static  String formatVector(String name, double[] v) {
		StringBuilder sb = new StringBuilder();
		Formatter out = new Formatter(sb, Locale.US);
		out.format("%20s: [ ", name);
		for (int idx = 0; idx < v.length - 1; idx++) {
			out.format("%10.4f, ", v[idx]);
		}
		out.format("%10.4f ] ", v[v.length - 1]);
		return out.toString();
	}
	
	public static void replaceEolnsWithSpaces(char[] buffer, int bufferSize) {
		for (int cdx = 0; cdx < bufferSize; cdx++) {
			char c = buffer[cdx];
			if (c == '\n') {
				buffer[cdx] = ' ';
			}
		}
	}

	public static void createNewFile(File f) throws IOException {
		if (!f.exists()) {
			f.createNewFile();
		}
	}
	
	public static String delimit(String inputString) {
		String delimiter = " ";
		String outputString = delimiter + inputString.substring(1, inputString.length());
		outputString = outputString.substring(0, outputString.length()-1) + ",";
		return outputString;
	}
	
	
}
