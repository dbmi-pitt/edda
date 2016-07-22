package edu.pitt.dbmi.edda.reference.filer.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.pitt.dbmi.nlp.noble.tools.TextTools;
/*import gov.nih.nlm.nls.nlp.textfeatures.LexicalElement;
import gov.nih.nlm.nls.nlp.textfeatures.Phrase;
import gov.nih.nlm.nls.nlp.textfeatures.Sentence;*/

public class Utils {
	private static boolean extractKeywordsFromAbstract,extractKeywordsUseMajorFocus,extractKeywordsUseCategories,extractKeywordsFilterMeSHLine;
	private static boolean extractKeywordsEntireMeSHLine,extractKeywordsUseNgrams,extractKeywordsUseNgramFilter,extractKeywordsSmallNgramFilter;
	private static TextTools textTools;
	
	public static boolean compareAuthors(String a1, String a2) {
		//break into arthurs (and strip non alpha chars
		String [] alist1 = a1.replaceAll("[^A-Za-z\\s,]","").split("(,| and )");
		String [] alist2 = a2.replaceAll("[^A-Za-z\\s,]","").split("(,| and )");
		
		// strip initials
		Pattern pt1 = Pattern.compile("\\s*[A-Z ]{1,5}\\s+([A-Z]\\w+)\\s*");
		Pattern pt2 = Pattern.compile("\\s*([A-Z]\\w+[a-z])\\s*[A-Z]{1,5}\\s*");
		
		// first list
		for(int i=0;i<alist1.length;i++){
			Matcher m1 = pt1.matcher(alist1[i]);
			Matcher m2 = pt2.matcher(alist1[i]);
			if(m1.matches())
				alist1[i] = m1.group(1);
			if(m2.matches())
				alist1[i] = m2.group(1);
		}
		
		// second list
		for(int i=0;i<alist2.length;i++){
			Matcher m1 = pt1.matcher(alist2[i]);
			Matcher m2 = pt2.matcher(alist2[i]);
			if(m1.matches())
				alist2[i] = m1.group(1);
			if(m2.matches())
				alist2[i] = m2.group(1);
		}
		
		// sort name
		Arrays.sort(alist1);
		Arrays.sort(alist2);
		
		return Arrays.equals(alist1,alist2);
	}

	public static boolean compareTitles(String t1, String t2) {
		// remove bracketes at then end
		Pattern pt = Pattern.compile("(.+)[\\[].+[\\]]");
		Matcher m1 = pt.matcher(t1);
		Matcher m2 = pt.matcher(t2);
		if(m1.matches())
			t1 = m1.group(1);
		if(m2.matches())
			t2 = m2.group(1);
		
		// search/replace known diagraphs and non alphanumeric characters
		String s1 = stripDiacritics(t1).replaceAll("[\\W\\s]","").trim();
		String s2 = stripDiacritics(t2).replaceAll("[\\W\\s]","").trim();
		return s1.equalsIgnoreCase(s2);
	}

	/**
	 * strip diacritics from the string Ex; Protégé -> Protege
	 */
	public static String stripDiacritics(String s){
		s = s.replaceAll("[èéêë]","e");
	    s = s.replaceAll("[ûù]","u");
	    s = s.replaceAll("[ïî]","i");
	    s = s.replaceAll("[àâ]","a");
	    s = s.replaceAll("Ô","o");

	    s = s.replaceAll("[ÈÉÊË]","E");
	    s = s.replaceAll("[ÛÙ]","U");
	    s = s.replaceAll("[ÏÎ]","I");
	    s = s.replaceAll("[ÀÂ]","A");
	    s = s.replaceAll("Ô","O");
	    
	    s = s.replaceAll("ﬂ","fl");
	    s = s.replaceAll("ﬁ","fi");
	    
	    return s;
	}
	
	
	/**
	 * compare two references
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean equals(Reference r1, Reference r2){
		if(r1 == null && r2 == null)
			return true;
		if(r1 == null || r2 == null)
			return false;
		//return compareAuthors(r1.getAuthors(),r2.getAuthors()) && compareTitles(r1.getTitle(),r2.getTitle());
		return compareTitles(r1.getTitle(),r2.getTitle());
	}
	
	
	/**
	 * parse XML document
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static Document parseXML(InputStream in) throws IOException {
		Document document = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//factory.setValidating(true);
		//factory.setNamespaceAware(true);

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			//builder.setErrorHandler(new XmlErrorHandler());
			//builder.setEntityResolver(new XmlEntityResolver());
			document = builder.parse(in);
			
			// close input stream
			in.close();
		}catch(Exception ex){
			throw new IOException(ex.getMessage());
		}
		return document;
	}
	
	/**
	 * get single element by tag name
	 * @param element
	 * @param tag
	 * @return
	 */
	public static Element getElementByTagName(Element element, String tag){
		NodeList list = element.getElementsByTagName(tag);
		for(int i=0;i<list.getLength();i++){
			Node node = list.item(i);
			if(node instanceof Element){
				return (Element) node;
			}
		}
		return null;
	}
	
