package edu.pitt.dbmi.edda.replication;

public class WeightedWord implements Comparable<Object> {
	public String word;
	public Double weight;
	public int compareTo(Object obj) {
		WeightedWord weightedWord = (WeightedWord) obj;
		return this.word.compareTo(weightedWord.word);
	}
	public String toString() {
		return this.word + " ==> " + this.weight;
	}
}
