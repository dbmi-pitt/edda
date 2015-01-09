package edu.pitt.dbmi.edda.terms;

import java.io.*;
import java.util.*;

import edu.pitt.dbmi.nlp.noble.coder.*;
import edu.pitt.dbmi.nlp.noble.coder.model.Document;
import edu.pitt.dbmi.nlp.noble.coder.model.Mention;
import edu.pitt.dbmi.nlp.noble.terminology.Concept;
import edu.pitt.dbmi.nlp.noble.terminology.impl.NobleCoderTerminology;
import edu.pitt.terminology.*;



public class ConceptCoder {
	private boolean USE_TF_IDF = false;
	private boolean MARK_ANCESTORS = false;
	private Map<Concept,Map<String,Integer>> concepCounts;
	private Set<String> files;
	private NobleCoder coder;
	
	public void setCoder(String name) throws Exception {
		coder = new NobleCoder(new File(NobleCoderTerminology.getPersistenceDirectory(),name));
	}
	
	public void process(String name) throws Exception {
		File f = new File(name);
		if(f.isDirectory()){
			for(File c: f.listFiles()){
				process(c.getAbsolutePath());
			}
		}else if(isValid(f)){
			parse(f);
		}
	}
	
	private boolean isValid(File f){
		return f.isFile() && f.getName().endsWith("_FULL.txt");
	}
	
	/**
	 * parse text to find design terms
	 * @param text
	 * @throws Exception
	 */
	private void parse(File f) throws Exception {
		if(concepCounts == null)
			concepCounts = new HashMap<Concept, Map<String,Integer>>();
		String k = f.getAbsolutePath();
		System.out.println("processing "+k+" ...");
		BufferedReader r = new BufferedReader(new FileReader(f));
		StringBuffer text = new StringBuffer();
		for(String l=r.readLine();l != null; l=r.readLine()){
			text.append(l+"\n");
		}
		r.close();
		
		// do a single search
		Document doc = new Document(text.toString());
		coder.process(doc);
		for(Mention m :doc.getMentions()){
			Concept c = m.getConcept();
			List<Concept> mark = new ArrayList<Concept>();
			mark.add(c);
			if(MARK_ANCESTORS){
				for(Concept p: c.getParentConcepts()){
					mark.add(p);
				}
			}
			for(Concept cc: mark){
				Map<String,Integer> counts = concepCounts.get(cc);
				if(counts == null){
					counts = new LinkedHashMap<String, Integer>();
					concepCounts.put(cc,counts);
				}
				counts.put(k,counts.containsKey(k)?1+counts.get(k):1);
			}
		}
		
		
		if(files == null)
			files = new TreeSet<String>();
		files.add(k);
	}
	
	/**
	 * get found concepts in a document set
	 * @return
	 */
	public Set<Concept> getFoundConcepts(){
		return concepCounts.keySet();
	}
	
	
	public void save(File f) throws Exception {
		List<Concept> keys = new ArrayList<Concept>();
		for(String cui: ((NobleCoderTerminology)coder.getTerminology()).getAllConcepts()){
			keys.add(coder.getTerminology().lookupConcept(cui));
		}
		save(f,keys);
	}
	
	public void save(File f,Collection<Concept> concepts) throws Exception {
		System.out.println("saving "+f.getAbsolutePath()+" ...");
		String s = ";";
		Set<Concept> keys = new TreeSet<Concept>(new Comparator<Concept>() {
			public int compare(Concept o1, Concept o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		keys.addAll(concepts);
		/*for(String cui: concepts){
			keys.add(coder.getTerminology().lookupConcept(cui));
		}*/
		
		
		BufferedWriter w = new BufferedWriter(new FileWriter(f));	
		// write out header
		w.write("file path"+s+"label");
		for(Concept c:  keys){
			String name = c.getName().replaceAll("\\W+","_");
			if(name.length() > 100)
				name = name.substring(0,100)+"..";
			w.write(s+name);
		}
		w.write("\n");
		
		// write out data
		for(String file: files){
			// write out file name
			w.write(file);
			// write out label
			w.write(s+(file.contains("_Y_")?"include":"exclude"));
			// write out design term features
			for(Concept c:  keys){
				w.write(s+calculateValue(concepCounts.get(c),file));
			}
			w.write("\n");
			
		}
		w.close();
	}
	
	/**
	 * calculate value based on frequency table given
	 * @param map
	 * @param key
	 * @return
	 */
	private double calculateValue(Map<String,Integer> map,String key){
		// default condition
		if(map == null || !map.containsKey(key))
			return 0;
		
		// calculate TF (term frequency)
		double tf   = map.get(key);  
		if(USE_TF_IDF){
			// calculate IDF
			double idf =  Math.log(files.size()/map.size());
			return tf*idf;
		}
		return tf;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// setup parameter
		String param  = " (sn+dt)";
		String domain = "ORGAN_TRANSPLANT";
		String train  = "TRAIN"; 
		String test   = "TEST";
		String dir    = "/home/tseytlin/Data/EDDA/"+domain+"/5050_2xTitles/";
		
		
		String terminology = "SR_"+domain+param;
		String [] trainDirs = new String [] {dir+train+"_data/FULL_Y_"+train.toLowerCase(),dir+train+"_data/FULL_N_"+train.toLowerCase()};
		String [] testDirs = new String []  {dir+test+"_data/FULL_Y_"+test.toLowerCase(),dir+test+"_data/FULL_N_"+test.toLowerCase()};
		String trainOut  = "/home/tseytlin/"+domain+"_SR_Codes_A.csv";
		String testOut   = "/home/tseytlin/"+domain+"_SR_Codes_B.csv";;
		
		// process TRAIN dataset	
		ConceptCoder dt1 = new ConceptCoder();
		dt1.setCoder(terminology);
		for(String d :trainDirs)
			dt1.process(d);
		// process TEST dataset
		ConceptCoder dt2 = new ConceptCoder();
		dt2.setCoder(terminology);
		for(String d :testDirs)
			dt2.process(d);
		
		// create a subset of all concepts
		Set<Concept> concepts = new HashSet<Concept>();
		concepts.addAll(dt1.getFoundConcepts());
		concepts.addAll(dt2.getFoundConcepts());
		
		System.out.println("saving ...");
		dt1.save(new File(trainOut),concepts);
		dt2.save(new File(testOut),concepts);
		
		System.out.println("\ndone");
	}

}
