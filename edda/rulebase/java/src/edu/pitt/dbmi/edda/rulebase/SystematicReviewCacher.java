package edu.pitt.dbmi.edda.rulebase;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import edu.pitt.dbmi.edda.rulebase.document.Citation;
import edu.pitt.dbmi.edda.rulebase.pico.InterventionComparator;
import edu.pitt.dbmi.edda.rulebase.pico.OutcomePopulation;
import edu.pitt.dbmi.edda.rulebase.pico.PublicationType;
import edu.pitt.dbmi.edda.rulebase.pico.StudyDesign;

public class SystematicReviewCacher {

	private String excludeTrainPath = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output\\5050_2xTitles\\TRAIN_data\\FULL_N_train";
	private String includeTrainPath = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output\\5050_2xTitles\\TRAIN_data\\FULL_Y_train";
	private String excludeTestPath = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output\\5050_2xTitles\\TEST_data\\FULL_N_train";
	private String includeTestPath = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output\\5050_2xTitles\\TEST_data\\FULL_Y_train";
	
	private transient String reportPath = "NA";
	private transient String studyDesign = "NA";
	private transient String publicationType = "NA";
	private transient String outComePopulation = "NA";
	private transient String interventionComparator = "NA";

	private final StudyDesign cachedStudyDesign = new StudyDesign();
	private final PublicationType cachedPublicationType = new PublicationType();
	private final OutcomePopulation cachedOutcomePopulation = new OutcomePopulation();
	private final InterventionComparator cachedInterventionComparator = new InterventionComparator();

	private Citation citation;
	
	public SystematicReviewCacher() {
		;
	}
	
	public void classify() {
		cachedStudyDesign.scoreCitation(citation.getContent());
		cachedPublicationType.scoreCitation(citation.getContent());
		cachedOutcomePopulation.scoreCitation(citation.getContent());
		cachedInterventionComparator.scoreCitation(citation.getContent());
		
	}
	
	public void cache() {
		try {
			cacheReportAbsolutePath();
			cachedStudyDesign.addSemiColonDeliminatedTermList(studyDesign);
			cachedPublicationType.addSemiColonDeliminatedTermList(publicationType);
			cachedOutcomePopulation.addSemiColonDeliminatedTermList(outComePopulation);
			cachedInterventionComparator.addSemiColonDeliminatedTermList(interventionComparator);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
	
	public void reset() {
		reportPath = "NA";
		studyDesign = "NA";
		publicationType = "NA";
		outComePopulation = "NA";
		interventionComparator = "NA";
	}

	private void cacheReportAbsolutePath() {
		File report = new File(excludeTrainPath + File.separator
				+ reportPath);
		if (!report.exists()) {
			report = new File(includeTrainPath + File.separator
					+ reportPath);
		}
		if (!report.exists()) {
			report = new File(excludeTestPath + File.separator
					+ reportPath);
		}
		if (!report.exists()) {
			report = new File(includeTestPath + File.separator
					+ reportPath);
		}
		if (report.exists()) {
			setReportPath(report.getAbsolutePath());
		}
	}

	public String getReportPath() {
		return reportPath;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public String getStudyDesign() {
		return studyDesign;
	}

	public void setStudyDesign(String studyDesign) {
		if (!StringUtils.isEmpty(studyDesign)) {
			this.studyDesign = studyDesign;
		}
	}

	public String getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(String publicationType) {
		if (!StringUtils.isEmpty(publicationType)) {
			this.publicationType = publicationType;
		}
	}

	public String getOutComePopulation() {
		return outComePopulation;
	}

	public void setOutComePopulation(String outComePopulation) {
		if (!StringUtils.isEmpty(outComePopulation)) {
			this.outComePopulation = outComePopulation;
		}
	}

	public String getInterventionComparator() {
		return interventionComparator;
	}

	public void setInterventionComparator(String interventionComparator) {
		if (!StringUtils.isEmpty(interventionComparator)) {
			this.interventionComparator = interventionComparator;
		}
	}

	public StudyDesign getCachedStudyDesign() {
		return cachedStudyDesign;
	}

	public PublicationType getCachedPublicationType() {
		return cachedPublicationType;
	}

	public OutcomePopulation getCachedOutcomePopulation() {
		return cachedOutcomePopulation;
	}

	public InterventionComparator getCachedInterventionComparator() {
		return cachedInterventionComparator;
	}
	
	public Citation getCitation() {
		return citation;
	}

	public void setCitation(Citation citation) {
		this.citation = citation;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getName() + ":\n");
		sb.append("\tReportPath: " + getReportPath() + "\n");
		sb.append("\tpublicationType: " + getCachedPublicationType() + "\n");
		sb.append("\tstudyDesign: " + getCachedStudyDesign() + "\n");
		sb.append("\toutcomePopulation: " + getCachedOutcomePopulation() + "\n");
		sb.append("\tinterventionComparator: " + getCachedInterventionComparator()
				+ "\n");
		return sb.toString();
	}


}
