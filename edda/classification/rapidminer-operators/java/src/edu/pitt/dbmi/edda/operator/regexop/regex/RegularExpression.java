/*
 *  Edda - RegularExpression
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

import java.io.Serializable;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class RegularExpression implements Serializable {
	private static final long serialVersionUID = 6798327455130496093L;
	public String name;
	public String value;
	public Boolean isActive = true;
	public Pattern pattern;
	public Integer regularExpressionNumber;
	public String key;
	public RegularExpression(String name, String value, int regularExpressionNumber) {
		this.name = name;
		this.value = value;
		this.regularExpressionNumber = regularExpressionNumber;
		this.key = ":" + StringUtils.leftPad(regularExpressionNumber+"", 10, "0");
/* @todo
 * 	Add regex parameters into UI
 */
//		this.pattern = Pattern.compile(value, Pattern.DOTALL
//				| Pattern.CASE_INSENSITIVE);
		this.pattern = Pattern.compile(value, Pattern.DOTALL);
	}
}
