/*
 *  Edda - RegularExpressionListRenderer
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
import java.util.Iterator;

import com.rapidminer.datatable.AbstractDataTable;
import com.rapidminer.datatable.DataTable;
import com.rapidminer.datatable.DataTableRow;
import com.rapidminer.gui.renderer.AbstractDataTableTableRenderer;
import com.rapidminer.operator.IOContainer;
import com.rapidminer.report.Tableable;

public class RegularExpressionListRenderer extends AbstractDataTableTableRenderer {

	private static class RegularExpressionListDataTable extends AbstractDataTable implements Tableable {

		private RegularExpressionList regularExpressionList;

		public RegularExpressionListDataTable(String name, RegularExpressionList regularExpressionList) {
			super(name);
			this.regularExpressionList = regularExpressionList;
		}

		@Override
		public void add(DataTableRow row) {
		}

		@Override
		public int getColumnIndex(String name) {

			return 0;
		}

		@Override
		public double getColumnWeight(int i) {
			return 0;
		}

		@Override
		public int getNumberOfColumns() {
			return 2;
		}

		@Override
		public int getNumberOfRows() {
			return regularExpressionList.size();
		}

		@Override
		public int getNumberOfSpecialColumns() {
			return 0;
		}

		@Override
		public int getNumberOfValues(int column) {
			if (column == 0)
				return getRowNumber();
			return -1;
		}

		@Override
		public DataTableRow getRow(final int index) {
			return new DataTableRow() {
				@Override
				public String getId() {
					ArrayList<RegularExpression> regularExpressions = (ArrayList<RegularExpression>) regularExpressionList.getRegularExpressions() ;
					return regularExpressions.get(index).name;
				}

				@Override
				public int getNumberOfValues() {
					return 2;
				}

				@Override
				public double getValue(int column) {
					switch (column) {
					case 0:
						return index;
					case 1:
						return index;
					default:
						return index;
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
			return index == 0 || index == 1;
		}

		@Override
		public boolean isNumerical(int index) {
			return true;
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
				public void remove() {}
			};
		}

		@Override
		public String mapIndex(int column, int index) {
			ArrayList<RegularExpression> regularExpressions = (ArrayList<RegularExpression>) regularExpressionList.getRegularExpressions() ;
			if (column == 0)
				return regularExpressions.get(index).name;
			if (column == 1)
				return regularExpressions.get(index).value;
			return "";
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
			ArrayList<RegularExpression> regularExpressions = (ArrayList<RegularExpression>) regularExpressionList.getRegularExpressions() ;
			switch (column) {
			case 0:
				return regularExpressions.get(row).name;
			case 1:
				return regularExpressions.get(row).value;
			default:
				return "Unknown";
			}
		}

		@Override
		public String getColumnName(int index) {
			switch (index) {
			case 0:
				return "Name";
			case 1:
				return "Regular Expression";
			default:
				return "Unknown";
			}
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
	public DataTable getDataTable(Object renderable, IOContainer ioContainer, boolean isRendering) {
		return new RegularExpressionListDataTable("Regular Expression List", (RegularExpressionList) renderable);
	}

}
