package edu.pitt.dbmi.edda.rulebase.document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.edda.pico.PICOExtractor;
import edu.pitt.dbmi.edda.rulebase.Identifiable;
import edu.pitt.dbmi.edda.rulebase.Utilities;
import edu.pitt.dbmi.edda.rulebase.pico.PicoEvidence;
import edu.pitt.dbmi.nlp.noble.terminology.TerminologyException;

public class Citation extends Identifiable {

	private static final long serialVersionUID = 1L;

	private Integer systematicReviewId = -1;
	private String citationKey;
	private String path = "NA";
	private String partition = "NA";
	private String actualClassification = "NA";
	private String predictedClassification = "NA";
	private Integer weight = 0;

	private PICOExtractor picoExtractor;

	private Collection<PicoEvidence> picoEvidence = new ArrayList<PicoEvidence>();
	private Iterator<PicoEvidence> picoEvidenceIterator;

	private String lastRuleApplied = "NA";

	private transient String content;

	public static void main(String[] args) {
		Citation citationOne = new Citation();
		citationOne.setContent("hello world\nAB - mycophenolic acid 2 morpholinoethyl ester Post-marketing study.");
		citationOne.generateNoAbstractEvidence();
		citationOne.generateExtraLiteratureReviewEvidence();
		citationOne.generateEmbaseMmfEvidence();
		System.out.println("Citation #1");
		for (PicoEvidence e : citationOne.getPicoEvidence()) {
			System.out.println(e);
		}
		Citation citationTwo = new Citation();
		citationTwo.setContent("Post-marketing studies have no impact like no abstracts.\n mycophenolic acid 2 morpholinoethyl ester");
		citationTwo.generateNoAbstractEvidence();
		citationTwo.generateExtraLiteratureReviewEvidence();
		citationTwo.generateEmbaseMmfEvidence();
		System.out.println("Citation #2");
		for (PicoEvidence e : citationTwo.getPicoEvidence()) {
			System.out.println(e);
		}
	}

	public Citation() {
		;
	}

	private void extractPicoEvidence() {
		try {
			picoEvidence.clear();
			File f = new File(getPath());
			Map<String, List<String>> evidence = picoExtractor
					.processDocument(f);
			setPicoEvidence(evidence);
			
//			generateExtraLiteratureReviewEvidence();
//			generateExtraBloodEvidence();
//			generateExtraMeasurementEvidence();
//			generateNoAbstractEvidence();
//			generateEmbaseMmfEvidence();
//			generateGeneralMmfEvidence();
			
			setContent("NA");
		} catch (TerminologyException | IOException e) {
			e.printStackTrace();
		}
	}

	public void setPicoEvidence(Map<String, List<String>> evidence) {
		if (evidence == null || evidence.size() == 0) {
			System.err.println("No evidence found for citation "
					+ getCitationKey());
		} else {
			for (String picoCategory : evidence.keySet()) {
				final Set<String> ancestorTerms = new HashSet<String>();
				List<String> terms = evidence.get(picoCategory);
				for (String picoTerm : terms) {
					PicoEvidence picoAtomicEvidence = new PicoEvidence();
					picoAtomicEvidence.setCitationId(getId());
					picoAtomicEvidence.setPicoCategory(picoCategory);
					picoAtomicEvidence.setPicoTerm(picoTerm.toLowerCase());
					picoAtomicEvidence.setAncestryDepth(0);
					picoAtomicEvidence.setPolarity("present");
					picoAtomicEvidence.setWeight(1);
					picoEvidence.add(picoAtomicEvidence);
					ancestorTerms.addAll(picoExtractor
							.getAncestors(picoAtomicEvidence.getPicoTerm()));
				}
				for (String ancestorTerm : ancestorTerms) {
					PicoEvidence picoAncestorEvidence = new PicoEvidence();
					picoAncestorEvidence.setCitationId(getId());
					picoAncestorEvidence.setPicoCategory(picoCategory);
					picoAncestorEvidence
							.setPicoTerm(ancestorTerm.toLowerCase());
					picoAncestorEvidence.setAncestryDepth(1);
					picoAncestorEvidence.setPolarity("ancestor");
					picoAncestorEvidence.setWeight(1);
					picoEvidence.add(picoAncestorEvidence);
				}
			}
		}
	}

	private void generateExtraBloodEvidence() {
		final String[] patterns = { "\\d+\\s*microg/ml",
				"\\d+\\s*microg/hour/ml", "\\[Blood\\]" };
		generateExtraEvidence(patterns, "Intervention / Comparator Category",
				"blood", Pattern.CASE_INSENSITIVE, false);
	}

