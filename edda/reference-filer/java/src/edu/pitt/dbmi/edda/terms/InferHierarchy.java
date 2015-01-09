package edu.pitt.dbmi.edda.terms;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import edu.pitt.ontology.*;
import edu.pitt.ontology.owl.OOntology;
import edu.pitt.ontology.protege.POntology;
import edu.pitt.terminology.lexicon.Concept;
import edu.pitt.text.tools.TextTools;

public class InferHierarchy {
	private IOntology ont;
	
	public InferHierarchy(IOntology ont){
		this.ont = ont;
	}
	
	
	/**
	 * infer hierarchy of findings based on their linguistic description
	 * (organize feature - attribute -values )
	 */
	
	public void inferHierarchy(IClass root){
		// iterate through all features and
		IClass [] classes = root.getSubClasses();
		Arrays.sort(classes,new Comparator<IClass>() {
			public int compare(IClass o1, IClass o2) {
				return o1.getName().length() - o2.getName().length();
			}
		});
		for(IClass c1: classes){
			List<IClass> list = new ArrayList<IClass>();
			for(IClass c2: classes){
				if(!c1.equals(c2) && isBroader(c1,c2)){
					list.add(c2);
				}
			}
			System.out.println(c1.getName()+" -> "+list);
			setupHeiarchy(c1,list);
		}
	}
	
	private boolean isBroader(IClass c1, IClass c2) {
	/*	String [] c1_names = new String[] {c1.getConcept().getName()};
		String [] c2_names = new String[] {c2.getConcept().getName()};*/
		String [] c1_names = c1.getConcept().getSynonyms();
		String [] c2_names = c2.getConcept().getSynonyms();
		List<List<String>> c1_words = new ArrayList<List<String>>();
		List<List<String>> c2_words = new ArrayList<List<String>>();
		for(String s: c1_names){
			c1_words.add(TextTools.normalizeWords(s,true));
		}
		for(String s: c2_names){
			c2_words.add(TextTools.normalizeWords(s,true));
		}
		
		for(List<String> c1_syn: c1_words){
			for(List<String> c2_syn: c2_words){
				if(c2_syn.size() > c1_syn.size() && c2_syn.containsAll(c1_syn))
					return true;
			}
		}
		return false;
	}


	/**
	 * rename classes based on labels
	 * @param root
	 */
	public void renameClasses(IClass root){
		for(IClass cls: root.getSubClasses()){
			String [] labels = cls.getLabels();
			if(labels.length > 0){
				cls.setName(createClassName(labels[0]));
			}
		}
	}
	
	/**
	 * create ontology friendly class name
	 * @param name
	 * @return
	 */
	private String createClassName(String name){
		return name.trim().replaceAll("\\s*\\(.+\\)\\s*","").replaceAll("[^\\w\\-]","_").replaceAll("_+","_");
	}
	
	
	/**
	 * is class a a substring of class b
	 * @param a
	 * @param b
	 * @return
	 */
	private boolean isSubstring(IClass a,IClass b){
		String sa = a.getName().replaceAll("_"," ");
		String ba = b.getName().replaceAll("_"," ");
		return ba.matches(".*\\b"+sa+"\\b.*");
	}
	
	/**
	 * infer concept attribuets of a single class
	 * @param cls
	 * @throws Exception
	 */
	private void inferHeiarchy(IClass parent,IClass cls) {
		if(!cls.isSystem()){
			List<IClass> list = new ArrayList<IClass>();
			// get all matching resources
			for(Iterator i = ont.getMatchingResources(cls.getName());i.hasNext();){
				Object obj = i.next();
				if(obj instanceof IClass){
					// don't add stuff from different parent
					// nor do you want to add stuff that are from the same word
					IClass c = (IClass)obj;
					if(c.hasSuperClass(parent) && isSubstring(cls,c))
						list.add(c);
				}
			}
			setupHeiarchy(cls, list);
		}
	}
	
	/**
	 * infer concept attribuets of a single class
	 * @param cls
	 * @throws Exception
	 */
	private void setupHeiarchy(IClass cls,List<IClass> list) {
		// remove self
		list.remove(cls);
		
		// if list not empty
		if(!list.isEmpty()){
			//System.out.println(cls+" -> "+list);
			try{
			for(IClass child: list){
				if(!child.hasSuperClass(cls) && !child.hasSubClass(cls)){
					// remove all feature superclasses
					for(IClass p: child.getDirectSuperClasses()){
						//if(isFeature(p))
						child.removeSuperClass(p);
					}
					// add superclass
					child.addSuperClass(cls);
				}
			}
			}catch(StackOverflowError e){
				System.err.println("stack overflow on "+cls);
			}
		}	
	}
	


	private static void printOntology(IClass root, String indent) {
		System.out.println(indent+root.getName());
		for(IClass c: root.getDirectSubClasses()){
			printOntology(c, indent+"  ");
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//IOntology ont = OOntology.loadOntology(new File("/home/tseytlin/EDDA_Design_Terms.owl"));
		IOntology ont = OOntology.loadOntology(new File("/home/tseytlin/StudyDesigns.owl"));
		System.out.println("Original Ontology\n-----------------");
		InferHierarchy ih = new InferHierarchy(ont);
		System.out.println("\n ... renaming classes ... \n");
		//ih.renameClasses(ont.getRoot());
		//ont.save();
		printOntology(ont.getRoot(),"");
		System.out.println("\n ... inferring hierarchy ... \n");
		/*for(IClass c: ont.getRootClasses()){
			ih.inferHierarchy(c);
		}*/
		ih.inferHierarchy(ont.getClass("EDDA_Concepts"));
		System.out.println("Modified Ontology\n-----------------");
		printOntology(ont.getRoot(),"");
		ont.write(new FileOutputStream(new File("/home/tseytlin/StudyDesigns6.owl")),IOntology.OWL_FORMAT);
	}



}
