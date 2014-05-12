package edu.pitt.dbmi.edda.reference.token.filter;

import java.util.Properties;

import javax.swing.JComponent;

public interface Filter {
	public String getName();
	public String getDescription();
	public JComponent getPanel();
	public void setTokenSeparator(String s);
	public String toString();
	public Properties save();
	public void load(Properties p);
	/**
	 * process string
	 * @param str
	 * @return
	 */
	public String process(String str);
}
