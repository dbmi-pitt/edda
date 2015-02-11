package edu.pitt.dbmi.edda.operator.ldaop;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Iterator;
import java.util.regex.Pattern;

import cc.mallet.pipe.iterator.CsvIterator;
import cc.mallet.types.Instance;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.Attributes;
import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;

public class ExampleSetIterator implements Iterator<Instance> {
	
	private ExampleSet exampleSet;
	private Attributes attrs;
	private Attribute attrLabel;
	private Attribute attrMetaDataPath;
	
	private CsvIterator csvIterator;
	
	public ExampleSetIterator(ExampleSet exampleSet) {
		this.exampleSet = exampleSet;
		final ByteArrayOutputStream bos = new ByteArrayOutputStream();
		final PrintStream os = new PrintStream(bos);
		conflateExampleSet(os);
		Reader fileReader = new InputStreamReader(new ByteArrayInputStream(bos.toByteArray()));
		Pattern threeFieldCsvParser = Pattern.compile("^([^,]+),([^,]+),([^,]+)$", Pattern.DOTALL | Pattern.MULTILINE);
		
		csvIterator = new CsvIterator(fileReader, threeFieldCsvParser,
											   3, 2, 1); // data
	}
	
	private void conflateExampleSet(PrintStream os) {
		if (exampleSet != null) {
			attrs = exampleSet.getAttributes();
			attrLabel = attrs.getLabel();
			attrMetaDataPath = attrs.getSpecial(TopicModelOperator.METADATA_PATH);
			for (Example example : exampleSet) {
				conflateExample(os, example);
			}	 
		}
	}

	private void conflateExample(PrintStream os, Example example) {
		String exampleLabel = example.getValueAsString(attrLabel);
		String filePath = example.getValueAsString(attrMetaDataPath);
		String text = conflateToSpaceDelimitedWordSequence(example);
		os.println(filePath + "," + exampleLabel + "," + text);
	}

	private String conflateToSpaceDelimitedWordSequence(Example example) {
		final StringBuffer sb = new StringBuffer();
		for (Attribute attr : example.getAttributes()) {
			if (attr.isNumerical()) {
				String word = attr.getName();
				word = word.replaceAll("[, ]", "_");
				Double numberOfOccurencesAsDouble = example.getNumericalValue(attr);
				Integer numberOfOccurencesAsInteger = numberOfOccurencesAsDouble.intValue();
				while (numberOfOccurencesAsInteger > 0) {
					if (sb.length() > 0) {
						sb.append(" ");
					}
					sb.append(word);
					numberOfOccurencesAsInteger--;
				}
			}
		}
		String result = sb.toString();
		if (result.length() == 0) {
			result += " ";
		}
		return result;
	}

	@Override
	public boolean hasNext() {
		return csvIterator.hasNext();
	}

	@Override
	public Instance next() {
		Instance instance = csvIterator.next();
		return instance;
	}

	@Override
	public void remove() {
		throw new IllegalStateException(
				"This Iterator<Instance> does not support remove().");

	}

}
