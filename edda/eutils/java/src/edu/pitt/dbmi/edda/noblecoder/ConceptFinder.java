package edu.pitt.dbmi.edda.noblecoder;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import edu.pitt.coder.NobleCoder;
import edu.pitt.dbmi.edda.examples.ExampleParagraphs;
import edu.pitt.dbmi.edda.lens.enlreader.Annotation;
import edu.pitt.terminology.lexicon.Concept;
import edu.pitt.terminology.util.TerminologyException;

public class ConceptFinder {
	
	private static ConceptFinder singleton = null;
	
	private NobleCoder coder;
	private Integer annotationOffset = 0;
	private boolean debugging;
	
	public static void main(String[] args) {
		ConceptFinder conceptFinder = getInstance();
		String sentenceText = ExampleParagraphs.getExampleTwo();
		conceptFinder.findConcepts(sentenceText);
		sentenceText = ExampleParagraphs.getExampleThree();
		conceptFinder.findConcepts(sentenceText);
		sentenceText = ExampleParagraphs.getExampleFour();
		conceptFinder.findConcepts(sentenceText);
		sentenceText = ExampleParagraphs.getExampleFive();
		conceptFinder.findConcepts(sentenceText);
		sentenceText = ExampleParagraphs.getExampleSix();
		conceptFinder.findConcepts(sentenceText);
	}
	
	public static ConceptFinder getInstance() {
		if (singleton == null) {
			singleton = new ConceptFinder();
		}
		return singleton;
	}
	
	private ConceptFinder() {
		openNobleCoder();
	}
	
	public void finalize() {
		closeNobleCoder();
	}
	
	public List<Annotation> findConcepts(String sentenceText) {
		return findConcepts(sentenceText, 0);
	}
		
	public List<Annotation> findConcepts(String sentenceText, Integer annotationOffset) {
		this.annotationOffset = annotationOffset;
		final List<Annotation> annotations = new ArrayList<Annotation>();
		try {
			final Concept[] concepts = coder.processPhrase(sentenceText);
			for (Concept concept : concepts) {
				String cui = concept.getCode();
				Integer sPos = Integer.MAX_VALUE;
				Integer ePos = Integer.MIN_VALUE;
				for (edu.pitt.terminology.lexicon.Annotation conceptAnnot : concept.getAnnotations()) {
					sPos = Math.min(sPos, conceptAnnot.getOffset());
					ePos = Math.max(ePos, conceptAnnot.getOffset() + conceptAnnot.getText().length());
					sPos += annotationOffset;
					ePos += annotationOffset;
					String annotationType = "NounPhraseMention";
					String underLyingText = cui;
					Annotation annot = new Annotation(annotationType, sPos, ePos, underLyingText);
					annotations.add(annot);
				}
			}
		} catch (TerminologyException e) {
			e.printStackTrace();
		}
		return annotations;
	}
	
	private void displayAnnotations(List<Annotation> annotations) {
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
	}

	protected void openNobleCoder() {
		if (coder == null) {
			try {
				URL terminologyUrl = new URL(
						"file:///C:/nobletools/terminologies/TIES_Pathology.term");
				terminologyUrl = new URL(
						"file:///C:/nobletools/terminologies/TIES_Pathology");
				File terminologyFileHandle = new File(terminologyUrl.toURI());
				coder = new NobleCoder(terminologyFileHandle);
				if (debugging) {
					System.out
							.println("Successfully opened NobleCoder data source.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}

	private void closeNobleCoder() {
		System.err.println("Closing NobleCoder");
	}

}
