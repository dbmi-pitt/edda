package edu.pitt.dbmi.edda.operator.ldaop;

import java.util.Formatter;
import java.util.Locale;
import java.util.logging.Logger;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.Alphabet;
import cc.mallet.types.FeatureSequence;
import cc.mallet.types.InstanceList;
import cc.mallet.types.LabelSequence;

public class InstanceWriter {
	
	private final static Logger logger = Logger.getLogger(InstanceWriter.class .getName()); 
	
	private ParallelTopicModel model;

	private InstanceList instances;

	public InstanceWriter() {
		;
	}

	public void display(int instanceNumber) {

		Alphabet dataAlphabet = instances.getDataAlphabet();

		FeatureSequence tokens = (FeatureSequence) model.getData().get(instanceNumber).instance
				.getData();
		LabelSequence topics = model.getData().get(instanceNumber).topicSequence;

		Formatter out = new Formatter(new StringBuilder(), Locale.US);
		for (int position = 0; position < tokens.getLength(); position++) {
			out.format("%s-%d ", dataAlphabet.lookupObject(tokens
					.getIndexAtPosition(position)), topics
					.getIndexAtPosition(position));
		}
		
		logger.fine(out.toString());
		
	}
	
	public void setModel(ParallelTopicModel model) {
		this.model = model;
	}

	public void setInstances(InstanceList instances) {
		this.instances = instances;
	}

}
