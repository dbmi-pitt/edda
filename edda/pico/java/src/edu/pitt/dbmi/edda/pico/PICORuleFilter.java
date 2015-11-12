package edu.pitt.dbmi.edda.pico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.nlp.noble.coder.model.Mention;
import edu.pitt.dbmi.nlp.noble.coder.model.Section;
import edu.pitt.dbmi.nlp.noble.coder.processor.DocumentProcessor;
import edu.pitt.dbmi.nlp.noble.extract.InformationExtractor;
import edu.pitt.dbmi.nlp.noble.extract.model.ItemInstance;
import edu.pitt.dbmi.nlp.noble.extract.model.Template;
import edu.pitt.dbmi.nlp.noble.extract.model.TemplateDocument;
import edu.pitt.dbmi.nlp.noble.extract.model.TemplateFactory;
import edu.pitt.dbmi.nlp.noble.extract.model.TemplateItem;
import edu.pitt.dbmi.nlp.noble.ontology.IClass;
import edu.pitt.dbmi.nlp.noble.ontology.IInstance;
import edu.pitt.dbmi.nlp.noble.ontology.ILogicExpression;
import edu.pitt.dbmi.nlp.noble.ontology.IOntology;
import edu.pitt.dbmi.nlp.noble.ontology.IOntologyException;
import edu.pitt.dbmi.nlp.noble.ontology.IProperty;
import edu.pitt.dbmi.nlp.noble.ontology.IRestriction;
import edu.pitt.dbmi.nlp.noble.ontology.owl.OOntology;
import edu.pitt.dbmi.nlp.noble.terminology.Concept;
import edu.pitt.dbmi.nlp.noble.terminology.TerminologyException;
import edu.pitt.dbmi.nlp.noble.tools.TextTools;

public class PICORuleFilter {
	//public static final int RULE_CUTOFF = 10;
	public static final boolean RULE_SHORT_CIRCUIT = true; 
	public static final String LABEL_INCLUDE = "include";
	public static final String LABEL_EXCLUDE = "exclude";
	private File ontologyFile, templateFile;
	private IOntology ontology;
	private Template template;
	private InformationExtractor ie;
	private Map<Object,Count> activatedRuleCounts;
	private List<String> debugList;
	
	private static class Count {
		public int TP,FP;
		public String toString(){
			return TP+" / "+FP;
		}
		public int getTotal(){
			return TP+FP;
		}
	}
	
	
	public PICORuleFilter(File ontologyFile, File templateFile){
		this.ontologyFile = ontologyFile;
		this.templateFile = templateFile;
		ie = new InformationExtractor();
	}
	
	
	private String getResourceName(String code){
		int i = code.indexOf(':');
		if(i > -1)
			code = code.substring(i+1);
		return code;
	}
	
	private String getResourceName(Concept c){
		return getResourceName(c.getCode());
	}
	
	private String getResourceName(Mention m){
		return getResourceName(m.getConcept());
	}
	
	
	/**
	 * get propert that corresponds to template item
	 * @param temp
	 * @return
	 */
	private IProperty getPropertyFor(TemplateItem temp){
		IOntology ont = getOntology();
		IClass cls = ont.getClass(getResourceName(temp.getConcept()));
		if(cls != null){
			for(IProperty prop : ont.getProperty("hasRule").getDirectSubProperties()){
				if(Arrays.asList(prop.getRange()).contains(cls)){
					return prop;
				}
			}
		}
		return null;
	}
	
	public void loadDebugList(File file) throws FileNotFoundException, IOException{
		debugList = new ArrayList<String>();
		for(String s: TextTools.getText(new FileInputStream(file)).split("\n")){
			s = s.trim();
			if(s.length() > 0)
				debugList.add(s);
		}
	}
	
	
	/**
	 * get ontology
	 * @return
	 */
	private IOntology getOntology(){
		if(ontology == null && ontologyFile  != null){
			try {
				ontology = OOntology.loadOntology(ontologyFile);
			} catch (IOntologyException e) {
				e.printStackTrace();
			}
		}
		return ontology;
	}
	
