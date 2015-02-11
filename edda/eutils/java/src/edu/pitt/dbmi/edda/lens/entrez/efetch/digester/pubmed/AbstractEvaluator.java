package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import java.util.Collection;

public class AbstractEvaluator {

	private boolean hasAbstract = false;
	private boolean hasNoAbstract = false;
	private boolean hasUnstructuredAbstract = false;
	private boolean hasStructuredAbstract = false;

	private int numberWithAbstracts;
	private int numberWithNoAbstracts;
	private int numberWithStructuredAbstracts;
	private int numberWithUnstructuredAbstracts;

	public void evaluate(PubmedArticle pubmedArticle) {
		clearCache();
		if (pubmedArticle.getArticleAbstract() != null) {
			hasAbstract = true;
			Collection<AbstractText> abstractTexts = pubmedArticle
					.getArticleAbstract().getAbstractTexts();
			if (abstractTexts != null && abstractTexts.size() > 1) {
				hasStructuredAbstract = true;
			} else {
				hasUnstructuredAbstract = true;
			}
		} else {
			hasNoAbstract = true;
		}

		numberWithAbstracts = hasAbstract() ? numberWithAbstracts + 1
				: numberWithAbstracts;
		numberWithStructuredAbstracts = hasStructuredAbstract() ? numberWithStructuredAbstracts + 1
				: numberWithStructuredAbstracts;
		numberWithUnstructuredAbstracts = hasUnstructuredAbstract() ? numberWithUnstructuredAbstracts + 1
				: numberWithUnstructuredAbstracts;
		numberWithNoAbstracts = hasNoAbstract() ? numberWithNoAbstracts + 1
				: numberWithNoAbstracts;
	}

	private void clearCache() {
		hasAbstract = false;
		hasNoAbstract = false;
		hasUnstructuredAbstract = false;
		hasStructuredAbstract = false;
	}

	public boolean hasAbstract() {
		return hasAbstract;
	}

	public void setHasAbstract(boolean hasAbstract) {
		this.hasAbstract = hasAbstract;
	}

	public boolean hasUnstructuredAbstract() {
		return hasUnstructuredAbstract;
	}

	public void setHasUnstructuredAbstract(boolean hasUnstructuredAbstract) {
		this.hasUnstructuredAbstract = hasUnstructuredAbstract;
	}

	public boolean hasStructuredAbstract() {
		return hasStructuredAbstract;
	}

	public void setHasStructuredAbstract(boolean hasStructuredAbstract) {
		this.hasStructuredAbstract = hasStructuredAbstract;
	}

	public boolean hasNoAbstract() {
		return hasNoAbstract;
	}

	public void setHasNoAbstract(boolean hasNoAbstract) {
		this.hasNoAbstract = hasNoAbstract;
	}

	public int getNumberWithAbstracts() {
		return numberWithAbstracts;
	}

	public int getNumberWithNoAbstracts() {
		return numberWithNoAbstracts;
	}

	public int getNumberWithStructuredAbstracts() {
		return numberWithStructuredAbstracts;
	}

	public int getNumberWithUnstructuredAbstracts() {
		return numberWithUnstructuredAbstracts;
	}

	public String toString() {
		return String
				.format("hasAbstract=%s,isStructured=%s,isUnstructured=%s,hasNoAbstract=%s%n",
						hasAbstract(), hasStructuredAbstract(),
						hasUnstructuredAbstract(), hasNoAbstract());
	}

}
