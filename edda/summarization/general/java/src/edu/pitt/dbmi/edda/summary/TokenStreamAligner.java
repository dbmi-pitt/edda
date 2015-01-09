package edu.pitt.dbmi.edda.summary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scala.Array;

public class TokenStreamAligner {

	private static String createFeatureSet(String summary, String gold_text) {
		final String INC = "Include";
		final String EXC = "Exclude";

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
	 * http://stackoverflow.com/questions/15042879/java-characters-alignment-
	 * algorithm
	 * 
	 * @param text
	 * @param out
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List<String> align(String[] a, String[] b) {
		final String INC = "Include";
		final String EXC = "Exclude";
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

		// StringBuilder aa = new StringBuilder(), bb = new StringBuilder();
		List<String> buf = new ArrayList<String>();
		for (int i = a.length, j = b.length; i > 0 || j > 0;) {
			if (i > 0 && T[i][j] == T[i - 1][j] + 1) {
				buf.add(a[--i] + "\t" + EXC + "\n");
				// aa.append(a[--i]);
				// bb.append("-");
			} else if (j > 0 && T[i][j] == T[i][j - 1] + 1) {
				--j;
				// bb.append(b[--j]);
				// aa.append("-");
			} else if (i > 0 && j > 0 && T[i][j] == T[i - 1][j - 1]) {
				buf.add(a[--i] + "\t" + INC + "\n");
				--j;
				// aa.append(a[--i]);
				// bb.append(b[--j]);
			}
		}

		// return new String[] { aa.reverse().toString(),
		// bb.reverse().toString() };
		Collections.reverse(buf);
		return buf;
	}

	public static List<String> getText(File f) throws Exception {
		List<String> lines = new ArrayList<String>();
		BufferedReader buf = new BufferedReader(new FileReader(f));
		try {
			for (String line = buf.readLine(); line != null; line = buf.readLine()) {
				lines.add(line.trim());
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			buf.close();
		}
		return lines;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String pdfStream = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/TokenStream/pdfboxStream.txt";
		String goldStream = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/TokenStream/coryStream.txt";
		String outStream = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/TokenStream/outputStream.tab";
		
		List<String> pdf_tokens = getText(new File(pdfStream));
		List<String> gold_tokens = getText(new File(goldStream));
		
		List<List<String>> pdf_tokens_by_doc = new ArrayList<List<String>>();
		List<List<String>> gold_tokens_by_doc = new ArrayList<List<String>>();
		List<String> list = null;
		for(String l: pdf_tokens){
			if("[Document]".equals(l)){
				list = new ArrayList<String>();
				if(list != null)
					pdf_tokens_by_doc.add(list);
			}else{
				list.add(l);
			}
		}
		if(list != null)
			pdf_tokens_by_doc.add(list);
		for(String l: gold_tokens){
			if("[Document]".equals(l)){
				list = new ArrayList<String>();
				if(list != null)
					gold_tokens_by_doc.add(list);
			}else{
				list.add(l);
			}
		}
		if(list != null)
			gold_tokens_by_doc.add(list);
		
		System.out.println("pdf documents "+pdf_tokens_by_doc.size());
		System.out.println("gold documents "+pdf_tokens_by_doc.size());
		//saveText(align(pdf_tokens.toArray(new String [0]),gold_tokens.toArray(new String [0])),new File(outStream));
		
		BufferedWriter w = new BufferedWriter(new FileWriter(new File(outStream)));
		for(int i=0;i<pdf_tokens_by_doc.size();i++){
			w.write("[Document]\n");
			for(String t: align(pdf_tokens_by_doc.get(i).toArray(new String [0]),gold_tokens_by_doc.get(i).toArray(new String [0]))){
				w.write(t);
			}
		}
		w.close();
		System.out.println("done");
		
		
	}

}
