/*
 *  Edda - RegExOperator
 *
 *  Copyright (C) 2013 by Univesity of Pittsburgh DBMI Edda Project.
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
 *  along with RapidMiner.  If not, see http://www.gnu.org/licenses/.
 */
package edu.pitt.dbmi.edda.operator.regexop;

import java.io.File;
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
import com.rapidminer.parameter.ParameterTypeFile;
import com.rapidminer.parameter.ParameterTypeInt;
import com.rapidminer.parameter.ParameterTypeList;
import com.rapidminer.parameter.ParameterTypeString;
import com.rapidminer.parameter.UndefinedParameterError;
import com.rapidminer.tools.Ontology;

import edu.pitt.dbmi.edda.operator.regexop.document.DocumentFetcher;
import edu.pitt.dbmi.edda.operator.regexop.rank.RankerBinary;
import edu.pitt.dbmi.edda.operator.regexop.rank.RankerFrequency;
import edu.pitt.dbmi.edda.operator.regexop.rank.RankerOccurrence;
import edu.pitt.dbmi.edda.operator.regexop.rank.RankerRegularExpression;
import edu.pitt.dbmi.edda.operator.regexop.rank.RankerTfIdf;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegExReader;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpressionList;

public class RegExOperator extends Operator {

	public static final String PARAMETER_REGEX_FILE = "regex_file";

	public static final String PARAMETER_TEXTS = "text_directories";
	public static final String PARAMETER_TEXT_DIR = "directory";
	public static final String PARAMETER_CREATE_WORD_VECTOR = "create_word_vector";
	public static final String PARAMETER_VECTOR_CREATION = "vector_creation";
	public static final String PARAMETER_NO_OVERLAPS = "no_overlaps";
	public static final String PARAMETER_MIN_NON_ZEROS = "prune_below_absolute";
	public static final String PARAMETER_ABSTRACTS_ONLY = "abstracts_only";
	public static final String PARAMETER_GENERATE_DIAGNOSTICS = "generate_diagnostics";

	public static final String METADATA_PATH = "metadata_path";

	public static final String[] VECTOR_CREATOR_NAMES = new String[] {
			"Term Frequency", "Binary Term Occurrences", "Term Occurrences",
			"TF-IDF" };
	public static final Class<?>[] VECTOR_CREATOR_CLASSES = new Class[] {
			RankerFrequency.class, RankerBinary.class, RankerOccurrence.class,
			RankerTfIdf.class };

	private final InputPort regularExpressionListInput = getInputPorts()
			.createPort("regex list");
	private final OutputPort exampleSetOutput = getOutputPorts().createPort(
			"example set");
	private final OutputPort regularExpressionListOutput = getOutputPorts()
			.createPort("regex list");