	/**
	 * get single element by tag name
	 * @param element
	 * @param tag
	 * @return
	 */
	public static List<Element> getElementsByTagName(Element element, String tag){
		return getElementsByTagName(element, tag,false);
	}
	
	/**
	 * get single element by tag name
	 * @param element
	 * @param tag
	 * @return
	 */
	public static List<Element> getElementsByTagName(Element element, String tag, boolean recursive){
		ArrayList<Element> elements = new ArrayList<Element>();
		NodeList list = (recursive)?element.getElementsByTagName(tag):element.getChildNodes();
		for(int i=0;i<list.getLength();i++){
			Node node = list.item(i);
			if(node instanceof Element && ((Element) node).getTagName().equals(tag)){
				elements.add((Element)node);
			}
		}
		return elements;
	}
	
	/**
	 * get single element by tag name
	 * @param element
	 * @param tag
	 * @return
	 */
	public static List<Element> getChildElements(Element element){
		ArrayList<Element> elements = new ArrayList<Element>();
		NodeList list = element.getChildNodes();
		for(int i=0;i<list.getLength();i++){
			Node node = list.item(i);
			if(node instanceof Element){
				elements.add((Element)node);
			}
		}
		return elements;
	}
	
	/**
	 * responsible for 
	 * @author tseytlin
	 *
	 */
	public static class DataSplitter {
		private String [] dataL;
		private double []  dataR;
		private int [] counts;
		
		public DataSplitter(String [] labels, double [] ratios,int n){
			this.dataL = labels;
			this.dataR = ratios;
			counts = new int [dataL.length];
			for(int i=0;i<counts.length;i++)
				counts[i] = (int) (n*dataR[i]);
		}
		
		/**
		 * get label for prefix
		 * @return
		 */
		public String getLabel(){
			String dirPrefix = null;
			
			// do the same random trick as before, just decrement the tokens
			int x = 0;
			double r = Math.random();
			if(r < dataR[0]){
				x = 0;
				if(counts[0] > 0){
					dirPrefix = dataL[0];
					counts[0] --;
				}
			}else if(r > (1-dataR[1]) ){
				x = 1;
				if(counts[1] > 0){
					dirPrefix = dataL[1];
					counts[1] --;
				}
			}else{
				x = 2;
				if(counts[2] > 0){
					dirPrefix = dataL[2];
					counts[2] --;
				}
			}
			
			// now if we run out of tokens somewhere, just pick the next available record
			if(dirPrefix == null){
				// ain't exactly random I guess, will see
				for(int i=0;i<counts.length;i++){
					int y = (i+x)%counts.length;
					if(counts[y] > 0){
						dirPrefix = dataL[y];
						counts[y] --;
						break;
					}
				}
				// if we run out of tokens, but still need to evaluate just pick the one
				// where dice fell
				if(dirPrefix == null)
					dirPrefix = dataL[x];
			}
			
			return dirPrefix;
		}
	}
	
