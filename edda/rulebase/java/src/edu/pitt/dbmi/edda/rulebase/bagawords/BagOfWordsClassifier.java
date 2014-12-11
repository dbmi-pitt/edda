package edu.pitt.dbmi.edda.rulebase.bagawords;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.edda.rulebase.Utilities;
import edu.pitt.dbmi.edda.rulebase.document.Citation;
import edu.pitt.dbmi.edda.rulebase.document.Word;

public class BagOfWordsClassifier {

	private BagOfWordsEvidence bagOfWordsEvidence = new BagOfWordsEvidence();
	
	private final Alphabet alphabet = new Alphabet();

	private final HashMap<String, Word> matchedAlphabet = new HashMap<String, Word>();

	private Citation citation;

	public void classify() {
		try {
			tryClassify();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void tryClassify() throws IOException {
		
		populateMatchedAlphabet();
		
		int combinedScore = 0;
		for (Word w : matchedAlphabet.values()) {
			combinedScore += w.getRank();
		}
		if (combinedScore > 0) {
			bagOfWordsEvidence.setCategory(new Integer(1));
		} else {
			bagOfWordsEvidence.setCategory(new Integer(0));
		}
		bagOfWordsEvidence.setWeight(new Integer(combinedScore));

	}
	
	private void populateMatchedAlphabet() throws IOException {
		
		matchedAlphabet.clear();

		Pattern pattern = Pattern.compile("\\w+");
		
		Matcher matcher = pattern.matcher(citation.getContent());
		while (matcher.find()) {
			String text = matcher.group().toLowerCase();
			Word word = alphabet.getWord(text);
			if (word != null) {
				matchedAlphabet.put(text, word);
			}
		}
	}

	@SuppressWarnings("unused")
	private void tryClassifyOriginal() throws IOException {
		
		File file = new File(citation.getPath());
		Pattern pattern = Pattern.compile("\\w+");
		String filePath = file.getAbsolutePath();
		String content = Utilities.readFileToString(filePath);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			String text = matcher.group().toLowerCase();
			Word word = alphabet.getWord(text);
			if (word != null) {
				matchedAlphabet.put(text, word);
			}
		}
		int combinedScore = 0;
		for (Word w : matchedAlphabet.values()) {
			combinedScore += w.getRank();
		}
		if (combinedScore > 0) {
			citation.setPredictedClassification("include");
		} else {
			citation.setPredictedClassification("exclude");
		}



	}

	public Alphabet getAlphabet() {
		return alphabet;
	}

	public BagOfWordsEvidence getBagOfWordsEvidence() {
		return bagOfWordsEvidence;
	}

	public Citation getCitation() {
		return citation;
	}

	public void setCitation(Citation citation) {
		this.citation = citation;
	}


	

}
