package edu.pitt.dbmi.edda.reference.token.filter;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import edu.pitt.dbmi.edda.reference.token.TextPreProcessor;

public class StopWordFilter implements Filter {
	private String s = " ";
	private JTextField wordList;
	private JPanel panel;
	
	// RapidMiner stop word list
	public static String[] STOP_WORDS = new String[] { "a", "abaft", "aboard", "about", "above", "across", "afore", "aforesaid", "after", "again", "against", "agin", "ago", "aint", "albeit", "all", "almost", "alone", "along", "alongside", "already", "also", "although", "always", "am", "american", "amid", "amidst", "among", "amongst", "an", "and", "anent",
		"another", "any", "anybody", "anyone", "anything", "are", "aren", "around", "as", "aslant", "astride", "at", "athwart", "away", "back", "bar", "barring", "be", "because", "been", "before", "behind", "being", "below", "beneath", "beside", "besides", "best", "better", "between", "betwixt", "beyond", "both", "but", "by", "can", "cannot", "certain",
		"circa", "close", "concerning", "considering", "cos", "could", "couldn", "couldst", "dare", "dared", "daren", "dares", "daring", "despite", "did", "didn", "different", "directly", "do", "does", "doesn", "doing", "done", "don", "dost", "doth", "down", "during", "durst", "each", "early", "either", "em", "english", "enough", "ere", "even", "ever",
		"every", "everybody", "everyone", "everything", "except", "excepting", "failing", "far", "few", "first", "five", "following", "for", "four", "from", "gonna", "gotta", "had", "hadn", "hard", "has", "hasn", "hast", "hath", "have", "haven", "having", "he", "her", "here", "hers", "herself", "high", "him", "himself", "his", "home", "how", "howbeit",
		"however", "id", "if", "ill", "immediately", "important", "in", "inside", "instantly", "into", "is", "isn", "it", "its", "itself", "ve", "just", "large", "last", "later", "least", "left", "less", "lest", "let", "like", "likewise", "little", "living", "long", "many", "may", "mayn", "me", "mid", "midst", "might", "mightn", "mine", "minus", "more",
		"most", "much", "must", "mustn", "my", "myself", "near", "neath", "need", "needed", "needing", "needn", "needs", "neither", "never", "nevertheless", "new", "next", "nigh", "nigher", "nighest", "nisi", "no", "one", "nobody", "none", "nor", "not", "nothing", "notwithstanding", "now", "er", "of", "off", "often", "on", "once", "oneself", "only",
		"onto", "open", "or", "other", "otherwise", "ought", "oughtn", "our", "ours", "ourselves", "out", "outside", "over", "own", "past", "pending", "per", "perhaps", "plus", "possible", "present", "probably", "provided", "providing", "public", "qua", "quite", "rather", "re", "real", "really", "respecting", "right", "round", "same", "sans", "save",
		"saving", "second", "several", "shall", "shalt", "shan", "she", "shed", "shell", "short", "should", "shouldn", "since", "six", "small", "so", "some", "somebody", "someone", "something", "sometimes", "soon", "special", "still", "such", "summat", "supposing", "sure", "than", "that", "the", "thee", "their", "theirs", "them", "themselves", "then",
		"there", "these", "they", "thine", "this", "tho", "those", "thou", "though", "three", "thro", "through", "throughout", "thru", "thyself", "till", "to", "today", "together", "too", "touching", "toward", "towards", "true", "twas", "tween", "twere", "twill", "twixt", "two", "twould", "under", "underneath", "unless", "unlike", "until", "unto", "up",
		"upon", "us", "used", "usually", "versus", "very", "via", "vice", "vis-a-vis", "wanna", "wanting", "was", "wasn", "way", "we", "well", "were", "weren", "wert", "what", "whatever", "when", "whencesoever", "whenever", "whereas", "where", "whether", "which", "whichever", "whichsoever", "while", "whilst", "who", "whoever", "whole", "whom", "whore",
		"whose", "whoso", "whosoever", "will", "with", "within", "without", "wont", "would", "wouldn", "wouldst", "ye", "yet", "you", "your", "yours", "yourself", "yourselves" };
	private Set<String> stopWords = new HashSet<String>(Arrays.asList(STOP_WORDS));
	
	
	public String getName() {
		return "Stop Word Filter";
	}

	public String getDescription() {
		return "Filters out common English stop words. The default stop word list is identical to the one used by RapidMiner TextProcessing plugin";
	}

	public JComponent getPanel() {
		if(panel == null){
			JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
			p.add(new JLabel("<html><h2>"+getName()+"</h2><table width=300 bgcolor=\"#FFF380\"><tr><td>"+
			getDescription()+"</td></tr></table></html>"));
			
			JPanel p2 = new JPanel();
			//p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
			p2.setBorder(new EmptyBorder(5,5,5,5));
			p2.setLayout(new GridBagLayout());
			// init constraints
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(1,1,1,1);
			c.fill = GridBagConstraints.NONE;
			c.gridy = 0;
			c.gridx = 0;
			c.anchor = GridBagConstraints.WEST;
			
			
			wordList = new JTextField(15);
			//wordList.setMaximumSize(new Dimension(500,20));
			p2.add(new JLabel("Custom Stop Word Filter"),c);c.gridy++;
			p2.add(wordList,c);c.gridy++;
			p2.add(TextPreProcessor.createBrowseButton(wordList),c);
			p.add(p2);		
			panel = p;
		}
		return panel;
	}

	public void setTokenSeparator(String s){
		this.s = s;
		// load stop word list from file
		if(wordList != null && wordList.getText().length() > 0){
			File f = new File(wordList.getText());
			if(f.exists())
				stopWords = new HashSet<String>(loadResource(new File(wordList.getText())));
		}
	}
	
	/**
	 * Read a list with this name and put its content into a list object
	 */	
	private static List<String> loadResource(File file){
		List<String> list = new ArrayList<String>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			for(String line = reader.readLine();line != null;line=reader.readLine()){
				list.add(line.trim());
			}
			reader.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		return list;
	}
	
	
	public String process(String line) {
		StringBuffer b = new StringBuffer();
		for(String word: line.split(s)){
			String sword = clean(word);
			if(!stopWords.contains(sword))
				b.append(word+s);
		}
		return b.toString();
	}

	private String clean(String word){
		if(word.contains("|")){
			return word.substring(0,word.indexOf('|'));
		}	
		return word;
	}
	
	public String toString(){
		return getName();
	}
	
	public Properties save(){
		Properties p = new Properties();
		if(panel != null)
			p.setProperty("filter."+getClass().getSimpleName(),""+wordList.getText());
		return p;
	}
	public void load(Properties p){
		String val = p.getProperty("filter."+getClass().getSimpleName());
		if(panel != null && val != null){
			wordList.setText(val);
		}
	}
	
}
