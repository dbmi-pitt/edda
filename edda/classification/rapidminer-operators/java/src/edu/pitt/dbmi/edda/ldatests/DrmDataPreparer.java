package edu.pitt.dbmi.edda.ldatests;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DrmDataPreparer {
	
	private static final int CONST_BYTE_BUFFER_SIZE = 1024;
	
	private static final String CONST_A_SET_DIRECTORY = "C:\\edda\\data\\easy\\A_Data";
	
	private static final String CONST_B_SET_DIRECTORY = "C:\\edda\\data\\easy\\B_Data";

	private File includeDirectory;
	private File excludeDirectory;

	private File wordsFile;
	private File featuresFile;
	
	FileWriter wordsWriter;
	FileWriter featuresWriter;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DrmDataPreparer();
	}

	public DrmDataPreparer() {
		try {
			tryFileTransfer(CONST_A_SET_DIRECTORY, "A_");
			tryFileTransfer(CONST_B_SET_DIRECTORY, "B_");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void tryFileTransfer(String baseDirectoryPath, String outputPrefix) throws IOException {
		
		File srcDirectory = new File(baseDirectoryPath);
		includeDirectory = new File(srcDirectory, "include");
		excludeDirectory = new File(srcDirectory, "exclude");

		File tgtDirectory = new File("C:\\edda\\data\\drm_easy");
		wordsFile = new File(tgtDirectory, outputPrefix + "words.txt");
		featuresFile = new File(tgtDirectory, outputPrefix + "features.txt");

		createNewFile(wordsFile);
		createNewFile(featuresFile);
		
		wordsWriter = new FileWriter(wordsFile);
		featuresWriter = new FileWriter(featuresFile);

		flattenDirectoryOfFiles(includeDirectory, "include");
		flattenDirectoryOfFiles(excludeDirectory, "exclude");
		
		wordsWriter.flush();
		featuresWriter.flush();
		
		wordsWriter.close();
		featuresWriter.close();
		
	}

	private void flattenDirectoryOfFiles(File srcDirectory,
			String featureValue) throws IOException {
		final File[] srcFiles = srcDirectory.listFiles() ;
		for (File srcFile : srcFiles) {
			FileReader srcFileReader = new FileReader(srcFile);
			writeSourceFileToWordsFile(srcFileReader, wordsWriter);
			writeFeatureToFeaturesFile(featureValue);
		}
	}
	
	private void writeSourceFileToWordsFile(FileReader fileReader,
			FileWriter wordsWriter) throws IOException {
		char[] buffer = new char[CONST_BYTE_BUFFER_SIZE];
		while (true) {
			int bytesRead = fileReader.read(buffer, 0, CONST_BYTE_BUFFER_SIZE);
			if (bytesRead < CONST_BYTE_BUFFER_SIZE) {
				break;
			}
			replaceEolnsWithSpaces(buffer, bytesRead);
			wordsWriter.write(buffer, 0, bytesRead);
		}
		wordsWriter.write("\n");
	}
	
	private void writeFeatureToFeaturesFile(
			String featureValue) throws IOException {
		featuresWriter.write(featureValue + "\n");
	}

	private void replaceEolnsWithSpaces(char[] buffer, int bufferSize) {
		for (int cdx = 0; cdx < bufferSize; cdx++) {
			char c = buffer[cdx];
			if (c == '\n') {
				buffer[cdx] = ' ';
			}
		}
	}

	private static void createNewFile(File f) throws IOException {
		if (!f.exists()) {
			f.createNewFile();
		}
	}

}
