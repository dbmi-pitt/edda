package edu.pitt.dbmi.edda.misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class HTMLClusterSummary {
	private DocumentClusterExplorer clusters;
	public HTMLClusterSummary(DocumentClusterExplorer cl){
		clusters = cl;
	}
	
	public void writeHTMLSummary(File out) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		writer.write("<html>\n" + 
				"<head>\n" + 
				"<title>Cluster Summary</title>\n" + 
				"	<style type=\"text/css\">\n" + 
				"	.main {\n" + 
				"		width: 100%; \n" + 
				"		height: 100%;\n" + 
				"	}\n" + 
				"	.header {\n" + 
				"		font-size: 26pt; \n" + 
				"		font-weight: bold;\n" + 
				"		text-align: center;\n" + 
				"		position: relative;\n" + 
				"	}\n" + 
				"	.clusters {\n" + 
				"		position: relative;\n" + 
				"		float: left;\n" + 
				"		border: 3px solid #000;\n" + 
				"		width: 20%;\n" + 
				"		height: 85%;\n" + 
				"		overflow: auto;\n"+
				"	}\n" + 
				"	.cluster {\n" + 
				"		width: 80%;\n" + 
				"		padding-left: 10px;\n" + 
				"		margin: 10px 10px 10px 10px;\n" + 
				"		border: 3px solid #00f;\n" + 
				"	}\n" + 
				"	.preview {\n" + 
				"		position: relative;\n" + 
				"		float: right;\n" + 
				"		width: 75%;\n" + 
				"		height: 85%;\n" + 
				"		right: 3%;\n" + 
				"	}\n" + 
				"	.info {\n" + 
				"		vertical-align: top;\n" +
				"		width: 100%; \n" + 
				"		height: 30%;\n" + 
				"		overflow: auto;" + 
				"	}\n" + 
				"	.frame {\n" + 
				"		vertical-align: bottom;\n" + 
				"		border-style: solid;\n" + 
				"		width: 100%; \n" + 
				"		height: 70%" + 
				"	}\n" + 
				"	</style>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<script type=\"text/javascript\">\n" + 
				"	function info(cluster,type){\n" + 
				"		var text = \"<h2>\"+cluster+\"</h2><hr>\";\n" + 
				"		if('info' == type){\n" + 
				"			text += \"<b>Information</b><p>\";\n" + 
				"			text += \"Overall cluster information : number of documents, number of sentences, description sentence etc..\"; \n" + 
				"			text += \"</p>\";\n" + 
				"		}else if('docs' == type){\n" + 
				"			text += \"<b>Documents</b><p>\";\n" + 
				"			text += \"Documents that were grouped together to form this cluster. \"; \n" + 
				"			text += \"You can click on individual document to view it. \";\n" + 
				"			text += \"Use browser back button to return to document listing. \";\n" + 
				"			text += \"</p>\";\n" + 
				"		}else if('sents' == type){\n" + 
				"			text += \"<b>Sentences</b><p>\";\n" + 
				"			text += \"A list of sentences extracted from title and an abstract for all documents in a cluster. \"; \n" + 
				"			text += \"Section tags s.a. RESULTS:, METHODS: etc. were removed. \";\n" + 
				"			text += \"</p>\";\n" + 
				"		}else if('keyword' == type){\n" + 
				"			text += \"<b>MeSH Indexing Term Text Summary</b><p>\";\n" + 
				"			text += \"A frequency distribution of MeSH indexing terms was calculated from a given set of citations. \";\n" + 
				"			text += \"A sorted list of the most frequent indexing terms above some threshold was reported as a summary of that set. \";\n" + 
				"			text += \"A threshold was empirically derived and equaled to either 2 or 2% of the number of citations whichever number was the largest. \";\n" + 
				"			text += \"</p>\";\n" + 
				"		}else if('ngram' == type){\n" + 
				"			text += \"<b>NGRAM Text Summary</b><p>\";\n" + 
				"			text += \"A frequency distribution of normalized 4-grams was calculated from a given set of citations. \";\n" + 
				"			text += \"For each citation a title and an abstract was broken into 4-grams including 3-gram and 2-gram, but not 1-gram. \";\n" + 
				"			text += \"Each n-gram was normalized: that is words in it were sorted alphabetically and stop words and digits were removed. \"; \n" + 
				"			text += \"Term frequency for each n-gram was calculated across the entire corpus. \";\n" + 
				"			text += \"The summary of the corpus was a set of n-grams with frequencies above 25% of the total number of citations in a corpus. \";\n" + 
				"			text += \"The output was presented as a set of n-grams sorted in descending order based on frequencies along with a shortest concordance \";\n" + 
				"			text += \"sentence out of the first ten found in a corpus containing that n-gram.\";\n" + 
				"			text += \"</p>\";\n" + 
				"		}else if('lexrank' == type){\n" + 
				"			text += \"<b>LexRank Extractive Sentence Summary</b><p>\";	\n" + 
				"			text += \"An extractive sentence summary of a set of citations was computed using software based on LexRank algorithm[1]. \";\n" + 
				"			text += \"For each citation a title and an abstract was extracted and parsed into sentences. \";\n" + 
				"			text += \"This set of sentences were fed into C-LexRank system. \\\"C-LexRank is a summarization system that leverages the diversity of \";\n" + 
				"			text += \"perspectives in a set of documents written about the same subject\\\" [2]. \";\n" + 
				"			text += \"\\\"C-LexRank first builds the similarity network in which sentences are represented as nodes and undirected edges are weighted \";\n" + 
				"			text += \"using the cosine similarity between node pairs. On the similarity network, C-LexRank employs Newman's network community detection \";\n" + 
				"			text += \"method, which is a hierarchical agglomeration algorithm that greedily optimizes network modularity. Finally, it calculates LexRank \";\n" + 
				"			text += \"within each cluster to find the most salient sentences of each community, and picks the sentences with respect to their salience \";\n" + 
				"			text += \"from different clusters\\\" [2] The ten sentence summary was used with a cutoff of 0.5, representing a cosine similarity threshold \";\n" + 
				"			text += \"below which the edges in the undirected graph should not be created.</b><br>\";\n" + 
				"		}\n" + 
				"		document.getElementById(\"info\").innerHTML = text;\n" + 
				"		return true;\n"+
				"	}\n" + 
				"</script>\n" + 
				"<div class=\"main\">\n" + 
				"	<div class=\"header\">\n" + 
				"		10 Cluster Summary<hr>\n" + 
				"	</div>\n" + 
				"	<div class=\"clusters\">\n");
		
		// go over clusters
		writer.write(createClusterHTML("Corpus"));
		for(String cluster : clusters.getClusterMap().keySet()){
			String name = cluster.replaceAll(" ","-");
			writer.write(createClusterHTML(name));
		}
		// finish
		writer.write("	</div>\n" + 
				"	<div class=\"preview\">\n" + 
				"		<div class=\"info\" id=\"info\" >" +
				"		<h2>Corpus</h2><hr>\n" + 
				"		Overall corpus summary.\n" + 
				"		<ul>\n" + 
				"			<li><a href=\"Corpus-summary.keywords.txt\" target=\"preview\" onclick=\"return info('Corpus','keyword');\">" +
				"				MeSH Indexing Terms Corpus Summary</a></li>\n" + 
				"			<li><a href=\"Corpus-summary.ngram.txt\" target=\"preview\" onclick=\"return info('Corpus','ngram');\">" +
				"				nGRAM Corpus Summary</a></li>\n" + 
				"		</ul></div>\n" + 
				"		<iframe class=\"frame\"  name=\"preview\"></iframe>\n" + 
				"	</div>\n" + 
				"</div>\n" + 
				"</body>\n" + 
				"</html>");
		
		
		
		writer.close();
	}
	
	
	private String createClusterHTML(String name){
		return 	"		<div class=\"cluster\">\n" + 
				"			<h3>"+name+"</h3>\n" + 
				"			<ul>\n" + 
				"				<li><a href=\""+name+"-info.txt\" target=\"preview\" onclick=\"return info('"+name+"','info');\">information</a></li>\n" + 
				"				<li><a href=\""+name+"-documents.html\" target=\"preview\" onclick=\"return info('"+name+"','docs');\">documents</a></li>\n" + 
				"				<li><a href=\""+name+"-sentences.txt\" target=\"preview\" onclick=\"return info('"+name+"','sents');\">sentences</a></li>\n" + 
				"				<li>summary\n" + 
				"					<ul>\n" + 
				"						<li><a href=\""+name+"-summary.keywords.txt\" target=\"preview\" onclick=\"return info('"+name+"','keyword');\">indexing terms</a></li>\n" + 
				"						<li><a href=\""+name+"-summary.ngram.txt\" target=\"preview\" onclick=\"return info('"+name+"','ngram');\">ngram</a></li>\n" + 
				"						<li><a href=\""+name+"-summary.lexrank.txt\" target=\"preview\" onclick=\"return info('"+name+"','lexrank');\">lexrank</a></li>\n" + 
				"					</ul>\n" + 
				"				\n" + 
				"				</li>\n" + 
				"				\n" + 
				"			</ul>\n" + 
				"		</div>\n" ;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// directory 
		File dir = new File("/home/tseytlin/Data/OBP/OBP_References"); //_tokenized
		String clusterFile = "/home/tseytlin/Data/OBP/Clusters/10-Clusters/Obp Clustering Analysis.html";
		File outDir = new File("/home/tseytlin/Data/OBP/Clusters/10-Clusters");
		
		// read in cluster file
		DocumentClusterExplorer dce = new DocumentClusterExplorer(dir);
		
		//read in cluster file
		System.out.println("reading "+clusterFile+" ..");
		dce.readHTMLClusters(clusterFile);
		
		
		HTMLClusterSummary clusterSummary = new HTMLClusterSummary(dce);
		

	}

}
