package edu.pitt.dbmi.edda.summarization.lingpipe;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.aliasi.sentences.MedlineSentenceModel;
import com.aliasi.sentences.SentenceModel;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;

import edu.pitt.dbmi.edda.summarization.lens.enlreader.Annotation;

/** Use SentenceModel to find sentence boundaries in text */
public class SentenceFinder {
	
	private static SentenceFinder singleton = null;

	private static final TokenizerFactory tokenizerFactory = IndoEuropeanTokenizerFactory.INSTANCE;
	private static final SentenceModel medlineSentenceModel = new MedlineSentenceModel();

	private String text;
	
	private final List<String> tokenList = new ArrayList<String>();
	private final List<String> whiteList = new ArrayList<String>();
	private String[] tokens;
	private String[] whites;
	
	private int[] sentenceBoundaries;
	
	public static void main(String[] args) {
		SentenceFinder sentenceFinder = getInstance();
		String sentenceText = getExampleParagraphOne();
		findSentences(sentenceFinder,sentenceText);
		sentenceText = getExampleParagraphTwo();
		findSentences(sentenceFinder,sentenceText);
	}
	
	private static void findSentences(SentenceFinder sentenceFinder, String sentenceText) {
		List<Annotation> annotations = sentenceFinder.annotateSentences(sentenceText);
		for (Annotation annot : annotations) {
			System.out.println(annot);
		}
	}
	
	private static String getExampleParagraphOne() {
		StringBuffer sb = new StringBuffer();
		sb.append("See the dog run.  Spot runs fast.\nJohn and Jane watched Spot run.");
		return sb.toString();
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
	
	public static SentenceFinder getInstance() {
		if (singleton == null) {
			singleton = new SentenceFinder();
		}
		return singleton;
	}
	
	private SentenceFinder() {
		;
	}

	public List<Annotation> annotateSentences(String text) {
		setText(text);
		tokenize();
		storeTokensInArrays();
		discoverSentenceBoundaries() ;
		final List<Annotation> sentenceAnnotations = buildSentenceAnnotations();
		return sentenceAnnotations;
	}
	
	private List<Annotation> buildSentenceAnnotations() {
		final List<Annotation> sentenceAnnotations = new ArrayList<Annotation>();
		if (sentenceBoundaries.length > 0) {
			int sentStartTok = 0;
			int sentEndTok = 0;
			String textAccumulator = "";
			for (int i = 0; i < sentenceBoundaries.length; ++i) {
			    sentEndTok = sentenceBoundaries[i];
			    String sentenceAccumulator = "";
			    for (int j=sentStartTok; j<=sentEndTok; j++) {
			    	sentenceAccumulator += tokens[j] + whites[j+1];
			    }
			    int sPos = textAccumulator.length();
			    int ePos = sPos + StringUtils.chomp(sentenceAccumulator, whites[sentEndTok+1]).length();
			    System.out.println(sentenceAccumulator);
			    Annotation sentenceAnnotation = new Annotation("Sentence", sPos, ePos, text.substring(sPos, ePos));
				sentenceAnnotations.add(sentenceAnnotation);
				textAccumulator += sentenceAccumulator;
			    sentStartTok = sentEndTok+1;
			}
		}
		else {
			System.out.println("No sentence boundaries found.");
		}
		return sentenceAnnotations;
	}
	
	private int lastNonSpaceIndex(String s) {
		int index = -1;
		Pattern pattern = Pattern.compile("[\\s\n]+$");
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			index = matcher.start(0);
		}
		return index;
	}
	
	private void discoverSentenceBoundaries() {
		sentenceBoundaries = medlineSentenceModel.boundaryIndices(tokens,
				whites);
		System.out.println(sentenceBoundaries.length
				+ " SENTENCE END TOKEN OFFSETS");		
	}

	private void tokenize() {
		tokenList.clear();
		whiteList.clear();
		Tokenizer tokenizer = tokenizerFactory.tokenizer(text.toCharArray(),
				0, text.length());
		tokenizer.tokenize(tokenList, whiteList);
		System.out.println(tokenList.size() + " TOKENS");
		System.out.println(whiteList.size() + " WHITESPACES");
	}
	
	private void storeTokensInArrays() {
		tokens = new String[tokenList.size()];
		whites = new String[whiteList.size()];
		tokenList.toArray(tokens);
		whiteList.toArray(whites);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
