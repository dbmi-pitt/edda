package edu.pitt.dbmi.edda.reference.filer.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EndNoteReference implements Reference {
	private String content;
	private Map<String,String> info;
	private List<String> keywords;
	private boolean included;
	
	public EndNoteReference(String content){
		read(content);
	}
	
	public String getAuthors(){
		return info.containsKey("Author")?info.get("Author"):"";
	}
	
	public String getTitle(){
		return info.containsKey("Title")?info.get("Title"):"";
	}
	
	public String getAbstract(){
		return info.containsKey("Abstract")?info.get("Abstract"):"";
	}
	
	public String getRecordNumber(){
		return info.containsKey("Record Number")?info.get("Record Number"):null;
		
	}
	
	
	public String getPublication(){
		return info.containsKey("Journal")?info.get("Journal"):"";
	}
	
	public List<String> getKeywords(){
		if(keywords == null){
			keywords = new ArrayList<String>(Utils.getKeywords(this));
		}
		return keywords;
	}
	
	public String getFileAttachment(){
		String suf = "internal-pdf://";
		String f = info.containsKey("'File' Attachments")?info.get("'File' Attachments"):null;
		
		if(f != null && f.startsWith(suf)){
			f = f.substring(suf.length());
		}
		return f;
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
		Pattern priPT = Pattern.compile("^([A-Z'][A-Za-z' ]+):\\s(.*?)$", Pattern.MULTILINE|Pattern.DOTALL);
		
		// take care of primary tags
		Matcher priMatcher = priPT.matcher(content);
		String multilineField = null;
		int start = -1;
		while(priMatcher.find()){
			String key = priMatcher.group(1).trim();
			String val = priMatcher.group(2).trim();
			// special case for MH terms
			if(Arrays.asList("Keywords","Notes").contains(key)){
				start = priMatcher.start(2);
				multilineField = key;
			}else if(start > -1){
				// we reached the next section after MH
				int end = priMatcher.start();
				info.put(multilineField,content.substring(start,end).trim());
			}
			info.put(key,val);
		}
	}
	
	public void write(File file, String format) {
		// by default write out entire reference as is
		String data = content;
		
		if("TI".equalsIgnoreCase(format)){
			data = "Title: "+getTitle()+"\n";
		}else if("TA".equalsIgnoreCase(format)){
			data = "Title: "+getTitle()+"\nAbstract: "+getAbstract()+"\n";
		}else if("FULL".equalsIgnoreCase(format)){
			data = data+"\nTitle: "+getTitle()+"\n";
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
	public String getContent(){
		return content;
	}
	/**
	 * write out the reference in given format to a file
	 * @param file
	 * @param format
	 * @throws IOException 
	 */
	public void write(Writer writer) throws IOException{
		writer.write(content);
		writer.close();
	}
}
