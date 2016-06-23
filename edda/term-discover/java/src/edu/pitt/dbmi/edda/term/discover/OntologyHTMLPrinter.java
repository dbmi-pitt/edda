package edu.pitt.dbmi.edda.term.discover;

import java.util.Arrays;
import java.util.Comparator;

import edu.pitt.dbmi.nlp.noble.ontology.*;
import edu.pitt.dbmi.nlp.noble.ontology.owl.OOntology;
import edu.pitt.dbmi.nlp.noble.terminology.Concept;

public class OntologyHTMLPrinter {
	private static boolean doSynonyms = true, doDefinitions = true, asTips = true;
	
	public static void printClass(IClass cls){
		Concept c = cls.getConcept();
		String tip = c.getDefinition();
		System.out.println("<li><b>"+c.getName()+"</b> ");
		if(doDefinitions && tip != null && tip.length() > 0){
			if(asTips)
				System.out.println(" [<a href=\"\" title=\""+tip+"\">definition</a>]");
			else
				System.out.println("<div><i>"+tip+"</i></div>");
		}
		if(doSynonyms){
			//if(asTips)
			//System.out.println("<br>");
			String [] syn = c.getSynonyms();
			Arrays.sort(syn);
			String p = "";
			System.out.println("<div style=\"margin-top:5px; margin-bottom:10px;\">");
			for(String s: syn){
				System.out.print(p+s); 
				if(p.length() == 0)
					p = "; ";
			}
			System.out.println("</div>");
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
		Arrays.sort(cls,new Comparator<IClass>() {
			public int compare(IClass o1, IClass o2) {
				return o1.getConcept().getName().compareToIgnoreCase(o2.getConcept().getName());
			}
		});
		return cls;
	}
	
	public static void main(String[] args) throws IOntologyException {
		IOntology ontology = OOntology.loadOntology("/home/tseytlin/Data/SD_Mining/data/final/ontology/Post Hoc Processing/StudyDesigns.owl");
		
		String title = (String) ontology.getPropertyValue(ontology.getProperty(IProperty.DC_TITLE));
		String name = (title != null)?title:ontology.getName();
		String version = ontology.getVersion();
				
		System.out.println("<html><title>"+ontology.getName()+"</title></head>");
		System.out.println("<body>");
		System.out.println("<h2>"+name+"  ("+version+")</h2>");
		System.out.println("<p>"+ontology.getDescription()+"</p>");
		IProperty p = ontology.getProperty("http://purl.org/dc/elements/1.1/rights");
		if(p != null && ontology.getPropertyValue(p) != null)
			System.out.println("<p><i>"+ontology.getPropertyValue(p)+"</i></p>");
		System.out.println("<hr><ul>");
		for(IClass c: getClasses(ontology.getRootClasses())){
			printClass(c);
		}
		System.out.println("</ul></body>");
		
	}

}
