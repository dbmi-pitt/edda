package edu.pitt.dbmi.edda.summary;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import edu.pitt.dbmi.edda.summary.PDFTextConverter.TextSpan;
import edu.pitt.text.tools.TextTools;

public class InputTextCleaner {
	private static final String _TXT = ".txt";
	private static final String _PDF = ".pdf";
	private static class LineStats{
		public int length,upper,lower,special,spaces,periods,digits;
		public String fontLabel,fontSize;
	}
	private static Map<String,String []> fontMap;
	
	
	/**
	 * clean text from PDF
	 * @param summary
	 * @return
	 */
	private static String cleanText(String summary) {
		StringBuffer b = new StringBuffer();
		for(String l: summary.split("\n")){
			if(isClean(l))
				b.append(l+"\n");
		}
		return b.toString();
	}
	
	private static String postProcessText(String text){
		Pattern p1 = Pattern.compile("(.*\\b[A-Za-z]+)\\p{Pd}$");
		Pattern p2 = Pattern.compile("^([a-z]+)\\b(.*)");
		
		StringBuffer b = new StringBuffer();
		String [] l = text.split("\n");
		for(int i=0;i<l.length;i++){
			Matcher m1 = p1.matcher(l[i].trim());
			Matcher m2 = (i+1 < l.length)?p2.matcher(l[i+1].trim()):null;
			if(m1.matches() && m2 != null && m2.matches()){
				b.append(m1.group(1));
				b.append(m2.group(1)+"\n");
				l[i+1] = m2.group(2).trim();
				//b.append(m2.group(2).trim()+"\n");
			}else{
				b.append(l[i]+"\n");
			}
		}
		return b.toString();
	}
	
	
	/**
	 * check if line should be included
	 * @param l
	 * @return
	 *

	private static boolean isClean(String l) {
		LineStats s = getStats(l);
		if(s.length == 0){
			return false;
		}else if(((double)s.special)/s.lower > 0.5){
			return false;
		}else if(((double)s.spaces)/(s.lower+s.upper) > 0.5){
			return false;
		}else if(s.length > 47.5){
			return true;
		}else if(((double)s.upper)/s.length > 0.8 && s.length > 3){
			return true;
		}else if(s.lower < 18){
			return false;
		}else if(s.special > 7.5){
			return false;
		}else{
			return true;
		}
	}
	*/
	
	
	/**
	 * check if line should be included
	 * @param l
	 * @return
	 */

	private static boolean isClean(String l) {
		LineStats s = getStats(l);
		if(s.length == 0){
			return false;
		// get rid of all non common/normal text
		}else if(!("normal".equals(s.fontSize) && "common".equals(s.fontLabel))){
			return false;
		// all lines where there are more special chars then normal	
		}else if(((double)s.special)/s.lower > 0.5){
			return false;
		// more spaces that alphanum
		}else if(((double)s.spaces)/(s.lower+s.upper) > 0.5){
			return false;
		// get rid of all 	
		}else if(s.lower < 5){
			return false;
		}else if(s.special > 7.5){
			return false;
		}else{
			return true;
		}
	}
	

	/**
	 * clean text from PDF
	 * @param summary
	 * @return
	 */
	private static String statsText(String summary) {
		StringBuffer b = new StringBuffer();
		for(String l: summary.split("\n")){
			b.append(outputStats(l)+l+"\n");
		}
		return b.toString();
	}
	
	/**
	 * clean text from PDF
	 * @param summary
	 * @return
	 */
	private static String statsText(List<String> text,List<TextSpan> spans) {
		fontMap = new HashMap<String,String[]>();
		StringBuffer b = new StringBuffer();
		int n = 0;
		String [] last = new String [] {"common","normal"};
		for(String l: text){
			String st = outputStats(l);
			String [] fl = getFontLabel(l,spans,n);
			//if labels weren't picked right, get the previous label
			if(fl[0].length() == 0)
				fl = last;
			b.append(st+fl[0]+"\t"+fl[1]+"\t"+l+"\n");
			n+=l.replaceAll("\\W","").length();
			last = fl;
			fontMap.put(l,fl);
		}
		return b.toString();
	}
	
	/**
	 * get font label and size from the span
	 * @param l
	 * @param spans
	 * @param n
	 * @return
	 */
	private static String[] getFontLabel(String l, List<TextSpan> spans, int n) {
		String fontLabel = "";
		String fontSize = "";
		
		int x = 0;
		int overlap = 0;
		for(TextSpan t: spans){
			int xl = t.getText().replaceAll("\\W","").length();
			int nl = l.replaceAll("\\W","").length();
			if(xl == 0)
				continue;
			
			// if offset is within a span of T span, figure things out
			if(intersects(x,x+xl,n,n+nl)){
				int o = overlap(t.getText(),l);
				//if(similar(t.getText(),l)){
				if(o > overlap){
					fontLabel = t.getFontLabel();
					fontSize = t.getSizeLabel();
					overlap = o;
					//break;
				}
			}else if(fontLabel.length() > 0){
				break;
			}
			x += xl;
		}
		return new String [] {fontLabel,fontSize};
	}
	
