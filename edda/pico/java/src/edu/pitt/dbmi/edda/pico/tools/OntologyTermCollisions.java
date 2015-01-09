package edu.pitt.dbmi.edda.pico.tools;

import java.io.File;
import java.io.IOException;
import java.util.*;

import edu.pitt.dbmi.nlp.noble.ontology.IOntology;
import edu.pitt.dbmi.nlp.noble.ontology.IOntologyException;
import edu.pitt.dbmi.nlp.noble.ontology.owl.OOntology;
import edu.pitt.dbmi.nlp.noble.terminology.Concept;
import edu.pitt.dbmi.nlp.noble.terminology.TerminologyException;
import edu.pitt.dbmi.nlp.noble.terminology.impl.NobleCoderTerminology;
import edu.pitt.dbmi.nlp.noble.util.PathHelper;

/**
 * looks at a given ontology and checks whether it has any distinct classes that have identical terms representing them
 * @author tseytlin
 *
 */

public class OntologyTermCollisions {
	
	/**
	 * validate ontology
	 * @param ont
	 * @throws IOntologyException 
	 * @throws TerminologyException 
	 * @throws IOException 
	 */
	public static void validateOntology(IOntology ont) throws IOException, TerminologyException, IOntologyException{
		// load into terminology
		NobleCoderTerminology term = new NobleCoderTerminology();
		term.setStemWords(false);
		term.loadOntology(ont,null,true,true);
		PathHelper helper = new PathHelper(term);
		
		//check for collisons
		NobleCoderTerminology.Storage storage = term.getStorage();
		Map<String,Set<String>> map = storage.getTermMap();
		Set<String> problemClasses = new TreeSet<String>();
		System.out.println("Problem Terms:");
		for(String t: map.keySet()){
			Set<String> codes = map.get(t);
			if(codes.size()> 1){
				List<String> cls = new ArrayList<String>();
				for(String c: codes){
					//Concept cn = term.lookupConcept(c).getCode();
					cls.add(c);
					problemClasses.add(c);
				}
				System.out.println("\t'"+t+"'\t-> in classes:\t "+cls);
			}
		}
		System.out.println("\nProblem Class Summary:");
		for(String c: problemClasses){
			Concept cn = term.lookupConcept(c);
			System.out.println("\t'"+cn.getName()+"'\t["+cn.getCode()+" -> "+helper.getPaths(cn));
		}
		
	}
	
	/**
	 * @param args
	 * @throws IOntologyException 
	 * @throws TerminologyException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOntologyException, IOException, TerminologyException {
		File file = new File("/home/tseytlin/Dropbox/Data/EDDA Design Terms/StudyDesigns.owl");
		IOntology ont = OOntology.loadOntology(file);
		validateOntology(ont);
	}

}
