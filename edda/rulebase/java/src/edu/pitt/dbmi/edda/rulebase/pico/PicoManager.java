package edu.pitt.dbmi.edda.rulebase.pico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class PicoManager {
	
	private final static String CONST_PICO_PATH = "C:\\Users\\kjm84\\Desktop\\RESULTS.tab";

	private List<String> headers = new ArrayList<String>();
	private HashMap<String, Collection<PicoEvidence>> citationPicos = 
		new HashMap<String, Collection<PicoEvidence>>();
	
	public static void main(String[] args) {
		PicoManager picoManager = new PicoManager();
		try {
			picoManager.cache();
			picoManager.reportEvidence("TRANSPLANT49_FULL.txt");
			picoManager.reportEvidence("TRANSPLANT2158_FULL.txt");
			picoManager.reportEvidence("TRANSPLANT5402_FULL.txt");
			picoManager.reportEvidence("TRANSPLANT8888_FULL.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cache() throws IOException {
		File picoFile = new File(CONST_PICO_PATH);
		FileReader picoFileReader = new FileReader(picoFile);
		BufferedReader picoBufferedReader = new BufferedReader(picoFileReader);
		String line = null;
		while ((line = picoBufferedReader.readLine()) != null) {
			if (headers.isEmpty()) {
				String[] headerArray = line.split("\t");
				for (String header : headerArray) {
					headers.add(header);
				}
			}
			else if (line.matches("^\\s*Report.*")) {
				;
			}
			else {
				try {
					tryParsing(line);
				}
				catch (Exception x) {
//					System.err.println(line);
				}
				
			}
		}
	}
	
	private void tryParsing(String line) {
		final List<PicoEvidence> picoEvidenceList = new ArrayList<PicoEvidence>();
		Iterator<String> headerIterator = headers.iterator();
		headerIterator.next(); // skip the Report header
		Iterator<String> evidenceIterator = Arrays.asList(line.split("\t")).iterator();
		String citationKey = evidenceIterator.next();
		while (headerIterator.hasNext()) {
			String header = headerIterator.next();
			String semiSeparatedEvidence = evidenceIterator.next();
			if (!StringUtils.isEmpty(semiSeparatedEvidence)) {
				Iterator<String> microEvidenceIterator = Arrays.asList(semiSeparatedEvidence.split(";")).iterator();
				while (microEvidenceIterator.hasNext()) {
					String microEvidence = microEvidenceIterator.next();
					if (!StringUtils.isEmpty(microEvidence)) {	
						microEvidence = microEvidence.replaceAll("^OTE:","");
						microEvidence = microEvidence.toLowerCase();
						PicoEvidence picoEvidence = new PicoEvidence();
						picoEvidence.setCitationId(-1);
						picoEvidence.setCitationKey(citationKey);
						picoEvidence.setIsActivated(1);
						picoEvidence.setPicoCategory(header);
						picoEvidence.setPicoTerm(microEvidence);
						picoEvidence.setPolarity("present");
						picoEvidence.setWeight(1);
						picoEvidenceList.add(picoEvidence);
					}
				}
			}
		}
		citationPicos.put(citationKey, picoEvidenceList);
	}

	public Collection<PicoEvidence> reportEvidence(String citationKey) {
		return citationPicos.get(citationKey);	
	}
}
