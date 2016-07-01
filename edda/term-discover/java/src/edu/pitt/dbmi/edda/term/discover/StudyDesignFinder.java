package edu.pitt.dbmi.edda.term.discover;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.nlp.noble.tools.TextTools;

/*import edu.pitt.text.tools.TextTools;
import gov.nih.nlm.nls.nlp.textfeatures.Phrase;
import gov.nih.nlm.nls.nlp.textfeatures.Sentence;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.*;
import opennlp.tools.postag.*;
*/
public class StudyDesignFinder {
	public static enum Mode {MSH,NCIT,HTA_TITLES};
	private Mode mode;
	//private Parser parser;
	private TextTools textTools;
	
	/**
	 * is a term a possible design
	 * @param term
	 * @return
	 */
	private boolean isPossibleDesign(String term) {
		term = term.toLowerCase();
		
		boolean isDesign = false;
		String seed = "(study|studies|designs?|trials?|assessments?|evaluations?|surveys?|questionnaires?|analys[ie]s|models?|modell?ing)";
		
		// if "Study Of ......"
		if(term.contains(" of "))
			isDesign = term.matches(seed+" of .*");
		
		// if "... Trial to"
		if(!isDesign && term.contains(" to"))
			isDesign = term.matches(".* "+seed+" to");
		
		// if "study, ...."
		if(!isDesign && term.contains(","))
			isDesign = term.matches(seed+", .*");
		
		// if ends with seed
		if(!isDesign)
			isDesign = term.matches(".*"+seed);
		
		// depending on the mode do some things differently do additional filtering
		if(isDesign){
			if(Mode.HTA_TITLES.equals(mode)){
				/*
				a. Drop terms that begin with numbers, e.g., 10th symposium health technology assessment.
				c. Drop terms with genes or proteins. E.g., drop d4z4 analysis.
				*/
				if(term.matches("\\d.*"))
					isDesign = false;
			}else if(Mode.NCIT.equals(mode) && isDesign){
				/*
				 * 	a. Delete terms where the seed is not the rightmost word, unless inverted.
				  	b. Delete terms with {of | for | or } inside the string, e.g., assessment of fetal attitude; 
				  		actual accrual for clinical trial; chamber hypertrophy or enlargement ecg assessment
					c. Delete all multi-word phrases that end in questionnaire, e.g., alzheimer's disease neuroimaging 
						initiative auditory verbal learning test questionnaire. However, keep the singleton term for questionnaire.
					d. Delete all multi-word phrases that end in survey, e.g., third national health and nutrition examination survey. 
						However, keep the singleton term for survey.
					e. Delete terms with words that include numbers, e.g., brca1 mutation analysis, or p16 immunohistochemical expression analysis. 
						However, keep terms such as phase 1 study .
					f. Delete terms with a colon (:) in the string, e.g., drug product: process validation and/or evaluation.
				 */
				if(term.matches(".* (of|for|or|to) .*"))
					isDesign = false;
				if(term.matches(".* (questionnaire|survey)"))
					isDesign = false;
				if(term.matches(".*[a-z]+[0-9]+[a-z]*.*"))
					isDesign = false;
				if(term.contains(":"))
					isDesign = false;
				
			}
		}
		
		return isDesign;
	}
	

	/**
	 * filter term based on varies heuristics
	 * @param np
	 * @return
	 */
	private String filter(String np) {
		np = np.trim();
			
		// the varies flavours of dashes will drive me nuts later, so let me normalize it
		np = np.replaceAll("\\p{Pd}","-");
		
		// now lets do filtering based on mode of operation
		if(Mode.HTA_TITLES.equals(mode)){
			/*
			  	b. Simplify terms with hyphens by dropping drugs or chemicals before the hyphen. 
				E.g. change cabazitaxel - benefit assessment ? benefit assessment. Caution: sometimes the words before a hyphen are meaningful, 
				as in cost-effective assessment, which we want to keep. In this file, maybe the terms to simplify have a space before 
				the hyphen and the terms to keep as is have a hyphen with no spaces.	Need to double check this. 
			 */
			if(np.contains(" - ")){
				int n = np.indexOf(" - ");
				np =  np.substring(n+3).trim();
			}
			
			/*
			d. Simplify terms with part (singular word) in them by deleting string before the hyphen. 
			E.g., outpatient cardiac rehabilitation part i- evaluation evaluation . However, want to keep as is terms like participation study.
			*/
			Matcher m = Pattern.compile("(?i).*\\bpart\\b.*\\-(.+)").matcher(np);
			if(m.matches()){
				np =  m.group(1).trim();
			}
		}else if(Mode.MSH.equals(mode)){
			/*
			a. Simplify terms by dropping forward slash (/) and any subsequent text to the right of the slash
			*/
			if(np.contains("/")){
				int n = np.indexOf("/");
				np = np.substring(0,n).trim();
			}
			
		}
		
		// replace junk
		if(np.startsWith("(") || np.startsWith("/") || np.startsWith("["))
			np = np.substring(1).trim();
		if(np.startsWith("-"))
			np = np.substring(1).trim();
		if(np.toLowerCase().startsWith("a "))
			np = np.substring(2);
		if(np.toLowerCase().startsWith("an "))
			np = np.substring(3);
		if(np.toLowerCase().startsWith("the "))
			np = np.substring(4);
		if(np.toLowerCase().endsWith(" to"))
			np = np.substring(0,np.length()-3);
		if(np.toLowerCase().contains(" - a "))
			np = np.substring(np.indexOf(" - a ")+5);
		
		return np.trim();
	}

	

