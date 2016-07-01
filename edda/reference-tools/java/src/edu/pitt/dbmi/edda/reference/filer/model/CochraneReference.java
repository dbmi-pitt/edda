package edu.pitt.dbmi.edda.reference.filer.model;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.*;


public class CochraneReference implements Reference {
	private String authors,publication,title;
	
	public CochraneReference(String content){
		read(content);
	}
	
	private void read(String content) {
		// strip header identifier
		String hdr = "{published data only}";
		int offs = content.indexOf(hdr);
		if(offs > -1){
			content = content.substring(offs+hdr.length()).trim();
		}else{
			// see if there is a regular useless prefix
			Pattern pt = Pattern.compile("[A-Z][A-Za-z]+[\\d]{4}[a-z]?\\s(.*)");
			Matcher mt = pt.matcher(content);
			if(mt.matches())
				content = mt.group(1);
		}
		
		// now parse it out
		try{
			int a = content.indexOf('.');
			int b = content.indexOf('.',a+1);
			authors = content.substring(0,a).trim();
			title   = content.substring(a+1,b).trim();
			publication = content.substring(b+1).trim();
		}catch(Exception ex){
			System.out.println(content);
			ex.printStackTrace();
		}
		
	}

	public boolean equals(Object obj){
		if(obj instanceof Reference)
			return Utils.equals(this,(Reference)obj);
		return super.equals(obj);
	}
	
	public String getAbstract() {
		return "";
	}

	public String getAuthors() {
		return authors;
	}

	public String getPublication() {
		return publication;
	}

	public String getTitle() {
		return title;
	}
	public void write(File file, String format) {
		//nothing

	}

	public String toString(){
		return getAuthors()+" - "+getTitle();
	}

	public boolean isIncluded() {
		return true;
	}

	public void setIncluded(boolean b) {
		
	}

	public List<String> getKeywords() {
		// TODO Auto-generated method stub
		return Collections.EMPTY_LIST;
	}

	public Map<String, String> getContentMap() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getContent(){
		return null;
	}
	/**
	 * write out the reference in given format to a file
	 * @param file
	 * @param format
	 * @throws IOException 
	 */
	public void write(Writer writer) throws IOException{
		
	}

	public String getRecordNumber() {
		// TODO Auto-generated method stub
		return null;
	}
}
