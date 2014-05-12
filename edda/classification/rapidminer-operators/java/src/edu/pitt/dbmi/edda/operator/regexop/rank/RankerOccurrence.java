package edu.pitt.dbmi.edda.operator.regexop.rank;

import java.util.Iterator;
import java.util.TreeSet;

import edu.pitt.dbmi.edda.operator.regexop.Annotation;
import edu.pitt.dbmi.edda.operator.regexop.document.LabeledDocument;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpression;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpressionList;

public class RankerOccurrence extends RankerRegularExpression {

	protected RankList rankDocument(LabeledDocument currentDocument,
			RegularExpressionList regularExpressions, TreeSet<Annotation> cumulativeAnnotations) {
		final RankList ranks =  RankListFactory.newRankerList();;
		for (Iterator<RegularExpression> regExIterator = this.regularExpressions.iterator(); regExIterator.hasNext();) {
			RegularExpression regularExpression = regExIterator.next();
			final TreeSet<Annotation> annotsForThisRegEx = filterAnnotsForRegEx(regularExpression, cumulativeAnnotations) ;
			Rank rank = Rank.newRank(currentDocument, regularExpression);
			rank.value = (double) annotsForThisRegEx.size();
			ranks.add(rank) ;
		}
		return ranks;
	}

	protected void tallyRegExStatsOverDocumentSet() {
		; 
	}

	
}
