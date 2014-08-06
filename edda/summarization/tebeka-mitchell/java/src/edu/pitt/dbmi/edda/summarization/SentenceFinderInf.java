package edu.pitt.dbmi.edda.summarization;

import java.util.List;

import edu.pitt.dbmi.edda.summarization.lens.enlreader.Annotation;

public interface SentenceFinderInf {
	
	public List<Annotation> annotateSentences(String documentText);

}
