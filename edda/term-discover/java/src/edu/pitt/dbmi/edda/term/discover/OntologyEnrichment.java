package edu.pitt.dbmi.edda.term.discover;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.pitt.dbmi.nlp.noble.coder.model.Mention;
import edu.pitt.dbmi.nlp.noble.coder.model.Sentence;
import edu.pitt.dbmi.nlp.noble.ontology.IClass;
import edu.pitt.dbmi.nlp.noble.ontology.IOntology;
import edu.pitt.dbmi.nlp.noble.ontology.IOntologyException;
import edu.pitt.dbmi.nlp.noble.ontology.IProperty;
import edu.pitt.dbmi.nlp.noble.ontology.OntologyUtils;
import edu.pitt.dbmi.nlp.noble.ontology.owl.OOntology;
import edu.pitt.dbmi.nlp.noble.terminology.Concept;
import edu.pitt.dbmi.nlp.noble.terminology.Definition;
import edu.pitt.dbmi.nlp.noble.terminology.SemanticType;
import edu.pitt.dbmi.nlp.noble.terminology.Source;
import edu.pitt.dbmi.nlp.noble.terminology.Terminology;
import edu.pitt.dbmi.nlp.noble.terminology.TerminologyException;
import edu.pitt.dbmi.nlp.noble.terminology.impl.NobleCoderTerminology;
import edu.pitt.dbmi.nlp.noble.tools.TextTools;
import edu.pitt.dbmi.nlp.noble.util.PathHelper;

public class OntologyEnrichment {
	
	private static final String CANDIDATE_CLASS = "Candidate";
	private static final String SYNONYM_PROPETY = "Variant";
	private static final String DEFINITION_PROPETY = "Definition";
	private static final String SEMTYPE_PROPETY = "Semantic_Type";
	private static final String MeSH_CODE_PROPERTY = "MeSH_Code";
	private static final String NCIT_CODE_PROPERTY = "NCI_Thesaurus_Code";	
	private static final String UMLS_CODE_PROPERTY = "UMLS_CUI";
	
	
	private PathHelper pathHelper;
	private IOntology ontology;
	private Terminology terminology,thesaurus;
	private Map<String,Integer> importStats;

	public IOntology getOntology() {
		return ontology;
	}


	public void setOntology(IOntology ontology) {
		this.ontology = ontology;
	}
	
	

	public Terminology getTerminology() throws IOException, TerminologyException, IOntologyException {
		if(terminology == null){
			terminology = new NobleCoderTerminology();
			((NobleCoderTerminology)terminology).loadOntology(ontology,null,true, false);
		}
		return terminology;
	}
	
	public Terminology getThesaurus() throws IOException, TerminologyException, IOntologyException {
		if(thesaurus == null){
			thesaurus = new NobleCoderTerminology("NCI_Metathesaurus");
			((NobleCoderTerminology)thesaurus).setSourceFilter("NCI;MSH");
		}
		return thesaurus;
	}


	public Map<String,Integer> getImportStats(){
		if(importStats == null)
			importStats = new LinkedHashMap<String, Integer>();
		return importStats;
	}
	
	private void incrementStat(String key,int n){
		if(!getImportStats().containsKey(key))
			getImportStats().put(key,0);
		getImportStats().put(key,n+getImportStats().get(key));
	}
	
	/**
	 * add terms specified in this file
	 * @param file
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws IOntologyException 
	 * @throws TerminologyException 
	 */

