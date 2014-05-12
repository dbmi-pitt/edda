package edu.pitt.dbmi.edda.misc;

import java.io.*;
import java.util.*;


/**
 * process giant output file and cross reference it 
 * @author tseytlin
 *
 */
public class GiantOutputProcessor {
	private static final List<String> questions = Arrays.asList(
			"Is the paper about OSCC",
			"Is the paper about Biomarkers",
			"Is the paper about Prognosis",
			"Is the paper relevant for OSCC Biomarkers Prognosis",
			"Did authors explicitly state biomarkers OSCC prognosis",
			"Was prognosis stated increase morbidity mortality decrease");
	private static final List<String> open_questions = Arrays.asList(
			"What are the Biomarkers and how were they stated",
			"What is the prognosis and how was it  stated");
	/**
	 * read in key file
	 */
	private static Map<String,String> readKey(File f) throws Exception{
		Map<String,String> map = new LinkedHashMap<String, String>();
		BufferedReader r = new BufferedReader(new FileReader(f));
		for(String l = r.readLine();l !=null; l=r.readLine()){
			String [] p = l.split("\\s+");
			if(p.length == 2){
				map.put(p[0].trim(),p[1].trim());
			}
		}
		r.close();
		return map;
	}
	
	/**
	 * parse CSV line (take care of double quotes)
	 * @param line
	 * @param delimeter
	 * @return
	 */
	private static List<String> parseCSVline(String line){
		return parseCSVline(line, ',');
	}
	
	/**
	 * parse CSV line (take care of double quotes)
	 * @param line
	 * @param delimeter
	 * @return
	 */
	private static List<String> parseCSVline(String line,char delim){
		List<String> fields = new ArrayList<String>();
		boolean inquotes = false;
		int st = 0;
		for(int i = 0;i<line.length();i++){
			// start/end quotes
			if(line.charAt(i) == '"'){
				inquotes ^= true;
			}
			// found delimeter (use it)
			if(!inquotes && line.charAt(i) == delim){
				String s = line.substring(st,i).trim();
				if(s.startsWith("\"") && s.endsWith("\""))
					s = s.substring(1,s.length()-1);
				fields.add(s.trim());
				st = i+1;
			}
		}
		// handle last field
		if(st < line.length()){
			String s = line.substring(st).trim();
			if(s.startsWith("\"") && s.endsWith("\""))
				s = s.substring(1,s.length()-1);
			fields.add(s.trim());
		}
		return fields;
	}
	
	
	/**
	 * read in spreadsheet
	 * @param f
	 * @return
	 * @throws Exception
	 */
	private static List<Map<String,String>> readSpreadsheet(File f) throws Exception {
		List<Map<String,String>> spreadsheet = new ArrayList<Map<String,String>>();
		BufferedReader r = new BufferedReader(new FileReader(f));
		List<String> header = new ArrayList<String>();
		for(String l = r.readLine();l !=null; l=r.readLine()){
			// read header at first line
			if(header.isEmpty()){
				header = parseCSVline(l);
			}else{
				Map<String,String> map = new LinkedHashMap<String, String>();
				List<String> data = parseCSVline(l);
				if(data.size() <= header.size()){
					for(int i=0;i<data.size();i++){
						map.put(header.get(i),data.get(i));
					}
				}else{
					System.err.println("Error: FUCK ME!");
				}
				spreadsheet.add(map);
			}
		}
		r.close();
		return spreadsheet;
	}
	
	private static void writeSpreadsheet(List<Map<String,String>>  data, File f) throws Exception {
		BufferedWriter w = new BufferedWriter(new FileWriter(f));
		boolean header = false;
		for(Map<String,String> map: data){
			// write header
			if(!header){
				for(String key: map.keySet()){
					String cell = key;
					if(cell.contains(","))
						cell = "\""+cell+"\"";
					w.write(cell+",");
				}
				w.write("\n");
				header = true;
			}
			//write data
			for(String key: map.keySet()){
				String cell = map.get(key);
				if(cell.contains(","))
					cell = "\""+cell+"\"";
				w.write(cell+",");
			}
			w.write("\n");
		}
		w.close();
	}
	
	/**
	 * add PMID to each spreadsheet
	 * @param data
	 * @param keys
	 */
	private static List<Map<String,String>> collapseSpreadsheet(List<Map<String,String>> data,Map<String,String> keys){
		// add PMID columm
		for(Map<String,String> m : data){
			String pmid = keys.get(m.get("ReportID"));
			m.put("PMID",pmid);
		}
		
		// create new spreadsheet
		List<Map<String,String>> ndata = new ArrayList<Map<String,String>>();
		List<Map<String,String>> same = new ArrayList<Map<String,String>>();
		for(Map<String,String> m: data){
			// collapse reports to the same list
			if(same.isEmpty() || same.get(0).get("ReportID").equals(m.get("ReportID"))){
				same.add(m);
			}else{
				ndata.add(collapseReports(same));
				same.clear();
				same.add(m);
			}
		}
		return ndata;
	}
	

	
	
