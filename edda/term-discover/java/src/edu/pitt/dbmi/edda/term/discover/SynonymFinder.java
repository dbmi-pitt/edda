package edu.pitt.dbmi.edda.term.discover;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import edu.pitt.dbmi.nlp.noble.tools.TextTools;

public class SynonymFinder {
	
	/**
	 * find synonymous terms and group them together
	 * @param text
	 */
	private void findSynonyms(String text){
		Map<String,List<String>> termMap = new LinkedHashMap<String,List<String>>();
		for(String term: text.split("\n")){
			String nterm = TextTools.normalize(term,true,false,true);
			List<String> terms = termMap.get(nterm);
			if(terms == null){
				terms = new ArrayList<String>();
				termMap.put(nterm,terms);
			}
			terms.add(term);
		}
		
		for(String key: termMap.keySet()){
			for(String term: termMap.get(key)){
				System.out.println(term);
			}
			System.out.println("");
		}
		
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File f = new File("/home/tseytlin/Data/SD_Mining/data/final/target/target_HTA_keywords.txt");
		SynonymFinder sf = new SynonymFinder();
		sf.findSynonyms(TextTools.getText(new FileInputStream(f)));
	}

}
