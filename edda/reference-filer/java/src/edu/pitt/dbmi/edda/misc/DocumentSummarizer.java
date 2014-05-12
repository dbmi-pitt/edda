package edu.pitt.dbmi.edda.misc;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.text.tools.TextTools;

public class DocumentSummarizer {
	private static final int NGRAM = 4;
	private static final boolean MULTI_WORD_ONLY = true;
	private static final String S = "\t";
	private static final List<String> CHECK_TERMS = Arrays.asList("Animal","Human","Humans","Male","Female","Ancient","Medieval","* In Vitro (PT)","* Comp Study (PT)");
	
	/**
	 * rank NGRAM
	 * @throws Exception
	 */
	private static List<String> rankNGrams(Collection files,PrintWriter out, int cutoff) throws Exception {
		Pattern p1 = Pattern.compile("^Title:(.*?)^[A-Za-z ]+:",Pattern.DOTALL|Pattern.MULTILINE);
		Pattern p2 = Pattern.compile("^Abstract:(.*?)^[A-Za-z ]+:",Pattern.DOTALL|Pattern.MULTILINE);
		
		List<String> sentences = new ArrayList<String>();
		final Map<String,Integer> wordMap  = new HashMap<String,Integer>();
		for(Object o: files){
			File f = null;
			if(o instanceof File)
				f = (File) o;
			else
				f = new File(o.toString());
			
			//System.out.println("processing "+f.getName()+" ...");
			String text = TextTools.getText(new FileInputStream(f));
			Matcher m1 = p1.matcher(text);
			Matcher m2 = p2.matcher(text);
			String txt = "";
			if(m1.find()){
				txt += m1.group(1)+". ";
				sentences.add(m1.group(1).trim());
			}
			if(m2.find()){
				txt += m2.group(1);
				sentences.addAll(getSentences(m2.group(1).trim()));
			}
			
			for(String ngram: TextTools.getNGrams(txt,NGRAM)){
				String ng = TextTools.normalize(ngram);
				int n = (wordMap.containsKey(ng))?wordMap.get(ng):0;
				wordMap.put(ng,n+1);
			}
		}
		List<String> phrases = new ArrayList<String>(wordMap.keySet());
		Collections.sort(phrases,new Comparator<String>() {
			public int compare(String o1, String o2) {
				return wordMap.get(o2) - wordMap.get(o1);
			}
		});
		//System.out.println("-------------------------");
		//NGRAM_COUNT_THRESHOLD = files.size()/4;
		int max = 0,n=0,lastN=0;
		List<String> summary = new ArrayList<String>();
		for(String phrase: phrases){
			if(!MULTI_WORD_ONLY || phrase.contains(" ")){
				//if(NGRAM_COUNT_THRESHOLD == 0 || wordMap.get(phrase) > NGRAM_COUNT_THRESHOLD){
				if(cutoff <= 0 || (n < cutoff  || wordMap.get(phrase) == lastN)){
					//System.out.println(phrase+"\t"+wordMap.get(phrase));
					summary.add(phrase);
					if(phrase.length() > max)
						max = phrase.length();
					n++;
					lastN =wordMap.get(phrase);
				}
			}
		}
		
		// collapse terms
		/*for(ListIterator<String> it=summary.listIterator();it.hasNext();){
			String phrase = it.next();
			for(String ph: summary){
				if(ph.length() > phrase.length() && ph.contains(phrase)){
					it.remove();
					break;
				}
			}
		}*/
		
		// display collapsed terms
		for(String phrase: summary){
			out.println(wordMap.get(phrase)+S+phrase+pad(max-phrase.length())+S+pickSentence(lookupSentences(phrase,sentences)));
		}
		out.println("\n"+summary.size()+" ngrams with highest frequency out of "+files.size()+" documents");
		return summary;
	}
	
	private static String pad(int n) {
		StringBuffer s = new StringBuffer();
		for(int i=0;i<n;i++)
			s.append(" ");
		return s.toString();
	}

	private static String pickSentence(List<String> lookupSentences) {
		String sentence = null;
		for(String s: lookupSentences){
			if(sentence == null || s.length() < sentence.length())
				sentence = s;
		}
		return sentence;
	}

