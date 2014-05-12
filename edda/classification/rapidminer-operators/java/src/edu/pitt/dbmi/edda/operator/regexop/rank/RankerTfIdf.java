package edu.pitt.dbmi.edda.operator.regexop.rank;

import java.util.Iterator;
import java.util.TreeSet;

import edu.pitt.dbmi.edda.operator.regexop.Annotation;
import edu.pitt.dbmi.edda.operator.regexop.document.LabeledDocument;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpression;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpressionList;

public class RankerTfIdf extends RankerRegularExpression {
	//
	// Let 
	//     N = total number of documents;
	//     wtf = weighted term frequency;
	//     idf = inverse document frequency
	//
	//     wtf = { (1 + log tf) if tf > 0
	//                       0     otherwise
	//
	//      idf = log (N/(1 + df))
	//
	//      tfidf=wtf*idf
	//
	protected RankList rankDocument(LabeledDocument currentDocument,
			RegularExpressionList regularExpressions,
			TreeSet<Annotation> cumulativeAnnotations) {
		final RankList ranks =  RankListFactory.newRankerList();
		for (Iterator<RegularExpression> regExIterator = this.regularExpressions
				.iterator(); regExIterator.hasNext();) {
			RegularExpression regularExpression = regExIterator.next();
			final TreeSet<Annotation> annotsForThisRegEx = filterAnnotsForRegEx(
					regularExpression, cumulativeAnnotations);
			Rank rank = Rank.newRank(currentDocument, regularExpression);
			rank.value = (double) annotsForThisRegEx.size();
			ranks.add(rank);
		}
		return ranks;
	}
	
	protected void tallyRegExStatsOverDocumentSet() {
		Double inverseDocumentFrequency = 0.0d;
		for (Iterator<RegularExpression> regExIterator = this.regularExpressions
				.iterator(); regExIterator.hasNext();) {
			RegularExpression regularExpression = regExIterator.next();
			final RankList ranksForRegEx = this.ranks.getRanksFor(regularExpression);
			inverseDocumentFrequency = calculateInverseDocumentFrequency(
					ranksForRegEx, regularExpression);
			System.out.println("Inverse document freq for " + regularExpression.name + " = 	" + inverseDocumentFrequency);
			calculateTfIdf(inverseDocumentFrequency, ranksForRegEx);
		}
	}

	
	private void calculateTfIdf(Double inverseDocumentFrequency,
			RankList ranksForRegEx) {
		this.documentFetcher.startIteration();
		while (true) {
			LabeledDocument labeledDocument = this.documentFetcher.getNext();
			if (labeledDocument == null) {
				break;
			}
			RankList ranksForDocument = ranksForRegEx.getRanksFor(labeledDocument);
			ranksForDocument.iterate();
			while (ranksForDocument.hasNext()) {
				Rank rank = ranksForDocument.getNext();
				calculateWeightedTermFrequency(rank);
				rank.value *= inverseDocumentFrequency;
			}
		}
	}
	
	private void calculateWeightedTermFrequency(Rank rank) {
		if (rank.value > 0.0d) {
			Double logOfTermFrequency = Math.log10(rank.value);
			rank.value = 1.0d + logOfTermFrequency;
		} else {
			rank.value = 0.0d;
		}
	}

	private Double calculateInverseDocumentFrequency(
			RankList ranksForRegEx, RegularExpression currentRegularExpression) {
		Double documentFrequency = 0.0d;
		this.documentFetcher.startIteration();
		while (true) {
			LabeledDocument labeledDocument = this.documentFetcher.getNext();
			if (labeledDocument == null) {
				break;
			}
			final RankList ranksForDocument = ranksForRegEx.getRanksFor(labeledDocument);
			ranksForDocument.iterate();
			while (ranksForDocument.hasNext()) {
				Rank rank = ranksForDocument.getNext();
				if (rank.value > 0.0d) {
					documentFrequency++;
				}
				break;
			}	
		}
		System.out.println("The regular expression " + currentRegularExpression.name + " appears at least once in " + documentFrequency + " documents.");
		Double inverseDocumentFrequency = this.documentFetcher
				.getTotalNumberOfDocuments() / (1.0d + documentFrequency);
		inverseDocumentFrequency = Math.log10(inverseDocumentFrequency) ;
		return inverseDocumentFrequency;
	}

	

}