	private void generateExtraMeasurementEvidence() {
		final String[] patterns = { "matched multivariate analysis",
				"in vitro assay", "\\d+\\s*microg/ml",
				"\\d+\\s*microg/hour/ml", "glomerular permeability test",
				"adjusted odds ratio" };
		generateExtraEvidence(patterns, "Intervention / Comparator Category",
				"physiologic monitoring", Pattern.CASE_INSENSITIVE, false);
	}

	public void generateExtraLiteratureReviewEvidence() {
		final String[] patterns = { "Cochrane Library", "Post-marketing stud(ies|y)" };
		generateExtraEvidence(patterns, "Publication Type",
				"literature review", Pattern.CASE_INSENSITIVE, false);
	}

	public void generateNoAbstractEvidence() {
		final String[] patterns = { "\\bAB\\s+-" };
		generateExtraEvidence(patterns, "Abstract Category", "missing",
				Pattern.CASE_INSENSITIVE, true);
	}
	
	public void generateEmbaseMmfEvidence() {
		final String[] patterns = { "mycophenolic acid 2 morpholinoethyl ester" };
		generateExtraEvidence(patterns, "Embase Keywords Category", "mmf",
				Pattern.CASE_INSENSITIVE, false);
	}
	
	public void generateGeneralMmfEvidence() {
		final String[] patterns = { "[Mm]ycophenolate [Mm]ofetil|MMF" };
		generateExtraEvidence(patterns, "General Mention Category", "mmf",
				Pattern.CASE_INSENSITIVE, false);
	}

	private void generateExtraEvidence(String[] patterns, String category,
			String generalTerm, int flags, boolean useMissing) {
		for (String currentPattern : patterns) {
			Pattern p = Pattern.compile(currentPattern, flags);
			Matcher m = p.matcher(getContent());
			if ((useMissing && !m.find()) || (!useMissing && m.find())) {
				PicoEvidence picoAtomicEvidence = new PicoEvidence();
				picoAtomicEvidence.setCitationId(getId());
				picoAtomicEvidence.setIsActivated(1);
				picoAtomicEvidence.setPicoCategory(category);
				picoAtomicEvidence.setPicoTerm(generalTerm);
				picoAtomicEvidence.setAncestryDepth(0);
				picoAtomicEvidence.setPolarity("present");
				picoAtomicEvidence.setWeight(1);
				picoEvidence.add(picoAtomicEvidence);
			}
		}
	}

	public void iterateEvidence() {
		if (picoEvidence.isEmpty()) {
			extractPicoEvidence();
		}
		picoEvidenceIterator = picoEvidence.iterator();
	}

	public PicoEvidence nextPicoEvidence() {
		if (picoEvidenceIterator.hasNext()) {
			PicoEvidence picoEvidence = picoEvidenceIterator.next();
			picoEvidence.setCitationKey(getCitationKey());
			return picoEvidence;
		} else {
			return null;
		}
	}

	public void cacheContent() {
		File file = new File(getPath());
		String filePath = file.getAbsolutePath();
		String content = Utilities.readFileToString(filePath);
		setContent(content);
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		if (content == null || content.equals("NA")) {
			cacheContent();
		}
		return content;
	}

	public void setSystematicReviewId(Integer systematicReviewId) {
		this.systematicReviewId = systematicReviewId;
	}

	public Integer getSystematicReviewId() {
		return systematicReviewId;
	}

	public void setCitationKey(String citationKey) {
		this.citationKey = citationKey;
	}

	public String getCitationKey() {
		return citationKey;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPartition(String partition) {
		this.partition = partition;
	}

	public String getPartition() {
		return partition;
	}

	public void setActualClassification(String actualClassification) {
		this.actualClassification = actualClassification;
	}

	public String getActualClassification() {
		return actualClassification;
	}

	public void setPredictedClassification(String predictedClassification) {
		this.predictedClassification = predictedClassification;
	}

	public String getPredictedClassification() {
		return predictedClassification;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getWeight() {
		return weight;
	}

	public Collection<PicoEvidence> getPicoEvidence() {
		return picoEvidence;
	}

	public void setPicoExtractor(PICOExtractor picoExtractor) {
		this.picoExtractor = picoExtractor;
	}

	public PICOExtractor getPicoExtractor() {
		return picoExtractor;
	}

	public String getLastRuleApplied() {
		return lastRuleApplied;
	}

	public void setLastRuleApplied(String lastRuleApplied) {
		this.lastRuleApplied = lastRuleApplied;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Citation\n ");
		sb.append("\tid: " + getId() + "\n");
		sb.append("\tcitationKey: " + getCitationKey() + "\n");
		sb.append("\tpartition: " + getPartition() + "\n");
		sb.append("\tactualClassification " + getActualClassification() + "\n");
		sb.append("\tpredictedClassification " + getPredictedClassification()
				+ "\n");
		return sb.toString();
	}
}
