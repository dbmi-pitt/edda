package edu.pitt.dbmi.edda.terms;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.pitt.terminology.RemoteTerminology;
import edu.pitt.terminology.lexicon.Concept;
import edu.pitt.terminology.lexicon.Relation;

public class Terms2OBO {
	private static Map<String,Concept> conceptMap;
	private static DateFormat df = new SimpleDateFormat("dd:MM:yyyy HH:mm");
	private static final String HEADER = 
	"format-version: 1.2\n"+
	"date: "+df.format(new Date())+"\n" +
	"remark: EDDA Study Design Terminology.\n"+
	"remark: Evidence in Documents, Discovery, and Analysis (EDDA) Group.\n"+
	"remark: PI Tanja Bekhuis. Developers Eugene Tseytlin and Kevin Mitchell.\n"+
	"remark: Department of Biomedical Informatics, University of Pittsburgh School of Medicine, PA, USA.\n"+
	"remark: Work made possible by US National Library of Medicine,\n"+
	"remark: National Institutes of Health, grant no. R00LM010943.\n"+
	"remark: This terminology is based on research presented in\n"+
	"remark: Bekhuis T, Demner-Fushman D, Crowley RS. Comparative effectiveness research\n"+
	"remark: designs: an analysis of terms and coverage in Medical Subject Headings (MeSH) and\n"+
	"remark: Emtree. J Med Libr Assoc. 2013 Apr;101(2):92-100. doi:\n"+
	"remark: 10.3163/1536-5050.101.2.004. PubMed PMID: 23646024; PubMed Central PMCID: PMC3634392.\n\n";
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File infile = new File(args[0]);
		File outfile =  new File(args[1]);
		String name = outfile.getName();
		conceptMap = new HashMap<String, Concept>();
		int x=name.lastIndexOf('.');
		if(x > -1)
			name = name.substring(0,x);
		BufferedReader reader = new BufferedReader(new FileReader(infile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outfile));
		writer.write(HEADER);
		writer.flush();
		
		// get root concepts (Study Designs)
		int code = 0;
		//Concept root = new RemoteTerminology().lookupConcept("C0035171");
		//root.setCode(getCode(name,code++));
		Concept root = new Concept(getCode(name,code++),"EDDA Concept");
		addConcept(root, writer);
		
		List<Concept> concepts = new ArrayList<Concept>();
		Concept c = new Concept("_");
		List<String> synonyms = new ArrayList<String>();
		for(String line=reader.readLine();line != null; line=reader.readLine()){
			line = line.trim();
			
			// junk is a concept delimeter
			if(line.length() == 0 || line.matches("_+") || line.matches("\\d+")){
				// add previous concept
				if(c != null && synonyms != null && synonyms.size() > 0){
					c.setName(synonyms.get(0));
					c.setCode(getCode(name,code++));
					c.setSynonyms(synonyms.toArray(new String [0]));
					c.addRelatedConcept(Relation.BROADER,root.getCode());
					//addConcept(c,writer);
					concepts.add(c);
				}
				// start new concept
				c = new Concept("_");
				synonyms = new ArrayList<String>();
			}else{
				synonyms.add(line);
			}
		}
		reader.close();
		
		// handle last concept
		if(c != null && synonyms != null && synonyms.size() > 0){
			c.setName(synonyms.get(0));
			c.setCode(getCode(name,code++));
			c.setSynonyms(synonyms.toArray(new String [0]));
			//addConcept(c,writer);
			concepts.add(c);
		}
		
		// sort by names
		Collections.sort(concepts,new Comparator<Concept>() {
			public int compare(Concept o1, Concept o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		
		// add concepts
		for(Concept child: concepts){
			addConcept(child, writer);
		}
		
		writer.close();
	}
	private static String getCode(String name,int code){
		return name+":"+String.format("%04d",code);
	}
	
	private static void addConcept(Concept c, Writer writer) throws Exception {
		conceptMap.put(c.getCode(),c);
		writer.write("\n[Term]\n");
		writer.write("id: "+c.getCode()+"\n");
		writer.write("name: "+c.getName()+"\n");
		String [] s = c.getSynonyms();
		for(int i=1;i<s.length;i++){
			writer.write("synonym: \""+s[i]+"\" EXACT []\n");
		}
		Map<String,Set<String>> map = c.getRelationMap();
		if(map != null && map.containsKey(""+Relation.BROADER)){
			for(String cui: map.get(""+Relation.BROADER)){
				Concept p = conceptMap.get(cui);
				if(p != null)
					writer.write("is_a: "+cui+" ! "+p.getName()+"\n");
			}
		}
		writer.flush();
	}
}
