/*
 *  Edda - RankerFrequency
 *
 *  Copyright (C) 2013 by Univesity of Pittsburgh DBMI Edda Project.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with RapidMiner.  If not, see http://www.gnu.org/licenses/.
 */
package edu.pitt.dbmi.edda.operator.regexop.rank;

import java.util.Iterator;
import java.util.TreeSet;

import edu.pitt.dbmi.edda.operator.regexop.Annotation;
import edu.pitt.dbmi.edda.operator.regexop.document.LabeledDocument;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpression;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpressionList;

public class RankerFrequency extends RankerRegularExpression {

	protected RankList rankDocument(LabeledDocument currentDocument,
			RegularExpressionList regularExpressions, TreeSet<Annotation> cumulativeAnnotations) {
		final RankList ranks = RankListFactory.newRankerList();
		for (Iterator<RegularExpression> regExIterator = this.regularExpressions.iterator(); regExIterator.hasNext();) {
			RegularExpression regularExpression = regExIterator.next();
			final TreeSet<Annotation> annotsForThisRegEx = filterAnnotsForRegEx(regularExpression, cumulativeAnnotations) ;
			Rank rank = Rank.newRank(currentDocument, regularExpression);
			rank.value = (double) annotsForThisRegEx.size();
			rank.value /= currentDocument.numberOfSpaceTokens;
			ranks.add(rank) ;
		}
		return ranks;
	}

	protected void tallyRegExStatsOverDocumentSet() {
		; 
	}

	
}
