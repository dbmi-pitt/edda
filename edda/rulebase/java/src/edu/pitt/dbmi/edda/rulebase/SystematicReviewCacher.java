package edu.pitt.dbmi.edda.rulebase;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import edu.pitt.dbmi.edda.rulebase.document.Citation;

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

	private Citation citation;
	
	public SystematicReviewCacher() {
		;
	}
	
	public void classify() {
		
		
	}
	
	public void cache() {
		try {
			cacheReportAbsolutePath();
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
		return sb.toString();
	}


}
