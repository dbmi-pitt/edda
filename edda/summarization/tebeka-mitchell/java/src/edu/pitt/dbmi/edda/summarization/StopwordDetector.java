package edu.pitt.dbmi.edda.summarization;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;


public class StopwordDetector {
	
	private static StopwordDetector singleton = null;
	
	private HashSet<String> stopwords = new HashSet<String>();

	public static void main(String[] args) {
		StopwordDetector detector = getInstance();
		System.out.println(detector);
	}
	
	public static StopwordDetector getInstance() {
		if (singleton == null) {
			singleton = new StopwordDetector();
		}
		return singleton;
	}
	
	private StopwordDetector() {
		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialize() throws IOException {
		String stopWordsDirectoryPath = "C:\\ws\\eddalens\\eddalens\\stop-words";
		File stopWordsDirectory = new File(stopWordsDirectoryPath);
		if (stopWordsDirectory.exists() && stopWordsDirectory.isDirectory()) {
			File[] files = stopWordsDirectory.listFiles();
			for (File file : files) {
				if (file.getName().contains("_english_")) {
//					System.out.println("Reading file " + file);
					String fileAsString = FileUtils.readFileToString(file);
					String[] words = fileAsString.split("\n");					
					for (String word : words) {
						String token = extractToken(word);
						stopwords.add(token);
					}
				}
			}
		}
	}
	
	
	
	private String extractToken(String s) {
		Pattern pattern = Pattern.compile("\\w+$");
		Matcher matcher = pattern.matcher(s);
		return (matcher.find()) ? matcher.group(0) : "";
	}

	public boolean isStopword(String word) {
		return stopwords.contains(word);
	}
	
	public String toString() {
		return StringUtils.join(stopwords, "\n");
	}

}
