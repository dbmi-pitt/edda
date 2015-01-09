package edu.pitt.dbmi.edda.rulebase.pico;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import edu.pitt.dbmi.edda.rulebase.ClassificationEvidence;

public class PicoEvidence extends ClassificationEvidence {

	private static final long serialVersionUID = 1L;

	protected String pico
	protected HashSet<String> termSet = new HashSet<String>();

	public PicoEvidence() {
	}

	public void addSemiColonDeliminatedTermList(
			String semiColonDelimitedTermList) {
		if (!StringUtils.isEmpty(semiColonDelimitedTermList)
				&& !semiColonDelimitedTermList.equalsIgnoreCase("NA")) {
			String[] terms = semiColonDelimitedTermList.split(";");
			for (String term : terms) {
				String trimmedTerm = StringUtils.trimToEmpty(term);
				trimmedTerm = trimmedTerm.toLowerCase();
				if (!StringUtils.isEmpty(trimmedTerm)) {
					termSet.add(trimmedTerm);
				}
			}
		}
	}

	public void scoreCitation(String citationText) {
		category = 0;
		weight = 0;
		for (String term : termSet) {
			String regex = "\\b" + term + "\\b";
			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(citationText);
			if (matcher.find()) {
				category = 1;
				weight = new Integer(weight.intValue() + 1);
			}
			while (matcher.find()) {
				weight = new Integer(weight.intValue() + 1);
			}
		}
	}

	public Integer getCitationId() {
		return citationId;
	}

	public void setCitationId(Integer citationId) {
		this.citationId = citationId;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		for (String term : termSet) {
			sb.append("\t\t" + term + "\n");
		}
		return sb.toString();
	}

}
