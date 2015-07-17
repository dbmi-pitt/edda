package edu.pitt.dbmi.edda.term.discover;

import edu.pitt.dbmi.nlp.noble.ontology.*;
import edu.pitt.dbmi.nlp.noble.ontology.owl.OOntology;

public class EDDATerminologyExtractor {

	public static void main(String[] args) throws IOntologyException {
		IOntology ont = OOntology.loadOntology("http://edda.dbmi.pitt.edu/ontologies/StudyDesigns.owl");
		IClass root = ont.getClass("Study_Designs");
		for(IClass c: root.getSubClasses()){
			for(String s: c.getConcept().getSynonyms()){
				System.out.println(s);
			}
		}
	}

}
