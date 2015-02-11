/*
 *  Edda - RegularExpressionList
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
package edu.pitt.dbmi.edda.operator.regexop.regex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.rapidminer.operator.ResultObjectAdapter;

public class RegularExpressionList extends ResultObjectAdapter {
	
	private static final long serialVersionUID = -8986279540182463880L;
	
	private final ArrayList<RegularExpression> regularExpressions = new ArrayList<RegularExpression>() ;

	public void add(RegularExpression regularExpression) {
		this.regularExpressions.add(regularExpression) ;
	}
	
	public boolean remove(RegularExpression regularExpression) {
		return this.regularExpressions.remove(regularExpression) ;
	}
	
	public void addAll(RegularExpressionList regularExpressionList) {
		this.regularExpressions.addAll(regularExpressionList.getRegularExpressions()) ;
	}
	
	public void removeAll(RegularExpressionList regularExpressionList) {
		this.regularExpressions.removeAll(regularExpressionList.getRegularExpressions()) ;
	}

	public Collection<RegularExpression> getRegularExpressions() {
		return this.regularExpressions;
	}
	
	public Iterator<RegularExpression> iterator() {
		return this.regularExpressions.iterator();
	}
	
	public int size() {
		return this.regularExpressions.size();
	}
	
	public void clear() {
		regularExpressions.clear();
	}
}
