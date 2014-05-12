package edu.pitt.dbmi.edda.misc;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.text.tools.TextTools;

public class DocumentClusterExplorer {
	private static boolean debug = false;
	private File referenceDirectory;
	private Map<String,Collection<String>> clusterMap;
	
	public DocumentClusterExplorer(File dir){
		referenceDirectory = dir;
	}
	
	
	/**
	 * get cluster map
	 * @return
	 */
	public Map<String,Collection<String>> getClusterMap(){
		if(clusterMap == null)
			clusterMap = new LinkedHashMap<String, Collection<String>>();
		return clusterMap;
	}
	
	/**
	 * add cluster of documents
	 * @param documents
	 */
	private String addCluster(Collection<String> documents) {
		String name = "cluster-"+(getClusterMap().size()+1);
		addCluster(name,documents);
		return name;
	}
	
	/**
	 * add cluster of documents
	 * @param documents
	 */
	private void addCluster(String name, Collection<String> documents) {
		getClusterMap().put(name,documents);
	}

	private class Ngram {
		public String ngram;
		public double score;
		public List<String> locations = new ArrayList<String>();
		public String toString(){
			return ngram+" "+score;
		}
	}
	
	/**
	 * analyze cluster
	 * @param name
	 */
	public void analyzeCluster(String name){
		if(getClusterMap().containsKey(name)){
			// extract trigrams from documents in a cluster
			Map<String,List<String>> documentMap = new HashMap<String, List<String>>();
			Collection<String> docs = getClusterMap().get(name);
			for(String doc : docs){
				try {
					String text = TextTools.getText(new FileInputStream(new File(doc)));
					documentMap.put(doc,Arrays.asList(TextTools.getNGrams(text,3)));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// find common trigram measure
			Map<String,Ngram> ngramMap = new HashMap<String, DocumentClusterExplorer.Ngram>();
			for(String doc: documentMap.keySet()){
				for(String ngram: documentMap.get(doc)){
					Ngram ng = ngramMap.get(ngram);
					if(ng == null){
						ng = new Ngram();
						ng.ngram = ngram;
					}
					//add location
					if(!ng.locations.contains(doc)){
						ng.locations.add(doc);
						//ng.score++;
					}
					// add score 
					ng.score++;
					
					// add ngram to a map
					ngramMap.put(ngram,ng);
				}
			}
			
			// filter out ngrams above given threshold
			List<Ngram> ngrams = new ArrayList<DocumentClusterExplorer.Ngram>();
			for(String ngram: ngramMap.keySet()){
				Ngram ng = ngramMap.get(ngram);
				if(ng.locations.size() >= documentMap.size()){
					ngrams.add(ng);
				}
			}
			Collections.sort(ngrams,new Comparator<Ngram>(){
				public int compare(Ngram o1, Ngram o2) {
					return (int)Math.round(o2.score - o1.score);
				}
				
			});
			
			// print 
			System.out.println(name);
			System.out.println("------- documents --------");
			for(String doc: documentMap.keySet()){
				System.out.println(doc);
			}
			System.out.println("-------- content -------");
			for(Ngram ng: ngrams){
				System.out.println(ng);
			}
			System.out.println("----------------");
			
		}
	}

	/**
	 * parse into sentences
	 * @param document
	 * @return
	 */
	public static List<String> getSentences(File f) throws Exception {
		List<String> sentences = new ArrayList<String>();
		if(!f.exists())
			return sentences;
		
		Pattern p1 = Pattern.compile("^Title:(.*?)^[A-Za-z ]+:",Pattern.DOTALL|Pattern.MULTILINE);
		Pattern p2 = Pattern.compile("^Abstract:(.*?)^[A-Za-z ]+:",Pattern.DOTALL|Pattern.MULTILINE);
		
		String text = TextTools.getText(new FileInputStream(f));
		Matcher m1 = p1.matcher(text);
		Matcher m2 = p2.matcher(text);
		if(m1.find()){
			sentences.add(m1.group(1).trim()+".");
		}
		if(m2.find()){
			sentences.addAll(getSentences(m2.group(1).trim()));
		}
		return sentences;
	}

	public static List<String> getSentences(String txt) {
		List<String> sentences =new ArrayList<String>();
		/*
		Pattern p1 = Pattern.compile("[A-Z/ ]{3,}+:?\\s+(.*)");
		Pattern pt = Pattern.compile("[A-Z].+?(\\.|\\?|!)[^\\d]");
		Matcher mt = pt.matcher(txt);
		StringBuffer prefix = new StringBuffer();
		while(mt.find()){
			String s = mt.group();
			Matcher m1 = p1.matcher(s);
			if(m1.matches())
				s = m1.group(1).trim();
			// rejoin sentences 
			if(s.matches(".* (vs.)")){
				prefix.append(s);
			}else{
				sentences.add(prefix+s);
				prefix = new StringBuffer();
			}
		}
		*/
		char [] tc = txt.toCharArray();
		int st = 0;
		for(int i=0;i<txt.length();i++){
			if(tc[i] == '.' || tc[i] == '!' || tc[i] == '?'){
				// get candidate sentence
				String s = txt.substring(st,i+1);
				
				// check if this period is a decimal point
				if(i+1 < tc.length && Character.isDigit(tc[i+1]))
					continue;
				
				// check if this period is some known abreviation
				if(s.matches(".* (vs)\\."))
					continue;
				
				// save sentence
				sentences.add(trimSentence(s));	
				
				// move start 
				st = i+1;
			}
		}
		// mop up in case you don't have a period at the end
		if(st<tc.length){
			sentences.add(trimSentence(txt.substring(st)+"."));
		}
		
		return sentences;
	}
	
	/**
	 * trim sentence
	 * @param s
	 * @return
	 */
	private static String trimSentence(String s) {
		//Pattern pt = Pattern.compile("([A-Z/ ]{4,}+:?)\\s+(.*)");
		Pattern pt = Pattern.compile("(([A-Z/\\(\\) ]{4,}+|Original Publication):?)\\s+(.*)");
		Matcher mt = pt.matcher(s);
		if(mt.matches()){
			if(debug)
				System.out.println("#HEADER#|"+mt.group(1).trim());
			s = mt.group(2);
		}
		return s.trim();
	}

	/**
	 * read CSV cluster file
	 * @param clusterFile
	 * @param dce
	 */
	public void readCSVClusters(String clusterFile) throws Exception {
		BufferedReader r = new BufferedReader(new FileReader(new File(clusterFile)));
		for(String l=r.readLine();l !=null; l = r.readLine()){
			String [] p = l.split(",");
			List<String> docs = new ArrayList<String>();
			for(int i=1;i<p.length;i++){
				docs.add(new File(referenceDirectory,p[i].trim()).getAbsolutePath());
			}
			addCluster(p[0].trim(),docs);
		}
		r.close();
	}
	
	/**
	 * read CSV cluster file
	 * @param clusterFile
	 * @param dce
	 */
	public void readHTMLClusters(String clusterFile) throws Exception {
		BufferedReader r = new BufferedReader(new FileReader(new File(clusterFile)));
		StringBuffer buffer = new StringBuffer();
		for(String l=r.readLine();l !=null; l = r.readLine()){
			buffer.append(l+"\n");
		}
		r.close();
		
		Pattern p = Pattern.compile("<h2>(.*?)</h2><p>(.*?)</p>");
		Matcher m = p.matcher(buffer.toString());
		while(m.find()){
			String name = m.group(1);
			String data = m.group(2);
			List<String> docs = new ArrayList<String>();
			for(String ref: data.split("(&nbsp;|\\s)")){
				ref = ref.replaceAll("<.*?>","").trim();
				if(ref.length() > 0){
					docs.add(new File(referenceDirectory,ref).getAbsolutePath());
				}
			}
			addCluster(name.trim(),docs);
		}
		
	}
	
	
	
	public void writeClusterSentences(File outputDir) throws Exception {
		// create cluster sentence files
		List<File> files = new ArrayList<File>();
		for(String cluster: getClusterMap().keySet()){
			String name = cluster.replaceAll(" ","-");
			File f = new File(outputDir,name+"-sentences.txt");
			if(!f.getParentFile().exists())
				f.getParentFile().mkdirs();
			File df = new File(outputDir,name+"-documents.txt");
			File hf = new File(outputDir,name+"-documents.html");
			BufferedWriter dw = new BufferedWriter(new FileWriter(df));
			BufferedWriter iw = new BufferedWriter(new FileWriter(new File(outputDir,name+"-info.txt")));
			BufferedWriter hdw = new BufferedWriter(new FileWriter(hf));
			hdw.write("<html><head></head><body>");
			System.out.println("saving "+f.getName()+" ..");
			BufferedWriter w = new BufferedWriter(new FileWriter(f));
			int n = 0;
			for(String document: getClusterMap().get(cluster)){
				File ff = new File(document);
				files.add(ff);
				//String path = ff.getAbsolutePath();
				String path = ff.getParentFile().getName()+"/"+ff.getName();
				dw.write(ff.getName()+"\n");
				hdw.write("<a href=\""+path+"\">"+ff.getName()+"</a>\n");
				for(String sentence: getSentences(new File(document))){
					w.write(sentence+"\n");
					n++;
				}
			}
			hdw.write("</body></html>");
			iw.write("number of documents:\t"+getClusterMap().get(cluster).size()+"\n");
			iw.write("number of sentences:\t"+n+"\n");
			w.close();
			dw.close();
			hdw.close();
			iw.close();
		}
		Collections.sort(files);
		BufferedWriter docs  = new BufferedWriter(new FileWriter(new File(outputDir,"Corpus-documents.html")));
		BufferedWriter sents = new BufferedWriter(new FileWriter(new File(outputDir,"Corpus-sentences.txt")));
		BufferedWriter info = new BufferedWriter(new FileWriter(new File(outputDir,"Corpus-info.txt")));
		docs.write("<html><head></head><body>");
		int n = 0;
		for(File f: files){
			String path = f.getParentFile().getName()+"/"+f.getName();
			docs.write("<a href=\""+path+"\">"+f.getName()+"</a>\n");
			for(String sentence: getSentences(f)){
				sents.write(sentence+"\n");
				n++;
			}
		}
		docs.write("</body></html>");
		info.write("number of documents:\t"+files.size()+"\n");
		info.write("number of sentences:\t"+n+"\n");
		docs.close();
		sents.close();
		info.close();
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String referenceDirectory = "/home/tseytlin/Data/OBP/OBP_References";
		//String clusterFile = "/home/tseytlin/Data/OBP/Clusters/edda_clusters.csv";
		String clusterFile = "/home/tseytlin/Data/OBP/Clusters/10-Clusters/Obp Clustering Analysis.html";
		String outputDir = "/home/tseytlin/Data/OBP/Clusters/10-Clusters";
		
		DocumentClusterExplorer dce = new DocumentClusterExplorer(new File(referenceDirectory));
		
		//read in cluster file
		System.out.println("reading "+clusterFile+" ..");
		//readCSVClusters(clusterFile);
		dce.readHTMLClusters(clusterFile);
		
		// create cluster sentence files
		dce.writeClusterSentences(new File(outputDir));
		
		
	/*	List<String> c1 = new ArrayList<String>();
		for(int i=0;i<10;i++){
			int n = (int)(Math.random()*1000)+1;
			c1.add(String.format("/home/tseytlin/Data/OBP/OBP_References_tokenized/REF%05d.txt",n));
		}
		System.out.println(c1);
		String cluster1 = dce.addCluster(c1);
		dce.analyzeCluster(cluster1);*/
	}

	

}
