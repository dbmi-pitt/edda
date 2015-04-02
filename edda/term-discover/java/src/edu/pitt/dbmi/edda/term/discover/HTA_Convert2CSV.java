package edu.pitt.dbmi.edda.term.discover;

import java.io.*;
import java.util.*;

public class HTA_Convert2CSV {
	public static void main(String[] args) throws IOException {
		File infile = new File("/home/tseytlin/Data/EDDA/HTA_records_2005-to-2014_CanadaPlusInternational_Interface_020615.txt");
		File outfile = new File("/home/tseytlin/Data/EDDA/HTA_records_2005-to-2014_CanadaPlusInternational_Interface_020615.csv");
		
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
		
		
		BufferedWriter w = new BufferedWriter(new FileWriter(outfile));
		for(String key: keys){
			w.write("\""+key+"\",");
		}
		w.write("\n");
		for(Map<String,String> rec: records){
			for(String key: keys){
				String val = rec.get(key);
				w.write("\""+(val != null?val:"")+"\",");
			}
			w.write("\n");
		}
		w.close();
	}

	private static void saveRecord(BufferedWriter w, Map<String, String> record) {
		
		
	}

}