	/**
	 * collapse records
	 * @param same
	 * @return
	 */
	private static Map<String, String> collapseReports(List<Map<String, String>> same) {
		// predefined question types
		
	
		Map<String,String> nmap = new LinkedHashMap<String, String>();
		for(Map<String,String> m : same){
			if(nmap.isEmpty())
				nmap.putAll(m);
			else{
				String include = questions.get(3);
				nmap.put("User",nmap.get("User")+"|"+m.get("User"));
				for(List<String> list: Arrays.asList(questions,open_questions)){
					for(String key: list){
						// if not equal, collapse and mark as not consensus 
						if(!nmap.get(key).equals(m.get(key))){
							nmap.put(key,nmap.get(key)+"|"+m.get(key));
						}
					}
				}
				// do consensus
				String v1 = nmap.get(include);
				String v2 = m.get(include);
				String concensus = "disagreement";
				if(v1.equals(v2))
					concensus = "consensus";
				else if(v1.equals("U") || v2.equals("U"))
					concensus = "uncertain";
				
				
				nmap.put("Consensus",concensus);
			}
		}
		return nmap;
	}

	/**
	 * read in reference map
	 * @param in
	 * @return
	 * @throws Exception
	 */
	private static  Map<String,Map<String,String>> readReferenceMap(String in) throws Exception {
		String key = null,val,l;
		
		Map<String,String> ref = null;
		Map<String,Map<String,String>> references = new LinkedHashMap<String,Map<String,String>>();
		Set<String> fields = new TreeSet<String>();
		
		// read in all references
		File input = new File(in);
		BufferedReader r = new BufferedReader(new FileReader(input));
		while((l = r.readLine()) != null){
			if(l.length() == 0 ){
				// end of record
				if(ref != null){
					String pmid = ref.get("Accession Number");
					if(pmid != null)
						references.put(pmid,ref);
					ref = null;
				}
			}else{
				int i = l.indexOf(':');
				if(i > -1 && l.substring(0,i).matches("[A-Za-z ]+") && !l.substring(0,i).equals("http")){
					key = l.substring(0,i).trim();
					val = l.substring(i+1).trim();
					if(ref == null)
						ref = new LinkedHashMap<String, String>();
					ref.put(key,val);
					fields.add(key);
				}else if(ref != null && key != null && ref.containsKey(key)){
					ref.put(key,ref.get(key)+"\n"+l);
				}
			}
		}
		r.close();
		return references;
	}
	

	/**
	 * write reference file
	 * @param reference
	 * @param file
	 * @throws Exception
	 */
	private static void writeReference(Map<String, String> reference,Map<String, String> review, File file) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write("[Review]\n");
		writer.write("Users:\t"+review.get("User")+"\n");
		for(List<String> list: Arrays.asList(questions,open_questions)){
			for(String key: list){
				writer.write(key+":\t"+review.get(key)+"\n");
			}
		}
		writer.write("\n");
		writer.write("[PMID]\n"+get(reference,"Accession Number")+"\n\n");
		writer.write("[Title]\n"+get(reference,"Title")+"\n\n");
		writer.write("[Abstract]\n"+get(reference,"Abstract")+"\n\n");
		writer.write("[Keywords]\n"+get(reference,"Keywords")+"\n");
		writer.flush();
		writer.close();
	}

	private static String get(Map<String,String> map,String key){
		String val = map.get(key);
		return val !=null?val:"";
	}
	
	
	private static File getFile(File d, String consensus, String pmid){
		File dir = new File(d+"/OBP_"+consensus);
		if(!dir.exists())
			dir.mkdirs();
		return new File(dir,pmid+".txt");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File obpDir = new File("/home/tseytlin/Data/OBP/Consensus");
		String outputCSV = "OBP_giant_output.csv";
		String giantKey = "giant_keys.txt";
		String referenceFile = obpDir+"/../Frazier_OBP.txt";
		
		
		// read in data
		System.out.println("get keys ...");
		Map<String,String> keys = readKey(new File(obpDir,giantKey));
		System.out.println("read spreadsheet ...");
		List<Map<String,String>> spreadsheet = readSpreadsheet(new File(obpDir,outputCSV));
		
		// add PMID to each 
		System.out.println("collapse spreadsheet ...");
		List<Map<String,String>> nspreadsheet = collapseSpreadsheet(spreadsheet, keys);
		
		// write it out
		System.out.println("write spreadsheet ...");
		writeSpreadsheet(nspreadsheet,new File(obpDir,"output."+outputCSV));
		
		// read in the reference map
		Map<String,Map<String,String>> refMap = readReferenceMap(referenceFile);
		
		// write out references without concensus
		System.out.println("save disagreements ...");
		for(Map<String,String> map : nspreadsheet){
			String pmid = map.get("PMID");
			writeReference(refMap.get(pmid),map,getFile(obpDir,map.get("Consensus"),pmid));
		}
		
		System.out.println("done");
	}

}