	/**
	 * strip Unicode Byte Order Mark
	 * @param line
	 * @return
	 */
	public static String stripBOB(String line){
		// check for Byte Order Mark http://en.wikipedia.org/wiki/Byte_order_mark
		byte [] bt = line.getBytes();
		if(bt.length > 3 && bt[0] == -17 && bt[1] == -69 && bt[2] == -65){
			line = new String(Arrays.copyOfRange(bt,3,bt.length));
		}
		return line;		
	}
	
	
	
	
	/**
	 * read input reference in MEDLINE format
	 * @param file
	 * @return
	 */
	
	public static List<Reference> readRISReferences(File file) {
		List<Reference> list = new ArrayList<Reference>();
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuffer buffer = new StringBuffer();
			//boolean referenceStart = false;
			for(String line = reader.readLine();line != null; line = reader.readLine()){
				line = Utils.stripBOB(line.trim());
				if(line.length() == 0)
					continue;
				
				buffer.append(line+"\n");
				
				// break references apart by finding an ER  tag
				if(line.startsWith(RISReference.END_OF_RECORD)){
					// write out the old buffer
					if(buffer.length() > 0)
						list.add(new RISReference(buffer.toString()));
					
					// start working on new reference
					buffer = new StringBuffer();
				}
			}
			
			// write out the last record
			if(buffer.length() > 0)
				list.add(new RISReference(buffer.toString()));
			
			// close
			reader.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return list;
	}
	
	
	
	/**
	 * read input reference in MEDLINE format
	 * @param file
	 * @return
	 */
	
