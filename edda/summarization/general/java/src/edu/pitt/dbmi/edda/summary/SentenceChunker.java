package edu.pitt.dbmi.edda.summary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import edu.pitt.text.tools.TextTools;

public class SentenceChunker {
	private static final List<String> exceptionList = new ArrayList<String>();
	// list of known exceptions where period is allowed 
	static {
		exceptionList.add(".*\\W(vs|Fig|al|etc)\\."); // vs. Fig. al.
		exceptionList.add(".*\\W[A-Z][a-z]?\\."); // A.B. Dr. Mr. etc... 
	}
	/*private static long totalTime;
	private static int n;*/
	
	private static boolean isException(String s){
		// check if this period is some known abreviation
		for(String ex: exceptionList)
			if(s.matches(ex))
				return true;
		return false;
	}

	
	/**
	 * Parse English sentences from a blurb of text. 
	 * Each sentence should be terminated by .! or ?
	 * Periods in digits and some acronyms should be skipped
	 * @param txt
	 * @return
	 */
	public static List<String> getSentences(String txt) {
		List<String> sentences =new ArrayList<String>();
		char [] tc = txt.toCharArray();
		//int st = 0;
		StringBuffer s = new StringBuffer();
		for(int i=0;i<txt.length();i++){
			// skip control characters and replace them with space
			if(tc[i] == '\n' || tc[i] == '\r')
				s.append(" ");
			else
				s.append(tc[i]);
			
			if(tc[i] == '.' || tc[i] == '!' || tc[i] == '?'){
				// get candidate sentence
				//String s = txt.substring(st,i+1);
				
				// check if this period is a decimal point
				if(i+1 < tc.length && Character.isDigit(tc[i+1]))
					continue;
				
				// check if the next character is not a whitespace
				// check if this period is a decimal point
				if(i+1 < tc.length && !Character.isWhitespace(tc[i+1]))
					continue;
				
				// check if this period is some known abreviation
				if(isException(s.toString()))
					continue;
				
				
				// save sentence
				sentences.add(s.toString());	
				
				// move start 
				//st = i+1;
				s = new StringBuffer();
			}
		}
		// mop up in case you don't have a period at the end
		//if(st<tc.length){
		//sentences.add(txt.substring(st)+".");
		if(s.toString().trim().length() >0){
			sentences.add(s.toString()+".");
		}
		
		return sentences;
	}
	/**
	 * @param args
	 *
	public static void main(String[] args) throws Exception {
		File inputData = new File("/home/tseytlin/Data/EDDA/GALACTOMANNAN/TextExcerpts (Human)");
		File outputData = new File("/home/tseytlin/Data/EDDA/GALACTOMANNAN/TextExcerpts (Sentences)");
		
		if(!outputData.exists())
			outputData.mkdir();
		
		File []  files = inputData.listFiles();
		Arrays.sort(files);
		for(File f : files){
			if(f.getName().endsWith(".txt")){
				String summary = TextTools.getText(new FileInputStream(f));
				File tmpFile = new File(outputData,f.getName());
				saveText(resentenceText(summary),tmpFile);
			}
		}
		System.out.println("sentence chunking average time "+totalTime/n);
	}
	
	private static String resentenceText(String summary) {
		StringBuffer b = new StringBuffer();
		long time = System.currentTimeMillis();
		List<String> sentences = SentenceChunker.getSentences(summary);
		totalTime += System.currentTimeMillis()-time;
		n++;
		for(String s: sentences){
			b.append(s+"\n\n");
		}
		return b.toString();
	}

	public static void saveText(String text, File out) throws FileNotFoundException,IOException {
		if(!out.getParentFile().exists())
			out.getParentFile().mkdirs();
		BufferedWriter w = new BufferedWriter(new FileWriter(out));
		w.write(text);
		w.close();
		
	
		
	}
	*/
	

}
