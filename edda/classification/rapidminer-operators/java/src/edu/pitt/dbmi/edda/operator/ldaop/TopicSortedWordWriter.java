package edu.pitt.dbmi.edda.operator.ldaop;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.Alphabet;
import cc.mallet.types.IDSorter;

public class TopicSortedWordWriter {
	
	private ParallelTopicModel model;
	
	private double[] topicDistribution;
	
	private Alphabet dataAlphabet;

	public TopicSortedWordWriter() {
		
	}
	
	public void display() {
		// Get an array of sorted sets of word ID/count pairs
		ArrayList<TreeSet<IDSorter>> topicSortedWords = model.getSortedWords();

		// Show top 5 words in topics with proportions for the first document
		for (int topic = 0; topic < model.getNumTopics(); topic++) {
			Iterator<IDSorter> iterator = topicSortedWords.get(topic)
					.iterator();
			Formatter out = new Formatter(new StringBuilder(), Locale.US);
			out.format("%d\t%.3f\t", topic, topicDistribution[topic]);
			int rank = 0;
			while (iterator.hasNext() && rank < 5) {
				IDSorter idCountPair = iterator.next();
				out.format("%s (%.0f) ",
						dataAlphabet.lookupObject(idCountPair.getID()),
						idCountPair.getWeight());
				rank++;
			}
			System.out.println(out);
		}
	}
	

	public void setModel(ParallelTopicModel model) {
		this.model = model;
	}

	public void setTopicDistribution(double[] topicDistribution) {
		this.topicDistribution = topicDistribution;
	}

	public void setDataAlphabet(Alphabet dataAlphabet) {
		this.dataAlphabet = dataAlphabet;
	}
}
