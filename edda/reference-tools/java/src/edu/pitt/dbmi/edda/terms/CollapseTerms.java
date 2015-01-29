package edu.pitt.dbmi.edda.terms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import edu.pitt.text.tools.TextTools;

public class CollapseTerms {
	private final String PREFIX= "[dt] ";
	private boolean DEBUG = true;
	private List<String> terms = new ArrayList<String>();
	private List<ExpressionTerm> expressions = new ArrayList<ExpressionTerm>();
	
	/**
	 * expression term
	 * @author tseytlin
	 */
	private class ExpressionTerm {
		public String expression;
		public List<String> relatedTerms;
		public String name;
		public ExpressionTerm(String e, List<String> related){
			expression = e;
			relatedTerms = related;
			name = (related != null && !related.isEmpty())?related.get(0):null;
		}
		public String toString(){
			return "/"+expression+"/";
		}
		public boolean matches(String s){
			return s != null?s.matches(expression):false;
		}
		public boolean matches(List<String> list){
			for(String s: list)
				if(!matches(s))
					return false;
			return true;
		}
	}
	
	
	public void load(File f) throws Exception{
		terms = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(f));
		for(String line = reader.readLine();line != null; line = reader.readLine()){
			//line = line.trim();
			//if(line.length() == 0)
			//	continue;
			// remove redundant spaces
			terms.add(clean(line));
		}
		reader.close();
		
