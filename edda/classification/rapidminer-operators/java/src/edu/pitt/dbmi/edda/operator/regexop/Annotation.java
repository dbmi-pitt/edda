/*
 *  Edda - Annotation
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
package edu.pitt.dbmi.edda.operator.regexop;

import java.util.Comparator;

public class Annotation {
	public String kind;
	public Long sPos;
	public Long ePos;
	public String str;

	public boolean subsumes(Annotation annotation) {
		if (this.sPos < annotation.sPos && this.ePos > annotation.ePos) {
			return true;
		} else {
			return false;
		}
	}

	public static Comparator<Annotation> annotationComparator = new Comparator<Annotation>() {
		public int compare(Annotation annotationOne, Annotation annotationTwo) {
			int retValue = -1;
			Long offset = annotationOne.sPos - annotationTwo.sPos;
			if (offset < 0) {
				retValue = -1;
			} else if (offset > 0) {
				retValue = 1;
			} else { // sPos are the same; keep the longest
				offset = annotationOne.ePos - annotationTwo.ePos;
				if (offset > 0) {
					retValue = -1;
				} else if (offset < 0) {
					retValue = 1;
				} else {
					if (annotationOne.equals(annotationTwo)) {
						retValue = 0;
					}
					else {
						retValue = -1;
					}
					
				}
			}
			return retValue;
		}
	};

	public String toString() {
		return kind + "{" + sPos + "," + ePos + "} = " + str;
	}
}
