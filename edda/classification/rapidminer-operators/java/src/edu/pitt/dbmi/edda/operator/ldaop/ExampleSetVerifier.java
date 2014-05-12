package edu.pitt.dbmi.edda.operator.ldaop;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.Attributes;
import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.Tools;
import com.rapidminer.tools.Ontology;

public class ExampleSetVerifier {

	private ExampleSet exampleSet;
	private boolean isVerified = true;
	private Set<String> regularAttributeNames = new HashSet<String>();
	private Set<String> specialAttributeNames = new HashSet<String>();
	
	public ExampleSetVerifier(ExampleSet exampleSet) {
		this.exampleSet = exampleSet;
		
		if (exampleSet != null) {
			
			cacheRegularAttributeNames();
			cacheSpecialAttributeNames();			
			
			isVerified = isVerified && hasLabelAttribute();
			isVerified = isVerified && isBinominalLabel();
			isVerified = isVerified && hasAllNumericalRegularAttributes();
			isVerified = isVerified && hasAllIntegerRegularAttributeValues();
		
		}
	}
	
	private void cacheRegularAttributeNames() {
		final String[] regularAttributeNamesArray = Tools.getRegularAttributeNames(exampleSet);
		for (String attributeName : regularAttributeNamesArray) {
			regularAttributeNames.add(attributeName);
		}
	}
	
	private void cacheSpecialAttributeNames() {
		final String[] allAttributeNamesArray = Tools.getAllAttributeNames(exampleSet);
		for (String attributeName : allAttributeNamesArray) {
			if (!regularAttributeNames.contains(attributeName)) {
				specialAttributeNames.add(attributeName);
			}
		}
	}
	
	private boolean isRegular(Attribute attribute) {
		return regularAttributeNames.contains(attribute.getName());
	}
	
	private boolean isSpecial(Attribute attribute) {
		return specialAttributeNames.contains(attribute.getName());
	}
	
	private boolean isNumerical(Attribute attribute) {
		return Ontology.ATTRIBUTE_VALUE_TYPE.isA(attribute.getValueType(),
				Ontology.NUMERICAL);
	}

	private boolean hasLabelAttribute() {
		Attributes attributes = exampleSet.getAttributes();
		Attribute labelAttribute = attributes.getLabel();
		return labelAttribute != null && isSpecial(labelAttribute) ;
	}

	private boolean isBinominalLabel() {
		Attributes attributes = exampleSet.getAttributes();
		Attribute labelAttribute = attributes.getLabel();
		return Ontology.ATTRIBUTE_VALUE_TYPE.isA(labelAttribute.getValueType(),
				Ontology.BINOMINAL);
	}
	

	private boolean hasAllNumericalRegularAttributes() {
		boolean result = true;
		for (Attribute attribute : exampleSet.getAttributes()) {
			if (isRegular(attribute) && !isNumerical(attribute)) {
				result = false;
				break;
			}
		}
		return result;
	}

	private boolean hasAllIntegerRegularAttributeValues() {
		boolean result = true;
		for (Iterator<Example> exampleIterator = exampleSet.iterator(); exampleIterator
				.hasNext();) {
			Example example = exampleIterator.next();
			for (Attribute attribute : example.getAttributes()) {
				if (isRegular(attribute) && isDecimalValue(example, attribute)) {
					result = false;
					break;
				}
			}
			if (!result) {
				break;
			}
		}
		return result;
	}

	private boolean isDecimalValue(Example example, Attribute attribute) {
		Double numberOfOccurencesAsDouble = example
				.getNumericalValue(attribute);
		Integer numberOfOccurencesAsInteger = numberOfOccurencesAsDouble
				.intValue();
		return numberOfOccurencesAsDouble > numberOfOccurencesAsInteger;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}


}
