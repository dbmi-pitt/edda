package edu.pitt.dbmi.edda.reference.filer.model;

import java.io.File;
import java.util.List;

public interface Reference {
	public String getAuthors();
	public String getTitle();
	public String getAbstract();
	public String getPublication();
	public List<String> getKeywords();
	public boolean isIncluded();
	public void setIncluded(boolean b);
	
	/**
	 * write out the reference in given format to a file
	 * @param file
	 * @param format
	 */
	public void write(File file, String format);
}
