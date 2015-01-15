package edu.pitt.dbmi.edda.rulebase.section;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.edda.rulebase.MentionEvidence;
import edu.pitt.dbmi.edda.rulebase.document.Citation;

public class AbstractEvidence extends MentionEvidence {

	private static final long serialVersionUID = 1L;
	
	protected String extractCitationSection(Citation citation) {
		String content = citation.getContent();
		Pattern pattern = Pattern.compile("^\\s*AB\\s*-(.*)$");
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			content = matcher.group(1);
		}
		else {
			content = "";
		}
		return content;
	}
	
	

}

