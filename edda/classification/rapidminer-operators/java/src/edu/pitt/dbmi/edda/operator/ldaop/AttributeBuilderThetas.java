package edu.pitt.dbmi.edda.operator.ldaop;

import java.io.File;

import cc.mallet.types.Instance;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.table.AttributeFactory;
import com.rapidminer.example.table.DataRow;
import com.rapidminer.example.table.MemoryExampleTable;
import com.rapidminer.tools.Ontology;

public class AttributeBuilderThetas extends AttributeBuilder {
	
	public AttributeBuilderThetas() {
	}
	
	protected void buildMemoryTable() {
		addAttributesForMetaData();
		for (int topicIndex = 0 ; topicIndex < topicModel.getNumTopics() ; topicIndex++) {
			String attributeLabel = TopicModelUtils.buildColumnNameForTopic(topicIndex);
			attributes.add(AttributeFactory.createAttribute(
					attributeLabel, Ontology.REAL));
		}
		memoryExampleTable = new MemoryExampleTable(attributes);
	}
	
	protected DataRow populateRowForDocument(Instance instance) {
		DataRow row = factory.create(memoryExampleTable.getNumberOfAttributes());
		Integer jdx = 0;
		jdx = populateRowMetaDataValues(jdx, instance, row);
		final double[] topicProbs = TopicModelUtils.inferTopicForInstance(inferencer, instance, false);
		for (double topicProb : topicProbs) {
			Attribute currentAttribute = attributes.get(jdx);
			row.set(currentAttribute, topicProb);
			jdx++;
		}
		return row;
	}
	
}
