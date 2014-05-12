package edu.pitt.dbmi.edda.operator.ldaop;


import cc.mallet.types.Instance;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.table.AttributeFactory;
import com.rapidminer.example.table.DataRow;
import com.rapidminer.example.table.MemoryExampleTable;
import com.rapidminer.tools.Ontology;

public class AttributeBuilderKulbackLeibler extends AttributeBuilder {
	
	public AttributeBuilderKulbackLeibler() {
	}
	
	protected void buildMemoryTable() {
		addAttributesForMetaData();
		String attributeLabel = "ExcludeDistance";
		attributes.add(AttributeFactory.createAttribute(
				attributeLabel, Ontology.REAL));
		attributeLabel = "IncludeDistance";
		attributes.add(AttributeFactory.createAttribute(
				attributeLabel, Ontology.REAL));
		memoryExampleTable = new MemoryExampleTable(attributes);
	}
	
	protected DataRow populateRowForDocument(Instance instance) {
		DataRow row = factory.create(memoryExampleTable.getNumberOfAttributes());
		Integer jdx = 0;
		jdx = populateRowMetaDataValues(jdx, instance, row);
		final double[] topicProbs = inferTopicForInstance(instance);
		double[] distances = new double[2];
		distances[0] = topicModelAdapter.calculateExcludeDistance(topicProbs);
		distances[1] = topicModelAdapter.calculateIncludeDistance(topicProbs);
		for (int idx = 0 ; idx < distances.length; idx++)  {
			Attribute currentAttribute = attributes.get(jdx);
			row.set(currentAttribute, distances[idx]);
			jdx++;
		}
		return row;
	}
	

}
