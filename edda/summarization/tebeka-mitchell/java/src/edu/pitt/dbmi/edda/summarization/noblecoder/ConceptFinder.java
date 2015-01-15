package edu.pitt.dbmi.edda.summarization.noblecoder;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import edu.pitt.coder.NobleCoder;
import edu.pitt.dbmi.edda.summarization.examples.ExampleParagraphs;
import edu.pitt.dbmi.edda.summarization.lens.enlreader.Annotation;
import edu.pitt.terminology.lexicon.Concept;
import edu.pitt.terminology.util.TerminologyException;

public class ConceptFinder {

	private String terminologyPath;
	private NobleCoder coder;
	private Integer annotationOffset = 0;
	private boolean debugging;

	public static void main(String[] args) {
		ConceptFinder conceptFinder = new ConceptFinder();
		conceptFinder.setTerminologyPath("file:///C:/ties/nobletools/terminologies/TIES_Pathology");
		conceptFinder.initialize();
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

	public ConceptFinder() {
	}

	public void initialize() {
		openNobleCoder();
	}

	public void finalize() {
		closeNobleCoder();
	}

	public List<Annotation> findConcepts(String sentenceText) {
		return findConcepts(sentenceText, 0);
	}

	public List<Annotation> findConcepts(String sentenceText,
			Integer annotationOffset) {
		this.setAnnotationOffset(annotationOffset);
		final List<Annotation> annotations = new ArrayList<Annotation>();
		try {
			final Concept[] concepts = coder.processPhrase(sentenceText);
			for (Concept concept : concepts) {
				String cui = concept.getCode();
				Integer sPos = Integer.MAX_VALUE;
				Integer ePos = Integer.MIN_VALUE;
				for (edu.pitt.terminology.lexicon.Annotation conceptAnnot : concept
						.getAnnotations()) {
					sPos = Math.min(sPos, conceptAnnot.getOffset());
					ePos = Math.max(ePos, conceptAnnot.getOffset()
							+ conceptAnnot.getText().length());
					sPos += annotationOffset;
					ePos += annotationOffset;
					String annotationType = "NounPhraseMention";
					String underLyingText = cui;
					Annotation annot = new Annotation(annotationType, sPos,
							ePos, underLyingText);
					annotations.add(annot);
				}
			}
		} catch (TerminologyException e) {
			e.printStackTrace();
		}
		return annotations;
	}

	protected void openNobleCoder() {
		if (coder == null) {
			try {
				URL terminologyUrl = new URL(getTerminologyPath());
				File terminologyFileHandle = new File(terminologyUrl.toURI());
				coder = new NobleCoder(terminologyFileHandle);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}

	private void closeNobleCoder() {
		if (coder != null) {
			coder.getTerminology().dispose();
			coder = null;
		}
	}

	public String getTerminologyPath() {
		return terminologyPath;
	}

	public void setTerminologyPath(String terminologyPath) {
		this.terminologyPath = terminologyPath;
	}

	public Integer getAnnotationOffset() {
		return annotationOffset;
	}

	public void setAnnotationOffset(Integer annotationOffset) {
		this.annotationOffset = annotationOffset;
	}

	public boolean isDebugging() {
		return debugging;
	}

	public void setDebugging(boolean debugging) {
		this.debugging = debugging;
	}

}
