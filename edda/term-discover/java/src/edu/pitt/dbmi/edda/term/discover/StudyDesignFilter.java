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
	private File nameFile,locationFile; 
	public static List<String> termBlacklist = Arrays.asList("tests","meta","gene","case","blind","regression","disease","root");
	public static List<String> abbreviationBlacklist = Arrays.asList("2x2");
	private List<String> names, locations;
	private NobleCoderTerminology thesaurus;
	
	
	public static void main(String [] args) throws FileNotFoundException, IOException{
		File dir = new File("/home/tseytlin/Data/SD_Mining/");
		
		
		File file = new File("/home/tseytlin/Data/HTA/study_designs_MSH.txt");
		
		
		StudyDesignFilter sd = new StudyDesignFilter();
		sd.setNameFile(new File(dir,"names/all_names.txt"));
		sd.setLocationFile(new File(dir,"gazetteers/all_locations.txt"));
		
		String text = TextTools.getText(new FileInputStream(file));
		
		//sd.filterGenes(text);
		sd.filterDiagnosis(text);
		sd.filterAcronym(text);
		sd.filterOrgan(text);
		sd.filterNames(text);
		sd.filterLocations(text);
		
		if(!file.getName().contains("EDDA")){
			sd.filterDesign(text);
			sd.filterAnalysis(text);
		}
	}
	
	
	
	public void setNameFile(File nameFile) {
		this.nameFile = nameFile;
	}



	public void setLocationFile(File locationFile) {
		this.locationFile = locationFile;
	}



	private List<String> getNames() throws FileNotFoundException, IOException{
		if(names == null){
			names = new ArrayList<String>();
			for(String s: TextTools.getText(new FileInputStream(nameFile)).split("\n")){
				s = s.trim();
				if(s.length() > 0)
					names.add(s);
			}
		
		}
		return names;
	}
	
	private List<String> getLocations() throws FileNotFoundException, IOException{
		if(locations == null){
			locations = new ArrayList<String>();
			for(String s: TextTools.getText(new FileInputStream(locationFile)).split("\n")){
				s = s.trim();
				if(s.length() > 0)
					locations.add(s);
			}
		
		}
		return locations;
	}
	
	private boolean contains(List<String> list, String text ,boolean caseSensitive){
		for(String s: list){
			if(containsWord(text,s,caseSensitive))
				return true;
		}
		return false;
	}
	private boolean contains(List<String> list, String text){
		return contains(list, text, false);
	}
	
	
	private boolean containsWord(String text, String word){
		return containsWord(text, word,false);
	}
	
	private boolean containsWord(String text, String word, boolean caseSensitive){
		String cs = caseSensitive?"":"(?i)";
		return Pattern.compile(cs+"\\b"+word+"\\b").matcher(text).find();
	}
	

	private void filterAnalysis(String text) {
		System.out.println("\n## analysis filter ##");
		for(String term: text.split("\n")){
			// check for gene mentions
			try {
				if(containsWord(term,"analy(s[ie]s|tical)") && !isBlacklisted(term))
					System.out.println(term);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}



	private void filterNames(String text) {
		System.out.println("\n## name filter ##");
		for(String term: text.split("\n")){
			// check for gene mentions
			try {
				if(contains(getNames(),term) && !isBlacklisted(term))
					System.out.println(term);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}



	private void filterLocations(String text) {
		System.out.println("\n## location filter ##");
		for(String term: text.split("\n")){
			// check for gene mentions
			try {
				if(contains(getLocations(),term,true))
					System.out.println(term);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}



	/**
	 * filter possible study designs
	 * @param text
	 * @throws IOException 
	 */
	private void filterGenes(String text) throws IOException {
		System.out.println("\n## gene filter ##");
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
	
	public NobleCoderTerminology getThesaurus() throws IOException{
		if(thesaurus == null){
			thesaurus = new NobleCoderTerminology("NCI_Metathesaurus");
			thesaurus.setSourceFilter("NCI;MSH");
		}
		return thesaurus;
	}
	
	/**
	 * filter possible study designs
	 * @param text
	 * @throws IOException 
	 */
	private void filterDiagnosis(String text) throws IOException {
		System.out.println("\n## diagnostic filter ##");
		NobleCoderTerminology terminology = getThesaurus();
		terminology.setSemanticTypeFilter("Disease or Syndrome; Neoplastic Process");
		terminology.setSelectBestCandidate(true);
		for(String term: text.split("\n")){
			// check for gene mentions
			try {
				boolean match = terminology.search(term,NobleCoderTerminology.ALL_MATCH).length > 0;
				if(match && !isBlacklisted(term))
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
	private void filterOrgan(String text) throws IOException {
		System.out.println("\n## organ filter ##");
		NobleCoderTerminology terminology = getThesaurus();
		terminology.setSemanticTypeFilter("Body Part, Organ, or Organ Component ; Organ or Tissue Function");
		terminology.setSelectBestCandidate(true);
		for(String term: text.split("\n")){
			// check for gene mentions
			try {
				boolean match = terminology.search(term,NobleCoderTerminology.ALL_MATCH).length > 0;
				if(match && !isBlacklisted(term))
					System.out.println(term);
			} catch (TerminologyException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void filterDesign(String text)  throws IOException {
		System.out.println("\n## design filter ##");
		NobleCoderTerminology terminology = getThesaurus();
		terminology.setSemanticTypeFilter("Research Activity ; Molecular Biology Research Technique");
		for(String term: text.split("\n")){
			if(term.toLowerCase().contains("design")){
				// check for gene mentions
				try {
					boolean match = terminology.search(term).length > 0;
					if(!match)
						System.out.println(term);
				} catch (TerminologyException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	private boolean isBlacklisted(String term) {
		for(String s: termBlacklist){
			if(Pattern.compile("\\b"+s+"\\b").matcher(term.toLowerCase()).find())
				return true;
		}
		return false;
	}

	/**
	 * filter possible study designs
	 * @param text
	 * @throws IOException 
	 */
	private void filterAcronym(String text) throws IOException {
		System.out.println("\n## acronym filter ##");
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
				if((TextTools.isLikelyAbbreviation(word) || word.matches("[A-Z]+"))&& !abbreviationBlacklist.contains(word)){
					System.out.println(term);
					break;
				}
			}
		}
	}
}
