package edu.pitt.dbmi.edda.reference;

import java.io.File;
import java.util.Arrays;

import edu.pitt.dbmi.edda.reference.filer.model.MedlineReference;
import edu.pitt.dbmi.edda.reference.filer.model.Reference;
import edu.pitt.dbmi.edda.reference.filer.model.Utils;
import edu.pitt.dbmi.nlp.noble.terminology.*;
import edu.pitt.dbmi.nlp.noble.terminology.impl.NobleCoderTerminology;
import edu.pitt.dbmi.nlp.noble.terminology.impl.RemoteTerminology;


public class Reference2Terminology {

	public static Terminology getTerminology(Reference r){
		RemoteTerminology umls = new RemoteTerminology();
		umls.setTerminology("metathesaurus");
		//umls.setFilterSources(Source.getSources(new String []{"MSH"}));
		Terminology term = new NobleCoderTerminology();
		for(String keyword: r.getKeywords()){
			for(Concept c: umls.search(keyword)){
				try {
					if(Arrays.asList(c.getSources()).contains(Source.getSource("MSH")))
						term.addConcept(c);
				} catch (TerminologyException e) {
					e.printStackTrace();
				}
			}
		}
		return term;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String ref = "/home/tseytlin/Data/EDDA/GALACTOMANNAN/5050_2xTitles/TRAIN_data/FULL_Y_train/GALACTO8_FULL.txt";
		for(Reference r: Utils.readMedlineReferences(new File(ref))){
			Terminology term = getTerminology(r);
			for(Concept c: term.getConcepts()){
				System.out.println(c.getName()+"\t"+c.getCode()+"\t"+Arrays.toString(c.getSynonyms()));
			}
		}

	}

}
