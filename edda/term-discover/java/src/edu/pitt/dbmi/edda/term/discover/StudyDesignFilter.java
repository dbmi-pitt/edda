package edu.pitt.dbmi.edda.term.discover;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.edda.term.discover.StudyDesignFinder.Mode;
import edu.pitt.dbmi.nlp.noble.coder.NobleCoder;
import edu.pitt.dbmi.nlp.noble.terminology.Terminology;
import edu.pitt.dbmi.nlp.noble.terminology.TerminologyException;
import edu.pitt.dbmi.nlp.noble.terminology.impl.NobleCoderTerminology;
import edu.pitt.dbmi.nlp.noble.tools.TextTools;

public class StudyDesignFilter {
	public static List<String> abbreviationBlacklist = Arrays.asList("2x2");
	
	public static void main(String [] args) throws FileNotFoundException, IOException{
		File file = new File("/home/tseytlin/Data/HTA/study_designs_MSH.txt");
		//File file = new File("/home/tseytlin/Data/HTA/possible_study_design_candidates_NCIT.txt");
		StudyDesignFilter sd = new StudyDesignFilter();
		String text = TextTools.getText(new FileInputStream(file));
		//sd.filterGenes(text);
		sd.filterDiagnosis(text);
		sd.filterAcronym(text);
	}
	
	/**
	 * filter possible study designs
	 * @param text
	 * @throws IOException 
	 */
	private void filterGenes(String text) throws IOException {
		System.out.println("## gene filter ##");
		NobleCoderTerminology terminology = new NobleCoderTerminology("CRAFT");
		terminology.setSourceFilter("GO;PR");
		for(String term: text.split("\n")){
			// check for gene mentions
			try {
				boolean match = terminology.search(term).length > 0;
				if(match)
					System.out.println(term);
			} catch (TerminologyException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * filter possible study designs
	 * @param text
	 * @throws IOException 
	 */
	private void filterDiagnosis(String text) throws IOException {
		System.out.println("## diagnostic filter ##");
		NobleCoderTerminology terminology = new NobleCoderTerminology("NCI_Thesaurus");
		terminology.setSemanticTypeFilter("Disease or Syndrome");
		for(String term: text.split("\n")){
			// check for gene mentions
			try {
				boolean match = terminology.search(term).length > 0;
				if(match)
					System.out.println(term);
			} catch (TerminologyException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * filter possible study designs
	 * @param text
	 * @throws IOException 
	 */
	private void filterAcronym(String text) throws IOException {
		System.out.println("## acronym filter ##");
		for(String term: text.split("\n")){
			// skip terms that are all upper case
			if(term.toUpperCase().equals(term))
				continue;
			// skip terms with roman numerals
			if(term.matches(".*\\b[IV]+[ab]?\\b.*"))
				continue;
			
			// skip terms that follow 12-labdene pattern
			if(Pattern.compile("\\d+\\-[a-z]+").matcher(term).find()){
				System.out.println(term);
				continue;
			}
			
			// filter out abbreviation
			for(String word: TextTools.getWords(term)){
				if(TextTools.isLikelyAbbreviation(word) && !abbreviationBlacklist.contains(word)){
					System.out.println(term);
					break;
				}
			}
		}
	}
}