	public static List<Reference> readMedlineReferences(File file) {
		List<Reference> list = new ArrayList<Reference>();
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuffer buffer = new StringBuffer();
			//boolean referenceStart = false;
			for(String line = reader.readLine();line != null; line = reader.readLine()){
				line = Utils.stripBOB(line.trim());
				if(line.length() == 0)
					continue;
				
				// break references apart by finding an author tag
				if(line.startsWith("AU  ")){
					// write out the old buffer
					if(buffer.length() > 0)
						list.add(new MedlineReference(buffer.toString()));
					
					// start working on new reference
					buffer = new StringBuffer();
					//referenceStart = true;
				// some $#*&^@ entries might have no author
				}else if(line.startsWith("TI  ")){
					// now if buffer already contains a title, then it is a second entry
					Pattern pt = Pattern.compile("^TI  .*$",Pattern.MULTILINE);
					Matcher mt = pt.matcher(buffer.toString());
					if(mt.find()){
						// write out the old buffer
						if(buffer.length() > 0)
							list.add(new MedlineReference(buffer.toString()));
						
						// start working on new reference
						buffer = new StringBuffer();
						//referenceStart = true;
					}
				}
				
				//if(referenceStart)
				buffer.append(line+"\n");
				
				//System.out.println(line);
				
			}
			
			// write out the last record
			if(buffer.length() > 0)
				list.add(new MedlineReference(buffer.toString()));
			
			// close
			reader.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * write each reference based on format
	 * @param ref
	 * @param string
	 * @param isIncluded
	 * @param d
	 */
		
	private void writeRefernce(Reference ref, String format, boolean isIncluded, File dir, String name) {
		String fname = format;
		if(format.startsWith("[") && format.endsWith("]")){
			fname = format.replaceAll("[^A-Z]","");
		}
		// figure out folder and file
		String suffix = dir.getName().substring(0,dir.getName().indexOf("_")).toLowerCase();
		File folder = new File(dir,fname+"_"+((isIncluded)?"Y":"N")+"_"+suffix);
		if(!folder.exists())
			folder.mkdirs();
		File file  = new File(folder,name+"_"+fname+".txt");
		
		// save file
		ref.write(file,format);
	}

	public static void writeReference(Reference ref, Writer writer) {
		
	}
	
	
	/**
	 * read input reference in MEDLINE format
	 * @param file
	 * @return
	 */
	
	public static List<Reference> readEndNoteReferences(File file) {
		List<Reference> list = new ArrayList<Reference>();
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuffer buffer = new StringBuffer();
			//boolean referenceStart = false;
			for(String line = reader.readLine();line != null; line = reader.readLine()){
				line = Utils.stripBOB(line.trim());
				if(line.length() == 0)
					continue;
				
				// break references apart by finding an author tag
				if(line.startsWith("Reference Type: ")){
					// write out the old buffer
					if(buffer.length() > 0)
						list.add(new EndNoteReference(buffer.toString()));
					
					// start working on new reference
					buffer = new StringBuffer();
					//referenceStart = true;
				}	
				//if(referenceStart)
				buffer.append(line+"\n");
				
				//System.out.println(line);
			}
			
			// write out the last record
			if(buffer.length() > 0)
				list.add(new EndNoteReference(buffer.toString()));
			
			// close
			reader.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * read an XML reference
	 * @param file
	 * @return
	 */
	public static Map<String,List<Reference>> readXMLReferences(File file) {
		Map<String,List<Reference>> filterMap = new LinkedHashMap<String, List<Reference>>();
	
		
		// lets read in an XML file generated from PDF
		try {
			Document doc = Utils.parseXML(new FileInputStream(file));
		
			// lets find approprate section 
			for(Element e: Utils.getElementsByTagName(Utils.getElementByTagName(doc.getDocumentElement(),"Part"),"Sect")){
				// find ACKNOWLEDGEMENTS section 
				Element acknowledgements = Utils.getElementByTagName(e,"H5");
				if(acknowledgements != null && "ACKNOWLEDGEMENTS".equals(acknowledgements.getTextContent().trim())){
					// YEAHAA we got there!!!!
					String title = null;
					List<Reference> list = null; 
					StringBuffer buffer = new StringBuffer();
					for(Element sect: Utils.getElementsByTagName(e,"Sect",true)){
						for(Element child: Utils.getChildElements(sect)){
							if("H5".equals(child.getTagName())){
								// we got us a section heading
								title = child.getTextContent().trim();
								list  = new ArrayList<Reference>();
								filterMap.put(title,list);
							}else if("H6".equals(child.getTagName())){
								// we can ignore those
							}else if("P".equals(child.getTagName()) && list != null){
								// we got a reference, hopefully
								String text = child.getTextContent().trim();
								
								// append to buffer
								// this is done cause some references are spanned across multiple P tags
								buffer.append(text);
								
								// if record ends with period then we have a complete record
								if(text.endsWith(".")){
									list.add(new CochraneReference(buffer.toString()));
									// reset buffer for new record
									buffer = new StringBuffer();
								}
							}
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filterMap;
	}

	/**
	 * extract a set of keywords for a given reference
	 */
	public static Set<String> getAuthors(Reference ref){
		String [] auth = ref.getAuthors().split("\\s*(,| and | et al\\.)\\s*");
		return new HashSet<String>(Arrays.asList(auth));
	}
	
	
	/**
	 * extract a set of keywords for a given reference
	 */
	public static Set<String> getKeywords(MedlineReference ref){
		return  getKeywords(ref,"MH");
	}
	
	/**
	 * extract a set of keywords for a given reference
	 */
	public static Set<String> getKeywords(RISReference ref){
		return  getKeywords(ref,"KW");
	}
	
	/**
	 * extract a set of keywords for a given reference
	 */
	public static Set<String> getKeywords(EndNoteReference ref){
		return getKeywords(ref,"Keywords");
	}
	
	/**
	 * extract a set of keywords for a given reference
	 */
	public static Set<String> getKeywords(Reference ref, String tag){
		Set<String> keys = new LinkedHashSet<String>();
		if(ref.getContentMap().containsKey(tag)){
			for(String line: ref.getContentMap().get(tag).split("\\n")){
				if(extractKeywordsEntireMeSHLine){
					String term = line.trim();
					if(extractKeywordsFilterMeSHLine){
						term = term.toLowerCase().replaceAll("\\*","");
					}
					addKeyword(term, keys);
				}else{
					// remove semantic types and other junk
					if(!extractKeywordsUseCategories)
						line = line.replaceAll("[\\(\\[]\\{(.+)[\\}\\)\\]]","");
					
					// remove semantic types abbreviation in the begining
					line = line.replaceAll("^[a-z]{2}\\b","");
					// remove *
					line = line.replaceAll("\\*","");
					// remove sema* /ac stuff
					line = line.replaceAll("/[a-z]{2}\\b","");
					for(String t: line.split("[\\.;\\[\\]\\(\\)/]")){
						String k = t.toLowerCase().trim();
						if(k.length() > 3 && k.matches("[^0-9\\-]+")){
							addKeyword(k, keys);
						}
					}
				}
			}
		}
		
		// add EMTREE terms embeded inside the abstract
		if(extractKeywordsFromAbstract){
			String ab = ref.getAbstract();
			Pattern pt = Pattern.compile("EMTREE [A-Z\\s]+ INDEX TERMS (\\(MAJOR FOCUS\\))?");
			Matcher mt = pt.matcher(ab);
			String header = null;
			int st = -1;
			List<String> sec = new ArrayList<String>();
			while(mt.find()){
				if(header != null){
					if(!extractKeywordsUseMajorFocus || header.endsWith("(MAJOR FOCUS)"))
						sec.add(ab.substring(st,mt.start()));
				}
				header = mt.group();
				st = mt.end();
			}
			if(header != null){
				if(!extractKeywordsUseMajorFocus || header.endsWith("(MAJOR FOCUS)"))
					sec.add(ab.substring(st));
			}
			
			
			// lets first see if we can split those by something like paranthesis
			for(String s: sec){
				if(extractKeywordsUseCategories){
					for(String t: s.split("[\\.;\\[\\]\\(\\)/]")){
						String k = t.toLowerCase().trim();
						if(k.length() > 3 && k.matches("[^0-9\\-]+")){
							Utils.addKeyword(k, keys);
						}
					}
				}else{
					// split using category, if available
					for(String t: s.split("\\([^\\)\\(]+\\)")){
						String k = t.toLowerCase().trim();
						if(k.length() > 3 && k.matches("[^0-9\\-]+")){
							Utils.addKeyword(k, keys);
						}
					}
				}
			}
			
		}
		return keys;
	}
	
	
	public static boolean isExtractKeywordsFromAbstract() {
		return extractKeywordsFromAbstract;
	}

	public static void setExtractKeywordsFromAbstract(boolean extractKeywordsFromAbstract) {
		Utils.extractKeywordsFromAbstract = extractKeywordsFromAbstract;
	}

	public static boolean isExtractKeywordsUseMajorFocus() {
		return extractKeywordsUseMajorFocus;
	}

	public static void setExtractKeywordsUseMajorFocus(boolean extractKeywordsUseMajorFocus) {
		Utils.extractKeywordsUseMajorFocus = extractKeywordsUseMajorFocus;
	}

	public static boolean isExtractKeywordsUseCategories() {
		return extractKeywordsUseCategories;
	}

	public static void setExtractKeywordsUseCategories(boolean extractKeywordsUseCategories) {
		Utils.extractKeywordsUseCategories = extractKeywordsUseCategories;
	}

	public static boolean isExtractKeywordsUseNgrams() {
		return extractKeywordsUseNgrams;
	}

	public static void setExtractKeywordsUseNgrams(boolean extractKeywordsUseNgrams) {
		Utils.extractKeywordsUseNgrams = extractKeywordsUseNgrams;
	}

	public static boolean isExtractKeywordsUseNgramFilter() {
		return extractKeywordsUseNgramFilter;
	}

	public static void setExtractKeywordsUseNgramFilter(boolean extractKeywordsUseNgramFilter) {
		Utils.extractKeywordsUseNgramFilter = extractKeywordsUseNgramFilter;
	}
	
	public static boolean isExtractKeywordsSmallNgramFilter() {
		return extractKeywordsSmallNgramFilter;
	}

	public static void setExtractKeywordsSmallNgramFilter(boolean extractKeywordsUseNgramFilter) {
		Utils.extractKeywordsSmallNgramFilter = extractKeywordsUseNgramFilter;
	}
	
	public static boolean isExtractKeywordsEntireMeSHLine() {
		return extractKeywordsEntireMeSHLine;
	}

	public static void setExtractKeywordsEntireMeSHLine(boolean extractKeywordsEntireMeSHLine) {
		Utils.extractKeywordsEntireMeSHLine = extractKeywordsEntireMeSHLine;
	}

	public static void setExtractKeywordsFilterMeSHLine(boolean selected) {
		Utils.extractKeywordsFilterMeSHLine = selected;
	}



	/**
	 * Add keyword to a list
	 * @param str
	 * @param keys
	 */
	public static void addKeyword(String str, Collection<String> keys){
		List<String> words = TextTools.getWords(str);
		
		// if more then 4 words and has a comma, split by comma
		if(words.size() > 5){
			// we have a flat list of words that should be split using noun phrase parser
			try{
				// intialize text tools
				if(textTools == null)
					textTools = new TextTools(new URL("http://slidetutor.upmc.edu/term/servlet/TextToolsServlet"));
				
				// break into 3-grams
				if(extractKeywordsUseNgrams){
					
					// if filter by size, remove small words
					if(extractKeywordsSmallNgramFilter){
						for(String w: words){
							if(w.length() < 3){
								str = str.replaceAll("\\b"+w+"\\b","");
							}
						}
					}
				
					
					for(String s : TextTools.getNGrams(str, 3)){
						// check if last word is noun, if so, then we are cool
						if(extractKeywordsUseNgramFilter){
						/*	Sentence sent = textTools.parseSentence(s);
							Vector v = sent.getLexicalElements();
							LexicalElement el = (LexicalElement) v.get(v.size()-1);
							if("noun".equals(el.getPOSTagString())){
								keys.add(s);
								//System.out.println(s);
							}*/
						}else{
							keys.add(s);
						}
					}
				}else{
					keys.add(str);
				}
					
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if(words.size() >=4 && str.contains(",")){
			for(String w: str.split(",")){
				keys.add(w.trim());
			}
		}else{
			// default add
			keys.add(str);
		}
	}
	
	public static class IntegerDocument extends DefaultStyledDocument {
		private int cap = 100;
		public IntegerDocument(){}
		public IntegerDocument(int c){
			cap = c;
		}
		public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
			if(arg1.matches("[\\.\\d]+")){
				String s = getText(0,getLength())+arg1;
				if(cap == 0 || s == null || s.length() == 0 || Double.parseDouble(s) <= cap)
					super.insertString(arg0, arg1, arg2);
			}
		}
	}
	
	
	/**
	 * parse text into sentences
	 * @param txt
	 * @return
	 */
	public static List<String> getSentences(String txt) {
		List<String> sentences =new ArrayList<String>();
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
		Pattern pt = Pattern.compile("([A-Z/\\(\\) &]{4,}+:?)\\s+(.*)");
		Matcher mt = pt.matcher(s);
		if(mt.matches()){
			//if(debug)
			//	System.out.println("#HEADER#|"+mt.group(1).trim());
			s = mt.group(2);
		}
		return s.trim();
	}

	public static void main(String [] args){
		String a1 = "NicholsonKG,AhmedAE,Nguyen-Van-Tam JS";
		String a2 = "A.E. Ahmed, K.G. Nicholson and J.S. Nguyen-Van-Tam";
		System.out.println(a1+"\n"+a2+"\n"+compareAuthors(a1, a2));
		
		//String t1 = "Summaries for patients. Influenza vaccination or antiviral treatment for healthy working adults: an economic analysis.[Original report in Ann Intern Med. 2002 Aug 20;137(4):225-31; PMID: 12186512]";
		//String t2 = "Summariesforpatients. Inﬂuenzavaccinationor antiviraltreatment for healthy working adultsan economic analysis";
		
		String t1= "[Formation of secretory antibodies in experimental influenza infection]";
		String t2= "Formationofsecretory antibodies in experimental influenzainfection [blah]";
		
		System.out.println(t1+"\n"+t2+"\n"+compareTitles(t1, t2));
		
	}

}
