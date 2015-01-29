/*
 *  Edda - Rank
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

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;

import edu.pitt.dbmi.edda.operator.regexop.document.LabeledDocument;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpression;

public class Rank implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Integer nextRankNumber = 0 ;
	public static Rank newRank(LabeledDocument labeledDocument, RegularExpression regularExpression) {
		Rank rank = new Rank(nextRankNumber++);
		rank.labeledDocument = labeledDocument;
		rank.regularExpression = regularExpression;
		rank.key = "";
		rank.key += StringUtils.leftPad(labeledDocument.documentNumber+"", 10, "0");
		rank.key += ":" ;
		rank.key += StringUtils.leftPad(regularExpression.regularExpressionNumber+"", 10, "0");
		return rank;
	}
	public Integer rankNumber;
	public LabeledDocument labeledDocument;
	public RegularExpression regularExpression;
	public Double value = 0.0d;
	public String key;
	private Rank(Integer rankNumber) {
		this.rankNumber = rankNumber;
	}
	public static Comparator<Rank> defaultRankComparator = new Comparator<Rank>() {
		public int compare(Rank rankOne, Rank rankTwo) {
			if (rankOne.labeledDocument.documentNumber < rankTwo.labeledDocument.documentNumber) {
				return -1;
			}
			else if (rankOne.labeledDocument.documentNumber > rankTwo.labeledDocument.documentNumber) {
				return 1;
			}
			else {
				return rankOne.regularExpression.name.compareTo(rankTwo.regularExpression.name) ;
			}
		} };
	
	
}
