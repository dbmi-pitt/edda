package edu.pitt.dbmi.edda.reference.filer.model;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public interface Reference {
	public String getAuthors();
	public String getTitle();
	public String getAbstract();
	public String getPublication();
	public List<String> getKeywords();
	public boolean isIncluded();
	public Map<String,String> getContentMap();
	public String getContent();
	public String getRecordNumber();
	public void setIncluded(boolean b);
	
	/**
	 * write out the reference in given format to a file
	 * @param file
	 * @param format
	 */
	public void write(File file, String format);
	
	/**
	 * write out the reference in given format to a file
	 * @param file
	 * @param format
	 */
	public void write(Writer writer) throws IOException;
}
