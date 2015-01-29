package edu.pitt.dbmi.edda.reference.token.filter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Tokenizer implements Filter {
	private final String [] patterns = new String [] {"[^a-zA-Z]+","[^a-zA-Z0-9\\-<>/%\\.]","[^a-zA-Z\\|]+"};
	private String s = " ";
	private JPanel panel;
	private JComboBox regexSelector;
	private String regex = patterns[0];
	
	public String getName() {
		return "Tokenizer";
	}

	public String toString(){
		return getName();
	}
	
	public String getDescription() {
		return "Break each input line into a set of tokens based on a specified regular expression. " +
				"The default is a \"nonletter\" expression that breaks input line into strings of alphabetic characters.";
	}

	public JComponent getPanel() {
		if(panel  == null){
			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
			p.add(new JLabel("<html><h2>"+getName()+"</h2><table width=300 bgcolor=\"#FFF380\"><tr><td>"+
			getDescription()+"</td></tr></table></html>"));
			
			JPanel p2 = new JPanel();
			p2.setBorder(new EmptyBorder(5,5,5,5));
			p2.setLayout(new GridBagLayout());
			// init constraints
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(5,5,5,5);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridy = 0;
			c.gridx = 0;
			c.anchor = GridBagConstraints.NORTH;
			
			
			regexSelector = new JComboBox(patterns);
			regexSelector.setEditable(true);
			p2.add(new JLabel("Tokenize by Expression"),c);c.gridy++;
			p2.add(regexSelector,c);
			p.add(p2);
			panel = p;
		}
		return panel;
	}

	public void setTokenSeparator(String s) {
		this.s = s;
		if(panel != null)
			regex = ""+regexSelector.getSelectedItem();

	}
	public String process(String str) {
		return str.replaceAll(regex,s);
	}

	public Properties save(){
		Properties p = new Properties();
		if(panel != null)
			p.setProperty("filter."+getClass().getSimpleName(),""+regexSelector.getSelectedItem());
		return p;
	}
	public void load(Properties p){
		String val = p.getProperty("filter."+getClass().getSimpleName());
		if(panel != null && val != null){
			regexSelector.setSelectedItem(val);
		}
	}
}
