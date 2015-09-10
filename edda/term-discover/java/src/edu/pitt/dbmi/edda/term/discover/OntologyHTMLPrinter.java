package edu.pitt.dbmi.edda.term.discover;

import java.util.Arrays;

import edu.pitt.dbmi.nlp.noble.ontology.*;
import edu.pitt.dbmi.nlp.noble.ontology.owl.OOntology;
import edu.pitt.dbmi.nlp.noble.terminology.Concept;

public class OntologyHTMLPrinter {
	private static boolean doSynonyms = true, doDefinitions = true;
	
	public static void printClass(IClass cls){
		Concept c = cls.getConcept();
		String tip = c.getDefinition();
		System.out.println("<li><b>"+c.getName()+"</b> ");
		if(doDefinitions && tip != null && tip.length() > 0){
			System.out.println(" [<a href=\"\" title=\""+tip+"\">definition</a>]");
		}
		if(doSynonyms){
			System.out.println("<br>");
			String [] syn = c.getSynonyms();
			Arrays.sort(syn);
			String p = "";
			for(String s: syn){
				System.out.print(p+s); 
				if(p.length() == 0)
					p = "; ";
			}
			System.out.println("");
		}
		IClass [] kids = getClasses(cls.getDirectSubClasses());
		if(kids.length > 0){
			System.out.println("<ul>");
			for(IClass i: kids)
				printClass(i);
			System.out.println("</ul>");
		}
		System.out.println("</li>");
	}
	
	private static IClass [] getClasses(IClass [] cls){
		Arrays.sort(cls);
		return cls;
	}
	
	public static void main(String[] args) throws IOntologyException {
		IOntology ontology = OOntology.loadOntology("http://edda.dbmi.pitt.edu/ontologies/StudyDesigns.owl");
		String title = (String) ontology.getPropertyValue(ontology.getProperty(IProperty.DC_TITLE));
		String name = (title != null)?title:ontology.getName();
		String version = ontology.getVersion();
				
		System.out.println("<html><title>"+ontology.getName()+"</title></head>");
		System.out.println("<body>");
		System.out.println("<h2>"+name+"  ("+version+")</h2>");
		System.out.println("<p>"+ontology.getDescription()+"</p>");
		System.out.println("<hr><ul>");
		for(IClass c: getClasses(ontology.getRootClasses())){
			printClass(c);
		}
		System.out.println("</ul></body>");
		
	}

}