	private Template getTemplate(){
		if(template == null && templateFile != null){
			try {
				InputStream is = new FileInputStream(templateFile);
				template =  TemplateFactory.getInstance().importTemplate(is);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return template;
	}
	
	/**
	 * process document and return key-value map with extracted items
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws TerminologyException 
	 */
	public TemplateDocument processDocument(File file) throws FileNotFoundException, IOException, TerminologyException{
		return processDocument(TextTools.getText(new FileInputStream(file)),file.getName(),getLabel(file));
	}
	
	/**
	 * process document and return key-value map with extracted items
	 * @param file
	 * @return
	 * @throws TerminologyException 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public TemplateDocument processDocument(String text, String name, String label) throws TerminologyException{
		TemplateDocument doc = new TemplateDocument();
		doc.setTitle(name);
		doc.setText(text);
		doc.addTemplate(getTemplate());
		doc.setDocumentType(DocumentProcessor.suggestDocumentType(text));
		doc.getProperties().put("label",label);
		
		// do information extraction
		ie.process(doc);
		
		return doc;
	}
	
	/**
	 * process rules for a given reference
	 * @param doc
	 * @return
	 */
	public String processRules(TemplateDocument doc){
		// figure out if we want to debug this doc
		boolean debug = (debugList != null && debugList.contains(doc.getTitle()));
		
		// create an instance of type 
		IOntology ont = getOntology();
		IClass citation = ont.getClass("Citation");
		IInstance inst = citation.createInstance(doc.getTitle());
	
		
		// add has abstract property
		boolean hasAbstract = false;
		for(Section s: doc.getSections()){
			if("AB".equals(s.getTitle()) && s.getText().trim().length() > 0){
				hasAbstract = true;
				break;
			}
		}
		inst.addPropertyValue(ont.getProperty("hasAbstract"),hasAbstract);
		
		// now add values to instance
		for(TemplateItem temp: getTemplate().getTemplateItems()){
			List<ItemInstance> instances = doc.getItemInstances(temp);
			if(!instances.isEmpty()){
				IProperty prop = getPropertyFor(temp);
				if(prop != null){
					for(ItemInstance in: instances){
						IClass icls = ont.getClass(getResourceName(in.getMention()));
						if(icls != null){
							IInstance ii = ont.getInstance(icls.getName()+"_instance");
							if(ii == null){
								ii = icls.createInstance(icls.getName()+"_instance");
							}
							inst.addPropertyValue(prop,ii);
						}
					}
				}
			}
		}
		
		// look over citation categories
		String answer = LABEL_INCLUDE;
		for(IClass category: citation.getDirectSubClasses()){
			// no process all of the restrictions
			for(Object r: getRules(category)){
				boolean result = evaluate(r,inst);
				if(result){
					incrementRuleCount(r,doc.getProperties().get("label"));
					if(debug){
						System.out.println(doc.getTitle()+"\trule: "+r+" | evidence: "+Arrays.asList(inst.getPropertyValues(getProperty(r)))+" | result: "+result);
					}
					answer =  category.getName().toLowerCase();
					if(RULE_SHORT_CIRCUIT)
						return answer;
				}
			}
		}
		return answer;
	}
	
	private void incrementRuleCount(Object rule,String label) {
		Count count = getRuleCounts().get(rule);
		if( count == null)
			count = new Count();
		
		// increment appropriate value
		if(LABEL_EXCLUDE.equals(label))
			count.TP ++;
		else
			count.FP ++;
		
		getRuleCounts().put(rule,count);
		
	}


	private Map<Object,Count> getRuleCounts() {
		if(activatedRuleCounts == null){
			activatedRuleCounts = new LinkedHashMap<Object,Count>();
		}
		return activatedRuleCounts;
	}


	/**
	 * get rule order, return 0 if not found
	 * @param r
	 * @return
	 */
	private int getRuleOrder(Object o){
		IRestriction r = getRestriction(o);
		if(r == null)
			return 0;
		IProperty order = r.getOntology().getProperty("hasRuleOrder");
		Object v1 = r.getProperty().getPropertyValue(order);
		if(v1 != null && v1 instanceof Integer){
			return ((Integer)v1).intValue();
		}
		return 0;
	}
	
	/**
	 * get the 1st restriction out of the rule
	 * @param rule
	 * @return
	 */
	private IRestriction getRestriction(Object o){
		IRestriction r = null;
		if(o instanceof IRestriction)
			r = (IRestriction) o;
		else if (o instanceof ILogicExpression && ((ILogicExpression)o).getOperand() instanceof IRestriction)
			r = (IRestriction)((ILogicExpression)o).getOperand();
		return r;
	}
	
	private IProperty getProperty(Object o){
		IRestriction r = getRestriction(o);
		return (r != null)?r.getProperty():null;
	}

	
	private boolean evaluate(Object r, IInstance inst){
		boolean result = false;
		if(r instanceof IRestriction)
			result = ((IRestriction)r).evaluate(inst);
		else if (r instanceof ILogicExpression)
			result = ((ILogicExpression)r).evaluate(inst);
		return result;
	}

	/**
	 * get sorted set of rules
	 * @param category
	 * @return
	 */
	
	private List getRules(IClass category){
		List rules = new ArrayList();
		for(Object obj : category.getNecessaryRestrictions()){
			if(obj instanceof IRestriction || obj instanceof ILogicExpression){
				rules.add(obj);
			}
		}
		Collections.sort(rules,new Comparator() {
			public int compare(Object o1, Object o2) {
				return getRuleOrder(o1) - getRuleOrder(o2);
			}
		});
		return rules;
	}
	
	/**
	 * get input list of files of interest
	 * @param dir
	 * @return
	 */
	public List<File> getInputFiles(File dir){
		List<File> files = getInputFiles(dir,new ArrayList<File>());
		Collections.sort(files,new Comparator<File>(){
			public int compare(File o1, File o2) {
				Pattern p = Pattern.compile("\\d+");
				Matcher m1 = p.matcher(o1.getName());
				Matcher m2 = p.matcher(o2.getName());
				if(m1.find() && m2.find()){
					return Integer.parseInt(m1.group()) - Integer.parseInt(m2.group());
				}
				return o1.compareTo(o2);
			}
			
		});
		return files;
	}
	
	/**
	 * get input list of files of interest
	 * @param dir
	 * @return
	 */
	private List<File> getInputFiles(File file,List<File> list){
		if(file.isFile() && file.getName().toLowerCase().endsWith("_full.txt")){
			list.add(file);
		}else if(file.isDirectory()){
			for(File f: file.listFiles()){
				getInputFiles(f,list);
			}
		}
		return list;
	}
	
	private String getLabel(File f) {
		return f.getAbsolutePath().matches(".*_N_.*")?LABEL_EXCLUDE:LABEL_INCLUDE;
	}
	
	/**
	 * process input references in a given directory and output it to a file
	 * @param input
	 * @param output
	 * @throws TerminologyException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void process(File input, File output) throws FileNotFoundException, IOException, TerminologyException{
		activatedRuleCounts = null;
		BufferedWriter w = new BufferedWriter(new FileWriter(output));
		int ee = 0, ei = 0, ie = 0, ii = 0;
		
		// process all files
		for(File f: getInputFiles(input)){
			TemplateDocument doc = processDocument(f);
			String category = processRules(doc);
			String label = getLabel(f);
			//System.out.println(f.getName()+","+label+","+category);
			w.write(f.getName()+","+label+","+category+"\n");
			
			// do counts
			if(LABEL_EXCLUDE.equals(label)){
				if(LABEL_EXCLUDE.equals(category)){
					ee ++;
				}else{
					ei ++;
				}
			}else {
				if(LABEL_INCLUDE.equals(category)){
					ii ++;
				}else{
					ie ++;
				}
			}
		}
		w.close();
		
		// print stats
		System.out.println("\n-----------------------------------------------");
		System.out.println("actual, predicted,\tcount");
		System.out.println("exclude,exclude,\t"+ee);
		System.out.println("exclude,include,\t"+ei);
		System.out.println("include,exclude,\t"+ie);
		System.out.println("include,include,\t"+ii);
		System.out.println("-----------------------------------------------");
		List rules = new ArrayList(getRuleCounts().keySet());
		/*Collections.sort(rules,new Comparator<String>(){
			public int compare(String o1, String o2) {
				return getRuleCounts().get(o2).getTotal() - getRuleCounts().get(o1).getTotal();
			}
			
		});*/
		Collections.sort(rules,new Comparator() {
			public int compare(Object o1, Object o2) {
				return getRuleOrder(o1) - getRuleOrder(o2);
			}
		});
		for(Object rule: rules){
			System.out.println(getRuleCounts().get(rule)+"  \t->\t"+rule);
		}
			
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, TerminologyException {
		File dataDirectory = new File("/home/tseytlin/Work/EDDA/edda/pico/data");
		File templateFile = new File(dataDirectory,"OrganTransplant.template");
		File ontologyFile = new File(dataDirectory,"OrganTransplantRules.owl");
		File inputReferences = new File("/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/5050_2xTitles/TRAIN_data");
		File outputResult = new File("/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/pico_rules_train.txt");
		File debugList = new File("/home/tseytlin/Data/EDDA/ORGAN_TRANSPLANT/debugList.txt");
		
		PICORuleFilter filter = new PICORuleFilter(ontologyFile, templateFile);
		//filter.loadDebugList(debugList);
		filter.process(inputReferences, outputResult);
	}


	

}
