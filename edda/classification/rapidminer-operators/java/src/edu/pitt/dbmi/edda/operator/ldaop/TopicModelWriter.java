package edu.pitt.dbmi.edda.operator.ldaop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.Alphabet;

public class TopicModelWriter {

	public static void main(String[] args) {
		String topicModelAdapterPath = args[0];
		TopicModelWriter writer = new TopicModelWriter();
		writer.setTopicModelAdapterPath(topicModelAdapterPath);
		writer.write();
	}

	private String topicModelAdapterPath;

	public void write() {
		TopicModelAdapter topicModelAdapter = deSerializeTopicModelAdapter();
		ParallelTopicModel topicModel = topicModelAdapter.getParallelTopicModel();
		Alphabet dataAlphabet = topicModel.getAlphabet();
		double[] topicDistribution = topicModel.getTopicProbabilities(0);
		TopicSortedWordWriter sortedWordWriter = new TopicSortedWordWriter();
		sortedWordWriter.setModel(topicModel);
		sortedWordWriter.setDataAlphabet(dataAlphabet);
		sortedWordWriter.setTopicDistribution(topicDistribution);
		sortedWordWriter.display();
	}

	private TopicModelAdapter deSerializeTopicModelAdapter() {
		TopicModelAdapter result = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(topicModelAdapterPath);
			in = new ObjectInputStream(fis);
			result = (TopicModelAdapter) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	

	private void setTopicModelAdapterPath(String topicModelAdapterPath) {
		this.topicModelAdapterPath = topicModelAdapterPath;

	}

}
