package edu.pitt.dbmi.edda.summarization;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.edda.summarization.lens.enlreader.Annotation;

public class SentenceFinderEoln implements SentenceFinderInf {
	
	private static SentenceFinderEoln singleton = null;
	
	public static void main(String[] args) {
		SentenceFinderEoln sentenceFinder = getInstance();
		List<Annotation> annotations = sentenceFinder.annotateSentences(getExampleParagraphTwo());
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
	}
	
	private static String getExampleParagraphTwo() {
		StringBuffer sb = new StringBuffer();
		sb.append("The induction of immediate-early (IE) response genes, such as egr-1,\n");
		sb.append("  c-fos, and c-jun, occurs rapidly after the activation of T\n");
		sb.append("  lymphocytes. The process of activation involves calcium mobilization,\n");
		sb.append("  activation of protein kinase C (PKC), and phosphorylation of tyrosine\n");
		sb.append("  kinases. p21(ras), a guanine nucleotide binding factor, mediates\n");
		sb.append("  T-cell signal transduction through PKC-dependent and PKC-independent\n");
		sb.append("  pathways. The involvement of p21(ras) in the regulation of\n");
		sb.append("  calcium-dependent signals has been suggested through analysis of its\n");
		sb.append("  role in the activation of NF-AT. We have investigated the inductions\n");
		sb.append("  of the IE genes in response to calcium signals in Jurkat cells (in\n");
		sb.append("  the presence of activated p21(ras)) and their correlated\n");
		sb.append("  consequences.");
		return sb.toString();
		}
	
	public static SentenceFinderEoln getInstance() {
		if (singleton == null) {
			singleton = new SentenceFinderEoln();
		}
		return singleton;
	}

	@Override
	public List<Annotation> annotateSentences(String documentText) {
		final ArrayList<Annotation> annotations = new ArrayList<Annotation>();
		Pattern eolnPattern = Pattern.compile("^.*$", Pattern.MULTILINE);
		Matcher matcher = eolnPattern.matcher(documentText);
		while (matcher.find()) {
			String line = matcher.group();
			Integer sPos = new Integer(matcher.start());
			Integer ePos = new Integer(matcher.end());
			annotations.add(new Annotation("Sentence", sPos, ePos, line));
		}
		return annotations;
	}

}
