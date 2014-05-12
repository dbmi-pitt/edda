package edu.pitt.dbmi.edda.ldatests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParallelDataPreparer {

	private final String[] dataSubSets = { "easy", "ameloblastoma", "malaria",
			"galactomannanen", "influenza", "transplant" };
	private final String[] dataSplits = { "A", "B" };
	private final String[] dataClassifications = { "include", "exclude" };

	private File includeDirectory;
	private File excludeDirectory;

	private File instancesFile;
	private FileWriter instancesWriter;

	private Integer currentRecordId;
	private String currentFileName;
	private String currentClass;
	private String currentText;

	public static void main(String[] args) {
		new ParallelDataPreparer();
	}

	public ParallelDataPreparer() {
		try {
			tryFileTransfer("C:\\edda\\data\\comprehensive\\");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void tryFileTransfer(String baseDirectoryPath) throws IOException {

		File baseDirectory = new File(baseDirectoryPath);

		for (String dataSubSet : dataSubSets) {

			currentRecordId = 0;

			File dataSetDirectory = new File(baseDirectory, dataSubSet);

			for (String dataSplit : dataSplits) {

				File dataSplitDirectory = new File(dataSetDirectory, dataSplit
						+ "_data");

				includeDirectory = new File(dataSplitDirectory,
						dataClassifications[0]);
				excludeDirectory = new File(dataSplitDirectory,
						dataClassifications[1]);

				instancesFile = new File(dataSetDirectory, dataSplit + ".csv");

				TopicModelUtils.createNewFile(instancesFile);

				instancesWriter = new FileWriter(instancesFile);

				currentClass = dataClassifications[0];
				flattenDirectoryOfFiles(includeDirectory);

				currentClass = dataClassifications[1];
				flattenDirectoryOfFiles(excludeDirectory);

				instancesWriter.flush();
				instancesWriter.close();

			}

		}
	}

	private void flattenDirectoryOfFiles(File srcDirectory) throws IOException {
		final File[] srcFiles = srcDirectory.listFiles();
		for (File srcFile : srcFiles) {
			processSourceFile(srcFile);
		}
	}
	
	private void processSourceFile(File srcFile) throws IOException {
		currentFileName = srcFile.getName();
		BufferedReader srcFileReader = new BufferedReader(new FileReader(
				srcFile));
		currentText = representTextAsSingleLine(srcFileReader);
		formatAndWriteInstance() ;
		srcFileReader.close();
	}

	private void formatAndWriteInstance() throws IOException {
		String formattedInstance = formatInstance();
		instancesWriter.write(formattedInstance);
	}

	private String formatInstance() {
		String formattedInstance = String.format("%s, %s, %s, %s\n",
				currentRecordId + "", currentFileName, currentClass,
				currentText);
		currentRecordId++;
		return formattedInstance;
	}

	private String representTextAsSingleLine(BufferedReader srcFileReader)
			throws IOException {
		StringBuffer sb = new StringBuffer();
		while (true) {
			String line = srcFileReader.readLine();
			if (line == null) {
				break;
			}
			sb.append(line + " ");
		}
		String result = sb.toString();
		result = sanitize(result);
		result = result.replaceAll("\"", " ");
		result = result.replaceAll(",", " ");

		return result;
	}
	
	private String sanitize(String s) {
		return s.replaceAll("[^\\p{ASCII}]", " ");
	}

}
