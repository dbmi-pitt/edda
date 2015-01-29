package edu.pitt.dbmi.edda.terms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import edu.pitt.terminology.Terminology;
import edu.pitt.terminology.client.IndexFinderTerminology;
import edu.pitt.terminology.lexicon.Concept;
import edu.pitt.terminology.util.TerminologyException;


/**
 * create new terminology from a set of CUIs
 * @author tseytlin
 *
 */
public class TerminologyCreator {
	private boolean USE_SEMANTIC_NEIGHBORHOOD = true;
	private Terminology source,target;

	/**
	 * create terminolgy 
	 */
	public void createTerminology(Collection<String> codes) throws TerminologyException{
		for(String cui: codes){
			String [] s = cui.split(" ");
			if(s.length == 0)
				continue;
			cui = s[0];
			Concept c = source.lookupConcept(cui);
			System.out.println("processing: "+cui+" ..");
			if(c != null){
				// if acronym is along with a concept
				if(s.length > 1){
					c.addSynonym(s[1]);
				}
				target.addConcept(c);
				if(USE_SEMANTIC_NEIGHBORHOOD){
					for(Concept i: c.getParentConcepts()){
						target.addConcept(i);
					}
					for(Concept i: c.getChildrenConcepts()){
						target.addConcept(i);
					}
				}
			}
		}
		((IndexFinderTerminology)target).save();
		((IndexFinderTerminology)target).dispose();
		System.out.println("done");
	}
	
	/**
	 * create terminolgy 
	 */
	public void addTerminology(Terminology term) throws TerminologyException{
		
		for(String cui: ((IndexFinderTerminology)term).getAllConcepts()){
			Concept c = term.lookupConcept(cui);
			System.out.println("processing: "+cui+" ..");
			if(c != null){
				target.addConcept(c);
			}
		}
		((IndexFinderTerminology)target).save();
		((IndexFinderTerminology)target).dispose();
		System.out.println("done");
	}
	
	
	public Terminology getSource() {
		return source;
	}

	public void setSource(Terminology source) {
		this.source = source;
	}

	public Terminology getTarget() {
		return target;
	}

	public void setTarget(Terminology target) {
		this.target = target;
	}
	
	public Collection<String> getList(String f) throws Exception {
		Set<String> lines = new LinkedHashSet<String>();
		BufferedReader r = new BufferedReader(new FileReader(f));
		for(String l=r.readLine();l != null;l=r.readLine()){
			lines.add(l.trim());
		}
		r.close();
		return lines;
	}
	
	/**
	 * create custom terminology
	 * @param args
	 */
	public static void main(String [] args) throws Exception {
		String codeFile = "/home/tseytlin/codes.txt";
		//String targetName = "SR_FLU (sn+dt)";
		String targetName = "SR_ORGAN_TRANSPLANT (sn+dt)";
		//String targetName = "SR_GALACTOMANNAN (sn+dt)";
		//String targetName = "SR_AMELO (sn+dt)";
		//String targetName = "SR_MALARIA (sn+dt)";
		
		TerminologyCreator tc = new TerminologyCreator();
		tc.setSource(new IndexFinderTerminology("UMLS"));
		tc.setTarget(new IndexFinderTerminology(targetName));
		tc.createTerminology(tc.getList(codeFile));
		tc.setTarget(new IndexFinderTerminology(targetName));
		tc.addTerminology(new IndexFinderTerminology("DesignTerms"));
		
	}

}
