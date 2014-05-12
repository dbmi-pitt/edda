package edu.pitt.dbmi.edda.replication;

import java.io.File;
import java.util.Comparator;
import java.util.TreeSet;

import org.jdom.Document;
import org.jdom.Element;

import edu.pitt.dbmi.edda.util.JdomUtils;
import edu.pitt.dbmi.edda.util.FileUtils;

public class InformationGainVerifier {

	private static Comparator<WeightedWord> weightedWordWeightComparator = new Comparator<WeightedWord>() {
		public int compare(WeightedWord weightedWordOne,
				WeightedWord weightedWordTwo) {
			if (weightedWordOne.weight < weightedWordTwo.weight) {
				return -1;
			} else if (weightedWordTwo.weight < weightedWordOne.weight) {
				return 1;
			} else {
				return (weightedWordOne.word.compareTo(weightedWordTwo.word));
			}
		}
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InformationGainVerifier verifier = new InformationGainVerifier();
		verifier.execute();
	}

	private void execute() {
		// TODO Auto-generated method stub

	}

	public InformationGainVerifier() {
		String oldWeightsAsString = FileUtils
				.getContents(buildOldWeightsFile());
		String newWeightsAsString = FileUtils
				.getContents(buildNewWeightsFile());
		Document oldDocument = JdomUtils
				.convertXmlToDocument(oldWeightsAsString);
		Document newDocument = JdomUtils
				.convertXmlToDocument(newWeightsAsString);
		TreeSet<WeightedWord> oldWords = processDocument(oldDocument);
		System.out.println("Before selection there are " + oldWords.size()
				+ " old words.");
		oldWords = keepWeightsGreaterThanOrEqualTo(oldWords,
				new Double(1.0E-04));
		System.out.println("After selection there are " + oldWords.size()
				+ " old words.");

		TreeSet<WeightedWord> newWords = processDocument(newDocument);
		System.out.println("Before selection there are " + newWords.size()
				+ " new words.");
		newWords = keepWeightsGreaterThanOrEqualTo(newWords,
				new Double(1.0E-04));
		System.out.println("After selection there are " + newWords.size()
				+ " new words.");

		System.out.println("Comparing new set to old.");
		compareSets("New Set", "Old Set", newWords, oldWords);

		System.out.println("Comparing old set to new.");
		compareSets("Old Set", "New Set", oldWords, newWords);
	}

	private TreeSet<WeightedWord> keepWeightsGreaterThanOrEqualTo(
			TreeSet<WeightedWord> srcSet, Double boundary) {
		final TreeSet<WeightedWord> resultSet = new TreeSet<WeightedWord>();
		final TreeSet<WeightedWord> rejectSet = new TreeSet<WeightedWord>(weightedWordWeightComparator);
		for (WeightedWord weightedWord : srcSet) {
			if (weightedWord.weight >= boundary) {
				resultSet.add(weightedWord);
			}
			else {
				rejectSet.add(weightedWord) ;
			}
		}
		if (rejectSet.size()>0) {
			System.out.println("Highest ranked rejection is " + rejectSet.first());
		}
		
		return resultSet;
	}

	private TreeSet<WeightedWord> processDocument(Document oldDocument) {
		final TreeSet<WeightedWord> wordSet = new TreeSet<WeightedWord>();
		Element rootElement = oldDocument.getRootElement();
		for (Object childObject : rootElement.getChildren()) {
			Element childElement = (Element) childObject;
			WeightedWord weightedWord = new WeightedWord();
			weightedWord.word = childElement.getAttributeValue("name");
			weightedWord.weight = new Double(
					childElement.getAttributeValue("value"));
			wordSet.add(weightedWord);

			;

		}
		return wordSet;

	}

	private void compareSets(String setNameOne, String setNameTwo,
			TreeSet<WeightedWord> setOne, TreeSet<WeightedWord> setTwo) {
		for (WeightedWord weightedWord : setOne) {
			if (!setTwo.contains(weightedWord)) {
				System.out.println(setNameOne + " has word "
						+ weightedWord.word + " not in " + setNameTwo);
			}
		}
	}

	public File buildOldWeightsFile() {
		StringBuffer sb = new StringBuffer();
		sb.append("E:" + File.separator);
		sb.append("revipure" + File.separator);
		sb.append("RapidMiner" + File.separator);
		sb.append("RAPID_MINER_FILES_TCB" + File.separator);
		sb.append("AMEL0BLASTOMA" + File.separator);
		sb.append("PHASE_II" + File.separator);
		sb.append("COMPNB" + File.separator);
		sb.append("infogainwts_BOW_FULL.wgt");
		String filePath = sb.toString();
		System.out.println("Opening " + sb.toString());

		File f = new File(filePath);
		if (f.exists() && !f.isDirectory()) {
			System.out.println("Successfully opened " + f.getAbsolutePath());
		} else {

		}

		return f;
	}

	public File buildNewWeightsFile() {
		StringBuffer sb = new StringBuffer();
		sb.append("E:" + File.separator);
		sb.append("revipure" + File.separator);
		sb.append("RapidMiner" + File.separator);
		sb.append("RAPID_MINER_FILES_TCB" + File.separator);
		sb.append("AMEL0BLASTOMA" + File.separator);
		sb.append("PHASE_II" + File.separator);
		sb.append("COMPNB" + File.separator);
		sb.append("kjm.wgt");
		String filePath = sb.toString();
		System.out.println("Opening " + sb.toString());

		File f = new File(filePath);
		if (f.exists() && !f.isDirectory()) {
			System.out.println("Successfully opened " + f.getAbsolutePath());
		}

		return f;
	}
}
