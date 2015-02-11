/*
 *  Edda - AttributeBuilder
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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.table.AttributeFactory;
import com.rapidminer.example.table.DataRow;
import com.rapidminer.example.table.DataRowFactory;
import com.rapidminer.example.table.MemoryExampleTable;
import com.rapidminer.tools.Ontology;

import edu.pitt.dbmi.edda.operator.regexop.document.DocumentFetcher;
import edu.pitt.dbmi.edda.operator.regexop.document.LabeledDocument;
import edu.pitt.dbmi.edda.operator.regexop.rank.Rank;
import edu.pitt.dbmi.edda.operator.regexop.rank.RankList;
import edu.pitt.dbmi.edda.operator.regexop.rank.RankerRegularExpression;
import edu.pitt.dbmi.edda.operator.regexop.regex.RegularExpression;

public class AttributeBuilder {
	
	private RankerRegularExpression rankerRegularExpression;
	
	private boolean isGeneratingDiagnostics = false;

	private final List<Attribute> attributes = new LinkedList<Attribute>();

	private Attribute outgoingLabelAttribute;
	protected Attribute filePathAttribute;

	private MemoryExampleTable memoryExampleTable;
	
	private DataRowFactory factory;

	private ExampleSet exampleSet;

	public AttributeBuilder() {
	}
	
	public void createAttributes(RankerRegularExpression rankerRegularExpression) {
		this.rankerRegularExpression = rankerRegularExpression;
		initializeTableBuilding();
		traverseDocumentsWhileFillingTableColumns();
		exampleSet = memoryExampleTable.createExampleSet(outgoingLabelAttribute);
		if (isGeneratingDiagnostics) {
			System.out.println("Finished generating ExampleSet. ");
		}
	}
	
	private void traverseDocumentsWhileFillingTableColumns() {
		DocumentFetcher documentFetcher = rankerRegularExpression
				.getDocumentFetcher();
		if (isGeneratingDiagnostics()) {
			System.out.println("Attribute Builder: building a matrix " + documentFetcher.getTotalNumberOfDocuments() + " x " + memoryExampleTable.getNumberOfAttributes());
		}
		documentFetcher.startIteration();
		int numberOfRowsAdded = 0;
		while (true) {
			LabeledDocument currentDocument = documentFetcher.getNext();
			if (currentDocument == null) {
				break;
			}
			DataRow row = populateRegExRowForDocument(currentDocument);
			memoryExampleTable.addDataRow(row);
			if (isGeneratingDiagnostics()) {
				System.out.println("Added row " + numberOfRowsAdded);
			}
			numberOfRowsAdded++;
			
		}
	}

	private void initializeTableBuilding() {
		clearAttributes();
		buildOutgoingLabelAttribute();
		buildFilePathAttribute();
		buildMemoryTable();
		buildDataRowFactory();
	}
	
	private void buildOutgoingLabelAttribute() {
		this.outgoingLabelAttribute = AttributeFactory.createAttribute("label",
				Ontology.BINOMINAL);

	}
	
	protected void buildFilePathAttribute() {
		filePathAttribute = AttributeFactory.createAttribute(RegExOperator.METADATA_PATH,
				Ontology.POLYNOMINAL);
	}
	
	private void clearAttributes() {
		attributes.clear();
	}
	
	private void buildMemoryTable() {
		attributes.add(outgoingLabelAttribute);
		attributes.add(filePathAttribute);
		for (Iterator<RegularExpression> regExIterator = rankerRegularExpression
				.getRegularExpressions().iterator(); regExIterator.hasNext();) {
			RegularExpression regularExpression = regExIterator.next();
			attributes.add(AttributeFactory.createAttribute(
					regularExpression.name, Ontology.REAL));
		}
		memoryExampleTable = new MemoryExampleTable(attributes);
	}
	
	private void buildDataRowFactory() {
		factory = new DataRowFactory(
				DataRowFactory.TYPE_DOUBLE_ARRAY, '.');
	}

	private DataRow populateRegExRowForDocument(LabeledDocument currentDocument) {
		DataRow row = factory.create(memoryExampleTable.getNumberOfAttributes());
		int jdx = 2;
		boolean isFirst = true;
		final RankList rankList = rankerRegularExpression.getRanks();
		for (Iterator<RegularExpression> regExIterator = rankerRegularExpression
				.getRegularExpressions().iterator(); regExIterator
				.hasNext();) {
			RegularExpression currentRegularExpression = regExIterator
					.next();
			Rank rank = rankList.getRankFor(currentDocument,
					currentRegularExpression);
			if (isFirst) {
				String label = rank.labeledDocument.label;
				row.set(outgoingLabelAttribute, outgoingLabelAttribute
						.getMapping().mapString(label));
				row.set(filePathAttribute, filePathAttribute
						.getMapping().mapString(currentDocument.file.getAbsolutePath()));
				isFirst = false;
			}
			Attribute currentAttribute = attributes.get(jdx);
			row.set(currentAttribute, rank.value);
			jdx++;
		}
		return row;
	}
	
	public ExampleSet getExampleSet() {
		return this.exampleSet;
	}

	public void setExampleSet(ExampleSet exampleSet) {
		this.exampleSet = exampleSet;
	}
	
	public boolean isGeneratingDiagnostics() {
		return isGeneratingDiagnostics;
	}

	public void setGeneratingDiagnostics(boolean isGeneratingDiagnostics) {
		this.isGeneratingDiagnostics = isGeneratingDiagnostics;
	}

}
