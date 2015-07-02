package edu.pitt.dbmi.edda.term.discover;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import edu.pitt.dbmi.nlp.noble.coder.model.Mention;
import edu.pitt.dbmi.nlp.noble.coder.model.Sentence;
import edu.pitt.dbmi.nlp.noble.terminology.Terminology;
import edu.pitt.dbmi.nlp.noble.terminology.impl.NobleCoderTerminology;
import edu.pitt.dbmi.nlp.noble.tools.TextTools;
import edu.pitt.dbmi.nlp.noble.util.PathHelper;


/**
 * identify overlap between StudyDesign candidate and existing terminology
 * @author tseytlin
 *
 */
public class StudyDesignOverlap {
	private Terminology term;
	private Map<String,String> exactMatch,generalMatch;
	private List<String> noMatch;
	private PathHelper pathHelper;
	
	public StudyDesignOverlap(Terminology t) {
		this.term = t;
	}
	public Map<String, String> getExactMatch() {
		if(exactMatch == null)
			exactMatch = new LinkedHashMap<String, String>();
		return exactMatch;
	}

	public Map<String, String> getGeneralMatch() {
		if(generalMatch == null)
			generalMatch = new LinkedHashMap<String, String>();
		return generalMatch;
	}

	public List<String> getNoMatch() {
		if(noMatch == null)
			noMatch = new ArrayList<String>();
		return noMatch;
	}
	
	
	/**
	 * find all possible study designs in a given file
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public void process(File file) throws Exception {
		BufferedReader r = new BufferedReader(new FileReader(file));
		for(String l=r.readLine();l!=null;l=r.readLine()){
			l = l.trim();
			if(l.length() > 0)
				process(l);
		}
		r.close();
	}
	/**
	 * process candidate
	 * @param l
	 */
	private void process(String line) throws Exception{
		// lookup line in terminolgoy
		Sentence s = term.process(new Sentence(line));
		// if no mentions found, then
		if(s.getMentions().isEmpty()){
			getNoMatch().add(line);
		// if we do have one or more candidates, lets make a determination
		}else {
			List<String> words = TextTools.normalizeWords(line,false,false,true);
			// get first mention
			Mention m = getBestMention(s);
			// if all words are covered, we have an exact match
			if(words.size()  == m.getAnnotations().size()){
				getExactMatch().put(line,m.getConcept().getName().trim());
			}else if (words.size() > m.getAnnotations().size()){
				getGeneralMatch().put(line,m.getConcept().getName().trim());
			}
			
		}
		
	}
	
	private PathHelper getPathHelper(){
		if(pathHelper == null)
			pathHelper = new PathHelper(term);
		return pathHelper;		
	}

	/**
	 * select best mention in  a sentence
	 * @param s
	 * @return
	 */
	private Mention getBestMention(Sentence s){
		if(s.getMentions().isEmpty())
			return null;
		if(s.getMentions().size() == 1)
			return s.getMentions().get(0);
		// else select either more specific, or just one
		Mention m = s.getMentions().get(0);
		for(Mention mm: s.getMentions()){
			if(!m.equals(mm)){
				if(getPathHelper().hasAncestor(mm.getConcept(),m.getConcept())){
					m = mm;
				}
			}
		}
		return m;
	}
	
	
	public static void main(String[] args) throws Exception{
		String terminology = "StudyDesigns";
		File file = new File("/home/tseytlin/Data/SD_Mining/data/candidates-7-1-2015/target/filtered_study_designs_HTA_keywords.txt");
		StudyDesignOverlap overlap = new StudyDesignOverlap(new NobleCoderTerminology(terminology));
		overlap.process(file);
		System.out.println("Exact Match ("+overlap.getExactMatch().size()+")");
		for(String term: overlap.getExactMatch().keySet()){
			System.out.println("\t"+term+" -> "+overlap.getExactMatch().get(term));
		}
		System.out.println("General Match ("+overlap.getGeneralMatch().size()+")");
		for(String term: overlap.getGeneralMatch().keySet()){
			System.out.println("\t"+term+" -> "+overlap.getGeneralMatch().get(term));
		}
		System.out.println("No Match ("+overlap.getNoMatch().size()+")");
		for(String term: overlap.getNoMatch()){
			System.out.println("\t"+term);
		}

	}
	
}
