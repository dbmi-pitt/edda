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

import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.topics.TopicInferencer;
import cc.mallet.types.Instance;
import cc.mallet.types.LabelSequence;

import com.rapidminer.datatable.AbstractDataTable;
import com.rapidminer.datatable.DataTable;
import com.rapidminer.datatable.DataTableRow;
import com.rapidminer.gui.renderer.AbstractDataTableTableRenderer;
import com.rapidminer.operator.IOContainer;
import com.rapidminer.report.Tableable;

public class RendererTheta extends AbstractDataTableTableRenderer {
	
	private final static Logger logger = Logger.getLogger(RendererTheta.class .getName()); 

	public RendererTheta() {
		logger.fine("Constructed a " + getClass().getSimpleName());
	}

	@Override
	public String getName() {
		return "Theta Matrix";
	}

	private static class DataTableTheta extends AbstractDataTable
			implements Tableable {

		private ParallelTopicModel parallelTopicModel;

		private LabelSequence labelSequence;
		
		private int numberOfRows = -1;
		private int numberOfCols = -1;

		private String[] colLabels;
		private final HashMap<String, Object> sparseValues = new HashMap<String, Object>();
		
		public DataTableTheta(String name,
				TopicModelAdapter topicModelAdapter) {
			super(name);
			parallelTopicModel = topicModelAdapter.getParallelTopicModel();
			labelSequence = parallelTopicModel.getData().get(0).topicSequence;
			parallelTopicModel
					.getTopicProbabilities(labelSequence);
			numberOfRows = parallelTopicModel.getData().size();
			numberOfCols = parallelTopicModel.getNumTopics() + 1;

			colLabels = new String[numberOfCols];

			colLabels[0] = "document";
			for (int col = 1; col < numberOfCols; col++) {
				colLabels[col] = TopicModelUtils.buildColumnNameForTopic(col-1);
			}
			
			for (int row = 0 ; row < numberOfRows ; row++) {
				String key = TopicModelUtils.buildKey(row, 0);
				sparseValues.put(key, new Integer(row));
				TopicInferencer inferencer = parallelTopicModel.getInferencer();
				Instance instance =  parallelTopicModel.getData().get(row).instance;
				final double[] topicProbabilities = TopicModelUtils.inferTopicForInstance(inferencer, instance, false);
				for (int col = 1 ; col < numberOfCols ; col++) {
					double topicProbability = topicProbabilities[col-1];
					if (topicProbability > 0.0d) {
						key = TopicModelUtils.buildKey(row, col);
						sparseValues.put(key, new Double(topicProbability));
					}
				}
			}
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
						Double result = (Double) sparseValues.get(key);
						if (result == null) {
							result = 0.0d;
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
			return false;
		}

		@Override
		public boolean isNumerical(int index) {
			return index >= 0;
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
			String key = TopicModelUtils.buildKey(index, column);
			Object value = sparseValues.get(key);
			String result = "Empty";
			if (value != null) {
				result = String.valueOf(value);
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
			Object value = sparseValues.get(key);
			String result = "Empty";
			if (value != null) {
				result = String.valueOf(value);
			}
			return result;
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
		return new DataTableTheta("Theta",
				(TopicModelAdapter) renderable);
	}

}
