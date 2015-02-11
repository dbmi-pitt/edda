package edu.pitt.dbmi.edda.operator.ldaop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.apache.commons.lang3.StringUtils;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.IDSorter;

public class TopicModelViewerTableModel implements TableModel {
	
	private final Comparator<RankedWord> rankedWordComparator = new Comparator<RankedWord>() {
		public int compare(RankedWord o1, RankedWord o2) {
			if (o1.getProbability() > o2.getProbability()) {
				return -1;
			} else {
				return 1;
			}
		}
	};

	private final HashMap<String, RankedWord> maximumProbabilities = new HashMap<String, RankedWord>();
	private final TreeSet<RankedWord> descendingProbabilites = new TreeSet<RankedWord>(
			rankedWordComparator);

	private ParallelTopicModel topicModel;
	private String[][] dataMatrix;
	private int numberOfRows = -1;
	private int numberOfCols = -1;
	private String[] colLabels;
	
	public TopicModelViewerTableModel(TopicModelAdapter topicModelAdapter) {
	
		try {
			
			topicModel = topicModelAdapter.getParallelTopicModel();
			numberOfRows = topicModelAdapter
					.getNumberMostProbableWordsForDisplay();
			numberOfCols = (2 * topicModel.getNumTopics()) + 1;

			buildColumnLabels();

			buildMaximumProbabilities();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void buildColumnLabels() {
		colLabels = new String[numberOfCols];
		colLabels[0] = "entry";
		int topicForColumnNumber = 0;
		for (int col = 1; col < numberOfCols; col += 2) {
			String formattedTopicNumber = buildFormattedTopicNumber(topicForColumnNumber);
			colLabels[col] = "word" + formattedTopicNumber;
			colLabels[col + 1] = "prob" + formattedTopicNumber;
			topicForColumnNumber++;
		}
	}

	private void buildMaximumProbabilities() throws IOException {

		dataMatrix = new String[numberOfRows][numberOfCols];

		initializeDataMatrix(dataMatrix);

		fillRowIndices(dataMatrix);

		ArrayList<TreeSet<IDSorter>> allWords = topicModel.getSortedWords();
		int topicIdx = 0;
		for (TreeSet<IDSorter> allTopicWords : allWords) {
			processTopicWords(topicIdx, allTopicWords);
			topicIdx++;
		}
	}
	
	private void initializeDataMatrix(String[][] data) {
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				data[row][col] = " ";
			}
		}
	}

	private void fillRowIndices(String[][] dataMatrix) {
		for (int row = 0; row < dataMatrix.length; row++) {
			String formattedRowNumber = StringUtils.leftPad(row + "", 4, "0");
			dataMatrix[row][0] = formattedRowNumber;
		}
	}

	private void processTopicWords(int topicIndex,
			TreeSet<IDSorter> allTopicWords) {
		clearCaches();
		fillMaximumProbabilities(allTopicWords);
		final TreeSet<RankedWord> descendingProbabilites = sortMaximumProbabilities();
		fillFormattedDataArray(topicIndex, descendingProbabilites);
	}

	private void fillFormattedDataArray(int topicIndex,
			TreeSet<RankedWord> descendingProbabilites) {
		Iterator<RankedWord> wordIterator = descendingProbabilites.iterator();
		int wordsVisited = 0;
		while (wordIterator.hasNext() && wordsVisited < numberOfRows) {
			RankedWord rankedWord = wordIterator.next();
			dataMatrix[wordsVisited][1 + (2 * topicIndex)] = rankedWord
					.getWord();
			dataMatrix[wordsVisited][2 + (2 * topicIndex)] = rankedWord
					.getFormattedProbability();
			wordsVisited++;
		}
	}

	private void fillMaximumProbabilities(TreeSet<IDSorter> allTopicWords) {
		int numberOfAssignments = sumOverTopicAssignments(allTopicWords);
		for (IDSorter weightedWordPointer : allTopicWords) {
			RankedWord rankedWord = new RankedWord();
			rankedWord.setWord((String) topicModel.getAlphabet().lookupObject(
					weightedWordPointer.getID()));
			rankedWord.setProbability(new Double(weightedWordPointer
					.getWeight()) / new Double(numberOfAssignments));
			RankedWord existingRankedWord = maximumProbabilities.get(rankedWord
					.getWord());
			if (existingRankedWord == null
					|| existingRankedWord.getProbability() < rankedWord
							.getProbability()) {
				maximumProbabilities.put(rankedWord.getWord(), rankedWord);
			}
		}
	}

	private TreeSet<RankedWord> sortMaximumProbabilities() {
		final TreeSet<RankedWord> descendingProbabilites = new TreeSet<RankedWord>(
				rankedWordComparator);
		descendingProbabilites.addAll(maximumProbabilities.values());
		return descendingProbabilites;
	}

	private String buildFormattedTopicNumber(int topicNumber) {
		return StringUtils.leftPad(topicNumber + "", 4, "0");
	}

	private void clearCaches() {
		maximumProbabilities.clear();
		descendingProbabilites.clear();
	}

	private int sumOverTopicAssignments(TreeSet<IDSorter> allTopicWords) {
		int accumulator = 0;
		for (IDSorter weightedWordPointer : allTopicWords) {
			accumulator += weightedWordPointer.getWeight();
		}
		return accumulator;
	}

	public int getRowCount() {
		return dataMatrix.length;
	}

	@Override
	public int getColumnCount() {
		return dataMatrix[0].length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colLabels[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return java.lang.String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return dataMatrix[rowIndex][columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		; // not writeable
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		; // not allowing listers
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {

	}

}
