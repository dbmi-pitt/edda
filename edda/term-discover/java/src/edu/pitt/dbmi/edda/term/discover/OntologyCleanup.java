package edu.pitt.dbmi.edda.term.discover;

import java.io.File;
import java.util.*;

import edu.pitt.dbmi.nlp.noble.ontology.*;
import edu.pitt.dbmi.nlp.noble.ontology.owl.OOntology;
import edu.pitt.dbmi.nlp.noble.tools.TextTools;

/**
 * clean up ontology
 * @author tseytlin
 *
 */

public class OntologyCleanup {
	private IOntology ontology;
	
	public OntologyCleanup(IOntology ont){
		ontology = ont;
	}
	
	public void mergeEquivalentClasses(){
		Set<IClass> toMerge = new HashSet<IClass>();
		Set<IClass> notToMerge = new HashSet<IClass>();
		for(IClass cls: ontology.getRoot().getSubClasses()){
			List<IClass> list = new ArrayList<IClass>();
			Collections.addAll(list,cls.getEquivalentClasses());
			list.remove(cls);
			if(!list.isEmpty() && !notToMerge.contains(cls)){
				list.add(cls);
				toMerge.add(getBestClassToMerge(cls,cls.getEquivalentClasses()));
				notToMerge.addAll(list);
			}
		}
		for(IClass cls: toMerge){
			mergeClass(cls);
		}
	}
	
	private IClass getBestClassToMerge(IClass cls, IClass [] other){
		for(IClass c: other){
			if(c.getDirectSubClasses().length > cls.getDirectSubClasses().length || c.getProperties().length > cls.getProperties().length){
				cls = c;
			}
		}
		return cls;
	}
	
	
	private void mergeClass(IClass cls) {
		System.out.println("merging "+cls.getLabel()+" ..");
		for(IClass c: Arrays.asList(cls.getEquivalentClasses())){
			if(cls.equals(c))
				continue;
			
			// copy property values
			for(IProperty p: c.getProperties()){
				for(Object v: c.getPropertyValues(p)){
					if(!cls.hasPropetyValue(p, v))
						cls.addPropertyValue(p,v);
				}
			}
			// copy children
			for(IClass child: c.getDirectSubClasses()){
				child.addSuperClass(cls);
			}
			// remove as equivalent class
			cls.removeEquivalentClass(c);
			
			// remove class altogether
			System.out.println("\tremoving "+c.getLabel());
			c.delete();
		}
		
	}

	public void normalizeLabels(){
		IProperty prop = ontology.getProperty("Variant");
		for(IClass cls: ontology.getRoot().getSubClasses()){
			// copy label as varient (just in case)
			for(String lbl: cls.getLabels()){
				if(!cls.hasPropetyValue(prop,lbl)){
					cls.addPropertyValue(prop, lbl);
				}
			}
			
			// now lets pick the best varient IF we don't have a label, or it is not OK, or it is not lower-case
			if(cls.getLabels().length == 0 || !isOKLabel(cls.getLabel()) || !cls.getLabel().equals(cls.getLabel().toLowerCase())){
				String lbl = cls.getLabel();
				System.out.print("changing label of "+lbl+" .. ");
				
				// remove prior labels
				for(String s: cls.getLabels()){
					cls.removeLabel(s);
				}
				// pick best variant
				for(Object str : cls.getPropertyValues(prop)){
					if(isOKLabel((String)str)){
						lbl = (String) str;
						break;
					}
				}
				// re-add label
				lbl = toLowerCase(lbl);
				cls.addLabel(lbl);
				
				// print
				System.out.println(lbl);
				
				// add as a varient non lowercase version
				if(!cls.hasPropetyValue(prop,lbl)){
					cls.addPropertyValue(prop, lbl);
				}
			}
			
		}
	}
	
	private String toLowerCase(String lbl) {
		StringBuffer str = new StringBuffer();
		for(String word : lbl.split(" ")){
			if(word.matches("[IV/]+[ab]?")){
				str.append(word+" ");
			}else{
				str.append(word.toLowerCase()+" ");
			}
		}
		return str.toString().trim();
	}

	private boolean isOKLabel(String str) {
		// check if inverted
		if(str.contains(",") || str.contains(":"))
			return false;
		// check if the head word is in singular form
		List<String> words = TextTools.getWords(str);
		if(words.isEmpty())
			return false;
		
		// uppoer case are usually not good
		if(str.toUpperCase().equals(str) || str.contains("ipd "))
			return false;
		
		String last = words.get(words.size()-1);
		if(TextTools.isPlural(last)){
			return false;
		}
		
		// prefer last word to be a seed
		if(!last.toLowerCase().matches("(study|design|trial|model|assessment|evaluation|review)")){
			return false;
		}
		
		// not OK for paranthesis?
		if(str.contains("("))
			return false;
		
		// skip small ones
		if(str.length() < 6)
			return false;
		
	
		return true;
	}

	public void normalizeURIs(){
		for(IClass c: ontology.getRoot().getSubClasses()){
			String label = c.getLabel().replaceAll("\\W+","_");
			if(!c.getName().equals(label)){
				System.out.println("rename "+c.getName()+" -> "+label);
				c.setName(label);
			}
		}
	}
	
	public void save() throws IOntologyException{
		ontology.save();
	}

	public static void main(String[] args) throws IOntologyException {
		File file = new File("/home/tseytlin/Dropbox/Data/EDDA Design Terms/Study Design Mining/data/final/ontology/Post Hoc Processing/PublicationType.owl");
		
		OntologyCleanup cleaner = new OntologyCleanup(OOntology.loadOntology(file));
		//cleaner.mergeEquivalentClasses();
		//cleaner.normalizeLabels();
		cleaner.normalizeURIs();
		cleaner.save();
		System.out.println("ok");
	}

}
