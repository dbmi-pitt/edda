package edu.pitt.dbmi.edda.terms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import edu.pitt.ontology.IClass;
import edu.pitt.ontology.IOntology;
import edu.pitt.ontology.protege.POntology;
import edu.pitt.terminology.Terminology;
import edu.pitt.terminology.client.IndexFinderTerminology;
import edu.pitt.terminology.lexicon.Concept;
import edu.pitt.text.tools.TextTools;


public class EnrichOntology {
	private final boolean USE_COMMENTS = true;
	private IOntology ontology;
	private Terminology terminology = new IndexFinderTerminology();
	private List<Concept> designTerms;
	private Map<Concept,Set<IClass>> foundConcepts;
	private TextTools textTools = new TextTools();
	
	/**
	 * load terms file
	 * @param file
	 * @throws Exception
	 */
	public void loadTerms(File file) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Concept c = null;
		List<String> synonyms = null;
		designTerms = new ArrayList<Concept>();
		for(String line=reader.readLine();line != null; line=reader.readLine()){
			line = line.trim();
			
			// skip junk
			if(line.length() == 0 || line.matches("_+"))
				continue;
			
			// start new concept 
			if(line.matches("\\d+")){
				// add previous concept
				if(c != null && synonyms != null && synonyms.size() > 0){
					c.setName(synonyms.get(0));
					c.setSynonyms(synonyms.toArray(new String [0]));
					terminology.addConcept(c);
					designTerms.add(c);
				}
				// start new concept
				c = new Concept(line);
				synonyms = new ArrayList<String>();
			// add synonyms
			}else{
				synonyms.add(line);
			}
		}
		reader.close();
		
		// handle last concept
		if(c != null && synonyms != null && synonyms.size() > 0){
			c.setName(synonyms.get(0));
			c.setSynonyms(synonyms.toArray(new String [0]));
			terminology.addConcept(c);
			designTerms.add(c);
		}
	}
	
	public void loadOntology(IOntology ont){
		ontology = ont;
	}
	
	
	/**
	 * process terminology
	 */
	public void process() throws Exception {
		// for all classes
		foundConcepts = new HashMap<Concept,Set<IClass>>();
		int foundClasses = 0,totalClasses = 0;
		System.out.println("\n________________________________________\n");
		for(IClass cls: ontology.getRoot().getSubClasses()){
			// create a set of text that talks about this class
			List<String> texts = new ArrayList<String>();
			Collections.addAll(texts,cls.getLabels());
			// get names if labels not there
			if(texts.isEmpty())
				texts.add(cls.getName().replaceAll("_"," "));
			//Collections.addAll(texts,cls.getComments());
			if(USE_COMMENTS){
				/*for(String comment: cls.getComments()){
					Document doc = textTools.parseDocument(comment);
					for(Object o: doc.getPhrases()){
						String txt = ((Phrase)o).getNounPhrase().getTrimmedString();
						if(txt != null && txt.length() > 0)
							texts.add(txt);
					}
				}*/
			}
			
			// now lets go over every textual representation
			Set<Concept> result = new LinkedHashSet<Concept>();
			for(String txt: texts){
				Collections.addAll(result,terminology.search(txt));
			}
			
			// find the best result
			if(!result.isEmpty()){
				//System.out.println(cls.getName()+" | "+processResults(result));
				System.out.println("Class: "+cls.getName()+" /"+getID(cls));
				System.out.println("Class Synonyms: "+toString(cls.getLabels()));
				if(USE_COMMENTS)
					System.out.println("Class Definitions: "+cls.getDescription().replaceAll("\n"," "));
				System.out.println("Matched Concepts: "+toStringConcepts(result));
				System.out.println("Matched Concept Number: "+result.size());
				System.out.println("");
				
				//go over results
				for(Concept c: result){
					Set<IClass> list = foundConcepts.get(c);
					if(list == null){
						list = new LinkedHashSet<IClass>();
						foundConcepts.put(c,list);
					}
					list.add(cls);
				}
				foundClasses ++;
			}
			totalClasses ++;
		}
		
		System.out.println("\n________________________________________\n");
		for(Concept c: foundConcepts.keySet()){
			System.out.println("Design Term: "+c.getName());
			System.out.println("Design Synonyms: "+toString(c.getSynonyms()));
			System.out.println("Matched Classes: "+toStringClasses(foundConcepts.get(c)));
			System.out.println("Matched Class Number: "+foundConcepts.get(c).size());
			System.out.println("");
		}
		System.out.println("\n________________________________________\n");
		System.out.println("Matched Design Terms:  "+foundConcepts.size()+" / "+designTerms.size());
		System.out.println("Matched Classes:  "+foundClasses+" / "+totalClasses);
		
		
		// write out design terms
	
		
	}
	
	private String toStringConcepts(Set<Concept> result){
		List<String> texts = new ArrayList<String>();
		for(Concept c: result)
			texts.add(c.getName());
		return toString(texts);
	}
	
	private String toStringClasses(Set<IClass> result){
		List<String> texts = new ArrayList<String>();
		for(IClass c: result)
			texts.add(c.getName()+" /"+getID(c));
		return toString(texts);
	}
	
	private String toString(Collection<String> texts){
		String s =  texts.toString();
		return s.substring(1,s.length()-1).trim();
	}
	
	private String toString(String [] texts){
		String s =  Arrays.toString(texts).toString();
		return s.substring(1,s.length()-1).trim();
	}
	

	private void saveTerms(File file) throws Exception {
		FileWriter writer = new FileWriter(file);
		for(Concept c: designTerms){
			writer.write("________________________\n");
			for(String s: c.getSynonyms()){
				writer.write(s+"\n");
			}
			Set<IClass> result = foundConcepts.get(c);
			if(result != null){
				writer.write("---------------\n");
				for(IClass cls: result){
					writer.write(cls.getName()+" /"+getID(cls)+"\n");
				}
			}
			writer.write("________________________\n");
		}
		writer.close();
	}
	
	private String getID(IClass cls){
		String s = (String) cls.getPropertyValue(cls.getOntology().getProperty("id"));
		if(s.contains(":")){
			return s.split(":")[1];
		}
		return s;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		EnrichOntology ner = new EnrichOntology();
		ner.loadTerms(new File("/home/tseytlin/Work/systematic-reviews/data/design_terms_SORTED_TCB.txt"));
		ner.loadOntology(POntology.loadOntology(new File("/home/tseytlin/Work/systematic-reviews/data/Ontology_of_Clinical_Research.owl")));
		ner.process();
		ner.saveTerms(new File("/home/tseytlin/design_terms_OCRe_match.txt"));
		System.exit(0);

	}

}
