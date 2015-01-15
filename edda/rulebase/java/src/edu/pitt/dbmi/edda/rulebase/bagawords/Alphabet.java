package edu.pitt.dbmi.edda.rulebase.bagawords;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.edda.rulebase.Utilities;
import edu.pitt.dbmi.edda.rulebase.document.Citation;
import edu.pitt.dbmi.edda.rulebase.document.Word;

public class Alphabet {
	
	private final String CONST_SERIALIZED_ALPHA_PATH = "C:\\Users\\kjm84\\git\\edda\\edda\\rulebase\\data\\alphabet.ser";

	private final HashMap<String, Word> alphabet = new HashMap<String, Word>();
	private Iterator<Word> alphabetIterator;

	private Integer totalApartitionExcludes;
	private Integer totalApartitionIncludes;
	private int totalBpartitionExcludes;
	private int totalBpartitionIncludes;
	
	public Alphabet() {
		try {
			cacheAlphabet();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void findBestDiscriminators() {

		final TreeSet<Word> bestExcluders = new TreeSet<Word>(
				new Comparator<Word>() {
					@Override
					public int compare(Word w0, Word w1) {
						return w1.getRank() - w0.getRank();
					}
				});
		final TreeSet<Word> bestIncluders = new TreeSet<Word>(
				new Comparator<Word>() {
					@Override
					public int compare(Word w0, Word w1) {
						return w1.getRank() - w0.getRank();
					}
				});

		totalApartitionExcludes = 0;
		totalApartitionIncludes = 0;
		totalBpartitionExcludes = 0;
		totalBpartitionIncludes = 0;
		for (Word w : alphabet.values()) {
			totalApartitionExcludes += w.getFrequencyApartitionExclude();
			totalApartitionIncludes += w.getFrequencyApartitionInclude();
			totalBpartitionExcludes += w.getFrequencyBpartitionExclude();
			totalBpartitionIncludes += w.getFrequencyBpartitionInclude();
			w.setFrequencyApartition(w.getFrequencyApartitionExclude()
					+ w.getFrequencyApartitionInclude());
			w.setFrequencyBpartition(w.getFrequencyBpartitionExclude()
					+ w.getFrequencyBpartitionInclude());
			w.setFrequency(w.getFrequencyApartition()
					+ w.getFrequencyBpartition());
		}
		float scalingRatio = totalApartitionExcludes / totalApartitionIncludes;
		System.out.println("scalingRatio = " + scalingRatio);
		for (Word w : alphabet.values()) {
			int scaledApartitionInclude = Math.round(w
					.getFrequencyApartitionInclude() * scalingRatio);
			int differentialRange = scaledApartitionInclude
					- w.getFrequencyApartitionExclude();
			w.setRank(Math.abs(differentialRange));
			if (differentialRange < 0) {
				bestExcluders.add(w);
			} else {
				bestIncluders.add(w);
			}
		}

		System.out.println("Number in best excluders is "
				+ bestExcluders.size());
		System.out.println("Number in best includers is "
				+ bestIncluders.size());

		alphabet.clear();
		Iterator<Word> bestExcluderIterator = bestExcluders.iterator();
		while (alphabet.size() < 10 && bestExcluderIterator.hasNext()) {
			Word w = bestExcluderIterator.next();
			w.setRank(-1 * w.getRank());
			alphabet.put(w.getText(), w);
		}
		Iterator<Word> bestIncluderIterator = bestIncluders.iterator();
		while (alphabet.size() < 20 && bestIncluderIterator.hasNext()) {
			Word w = bestIncluderIterator.next();
			alphabet.put(w.getText(), w);
		}
		
		System.out.println("Initiating alphabet iterator for alphabet of size "
				+ alphabet.size());
		alphabetIterator = alphabet.values().iterator();
	}

	public void contributeToWordFrequencies(Citation citation) {
		try {
			tryContributeToWordFrequencies(citation);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void tryContributeToWordFrequencies(Citation citation)
			throws IOException {
		File file = new File(citation.getPath());
		Pattern pattern = Pattern.compile("\\w+");
		String content = Utilities.readFileToString(file.getAbsolutePath());
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			String text = matcher.group().toLowerCase();
			Word word = alphabet.get(text);
			if (word == null) {
				word = new Word();
				word.setText(text);
				alphabet.put(text, word);
			}
			tallyCategorizedFrequency(citation, word);
		}
	}

	private void tallyCategorizedFrequency(Citation citation, Word word) {
		if (citation.getPartition().equals("train")
				&& citation.getActualClassification().equals("include")) {
			word.setFrequencyApartitionInclude(word
					.getFrequencyApartitionInclude() + 1);
		} else if (citation.getPartition().equals("train")
				&& citation.getActualClassification().equals("exclude")) {
			word.setFrequencyApartitionExclude(word
					.getFrequencyApartitionExclude() + 1);
		} else if (citation.getPartition().equals("test")
				&& citation.getActualClassification().equals("include")) {
			word.setFrequencyBpartitionInclude(word
					.getFrequencyBpartitionInclude() + 1);
		} else if (citation.getPartition().equals("test")
				&& citation.getActualClassification().equals("exclude")) {
			word.setFrequencyBpartitionExclude(word
					.getFrequencyBpartitionExclude() + 1);
		}
	}
	
	public void persistAlphabet() throws IOException {
		File file = new File(CONST_SERIALIZED_ALPHA_PATH);
		FileOutputStream f = new FileOutputStream(file);
		ObjectOutputStream s = new ObjectOutputStream(f);
		s.writeObject(alphabet);
		s.flush();
	}

	@SuppressWarnings("unchecked")
	public void cacheAlphabet() throws IOException, ClassNotFoundException {
		File file = new File(CONST_SERIALIZED_ALPHA_PATH);
		if (file.exists()) {
			FileInputStream f = new FileInputStream(file);
			ObjectInputStream s = new ObjectInputStream(f);
			final HashMap<String, Word> cachedAlphabet = (HashMap<String, Word>) s
					.readObject();
			s.close();
			alphabet.clear();
			alphabet.putAll(cachedAlphabet);
			alphabetIterator = alphabet.values().iterator();
		}
	}
	
	public Word getWord(String text) {
		return alphabet.get(text);
	}

	public Word nextAlphabetWord() {
		return (alphabetIterator != null && alphabetIterator.hasNext()) ? alphabetIterator.next() : null;
	}

	public void setAlphabetIterator(Iterator<Word> alphabetIterator) {
		this.alphabetIterator = alphabetIterator;
	}

	public Iterator<Word> getAlphabetIterator() {
		return alphabetIterator;
	}


}
