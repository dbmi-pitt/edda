package edu.pitt.dbmi.edda.operator.ldaop;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.rapidminer.gui.tools.ExtendedJScrollPane;
import com.rapidminer.gui.tools.ViewToolBar;
import com.rapidminer.report.Tableable;

public class TopicModelViewer extends JPanel implements Tableable {

    private static final long serialVersionUID = -8114228636932871865L;

    private TopicModelTableViewer dataTable = new TopicModelTableViewer();

    private transient TopicModelAdapter originalTableModelAdapter;

    public TopicModelViewer(TopicModelAdapter topicModelAdapter) {
        super(new BorderLayout());
        this.originalTableModelAdapter = topicModelAdapter;

        ViewToolBar toolBar = new ViewToolBar();

        StringBuffer infoText = new StringBuffer("TopicModel (");
        int numberOfTopics = originalTableModelAdapter.getParallelTopicModel().getNumTopics();
        infoText.append(numberOfTopics);
        infoText.append(numberOfTopics == 1 ? " topic, " : " topics, ");
        int numberOfWords = originalTableModelAdapter.getParallelTopicModel().getAlphabet().size();
        infoText.append(numberOfWords);
        infoText.append(numberOfWords == 1 ? " word) " : " words) ");
        generalInfo.setText(infoText.toString());
        toolBar.add(generalInfo, ViewToolBar.LEFT);

        add(toolBar, BorderLayout.NORTH);

        JScrollPane tableScrollPane = new ExtendedJScrollPane(dataTable);
        tableScrollPane.setBorder(null);
        add(tableScrollPane, BorderLayout.CENTER);

        setTopicModelAdapter(topicModelAdapter);
    }
    
    private JLabel generalInfo = new JLabel();
    {
        generalInfo.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
    }

    public void setTopicModelAdapter(TopicModelAdapter topicModelAdapter) {
        dataTable.setTopicModelAdapter(topicModelAdapter);
    }

    @Override
    public void prepareReporting() {
        dataTable.prepareReporting();
    }

    @Override
    public void finishReporting() {
        dataTable.finishReporting();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return dataTable.getColumnName(columnIndex);
    }

    @Override
    public String getCell(int row, int column) {
        return dataTable.getCell(row, column);
    }

    @Override
    public int getColumnNumber() {
        return dataTable.getColumnNumber();
    }

    @Override
    public int getRowNumber() {
        return dataTable.getRowNumber();
    }

    @Override
    public boolean isFirstLineHeader() { return false; }

    @Override
    public boolean isFirstColumnHeader() { return false; }
}
