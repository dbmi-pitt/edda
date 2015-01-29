package edu.pitt.dbmi.edda.summary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dragon.ir.index.sentence.OnlineSentenceIndexer;
import dragon.ir.summarize.ClusterLexRankSummarizer;
import dragon.ir.summarize.LexRankSummarizer;
import dragon.nlp.extract.BasicTokenExtractor;
import dragon.nlp.extract.ConceptExtractor;
import dragon.nlp.tool.Lemmatiser;
import dragon.nlp.tool.PorterStemmer;
import dragon.onlinedb.ArrayCollectionReader;
import dragon.onlinedb.Article;
import dragon.onlinedb.BasicArticle;
import dragon.onlinedb.BasicCollectionReader;
import dragon.onlinedb.CollectionReader;
import dragon.onlinedb.SimpleArticleParser;
import dragon.onlinedb.SimpleCollectionReader;
import dragon.onlinedb.trec.SgmArticleParser;
import edu.pitt.text.tools.TextTools;

public class LexRank {
	private final String stopWords = "/home/tseytlin/Technologies/DragonToolkit/nlpdata/exp/umls.stopword";
	private ClusterLexRankSummarizer summarizer;
	private double similarityThreshold = 0.2;
	private boolean continousScore = true;
	private int numberOfClusters = 10;
	private int characterLimit = 1269;
	private int characterLimitExtra = 50;
	
	
	/**
	 * init lexrank
	 */
	public LexRank(){
		Lemmatiser lemmatiser = new PorterStemmer();
		ConceptExtractor extractor = new BasicTokenExtractor(lemmatiser,stopWords);
		OnlineSentenceIndexer indexer = new OnlineSentenceIndexer(extractor,false);
		summarizer = new ClusterLexRankSummarizer(indexer,numberOfClusters);
		summarizer.setContinuousScoreOpiton(continousScore);
		summarizer.setSimilarityThreshold(similarityThreshold);
	}
	
	/**
	 * get summary of the text file
	 * @param textFile
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public String getSummary(File textFile) throws FileNotFoundException, IOException{
		// read the content of the file and make sure it is not too short
		// if it is, just return its content
		String summary = TextTools.getText(new FileInputStream(textFile));
		if(summary.length() < (characterLimit+characterLimitExtra))
			return summary;
		
		
		// move text File to a directory where it is by itself
		File origDir = textFile.getParentFile();
		File tmp = new File(origDir,"tmp");
		if(!tmp.exists())
			tmp.mkdir();
		File tmpFile = new File(tmp,textFile.getName());
		//textFile.renameTo(tmpFile);
		saveText(resentenceText(summary),tmpFile);
		
		
		// pass this tmp dir to collection
		CollectionReader reader = new SimpleCollectionReader(tmp.getAbsolutePath());
		
		String text = summarizer.summarize(reader,characterLimit+characterLimitExtra);
		// reconstruct summary
		StringBuffer str = new StringBuffer();
		for(String s: TextTools.getSentences(text.replaceAll("[\\n\\r]+"," "))){
			if(s.endsWith("."))
				str.append(s.trim()+"\n");
		}
		
		// move file back
		//tmpFile.renameTo(textFile);
		tmpFile.delete();
		tmp.delete();
		
		// return result
		return str.toString();
	}
	
	
	private String resentenceText(String summary) {
		StringBuffer b = new StringBuffer();
		for(String s: SentenceChunker.getSentences(summary)){
			b.append(filterSentence(s)+"\n");
		}
		return b.toString();
	}

	private static String filterSentence(String s) {
		s = s.replaceAll("\n"," ").replaceAll("\\.","_").trim();
		if(s.endsWith("_"))
			s = s.substring(0,s.length()-1)+".";
		return s;
	}

	public static void saveText(String text, File out) throws FileNotFoundException,IOException {
		if(!out.getParentFile().exists())
			out.getParentFile().mkdirs();
		BufferedWriter w = new BufferedWriter(new FileWriter(out));
		w.write(text);
		w.close();
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		File inputData = new File("/home/tseytlin/Data/EDDA/GALACTOMANNAN/TextExcerpts (Human)");
		File outputData = new File("/home/tseytlin/Data/EDDA/GALACTOMANNAN/TextExcerpts (Summaries)");
		
		
		LexRank lexRank = new LexRank();
		File []  files = inputData.listFiles();
		Arrays.sort(files);
		for(File f : files){
			if(f.getName().endsWith(".txt")){
				System.out.print("SUMMARY of "+f.getName()+" .. "); 
				long time = System.currentTimeMillis();
				String summary = lexRank.getSummary(f);
				if(summary == null){
					System.out.println("(failed)");
				}else{
					System.out.print("\tchars: "+summary.length()+"\ttime: "+(System.currentTimeMillis()-time)+"\t\t..");
					saveText(summary,new File(outputData,f.getName()));
					System.out.println("(saved)");
				}
			}
		}
	}

}
