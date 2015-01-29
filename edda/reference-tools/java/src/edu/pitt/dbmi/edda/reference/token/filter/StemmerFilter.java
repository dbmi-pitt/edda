package edu.pitt.dbmi.edda.reference.token.filter;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.pitt.text.tools.TextTools;
import edu.ucdenver.ccp.nlp.biolemmatizer.BioLemmatizer;
import edu.ucdenver.ccp.nlp.biolemmatizer.LemmataEntry;
import edu.ucdenver.ccp.nlp.biolemmatizer.LemmataEntry.Lemma;

public class StemmerFilter implements Filter {
	private final String LEXICON_FILE = "/resources/lexicon.lex";
	private final String [] STEMMERS = new String [] {"Porter","BioLemmatizer"};
	private String s = " ";
	private JPanel panel;
	private JComboBox stemmerMenu;
	private BioLemmatizer bio;
	
	public String getName() {
		return "Stemmer Filter";
	}
	public String toString(){
		return getName();
	}

	public String getDescription() {
		return "Stem each token using Porter stemmer";
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
			
			
			stemmerMenu = new JComboBox(STEMMERS);
			//selectCase.setMaximumSize(new Dimension(500,20));
			p2.add(new JLabel("Select Stemmer"),c);c.gridy++;
			p2.add(stemmerMenu,c);
			p.add(p2);
			panel = p;
			
		}
		return panel;
	}

	public void setTokenSeparator(String s) {
		this.s = s;
	}

	public String process(String line) {
		StringBuffer ln = new StringBuffer();
		for(String word: line.split(s)){
			if(word.length() > 0)
				ln.append(stem(word)+s);
		}
		return ln.toString();
	}

	/**
	 * stem word
	 * @param word
	 * @return
	 */
	private String stem(String word){
		int index = (stemmerMenu != null)?stemmerMenu.getSelectedIndex():0;
		switch(index){
		case 1: return stemBioLem(word);
		}
		return TextTools.stem(word);
	}
	

	private String stemBioLem(String word) {
		if(bio == null){
			File f = null;
			try {
				URL u = getClass().getResource(LEXICON_FILE);
				if(u != null)
					f = new File(u.toURI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			if(f != null && f.exists())
				bio = new BioLemmatizer(f);
			else
				bio = new BioLemmatizer();
		}
		String pos = null;
		if(word.contains("|")){
			pos = word.substring(word.indexOf('|')+1).toUpperCase();
			word = word.substring(0,word.indexOf('|'));
		}	
		LemmataEntry lem = bio.lemmatizeByLexiconAndRules(word,pos);
		String sword =  lem.getLemmas().iterator().next().getLemma();
		// looks like BioLem, may make some words upper case
		if(!hasUpper(word))
			sword = sword.toLowerCase();
		else if(!hasLower(word))
			sword = sword.toUpperCase();
		return sword;
	}
	
	private boolean hasUpper(String s){
		for (char c : s.toCharArray()) {
		    if (Character.isUpperCase(c)) {
		        return true;
		    }
		}
		return false;
	}
	
	private boolean hasLower(String s){
		for (char c : s.toCharArray()) {
		    if (Character.isLowerCase(c)) {
		        return true;
		    }
		}
		return false;
	}
	
	
	public Properties save(){
		Properties p = new Properties();
		if(panel != null)
			p.setProperty("filter."+getClass().getSimpleName(),""+stemmerMenu.getSelectedItem());
		return p;
	}
	public void load(Properties p){
		String val = p.getProperty("filter."+getClass().getSimpleName());
		if(panel != null && val != null){
			stemmerMenu.setSelectedItem(val);
		}
	}
}
