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
package edu.pitt.dbmi.edda.operator.c45bayes;

import java.util.LinkedList;
import java.util.List;

import com.rapidminer.example.ExampleSet;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.ports.metadata.ExampleSetMetaData;
import com.rapidminer.operator.ports.metadata.GenerateModelTransformationRule;
import com.rapidminer.operator.ports.metadata.MetaData;
import com.rapidminer.operator.ports.metadata.SimplePrecondition;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeInt;
import com.rapidminer.parameter.UndefinedParameterError;

/**
 * Abstract superclass of all operators modifying an example set, i.e. accepting an {@link ExampleSet} as input and
 * delivering an {@link ExampleSet} as output. The behaviour is delegated from the {@link #doWork()} method to
 * {@link #apply(ExampleSet)}.
 * 
 * @author Simon Fischer
 */
public class C45BayesOperator extends Operator {
	
	public static final String PARAMETER_MAX_NUM_DISC_FTRS = "max_num_disc_ftrs";

	private final InputPort exampleSetInput = getInputPorts().createPort("example set input");
	private final OutputPort originalOutput = getOutputPorts().createPort("example set original");
	private final OutputPort c45BayesOutput = getOutputPorts().createPort("c45 bayes model");
	
	public C45BayesOperator(OperatorDescription description) {
		super(description);
		exampleSetInput.addPrecondition(new SimplePrecondition(exampleSetInput, getRequiredMetaData()));
		getTransformer().addRule(new GenerateModelTransformationRule(getExampleSetInputPort(),c45BayesOutput, C45BayesModel.class));
		getTransformer().addPassThroughRule(exampleSetInput, originalOutput);
	}

	/** Returns the example set input port, e.g. for adding errors. */
	protected final InputPort getInputPort() {
		return exampleSetInput;
	}

	/**
	 * Subclasses might override this method to define the meta data transformation performed by this operator.
	 * 
	 * @throws UndefinedParameterError
	 */
	protected MetaData modifyMetaData(ExampleSetMetaData metaData) throws UndefinedParameterError {
		return metaData;
	}

	/**
	 * Subclasses my override this method to define more precisely the meta data expected by this operator.
	 */
	protected ExampleSetMetaData getRequiredMetaData() {
		return new ExampleSetMetaData();
	}

	@Override
	public final void doWork() throws OperatorException {
		ExampleSet inputExampleSet = exampleSetInput.getData(ExampleSet.class);
		C45BayesModel model = new C45BayesModel(inputExampleSet, 0.0d);
		model.setMaximumNumberOfDiscriminatingFeatures(getParameterAsInt(PARAMETER_MAX_NUM_DISC_FTRS));
		model.train();
		System.out.println(model);
		originalOutput.deliver(inputExampleSet);
		c45BayesOutput.deliver(model);
	}

	public InputPort getExampleSetInputPort() {
		return exampleSetInput;
	}
	
public List<ParameterType> getParameterTypes() {
		
		List<ParameterType> types = new LinkedList<ParameterType>();
		
		String toolTip =  "Max # of features" ;
		ParameterType type = new ParameterTypeInt(PARAMETER_MAX_NUM_DISC_FTRS, toolTip, 1, Integer.MAX_VALUE, 5);
		type.setExpert(false);
		types.add(type);
	
		return types;
	}

}
