package edu.pitt.dbmi.edda.lens;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.nlp.noble.tools.TextTools;

public class DocumentSummarizer {
	private static final int NGRAM = 4;
	private static final boolean MULTI_WORD_ONLY = true;
	private static final String S = "\t";
	private static final List<String> CHECK_TERMS = Arrays.asList("Animal","Human","Humans","Male","Female","Ancient","Medieval","* In Vitro (PT)","* Comp Study (PT)");
	
	
	/**
	 * stats object representing frequency tables and such
	 * @author tseytlin
	 *
	 */
	private static class Stats {
		public Map<String,Double> wordMap = new HashMap<String,Double>();
		public List<String> sentences  = new ArrayList<String>(); 
		public Collection files = new ArrayList();
	}
	
	
	/**
	 * get frequency table for ngrams
	 * @param files
	 * @return
	 * @throws Exception
	 */
	private static Stats getNGramFrequencies(Collection files) throws Exception {
		Stats stat = new Stats();
		stat.files = files;
		for(Object o: files){
			File f = null;
			if(o instanceof File)
				f = (File) o;
			else
				f = new File(o.toString());
			
			StringBuffer txt = new StringBuffer();
			for(String s: DocumentClusterExplorer.getSentences(f)){
				stat.sentences.add(s);
				txt.append(s+"\n");
			}
			
			for(String ngram: TextTools.getNGrams(txt.toString(),NGRAM)){
				String ng = TextTools.normalize(ngram);
				double n = (stat.wordMap.containsKey(ng))?stat.wordMap.get(ng):0;
				stat.wordMap.put(ng,n+1);
			}
		}
		return stat;
	}
	
	/**
	 * calculate TF/IDF
	 * @param stat
	 * @param stats
	 * @return
	 */
	private static Stats getTfIdfMap(String name, Map<String,Stats> stats){
		Stats stat = new Stats();
		stat.files = stats.get(name).files;
		stat.sentences = stats.get(name).sentences;
		for(String word: stats.get(name).wordMap.keySet()){
			double tf = stats.get(name).wordMap.get(word);
			double nd = stats.size();
			double ndt = 0; // avoids devide/by 0, because at least 1 cluster will have the word
			// get number of clusters that contain this word
			for(Stats st: stats.values()){
				if(st.wordMap.containsKey(word))
					ndt++;
			}
			
			// now compute TF/IDF
			double tfidf = tf*Math.log(nd/ndt);
			stat.wordMap.put(word,tfidf);
		}
		
		return stat;
	}
	
