package edu.pitt.dbmi.edda.operator.ldaop;

import java.awt.Color;

import com.rapidminer.gui.tools.CellColorProvider;
import com.rapidminer.gui.tools.ExtendedJTable;
import com.rapidminer.gui.tools.SwingTools;

public class TopicModelTableViewer extends ExtendedJTable {

	private static final int MAXIMAL_CONTENT_LENGTH = 200;

	private static final long serialVersionUID = 5535239693801265693L;

	public TopicModelTableViewer() {
		setAutoResizeMode(AUTO_RESIZE_OFF);
		setFixFirstColumnForRearranging(true);
	}

	public void setTopicModelAdapter(TopicModelAdapter topicModelAdapter) {
		setModel(new TopicModelViewerTableModel(topicModelAdapter));
		setCellColorProvider(new CellColorProvider() {
			public Color getCellColor(int row, int column) {
				if (row % 2 == 0) {
					return Color.WHITE;
				} else {
					return SwingTools.LIGHTEST_BLUE;
				}
			}
		});
		setCutOnLineBreak(true);
		setMaximalTextLength(MAXIMAL_CONTENT_LENGTH);
	}

}
