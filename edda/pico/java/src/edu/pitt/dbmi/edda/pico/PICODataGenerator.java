package edu.pitt.dbmi.edda.pico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import edu.pitt.dbmi.nlp.noble.terminology.TerminologyException;

/**
 * generate DATA files in a CSV file by processing it with PICO
 * @author tseytlin
 */
public class PICODataGenerator {
	private List<String> trainFileNames,testFileNames;
	private Map<String,Boolean> includeMap ;
	private Map<String,Set<String>> data;
	private PICOExtractor extractor;
	private boolean includeAncestors;
	
	
	/**
	 * create an instance of PICO Data Generator with a template
	 * @param template
	 * @throws Exception 
	 */
	public PICODataGenerator(File template) throws Exception{
		trainFileNames = new ArrayList<String>();
		testFileNames = new ArrayList<String>();
		includeMap = new HashMap<String, Boolean>();
		data = new TreeMap<String,Set<String>>();
		extractor = new PICOExtractor(template);
	}
	
	
	/**
	 * Add value to a map
	 * @param map
	 * @param key
	 * @param val
	 */
	private void addValue(Map<String,Set<String>> map, String key, String val){
		Set<String> list = map.get(key);
		if(list == null){
			list = new HashSet<String>();
			map.put(key,list);
		}
		list.add(val);
	}
	
	
	/**
	 * process directory 
	 * @param file
	 * @param include
	 * @throws TerminologyException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void processDirectory(File file, boolean include, boolean train) throws FileNotFoundException, IOException, TerminologyException{
		List<String> files = train?trainFileNames:testFileNames;
		for(File f: new TreeSet<File>(Arrays.asList(file.listFiles()))){
			if(f.getName().endsWith(".txt")){
				System.out.println("processing "+f.getAbsolutePath()+" ..");
				Map<String,List<String>> map = extractor.processDocument(f);
				String name = f.getName();
				includeMap.put(name,include);
				files.add(name);
				for(String key: map.keySet()){
					for(String value: map.get(key)){
						addValue(data,value,name);
						if(includeAncestors){
							for(String parent: extractor.getAncestors(value)){
								addValue(data,parent,name);
							}
						}
					}
				}
			}
		}
	}
	
	public void saveData(File file, boolean train) throws IOException{
		System.out.println("saving data "+file.getAbsolutePath()+" ..");
		final char S = ',';
		BufferedWriter w = new BufferedWriter(new FileWriter(file));
		List<String> files = train?trainFileNames:testFileNames;
		// write header
		w.write("file"+S);
		w.write("label");
		for(String attr: data.keySet()){
			w.write(S+attr.replaceAll("\\W+","_"));
		}
		w.write("\n");
		
		// now write data for each file
		for(String f: files){
			w.write(f+S);
			w.write(includeMap.get(f)?"Include":"Exclude");
			for(String attr: data.keySet()){
				String val = "0";
				if(data.get(attr).contains(f))
					val = "1";
				w.write(S+val);
			}
			w.write("\n");
		}
		
		w.close();
	}
	
	
	public void setIncludeAncestors(boolean includeAncestors) {
		this.includeAncestors = includeAncestors;
	}


	/**
	 * generate data
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		boolean includeAncestors = true;
		String suff = includeAncestors?"_PARENTS":"";
		File dir = new File("/home/tseytlin/Data/Reports/EDDA");
		File template = new File("/home/tseytlin/Work/EDDA/edda/pico/data/OrganTransplant.template");
		File trainY = new File(dir,"TRANSPLANT_TRAIN_Y");
		File trainN = new File(dir,"TRANSPLANT_TRAIN_N");
		File testY = new File(dir,"TRANSPLANT_TEST_Y");
		File testN = new File(dir,"TRANSPLANT_TEST_N");
		File trainOut = new File(dir,"TRANSPLANT_TRAIN"+suff+".csv");
		File testOut = new File(dir,"TRANSPLANT_TEST"+suff+".csv");
		PICODataGenerator gen = new PICODataGenerator(template);
		gen.setIncludeAncestors(includeAncestors);
		gen.processDirectory(trainN,false,true);
		gen.processDirectory(trainY,true,true);
		gen.processDirectory(testN,false,false);
		gen.processDirectory(testY,true,false);
		gen.saveData(trainOut,true);
		gen.saveData(testOut,false);
		System.out.println("done");

	}

}
