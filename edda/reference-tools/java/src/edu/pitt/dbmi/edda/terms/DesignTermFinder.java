package edu.pitt.dbmi.edda.terms;

import java.io.*;
import java.util.*;

import edu.pitt.terminology.*;
import edu.pitt.terminology.client.IndexFinderTerminology;
import edu.pitt.terminology.lexicon.Concept;



public class DesignTermFinder {
	private final String DESIGN_TERMS = "DesignTerms";
	private Terminology term;
	private Map<Concept,Map<String,Integer>> designTerms;
	private Set<String> files;
	//private Set<Concept> concepts;
	
	public Terminology getTerminology() throws Exception {
		if(term == null){
			term = new IndexFinderTerminology(DESIGN_TERMS);
		}
		return term;
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
		if(designTerms == null)
			designTerms = new HashMap<Concept, Map<String,Integer>>();
		String k = f.getAbsolutePath();
		System.out.println("processing "+k+" ...");
		BufferedReader r = new BufferedReader(new FileReader(f));
		StringBuffer text = new StringBuffer();
		for(String l=r.readLine();l != null; l=r.readLine()){
			text.append(l+"\n");
		}
		r.close();
		
		// do a single search
		for(Concept c : getTerminology().search(text.toString(),IndexFinderTerminology.BEST_MATCH)){
			Map<String,Integer> counts = designTerms.get(c);
			if(counts == null){
				counts = new LinkedHashMap<String, Integer>();
				designTerms.put(c,counts);
			}
			counts.put(k,counts.containsKey(k)?1+counts.get(k):1);
		}
		
		
		if(files == null)
			files = new TreeSet<String>();
		files.add(k);
	}
	
	public void save(File f) throws Exception {
		System.out.println("saving "+f.getAbsolutePath()+" ...");
		String s = ";";
		Set<Concept> keys = new TreeSet<Concept>(new Comparator<Concept>() {
			public int compare(Concept o1, Concept o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		//keys.addAll(designTerms.keySet());
		for(String cui: ((IndexFinderTerminology)getTerminology()).getAllConcepts()){
			keys.add(getTerminology().lookupConcept(cui));
		}
		
		
		BufferedWriter w = new BufferedWriter(new FileWriter(f));	
		// write out header
		w.write("file path"+s+"label");
		for(Concept c:  keys){
			w.write(s+c.getName().replaceAll(" ","_"));
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
				int val = 0;
				Map<String,Integer> map = designTerms.get(c);
				if(map != null && map.containsKey(file)){
					val = map.get(file);
				}
				w.write(s+val);
			}
			w.write("\n");
			
		}
		w.close();
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//args = new String [] {"/home/tseytlin/Data/EDDA/MALARIA/5050_2xTitles/TRAIN_data/FULL_Y_train","/home/tseytlin/Data/EDDA/MALARIA/5050_2xTitles/TRAIN_data/FULL_N_train","/home/tseytlin/MALARIA_DesignTerms_full_train.csv"}; 
		//args = new String [] {"/home/tseytlin/Data/EDDA/MALARIA/5050_2xTitles/TEST_data/FULL_Y_test","/home/tseytlin/Data/EDDA/MALARIA/5050_2xTitles/TEST_data/FULL_N_test","/home/tseytlin/MALARIA_DesignTerms_full_test.csv"}; 
		
		//args = new String [] {"/home/tseytlin/Data/EDDA/FLU/5050_2xTitles/A_data/FULL_Y_a","/home/tseytlin/Data/EDDA/FLU/5050_2xTitles/A_data/FULL_N_a","/home/tseytlin/FLU_DesignTerms_full_a.csv"}; 
		//args = new String [] {"/home/tseytlin/Data/EDDA/FLU/5050_2xTitles/B_data/FULL_Y_b","/home/tseytlin/Data/EDDA/FLU/5050_2xTitles/B_data/FULL_N_b","/home/tseytlin/FLU_DesignTerms__full_b.csv"}; 
		
		//args = new String [] {"/home/tseytlin/Data/EDDA/AMELO/5050_2xTitles/A_data/FULL_Y_a","/home/tseytlin/Data/EDDA/AMELO/5050_2xTitles/A_data/FULL_N_a","/home/tseytlin/AMELO_DesignTerms_full_a.csv"}; 
		//args = new String [] {"/home/tseytlin/Data/EDDA/AMELO/5050_2xTitles/B_data/FULL_Y_b","/home/tseytlin/Data/EDDA/AMELO/5050_2xTitles/B_data/FULL_N_b","/home/tseytlin/AMELO_DesignTerms_full_b.csv"}; 
		
		//args = new String [] {"/home/tseytlin/Data/EDDA/GALACTOMANNAN/5050_2xTitles/TRAIN_data/FULL_Y_train","/home/tseytlin/Data/EDDA/GALACTOMANNAN/5050_2xTitles/TRAIN_data/FULL_N_train","/home/tseytlin/GALACTOMANNAN_DesignTerms_full_a.csv"}; 
		//args = new String [] {"/home/tseytlin/Data/EDDA/GALACTOMANNAN/5050_2xTitles/TEST_data/FULL_Y_test","/home/tseytlin/Data/EDDA/GALACTOMANNAN/5050_2xTitles/TEST_data/FULL_N_test","/home/tseytlin/GALACTOMANNAN_DesignTerms_full_b.csv"}; 
		
		//args = new String [] {"/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/5050_2xTitles/TRAIN_data/FULL_Y_train","/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/5050_2xTitles/TRAIN_data/FULL_N_train","/home/tseytlin/ORGAN_TRANSPLANT_DesignTerms_full_a.csv"}; 
		args = new String [] {"/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/5050_2xTitles/TEST_data/FULL_Y_test","/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/5050_2xTitles/TEST_data/FULL_N_test","/home/tseytlin/ORGAN_TRANSPLANT_DesignTerms_full_b.csv"}; 
		
		
		
		DesignTermFinder dt = new DesignTermFinder();
		for(int i = 0;i<args.length-1;i++)
			dt.process(args[i]);
		dt.save(new File(args[args.length-1]));
		System.out.println("done");
		
	}

}