	public void addTerms(File file) throws FileNotFoundException, IOException, TerminologyException, IOntologyException {
		// load candidates into a map that adds 
		Map<String,List<String>> termMap = findSynonyms(TextTools.getText(new FileInputStream(file)));
		
		// create Candidate class
		IClass candidates = ontology.hasResource(CANDIDATE_CLASS)?ontology.getClass(CANDIDATE_CLASS):ontology.createClass(CANDIDATE_CLASS);
		
		// re-sort a list of new candidates from shortest to longest
		List<String> termMapKeys = new ArrayList<String>(termMap.keySet());
		Collections.sort(termMapKeys,new Comparator<String>() {
			public int compare(String o1, String o2) {
				int n = o1.length() - o2.length();
				return n == 0?o1.compareTo(o2):n;
			}
		});
		
		// go over terms and add classes that 
		for(String name : termMap.keySet()){
			List<String> terms = termMap.get(name);
			String cname = OntologyUtils.toResourceName(terms.get(0));
			
			// if there is an exact match OR we actually have exact class name, then enrich existing class if necessary
			IClass cls = null;
			if(ontology.hasResource(cname)){
				cls = ontology.getClass(cname);
			}else{
				Set<IClass> cc = findMatchingClasses(terms,true);
				if(!cc.isEmpty())
					cls = cc.iterator().next();
			}
			
			// if there, enrich with additional synonyms and leave it be
			if(cls != null){
				// add synonyms if necessary
				addTerms(cls,terms," for exiting concept");
				System.out.println(cname+" ... exact match found, adding terms");
			}else{
				// find general parent class
				cls = candidates.createSubClass(cname);
				cls.addLabel(terms.get(0));
				addTerms(cls, terms," for new concept");
				addMetathesaurusInfo(cls);
				incrementStat("new candidates added",1);
				
				// add parent if there
				Set<IClass> parents = findMatchingClasses(terms,false);
				if(!parents.isEmpty()){
					for(IClass parent: parents){
						if(!cls.hasSuperClass(parent)){
							cls.addSuperClass(parent);
							incrementStat("new candidate parent",1);
						}
						// if parent is a candidate itself, then remove this clss from candidate
						if(parent.hasSuperClass(candidates)){
							cls.removeSuperClass(candidates);
						}
					}
					System.out.println(cname+" ... adding new candidate under parent: "+parents);
				}else{
					System.out.println(cname+" ... adding new candidate");
				}
				
				// add new concept to a terminology
				getTerminology().addConcept(cls.getConcept());
			}
		}
	}
	private void addTerms(IClass cls, List<String> terms){
		addTerms(cls,terms,"");
	}
	
	private void addTerms(IClass cls, List<String> terms, String from){
		IProperty variant = ontology.getProperty(SYNONYM_PROPETY);
		for(String t: terms){
			if(!cls.hasPropetyValue(variant,t)){
				cls.addPropertyValue(variant,t);
				incrementStat("new terms added"+from,1);
			}else{
				incrementStat("skip existing term"+from,1);
			}
		}
	}
	