	/**
	 * find sentences containing an ngram
	 * @param phrase
	 * @param sentences
	 * @return
	 */
	private static List<String> lookupSentences(String phrase, List<String> sentences) {
		List<String> list = new ArrayList<String>();
		for(String s: sentences){
			boolean included = true;
			for(String w: TextTools.getWords(phrase)){
				if(!s.toLowerCase().contains(w)){
					included = false;
					break;
				}
			}
			if(included){
				list.add(s);
				if(list.size() > 10)
					break;
			}
		}
		
		return list;
	}

	private static List<String> getSentences(String txt) {
		List<String> sentences =new ArrayList<String>();
		Pattern pt = Pattern.compile("[A-Z].+?\\.[^\\d]");
		Matcher mt = pt.matcher(txt);
		while(mt.find()){
			sentences.add(mt.group());
		}
		return sentences;
	}

	/**
	 * expand keyword into a list that handles subheadings
	 * @param keyword
	 * @return
	 */
	private static List<String> expand(String keyword){
		List<String> list = new ArrayList<String>();
		// check subheadings
		String [] p = keyword.split("/");
		
		// add general term
		list.add(p[0].trim());
		
		// add 1st level subheadings
		if(p.length > 1){
			for(int i=1;i<p.length;i++){
				list.add(p[0].trim()+" /"+p[i].trim());
			}
		}
		
		// add the term itself
		if(p.length > 2){
			list.add(keyword.replaceAll("\\s*/\\s*"," /"));
		}
		
		return list;
	}
	
	/**
	 * keword histogram
	 * @throws Exception
	 */
	private static List<String> keywordHistogram(Collection files,PrintWriter out, int cutoff) throws Exception {
		List<String> indexingTerms = new ArrayList<String>();
		Pattern pt = Pattern.compile("^Keywords:(.*?)^[A-Za-z ]+:",Pattern.DOTALL|Pattern.MULTILINE);
	
		final Map<String,Integer> wordMap  = new HashMap<String,Integer>();
		for(Object o: files){
			File f = null;
			if(o instanceof File)
				f = (File) o;
			else
				f = new File(o.toString());
			
			//System.out.println("processing "+f.getName()+" ...");
			String text = TextTools.getText(new FileInputStream(f));
			Matcher mt = pt.matcher(text);
			if(mt.find()){
				String keywords = mt.group(1);
				for(String term: keywords.split("\n")){
					for(String keyword : expand(term.trim())){
						int n = (wordMap.containsKey(keyword))?wordMap.get(keyword):0;
						wordMap.put(keyword,n+1);
					}
				}
			}
		}
		List<String> phrases = new ArrayList<String>(wordMap.keySet());
		Collections.sort(phrases,new Comparator<String>() {
			public int compare(String o1, String o2) {
				return wordMap.get(o2) - wordMap.get(o1);
			}
		});
		//System.out.println("-------------------------");
		//KEYWORD_COUNT_THRESHOLD = (int)((files.size()*.02 > 2)?files.size()*.02:2);
		int x = 0, lastN = 0;
		for(String phrase: phrases){
			int n = wordMap.get(phrase);
			// while less then 100 or same count as 
			if(cutoff <= 0 || (x < cutoff || n == lastN)){
				out.println(n+S+phrase);
				indexingTerms.add(phrase);
				lastN = n;
			}else{
				break;
			}
			x++;
			/*if(n > KEYWORD_COUNT_THRESHOLD){
				out.println(n+S+phrase);
				x++;
			}*/
		}
		out.println("\n"+x+" indexing terms with high frequency out of "+files.size()+" documents");
		return indexingTerms;
	}
	
	
	/**
	 * 
	 * @param dir
	 * @return
	 */
	private static List<File> getReferenceFiles(File dir){
		List<File> files = new ArrayList<File>();
		for(File f: dir.listFiles(new FileFilter() {
			public boolean accept(File path) {
				return path.getName().endsWith(".txt");
			}
		})){
			files.add(f);
		}
		return files;
	}
	