	/*private static boolean similar(String a, String b){
		a = a.replaceAll("\\W","");
		b = b.replaceAll("\\W","");
		return a.contains(b) || b.contains(a);
	}*/

	
	/**
	 * get the size of logest common substring
	 * http://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Longest_common_substring
	 * @param first
	 * @param second
	 * @return
	 */
	public static int overlap(String first, String second) {
		// remove non-word characters
		first = first.replaceAll("\\W","");
		second = second.replaceAll("\\W","");
		
		if (first == null || second == null || first.length() == 0 || second.length() == 0) {
	        return 0;
	    }
	 
	    int maxLen = 0;
	    int fl = first.length();
	    int sl = second.length();
	    int[][] table = new int[fl+1][sl+1];
	 
	    for(int s=0; s <= sl; s++)
	      table[0][s] = 0;
	    for(int f=0; f <= fl; f++)
	      table[f][0] = 0;
	 
	 
	    for (int i = 1; i <= fl; i++) {
	        for (int j = 1; j <= sl; j++) {
	            if (first.charAt(i-1) == second.charAt(j-1)) {
	                if (i == 1 || j == 1) {
	                    table[i][j] = 1;
	                }
	                else {
	                    table[i][j] = table[i - 1][j - 1] + 1;
	                }
	                if (table[i][j] > maxLen) {
	                    maxLen = table[i][j];
	                }
	            }
	        }
	    }
	    return maxLen;
	}
	
	
	/**
	 * 
	 * @param a
	 * @param al
	 * @param b
	 * @param bl
	 * @return
	 */
	private static boolean intersects(int as,int ae, int bs, int be){
		return (as <= bs && bs <= ae) || (as <= be && be <= ae);  
	}
	
	/**
	 * get variest stats about this line
	 * @param l
	 * @return
	 */
	private static String outputStats(String l) {
		StringBuffer b = new StringBuffer();
		// add length of string
		b.append(l.length()+"\t");
		// add number of upper-case characters
		b.append(l.replaceAll("[^A-Z]+","").length()+"\t");
		// add number of lower-case characters
		b.append(l.replaceAll("[^a-z]+","").length()+"\t");
		// add number of digits
		b.append(l.replaceAll("[^0-9]+","").length()+"\t");
		// add number of non alphanum
		b.append(l.replaceAll("[\\w\\s]+","").length()+"\t");
		// add number of whitesapce
		b.append(l.replaceAll("[^\\s]+","").length()+"\t");
		// add number of periods
		b.append(l.replaceAll("[^\\.]+","").length()+"\t");
		return b.toString();
	}
	
	/**
	 * get variest stats about this line
	 * @param l
	 * @return
	 */
	private static LineStats getStats(String l) {
		LineStats s = new LineStats();
		s.length = l.length();
		s.upper = l.replaceAll("[^A-Z]+","").length();
		s.lower = l.replaceAll("[^a-z]+","").length();
		s.digits = l.replaceAll("[^0-9]+","").length();
		s.special = l.replaceAll("[\\w\\s]+","").length();
		s.spaces = l.replaceAll("[^\\s]+","").length();
		s.periods = l.replaceAll("[^\\.]+","").length();
		if(fontMap != null && fontMap.containsKey(l)){
			s.fontLabel = fontMap.get(l)[0];
			s.fontSize = fontMap.get(l)[1];
		}
			
		return s;
	}

	/**
	 * get files
	 * @param dir
	 * @param files
	 * @return
	 */
	private static List<File> getFiles(File f, List<File> files){
		if(f.isDirectory()){
			for(File c: f.listFiles()){
				getFiles(c, files);
			}
		}else if(f.isFile() && f.getName().endsWith(_PDF)){
			files.add(f);
		}
		return files;
	}
	
