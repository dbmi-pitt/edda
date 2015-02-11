package edu.pitt.dbmi.edda.operator.ldaop;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cc.mallet.types.Instance;

public class FileIterator implements Iterator<Instance> {
	
	private final static Logger logger = Logger.getLogger(FileIterator.class .getName()); 

	private final ArrayList<String> targetNameArray = new ArrayList<String>();
	private final ArrayList<File> textFileArray = new ArrayList<File>();
	private Iterator<String> targetNameIterator;
	private Iterator<File> textFileIterator;

	public static void main(String[] args) {
		final String[] includeDirectory = {
				"exclude",
				args[0] };
		final String[] excludeDirectory = {
				"include",
				args[1] };
		List<String[]> labelDirectoryPairs = new ArrayList<String[]>();
		labelDirectoryPairs.add(includeDirectory);
		labelDirectoryPairs.add(excludeDirectory);
		boolean isSortingDirectory = true;
		boolean isBalancingInstances = false;
		FileIterator fileIterator = new FileIterator(labelDirectoryPairs, isSortingDirectory, isBalancingInstances);
		while (fileIterator.hasNext()) {
			Instance instance = fileIterator.next();
			logger.info(instance.getTarget() + " "
					+ ((File) instance.getData()).getAbsolutePath());
		}
	}

	public FileIterator(List<String[]> labelDirectoryPairs,
			boolean isSortingDirectory, boolean isBalancingInstances) {
		for (String[] pair : labelDirectoryPairs) {
			String currentClassification = pair[0];
			String currentDirectoryPath = pair[1];
			File directory = new File(currentDirectoryPath);
			File[] directoryContents = (isSortingDirectory) ? sortDirectoryList(directory.listFiles()) : directory.listFiles();
			for (int i = 0; i < directoryContents.length; i++) {
				if (directoryContents[i].isFile()) {
					targetNameArray.add(currentClassification);
					textFileArray.add(directoryContents[i]);
				}
			}
		}
		if (isBalancingInstances) {
			balanceClassificationInstances();
		}
		targetNameIterator = targetNameArray.iterator();
		textFileIterator = textFileArray.iterator();
	}

	private void balanceClassificationInstances() {
		final ArrayList<File> excludeFiles = filterByTarget("exclude");
		final ArrayList<File> includeFiles = filterByTarget("include");
		final ArrayList<File> reducedExcludeFiles = reduceExcludeFiles(
				excludeFiles, includeFiles);
		if (reducedExcludeFiles.size() == includeFiles.size()) {
			logger.fine("Both includes and excludes have "
					+ reducedExcludeFiles.size() + " members.");
		} else {
			logger.fine("Includes do not equal excludes.");
		}
		cacheReducedCollections(reducedExcludeFiles, includeFiles);
	}

	private void cacheReducedCollections(ArrayList<File> reducedExcludeFiles,
			ArrayList<File> includeFiles) {
		targetNameArray.clear();
		textFileArray.clear();
		for (File f : reducedExcludeFiles) {
			targetNameArray.add("exclude");
			textFileArray.add(f);
		}
		for (File f : includeFiles) {
			targetNameArray.add("include");
			textFileArray.add(f);
		}

	}

	private ArrayList<File> reduceExcludeFiles(ArrayList<File> excludeFiles,
			ArrayList<File> includeFiles) {
		final ArrayList<File> reducedExcludeFiles = new ArrayList<File>();
		Date timeNow = new Date();
		Long seed = timeNow.getTime();
		Random randomizer = new Random(seed);
		while (reducedExcludeFiles.size() < includeFiles.size()) {
			int choiceExcludeFile = randomizer.nextInt(excludeFiles.size());
			reducedExcludeFiles.add(excludeFiles.remove(choiceExcludeFile));
		}
		return reducedExcludeFiles;
	}

	private ArrayList<File> filterByTarget(String targetNameFilter) {
		final ArrayList<File> files = new ArrayList<File>();
		Iterator<String> targetNameIterator = targetNameArray.iterator();
		Iterator<File> textFileIterator = textFileArray.iterator();
		while (targetNameIterator.hasNext()) {
			String targetName = targetNameIterator.next();
			File textFile = textFileIterator.next();
			if (targetName.equals(targetNameFilter)) {
				files.add(textFile);
			}
		}
		return files;
	}

	private File[] sortDirectoryList(File[] directoryList) {
		ArrayList<File> toSort = new ArrayList<File>(
				Arrays.asList(directoryList));
		Collections.sort(toSort, new Comparator<File>() {
			Pattern pat = Pattern.compile("(\\D+)(\\d+)\\D*\\.txt$");
			public int compare(File a, File b) {
				String aFileName = a.getName();
				String bFileName = b.getName();
				Matcher matA = pat.matcher(aFileName);
				Matcher matB = pat.matcher(bFileName);
				matA.find();
				matB.find();
				String nameA = matA.group(1);
				String nameB = matB.group(1);
				Integer numberA = Integer.parseInt(matA.group(2));
				Integer numberB = Integer.parseInt(matB.group(2));
				int result = nameA.compareTo(nameB);
				if (result == 0) {
					result = numberA.compareTo(numberB);
				}
				return result;
			}
		});
		int idx = 0;
		File[] sortedFiles = new File[toSort.size()];
		for (File f : toSort) {
			sortedFiles[idx++] = f;
		}
		return sortedFiles;
	}

	@Override
	public boolean hasNext() {
		return targetNameIterator.hasNext();
	}

	@Override
	public Instance next() {
		String targetName = targetNameIterator.next();
		File nextFile = textFileIterator.next();
		return new Instance(nextFile, targetName, nextFile.toURI(), null);
	}

	@Override
	public void remove() {
		throw new IllegalStateException(
				"This Iterator<Instance> does not support remove().");

	}

}
