package edu.pitt.dbmi.edda.reference;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import edu.pitt.dbmi.edda.reference.filer.model.EndNoteReference;
import edu.pitt.dbmi.edda.reference.filer.model.Reference;
import edu.pitt.dbmi.edda.reference.filer.model.Utils;
import edu.pitt.terminology.Terminology;
import edu.pitt.terminology.client.IndexFinderTerminology;
import edu.pitt.terminology.lexicon.Concept;
import edu.pitt.terminology.util.TerminologyException;

public class ReferenceStats {
	private Terminology term;
	private Map<String,Reference> referenceMap = new LinkedHashMap<String,Reference>();
	private File pdfDirectory;
	private List<Concept> blacklist;
	private class Stats {
		public int abstractCount;
		public int referenceCount;
		public int pdfCount;
		public int pdfNoAbstract;
		public int totalAbChars,totalAbSentences;
		public Set<Integer> abChar= new TreeSet<Integer>(),abSents = new TreeSet<Integer>();
		public Map<String,Integer> pdfNoAbstracCounts = new LinkedHashMap<String,Integer>();
		public Map<String,Integer> pubTypeNoAbstracCounts = new LinkedHashMap<String,Integer>();
		public Map<String,Integer> pubTypeWithAbstracCounts = new LinkedHashMap<String,Integer>();
		public String toString(){
			String out =  
				"Reference Count:\t\t"+referenceCount+"\n"+
				"References w/ Abstacts:\t\t"+abstractCount+"\n"+
				"References w/out Abstacts:\t"+(referenceCount-abstractCount)+"\n"+
				"References w/ PDF:\t\t"+pdfCount+"\n"+
				"References w/ PDF no Abstract:\t"+pdfNoAbstract+"\n"+
				"Mean Characters in Abstract:\t"+(totalAbChars/abstractCount)+"\n"+
				"Mean Sentences in Abstract:\t"+(totalAbSentences/abstractCount)+"\n"+
				"Median Characters in Abstract:\t"+median(abChar)+"\n"+
				"Median Sentences in Abstract:\t"+median(abSents)+"\n";
			for(String name: pdfNoAbstracCounts.keySet()){
				out+= "References w/ PDF no Abstract ("+name+")\t"+pdfNoAbstracCounts.get(name)+"\n";
			}
			for(String name: pubTypeNoAbstracCounts.keySet()){
				out+= "References w/out Abstract Publication: ("+name+")\t"+pubTypeNoAbstracCounts.get(name)+"\n";
			}
			for(String name: pubTypeWithAbstracCounts.keySet()){
				out+= "References with Abstract Publication: ("+name+")\t"+pubTypeWithAbstracCounts.get(name)+"\n";
			}
			
			return out;
		}
		// the array double[] m MUST BE SORTED
		public double median(Collection<Integer> points){
			double [] pt = new double [points.size()];
			int i=0;
			for(int x: points){
				pt[i++] = x;
			}
			return median(pt);
		}
		
		public double median(double[] m) {
		    int middle = m.length/2;
		    if (m.length%2 == 1) {
		        return m[middle];
		    } else {
		        return (m[middle-1] + m[middle]) / 2.0;
		    }
		}
		
	};
	
	public File getPdfDirectory() {
		return pdfDirectory;
	}


	public void setPdfDirectory(File pdfDirectory) {
		this.pdfDirectory = pdfDirectory;
	}



	/**
	 * analyze list of references
	 * @param references
	 * @return
	 */
	public Stats analyze(List<Reference> references){
		String S="|";
		System.out.println("Authors"+S+"Title"+S+"Has Abstract"+S+"Has PDF"+S+"PDF Location"+S+"Dataset"+S+"Inclusion"+S+"Publication Type"+S+"Publication Year");
		
		Stats st = new Stats();
		st.referenceCount = references.size();
		for(Reference r : references){
			EndNoteReference er = (EndNoteReference) r;
			String jt = getJournalType(r);
			String inc = "",dset = "";
			Reference rr = referenceMap.get(key(r));
			if(rr != null){
				inc = rr.isIncluded()?"include":"exclude";
				dset = rr.getContentMap().get("dataset");
			}else{
				System.err.println("Reference Not Found in Dataset: "+r);
			}
			
			if(r.getAbstract().length() > 0){
				st.abstractCount++;
				// comput abstract stats
				st.totalAbChars += r.getAbstract().length();
				st.abChar.add(r.getAbstract().length());
				int sz = Utils.getSentences(r.getAbstract()).size();
				st.totalAbSentences += sz;
				st.abSents.add(sz);
				
				for(String j: jt.split(","))
					incrementCount(st.pubTypeWithAbstracCounts,j.trim());
			}else{
				// we got a PDF and no abstract, now lets look at break down
				if(er.getFileAttachment() != null){
					st.pdfNoAbstract ++;
					incrementCount(st.pdfNoAbstracCounts,dset+"|"+inc);
				}else{
					//System.out.println(r.getAuthors());
					//System.out.println(r.getTitle()+"\n");
				}
				for(String j: jt.split(","))
					incrementCount(st.pubTypeNoAbstracCounts,j.trim());
				
				// output stats for references w/out abstracts as CSV
			}
			boolean has_ab = r.getAbstract().length() > 0;
			boolean pdf = er.getFileAttachment() != null;
			String pdfl = "";
			String year = "";
			if(pdf)
				pdfl = er.getFileAttachment();
			if(r.getContentMap().containsKey("Year"))
				year = r.getContentMap().get("Year");
			System.out.println(r.getAuthors()+S+r.getTitle()+S+has_ab+S+pdf+S+pdfl+S+dset+S+inc+S+jt+S+year);
			if(er.getFileAttachment() != null){
				st.pdfCount ++;
				//File f = new File(pdfDirectory+File.separator+er.getFileAttachment());
				//System.out.println(f.exists()+"\t"+f.getAbsolutePath());
			}
		}
		
		
		return st;
	}
	
	
	