	private static String getMatchingFile(File file, File[] annotatedData) throws Exception{
		for(File f: annotatedData){
			if(f.getName().startsWith(file.getParentFile().getName())){
				return TextTools.getText(new FileInputStream(f));
			}
		}
		return "";
	}
		
	
	/**
	 * http://stackoverflow.com/questions/15042879/java-characters-alignment-algorithm
	 * @param text
	 * @param out
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	 public static List<String> align(String [] a, String [] b) {
			final String INC = "YES";
			final String EXC = "NO";
		 int[][] T = new int[a.length + 1][b.length + 1];

		for (int i = 0; i <= a.length; i++)
			T[i][0] = i;

		for (int i = 0; i <= b.length; i++)
			T[0][i] = i;

		for (int i = 1; i <= a.length; i++) {
			for (int j = 1; j <= b.length; j++) {
				if (a[i - 1].equals(b[j - 1]))
					T[i][j] = T[i - 1][j - 1];
				else
					T[i][j] = Math.min(T[i - 1][j], T[i][j - 1]) + 1;
			}
		}

		//StringBuilder aa  = new StringBuilder(), bb = new StringBuilder();
		List<String> buf = new ArrayList<String>();
		for (int i = a.length, j = b.length; i > 0 || j > 0;) {
			if (i > 0 && T[i][j] == T[i - 1][j] + 1) {
				buf.add(a[--i]+"\t"+EXC+"\n");
				//aa.append(a[--i]);
				//bb.append("-");
			} else if (j > 0 && T[i][j] == T[i][j - 1] + 1) {
				--j;
				//bb.append(b[--j]);
				//aa.append("-");
			} else if (i > 0 && j > 0 && T[i][j] == T[i - 1][j - 1]) {
				buf.add(a[--i]+"\t"+INC+"\n");
				--j;
				//aa.append(a[--i]);
				//bb.append(b[--j]);
			}
		}

		//return new String[] { aa.reverse().toString(), bb.reverse().toString() };
		Collections.reverse(buf);
		return buf;
	}
	

	public static void saveText(String text, File out) throws FileNotFoundException,IOException {
		if(text == null)
			return;
		if(!out.getParentFile().exists())
			out.getParentFile().mkdirs();
		BufferedWriter w = new BufferedWriter(new FileWriter(out));
		w.write(text);
		w.close();
	}
	

	private static String createFeatureSet(String text, List<TextSpan> spans, String gold_text) {
		String features = createFeatureSet(text,gold_text);
		StringBuffer b = new StringBuffer();
		int n = 0;
		String [] last = new String [] {"common","normal"};
		for(String line: features.split("\n")){
			String [] l = line.split("\\s+");
			String [] fl = getFontLabel(l[0].trim(),spans,n);
			//if labels weren't picked right, get the previous label
			if(fl[0].length() == 0)
				fl = last;
			b.append(l[0].trim()+"\t"+fl[0]+"\t"+fl[1]+"\t"+l[1].trim()+"\n");
			n+=l[0].replaceAll("\\W","").length();
			last = fl;
		}
		return b.toString();
	}
	
	
	private static String createFeatureSet(String summary, String gold_text) {
		//final String INC = "Include";
		//final String EXC = "Exclude";

		String[] input_tokens = summary.split("\\s+");
		String[] gold_tokens = gold_text.split("\\s+");

		/*
		 * StringBuffer b = new StringBuffer();
		 * 
		 * for(int i=0,j=0;i<input_tokens.length;i++){ String inclusion = EXC;
		 * String orig = input_tokens[i]; // if still have gold tokens if(j<
		 * gold_tokens.length){ String gold = gold_tokens[j]; // if simple match
		 * if(matches(orig,gold)){ inclusion = INC; j++; // if tokens ends with
		 * a hyphen in original }else if(orig.matches(".*\\p{Pd}") &&
		 * gold.startsWith(orig.substring(0,orig.length()-1))){ inclusion = INC;
		 * j++; // if next token matches and the other one is a substring of the
		 * first }else if(matchesNext(input_tokens,gold_tokens,i,j)){ inclusion
		 * = INC; j++; } } b.append(input_tokens[i]+"\t"+inclusion+"\n"); }
		 * return b.toString();
		 */
		StringBuilder b = new StringBuilder();
		for (String s : align(input_tokens, gold_tokens)) {
			b.append(s);
		}
		return b.toString();
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//File inputData = new File("/home/tseytlin/Data/EDDA/GALACTOMANNAN/43-PDFs-sent-to-Eugene/");
		File inputData = new File("/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/PDF-Data");
		//File inputData = new File("/home/tseytlin/Downloads/temp");
		//File [] annotatedData = new File("/home/tseytlin/Data/EDDA/GALACTOMANNAN/TextExcerpts (Human)").listFiles();
		for(File f : getFiles(inputData,new ArrayList<File>())){
			String fname = f.getName().substring(0,f.getName().length()-_TXT.length());
			System.out.print("converting "+fname+" ..  ");
			PDFTextConverter text = new PDFTextConverter(f);
			String ftext = text.getText();
			String stext = statsText(text.getTextLines(),text.getTextSpans());
			
			// save orig file
			System.out.print(" saving: .orig, ");
			saveText(ftext,new File(f.getParentFile(),fname+".orig"));
			
			// save stats file
			System.out.print("stats, ");
			saveText(stext,new File(f.getParentFile(),fname+".stats"));
			text.dispose();
			
			// save clean text
			System.out.print(".clean, ");
			saveText(postProcessText(cleanText(ftext)),new File(f.getParentFile(),fname+".clean"));
			
			// save CRF text
			//System.out.print(".crf");
			//saveText(createFeatureSet(ftext,text.getTextSpans(),getMatchingFile(f,annotatedData)),new File(f.getParentFile(),fname+".crf"));
			
			System.out.println(" .. done");
		}
	}

	
}
