package edu.pitt.dbmi.edda.term.discover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HTA_CreateKeywordTable {
	public static void main(String[] args) throws IOException {
		File infile = new File("/home/tseytlin/Data/HTA/HTA_records_2005-to-2014_CanadaPlusInternational_Interface_020615.txt");
		File outfile = new File("/home/tseytlin/Data/HTA/HTA_records_2005-to-2014_Keyword_Occurances_gt_3.csv");
		File dropfile = new File("/home/tseytlin/Data/HTA/HTA_records_2005-to-2014_Dropped_Keywords.txt");
		
		System.out.println("reading in "+infile.getName()+" ..");
		List<Map<String,String>> records = new ArrayList<Map<String,String>>();
		Set<String> keys = new LinkedHashSet<String>();
		Map<String,String> record = null;
		BufferedReader r = new BufferedReader(new FileReader(infile));
		for(String l=r.readLine();l != null;l = r.readLine()){
			if(l.matches("Record\\s+#\\d+")){
				if(record != null){
					records.add(record);
					keys.addAll(record.keySet());
				}
				record = new LinkedHashMap<String, String>();
			}else if(record != null){
				int x = l.indexOf(':');
				if(x > -1){
					String key = l.substring(0,x).trim();
					String val = l.substring(x+1).trim();
					record.put(key,val);
				}
			}
			
		}
		if(record != null){
			records.add(record);
			keys.addAll(record.keySet());
		
		}
		r.close();
		
		// now we have all of the records
		System.out.println("calculating requency counts ..");
		Map<String,Set<Integer>> keyMap = new HashMap<String,Set<Integer>>();
		Set<String> allKeywords = new TreeSet<String>();
		// go over all records
		int n = 1;
		for(Map<String,String> rec: records){
			String keywords = rec.get("KWO");
			if(keywords != null){
				for(String k: keywords.split(";")){
					k = k.trim();
					allKeywords.add(k);
					Set<Integer> rset = keyMap.get(k);
					if(rset == null){
						rset = new HashSet<Integer>();
						keyMap.put(k,rset);
					}
					rset.add(n);
				}
			}
			n++;
		}
		
		// lets remove keywords that are rather unique
		System.out.println("finding unique terms ..");
		Set<String> torem = new TreeSet<String>();
		for(String key: keyMap.keySet()){
			if(keyMap.get(key).size() < 3){
				torem.add(key);
			}
		}
		System.out.println("removing "+torem.size()+" unique terms ..");
		allKeywords.removeAll(torem);
		
		System.out.println("saving "+torem.size()+" unique terms ..");
		BufferedWriter w = new BufferedWriter(new FileWriter(dropfile));
		for(String key: torem){
			w.write(key+"\n");
		}
		w.close();
		
		System.out.println("saving results ..");
		w = new BufferedWriter(new FileWriter(outfile));
		w.write("ID,");
		for(String key: allKeywords){
			String fkey = key.replaceAll("\\W+","_");
			if(fkey.matches("\\d+.*"))
				fkey = "_"+fkey;
			w.write("\""+fkey+"\",");
		}
		w.write("\n");
		for(int i=1;i<records.size();i++){
			w.write(i+",");
			for(String key: allKeywords){
				int v = (keyMap.get(key).contains(i))?1:0;
				w.write(v+",");
			}
			w.write("\n");
		}
		w.close();
	}
}
