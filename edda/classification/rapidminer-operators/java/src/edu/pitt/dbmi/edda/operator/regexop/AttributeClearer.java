/*
 *  Edda - AttributeClearer
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

import java.util.ArrayList;
import java.util.Iterator;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.table.AbstractAttribute;

public class AttributeClearer {

	private ExampleSet exampleSet;

	public AttributeClearer() {
		;
	}

	public void clearExistingRegularAttributes() {
		final ArrayList<Attribute> existingRegularAttributes = new ArrayList<Attribute>();
		Iterator<Attribute> attributeIterator = this.exampleSet
				.getAttributes().iterator();
		while (attributeIterator.hasNext()) {
			AbstractAttribute attr = (AbstractAttribute) attributeIterator
					.next();
			existingRegularAttributes.add(attr);
		}
		for (Attribute attr : existingRegularAttributes) {
			for (Example example : this.exampleSet) {
				example.remove(attr);
			}
		}
	}

	public ExampleSet getExampleSet() {
		return this.exampleSet;
	}

	public void setExampleSet(ExampleSet exampleSet) {
		this.exampleSet = exampleSet;
	}

}
