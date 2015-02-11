package edu.pitt.dbmi.edda.rulebase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pitt.dbmi.edda.rulebase.document.Citation;

public class MentionEvidence extends ClassificationEvidence {
	
	private static final long serialVersionUID = 1L;
	
	private String mention;
	private final List<String> orEnds = new ArrayList<String>();

	public void setMention(String mention) {
		this.mention = mention;
	}

	public String getMention() {
		return mention;
	}
	
	public void addOrEnd(String orEnd) {
		orEnds.add(orEnd);
	}
	
	public void addSemiColonSeparatedOrEnds(String semiColonSeparatedOrEnds) {
		final String[] orEnds = semiColonSeparatedOrEnds.split(";");
		for (String orEnd : orEnds) {
			addOrEnd(orEnd);
		}
	}
	
	public void scoreWithCitation(Citation citation) {
		
		super.scoreWithCitation(citation);
		
		StringBuilder sb = new StringBuilder();
		for (String orEnd : orEnds) {
			if (sb.length()>0) {
				sb.append("|");
			}
			sb.append(orEnd);
		}
		
		int patternParams = Pattern.CASE_INSENSITIVE;
		patternParams |= Pattern.DOTALL;
		patternParams |= Pattern.MULTILINE;
		Pattern p = Pattern.compile(sb.toString(), patternParams);
		
		Matcher matcher = p.matcher(citation.getContent());
		int weight = 0;
		if (sb.toString().matches("plasmapheresis")) {
			System.out.println(sb.toString());
		}
		while (matcher.find()) {
			weight++;
		}
		setWeight(weight);
		if (weight > 0) {
			setPolarity("present");
		}
		else {
			setPolarity("absent");
		}
		if (sb.toString().matches("plasmapheresis")) {
			System.out.println("Polarity is " + getPolarity());
		}
	}
	
	protected String extractCitationSection(Citation citation) {
		return citation.getContent();
	}

}
