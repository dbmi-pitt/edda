/*
 *  Edda - RegExOpWorker
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

import com.rapidminer.example.ExampleSet;

import edu.pitt.dbmi.edda.operator.regexop.rank.RankerRegularExpression;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpressionList;

public class RegExOpWorker {
	
	private boolean isGeneratingDiagnostics = false;

	private ExampleSet outgoingExampleSet;
	
	private RegularExpressionList regularExpressions;

	private RankerRegularExpression rankerRegularExpression;

	public static void main(String[] args) {
		new RegExOpWorker();
	}

	public RegExOpWorker() {
		;
	}

	public void process() {
		if (isGeneratingDiagnostics()) {
			System.out.println("RegExOpWorker started.");
		}
		rankerRegularExpression.setRegularExpressions(regularExpressions) ;
		rankerRegularExpression.execute();
		AttributeBuilder attributeBuilder = establishAttributeBuilder(
				rankerRegularExpression);
		outgoingExampleSet = attributeBuilder.getExampleSet();
		if (isGeneratingDiagnostics()) {
			System.out.println("RegExOpWorker is done.");
		}
	}

	private AttributeBuilder establishAttributeBuilder(
			RankerRegularExpression rankerRegularExpression) {
		AttributeBuilder attributeBuilder = new AttributeBuilder();
		attributeBuilder.setGeneratingDiagnostics(isGeneratingDiagnostics());
		attributeBuilder.createAttributes(rankerRegularExpression);
		return attributeBuilder;
	}

	public void setRankerRegularExpression(
			RankerRegularExpression rankerRegularExpression) {
		this.rankerRegularExpression = rankerRegularExpression;
	}
	
	public RegularExpressionList getRegularExpressions() {
		return regularExpressions;
	}

	public void setRegularExpressions(RegularExpressionList regularExpressions) {
		this.regularExpressions = regularExpressions;
	}
	

	public ExampleSet getOutgoingExampleSet() {
		return outgoingExampleSet;
	}
	
	public boolean isGeneratingDiagnostics() {
		return isGeneratingDiagnostics;
	}

	public void setGeneratingDiagnostics(boolean isGeneratingDiagnostics) {
		this.isGeneratingDiagnostics = isGeneratingDiagnostics;
	}

	
}
