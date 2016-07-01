package edu.pitt.dbmi.edda.terms.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import edu.pitt.dbmi.nlp.noble.ontology.*;
import edu.pitt.dbmi.nlp.noble.ontology.owl.OOntology;



public class EnrichOCRe {
	private List<String> inputTerms;
	private IOntology ontology;
	/**
	 * get reference list
	 * @return
	 */
	public List<String> getInputTerms(){
		if(inputTerms == null){
			inputTerms = new ArrayList<String>();
		}
		return inputTerms;
	}
	
	public void setOntology(IOntology ont){
		ontology = ont;
	}
	
	/**
	 * load in a list of references
	 * @param file
	 */
	public void load(File file) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		for(String line=reader.readLine();line != null; line=reader.readLine()){
			getInputTerms().add(line.trim());
		}
		reader.close();
	}
	
	
	public void process(){
		// for all classes
		for(IClass cls: ontology.getRoot().getSubClasses()){
			// if we have a comment check if it matches any design terms
			if(cls.getComments().length > 0){
				Collection<String> synonyms = getMatchingTerms(cls);
				if(!synonyms.isEmpty()){
					System.out.print(cls.getURI());
					for(String term: synonyms ){
						System.out.print(";"+term);
					}
					System.out.println("");
				}
			}
		}
	}
	
	/**
	 * get matching terms within a list of design terms
	 * @param cls
	 * @return
	 */
	private Collection<String> getMatchingTerms(IClass cls) {
		Set<String> match = new LinkedHashSet<String>();
		for(String s: getInputTerms()){
			if(cls.getConcept().getDefinition().contains(s))
				match.add(s);
		}
		return match;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		EnrichOCRe ner = new EnrichOCRe();
		ner.load(new File("/home/tseytlin/Download/design_terms_mod.txt"));
		ner.setOntology(OOntology.loadOntology(new File("/home/tseytlin/Download/Ontology_of_Clinical_Research.owl")));
		ner.process();
		System.exit(0);

	}

}