	/**
	 * rank NGRAM
	 * @throws Exception
	 */
	private static List<String> rankNGrams(Stats stat,PrintWriter out, int cutoff) throws Exception {
		final Map<String,Double> wordMap  = stat.wordMap;
		
		// sort based on frequences  or TF/IDF
		List<String> phrases = new ArrayList<String>(wordMap.keySet());
		Collections.sort(phrases,new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (int)((1000*wordMap.get(o2)) - (1000*wordMap.get(o1)));
			}
		});
		
		// select summary ngrams based on cutoff criteria
		int max = 0,n=0;
		double lastN=0;
		List<String> summary = new ArrayList<String>();
		for(String phrase: phrases){
			if(!MULTI_WORD_ONLY || phrase.contains(" ")){
				double f = wordMap.get(phrase);
				if(cutoff <= 0 || (Math.round(f) > 0 && (n < cutoff  || f == lastN))){
					summary.add(phrase);
					if(phrase.length() > max)
						max = phrase.length();
					n++;
					lastN =f;
				}
			}
		}
		
		// display collapsed terms
		List<String> pickedSentences = new ArrayList<String>();
		for(String phrase: summary){
			String sentence = pickSentence(lookupSentences(phrase,stat.sentences),pickedSentences);
			pickedSentences.add(sentence);
			out.println(Math.round(wordMap.get(phrase))+S+phrase+pad(max-phrase.length())+S+sentence);
		}
		out.println("\n"+summary.size()+" ngrams with highest frequency out of "+stat.files.size()+" documents");
		return summary;
	}
	
	private static String pad(int n) {
		StringBuffer s = new StringBuffer();
		for(int i=0;i<n;i++)
			s.append(" ");
		return s.toString();
	}

	private static String pickSentence(List<String> lookupSentences, List<String> pickedSentences) {
		String sentence = null;
		for(String s: lookupSentences){
			if(!pickedSentences.contains(s) && (sentence == null || s.length() < sentence.length()))
				sentence = s;
		}
		if(sentence == null){
			for(String s: lookupSentences){
				if(sentence == null || s.length() < sentence.length())
					sentence = s;
			}
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
	 * create frequncy table
	 * @param files
	 * @return
	 * @throws Exception
	 */
	private static Stats getMeSHFrequenceis(Collection files) throws Exception {
		Stats stat = new Stats();
		stat.files = files;
		Pattern pt = Pattern.compile("^Keywords:(.*?)^[A-Za-z ]+:",Pattern.DOTALL|Pattern.MULTILINE);
		
		for(Object o: files){
			File f = null;
			if(o instanceof File)
				f = (File) o;
			else
				f = new File(o.toString());
			
			String text = TextTools.getText(new FileInputStream(f));
			Matcher mt = pt.matcher(text);
			if(mt.find()){
				String keywords = mt.group(1);
				for(String term: keywords.split("\n")){
					for(String keyword : expand(term.trim())){
						double n = (stat.wordMap.containsKey(keyword))?stat.wordMap.get(keyword):0;
						stat.wordMap.put(keyword,n+1);
					}
				}
			}
		}
		return stat;
	}
	
	
	/**
	 * keword histogram
	 * @throws Exception
	 */
	private static List<String> rankMeSHTerms(Stats stats,PrintWriter out, int cutoff) throws Exception {
		List<String> indexingTerms = new ArrayList<String>();
		final Map<String,Double> wordMap  = stats.wordMap;
	
		List<String> phrases = new ArrayList<String>(wordMap.keySet());
		Collections.sort(phrases,new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (int)((1000*wordMap.get(o2)) - (1000*wordMap.get(o1)));
			}
		});
		int x = 0;
		double lastN = 0;
		for(String phrase: phrases){
			double n = wordMap.get(phrase);
			// while less then 100 or same count as 
			if(cutoff <= 0 || (Math.round(n) > 0 && (x < cutoff || n == lastN))){
				out.println(Math.round(n)+S+phrase);
				indexingTerms.add(phrase);
				lastN = n;
			}else{
				break;
			}
			x++;
		}
		out.println("\n"+x+" indexing terms with high frequency out of "+stats.files.size()+" documents");
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
	 * does one string contains another w/out order 
	 * @param large
	 * @param small
	 * @return
	 */
	private static boolean contains(String large,String small){
		List<String> large_list = TextTools.getWords(large);
		List<String> small_list =TextTools.getWords(small);
		return large_list.containsAll(small_list);
	}
	
	/**
	 * return a list that filters out NGRams that occur in other Ngrams 
	 * @param ngrams
	 * @return
	 */
	private static List<String> collapseNGrams(List<String> ngrams){
		List<String> summary = new ArrayList<String>(ngrams);
		for(ListIterator<String> it=summary.listIterator();it.hasNext();){
			String phrase = it.next();
			for(String ph: summary){
				if(ph.length() > phrase.length() && contains(ph,phrase)){
					it.remove();
					break;
				}
			}
		}
		return summary;
	}
	
	private static boolean filteredNGram(String t) {
		Pattern pt = Pattern.compile("\\b(\\d+|\\d*\\.\\d+)\\b");
		Matcher mt = pt.matcher(t);
		return mt.find();
	}

	
	/**
	 * get top N ngrams, collapse some
	 * @param ngrams
	 * @param limit
	 * @return
	 */
	private static List<String> getTopNGrams(List<String> ngrams,int limit){
		//collapse some terms
		List<String> summary = collapseNGrams(ngrams.subList(0,limit*3));
		// now get top limit
		List<String> corpusNGRAMs = new ArrayList<String>();
		for(int i=0,n = 0;n<limit && i<summary.size();i++){
			if(!filteredNGram(summary.get(i))){
				corpusNGRAMs.add(summary.get(i));
			}
			n++;
		}
		return corpusNGRAMs;
	}
	

	/**
	 * get top N corpus MeSH terms not including the check terms
	 * @param keywords
	 * @param limit
	 * @return
	 */
	private static List<String> getTopMeSHTerms(List<String> keywords,List<String> filter,int limit){
		List<String> corpusKeywords = new ArrayList<String>();
		for(int i=0,n = 0;n<limit && i<keywords.size();i++){
			if(!filter.contains(keywords.get(i))){
				corpusKeywords.add(keywords.get(i));
				n++;
			}
		}
		return corpusKeywords;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// directory 
		final int CUTOFF = 100;
		File dir = new File("/home/tseytlin/Data/OBP/OBP_References"); //_tokenized
		String clusterFile = "/home/tseytlin/Data/OBP/Clusters/10-Clusters/Obp Clustering Analysis.html";
		//String clusterFile = "/home/tseytlin/Data/OBP/Clusters/analysis_12.html";
		File outDir = new File("/home/tseytlin/Data/OBP/Clusters/10-Clusters-Overall-Tweak");
		String title = "Prognostic Biomarker Studies of Oral Squamous Cell Carcinoma"; //OBP Dataset
		//String description = "OBP Dataset is a set of citations in the domain of Oral Squamous Cell Carcinoma.";
		String description = 
				"<p>The OBP dataset (n=498) is a subset of citations (N=1818) retrieved from MEDLINE®. \n" + 
				"The subset includes citations for studies about prognostic biomarkers of oral squamous cell carcinoma. </p> \n" + 
				"<p>\n" + 
				"To identify themes in the OBP dataset, we used a consensus clustering method implemented in R and developed by Wilkerson and Waltman " +
				"(<a href=\"http://www.bioconductor.org/packages/2.13/bioc/html/ConsensusClusterPlus.html\">described here</a>).  " +
				"The settings were: hierarchical clustering; (1-Pearson correlation) as the distance metric; 15 clusters (maximum); 50 subsamples; " +
				"each subsample consisted of 75% of the citations; all alphanumeric<sup>+</sup> features included (see Bekhuis et al, 2014, for a description of " +
				"the alphanumeric<sup>+</sup> feature set).\n" + 
				"</p>\n" + 
				"<h4>References</h4>\n" + 
				"<ol>\n" + 
				"<li>Bekhuis T, Tseytlin E, Mitchell K, Demner-Fushman D. (2014). Feature engineering and a proposed decision‑support system for systematic reviewers " +
				"of medical evidence. PLoS One, 9(1): e86277. doi: 10.1371/journal.pone.0086277.</li>\n"+
				"<li>Monti, S, Tamayo, P, Mesirov, J, Golub, T. (2003). Consensus clustering: a resampling-based method for class discovery " +
				"and visualization of gene expression microarray data. Machine Learning, 52, 91-118.</li>\n" + 
				"<li>Wilkerson, MD, Hayes, DN. (2010). ConsensusClusterPlus: a class discovery tool with confidence assessments and item tracking. " +
				"Bioinformatics, 26(12):1572-3.</li>\n" + 
				"</ol>";
		
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
		List<File> files = dce.getCorpusFiles(); //getReferenceFiles(dir);
		out = new PrintWriter(new FileWriter(new File(outDir,"Corpus-summary.ngram.txt")));
		List<String> ngrams = rankNGrams(getNGramFrequencies(files),out,10000);
		out.close();
		
		List<String> corpusNGRAMs = getTopNGrams(ngrams,5);
		out = new PrintWriter(new FileWriter(new File(outDir,"Corpus-info.txt"),true));
		out.write("top 5 n-grams:\t");
		for(int i=0;i<corpusNGRAMs.size();i++){
			out.write(corpusNGRAMs.get(i)+((i<corpusNGRAMs.size()-1)?"; ":"\n"));
		}
		out.close();
		
		
		System.out.println("IndexTerm summary for entire corpus ..");
		out = new PrintWriter(new FileWriter(new File(outDir,"Corpus-summary.keywords.txt")));
		
		List<String> keywords = rankMeSHTerms(getMeSHFrequenceis(files),out,0);
		List<String> corpusKeywords =getTopMeSHTerms(keywords,CHECK_TERMS,5);
		out = new PrintWriter(new FileWriter(new File(outDir,"Corpus-info.txt"),true));
		out.write("top 5 MeSH headings:\t");
		for(int i=0;i<corpusKeywords.size();i++){
			out.write(corpusKeywords.get(i)+((i<corpusKeywords.size()-1)?"; ":"\n"));
		}
		out.close();
		
		
		// count ngram frequencies first
		// now lets summarize all clusters
		Map<String,Stats> clusterNGramFrequencies = new LinkedHashMap<String, DocumentSummarizer.Stats>();
		Map<String,Stats> clusterMeSHFrequencies = new LinkedHashMap<String, DocumentSummarizer.Stats>();
		for(String cluster : dce.getClusterMap().keySet()){
			String name = cluster.replaceAll(" ","-");
			System.out.println("NGRAM frequency summary for: "+name);
			clusterNGramFrequencies.put(name,getNGramFrequencies(dce.getClusterMap().get(cluster)));
			System.out.println("MeSH frequency summary for: "+name);
			clusterMeSHFrequencies.put(name,getMeSHFrequenceis(dce.getClusterMap().get(cluster)));
		}
		
		// now lets summarize all clusters
		for(String cluster : dce.getClusterMap().keySet()){
			String name = cluster.replaceAll(" ","-");
			System.out.println("NGRAM summary for: "+name);
			out = new PrintWriter(new FileWriter(new File(outDir,name+"-summary.ngram.txt")));
			
			// get frequencies
			ngrams = rankNGrams(getTfIdfMap(name,clusterNGramFrequencies),out,CUTOFF);
			//ngrams = collapseNGrams(ngrams.subList(0,20));
			out.close();
			
			// write out top five ngrams
			out = new PrintWriter(new FileWriter(new File(outDir,name+"-info.txt"),true));
			out.write("top 5 n-grams:\t");
			int n = 0;
			for(int i=0;(i<5 || n<5) && i<ngrams.size();i++){
				//if(!corpusNGRAMs.contains(ngrams.get(i)) && !filteredNGram(ngrams.get(i))){
					out.write(ngrams.get(i)+((n<4)?"; ":"\n"));
					n++;
				//}
			}
			out.close();
			
			System.out.println("IndexTerm summary for: "+name);
			out = new PrintWriter(new FileWriter(new File(outDir,name+"-summary.keywords.txt")));
			keywords = rankMeSHTerms(getTfIdfMap(name,clusterMeSHFrequencies),out,CUTOFF);
			out.close();
			
			out = new PrintWriter(new FileWriter(new File(outDir,name+"-info.txt"),true));
			out.write("top 5 MeSH headings:\t");
			n = 0;
			for(int i=0;(i<5 || n<5) && i<keywords.size();i++){
				/*
				boolean contains = false;
				for(String top: corpusKeywords){
					if(keywords.get(i).startsWith(top)){
						contains = true;
					}
				}
				if(!contains && !CHECK_TERMS.contains(keywords.get(i))){
				*/
					out.write(keywords.get(i)+((n<4)?"; ":"\n"));
					n++;
				//}
			}
			out.close();
		}
		
		// extract Images through Open-I
		DocumentImageDownloader id = new DocumentImageDownloader(dce);
		id.writeImageClusters(outDir);

		
		// create HTML summary
		System.out.println("Creating HTML summary ..");
		HTMLClusterSummary html = new HTMLClusterSummary(dce);
		html.writeHTMLSummary(new File(outDir,"index.html"),title,description,false);
		html.writeHTMLSummary(new File(outDir,"index2.html"),title,description,true);
	}

}
