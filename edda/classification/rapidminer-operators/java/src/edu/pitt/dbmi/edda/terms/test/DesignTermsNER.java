package edu.pitt.dbmi.edda.terms.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import javax.swing.JDialog;

import edu.pitt.ontology.IOntology;
import edu.pitt.ontology.bioportal.BioPortalRepository;
import edu.pitt.ontology.ui.OntologyImporter;
import edu.pitt.terminology.client.OntologyTerminology;
import edu.pitt.terminology.client.PersistentOntologyTerminology;
import edu.pitt.terminology.lexicon.Concept;



public class DesignTermsNER {
	// search method 0 - best match, 1 - partial match
	public final int SEARCH_METHOD = 0;
	private List<String> inputTerms;
	
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
	
	/**
	 * get ontology to code against
	 * @return
	 */
	public IOntology getOntology() throws Exception {
		OntologyImporter importer = new OntologyImporter(new BioPortalRepository());
		JDialog d = importer.showImportWizard(null);
		while(d.isShowing()){
			try{
				Thread.sleep(500);
			}catch(Exception ex){}
		}
		if(importer.isSelected()){
			return importer.getSelectedOntology();
		}
		return null;
	}
	
	
	/**
	 * process terms against ontology
	 * @param output
	 */
	public void process() throws Exception {
		OntologyTerminology term = new PersistentOntologyTerminology(getOntology());
		Map<Concept,Integer> found = new HashMap<Concept,Integer>();
		int occurances = 0;
		for(String line: getInputTerms()){
			if(line.length()==0)
				continue;
			System.out.print(line+";");
			for(Concept c :term.search(line,term.getSearchMethods()[SEARCH_METHOD])){
				System.out.print(c.getName()+"["+c.getConceptClass().getName()+"]");
				if(!found.containsKey(c))
					found.put(c,0);
				found.put(c,found.get(c)+1);
				occurances ++;
				System.out.print(";");
			}
			System.out.println("");
		}
		System.out.println("\nUnique concepts found: "+found.size());
		System.out.println("Occurences found: "+occurances);
		for(Concept c: found.keySet()){
			System.out.println("\t"+c.getName()+" "+c.getConceptClass().getURI()+" ("+found.get(c)+" occurences)");
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		DesignTermsNER ner = new DesignTermsNER();
		ner.load(new File("/home/tseytlin/Download/design_terms_mod.txt"));
		ner.process();
		System.exit(0);
	}

}
