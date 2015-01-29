package edu.pitt.dbmi.edda.lens;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class HTMLClusterSummary {
	private DocumentClusterExplorer clusters;
	public HTMLClusterSummary(DocumentClusterExplorer cl){
		clusters = cl;
	}
	
	
	public void writeHTMLSummary(File out, String title, String description, boolean extended) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		int n = clusters.getClusterMap().size();
		
		writer.write(
				"<!DOCTYPE html>\n"+
				"<html>\n" + 
				"<head><meta charset=\"UTF-8\">\n" + 
				"<title>EDDA Lens</title>\n" + 
				"	<style type=\"text/css\">\n" + 
				"	.main {\n" + 
				"		width: 100%; \n" + 
				"		height: 100%;\n" + 
				"	}\n" + 
				"	.header {\n" + 
				"		height: 80px;\n" + 
				"		font-size: 32pt; \n" + 
				"		font-weight: bold;\n" + 
				"		text-align: center;\n" + 
				"		position: fixed;\n" + 
				"		top: 5px;\n" + 
				"		left: 5px;\n" + 
				"		right: 5px;\n" + 
				"		background: #eee;	\n" + 
				"	}\n" + 
				"	.clusters {\n" + 
				"		position: fixed;\n" + 
				"		border: 3px solid #000;\n" + 
				"		top: 90px;\n" + 
				"		bottom: 5px;\n" + 
				"		left: 5px;\n" + 
				"		width: 270px;\n" + 
				"		overflow: auto;\n" + 
				"	}\n" + 
				"	.cluster {\n" + 
				"		width: 85%;\n" + 
				"		padding-left: 10px;\n" + 
				"		margin: 10px 10px 10px 10px;\n" + 
				"		border: 3px solid #00f;\n" + 
				"	}\n" + 
				"	.preview {\n" + 
				"		position: fixed;\n" + 
				"		top: 90px;\n" + 
				"		left: 290px;\n" + 
				"		bottom: 5px;\n" + 
				"		right: 5px;\n" + 
				"	}\n" + 
				"	.info {\n" + 
				"		vertical-align: top;\n" + 
				"		width: 100%; \n" + 
				"		height: 40%;\n" + 
				"		overflow: auto;	\n" + 
				"	 }\n" + 
				"	.logo {\n" + 
				"		position: fixed;\n" + 
				"		top: 5px;\n" + 
				"		right: 5px;\n" + 
				"	 }\n" + 
				"	 img{\n" + 
				"	 	height: 75px;\n" + 
				"	 	width: auto;\n" + 
				"	 }\n" + 
				"	.frame {\n" + 
				"		vertical-align: bottom;\n" + 
				"		border-style: solid;\n" + 
				"		position: relative;\n" + 
				"		bottom: 5px;\n" + 
				"		left: 0px;\n" + 
				"		right: 0px;\n" + 
				"		width: 99%;\n" + 
				"		height: 60%;	\n" + 
				"	}\n" + 
				"	</style>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<script type=\"text/javascript\">\n" + 
				"	function info(cluster,type){\n" + 
				"		var text = \"<h2>\"+cluster+\"</h2><hr>\";\n" + 
				"		if('info' == type){\n" +
				"			if(\"Corpus\" === cluster){\n" + 
				"				text = \"<h2>"+title+"</h2><hr>\";\n" + 
				"				text += \"<p>"+description.replaceAll("\n"," ").replace('"','\'')+"</p>\";\n" +
				"			}else{\n" + 
				"				text += \"<b>Information</b><p>\";\n" + 
				"				text += \"Cluster information: number of documents and sentences in the cluster with n-gram and MeSH heading labels.\"; \n" + 
				"				text += \"</p>\";\n" + 
				"			}\n" +
				"		}else if('docs' == type){\n" +
				"			name = (\"Corpus\" === cluster)?\"dataset\":\"cluster\";" + 
				"			text += \"<b>Documents</b><p>\";\n" + 
				"			text += \"You can click on any of the documents (citations) in this \"+name+\". Use the browser back button to return to the document list.\";\n" + 
				"			text += \"</p>\";\n" + 
				"		}else if('sents' == type){\n" + 
				"			name = (\"Corpus\" === cluster)?\"dataset\":\"cluster\";\n" + 
				"			text += \"<b>Sentences</b><p>\";\n" + 
				"			text += \"A list of sentences extracted from titles and abstracts in this \"+name+\". Note that we treated titles as sentences. \";\n" + 
				"			text += \"Section tags, such as RESULTS and METHODS, were removed.\";" + 
				"			text += \"</p>\";\n" +
				"		}else if('keyword' == type){\n" + 
				"			text += \"<b>Summary Based on MeSH headings</b><p>\";\n" + 
				"			if(\"Corpus\" === cluster){\n" + 
				"				text += \"For this summary, we selected all of the MeSH headings and sorted by frequency.\";\n" + 
				"			}else{\n" + 
				"				text += \"For this summary, we selected the top 100 MeSH headings sorted by weights defined \";\n" + 
				"				text += \"as a function of term frequencies within and over all clusters. However, we included \";\n" + 
				"				text += \"terms in the tail of the distribution when weights were tied; we also dropped terms \";\n" + 
				"				text += \"when weights were zero.\";\n" + 
				"			}\n" + 
				"			text += \"</p>\";\n" + 
				"		}else if('ngram' == type){\n" + 
				"			text += \"<b>Summary based on N‑GRAMs</b><p>\";\n" + 
				"			desc = \"\";\n" + 
				"			if(\"Corpus\" === cluster){\n" + 
				"			    text += \"We calculated a frequency distribution for normalized 4-grams in a given set of citations. \";\n" + 
				"				desc = \"This summary is a list of top 10000 n-grams based on a sorted frequency distribution. \";\n" + 
				"				desc+= \"However, we included terms in the tail of the distribution when frequencies were tied. \";\n" + 
				"			}else{\n" + 
				"				desc = \"This summary is a list of the top 100 n-grams sorted by weights defined as a function \";\n" + 
				"				desc+= \"of term frequencies within and over all clusters. However, we included terms in the tail \";\n" + 
				"				desc+= \"of the distribution when weights were tied; we also dropped terms when weights were zero. \";\n" + 
				"			}\n" + 
				"			text += \"For each citation, we split the title and abstract into 4-grams, including 3-grams and 2-grams, \";\n" + 
				"			text += \"but not 1-grams. We normalized each n-gram by sorting its words alphabetically; we deleted stop words and most numbers. \";\n" + 
				"			text += desc;\n" + 
				"			text += \"We paired each n-gram with the shortest concordance sentence from the first 10 containing that n-gram. \";\n" + 
				"			text += \"To maximize coverage, we selected sentences without replacement.  \";\n" + 
				"			text += \"</p>\";\n" + 
				"		}else if('lexrank' == type){\n" +
				"			text += \"<b>LexRank Summarization</b><p>\";\n" + 
				"			text += \"We automatically summarized citations in a cluster using the LexRank algorithm. For each citation, we extracted its title and abstract, \";\n" + 
				"			text += \"which we then split into sentences. Note that we treated titles as sentences. The set of sentences served as input for the C-LexRank system. \";\n" + 
				"			text += \"\\\"C‑LexRank is a summarization system that leverages the diversity of perspectives in a set of documents written about the same subject … [it] \";\n" + 
				"			text += \"first builds the similarity network in which sentences are represented as nodes and undirected edges are weighted using the cosine similarity \";\n" + 
				"			text += \"between node pairs. On the similarity network, C-LexRank employs Newman's network community detection method, which is a hierarchical agglomeration \";\n" + 
				"			text += \"algorithm that greedily optimizes network modularity. Finally, it calculates LexRank within each cluster [of the network] to find the most salient \";\n" + 
				"			text += \"sentences of each community, and picks the sentences with respect to their salience from different clusters.\\\" \"; \n" + 
				"			text += \"— from <a href=\\\"http://www-personal.umich.edu/~vahed/c-lexrank.html\\\">C-LexRank page</a>; see also Qazvinian and Radev (2008). \";\n" + 
				"			text += \"We computed a k-sentence summary by setting a threshold of 0.5 for cosine similarity, below which edges in an undirected graph were disallowed.</p>\";\n" + 
				"			text += \"<b>Reference</b><ol><li>\";\n" + 
				"			text += \"Qazvinian V, Radev DR. Scientific paper summarization using citation summary networks. In Proceedings of the 22nd International Conference on \";\n" + 
				"			text += \"Computational Linguistics (Coling 2008); Manchester, UK: Coling 2008 Organizing Committee; August 2008. p. 689-96.</li><ol>\";" + 
				"		}else if('luhn' == type){\n" + 
				"			text += \"<b>Luhn Summarization</b><p>\";\n" + 
				"			text += \"We automatically summarized citations in a cluster using an algorithm described by Luhn (1958). \";\n" + 
				"			text += \"We extracted sentences from the citations and computed a measure of relative 'significance' based on word frequencies and their distribution; \";\n" + 
				"			text += \"we considered individual words first and then sentences. To create a summary, we extracted sentences scoring highest in significance. </p> \";\n" + 
				"			text += \"<b>Reference</b><ol><li>\";\n" + 
				"			text += \"Luhn HP. The automatic creation of literature abstracts. IBM Journal of Research and Development. 1958;2(2):159-65.</li></ol>\";\n" + 
				"			text += \"</p>\";" +
				"		}else if('tebeka' == type){\n" +
				"			text += \"<b>Tebeka-Mitchell Summarization (without replacement)</b><p>\";\n" + 
				"			text += \"We automatically summarized citations in a cluster using a modified version of the Simple Text Summarizer, an algorithm written by Tebeka \";\n" + 
				"			text += \"(see <a href=\\\"http://pythonwise.blogspot.com/2008/01/simple-text-summarizer.html\\\">here</a>). \";\n" + 
				"			text += \"We computed word frequencies across the entire cluster and then scored each sentence; the score equaled the sum of frequencies for \";\n" + 
				"			text += \"words appearing in a sentence. To diversify coverage in a summary, we modified the Tebeka algorithm by selecting high-scoring sentences without \";\n" + 
				"			text += \"replacement. Thus, in the Tebeka-Mitchell version, words from a sentence with highest priority were de-activated after scoring and their contributions \";\n" + 
				"			text += \"to other sentences in the priority queue were ignored. This required reprioritization each time we picked a high-scoring sentence.\";\n" + 
				"			text += \"</p>\";	" + 
				"		}else if('random' == type){\n" +
				"			text += \"<b>Random Summarization</b><p>\";\n" + 
				"			text += \"We automatically summarized citations in a cluster by randomly selecting an arbitrary number of sentences without replacement. \";\n" + 
				"			text += \"We used random summaries as a baseline to compare our various summarization strategies. \";\n" + 
				"			text += \"</p>\";	   		" + 
				"		}else if('images' == type){\n" + 
				"			name = (\"Corpus\" === cluster)?\"dataset\":\"cluster\";\n" + 
				"			text += \"<b>Images</b><p>\";\n" + 
				"			text += \"We retrieved images and figures from open access articles corresponding to citations in the \"+name;\n" + 
				"			text += \" via the <a href=\\\"http://openi.nlm.nih.gov/\\\">Open-i portal</a>. \";\n" + 
				"			text += \"\\\"The Open-i project aims to provide next generation information retrieval services for biomedical articles from the full text \";\n" + 
				"			text += \"collections such as PubMed Central. It is unique in its ability to index both the text and images in the articles.\\\"\";\n" + 
				"			text += \"</p>\";		"+
				"		}\n" + 
				"		document.getElementById(\"info\").innerHTML = text;\n" + 
				"		return true;\n" + 
				"	}\n" + 
				"</script>\n" + 
				"<div class=\"main\">\n" + 
				"	<div class=\"header\">\n" + 
				"		<div class=\"logo\"><a href=\"http://edda.dbmi.pitt.edu\" title=\"EDDA Website\"><img src=\"EDDA-logo.png\"/></a></div>\n" + 
				"		EDDA Lens Dataset Summary : "+n+" Themes\n" + 
				"	</div>\n" + 
				"	<div class=\"clusters\">\n");
		
		// go over clusters
		writer.write(createClusterHTML("Corpus",extended));
		for(String cluster : clusters.getClusterMap().keySet()){
			writer.write(createClusterHTML(cluster,extended));
		}
		// finish
		writer.write("	</div>\n" + 
				"	<div class=\"preview\">\n" + 
				"		<div class=\"info\" id=\"info\" >" +
				"		<h2>"+title+"</h2><hr>\n" + description +
				"		</div>\n" +
				"		<iframe class=\"frame\"  name=\"preview\"></iframe>\n" + 
				"	</div>\n" + 
				"</div>\n" + 
				"</body>\n" + 
				"</html>");
		
		
		
		writer.close();
	}
	
	
	private String createClusterHTML(String name, boolean extended){
		boolean corpus = "Corpus".equals(name);
		String bg = (corpus)?" style=\"background-color: #EEF;\"":"";
		String text = 	"		<div class=\"cluster\" "+bg+">\n" + 
				"			<h3>"+name+"</h3>\n" + 
				"			<ul>\n" + 
				"				<li><a href=\""+name+"-info.html\" target=\"preview\" onclick=\"return info('"+name+"','info');\">information</a></li>\n" + 
				"				<li><a href=\""+name+"-documents.html\" target=\"preview\" onclick=\"return info('"+name+"','docs');\">documents</a></li>\n";
				if(extended)
					text +="				<li><a href=\""+name+"-sentences.html\" target=\"preview\" onclick=\"return info('"+name+"','sents');\">sentences</a></li>\n";
				text += 
				"				<li><a href=\""+name+"-images.html\" target=\"preview\" onclick=\"return info('"+name+"','images');\">images</a></li>\n" + 
				"				<li>summary\n" + 
				"					<ul>\n" + 
				"						<li><a href=\""+name+"-summary.keywords.txt\" target=\"preview\" onclick=\"return info('"+name+"','keyword');\">indexing terms</a></li>\n" + 
				"						<li><a href=\""+name+"-summary.ngram.txt\" target=\"preview\" onclick=\"return info('"+name+"','ngram');\">n-gram</a></li>\n";
				if(!corpus){
					text += 
					"						<li><a href=\""+name+"-summary.lexrank.html\" target=\"preview\" onclick=\"return info('"+name+"','lexrank');\">LexRank</a></li>\n" + 
					"						<li><a href=\""+name+"-summary.tebeka.html\" target=\"preview\" onclick=\"return info('"+name+"','tebeka');\">Tebeka-Mitchell</a></li>\n"; 
					if(extended){
						text +=
						"						<li><a href=\""+name+"-summary.luhn.html\" target=\"preview\" onclick=\"return info('"+name+"','luhn');\">Luhn</a></li>\n" + 
						"						<li><a href=\""+name+"-summary.random.html\" target=\"preview\" onclick=\"return info('"+name+"','random');\">random</a></li>\n";
					}
				}
				text += 
				"					</ul>\n" + 
				"				\n" + 
				"				</li>\n" + 
				"				\n" + 
				"			</ul>\n" + 
				"		</div>\n" ;
		return text;
	}
	
	
	/**
	 * create wrapper HTML for a given text file
	 * @param out
	 * @throws Exception
	 */
	public void writeHTMLWrapper(File out) throws Exception {
		String name = out.getName();
		int n = name.lastIndexOf(".");
		if(n > -1){
			name = name.substring(0,n);
		}
	
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(out.getParentFile(),name+".html")));
		writer.write("<html>\n" + 
				"<body>\n" + 
				"<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.9.1.min.js\"></script>\n" + 
				"<script>\n" + 
				"$(document).ready(function() {\n" + 
				"    $.ajax({\n" + 
				"        url : \""+name+".txt\",\n" + 
				"        dataType: \"text\",\n" + 
				"        success : function (data) {\n" + 
				"            $(\"#text\").html(data);\n" + 
				"        }\n" + 
				"    });\n" + 
				"    \n" + 
				"});\n" + 
				"</script> \n" + 
				"<pre id=\"text\" style=\"width: 100%; white-space: pre-wrap; word-wrap: break-word;\"></pre>\n" + 
				"</body>\n" + 
				"</html>");
		writer.close();
	}

	/**
	 * create wrapper HTML for a given text file
	 * @param out
	 * @throws Exception
	 */
	public void writeHTMLView(File out) throws Exception {
		String name = out.getName();
		int n = name.lastIndexOf(".");
		if(n > -1){
			name = name.substring(0,n);
		}
	
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(out.getParentFile(),name+".html")));
		writer.write(	"<html>\n" + 
				"<body>\n" + 
				"<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.9.1.min.js\"></script>\n" + 
				"<script>\n" + 
				"$(document).ready(function() {\n" + 
				"    $.ajax({\n" + 
				"        url : getParameterByName(\"doc\"),\n" + 
				"        dataType: \"text\",\n" + 
				"        success : function (data) {\n" + 
				"            $(\"#text\").html(data);\n" + 
				"        }  \n" + 
				"    });\n" + 
				"    function getParameterByName(name) {\n" + 
				"		name = name.replace(/[\\[]/, \"\\\\[\").replace(/[\\]]/, \"\\\\]\");\n" + 
				"		var regex = new RegExp(\"[\\\\?&]\" + name + \"=([^&#]*)\"),\n" + 
				"		    results = regex.exec(location.search);\n" + 
				"		return results == null ? \"\" : decodeURIComponent(results[1].replace(/\\+/g, \" \"));\n" + 
				"	}\n" + 
				"    \n" + 
				"});\n" + 
				"</script> \n" + 
				"<pre id=\"text\" style=\"width: 100%; white-space: pre-wrap; word-wrap: break-word;\"></pre>\n" + 
				"</body>\n" + 
				"</html>");
		writer.close();
	}
}
