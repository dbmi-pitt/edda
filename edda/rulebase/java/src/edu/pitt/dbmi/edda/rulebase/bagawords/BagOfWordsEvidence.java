package edu.pitt.dbmi.edda.rulebase.bagawords;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.edda.rulebase.ClassificationEvidence;
import edu.pitt.dbmi.edda.rulebase.document.Citation;
import edu.pitt.dbmi.edda.rulebase.document.Word;

public class BagOfWordsEvidence extends ClassificationEvidence {
	
	private static final long serialVersionUID = 1L;
	
	private final Alphabet alphabet = new Alphabet();
	private final HashMap<String, Word> matchedAlphabet = new HashMap<String, Word>();

	public void scoreWithCitation(Citation citation) {
		super.scoreWithCitation(citation);
		try {
			tryScoreWithCitation();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void tryScoreWithCitation() throws IOException {
		
		populateMatchedAlphabet();
		
		int combinedScore = 0;
		for (Word w : matchedAlphabet.values()) {
			combinedScore += w.getRank();
		}
		if (combinedScore > 0) {
			setPolarity("present");
		} else {
			setPolarity("absent");
		}
		setWeight(new Integer(combinedScore));

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

	public Alphabet getAlphabet() {
		return alphabet;
	}

	public String toString() {
		return super.toString();
	}
}