		// optionally sort
		//Collections.sort(terms);
	}
	
	/**
	 * save output XML file
	 * @param f
	 * @throws Exception
	 */
	public void save(File f) throws Exception{
		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		writer.write("<?xml version=\"1.0\"?>\n");
		writer.write("<regexes>\n");
		for(ExpressionTerm e: expressions){
			writer.write("\t<regex>\n");
			writer.write("\t\t<name>"+PREFIX+TextTools.escapeHTML(e.name)+"</name>\n");
			writer.write("\t\t<value>"+TextTools.escapeHTML(e.expression)+"</value>\n");
			writer.write("\t</regex>\n");
		}
		writer.write("</regexes>\n");
		writer.close();
	}
	
	/**
	 * do the work
	 */
	public void process(){
		int spaces = 0;
		String last = null;
		List<String> related = new ArrayList<String>();
		//List<String> expressions = new ArrayList<String>();
		for(String s: terms){
			// if we have a blank space between  terms
			// it suggests grouping, so forget the last
			if(s.length() == 0){
				last = null;
				spaces ++;
			}else{
				if(last != null && isRelated(s,last)){
					related.add(s);
				}else{
					if(!related.isEmpty()){
						expressions.add(new ExpressionTerm(createExpression(related),related));
					}
					related = new ArrayList<String>();
					related.add(s);
					last = s;
				}
			}
			//System.out.println(s);
		}
		// add last
		if(!related.isEmpty())
			expressions.add(new ExpressionTerm(createExpression(related),related));
		
		//compact terms
		compact();
		
		debug("Total Terms: "+(terms.size()-spaces));
		debug("Expressiosn: "+expressions.size());
	}
	
	/**
	 * compact terms
	 */
	private void compact(){
		List<ExpressionTerm> torem = new ArrayList<ExpressionTerm>();
		for(ExpressionTerm expTerm: expressions){
			for(ExpressionTerm e: expressions){
				// if target expression matches all terms
				// of a different expression term, we can collapse
				if(!e.equals(expTerm) && expTerm.matches(e.relatedTerms)){
					debug("Collapsing "+e+" into "+expTerm);
					debug("\tsuper set: "+expTerm+" terms: "+expTerm.relatedTerms);
					debug("\tsub set:  "+e+" terms: "+e.relatedTerms);
					expTerm.relatedTerms.addAll(e.relatedTerms);
					torem.add(e);
				}
			}
		}
		expressions.removeAll(torem);
	}
	
	
	/**
	 * test those expressions on terms
	 */
	public void test(){
		for(String term: terms){
			if(term.length() == 0)
				continue;
			
			String matchedKey = null;
			for(ExpressionTerm expTerm: expressions){
				String exp = expTerm.expression;
				// match term to express, go ape-shit if didn't match
				if(term.matches(".*\\b"+exp+"\\b.*")){
					matchedKey = expTerm.name;
					break;
				}
			}
			if(matchedKey == null){
				System.err.println("Error: '"+term+"' didn't match any expression");
			}
			//else{
			//	System.out.println("'"+term+"' matched '"+matchedKey+"' in expresssion /"+expressions.get(matchedKey)+"/");
			//}
		}
		debug("Test Done!");
	}
	
	private void debug(Object o){
		if(DEBUG)
			System.out.println(o);
	}
	
	/**
	 * create regular expression from bunch of related terms
	 * @param related
	 * @return
	 */
	private String createExpression(List<String> related) {
		debug("\ninput: "+related);
		StringBuffer expr = new StringBuffer();
		String suf = null;
		
		// short cut for lists of one
		if(related.size() == 1){
			debug("output: "+related.get(0)+"\n");
			return related.get(0);
		}
		// build list of words
		List<String[]> words = new ArrayList<String[]>();
		int n = toWords(related, words);
		
		// go over each word
		for(int i=0;i<n;i++){
			boolean exEq = false, fzEq = false,optDash = false;
			Set<Set<String>> different = new LinkedHashSet<Set<String>>();
			Set<String> similar = new LinkedHashSet<String>();
			String word = null;
			for(int j=0;j<words.size();j++){
				//check bounds
				if(words.get(j).length <= i){
					System.err.println("SKIPPING WORD");
					continue;
				}
				// word check
				String w = words.get(j)[i];  
				
				// check dash at then end of the word
				int x = related.get(j).indexOf(w);
				int y = x+w.length();
				if(x > -1 && y < related.get(j).length() && related.get(j).charAt(y) == '-')
					optDash = true;
				
				if(word != null){
					//check  exact match
					exEq = word.equals(w);
					
					//check fuzzy match
					fzEq = TextTools.normalize(word, true,false,false).equals(TextTools.normalize(w,true,false,false));
					if(exEq || fzEq){
						// if fuzzy equal, then add to previous similarity list
						similar.add(w);
					}else{
						// else save previous list
						different.add(similar);
						// start new list with first word
						similar = new LinkedHashSet<String>();
						similar.add(w);
					}
				}else{
					// start new list
					similar.add(w);
				}
				word = w;
			}
			// add last set 
			different.add(similar);
			
			// append exact word
			suf = "\\s+";
			if(optDash){
				suf = "[ -]?";
			}
			expr.append(convert(different)+((i<n-1)?suf:""));
		}
		debug("output: "+expr.toString().trim()+"\n");
		return expr.toString().trim();
	}
	
	private String clean(String s) {
		//return s.replaceAll("[^\\p{Graph}]","").trim();
		return s.replaceAll("[^\\p{ASCII}]","").trim();
	}

	/**
	 * try to split into equal number of words all related terms
	 * @param related
	 * @param words
	 * @return
	 */
	private int toWords(List<String> related, List<String []> words){
		int n = 0;
		// first attempt using just spaces
		boolean firstAttemt = true;
		for(String s: related){
			String [] w = s.split("\\s+");
			words.add(w);
			if(n == 0)
				n = w.length;
			
			// n should be the same for everyone (will deal with concatanated words later)
			if(w.length != n){
				firstAttemt = false;
			}
		}
		if(firstAttemt)
			return n;
		
		n = 0;
		// second attempt
		words.clear();
		for(String s: related){
			String [] w = filter(s).split("[\\s-]+");
			words.add(w);
			if(n == 0)
				n = w.length;
			
			// n should be the same for everyone (will deal with concatanated words later)
			//if(w.length != n){
			//	firstAttemt = false;
			//}
		}
		
		return n;
		
	}
	
	
	/**
	 * convert special structure to expression
	 * @param list
	 * @return
	 */
	private String convert(Set<Set<String>> list){
		if(list.isEmpty())
			return "";
		
		// check for single identical or combined terms
		if(list.size() == 1){
			//check for identical term
			return combine(list.iterator().next());
		}else{
			StringBuffer buf = new StringBuffer();
			for(Set<String> terms : list ){
				String ct =combine(terms); 
				if(ct.length() > 0 && !buf.toString().contains(ct))
					buf.append(ct+"|");
			}
			// remove last pipe
			if(buf.toString().endsWith("|"))
				buf.deleteCharAt(buf.length()-1);
			return buf.toString().contains("|")?"("+buf+")":buf.toString();
		}
	}
	
	/**
	 * combine similar terms
	 * @param list
	 * @return
	 */
	private String combine(Set<String> list){
		// we got exact match, just return it
		if(list.size() == 1){
			String s = list.iterator().next();
			return unfilter(s);
		}else{
			String stem = stem(list);
			List<String> diffs = new ArrayList<String>();
			for(String s: list){
				// check difference between stem and word
				if(s.startsWith(stem)){
					diffs.add(s.substring(stem.length()));
				}
			}
			// two cases for diffs, optional vs either or
			StringBuffer sf = new StringBuffer();
			if(diffs.size() == 2 && diffs.get(0).length() == 0){
				// if there are two in list and first one is empty, then
				// second one is optional
				if(diffs.get(1).length() == 1)
					sf.append(diffs.get(1)+"?");
				else
					sf.append("("+diffs.get(1)+")?");
			}else{
				sf.append("(");
				boolean opt = false;
				for(String d : diffs ){
					if(d.length() > 0)
						sf.append(d+"|");
					else
						opt = true;
				}
				sf.deleteCharAt(sf.length()-1);
				sf.append(")");
				if(opt)
					sf.append("?");
			}
			return stem+sf;
		}
		//return ""+list;
	}
	
	/**
	 * combine similar terms
	 * @param list
	 * @return
	 */
	private String stem(Set<String> list){
		StringBuffer b = new StringBuffer();
		int n = Integer.MAX_VALUE;
		for(String s: list){
			if(n>s.length())
				n = s.length();
		}
		for(int i=0;i<n;i++){
			boolean match = false;
			char l = 0;
			for(String s: list){
				if(l == 0)
					l = s.charAt(i);
				else{
					match = l == s.charAt(i);
					if(!match)
						return b.toString();
				}
			}
			if(match)
				b.append(l);
		}
		return b.toString();
	}
	
	

	private String filter(String a){
		// some common helpers in dataset
		if(a.contains("non-"))
			a = a.replaceAll("non-","non");
		if(a.contains("pre-"))
			a = a.replaceAll("pre-","pre");
		if(a.contains("post-"))
			a = a.replaceAll("post-","post");
		if(a.matches(".*cross.over.*"))
			a = a.replaceAll("cross.over","crossover");
		if(a.contains("data base"))
			a = a.replaceAll("data base","database");
		return a;
	}
	
	private String unfilter(String a){
		// some common helpers in dataset
		if(a.equals("crossover") || a.equals("cross-over"))
			return "cross.?over";
		if(a.equals("database"))
			return "data.?base";
		return a;
	}
	
	private boolean isRelated(String a, String b) {
		// special case for non
		a = filter(a);
		b = filter(b);
		
		
		String a1 = TextTools.normalize(a, true,false,false);
		String b1 = TextTools.normalize(b, true,false,false);
		boolean result = a1.equals(b1);
		// check if there is one word difference
		if(!result){
			List<String> aw = TextTools.normalizeWords(a, true,false,false);
			List<String> bw = TextTools.normalizeWords(b, true,false,false);
			if(aw.size() == bw.size() && aw.size() > 1){
				// we can only tolerate a difference in one word
				int similarity = 0;
				for(int i=0;i<aw.size();i++){
					if(aw.get(i).equals(bw.get(i)))
						similarity ++;
				}
				if(similarity >= aw.size()-1)
					result = true;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		CollapseTerms cp = new CollapseTerms();
		cp.load(new File(args[0]));
		cp.process();
		cp.test();
		cp.save(new File(args[1]));
		
	}

}