	private String getJournalType(Reference r) {
		try {
			if(term == null){
				term = new IndexFinderTerminology("DesignTerms");
				// search strategy
				((IndexFinderTerminology) term).setDefaultSearchMethod(IndexFinderTerminology.CUSTOM_MATCH);
				((IndexFinderTerminology) term).setSubsumptionMode(true);
				((IndexFinderTerminology) term).setOverlapMode(true);
				((IndexFinderTerminology) term).setContiguousMode(false);
				((IndexFinderTerminology) term).setOrderedMode(false);
				((IndexFinderTerminology) term).setPartialMode(false);
			}
			
			
			List<Concept> result = new ArrayList<Concept>();
			Collections.addAll(result,term.search(r.getTitle()));
			for(String keyword: r.getKeywords()){
				Collections.addAll(result,term.search(keyword));
			}
			Collections.addAll(result,term.search(r.getContentMap().get("Notes")));
			// process abstract
			Collections.addAll(result,term.search(r.getAbstract()));
			
			
			// exclude database mention
			result.removeAll(getBlackList());
			
			if(!result.isEmpty()){
				Set<String> rset = new TreeSet<String>();
				for(Concept c: result)
					rset.add(c.getName());
				String s = rset.toString();
				return s.substring(1,s.length()-1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "unknown";
	}

	private List<Concept> getBlackList(){
		if(blacklist == null){
			// remove: database and address
			blacklist = new ArrayList<Concept>();
			for(String cui: Arrays.asList("DesignTerms:0039","DesignTerms:0147")){
				Concept c;
				try {
					c = term.lookupConcept(cui);
					if(c != null)
						blacklist.add(c);
				} catch (TerminologyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		return blacklist;
	}
	
	private String getInfo(Reference r) {
		String s = r.getContentMap().get("Notes");
		return "Title: "+r.getTitle()+" Keywords: "+r.getKeywords()+" Notes: "+((s != null)?s.replaceAll("\\n"," "):"");
	}


	private void incrementCount(Map<String,Integer> map,String nm){
		if(!map.containsKey(nm))
			map.put(nm,1);
		else
			map.put(nm,1+map.get(nm));
	
	}
	
	/**
	 * load in a list of references
	 * @param file
	 */
	public void loadReferences(File file){
		if(file.isDirectory()){
			for(File f: file.listFiles()){
				loadReferences(f);
			}
		}else if(file.getName().toLowerCase().endsWith("_full.txt")){
			Pattern pt = Pattern.compile("FULL_([YyNn])_(\\w+)");
			Matcher mt = pt.matcher(file.getParentFile().getName());
			String include = "";
			String dset    = "";
			if(mt.matches()){
				include = mt.group(1);
				dset = mt.group(2);
			}
			for(Reference r: Utils.readMedlineReferences(file)){
				r.getContentMap().put("include",include);
				r.getContentMap().put("dataset",dset);
				r.setIncluded("Y".equalsIgnoreCase(include));
				referenceMap.put(key(r),r);
			}
		}
	}
	
	private String key(Reference r){
		return r.getTitle().replaceAll("\\s","");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		/*String EndNoteFile = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/Galacto_Enriched_March20-with-PDFs.txt";
		String RefFileDir = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/5050_2xTitles";*/
		String EndNoteFile = "/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/OrganTransplant_withPDFs_showAllFields_061114.txt";
		String RefFileDir = "/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/5050_2xTitles";
		//String PDFDir = "/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/Galacto_Enriched_March20-with-PDFs.Data/PDF";
		List<Reference> refs = Utils.readEndNoteReferences(new File(EndNoteFile));
		ReferenceStats refStats = new ReferenceStats();
		//refStats.setPdfDirectory(new File(PDFDir));
		refStats.loadReferences(new File(RefFileDir));
		Stats st = refStats.analyze(refs);
		System.out.println("\n--------\n"+st);
	}

}
