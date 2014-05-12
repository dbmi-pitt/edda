/*
 *  RapidMiner
 *
 *  Copyright (C) 2001-2011 by Rapid-I and the contributors
 *
 *  Complete list of developers available at our web site:
 *
 *       http://rapid-i.com
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
 *  along with this program.  If not, see http://www.gnu.org/licenses/.
 */

package edu.pitt.dbmi.edda.operator.ldaop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.logging.Logger;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.Alphabet;
import cc.mallet.types.IDSorter;
import cc.mallet.types.LabelSequence;

import com.rapidminer.datatable.AbstractDataTable;
import com.rapidminer.datatable.DataTable;
import com.rapidminer.datatable.DataTableRow;
import com.rapidminer.gui.renderer.AbstractDataTableTableRenderer;
import com.rapidminer.operator.IOContainer;
import com.rapidminer.report.Tableable;

public class RendererPhi extends AbstractDataTableTableRenderer {
	
	private final static Logger logger = Logger.getLogger(RendererPhi.class .getName()); 

	public RendererPhi() {
		logger.fine("Constructed a " + getClass().getSimpleName());
	}
	
	@Override
	public String getName() {
		return "Phi Matrix";
	}

	private static class DataTablePhi extends AbstractDataTable
			implements Tableable {

		private ParallelTopicModel parallelTopicModel;

		private Alphabet alphabet;

		private LabelSequence labelSequence;

		private int numberOfRows = -1;
		private int numberOfCols = -1;
	
		private String[] colLabels;
		private final HashMap<String, Object> sparseFrequencies = new HashMap<String, Object>();
		private final HashMap<String, Object> sparseProbabilities = new HashMap<String, Object>();
		
		public DataTablePhi(String name,
				TopicModelAdapter topicModelAdapter) {
			super(name);
			parallelTopicModel = topicModelAdapter.getParallelTopicModel();
			alphabet = parallelTopicModel.getAlphabet();
			labelSequence = parallelTopicModel.getData().get(0).topicSequence;
			parallelTopicModel
					.getTopicProbabilities(labelSequence);
			numberOfRows = parallelTopicModel.getAlphabet().size();
			numberOfCols = parallelTopicModel.getNumTopics() + 1;

			colLabels = new String[numberOfCols];

			colLabels[0] = "word";
			for (int col = 1; col < numberOfCols; col++) {
				colLabels[col] = TopicModelUtils.buildColumnNameForTopic(col-1);
			}

			TreeSet<IDSorter> lexicallySortedWordsCumulative = sortAlphabetByWordOrder(parallelTopicModel
					.getSortedWords());
			fillColumnZeroWithAlphabetizedWords(lexicallySortedWordsCumulative) ;
			
			ArrayList<TreeSet<IDSorter>> topicSortedWords = parallelTopicModel.getSortedWords();
			for (int col = 1; col <= parallelTopicModel.getNumTopics(); col++) {
				TreeSet<IDSorter> lexicallySortedWordsInTopic = sortAlphabetByWordOrder(topicSortedWords.get(col-1));
				Iterator<IDSorter> iter1 = lexicallySortedWordsCumulative.iterator();
				Iterator<IDSorter> iter2 = lexicallySortedWordsInTopic.iterator();
				IDSorter pairOne = (iter1.hasNext()) ? iter1.next() : null;
				IDSorter pairTwo = (iter2.hasNext()) ? iter2.next() : null;
				int row = 0;
				while (pairOne != null && pairTwo != null) {
					String sOne = (String) alphabet.lookupObject(pairOne.getID());
					String sTwo = (String) alphabet.lookupObject(pairTwo.getID());
					if (sOne.equals(sTwo)) {
						String key = TopicModelUtils.buildKey(row, col);
						sparseFrequencies.put(key, pairTwo.getWeight());
						pairTwo = (iter2.hasNext()) ? iter2.next() : null;
					}
					pairOne =  (iter1.hasNext()) ? iter1.next() : null;
					row++;
				}
			}
			
			for (int col = 1; col < numberOfCols; col++) {
				Double totalFrequency = 0.0d;
				for (int row = 0 ; row < numberOfRows ; row++) {
					String key = TopicModelUtils.buildKey(row, col);
					Double frequency = (Double) sparseFrequencies.get(key);
					if (frequency != null) {
						totalFrequency += frequency;
					}
				}
				if (totalFrequency > 0.0d) {
					for (int row = 0 ; row < numberOfRows ; row++) {
						String key = TopicModelUtils.buildKey(row, col);
						Double frequency = (Double) sparseFrequencies.get(key);
						if (frequency != null) {
							Double probability = new Double(frequency / totalFrequency);
							sparseProbabilities.put(key, probability);
						}
					}
				}
			}

		}
		
		
		private String getFormattedProbabilityValueForKey(String key) {
			String result = "ERROR";
			Object valueAsObject = sparseProbabilities.get(key);
			if (valueAsObject == null) {
				valueAsObject = new Double(0.0d);
			}
			
			if (valueAsObject instanceof String) {
				result = (String) valueAsObject;
			}
			else if (valueAsObject instanceof Double) {
				Double valueAsDouble = (Double) valueAsObject;
				result = formatDoubleAsString(valueAsDouble);
			}
			
			return result;
			
		}

		private String formatDoubleAsString(Double valueAsDouble) {
			DecimalFormat formatter = new DecimalFormat("0.#####E0");
			return formatter.format(valueAsDouble);
		}


		private void fillColumnZeroWithAlphabetizedWords(
				TreeSet<IDSorter> lexicallySortedWords) {
			int row = 0;
			for (IDSorter idSorter : lexicallySortedWords) {
				String word = (String) alphabet.lookupObject(idSorter.getID());
				String key = TopicModelUtils.buildKey(row, 0);
				sparseFrequencies.put(key, word);
				sparseProbabilities.put(key, word);
				row++;
			}
		}

		private final Comparator<IDSorter> lexicalComparator = new Comparator<IDSorter>() {
			@Override
			public int compare(IDSorter o1, IDSorter o2) {
				Alphabet alphabet = parallelTopicModel.getAlphabet();
				String s1 = (String) alphabet.lookupObject(o1.getID());
				String s2 = (String) alphabet.lookupObject(o2.getID());
				return s1.compareTo(s2);
			}
		};
		
		public String getValueAsString(DataTableRow row, int column) {
			final double value = row.getValue(column);
			if (column == 0) {
				return mapIndex(column, (int)value);
			} else {
				return formatDoubleAsString(value);
			}
		}

		private TreeSet<IDSorter> sortAlphabetByWordOrder(
				TreeSet<IDSorter> topicSortedWords) {
			TreeSet<IDSorter> lexicallySortedWords = new TreeSet<IDSorter>(
					lexicalComparator);
			lexicallySortedWords.addAll(topicSortedWords);
			return lexicallySortedWords;
		}

		private TreeSet<IDSorter> sortAlphabetByWordOrder(
				ArrayList<TreeSet<IDSorter>> topicSortedWords) {
			TreeSet<IDSorter> lexicallySortedWords = new TreeSet<IDSorter>(
					lexicalComparator);
			for (int topicIndex = 0; topicIndex < parallelTopicModel
					.getNumTopics(); topicIndex++) {
				lexicallySortedWords.addAll(topicSortedWords.get(topicIndex));
			}
			return lexicallySortedWords;
		}

		@Override
		public void add(DataTableRow row) {
		}

		@Override
		public int getColumnIndex(String name) {
			int colIndex = 0;
			for (String colLabel : colLabels) {
				if (colLabel.equals(name)) {
					return colIndex;
				}
				colIndex++;
			}
			return -1;
		}

		@Override
		public double getColumnWeight(int i) {
			return 0.0d;
		}

		@Override
		public int getNumberOfColumns() {
			return numberOfCols;
		}

		@Override
		public int getNumberOfRows() {
			return numberOfRows;
		}

		@Override
		public int getNumberOfSpecialColumns() {
			return 0;
		}

		@Override
		public int getNumberOfValues(int column) {
			return getRowNumber();
		}

		@Override
		public DataTableRow getRow(final int index) {
			return new DataTableRow() {

				@Override
				public String getId() {
					return TopicModelUtils.formatIndex(index);
				}

				@Override
				public int getNumberOfValues() {
					return numberOfCols;
				}

				@Override
				public double getValue(int column) {
					if (column == 0) {
						return index;
					}
					else {
						String key = TopicModelUtils.buildKey(index, column);
						Double result = (Double) sparseProbabilities.get(key);
						if (result == null) {
							result = new Double(0.0d);
						}
					
						return result;
					}
					
				}
			};
		}

		@Override
		public boolean isDate(int index) {
			return false;
		}

		@Override
		public boolean isDateTime(int index) {
			return false;
		}

		@Override
		public boolean isNominal(int index) {
			return true;
		}

		@Override
		public boolean isNumerical(int index) {
			return false;
		}
		
		@Override
		public boolean isSpecial(int column) {
			return false;
		}

		@Override
		public boolean isSupportingColumnWeights() {
			return false;
		}

		@Override
		public boolean isTime(int index) {
			return false;
		}

		@Override
		public Iterator<DataTableRow> iterator() {
			return new Iterator<DataTableRow>() {

				private int rowIndex = 0;

				@Override
				public boolean hasNext() {
					return rowIndex < getNumberOfRows();
				}

				@Override
				public DataTableRow next() {
					DataTableRow row = getRow(this.rowIndex);
					this.rowIndex++;
					return row;
				}

				@Override
				public void remove() {
				}

			};
		}

		@Override
		public String mapIndex(int column, int index) {
			String result = "ERROR";
			String key = TopicModelUtils.buildKey(index, column);
			Object valueAsObject = sparseProbabilities.get(key);
			if (valueAsObject != null && valueAsObject instanceof String) {
				result = (String) valueAsObject;
			}
			return result;
		}

		@Override
		public int mapString(int column, String value) {
			return 0;
		}

		@Override
		public DataTable sample(int newSize) {
			return this;
		}

		@Override
		public String getCell(int row, int column) {
			String key = TopicModelUtils.buildKey(row, column);
			return getFormattedProbabilityValueForKey(key);
		}

		@Override
		public String getColumnName(int index) {
			return colLabels[index];
		}

		@Override
		public boolean isFirstColumnHeader() {
			return false;
		}

		@Override
		public boolean isFirstLineHeader() {
			return false;
		}

		@Override
		public void prepareReporting() {
		}
	}

	@Override
	public DataTable getDataTable(Object renderable, IOContainer ioContainer,
			boolean isRendering) {
		return new DataTablePhi("Phi",
				(TopicModelAdapter) renderable);
	}

}
