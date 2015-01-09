package edu.pitt.dbmi.edda.pico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import edu.pitt.dbmi.nlp.noble.coder.processor.DocumentProcessor;
import edu.pitt.dbmi.nlp.noble.extract.InformationExtractor;
import edu.pitt.dbmi.nlp.noble.extract.model.ItemInstance;
import edu.pitt.dbmi.nlp.noble.extract.model.Template;
import edu.pitt.dbmi.nlp.noble.extract.model.TemplateDocument;
import edu.pitt.dbmi.nlp.noble.extract.model.TemplateFactory;
import edu.pitt.dbmi.nlp.noble.extract.model.TemplateItem;
import edu.pitt.dbmi.nlp.noble.terminology.Concept;
import edu.pitt.dbmi.nlp.noble.terminology.TerminologyError;
import edu.pitt.dbmi.nlp.noble.terminology.TerminologyException;
import edu.pitt.dbmi.nlp.noble.tools.TextTools;
import edu.pitt.dbmi.nlp.noble.util.PathHelper;

/**
 * This class performs information extraction of PICO+ elements
 * from a target document
 * @author tseytlin
 *
 */
public class PICOExtractor {
	private InformationExtractor ie;
	private Template template;
	private PathHelper path;
	
	/**
	 * initialize PICO Extractor with a given template file
	 * @param picoTemplate
	 * @throws Exception 
	 */
	public PICOExtractor(File picoTemplate) throws Exception{
		InputStream is = new FileInputStream(picoTemplate);
		template =  TemplateFactory.getInstance().importTemplate(is);
		ie = new InformationExtractor();
		path = new PathHelper(template.getTerminology());
	}
	
	/**
	 * process document and return key-value map with extracted items
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws TerminologyException 
	 */
	public Map<String,List<String>> processDocument(File file) throws FileNotFoundException, IOException, TerminologyException{
		return processDocument(TextTools.getText(new FileInputStream(file)),file.getName());
	}
	
	/**
	 * process document and return key-value map with extracted items
	 * @param file
	 * @return
	 * @throws TerminologyException 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Map<String,List<String>> processDocument(String text) throws TerminologyException{
		return processDocument(text,"");
	}
	
	/**
	 * process document and return key-value map with extracted items
	 * @param file
	 * @return
	 * @throws TerminologyException 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Map<String,List<String>> processDocument(String text, String name) throws TerminologyException{
		Map<String,List<String>> result = new LinkedHashMap<String, List<String>>();
		
		TemplateDocument doc = new TemplateDocument();
		doc.setTitle(name);
		doc.setText(text);
		doc.addTemplate(template);
		doc.setDocumentType(DocumentProcessor.suggestDocumentType(text));
		
		// do information extraction
		ie.process(doc);
		
		// fill in the map
		for(TemplateItem temp: template.getTemplateItems()){
			boolean hasUnits = !temp.getUnits().isEmpty();
			List<ItemInstance> instances = doc.getItemInstances(temp);
			List<String> list = new ArrayList<String>();
			for(ItemInstance inst :instances){
				if(hasUnits && inst.getValue() != null){
					String num = TextTools.toString((Double)inst.getValue());
					list.add(num+" "+inst.getUnit().getName());
				}else
					list.add(inst.getAnswer());
			}
			result.put(temp.getName(),list);
		}		
		
		return result;
	}
	
	/**
	 * get ancestors for a given preferred term 
	 * @param term
	 * @return
	 */
	public Set<String> getAncestors(String term){
		Set<String> ancestors = new LinkedHashSet<String>();
		try {
			for(Concept c :template.getTerminology().search(term)){
				for(Concept a: path.getAncestors(c).keySet()){
					ancestors.add(a.getName());
				}
			}
		} catch (TerminologyException e) {
			throw new TerminologyError("Internal Error",e);
		}
		return ancestors;
	}
	
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File dataDirectory = new File("/home/tseytlin/Work/EDDA/edda/pico/data");
		File templateFile = new File(dataDirectory,"OrganTransplant.template");
		File documentSample = new File(dataDirectory,"SAMPLE_OrganTransplant.txt");
		long time = System.currentTimeMillis();
		System.out.print("loading template "+templateFile.getName()+" .. ");
		
		/**
		 * initialize PICO extractor class with a template file
		 */
		PICOExtractor pico = new PICOExtractor(templateFile);
		
		time = System.currentTimeMillis()-time;
		System.out.println(time+" ms");
		// parse one of the reports
		System.out.print("processing document "+documentSample.getName()+" ..");
		time = System.currentTimeMillis();
		
		/**
		 * process individual document. 
		 */
		Map<String,List<String>> result = pico.processDocument(documentSample);
		
		time = System.currentTimeMillis()-time;
		System.out.println(time+" ms\n");
		for(String key: result.keySet()){
			System.out.println(key+":");
			for(String val : result.get(key)){
				System.out.println("\t"+val+"\t..\t"+pico.getAncestors(val));
			}
		}
		
	}

}
