package edu.pitt.dbmi.edda.lens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.*;

import edu.pitt.text.tools.TextTools;


public class DocumentImageDownloader {
	private DocumentClusterExplorer clusters;
	
	
	
	/**
	 * Open-I image container object
	 * @author tseytlin
	 */
	private static class IImage {
		private String url;
		private JSONObject obj;
		public IImage(String url, JSONObject obj) throws JSONException{
			this.url = url;
			this.obj = obj;
		}
		
		/**
		 * get all property names associated with this image
		 * @return
		 */
		public List<String> getPropertyNames(){
			return getPropertyNames(obj);
		}
		
		/**
		 * get property names
		 * @param o
		 * @return
		 */
		private List<String> getPropertyNames(JSONObject o){
			List<String> names = new ArrayList<String>();
			JSONArray arr = o.names();
			for(int i=0;i<arr.length();i++){
				try {
					String key = arr.getString(i);
					Object val = o.get(key);
					if(val != null && val instanceof JSONObject){
						for(String n: getPropertyNames((JSONObject) val)){
							names.add(key+"/"+n);
						}
					}else{
						names.add(key);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			return names;
		}
		/**
		 * get property for an image
		 * @param prop
		 * @return
		 */
		private Object getProperty(JSONObject o, String key) throws Exception {
			int x = key.indexOf("/");
			if(x > -1){
				Object val = o.get(key.substring(0,x));
				if(val instanceof JSONObject){
					return getProperty((JSONObject)val,key.substring(x+1));
				}else{
					return val;
				}
			}
			return o.get(key);
		}
		
		/**
		 * get property for an image
		 * @param prop
		 * @return
		 */
		public String getProperty(String prop){
			String val = null;
			try {
				val = ""+getProperty(obj,prop);
				if(val.endsWith(".png") || val.startsWith("retrieve.php")){
					val = url+val;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return val;
		}
	}
	public DocumentImageDownloader(){}
	public DocumentImageDownloader(DocumentClusterExplorer cl){
		clusters = cl;
	}
	
	/**
	 * write out all image clusters
	 * @param dir
	 * @throws IOException
	 */
	public void writeImageClusters(File dir) throws Exception {
		List<String> pmids = new ArrayList<String>();
		for(String cluster: clusters.getClusterMap().keySet()){
			System.out.println("getting images for "+cluster+" ...");
			Collection<String> files = clusters.getClusterMap().get(cluster);
			List<String> p = getPMIDs(files);
			pmids.addAll(p);
			writeHTMLimages(p,new File(dir,cluster+"-images.html"));
		}
		System.out.println("getting images for corpus ...");
		writeHTMLimages(pmids,new File(dir,"Corpus-images.html"));
	}
	
	/**
	 * get list of PMIDs from references
	 * @param files
	 * @return
	 */
	private List<String> getPMIDs(Collection<String> files) {
		List<String> pmids = new ArrayList<String>();
		for(String file: files){
			try {
				String text = TextTools.getText(new FileInputStream(new File(file)));
				Pattern pt = Pattern.compile("^Accession Number: (\\d+)$",Pattern.DOTALL|Pattern.MULTILINE);
				Matcher mt = pt.matcher(text);
				if(mt.find()){
					pmids.add(mt.group(1).trim());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pmids;
	}

	/**
	 * write out a
	 * @param pmids
	 * @param out
	 */
	public void writeHTMLimages(List<String> pmids, File out) throws Exception{
		// gather all images for all pmids
		List<IImage> images = new ArrayList<IImage>();
		for(String pmid: pmids){
			try{
			images.addAll(getImages(pmid));
			}catch(Exception ex){
				System.err.println(ex.getMessage());
			}
		}
		String title = "Images";
		StringBuffer buffer = new StringBuffer();
		
		if(images.isEmpty()){
			buffer.append("<p>There were no open access images available for the articles in this cluster :(</p>");
		}else{
		
			// go over images
			int id=1;
			for(IImage img: images){
				String url = img.getProperty("imgRegular");
				//String alt = img.getProperty("image/caption");
				String tip = img.getProperty("title");
				buffer.append("<div class=\"image\"><a href=\"\" onclick=\"showTip('TIP"+id+"'); return false;\"><img id=\"IMG"+id+"\" ");
				buffer.append("src=\""+url+"\"></a></div>\n");
				
				// write out tooltip
				String fig = img.getProperty("image/id");
				String caption =  img.getProperty("image/caption");
				String outcome =  img.getProperty("Outcome");
				String authors = img.getProperty("authors");
				String journal = img.getProperty("journal_abbr");
				String year = img.getProperty("journal_date/year");
				String pubmed  = img.getProperty("pubMed_url");
				
				// extract info from outcomes
				if(outcome != null){
					StringBuffer out2 = new StringBuffer();
					Pattern p = Pattern.compile("\"#text\":\"(.*?)\"");
					Matcher m = p.matcher(outcome);
					while(m.find()){
						out2.append(m.group(1)+" ");
					}
					if(out2.length() > 0){
						outcome = out2.toString().trim();
					}
				}
				buffer.append("<div class=\"tip\" id=\"TIP"+id+"\" onclick=\"this.style.display='none';\" title=\"click to close\">\n");
				buffer.append("<h3><a href=\""+pubmed+"\" target=\"_blank\" >"+tip+"</a></h3>\n");
				buffer.append("<img src=\""+url+"\" style=\"float:left; margin: 10px;\"/>");
				buffer.append("<div><b>"+fig+":</b> "+caption+"</div><br/>\n");
				buffer.append("<div><b>Bottom Line:</b> "+outcome+"</div><br/>\n");
				buffer.append("<div style=\"color: green;\">"+authors+" <u>"+journal+" ("+year+") </u></div><br/>\n");
				buffer.append("<div style=\"font-size: 8pt; text-align: right;\">Powered by <a href=\"http://openi.nlm.nih.gov\" target=\"_blank\">Open-I</a></div>\n");
				buffer.append("</div>");
				id++;
			}
		}
		
		
		// now write an HTML file
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		writer.write("<!DOCTYPE html><html>\n" + 
				"<head><meta charset=\"UTF-8\"><title>"+title+"</title>\n" + 
				"<style type=\"text/css\">\n" + 
				".container {}\n" + 
				".image {\n" + 
				"	display: inline-block;\n" + 
				"	vertical-align: middle;\n" + 
				"	text-align:center;\n" +
				"	margin: 4px;\n" + 
				"	padding: 4px;\n" + 
				"}\n" +
				".image:hover {\n" + 
				"    outline: 3px solid blue;\n" + 
				"}\n" + 
				"img{\n" + 
				"	max-width:  256px;\n" + 
				"    max-height: 256px;\n" + 
				"    width: auto;\n" + 
				"    height: auto;\n" + 
				"}\n" +
				".tip {\n" + 
				"	position: fixed;\n" + 
				"	display: none;\n" + 
				"	max-width: 600px;\n" + 
				"	background-color: #EEF;\n" + 
				"	border: 5px solid gray;\n" + 
				"	font-size: 10pt;\n" + 
				"	padding: 10px;\n" +
				"	overflow: auto;\n" + 
				"}\n" + 
				"</style>\n" + 
				"<script>\n" + 
				"	var prevTip;\n" + 
				"	function showTip(id){\n" + 
				"		var oldTip = document.getElementById(prevTip);\n" + 
				"		if(oldTip){\n" + 
				"			oldTip.style.display='none'\n" + 
				"		}\n" + 
				"		prevTip = id;\n" + 
				"		var tip = document.getElementById(id);\n" + 
				"		var w = window.innerWidth;\n" + 
				"		var h = window.innerHeight;\n" + 
				"		var x = Math.max((w-600)/2,10);\n" + 
				"        var y = Math.max((h-500)/2,10);\n" + 
				"        \n" + 
				"       if( !tip.style.display || tip.style.display == \"none\"){\n" + 
				"    	   	tip.style.maxHeight = Math.min(500,h-60)+'px'; \n" + 
				"    	   	tip.style.display = 'block';\n" + 
				"	        tip.style.top = y+\"px\";\n" + 
				"			tip.style.left = x+\"px\";\n" + 
				"		}" + 
				"	}" + 
				"</script>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<div class=\"container\">\n" + buffer+ 
				"</div>\n" + 
				"</body>\n" + 
				"</html>");
		writer.close();
		
	} 
	
	/**
	 * get list of images for a given
	 * @param pmid
	 * @return
	 */
	private List<IImage> getImages(String pmid) throws Exception{
		String openi = "http://openi.nlm.nih.gov/";
		URL url = new URL(openi+"retrieve.php?query=DOC[Article]AREA[PMID]"+pmid); 
		String response = doGet(url);
		//System.out.println("request:\t"+url);
		//System.out.println("response:\n"+response);
		JSONObject json = new JSONObject(response);
		return getImages(openi,json);
	}
	
	
	/**
	 * get a list of image urls for a given response object
	 * @param json
	 * @return
	 */
	private List<IImage> getImages(String url,JSONObject json) throws Exception {
		List<IImage> list = new ArrayList<IImage>();
		JSONArray entries = (JSONArray) json.get("list");
		for(int i=0;i<entries.length();i++){
			JSONObject obj = (JSONObject) entries.get(i);
			list.add(new IImage(url,obj));
		}
		return list;
	}
	
	
	/**
	 * do get request
	 * @param url
	 * @return
	 */
	private String doGet(URL url) throws Exception {
		StringBuffer b = new StringBuffer();
		BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
		for(String l=r.readLine();l != null;l=r.readLine()){
			b.append(l+"\n");
		}
		r.close();
		return b.toString();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		DocumentImageDownloader imgs = new DocumentImageDownloader();
		/*String [] pmids = new String [] {"22287313",
				"19775228" ,
				"18458027" , 
				"19087901" , 
				"18766188" , 
				"20881335" , 
				"20303300" , 
				"21512861" , 
				"21125336" , 
				"22682934" , 
				"21474366" , 
				"18849186" , 
				"22321252" };
		for(String pmid: pmids){
			for(IImage i: imgs.getImages(pmid)){
				for(String key: i.getPropertyNames()){
					System.out.println(key+"\t=\t"+i.getProperty(key));
				}
				System.out.println("\n\n");
			}
		}*/
		
		imgs.writeHTMLimages(Arrays.asList("22287313",
				"19775228" ,
				"18458027" , 
				"19087901" , 
				"18766188" ),new File("/home/tseytlin/out.html"));
		System.out.println("done");
	}

}