	/**
	 * set mode
	 * @param b
	 */
	public void setMode(Mode b){
		mode = b;
	}
	
	public Mode getMode(){
		return mode;
	}
	
	private boolean isTerm(){
		return !mode.equals(Mode.HTA_TITLES);
	}
	
	/**
	 * find all possible study designs in a given file
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public List<String> find(File file) throws IOException {
		List<String> sentences = new ArrayList<String>();
		BufferedReader r = new BufferedReader(new FileReader(file));
		for(String l=r.readLine();l!=null;l=r.readLine()){
			l = l.trim();
			if(l.length() == 0)
				continue;
			if(l.startsWith("[") && l.endsWith("]"))
				l = l.substring(1,l.length()-1);
			if(!l.endsWith("."))
				l = l+".";
			sentences.add(l);
		}
		r.close();
		return find(sentences);
	}

	/**
	 * process list of sentences
	 * @param sentences
	 * @return
	 */
	
	public List<String> find(List<String> sentences) {
		List<String> designs = new ArrayList<String>();
		for(String sentence: sentences){
			//System.out.println(sentence);
			for(String np: getPhrases(sentence)){
				String term = filter(np);
				//System.out.println("\t"+np);
				if(isPossibleDesign(term)){
					designs.add(term);
				}
			}
		}
		return designs;
	}


	/**
	 * get phrases for a given sentence
	 * @param sentence
	 * @return
	 */
	private List<String> getPhrases(String sentence){
		// if input is an entire term then, just return it
		if(isTerm()){
			if(sentence.endsWith("."))
				sentence = sentence.substring(0,sentence.length()-1).trim();
			return Collections.singletonList(sentence);
		}
		
		// do sentence parsing
		List<String> list = new ArrayList<String>();
		//TODO: need noun-phrase parser
		/*
		Sentence s = getTextTool().parseSentence(sentence);
		for(Object o: s.getPhrases()){
			Phrase p = (Phrase) o;
			if(p.isNounPhrase()){
				list.add(p.getTrimmedString());
			}
		}
		*/
		return list;
	}
	
	/**
	 * create design counts by calculating a histogram
	 * @param designs
	 * @return
	 */
	public 	Map<String,Integer> getDesignCounts(List<String> designs){
		Map<String,Integer> designCounts = new TreeMap<String, Integer>();
		for(String s: designs){
			if(designCounts.containsKey(s))
				designCounts.put(s,designCounts.get(s)+1);
			else
				designCounts.put(s,1);
		}
		return designCounts;
	}

	/**
	 * get noun-phrases 
	 *
	public List<String> getNounPhrases(Parse p,List<String> nounPhrases) {
		if (p.getType().equals("NP")) { //NP=noun phrase
	        //remove a phrase that includes the new one
			for(ListIterator<String> it=nounPhrases.listIterator();it.hasNext();){
				if(it.next().contains(p.getCoveredText()))
					it.remove();
			}
			// add new one
			nounPhrases.add(p.getCoveredText());
	    }
	    for(Parse child : p.getChildren())
	         getNounPhrases(child,nounPhrases);
	    return nounPhrases;
	}
	*/
	
	public TextTools getTextTool(){
		if(textTools == null){
			textTools = new TextTools();
		}
		return textTools;
	}
	
	/*
	public Parser getParser(){
		if(parser == null){
			try {
			  ParserModel model = new ParserModel(getClass().getResource("/resources/en-parser-chunking.bin"));
			  parser = ParserFactory.create(model);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return parser;
		
	}
*/

	public static void main(String[] args) throws IOException {
		//File file = new File("/home/tseytlin/Data/HTA/possible_study_design_candidates_HTA_titles.txt");
		//File file = new File("/home/tseytlin/Data/HTA/possible_study_design_candidates_HTA_keywords.txt");
		File file = new File("/home/tseytlin/Data/HTA/possible_study_design_candidates_MSH.txt");
		//File file = new File("/home/tseytlin/Data/HTA/possible_study_design_candidates_NCIT.txt");
		
		StudyDesignFinder sd = new StudyDesignFinder();
		sd.setMode(Mode.MSH);
		
		// do sentence parsing 
		List<String> designs = sd.find(file);
		for(String s: new TreeSet<String>(designs)){
			System.out.println(s);
		}
	}

}
