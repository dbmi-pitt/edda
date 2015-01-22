package edu.pitt.dbmi.edda.pico.tools;

import java.io.*;
import java.util.*;

import edu.pitt.dbmi.nlp.noble.terminology.Concept;
import edu.pitt.dbmi.nlp.noble.terminology.Relation;
import edu.pitt.dbmi.nlp.noble.terminology.TerminologyException;
import edu.pitt.dbmi.nlp.noble.terminology.impl.NobleCoderTerminology;

/**
 * MeSH hierarchy doesn't get imported well from the current UMLS import method.
 * This class goes over existing MeSH NobleCoder deployment and fixes the issue
 * @author tseytlin
 *
 */
public class MeSH_HierarchyFixer {
	private Map<String,String> tree2cui;
	private Map<String,Set<String>> cui2tree;
	
	
	/**
	 * load a BAR delimitted file that has CUI to tree mapping.
	 * This file is extracted from MRHIER.RRF in UMLS
	 * @param file
	 * @throws IOException
	 */
	public void loadMeSHtree(File file) throws IOException{
		tree2cui = new HashMap<String, String>();
		cui2tree = new HashMap<String, Set<String>>();
		
		BufferedReader r = new BufferedReader(new FileReader(file));
		for(String l=r.readLine();l != null; l=r.readLine()){
			String [] p = l.split("\\|");
			if(p.length == 2){
				String cui = p[0].trim();
				String tree = p[1].trim();
				
				tree2cui.put(tree,cui);
				Set<String> trees = cui2tree.get(cui);
				if(trees == null){
					trees = new HashSet<String>();
					cui2tree.put(cui,trees);
				}
				trees.add(tree);
			}
		}
		r.close();
	}
	
	private String getParent(String tree){
		int x = tree.lastIndexOf('.');
		if(x > -1){
			return tree.substring(0,x);
		}
		return null;
	}
	
	/**
	 * add new relation
	 * @param con
	 * @param relation
	 * @param cui
	 */
	private void addRelation(Concept.Content con,Relation relation, String cui){
		String r = relation.getName();
		if(con.relationMap == null)
			con.relationMap = new HashMap<String, Set<String>>();
		Set<String> list = con.relationMap.get(r);
		if(list == null){
			list = new LinkedHashSet<String>();
			con.relationMap.put(r,list);
		}
		list.add(cui);
	}
	
	
	/**
	 * go over all concepts in terminology and re-do relationships
	 * @param term
	 * @throws TerminologyException 
	 */
	public void processTerminology(NobleCoderTerminology term) throws TerminologyException{
		NobleCoderTerminology.Storage st = term.getStorage();
		Map<String,Concept.Content> map = st.getConceptMap();
		
		// move stuff from to 
		// Topical Descriptor   (C1256741) [Intellectual Product]
		// MeSH Descriptors (C1256739) [Intellectual Product]
		/*System.out.println("correct root descritors");
		Concept.Content md = map.get("C1256739");
		Concept.Content tp = map.get("C1256741");
		
		// remove topic description from MeSH Descriptor
		md.relationMap.get(Relation.NARROWER.getName()).remove(tp.code);
		tp.relationMap.get(Relation.BROADER.getName()).remove(md.code);
		
		// add children of topic descriptor to MeSHDescriptor
		for(String cc: tp.relationMap.get(Relation.NARROWER.getName())){
			Concept.Content ccon = map.get(cc);
			addRelation(md,Relation.NARROWER,cc);
			addRelation(ccon,Relation.BROADER,md.code);
			
			map.put(cc,ccon);
		}
		map.put(md.code,md);
		map.put(tp.code,tp);*/
		
		
		// go over ALL concepts
		Set<String> missingCUIs = new LinkedHashSet<String>();
		Set<String> missingTree = new LinkedHashSet<String>();
		System.out.println("go over all MeSH concepts");
		for(String cui: map.keySet()){
			Concept.Content con = map.get(cui);
			if(con != null){
				// now, lets get the tree codes for this concept
				if(cui2tree.containsKey(cui)){
					for(String tree: cui2tree.get(cui)){
						System.out.print("\t"+cui+" -> "+tree);
						
						// remove the last part to get to parent
						String ptree = getParent(tree);
						if(ptree != null){
							String pcui = tree2cui.get(ptree);
							if(pcui != null){
								System.out.println(" ... "+ptree+" ("+pcui+")");
								// add parent to this concept
								addRelation(con,Relation.BROADER, pcui);
								
								// add child relationship to parent
								Concept.Content pcon = map.get(pcui);
								if(pcon != null){
									addRelation(pcon, Relation.NARROWER, cui);
									map.put(pcui,pcon);
								}else{
									System.err.println("Issue: concept "+ptree+" ("+pcui+") not found ");
									missingCUIs.add(pcui);
								}
							}else{
								System.err.println("Issue: parent "+ptree+" not found ");
								missingTree.add(ptree);
							}
						}
					}
					map.put(cui,con);
				}
			}else{
				System.err.println("Issue: concept ("+cui+") not found in MeSH "+cui2tree.get(cui));
				missingCUIs.add(cui);
			}
		}
		
		System.out.println("saving");
		// now save evrything
		st.save();
		System.out.println("Missing concepts "+missingCUIs.size()+" and trees "+missingTree.size());
		System.out.println("Concepts: "+missingCUIs);
		System.out.println("Trees: "+missingTree);
		/*for(String s: missing){
			System.out.println("\t"+s);
		}*/
		System.out.println("done");
		
	}
	
	
	public static void main(String[] args) throws IOException, TerminologyException {
		MeSH_HierarchyFixer fixer = new MeSH_HierarchyFixer();
		NobleCoderTerminology term = new NobleCoderTerminology();
		term.load("MeSH",false);
		
		fixer.loadMeSHtree(new File("/home/tseytlin/Data/Terminologies/UMLS/UMLS_2014AB/2014AB/UMLS/MRHIER_MeMSH_TREE3.txt"));
		fixer.processTerminology(term);
	}

}