	/**
	 * add other information from metathesaurus
	 * @param cls
	 * @throws IOntologyException 
	 * @throws IOException 
	 * @throws TerminologyException 
	 */
	private void addMetathesaurusInfo(IClass cls) throws TerminologyException, IOException, IOntologyException{
		// we always have a label, cause we add it earlier
		String text = cls.getLabels()[0]; 
		Sentence s = getThesaurus().process(new Sentence(text));
		// if there is only one mention and it covers the whole phrse ... enrich
		if(s.getMentions().size() == 1){
			List<String> words = TextTools.normalizeWords(text,false,false,true);
			Mention m = s.getMentions().get(0);
			if(m.getAnnotations().size() == words.size()){
				// now, add definitions semantic types and whatever
				Concept c = m.getConcept();
				
				// add new synonyms
				addTerms(cls,Arrays.asList(c.getSynonyms())," from NCI Metathesaurus");
				
				// add new definitions
				IProperty definition = ontology.getProperty(DEFINITION_PROPETY);
				for(Definition d: c.getDefinitions()){
					Source src = d.getSource();
					for(Source ss: getThesaurus().getSources(src.getCode())){
						src = ss;
						break;
					}
					String source = src.getName();
					// hack MeSH
					if(source.equals("MSH"))
						source = "MeSH";
					
					if(src.getVersion() != null){
						source = source +" "+src.getVersion();
					}
					String dd = d.getDefinition()+((d.getSource() != null)?" ["+source+"]":"");
					if(Arrays.asList("NCI","MSH").contains(d.getSource().getName())){
						if(!cls.hasPropetyValue(definition,dd)){
							cls.addPropertyValue(definition,dd);
						}
					}
				}
				
				// add semantic types
				IProperty semTypes = ontology.getProperty(SEMTYPE_PROPETY);
				for(SemanticType d: c.getSemanticTypes()){
					if(!cls.hasPropetyValue(semTypes,d.getName())){
						cls.addPropertyValue(semTypes,d.getName());
					}
				}
				
				// add new codes
				IProperty cui = ontology.getProperty(UMLS_CODE_PROPERTY);
				if(!cls.hasPropetyValue(cui,c.getCode())){
					cls.addPropertyValue(cui,c.getCode());
				}
				
				// add other codes
				IProperty MSH_code = ontology.getProperty(MeSH_CODE_PROPERTY);
				IProperty NCI_code = ontology.getProperty(NCIT_CODE_PROPERTY);
				for(Object src: c.getCodes().keySet()){
					String code = c.getCode((Source)src);
					IProperty prop = null;
					if("NCI".equals(src.toString())){
						prop = NCI_code;
					}else if("MSH".equals(src.toString())){
						prop = MSH_code;
					}
					// add code
					if(code != null && prop != null && !cls.hasPropetyValue(prop,code)){
						cls.addPropertyValue(prop,code);
					}
				}
				
			}
		}
	}
	
	
	private Set<IClass> findMatchingClasses(List<String> terms,boolean exact) throws IOException, TerminologyException, IOntologyException{
		Set<IClass> clses = new LinkedHashSet<IClass>();
		for(String term: terms){
			for(Mention m : findMatch(term)){
				if(!exact || "EXACT".equals(m.getModifier("Modality"))){
					clses.add(ontology.getClass(m.getConcept().getCode()));
				}
			}
		}
		return clses;
	}
	
	
	/**
	 * figure out if this term has a match in existing ontology
	 * @param text
	 * @return
	 * @throws IOntologyException 
	 * @throws TerminologyException 
	 * @throws IOException 
	 */
	private List<Mention> findMatch(String text) throws IOException, TerminologyException, IOntologyException{
		// lookup line in terminolgoy
		Terminology term = getTerminology();
		Sentence s = term.process(new Sentence(text));
		
		// if no mentions found, then
		if(s.getMentions().isEmpty()){
			return s.getMentions();
		// if we do have one or more candidates, lets make a determination
		}else {
			List<String> words = TextTools.normalizeWords(text,false,false,true);
			// get first mention
			//Mention m = getBestMention(s);
			List<Mention> mm = s.getMentions();
			// if all words are covered, we have an exact match
			/*if(words.size()  == m.getAnnotations().size()){
				m.setModality("EXACT");
				return m;
			}else if (words.size() > m.getAnnotations().size()){
				return m;
			}*/
			for(Mention m: mm){
				if(words.size()  == m.getAnnotations().size()){
					m.getModifiers().put("Modality","EXACT");
				}
			}
			return mm;
			
		}
	}
	

	
	/*private PathHelper getPathHelper() throws IOException, TerminologyException, IOntologyException{
		if(pathHelper == null)
			pathHelper = new PathHelper(getTerminology());
		return pathHelper;		
	}*/
	
	
	/**
	 * find synonymous terms and group them together
	 * @param text
	 */
	private Map<String,List<String>> findSynonyms(String text){
		Map<String,List<String>> termMap = new LinkedHashMap<String,List<String>>();
		for(String term: text.split("\n")){
			String nterm = TextTools.normalize(term,true,false,true);
			List<String> terms = termMap.get(nterm);
			if(terms == null){
				terms = new ArrayList<String>();
				termMap.put(nterm,terms);
			}
			terms.add(term);
			incrementStat("imported new terms",1);
		}
		getImportStats().put("imported new term clusters",termMap.size());
		return termMap;
	}

	

	public void save(File file) throws FileNotFoundException, IOntologyException {
		if(!file.getParentFile().exists())
			file.getParentFile().mkdirs();
		ontology.write(new FileOutputStream(file), IOntology.OWL_FORMAT);
		
	}

	public static void main(String[] args) throws Exception {
		
		OntologyEnrichment oe = new OntologyEnrichment();
		//"http://ontologies.dbmi.pitt.edu/edda/StudyDesigns.owl"
		oe.setOntology(OOntology.loadOntology("/home/tseytlin/Dropbox/Data/EDDA Design Terms/StudyDesigns.owl"));
		/*oe.addTerms(new File("/home/tseytlin/Data/SD_Mining/data/final/curated/consensus/consensus.txt"));
		oe.save(new File("/home/tseytlin/Data/SD_Mining/data/final/ontology/consensus-terms-added/StudyDesigns.owl"));*/
		oe.addTerms(new File("/home/tseytlin/Data/SD_Mining/data/final/curated/curated-synonyms_PHST.txt"));
		oe.save(new File("/home/tseytlin/StudyDesigns.owl"));
		System.out.println("\n---| stats |---");
		for(String s: oe.getImportStats().keySet()){
			System.out.println(s+":\t\t"+oe.getImportStats().get(s));
		}
	}



}
