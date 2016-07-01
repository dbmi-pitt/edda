package edu.pitt.dbmi.edda.reference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.edda.reference.filer.model.EndNoteReference;
import edu.pitt.dbmi.edda.reference.filer.model.MedlineReference;
import edu.pitt.dbmi.edda.reference.filer.model.Reference;
import edu.pitt.dbmi.edda.reference.filer.model.Utils;
import edu.pitt.dbmi.nlp.noble.tools.TextTools;

/**
 * identify references that have not abstract and try to 
 * generate a new one using various summarization techniques
 * @author tseytlin
 *
 */
public class ReferenceAugmentor {
	private Map<String,Reference> endNoteReferences = new HashMap<String,Reference>();
	private Map<String,String> summaryMap = new HashMap<String,String>();
	private List<Reference> references = new ArrayList<Reference>();
	private int averageAbstractSize;
	private boolean processEmptyAbstracts = true, summaryByTitles = false, onlyEmptyAbstracts = false;
	
	/**
	 * summarize pdf document to use as an abstract pdf
	 * @param r
	 * @param pdf
	 * @return
	 */
	private String summarize(Reference r, File pdf){
		/*if(pdf != null){
			return summarizeByPaper(pdf);
		}else{
			return summarizeByTitles(r.getTitle());
		}*/
		String ab = getAbstract(key(r));
		if(ab != null){
			System.out.println("generate abstract by pdf summary: "+r.getContentMap().get("filename"));
			return ab;
		}
		
		if(summaryByTitles){
			System.out.println("generate abstract by title: "+r.getContentMap().get("filename"));
			return summarizeByTitles(r.getTitle());
		}
			
		return "";
	}
	
	private String getAbstract(String key){
		String val =  summaryMap.get(key);
		/*if(val == null ){
			for(String k: summaryMap.keySet()){
				if(key.startsWith(k)){
					if(val != null){
						System.err.println("ERROR: double title found "+k+" -vs- "+key);
					}
					val =  summaryMap.get(k);
				}
			}
		}*/
		return val;
	}
	
	private String summarizeByTitles(String title) {
		StringBuffer b = new StringBuffer();
		do{
			b.append(title+". ");
		}while(b.length() < averageAbstractSize);
		return b.toString().trim();
	}


	private String summarizeByPaper(File pdf) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * augment reference with whatever it is missing
	 * @param r
	 */
	private void augmentReference(Reference r) {
		// found reference with empty abstract
		if(r.getAbstract().length() == 0){
			String ab = summarize(r,getPDFfile(r));
			if(ab.length() > 0)
				((MedlineReference)r).setAbstract(ab);
			//System.out.println(r.getAbstract()+"\n");
		}
	}
	
	public String key(Reference r){
		return key(r.getTitle());
	}
	private String key(String r){
		return r.replaceAll("\\s","");
	}
	
	private File getPDFfile(Reference r){
		Reference er = endNoteReferences.get(key(r));
		if(er != null && er.getContentMap().containsKey("pdf_file"))
			return new File(er.getContentMap().get("pdf_file"));
		return null;	
	}
	
	/**
	 * get EndNote reference based on MEDLINE reference
	 * @param r
	 * @return
	 */
	public Reference getEndNoteReference(Reference r){
		return endNoteReferences.get(key(r));
	}
	
	
	/**
	 * load endNote references into a map
	 * @param EndNoteFile
	 */
	public void loadEndNoteReferences(File EndNoteFile, File pdfDirectory){
		int n = 0,c = 0;
		for(Reference r: Utils.readEndNoteReferences(EndNoteFile)){
			EndNoteReference er = (EndNoteReference) r;
			if(er.getFileAttachment() != null){
				File f = new File(pdfDirectory.getAbsolutePath()+File.separator+er.getFileAttachment());
				r.getContentMap().put("pdf_file",f.getAbsolutePath());
			}
			if(r.getAbstract().length() > 0){
				n++;
				c += r.getAbstract().length();
			}
			endNoteReferences.put(key(r),r);
		}
		averageAbstractSize = c/n;
	}
	
