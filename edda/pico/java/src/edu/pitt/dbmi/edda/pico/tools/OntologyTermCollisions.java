package edu.pitt.dbmi.edda.pico.tools;

import java.io.File;
import java.io.IOException;
import java.util.*;

import edu.pitt.dbmi.nlp.noble.ontology.ClassPath;
import edu.pitt.dbmi.nlp.noble.ontology.IClass;
import edu.pitt.dbmi.nlp.noble.ontology.IOntology;
import edu.pitt.dbmi.nlp.noble.ontology.IOntologyException;
import edu.pitt.dbmi.nlp.noble.ontology.OntologyUtils;
import edu.pitt.dbmi.nlp.noble.ontology.owl.OOntology;
import edu.pitt.dbmi.nlp.noble.terminology.Concept;
import edu.pitt.dbmi.nlp.noble.terminology.ConceptPath;
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
		term.loadOntology(ont,null,true,false);
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
				System.out.println("\t'"+t+"'");
				for(String c: cls){
					IClass cc = ont.getClass(c);
					for(ClassPath cp: OntologyUtils.getRootPaths(cc)){
						System.out.println("\t\t"+cp);
					}
					/*for(ConceptPath path: helper.getPaths(term.lookupConcept(c))){
						System.out.println("\t\t"+path);
					}*/
				}
			}
		}
		System.out.println("\nSingle Term Variant:");
		/*
		for(String c: problemClasses){
			Concept cn = term.lookupConcept(c);
			System.out.println("\t'"+cn.getName()+"'\t["+cn.getCode()+" -> "+helper.getPaths(cn));
		}*/
		for(IClass cls: ont.getRoot().getSubClasses()){
			Concept c = cls.getConcept();
			if(c.getName().contains(" ")){
				for(String s: c.getSynonyms()){
					if(!s.contains(" ") && !s.contains("-")){
						System.out.println("\t'"+s+"'");
						for(ClassPath cp: OntologyUtils.getRootPaths(cls)){
							System.out.println("\t\t"+cp);
						}
					}
				}
			}
		}
		
	}
	
	/**
	 * @param args
	 * @throws IOntologyException 
	 * @throws TerminologyException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOntologyException, IOException, TerminologyException {
		File file = new File("/home/tseytlin/Data/SD_Mining/data/final/ontology/Post Hoc Processing/SystematicReviewOntology.owl");
		IOntology ont = OOntology.loadOntology(file);
		//validateOntology(ont);
		printDoubleLabels(ont);
	}

	private static void printDoubleLabels(IOntology ont) {
		for(IClass cls: ont.getRoot().getSubClasses()){
			if(cls.getLabels().length > 1){
				System.out.println(OntologyUtils.getRootPaths(cls)+"\t"+Arrays.asList(cls.getLabels()));
			}
		}
		
	}

}