	public RegExOperator(OperatorDescription description) {
		super(description);
		
		regularExpressionListInput.addPrecondition(new SimplePrecondition(
				regularExpressionListInput, new MetaData(
						RegularExpressionList.class), false));
		getTransformer().addRule(
				new PassThroughOrGenerateRule(regularExpressionListInput,
						regularExpressionListOutput, new MetaData(
								RegularExpressionList.class)));
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

		DocumentFetcher documentFetcher = new DocumentFetcher(
				getParameterList(PARAMETER_TEXTS));
		documentFetcher
				.setUsingAbstractsOnly(getParameterAsBoolean(PARAMETER_ABSTRACTS_ONLY));
		documentFetcher.establishLabeledDocuments();

		RankerRegularExpression ranker = establishRanker();
		ranker.setDocumentFetcher(documentFetcher);
		ranker.setGeneratingDiagnostics(getParameterAsBoolean(PARAMETER_GENERATE_DIAGNOSTICS));

		RegExOpWorker regExOperatorWorker = new RegExOpWorker();
		regExOperatorWorker
				.setGeneratingDiagnostics(getParameterAsBoolean(PARAMETER_GENERATE_DIAGNOSTICS));

		RegularExpressionList regularExpressionList = regularExpressionListInput
				.getDataOrNull();
		if (regularExpressionList == null) {
			File regexFile = getParameterAsFile(PARAMETER_REGEX_FILE);
			RegExReader regExReader = new RegExReader();
			regularExpressionList = regExReader
					.readRegularExpressionFromFile(regexFile.getAbsolutePath());
			regExOperatorWorker.setRegularExpressions(regularExpressionList);
			regExOperatorWorker.setRankerRegularExpression(ranker);
			regExOperatorWorker.process();

			ExampleSet outGoingExampleSet = regExOperatorWorker
					.getOutgoingExampleSet();
			markMetaDataAttributesSpecial(outGoingExampleSet);

			exampleSetOutput.deliver(outGoingExampleSet);
			regularExpressionListOutput.deliver(regularExpressionList);
		} else {
			// This will eliminate RegEx pruning which we don't want if
			// the RegularExpressionList is determined by a training set.
			ranker.setRequiredNumberOfNonZeroRanksPerRegEx(0);
			regExOperatorWorker.setRankerRegularExpression(ranker);
			regExOperatorWorker.setRegularExpressions(regularExpressionList);
			regExOperatorWorker.process();

			ExampleSet outGoingExampleSet = regExOperatorWorker
					.getOutgoingExampleSet();
			markMetaDataAttributesSpecial(outGoingExampleSet);

			exampleSetOutput.deliver(outGoingExampleSet);
			regularExpressionListOutput.deliver(regularExpressionList);
		}

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

	protected RankerRegularExpression establishRanker()
			throws OperatorException {
		RankerRegularExpression ranker = null;
		try {
			int strategyIndex = getParameterAsInt(PARAMETER_VECTOR_CREATION);
			Class<?> strategyClass = VECTOR_CREATOR_CLASSES[strategyIndex];
			ranker = (RankerRegularExpression) strategyClass.newInstance();
			ranker.setEliminatingSubsumedAnnotations(getParameterAsBoolean(PARAMETER_NO_OVERLAPS));
			ranker.setRequiredNumberOfNonZeroRanksPerRegEx(getParameterAsInt(PARAMETER_MIN_NON_ZEROS));
		} catch (Exception x) {
			throw new OperatorException(x.getMessage());
		}
		return ranker;
	}

	public List<ParameterType> getParameterTypes() {
		List<ParameterType> types = new LinkedList<ParameterType>();
		
		StringBuffer sb = null;
		String toolTip = null;
		
		sb = new StringBuffer();
		sb.append("XML input file of regular expressions.");
		sb.append("\n");
		toolTip = sb.toString();
		boolean isOptional = true;
		String acceptableFileExtension = null;
		ParameterType type = new ParameterTypeFile(PARAMETER_REGEX_FILE,
				toolTip, acceptableFileExtension, isOptional);
		type.setExpert(false);
		types.add(type);

		sb = new StringBuffer();
		sb.append("Specifies class and directory path pairs for corpus input.");
		sb.append("\n");
		toolTip = sb.toString();
		ParameterTypeString parameterString = new ParameterTypeString(
				"class_name", "Class");
		ParameterTypeDirectory parameterDirectory = new ParameterTypeDirectory(
				PARAMETER_TEXT_DIR,
				"Directory", false);
		type = new ParameterTypeList(PARAMETER_TEXTS, toolTip, parameterString,
				parameterDirectory);
		type.setOptional(true);
		type.setExpert(false);
		types.add(type);

		sb = new StringBuffer();
		sb.append(" Defines the attribute calculation. May be one of the following:\n");
		sb.append("       1. Match Frequency\n");
		sb.append("       2. Binary Match Occurrence\n");
		sb.append("       3. Cumulative Match Occurrences\n");
		sb.append("       4. MF-IDF Match Frequency Inverse Document Frequency\n");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeCategory(PARAMETER_VECTOR_CREATION, toolTip,
				VECTOR_CREATOR_NAMES, 0);
		type.setOptional(false);
		type.setExpert(false);
		types.add(type);

		sb = new StringBuffer();
		sb.append("Defines behavior across all regular expressions. \n");
		sb.append("If turned on, the following is true: \n");
		sb.append("When a regular expression matches a region of text, \n");
		sb.append("the region is 'off limits' to subsequent regular expression matching. \n");
		sb.append("The original XML file order determines precedence.\n");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeBoolean(PARAMETER_NO_OVERLAPS, toolTip, false);
		type.setOptional(true);
		type.setExpert(true);
		types.add(type);

		sb = new StringBuffer();
		sb.append(" A regular expression must match at least the number of times \n");
		sb.append(" specified before the expression is added to the output example set.\n");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeInt(PARAMETER_MIN_NON_ZEROS, toolTip, 0,
				Integer.MAX_VALUE, 0);
		type.setOptional(true);
		type.setExpert(true);
		types.add(type);

		sb = new StringBuffer();
		sb.append("Displays diagnostic messages to standard output.");
		sb.append("\n");
		toolTip = sb.toString();
		type = new ParameterTypeBoolean(PARAMETER_GENERATE_DIAGNOSTICS,
				toolTip, false);
		type.setOptional(true);
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
