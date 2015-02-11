package edu.pitt.dbmi.edda.summarization;

import edu.pitt.dbmi.edda.summarization.lingpipe.SentenceFinderLingPipe;

public class SentenceFinderFactory {
	
	public static final String CONST_SENTENCE_FINDER_LINGPIPE = "lingpipe";
	public static final String CONST_SENTENCE_FINDER_EOLN = "eoln";
	
	public static SentenceFinderInf getInstance(String sentenceFinderKind) {
		SentenceFinderInf sentenceFinder = SentenceFinderEoln.getInstance();
		if (sentenceFinderKind.equals(CONST_SENTENCE_FINDER_LINGPIPE)) {
			sentenceFinder = SentenceFinderLingPipe.getInstance();
		}
		return sentenceFinder;
	}

}
