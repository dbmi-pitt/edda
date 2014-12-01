package edu.pitt.dbmi.edda.rulebase;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class SystematicReviewCache {

	private String excludeTrainPath = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output\\5050_2xTitles\\TRAIN_data\\FULL_N_train";
	private String includeTrainPath = "T:\\EDDA\\DATA\\ORGAN_TRANSPLANT\\ReferenceFiler_Output\\5050_2xTitles\\TRAIN_data\\FULL_Y_train";

	private String reportPath = "NA";
	private String studyDesign = "NA";
	private String publicationType = "NA";
	private String outComePopulation = "NA";
	private String interventionComparator = "NA";
	private String reportText = "NA";

	public SystematicReviewCache() {
		;
	}

	public void cache() {
		try {
			File report = new File(excludeTrainPath + File.separator
					+ reportPath);
			if (!report.exists()) {
				report = new File(includeTrainPath + File.separator
						+ reportPath);
			}
			if (report.exists()) {
				setReportText(FileUtils.readFileToString(report));
			}
		} catch (Exception x) {
			x.printStackTrace();
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

	public String getReportText() {
		return reportText;
	}

	public void setReportText(String reportText) {
		if (!StringUtils.isEmpty(reportText)) {
			this.reportText = reportText;
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getName() + ":\n");
		sb.append("\tReportPath: " + getReportPath() + "\n");
		sb.append("\tpublicationType: " + getPublicationType() + "\n");
		sb.append("\tstudyDesign: " + getStudyDesign() + "\n");
		sb.append("\toutcomePopulation: " + getOutComePopulation() + "\n");
		sb.append("\tinterventionComparator: " + getInterventionComparator()
				+ "\n");
		String reportText = getReportText();
		reportText = reportText.substring(0, Math.min(20, reportText.length()));
		sb.append("\treportText: " + reportText  + "\n");
		return sb.toString();
	}

}
