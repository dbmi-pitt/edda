package edu.pitt.dbmi.edda.ldatests;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import cc.mallet.pipe.CharSequence2TokenSequence;
import cc.mallet.pipe.CharSequenceLowercase;
import cc.mallet.pipe.Input2CharSequence;
import cc.mallet.pipe.Pipe;
import cc.mallet.pipe.PrintInputAndTarget;
import cc.mallet.pipe.SerialPipes;
import cc.mallet.pipe.Target2Label;
import cc.mallet.pipe.TokenSequence2FeatureSequence;
import cc.mallet.pipe.TokenSequenceLowercase;
import cc.mallet.pipe.TokenSequenceRemoveNonAlpha;
import cc.mallet.pipe.TokenSequenceRemoveStopwords;

public class LdaPipeLine {

	private static final Logger logger = Logger.getLogger(LdaPipeLine.class);

	private final ArrayList<Pipe> pipeList = new ArrayList<Pipe>();

	private SerialPipes serialPipes;

	public LdaPipeLine() {
		buildPipeLineThree();
	}

	@SuppressWarnings("unused")
	private void buildPipeLineOne() {
		// Pipes:
		// lowercase,
		// tokenize,
		// remove stopwords,
		// map to features

		pipeList.clear();
		pipeList.add(new CharSequenceLowercase());
		pipeList.add(new CharSequence2TokenSequence(Pattern
				.compile("\\p{L}[\\p{L}\\p{P}]+\\p{L}")));
		pipeList.add(new TokenSequenceRemoveStopwords(new File(
				"stoplists/en.txt"), "UTF-8", false, false, false));
		pipeList.add(new TokenSequence2FeatureSequence());

		serialPipes = new SerialPipes(pipeList);

		logger.debug("constructed an " + getClass().getName());
	}

	@SuppressWarnings("unused")
	private void buildPipeLineTwo() {
		// Read data from File objects
		pipeList.add(new Input2CharSequence("UTF-8"));

		// Regular expression for what constitutes a token.
		// This pattern includes Unicode letters, Unicode numbers,
		// and the underscore character. Alternatives:
		// "\\S+" (anything not whitespace)
		// "\\w+" ( A-Z, a-z, 0-9, _ )
		// "[\\p{L}\\p{N}_]+|[\\p{P}]+" (a group of only letters and numbers OR
		// a group of only punctuation marks)
		Pattern tokenPattern = Pattern.compile("[\\p{L}\\p{N}_]+");
		tokenPattern = Pattern.compile("\\p{L}{3,}");

		// Tokenize raw strings
		pipeList.add(new CharSequence2TokenSequence(tokenPattern));

		//
		// Remove tokens that contain non-alphabetic characters.
		//
		pipeList.add(new TokenSequenceRemoveNonAlpha());

		// Normalize all tokens to all lowercase
		pipeList.add(new TokenSequenceLowercase());

		// Remove stopwords from a standard English stoplist.
		// options: [case sensitive] [mark deletions]
		pipeList.add(new TokenSequenceRemoveStopwords(false, false));

		// Rather than storing tokens as strings, convert
		// them to integers by looking them up in an alphabet.
		pipeList.add(new TokenSequence2FeatureSequence());

		// Do the same thing for the "target" field:
		// convert a class label string to a Label object,
		// which has an index in a Label alphabet.
		pipeList.add(new Target2Label());

		// Now convert the sequence of features to a sparse vector,
		// mapping feature IDs to counts.
		// This breaks the topic modeling. Don't do it.
		// pipeList.add(new FeatureSequence2FeatureVector());

		// Print out the features and the label
		pipeList.add(new PrintInputAndTarget());

		serialPipes = new SerialPipes(pipeList);

		logger.debug("constructed an " + getClass().getName());
	}
	
	private void buildPipeLineThree() {
		// Read data from File objects
		pipeList.add(new Input2CharSequence("UTF-8"));
		
		// Tokenize raw strings
		Pattern tokenPattern = Pattern.compile("\\S+");
		pipeList.add(new CharSequence2TokenSequence(tokenPattern));

		// Rather than storing tokens as strings, convert
		// them to integers by looking them up in an alphabet.
		pipeList.add(new TokenSequence2FeatureSequence());

		// Do the same thing for the "target" field:
		// convert a class label string to a Label object,
		// which has an index in a Label alphabet.
		pipeList.add(new Target2Label());

		// Now convert the sequence of features to a sparse vector,
		// mapping feature IDs to counts.
		// This breaks the topic modeling. Don't do it.
//		pipeList.add(new FeatureSequence2FeatureVector());

		// Print out the features and the label
//		pipeList.add(new PrintInputAndTarget());

		serialPipes = new SerialPipes(pipeList);

		logger.debug("constructed an " + getClass().getName());
	}

	public SerialPipes getSerialPipe() {
		return serialPipes;
	}

}
