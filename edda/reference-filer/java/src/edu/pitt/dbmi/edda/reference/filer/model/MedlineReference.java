package edu.pitt.dbmi.edda.reference.filer.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MedlineReference implements Reference {
	private String content;
	private Map<String,String> info;
	private List<String> keywords;
	private boolean included;
	
	public MedlineReference(String content){
		read(content);
	}
	
	public String getAuthors(){
		return info.containsKey("AU")?info.get("AU"):"";
	}
	
	public String getTitle(){
		return info.containsKey("TI")?info.get("TI"):"";
	}
	
	public String getAbstract(){
		return info.containsKey("AB")?info.get("AB"):"";
	}
	
	public String getPublication(){
		return info.containsKey("SO")?info.get("SO"):"";
	}
	
	public void setAbstract(String ab){
		info.put("AB",ab);
		content+="AB  - "+ab+"\n";
	}
	
	public List<String> getKeywords(){
		if(keywords == null){
			keywords = new ArrayList<String>(Utils.getKeywords(this));
		}
		return keywords;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Reference)
			return Utils.equals(this,(Reference)obj);
		return super.equals(obj);
	}
	
	/**
	 * get content map
	 * @return
	 */
	public Map<String,String> getContentMap(){
		return info;
	}
	
	/**
	 * read in end note reference content
	 * @param content
	 */
	public void read(String content){
		this.content = content;
		info = new LinkedHashMap<String,String>();
		
		// setup tags
		Pattern priPT = Pattern.compile("^([A-Z]{2})\\s+-\\s+(.*)$", Pattern.MULTILINE);
		//Pattern secPT = Pattern.compile("^([a-z]{2}\\s\\[[\\w\\s]+\\])[\\s\\.\\*]*(.*)$", Pattern.MULTILINE);
		
		// take care of primary tags
		Matcher priMatcher = priPT.matcher(content);
		int start = -1;
		while(priMatcher.find()){
			String key = priMatcher.group(1).trim();
			String val = priMatcher.group(2).trim();
			// special case for MH terms
			if("MH".equals(key)){
				start = priMatcher.start(2);
			}else if(start > -1){
				// we reached the next section after MH
				int end = priMatcher.start();
				info.put("MH",content.substring(start,end).trim());
			}
			info.put(key,val);
		}
		
		// take care of secondary tags
		/*
		Matcher secMatcher = secPT.matcher(content);
		while(secMatcher.find()){
			String key = secMatcher.group(1).trim();
			String val = secMatcher.group(2).trim();
			if(info.containsKey(key))
				val = info.get(key)+", "+val;
			info.put(key,val);
		}
		*/
	}
	
	public void write(File file, String format) {
		// by default write out entire reference as is
		String data = content;
		
		if("TI".equalsIgnoreCase(format)){
			data = "TI  -  "+getTitle()+"\n";
		}else if("TA".equalsIgnoreCase(format)){
			data = "TI  -  "+getTitle()+"\nAB  -  "+getAbstract()+"\n";
		}else if("FULL".equalsIgnoreCase(format)){
			data = data+"\nTI  -  "+getTitle()+"\n";
			// disable hard-coded weighting, should be handled by operators
		}else if(format.startsWith("[") && format.endsWith("]")){
			Pattern pt = Pattern.compile("([A-Z]+):(\\d)");
			Matcher mt = pt.matcher(format);
			data = "";
			while(mt.find()){
				String section = mt.group(1);
				int n = Integer.parseInt(mt.group(2));
				// iterate over each section
				for(int i=0;i<n;i++){
					if("FULL".equals(section)){
						data = data+ content+"\n";
					}else if("MH".equals(section)){
						for(String key: getKeywords()){
							data = data+ key+"\n"; 
						}
					}else{
						String cnt = getContentMap().get(section);
						if(cnt != null){
							data = data + cnt+"\n";
						}
					}
				}
			}
		}
		
		// write out files
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(data);
			writer.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	

	public String toString(){
		return getAuthors()+" - "+getTitle();
	}

	public boolean isIncluded() {
		return included;
	}

	public void setIncluded(boolean b) {
		included = b;
	}
}
