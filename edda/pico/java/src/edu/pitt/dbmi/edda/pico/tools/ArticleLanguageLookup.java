package edu.pitt.dbmi.edda.pico.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

import edu.pitt.dbmi.edda.reference.ReferenceAugmentor;
import edu.pitt.dbmi.edda.reference.filer.model.Reference;
import edu.pitt.dbmi.edda.reference.filer.model.Utils;
import edu.pitt.dbmi.nlp.noble.tools.TextTools;


public class ArticleLanguageLookup {
	private Map<String,Map<String,String>> journalMap;
	private ReferenceAugmentor referenceLookup ;
	
	
	public ReferenceAugmentor getReferenceLookup() {
		return referenceLookup;
	}

	public void setReferenceLookup(ReferenceAugmentor referenceLookup) {
		this.referenceLookup = referenceLookup;
	}

	/**
	 * Load information about Journals from a given file
	 * @param file
	 * @throws IOException 
	 */
	public void loadJournalMetadata(File file) throws IOException{
		Pattern p = Pattern.compile("\\d+\\. (.+)");
		BufferedReader r = new BufferedReader(new FileReader(file));
		StringBuffer b = new StringBuffer();
		int n = 0;
		for(String l = r.readLine();l != null;l = r.readLine()){
			Matcher m = p.matcher(l);
			if(m.matches()){
				addJournal(b.toString());
				b = new StringBuffer();
				b.append("Journal: "+m.group(1).trim()+"\n");
				n++;
			}else{
				b.append(l+"\n");
			}
		}
		r.close();
		addJournal(b.toString());
		System.out.println("loaded info about "+(n+1)+" journals ..");
	}
		
	private void addJournal(String b) {
		if(b.length() == 0)
			return;
		Map<String,String> map = new LinkedHashMap<String, String>();
		for(String l: b.split("\\n")){
			String [] p = l.split(":");
			if(p.length > 1){
				map.put(p[0].trim(),p[1].trim());
			}
		}
		if(journalMap == null)
			journalMap = new LinkedHashMap<String, Map<String,String>>();
		String name = getJournalName(map.get("Journal"));
		if(name != null){
			journalMap.put(name,map);
			for(String key: map.keySet()){
				if(key.endsWith("Abbreviation")){
					journalMap.put(getJournalName(map.get(key)),map);
				}
			}
			
		}
	}

	/**
	 * get normalized journal name
	 * @param name
	 * @return
	 */
	public static String getJournalName(String name) {
		if(name == null)
			return null;
		
		// replace andpercents
		name = name.replaceAll("(&amp;|\\.)","");
		
		//if prune
		String [] p = name.split("[,:=/\\(]");
		if(p.length > 1){
			name = p[0];
		}
		
		return TextTools.normalize(name.trim(),false,false);
	}

	/**
	 * process reference file
	 * @param file
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void processReference(File file) throws FileNotFoundException, IOException {
		if(file.getName().endsWith(".txt")){
			for(Reference r: Utils.readMedlineReferences(file)){
				Reference rr = referenceLookup.getEndNoteReference(r);
				if(rr != null){
					String jj = rr.getContentMap().get("Journal");
					String njj = getJournalName(jj);
					Map<String,String> journal = journalMap.get(njj);
					if(journal != null){
						String val = journal.get("Language");
						if(val != null){
							addLanguage(file,val);
						}
					}else if(jj != null){
						System.err.println(jj);
					}
				}
				break;
			}
			
			/*String text = TextTools.getText(new FileInputStream(file));
			Pattern pt = Pattern.compile("SO  - (.+) \\d{4};.*",Pattern.DOTALL|Pattern.MULTILINE);
			Matcher mt = pt.matcher(text);
			if(mt.find()){
				String jr = mt.group(1).trim();
				String njr = getJournalName(jr);
				Map<String,String> journal = journalMap.get(njr);
				if(journal != null){
					String val = journal.get("Language");
					if(val != null){
						addLanguage(file,val);
					}
				}
			}*/
		}
	}
	
	/**
	 * add language
	 * @param file
	 * @param val
	 * @throws IOException 
	 */
	private void addLanguage(File file, String val) throws IOException {
		BufferedWriter w = new BufferedWriter(new FileWriter(file,true));
		w.write("LA  - "+val+"\n");
		w.close();	
	}

	/**
	 * process directory full of citations
	 * @param file
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void processDirectory(File file) throws FileNotFoundException, IOException{
		if(file.isFile()){
			processReference(file);
		}else if(file.isDirectory()){
			for(File f: file.listFiles()){
				processDirectory(f);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		File journal_catalog = new File("/home/tseytlin/Data/EDDA/Journals/nlmcatalog_result.txt");
		String EndNoteFile = "/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/OrganTransplant_withPDFs_showAllFields_061114.txt";
		File reference_folder = new File("/home/tseytlin/Data/Reports/EDDA/TRANSPLANT_TEST_Y/");
		
		ReferenceAugmentor ra = new ReferenceAugmentor();
		ArticleLanguageLookup all = new ArticleLanguageLookup();
		all.setReferenceLookup(ra);
		System.out.println("loadng EndNote file ..");
		ra.loadEndNoteReferences(new File(EndNoteFile),new File("/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/PDF-Data"));
		System.out.println("loading journal catalogue ..");
		all.loadJournalMetadata(journal_catalog);
		System.out.println("processing references at "+reference_folder.getAbsolutePath()+" ..");
		all.processDirectory(reference_folder);
		System.out.println("done");
	}

}
