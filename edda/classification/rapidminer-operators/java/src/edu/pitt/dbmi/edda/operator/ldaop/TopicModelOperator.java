/*
 *  Edda
 *
 *  Copyright (C) 2001-2009 by Rapid-I and the contributors
 *
 *  Complete list of developers available at our web site:
 *
 *       http://rapid-i.com
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package edu.pitt.dbmi.edda.operator.ldaop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.Attributes;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.UserError;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.ports.metadata.AttributeMetaData;
import com.rapidminer.operator.ports.metadata.ExampleSetMetaData;
import com.rapidminer.operator.ports.metadata.GenerateNewMDRule;
import com.rapidminer.operator.ports.metadata.MetaData;
import com.rapidminer.operator.ports.metadata.PassThroughOrGenerateRule;
import com.rapidminer.operator.ports.metadata.SetRelation;
import com.rapidminer.operator.ports.metadata.SimplePrecondition;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeBoolean;
import com.rapidminer.parameter.ParameterTypeCategory;
import com.rapidminer.parameter.ParameterTypeDirectory;
import com.rapidminer.parameter.ParameterTypeDouble;
import com.rapidminer.parameter.ParameterTypeInt;
import com.rapidminer.parameter.ParameterTypeList;
import com.rapidminer.parameter.ParameterTypeString;
import com.rapidminer.parameter.UndefinedParameterError;
import com.rapidminer.tools.Ontology;

public class TopicModelOperator extends Operator {

	public static final String PARAMETER_TEXTS = "text_directories";
	public static final String PARAMETER_TEXT_DIR = "directory";
	public static final String PARAMETER_NUMBER_OF_TOPICS = "number_of_topics";
	public static final String PARAMETER_NUMBER_OF_ITERATIONS = "number_of_iterations";
	public static final String PARAMETER_BURN_IN_PERIOD = "burn_in_period";
	public static final String PARAMETER_DIRICHLET_ALPHA = "dirichlet_alpha";
	public static final String PARAMETER_DIRICHLET_BETA = "dirichlet_beta";
	public static final String PARAMETER_RANDOM_SEED = "random_seed";
	public static final String PARAMETER_OPTIMIZE_INTERVAL = "optimize_interval";
	public static final String PARAMETER_SYMMETRIC_ALPHA = "symmetric_alpha";
	public static final String PARAMETER_TEMPERING_INTERVAL = "tempering interval";
	public static final String PARAMETER_INFERENCER_ITERATIONS = "inferencer_iterations";
	public static final String PARAMETER_INFERENCER_THINNING = "inferencer_thinning";
	public static final String PARAMETER_INFERENCER_BURN_IN_PERIOD = "inferencer_burn_in_period";
	public static final String PARAMETER_GENERATE_DIAGNOSTICS = "generate_diagnostics";
	public static final String PARAMETER_NUM_MOST_PROB_TO_DISPLAY = "num_most_prob_to_display";

	public static final String PARAMETER_EXAMPLE_SET_FEATURES = "example_set_features";

	public static final String[] EXAMPLE_SET_FEATURES = new String[] {
			"Document Thetas", "KL Divergence (From Medians)", "Both" };

	public static final int ES_FTRS_DOC_THETAS = 0;
	public static final int ES_FTRS_KL_DIVERGE = 1;
	public static final int ES_FTRS_BOTH = 2;

	public static final String METADATA_PATH = "metadata_path";

	private final InputPort exampleSetInput = getInputPorts().createPort(
			"example set");
	private final InputPort topicModelInput = getInputPorts().createPort(
			"topic model");
	private final OutputPort exampleSetOutput = getOutputPorts().createPort(
			"example set");
	private final OutputPort topicModelOutput = getOutputPorts().createPort(
			"topic model");
	
	public TopicModelOperator(OperatorDescription description) {
		super(description);
		
		exampleSetInput.addPrecondition(new SimplePrecondition(exampleSetInput, 
				new MetaData(ExampleSet.class), false));

		topicModelInput.addPrecondition(new SimplePrecondition(topicModelInput,
				new MetaData(TopicModelAdapter.class), false));
		getTransformer()
				.addRule(
						new PassThroughOrGenerateRule(topicModelInput,
								topicModelOutput, new MetaData(
										TopicModelAdapter.class)));
		getTransformer().addRule(
				new GenerateNewMDRule(exampleSetOutput,
						new ExampleSetMetaData()) {
					public MetaData modifyMetaData(MetaData unmodifiedMetaData) {
						ExampleSetMetaData emd = (ExampleSetMetaData) unmodifiedMetaData;
						emd = addMetaDataAttributes(emd);
						return emd;
					}
				});
	}

	@Override
	public void doWork() throws OperatorException {
		
		List<String[]> labelDirectoryPairs = getParameterList(PARAMETER_TEXTS);
	
		TopicModelWorker topicModelWorker = new TopicModelWorker();
		ExampleSet es = exampleSetInput.getDataOrNull();
		topicModelWorker.setInputExampleSet(es);
		
		final ExampleSetVerifier exampleSetVerifier = new ExampleSetVerifier(es);
		if (!exampleSetVerifier.isVerified()) {
			throw new UserError(this, "edda.corrupt_es_input");
		}
		
		topicModelWorker.setLabelDirectoryPairs(labelDirectoryPairs);
		topicModelWorker
				.setNumTopics(getParameterAsInt(PARAMETER_NUMBER_OF_TOPICS));
		topicModelWorker
				.setNumberOfIterations(getParameterAsInt(PARAMETER_NUMBER_OF_ITERATIONS));
		topicModelWorker
				.setBurnInPeriod(getParameterAsInt(PARAMETER_BURN_IN_PERIOD));
		topicModelWorker
				.setAlpha(getParameterAsDouble(PARAMETER_DIRICHLET_ALPHA));
		topicModelWorker
				.setBeta(getParameterAsDouble(PARAMETER_DIRICHLET_BETA));
		topicModelWorker
				.setRandomSeed(getParameterAsInt(PARAMETER_RANDOM_SEED));
		topicModelWorker
				.setOptimizeInterval(getParameterAsInt(PARAMETER_OPTIMIZE_INTERVAL));
		topicModelWorker
				.setSymmetricAlpha(getParameterAsBoolean(PARAMETER_SYMMETRIC_ALPHA));
		topicModelWorker
				.setTemperingInterval(getParameterAsInt(PARAMETER_TEMPERING_INTERVAL));

		topicModelWorker
				.setNumberMostProbableWordsForDisplay(getParameterAsInt(PARAMETER_NUM_MOST_PROB_TO_DISPLAY));
		topicModelWorker
				.setGeneratingDiagnostics(getParameterAsBoolean(PARAMETER_GENERATE_DIAGNOSTICS));

		specifyOutputExampleSet(topicModelWorker);

		if (topicModelWorker.getAlpha() < 0.0d) {
			Double calculatedAlpha = 50.0d / ((double) topicModelWorker
					.getNumTopics());
			topicModelWorker.setAlpha(calculatedAlpha);
		}

		TopicModelAdapter topicModelAdapter = topicModelInput.getDataOrNull();

		if (topicModelAdapter != null) {
			topicModelWorker.setTopicModelAdapter(topicModelAdapter);
		}

		topicModelWorker.process();

		ExampleSet outGoingExampleSet = topicModelWorker
				.getOutgoingExampleSet();
		markMetaDataAttributesSpecial(outGoingExampleSet);

		exampleSetOutput.deliver(outGoingExampleSet);
		topicModelOutput.deliver(topicModelWorker.getTopicModelAdapter());

	}

	private void markMetaDataAttributesSpecial(ExampleSet outGoingExampleSet) {
		final ArrayList<Attribute> metaDataAttributes = new ArrayList<Attribute>();
		Attributes attributes = outGoingExampleSet.getAttributes();
		for (Iterator<Attribute> attributeIterator = attributes.iterator(); attributeIterator
				.hasNext();) {
			Attribute attribute = attributeIterator.next();
			boolean isMetaDataAttribute = false;
			isMetaDataAttribute |= attribute.getName().equals(METADATA_PATH);
			if (isMetaDataAttribute) {
				metaDataAttributes.add(attribute);
			}
		}
		for (Attribute attribute : metaDataAttributes) {
			outGoingExampleSet.getAttributes().setSpecialAttribute(attribute,
					attribute.getName());
		}
	}

	private void specifyOutputExampleSet(TopicModelWorker topicModelWorker)
			throws UndefinedParameterError {
		int exampleSetSelectionCriteria = getParameterAsInt(PARAMETER_EXAMPLE_SET_FEATURES);
		switch (exampleSetSelectionCriteria) {
		case ES_FTRS_DOC_THETAS:
			topicModelWorker.setOutputingDocumentThetas(true);
			topicModelWorker.setOutputingKulbachLeiblerDivergences(false);
			break;
		case ES_FTRS_KL_DIVERGE:
			topicModelWorker.setOutputingDocumentThetas(false);
			topicModelWorker.setOutputingKulbachLeiblerDivergences(true);
			break;
		default:
			topicModelWorker.setOutputingDocumentThetas(true);
			topicModelWorker.setOutputingKulbachLeiblerDivergences(true);
		}
	}

	public List<ParameterType> getParameterTypes() {

		List<ParameterType> types = new LinkedList<ParameterType>();
		
		StringBuffer sb = null;
		String toolTip = null;
		
		sb = new StringBuffer();
		sb.append("Specifies class and directory path pairs for corpus input.");
		sb.append("\n");
		sb.append("This parameter is ignored if an input example set is given.");
		toolTip = sb.toString();
		ParameterTypeString parameterString = new ParameterTypeString(
				"class_name", "Class name");
		ParameterTypeDirectory parameterDirectory = new ParameterTypeDirectory(
				PARAMETER_TEXT_DIR,
				"Directory of files", false);
		ParameterType type = new ParameterTypeList(PARAMETER_TEXTS, toolTip,
				parameterString, parameterDirectory);
		type.setOptional(true);
		type.setExpert(false);
		types.add(type);
		
		sb = new StringBuffer();
		sb.append("The number of topics for this model.");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeInt(PARAMETER_NUMBER_OF_TOPICS, toolTip, 0,
				Integer.MAX_VALUE, 10);
		type.setExpert(false);
		types.add(type);

		sb = new StringBuffer();
		sb.append("Alpha parameter of the Dirichlet prior.");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeDouble(PARAMETER_DIRICHLET_ALPHA, toolTip,
				-1.0d, Double.MAX_VALUE, 1.0d);
		type.setExpert(false);
		types.add(type);

		sb = new StringBuffer();
		sb.append("Beta parameter of the Dirichlet prior.");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeDouble(PARAMETER_DIRICHLET_BETA, toolTip,
				Double.MIN_VALUE, Double.MAX_VALUE, 0.01d);
		type.setExpert(false);
		types.add(type);

		sb = new StringBuffer();
		sb.append("Number of iterations of the Gibbs MCMC algorithm.");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeInt(PARAMETER_NUMBER_OF_ITERATIONS, toolTip, 0,
				Integer.MAX_VALUE, 1000);
		type.setExpert(false);
		types.add(type);

		sb = new StringBuffer();
		sb.append("Iterations before theta and phi begin to influence zeta assignments.");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeInt(PARAMETER_BURN_IN_PERIOD, toolTip, 0,
				Integer.MAX_VALUE, 50);
		type.setExpert(false);
		types.add(type);

		sb = new StringBuffer();
		sb.append("Thetas, KL divergences, or both.");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeCategory(PARAMETER_EXAMPLE_SET_FEATURES,
				toolTip, EXAMPLE_SET_FEATURES, ES_FTRS_DOC_THETAS);
		type.setExpert(false);
		types.add(type);

		sb = new StringBuffer();
		sb.append("Shows N most probable words (tokens) per topic in a visualization screen. ");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeInt(PARAMETER_NUM_MOST_PROB_TO_DISPLAY, toolTip,
				0, Integer.MAX_VALUE, 10);
		type.setExpert(false);
		types.add(type);

		sb = new StringBuffer();
		sb.append("For repeatable results over runs, users should set this parameter.");
		sb.append("\n");
		sb.append("It will cause the pseudo random number generator to repeat the same sequences,");
		sb.append("\n");
		sb.append("thus driving the algorithm to the same conclusion.");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeInt(PARAMETER_RANDOM_SEED, toolTip, 0,
				Integer.MAX_VALUE, 2013);
		type.setExpert(true);
		types.add(type);

		sb = new StringBuffer();
		sb.append("see Mallet");
		sb.append("\n");
		toolTip = sb.toString();
		
		type = new ParameterTypeBoolean(PARAMETER_SYMMETRIC_ALPHA, toolTip,
				new Boolean(true));
		type.setExpert(true);
		types.add(type);

		type = new ParameterTypeInt(PARAMETER_OPTIMIZE_INTERVAL, toolTip, 0,
				Integer.MAX_VALUE, 10);
		type.setExpert(true);
		types.add(type);

		type = new ParameterTypeInt(PARAMETER_TEMPERING_INTERVAL, toolTip, 0,
				Integer.MAX_VALUE, 0);
		type.setExpert(true);
		types.add(type);

		type = new ParameterTypeInt(PARAMETER_INFERENCER_ITERATIONS, toolTip,
				0, Integer.MAX_VALUE, 0);
		type.setExpert(true);
		types.add(type);

		type = new ParameterTypeInt(PARAMETER_INFERENCER_THINNING, toolTip, 0,
				Integer.MAX_VALUE, 0);
		type.setExpert(true);
		types.add(type);

		type = new ParameterTypeInt(PARAMETER_INFERENCER_BURN_IN_PERIOD,
				toolTip, 0, Integer.MAX_VALUE, 0);
		type.setExpert(true);
		types.add(type);

		sb = new StringBuffer();
		sb.append("Displays diagnostic messages to standard output.");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeBoolean(PARAMETER_GENERATE_DIAGNOSTICS,
				toolTip, false);
		type.setExpert(true);
		types.add(type);

		return types;
	}

	protected ExampleSetMetaData addMetaDataAttributes(ExampleSetMetaData emd) {
		try {
			AttributeMetaData amd = new AttributeMetaData(
					Attributes.LABEL_NAME, getProvidedLabelType(),
					Attributes.LABEL_NAME);
			amd.setValueSet(new HashSet<String>(getLabelValues()),
					SetRelation.EQUAL);
			emd.addAttribute(amd);
			emd.addAttribute(new AttributeMetaData(METADATA_PATH,
					Ontology.POLYNOMINAL, METADATA_PATH));
		} catch (Exception e) {
		}
		return emd;
	}

	protected int getProvidedLabelType() throws UndefinedParameterError {
		List<String[]> values = getParameterList(PARAMETER_TEXTS);
		if (values.size() == 2)
			return Ontology.BINOMINAL;
		else
			return Ontology.POLYNOMINAL;
	}

	protected List<String> getLabelValues() {
		List<String> labelValues = new LinkedList<String>();
		try {
			List<String[]> values = getParameterList(PARAMETER_TEXTS);
			for (String[] pair : values)
				labelValues.add(pair[0]);
		} catch (UndefinedParameterError e) {
			// simply return empty list
		}
		return labelValues;
	}
}
