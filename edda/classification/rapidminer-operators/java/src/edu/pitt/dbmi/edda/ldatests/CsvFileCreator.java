package edu.pitt.dbmi.edda.ldatests;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileCreator {
	
	private static final int CONST_BYTE_BUFFER_SIZE = 1024;
	
	private String srcDirectoryPath;
	private String tgtDirectoryPath;
	private String dataDomainPrefix;
	
	private File wordsFile;
	private FileWriter wordsWriter;
	
	private int currentRowNumber = 1;

	
	public static void main(String[] args) {
		String srcDirectoryPath = args[0];
		String tgtDirectoryPath = args[1];
		String dataDomainPrefix = args[2];
		CsvFileCreator csvFileCreator = new CsvFileCreator(srcDirectoryPath, tgtDirectoryPath, dataDomainPrefix);
		csvFileCreator.execute();
	}

	
	public CsvFileCreator(String srcDirectoryPath, String tgtDirectoryPath, String dataDomainPrefix) {
		this.srcDirectoryPath = srcDirectoryPath;
		this.tgtDirectoryPath = tgtDirectoryPath;
		this.dataDomainPrefix = dataDomainPrefix;
	}
	
	public void execute() {
		try {
			File tgtDirectory = new File(tgtDirectoryPath);
			tgtDirectory = new File(tgtDirectory, dataDomainPrefix);
			makeNewDirectory(tgtDirectory);
			wordsFile = new File(tgtDirectory, "TopicModelInput.csv");
			createNewFile(wordsFile);
			wordsWriter = new FileWriter(wordsFile);
		
			File srcDirectoryTopLevel = new File(srcDirectoryPath);
			File srcDirectoryExcludeDirectory = new File(srcDirectoryTopLevel, "FULL_N_Train");
			flattenDirectoryOfFiles(srcDirectoryExcludeDirectory, "exclude");
			File srcDirectoryIncludeDirectory = new File(srcDirectoryTopLevel, "FULL_Y_Train");
			flattenDirectoryOfFiles(srcDirectoryIncludeDirectory, "include");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private void flattenDirectoryOfFiles(File srcDirectory,
			String featureValue) throws IOException {
		final File[] srcFiles = srcDirectory.listFiles() ;
		for (File srcFile : srcFiles) {
			FileReader srcFileReader = new FileReader(srcFile);
			wordsWriter.write(currentRowNumber+",");
			wordsWriter.write(srcFile.getName() + ",");
			wordsWriter.write(featureValue + ",");
			writeSourceFileToWordsFile(srcFileReader, wordsWriter);
			wordsWriter.write("\n");
			currentRowNumber++;
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
		
	}

	private void replaceEolnsWithSpaces(char[] buffer, int bufferSize) {
		for (int cdx = 0; cdx < bufferSize; cdx++) {
			char c = buffer[cdx];
			if (c == '\n') {
				buffer[cdx] = ' ';
			}
		}
	}
	
	private static void makeNewDirectory(File f) throws IOException {
		if (!f.exists()) {
			f.mkdir();
		}
	}

	private static void createNewFile(File f) throws IOException {
		if (!f.exists()) {
			f.createNewFile();
		}
	}


}
