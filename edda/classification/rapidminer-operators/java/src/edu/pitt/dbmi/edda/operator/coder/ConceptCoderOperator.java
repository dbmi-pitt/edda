package edu.pitt.dbmi.edda.operator.coder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.rapidminer.example.Attributes;
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
import com.rapidminer.parameter.ParameterTypeDirectory;
import com.rapidminer.parameter.ParameterTypeDouble;
import com.rapidminer.parameter.ParameterTypeInt;
import com.rapidminer.parameter.ParameterTypeList;
import com.rapidminer.parameter.ParameterTypeString;
import com.rapidminer.tools.Ontology;

import edu.pitt.dbmi.edda.operator.ldaop.TopicModelAdapter;


public class ConceptCoderOperator extends Operator {
	public static final String PARAMETER_TEXTS = "text_directories";
	public static final String PARAMETER_TEXT_DIR = "directory";
	public static final String PARAMETER_NUMBER_OF_TOPICS = "number_of_topics";
	public static final String PARAMETER_NUMBER_OF_ITERATIONS = "number_of_iterations";
	public static final String PARAMETER_BURN_IN_PERIOD = "burn_in_period";
	public static final String PARAMETER_DIRICHLET_ALPHA = "dirichlet_alpha" ;
	public static final String PARAMETER_DIRICHLET_BETA = "dirichlet_beta" ;
	public static final String PARAMETER_GENERATE_DIAGNOSTICS = "generate_diagnostics" ;
	public static final String PARAMETER_BALANCE_INSTANCES = "balance_instances" ;
	
	private final InputPort topicModelInput = getInputPorts().createPort("topic model");
	private final OutputPort exampleSetOutput = getOutputPorts().createPort("example set");
	private final OutputPort topicModelOutput = getOutputPorts().createPort("topic model");
	
	
	public ConceptCoderOperator(OperatorDescription description) {
		super(description);
		topicModelInput.addPrecondition(new SimplePrecondition(topicModelInput, new MetaData(TopicModelAdapter.class), false));
		getTransformer().addRule(new PassThroughOrGenerateRule(topicModelInput, topicModelOutput, new MetaData(TopicModelAdapter.class)));
		getTransformer().addRule(new GenerateNewMDRule(exampleSetOutput, new ExampleSetMetaData()) {
			@Override
			public MetaData modifyMetaData(MetaData unmodifiedMetaData) {
				// construction of meta data
				ExampleSetMetaData emd = (ExampleSetMetaData) unmodifiedMetaData;
				AttributeMetaData amd = new AttributeMetaData(Attributes.LABEL_NAME, Ontology.BINOMINAL, Attributes.LABEL_NAME);
				final List<String> labelValuesList = new ArrayList<String>();
				labelValuesList.add("exclude") ;
				labelValuesList.add("include") ;
				amd.setValueSet(new HashSet<String>(labelValuesList), SetRelation.EQUAL);
				emd.addAttribute(amd);
				return emd;
			}
		});
	}
	
	public void doWork() throws OperatorException {
	
		/*
		List<String[]> labelDirectoryPairs = getParameterList(PARAMETER_TEXTS);
	
		TopicModelWorker topicModelWorker = new TopicModelWorker();
		topicModelWorker.setLabelDirectoryPairs(labelDirectoryPairs);
		topicModelWorker.setNumTopics(getParameterAsInt(PARAMETER_NUMBER_OF_TOPICS));
		topicModelWorker.setNumberOfIterations(getParameterAsInt(PARAMETER_NUMBER_OF_ITERATIONS));
		topicModelWorker.setBurnInPeriod(getParameterAsInt(PARAMETER_BURN_IN_PERIOD));
		topicModelWorker.setAlpha(getParameterAsDouble(PARAMETER_DIRICHLET_ALPHA));
		topicModelWorker.setBeta(getParameterAsDouble(PARAMETER_DIRICHLET_BETA));
		topicModelWorker.setBalancingInstances(getParameterAsBoolean(PARAMETER_BALANCE_INSTANCES));
		topicModelWorker.setGeneratingDiagnostics(getParameterAsBoolean(PARAMETER_GENERATE_DIAGNOSTICS));
		
		TopicModelAdapter topicModelAdapter = topicModelInput.getDataOrNull();
		
		if (topicModelAdapter != null) {
			topicModelWorker.setParallelTopicModel(topicModelAdapter.getParallelTopicModel());
		}
		
		topicModelWorker.process();
		
		topicModelAdapter = new TopicModelAdapter(topicModelWorker.getParallelTopicModel(), topicModelWorker.getOutgoingExampleSet());
		
		exampleSetOutput.deliver(topicModelWorker.getOutgoingExampleSet());
		topicModelOutput.deliver(topicModelAdapter) ;
		*/
	
	}
	
	public List<ParameterType> getParameterTypes() {
		/**
		 * TODO: here I want to select a terminology
		 * maybe create a new one
		 * select files that will be coded and select a metric
		 * use cuis vs preferred names
		 * tf/idf vs term occurance vs term frequency vs binary term occurance
		 * 
		 */
		
		
		List<ParameterType> types = new LinkedList<ParameterType>();
		
		String toolTip = "In this list arbitrary directories can be specified. All files matching the given file" ;
		toolTip += "ending will be loaded and assigned to the class value provided with the directory." ;
		ParameterTypeString parameterString = new ParameterTypeString("class_name", "The name of the class, this texts are assigned.") ;
		ParameterTypeDirectory parameterDirectory = new ParameterTypeDirectory(
				PARAMETER_TEXT_DIR, "Specifies the directory of file of this class.", false);
		ParameterType type = new ParameterTypeList(PARAMETER_TEXTS, toolTip, parameterString, parameterDirectory);
		type.setExpert(false);
		types.add(type);
		
		toolTip = "Number of topics." ;
		type = new ParameterTypeInt(PARAMETER_NUMBER_OF_TOPICS, toolTip, 0, Integer.MAX_VALUE, 10);
		type.setExpert(false);
		types.add(type);
		
		toolTip = "Number of iterations." ;
		type = new ParameterTypeInt(PARAMETER_NUMBER_OF_ITERATIONS, toolTip, 0, Integer.MAX_VALUE, 5000);
		type.setExpert(false);
		types.add(type);
		
		toolTip = "Burn In Period." ;
		type = new ParameterTypeInt(PARAMETER_BURN_IN_PERIOD, toolTip, 0, Integer.MAX_VALUE, 500);
		type.setExpert(false);
		types.add(type);
			
		toolTip = "Alpha parameter for Dirichlet Allocation." ;
		type = new ParameterTypeDouble(PARAMETER_DIRICHLET_ALPHA, toolTip, Double.MIN_VALUE, Double.MAX_VALUE, 1.0d);
		type.setExpert(false);
		types.add(type);
		
		toolTip = "Beta parameter for Dirichlet Allocation." ;
		type = new ParameterTypeDouble(PARAMETER_DIRICHLET_BETA, toolTip, Double.MIN_VALUE, Double.MAX_VALUE, 0.01d);
		type.setExpert(false);
		types.add(type);
		
		toolTip = "Randomly balance the exclude and include instances." ;
		type = new ParameterTypeBoolean(PARAMETER_BALANCE_INSTANCES, toolTip, false);
		type.setExpert(true);
		types.add(type);
		
		toolTip = "Generate diagnostic messages to standard java output." ;
		type = new ParameterTypeBoolean(PARAMETER_GENERATE_DIAGNOSTICS, toolTip, false);
		type.setExpert(true);
		types.add(type);
		
		return types;
	}

}
