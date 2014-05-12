package edu.pitt.dbmi.edda.reference.token.filter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.util.InvalidFormatException;

import edu.pitt.text.tools.TextTools;
import gov.nih.nlm.nls.dtagger.Tag;
import gov.nih.nlm.nls.nlp.textfeatures.Document;
import gov.nih.nlm.nls.nlp.textfeatures.LexicalElement;
import gov.nih.nlm.nls.nlp.textfeatures.Section;
import gov.nih.nlm.nls.nlp.textfeatures.Sentence;
import gov.nih.nlm.nls.nlp.textfeatures.Token;
import gov.nih.nlm.nls.utils.GlobalBehavior;

public class POSTagger implements Filter {
	private final String [] TAGGERS = new String [] {"SPECIALIST POS Tagger","NLM dTagger","OpenNLP POS Tagger"};
	private final String TAG_SEPERATOR = "|";
	private String s = " ";
	private JPanel panel;
	private TextTools textTools;
	private JComboBox posMenu;
	private Tag dTagger;
	private opennlp.tools.postag.POSTagger posTagger;
	
	public String getName() {
		return "POS Tagger";
	}

	public String toString(){
		return getName();
	}
	
	public String getDescription() {
		return "Append POS tags to each word in a sentence";
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
			
			
			posMenu = new JComboBox(TAGGERS);
			//selectCase.setMaximumSize(new Dimension(500,20));
			p2.add(new JLabel("Select POS Tagger"),c);c.gridy++;
			p2.add(posMenu,c);
			p.add(p2);
			panel = p;
			
		}
		return panel;
	}

	public void setTokenSeparator(String s) {
		this.s = s;
	}
	
	public String process(String str) {
		int index = (posMenu != null)?posMenu.getSelectedIndex():0;
		switch(index){
		case 1: return processDTagger(str);
		case 2: return processOpenNLP(str);
		}
		return processSpecialist(str);
	}
	
	
	private String processOpenNLP(String str) {
		if(posTagger == null){
			try {
				posTagger = new POSTaggerME(new POSModel(getClass().getResource("/resources/en-pos-maxent.bin")));
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		StringBuffer buf = new StringBuffer();
		String [] words = str.split("\\s+");
		String [] tags  = posTagger.tag(words);
		for(int i=0;i<words.length;i++)
			buf.append(words[i]+TAG_SEPERATOR+tags[i]+s);
		return (buf.length()==0)?str:buf.toString();
	}

	private String processDTagger(String str) {
		StringBuffer buf = new StringBuffer();
		try{
			for(Sentence sen: getDSentences(str)){
				for(Object o3: sen.getLexicalElements()){
					for(Object o4: ((LexicalElement) o3).getTokens()){
						Token le = (Token) o4;
						buf.append(le.getOriginalString()+"|"+toPennTreePOSTag(le.getPOSTag())+s);
					}
				}
				
			}
		}catch(Exception ex){
			
		}
		return (buf.length()==0)?str:buf.toString();
	}

	private List<Sentence> getDSentences(String str) {
		if(dTagger == null){
			try {
				dTagger = new Tag(new GlobalBehavior("Tag","dtaggerRegistry.cfg"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<Sentence> list = new ArrayList<Sentence>();
		try{
			if(str.startsWith("AB ") || str.startsWith("TI ")){
				Document doc = new Document(new StringBuffer(str)); 
				dTagger.processDocument(doc);
				for(Object o1 : doc.getSections()){
					for(Object o2: ((Section) o1).getSentences()){
						list.add((Sentence)o2);
					}
				}
			}else{
				Sentence s = new Sentence(str,0,str.length());
				dTagger.processSentence(s);
				list.add(s);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}

	private String processSpecialist(String str){
		StringBuffer buf = new StringBuffer();
		try{
			for(Sentence sen: getSentences(str)){
				for(Object o3: sen.getLexicalElements()){
					for(Object o4: ((LexicalElement) o3).getTokens()){
						Token le = (Token) o4;
						buf.append(le.getOriginalString()+TAG_SEPERATOR+toPennTreePOSTag(le.getPOSTag())+s);
					}
				}
				
			}
		}catch(Exception ex){
			
		}
		return (buf.length()==0)?str:buf.toString();
	}
	
	
	/**
	 * get sentences
	 * @param str
	 * @return
	 */
	private List<Sentence> getSentences(String str){
		List<Sentence> list = new ArrayList<Sentence>();
		if(textTools == null)
			textTools = new TextTools();
		if(str.startsWith("AB ") || str.startsWith("TI ")){
			Document doc = textTools.parseDocument(str);
			for(Object o1 : doc.getSections()){
				for(Object o2: ((Section) o1).getSentences()){
					list.add((Sentence)o2);
				}
			}
		}else{
			list.add(textTools.parseSentence(str));
		}
		return list;
	}
	
	public Properties save(){
		Properties p = new Properties();
		if(panel != null)
			p.setProperty("filter."+getClass().getSimpleName(),""+posMenu.getSelectedItem());
		return p;
	}
	public void load(Properties p){
		String val = p.getProperty("filter."+getClass().getSimpleName());
		if(panel != null && val != null){
			posMenu.setSelectedItem(val);
		}
	}
	
	public static String toPennTreePOSTag( int aCat) { 
	    String     returnValue = null;
	    switch (aCat) {
	    case ADJECTIVE        : returnValue = "JJ" ;        break;
	    case ADVERB           : returnValue = "RB";            break;
	    case CONJUNCTION      : returnValue = "CC";       break;
	    case DETERMINER       : returnValue = "DT";        break;
	    case MODAL            : returnValue = "MD";             break;
	    case NOUN             : returnValue = "NN";              break;
	    case PREPOSITION      : returnValue = "IN";       break;
	    case PRONOUN          : returnValue = "PRP";           break;
	    case VERB             : returnValue = "VB";              break;
	    case NUMBER           : returnValue = "CD";            break;
	    case WORD_NUMBER      : returnValue = "NN";       break;
	    case TILDA            : returnValue = "SYM";             break;
	    case BANG             : returnValue = "SYM";              break;
	    case ATSIGN           : returnValue = "SYM";            break;
	    case POUNDSIGN        : returnValue = "SYM";         break;
	    case DOLLARSIGN       : returnValue = "SYM";        break;
	    case PERCENT          : returnValue = "SYM";           break;
	    case CARROT           : returnValue = "SYM";            break;
	    case ANDSIGN          : returnValue = "SYM";           break;
	    case ASTERISK         : returnValue = "SYM";          break;
	    case LEFTPAREN        : returnValue = "SYM";         break;
	    case RIGHTPAREN       : returnValue = "SYM";        break;
	    case DASH             : returnValue = "SYM";              break;
	    case EQUAL            : returnValue = "SYM";             break;
	    case UNDERBAR         : returnValue = "SYM";          break;
	    case PLUS             : returnValue = "SYM";              break;
	    case BACKQUOTE        : returnValue = "SYM";         break;
	    case LEFTCURLYBRACKET : returnValue = "SYM";  break;
	    case RIGHTCURLYBRACKET: returnValue = "SYM"; break;
	    case BAR              : returnValue = "SYM";               break;
	    case LEFTBRACKET      : returnValue = "SYM";       break;
	    case RIGHTBRACKET     : returnValue = "SYM";      break;
	    case BACKSLASH        : returnValue = "SYM";         break;
	    case COLON            : returnValue = "SYM";             break;
	    case DOUBLEQUOTE      : returnValue = "SYM";       break;
	    case SEMICOLON        : returnValue = "SYM";         break;
	    case SINGLEQUOTE      : returnValue = "SYM";       break;
	    case LESSTHAN         : returnValue = "SYM";          break;
	    case GREATERTHAN      : returnValue = "SYM";       break;
	    case QUESTIONMARK     : returnValue = "SYM";      break;
	    case COMMA            : returnValue = "SYM";             break;
	    case PERIOD           : returnValue = "SYM";            break;
	    case SLASH            : returnValue = "SYM";             break;
	    case TAB              : returnValue = "SYM";               break;
	    case PUNCTUATION      : returnValue = "SYM";       break;
	    case PROPER_NAME      : returnValue = "NNP";       break;
	    /*
	    case PREFIX           : returnValue = CATEGORY_PREFIX;            break;
	    case AUXILIARY        : returnValue = CATEGORY_AUXILIARY;         break;
	    case COMPLEMENTIZER   : returnValue = CATEGORY_COMPLEMENTIZER;    break;
	    
	    case SHAPE            : returnValue = CATEGORY_SHAPE;             break;
	    case UNKNOWN          : returnValue = CATEGORY_UNKNOWN;           break;
	    case UNTAGGED         : returnValue = CATEGORY_UNTAGGED;          break;
	    case NONE             : returnValue = CATEGORY_NONE;              break;

	    case MONEY            : returnValue = CATEGORY_MONEY;             break; 
	    case PHONE_NUMBER_USA : returnValue = CATEGORY_PHONE_NUMBER_USA;  break; 
	    case DATE             : returnValue = CATEGORY_DATE;              break; 
	    case URL              : returnValue = CATEGORY_URL;               break; 
	    case EMAIL_ADDRESS    : returnValue = CATEGORY_EMAIL_ADDRESS;     break;
	    case REAL_NUMBER      : returnValue = CATEGORY_REAL_NUMBER;       break;
	    case UNIT_OF_MEASURE  : returnValue = CATEGORY_UNIT_OF_MEASURE;   break;
	    case CHEMICAL         : returnValue = CATEGORY_CHEMICAL;          break;
	   
	    case ACRONYM          : returnValue = CATEGORY_ACRONYM;           break;
	    case LOCAL_ACRONYM    : returnValue = CATEGORY_LOCAL_ACRONYM;     break;
	    case PERCENT_NUMBER   : returnValue = CATEGORY_PERCENT_NUMBER;    break;
	    case FRACTION         : returnValue = CATEGORY_FRACTION;          break;
	    case RANGE            : returnValue = CATEGORY_RANGE;             break;
	  
	    case LEVEL_OF_SIGNIFICANCE: returnValue = CATEGORY_LEVEL_OF_SIGNIFICANCE; break;
	    case EXPERIMENT_SIZE  : returnValue = CATEGORY_EXPERIMENT_SIZE; break;
	      */
	    default: returnValue = "";
	    } 
	    return( returnValue );

	 }
	  public final static int         ADJECTIVE =  (0x1 <<  0)       ;  //  +--
	  public final static int            ADVERB =  (0x1 <<  1)       ;  // These numbers conform to
	  public final static int         AUXILIARY =  (0x1 <<  2)       ;  // the bit or'd numbers used 
	  public final static int    COMPLEMENTIZER =  (0x1 <<  3)       ;  // for the older lexical
	  public final static int       CONJUNCTION =  (0x1 <<  4)       ;  // lookup and lexical tools.
	  public final static int        DETERMINER =  (0x1 <<  5)       ;  //  |
	  public final static int             MODAL =  (0x1 <<  6)       ;  //  |
	  public final static int              NOUN =  (0x1 <<  7)       ;  //  |
	  public final static int       PREPOSITION =  (0x1 <<  8)       ;  //  |
	  public final static int           PRONOUN =  (0x1 <<  9)       ;  //  |
	  public final static int              VERB =  (0x1 << 10)       ;  //  +---
	  public final static int            NUMBER =  (0x1 << 11)       ;  //  +--- 
	  public final static int             TILDA =  (0x1 << 12)       ;  //  |
	  public final static int              BANG =  (0x1 << 13)       ;  //  |
	  public final static int            ATSIGN =  (0x1 << 14)       ;  //  | These numbers are 
	  public final static int         POUNDSIGN =  (0x1 << 15)       ;  //  | not tied to anything.
	  public final static int        DOLLARSIGN =  (0x1 << 16)       ;  //  |
	  public final static int           PERCENT =  (0x1 << 17)       ;  //  |
	  public final static int            CARROT =  (0x1 << 18)       ;  //  |
	  public final static int           ANDSIGN =  (0x1 << 19)       ;  //  |
	  public final static int          ASTERISK =  (0x1 << 20)       ;  //  |
	  public final static int         LEFTPAREN =  (0x1 << 21)       ;  //  |
	  public final static int        RIGHTPAREN =  (0x1 << 22)       ;  //  |
	  public final static int              DASH =  (0x1 << 23)       ;  //  |
	  public final static int             EQUAL =  (0x1 << 24)       ;  //  |
	  public final static int          UNDERBAR =  (0x1 << 25)       ;  //  |
	  public final static int              PLUS =  (0x1 << 26)       ;  //  |
	  public final static int         BACKQUOTE =  (0x1 << 27)       ;  //  |
	  public final static int  LEFTCURLYBRACKET =  (0x1 << 28)       ;  //  |
	  public final static int RIGHTCURLYBRACKET =  (0x1 << 29)       ;  //  |
	  public final static int               BAR =  (0x1 << 30)       ;  //  |
	  public final static int       LEFTBRACKET =  (0x1 << 31) + 1   ;  //  |            31
	  public final static int      RIGHTBRACKET =  (0x1 << 31) + 2   ;  //  |--------    32
	  public final static int         BACKSLASH =  (0x1 << 31) + 3   ;  //  |  33
	  public final static int             COLON =  (0x1 << 31) + 4   ;  //  |  34
	  public final static int       DOUBLEQUOTE =  (0x1 << 31) + 5   ;  //  |  35
	  public final static int         SEMICOLON =  (0x1 << 31) + 6   ;  //  |  36
	  public final static int       SINGLEQUOTE =  (0x1 << 31) + 7   ;  //  |  37
	  public final static int          LESSTHAN =  (0x1 << 31) + 8   ;  //  |  38
	  public final static int       GREATERTHAN =  (0x1 << 31) + 9   ;  //  |  39
	  public final static int      QUESTIONMARK =  (0x1 << 31) +10   ;  //  |  40
	  public final static int             COMMA =  (0x1 << 31) +11   ;  //  |  41
	  public final static int            PERIOD =  (0x1 << 31) +12   ;  //  |  42
	  public final static int             SLASH =  (0x1 << 31) +13   ;  //  |  43
	  public final static int               TAB =  (0x1 << 31) +14   ;  //  +------  44
	  public final static int       PUNCTUATION =  (0x1 << 31) +15   ;  //  Just in case we want it.
	  public final static int           UNKNOWN =  (0x1 << 31) +16   ;  // This is the bit or'd cat's.
	  public final static int          UNTAGGED =  (0x1 << 31) +17   ;  //      47 
	  public final static int            PREFIX =  (0x1 << 31) +18   ;  // The Xerox parc tagger tags
	  public final static int              NONE =  (0x1 << 31) +19   ;  //For Lan's variant generation compatability 
	  public final static int             SHAPE =  (0x1 << 31) +20   ;  //To have the Parser deal with this a shape

	  public static final int             MONEY = 60; 
	  public static final int  PHONE_NUMBER_USA = 61; 
	  public static final int              DATE = 62; 
	  public static final int               URL = 63;
	  public static final int     EMAIL_ADDRESS = 78; 
	  public static final int       REAL_NUMBER = 65; 
	  public static final int   UNIT_OF_MEASURE = 66; 
	  public static final int          CHEMICAL = 67; 
	  public static final int       PROPER_NAME = 68; 
	  public static final int           ACRONYM = 69; 
	  public static final int     LOCAL_ACRONYM = 70; 
	  public static final int    PERCENT_NUMBER = 71;
	  public static final int          FRACTION = 72;
	  public static final int             RANGE = 73;
	  public static final int              GLOB = 74;
	  public static final int          EQUATION = 75;
	  public static final int       WORD_NUMBER = 76;
	  public static final int LEVEL_OF_SIGNIFICANCE = 80;
	  public static final int   EXPERIMENT_SIZE = 79;
}
