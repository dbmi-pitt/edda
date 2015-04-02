package edu.pitt.dbmi.edda.term.discover;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.pitt.dbmi.nlp.noble.util.XMLUtils;

public class HTA_Convert2XML {
	private static void processRecord(Map<String, String> record,File out) throws ParserConfigurationException, FileNotFoundException, TransformerException, IOException {
		System.out.println("processing "+out.getName()+" ..");
		// initialize document and root
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Document doc = factory.newDocumentBuilder().newDocument();
		Element root = doc.createElement("xml-fragment");
		
		if(record.containsKey("PUB")){
			Element pub = doc.createElement("publisher-name");
			pub.setTextContent(record.get("PUB"));
			root.appendChild(pub);
		}
		
		if(record.containsKey("TTL")){
			Element pub = doc.createElement("article-title");
			pub.setTextContent(record.get("TTL"));
			root.appendChild(pub);
		}
		
		if(record.containsKey("KWO")){
			Element pub = doc.createElement("abstract");
			Element p = doc.createElement("p");
			p.setTextContent(record.get("KWO"));
			pub.appendChild(p);
			//pub.setTextContent(record.get("KWO"));
			root.appendChild(pub);
		}
		
		if(record.containsKey("XAO")){
			Element pub = doc.createElement("body");
			Element p = doc.createElement("p");
			p.setTextContent(record.get("XAO"));
			pub.appendChild(p);
			//pub.setTextContent(record.get("XAO"));
			root.appendChild(pub);
		}
		
		
		
		
		// create DOM object
		doc.appendChild(root);
		XMLUtils.writeXML(doc, new FileOutputStream(out));
	}
	public static void main(String[] args) throws Exception {
		File in = new File("/home/tseytlin/Dropbox/Data/HTA/DATA/Raw_Data/HTA_records_2005-to-2014_CanadaPlusInternational_Interface_020615.txt");
		File out = new File(in.getParentFile().getParentFile(),"XML");
		out.mkdirs();
		Map<String,String> record = null;
		int n = 0 ;
		BufferedReader r = new BufferedReader(new FileReader(in));
		for(String l=r.readLine();l != null;l = r.readLine()){
			if(l.matches("Record\\s+#\\d+")){
				if(record != null){
					processRecord(record,new File(out,String.format("record%05d.xml", n)));
				}
				record = new LinkedHashMap<String, String>();
				n++;
			}else if(record != null){
				int x = l.indexOf(':');
				if(x > -1){
					String key = l.substring(0,x).trim();
					String val = l.substring(x+1).trim();
					record.put(key,val);
				}
			}
			
		}
		if(record != null){
			processRecord(record,new File(out,String.format("record%05d.xml", n)));
		
		}
		r.close();
	}



}
