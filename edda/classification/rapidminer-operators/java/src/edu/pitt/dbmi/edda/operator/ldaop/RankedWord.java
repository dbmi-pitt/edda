package edu.pitt.dbmi.edda.operator.ldaop;

import org.apache.commons.lang.StringUtils;

public class RankedWord {
	private static int maxWordLength = Integer.MIN_VALUE;
	public static int getOutputSpan() {
		return maxWordLength + 7;
	}
	private String word;
	private Double probability;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		if (word.length() > maxWordLength) {
			maxWordLength = word.length();
		}
		this.word = word;
	}
	public Double getProbability() {
		return probability;
	}
	public void setProbability(Double probability) {
		this.probability = probability;
	}
	public String getFormattedWord() {
		return StringUtils.leftPad(word,  maxWordLength, " ");
	}
	public String getFormattedProbability() {
		return String.format("%3.3f", probability);
	}
	public String toString() {
		String response = getFormattedWord() + " " + getFormattedProbability() + " ";
		return response;
	}
}