	/**
	 * load summary map from Kevin's intermediate set
	 * @param dir
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void loadSummaryMap(File dir) throws FileNotFoundException, IOException{
		summaryMap = new HashMap<String,String>();
		for(File f: dir.listFiles()){
			if(f.isFile() && f.getName().endsWith(".txt")){
				String ti = getTitle(f.getName());
				String text = TextTools.getText(new FileInputStream(f));
				String delim = "\nAB - ";
				String ab = "";
				int x = text.indexOf(delim);
				if(x > -1){
					String title = text.substring(0,x);
					if(title.startsWith("TI - ")){
						title = title.substring("TI - ".length());
					}
					ab = text.substring(x+delim.length());
					ab = ab.replaceAll("\n"," ");
					if(title.length() > 0 && !"null".equals(title))
						ti = title;
				}else{
					ab = text.replaceAll("\n"," ");
				}
				summaryMap.put(key(ti),ab);
			}
		}
	}
	
	
	private String getTitle(String name) {
		if(name.endsWith(".txt"))
			name = name.substring(0,name.length()-".txt".length());
		String fname = name;
		String [] p = name.split("\\-");
		if(p.length > 2){
			int n = name.indexOf(p[2]);
			name = name.substring(n); 
		}
		if(endNoteReferences != null){
			for(String key: endNoteReferences.keySet()){
				Reference r = endNoteReferences.get(key);
				File f = getPDFfile(r);
				if(f != null && f.getName().replaceAll("[\\W+]","").equals((fname+".pdf").replaceAll("[\\W+]",""))){
					name = key;
					break;
				}
			}
		}
		
		return name;
	}


	/**
	 * save a reference in a new location
	 * @param in
	 * @param dir
	 */
	private void saveReference(Reference ref, File dir){
		String filename = ref.getContentMap().get("filename");
		String name = "";
		String dirPrefix ="";
		//System.out.println("copying "+filename);
		Pattern pt = Pattern.compile(".*/([A-Z]+)_data/\\w+/(.+)_FULL.txt");
		Matcher mt = pt.matcher(filename);
		if(mt.matches()){
			dirPrefix = mt.group(1);
			name = mt.group(2);
		}else{
			System.err.println("Error: could not parse filename");
			return;
		}
		// is article included in review
		// only use first two categories
		boolean isIncluded   = ref.isIncluded();
		
		// get parent directory
		File d = new File(dir,dirPrefix+"_data");
		if(!d.exists())	
			d.mkdirs();
		
		writeRefernce(ref,"FULL",isIncluded,d,name);
		writeRefernce(ref,"TA",isIncluded,d,name);
		writeRefernce(ref,"TI",isIncluded,d,name);
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
				r.getContentMap().put("filename",file.getAbsolutePath());
				r.getContentMap().put("include",include);
				r.getContentMap().put("dataset",dset);
				r.setIncluded("Y".equalsIgnoreCase(include));
				references.add(r);
				break;
			}
		}
	}

	private void saveReferences(File dir) {
		for(Reference r: references){
			if(onlyEmptyAbstracts){
				if(r.getAbstract().length() == 0)
					saveReference(r, dir);
			}else if(processEmptyAbstracts || r.getAbstract().length() > 0){
				augmentReference(r);
				saveReference(r, dir);
			}
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		/*String EndNoteFile = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/Galacto_Enriched_March20-with-PDFs.txt";
		String PDFDir = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/Galacto_Enriched_March20-with-PDFs.Data/PDF";
		String inputReferencDir = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/5050_2xTitles";
		String outputReferencDir = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/5050_2xTitles_abstracts_by_human_pdf";
		String summaryDir = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/TM_Summarizations_43_noab_pdfs/corey";*/
		
		String EndNoteFile = "/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/OrganTransplant_withPDFs_showAllFields_061114.txt";
		String PDFDir = "/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/PDF-Data";
		String inputReferencDir = "/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/5050_2xTitles";
		String outputReferencDir = "/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/5050_2xTitles_abstracts_by_pdf";
		String summaryDir = "/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/PDF-Clean-TM";
		
		
		ReferenceAugmentor ra = new ReferenceAugmentor();
		ra.loadEndNoteReferences(new File(EndNoteFile), new File(PDFDir));
		ra.loadSummaryMap(new File(summaryDir));
		ra.loadReferences(new File(inputReferencDir));
		ra.saveReferences(new File(outputReferencDir));
	}


}
