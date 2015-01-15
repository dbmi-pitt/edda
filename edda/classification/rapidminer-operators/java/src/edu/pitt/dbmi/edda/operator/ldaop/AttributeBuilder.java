package edu.pitt.dbmi.edda.operator.ldaop;

import java.io.File;
import java.net.URI;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.Instance;
import cc.mallet.types.InstanceList;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.table.AttributeFactory;
import com.rapidminer.example.table.DataRow;
import com.rapidminer.example.table.DataRowFactory;
import com.rapidminer.example.table.MemoryExampleTable;
import com.rapidminer.tools.Ontology;

public abstract class AttributeBuilder {
	
	private final static Logger logger = Logger.getLogger(AttributeBuilder.class .getName()); 

	protected InstanceList instances;

	protected TopicModelAdapter topicModelAdapter;

	protected ParallelTopicModel topicModel;

	protected TopicInferencer inferencer;

	protected boolean isGeneratingDiagnostics = false;

	protected final Set<Attribute> unusedAttributes = new HashSet<Attribute>();

	protected final List<Attribute> attributes = new LinkedList<Attribute>();

	protected Attribute outgoingLabelAttribute;
	protected Attribute filePathAttribute;
	protected Attribute fileNameAttribute;
	protected Attribute fileTypeAttribute;
	protected Attribute fileDateAttribute;
	protected Attribute fileSizeAttribute;

	protected MemoryExampleTable memoryExampleTable;

	protected DataRowFactory factory;

	protected ExampleSet exampleSet;

	protected int inferencerIterations = 0;

	protected int inferencerThinning = 0;

	protected int inferencerBurnInPeriod = 0;

	public AttributeBuilder() {
	}

	public void createAttributes() {

		initializeTableBuilding();

		traverseInstancesWhileFillingTableColumns();

		exampleSet = memoryExampleTable
				.createExampleSet(outgoingLabelAttribute);

		if (isGeneratingDiagnostics) {
			logger.info("Finished generating ExampleSet. ");
		}

	}

	protected void initializeTableBuilding() {
		clearAttributes();
		buildOutgoingLabelAttribute();
		buildFilePathAttribute();
		buildMemoryTable();
		buildDataRowFactory();
	}

	protected void buildOutgoingLabelAttribute() {
		outgoingLabelAttribute = AttributeFactory.createAttribute("label",
				Ontology.BINOMINAL);
	}

	protected void buildFilePathAttribute() {
		filePathAttribute = AttributeFactory.createAttribute(
				TopicModelOperator.METADATA_PATH, Ontology.POLYNOMINAL);

	}

	protected void clearAttributes() {
		attributes.clear();
		unusedAttributes.clear();
	}

	protected void buildDataRowFactory() {
		factory = new DataRowFactory(DataRowFactory.TYPE_DOUBLE_ARRAY, '.');
	}

	protected void traverseInstancesWhileFillingTableColumns() {
		if (isGeneratingDiagnostics()) {
			logger.info("Attribute Builder: building a matrix "
					+ instances.size() + " x "
					+ memoryExampleTable.getNumberOfAttributes());
		}
		for (Instance instance : instances) {
			DataRow row = populateRowForDocument(instance);
			memoryExampleTable.addDataRow(row);
		}
	}

	protected void addAttributesForMetaData() {
		attributes.add(outgoingLabelAttribute);
		attributes.add(filePathAttribute);
	}

	protected Integer populateRowMetaDataValues(Integer idx, Instance instance,
			DataRow row) {
		String label = instance.getTarget().toString();
		row.set(outgoingLabelAttribute, outgoingLabelAttribute.getMapping()
				.mapString(label));
		idx++;
		URI sourceFileURI = fetchUriFromInstance(instance);
		File f = new File(sourceFileURI);
		String filePath = f.getAbsolutePath();
		row.set(filePathAttribute,
				filePathAttribute.getMapping().mapString(filePath));
		idx++;
		return idx;
	}

	private URI fetchUriFromInstance(Instance instance) {
		URI uri = null;
		Object uriObject = instance.getName();
		if (!(uriObject instanceof URI) && (uriObject instanceof String)) {
			uri = new File((String)uriObject).toURI();
		} else {
			uri = (URI) uriObject;
		}
		return uri;
	}

	protected abstract void buildMemoryTable();

	protected abstract DataRow populateRowForDocument(Instance instance);

	protected double[] inferTopicForInstance(Instance instance) {
		final double[] topicProbs = inferencer.getSampledDistribution(instance,
				getInferencerIterations(), getInferencerThinning(),
				getInferencerBurnInPeriod());
		return topicProbs;
	}

	protected static Attribute createAttribute(Set<String> usedAttributeNames,
			String desiredName, int attributeType) {
		String uniqueAttributeName = getUniqueAttributeName(usedAttributeNames,
				desiredName);
		usedAttributeNames.add(uniqueAttributeName);
		return AttributeFactory.createAttribute(uniqueAttributeName,
				attributeType);
	}

	protected static String getUniqueAttributeName(
			Set<String> usedAttributeNames, String desiredName) {
		if (!usedAttributeNames.contains(desiredName))
			return desiredName;
		int i = 0;
		while (usedAttributeNames.contains(desiredName + "_" + i))
			i++;
		return desiredName + "_" + i;
	}

	public void setInstances(InstanceList instances) {
		this.instances = instances;
	}

	public ExampleSet getExampleSet() {
		return this.exampleSet;
	}

	public void setExampleSet(ExampleSet exampleSet) {
		this.exampleSet = exampleSet;
	}

	public boolean isGeneratingDiagnostics() {
		return isGeneratingDiagnostics;
	}

	public void setGeneratingDiagnostics(boolean isGeneratingDiagnostics) {
		this.isGeneratingDiagnostics = isGeneratingDiagnostics;
	}

	public TopicModelAdapter getTopicModelAdapter() {
		return topicModelAdapter;
	}

	public void setTopicModelAdapter(TopicModelAdapter topicModelAdapter) {
		this.topicModelAdapter = topicModelAdapter;
		setTopicModel(this.topicModelAdapter.getParallelTopicModel());
	}

	public int getInferencerIterations() {
		return inferencerIterations;
	}

	public void setInferencerIterations(int inferencerIterations) {
		this.inferencerIterations = inferencerIterations;
	}

	public int getInferencerThinning() {
		return inferencerThinning;
	}

	public void setInferencerThinning(int inferencerThinning) {
		this.inferencerThinning = inferencerThinning;
	}

	public int getInferencerBurnInPeriod() {
		return inferencerBurnInPeriod;
	}

	public void setInferencerBurnInPeriod(int inferencerBurnInPeriod) {
		this.inferencerBurnInPeriod = inferencerBurnInPeriod;
	}

	public ParallelTopicModel getTopicModel() {
		return topicModel;
	}

	public void setTopicModel(ParallelTopicModel topicModel) {
		this.topicModel = topicModel;
		this.inferencer = this.topicModel.getInferencer();
	}

}