	/**
	 * 
	 * @param dir
	 * @return
	 */
	private static List<File> getReferenceFilesFromCluster(File dir, int [] cluster){
		List<File> files = new ArrayList<File>();
		for(int n: cluster){
			files.add(new File(dir,String.format("REF%05d.txt",n)));
		}
		return files;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// directory 
		final int CUTOFF = 100;
		File dir = new File("/home/tseytlin/Data/OBP/OBP_References"); //_tokenized
		String clusterFile = "/home/tseytlin/Data/OBP/Clusters/10-Clusters/Obp Clustering Analysis.html";
		File outDir = new File("/home/tseytlin/Data/OBP/Clusters/10-Clusters-final");
		
		// read in cluster file
		DocumentClusterExplorer dce = new DocumentClusterExplorer(dir);
		
		//read in cluster file
		System.out.println("reading "+clusterFile+" ..");
		dce.readHTMLClusters(clusterFile);
		
		// write out sentences and documents
		dce.writeClusterSentences(outDir);
		PrintWriter out = null;
		
		// write out overall ngram/keyword summaries
		System.out.println("NGRAM summary for entire corpus ..");
		List<File> files = getReferenceFiles(dir);
		out = new PrintWriter(new FileWriter(new File(outDir,"Corpus-summary.ngram.txt")));
		List<String> ngrams = rankNGrams(files,out,10000);
		out.close();
		
		List<String> corpusNGRAMs = new ArrayList<String>();
		out = new PrintWriter(new FileWriter(new File(outDir,"Corpus-info.txt"),true));
		out.write("top five ngrams:\t");
		for(int i=0;i<5 && i<ngrams.size();i++){
			corpusNGRAMs.add(ngrams.get(i));
			out.write(ngrams.get(i)+((i<4)?", ":"\n"));
		}
		out.close();
		
		
		System.out.println("IndexTerm summary for entire corpus ..");
		out = new PrintWriter(new FileWriter(new File(outDir,"Corpus-summary.keywords.txt")));
		List<String> corpusKeywords = new ArrayList<String>();
		List<String> keywords = keywordHistogram(files,out,0);
		out = new PrintWriter(new FileWriter(new File(outDir,"Corpus-info.txt"),true));
		out.write("top MeSH index terms:\t");
		for(int i=0,n = 0;n<5 && i<keywords.size();i++){
			if(!CHECK_TERMS.contains(keywords.get(i))){
				corpusKeywords.add(keywords.get(i));
				out.write(keywords.get(i)+((n<4)?", ":"\n"));
				n++;
			}
		}
		out.close();
		
		
		// now lets summarize all clusters
		for(String cluster : dce.getClusterMap().keySet()){
			String name = cluster.replaceAll(" ","-");
			System.out.println("NGRAM summary for: "+name);
			out = new PrintWriter(new FileWriter(new File(outDir,name+"-summary.ngram.txt")));
			ngrams = rankNGrams(dce.getClusterMap().get(cluster),out,CUTOFF);
			out.close();
			
			// write out top five ngrams
			out = new PrintWriter(new FileWriter(new File(outDir,name+"-info.txt"),true));
			out.write("top five ngrams:\t");
			int n = 0;
			for(int i=0;(i<5 || n<5) && i<ngrams.size();i++){
				if(!corpusNGRAMs.contains(ngrams.get(i))){
					out.write(ngrams.get(i)+((n<4)?", ":"\n"));
					n++;
				}
			}
			out.close();
			
			System.out.println("IndexTerm summary for: "+name);
			out = new PrintWriter(new FileWriter(new File(outDir,name+"-summary.keywords.txt")));
			keywords = keywordHistogram(dce.getClusterMap().get(cluster),out,CUTOFF);
			out.close();
			
			out = new PrintWriter(new FileWriter(new File(outDir,name+"-info.txt"),true));
			out.write("top MeSH index terms:\t");
			n = 0;
			for(int i=0;(i<5 || n<5) && i<keywords.size();i++){
				boolean contains = false;
				for(String top: corpusKeywords){
					if(keywords.get(i).startsWith(top)){
						contains = true;
					}
				}
				if(!contains && !CHECK_TERMS.contains(keywords.get(i))){
					out.write(keywords.get(i)+((n<4)?", ":"\n"));
					n++;
				}
			}
			out.close();
		}

		
		// create HTML summary
		System.out.println("Creating HTML summary ..");
		HTMLClusterSummary html = new HTMLClusterSummary(dce);
		html.writeHTMLSummary(new File(outDir,"index.html"));
	}

}
