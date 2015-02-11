package edu.pitt.dbmi.edda.lens.traverser;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.lang3.StringUtils;

public class EddaDirectoryFilter extends DirectoryWalker<Object> {
	
	private String referenceFilerTsvFilePath = "T:\\EDDA\\WORKSPACE\\KEVIN\\tebeka_mitchell_pdf\\referenceFilerAnalysis.txt";
	private String summaryDirectoryPath = "T:\\EDDA\\WORKSPACE\\KEVIN\\tebeka_mitchell_pdf\\galacto";

	private final TreeSet<EddaPublication> summaryTargets = new TreeSet<EddaPublication>(EddaPublication.eddaPublicationComparator);

	public static void main(String[] args) {
		new EddaDirectoryFilter();
	}
	
	public EddaDirectoryFilter() {
		try {
			tryCacheReferenceFilerOutput();
			tryWalkDirectory();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void tryCacheReferenceFilerOutput() throws IOException {	
		File referenceFilerTsvFile = new File(referenceFilerTsvFilePath);
		if (referenceFilerTsvFile.exists() && referenceFilerTsvFile.isFile()) {
			List<String> fileLines = FileUtils.readLines(referenceFilerTsvFile);
			for (String fileLine : fileLines) {
				final String[] fields = fileLine.split("\\t");
				EddaPublication eddaPublication = new EddaPublication();
				int fdx = 0;
				eddaPublication.setAuthors(trimApostrophes(fields[fdx++]));
				eddaPublication.setTitle(trimApostrophes(fields[fdx++]));
				eddaPublication.setHasAbstract(convertToBoolean(trimApostrophes(fields[fdx++])));
				eddaPublication.setHasPdf(convertToBoolean(trimApostrophes(fields[fdx++])));
				eddaPublication.setPdfPath(trimApostrophes(fields[fdx++]));
				eddaPublication.setDataSet(trimApostrophes(fields[fdx++]));
				eddaPublication.setClassification(trimApostrophes(fields[fdx++]));
				eddaPublication.setPublicationType(trimApostrophes(fields[fdx++]));
				eddaPublication.setYear(Integer.parseInt(trimApostrophes(fields[fdx++])));
				if (!eddaPublication.getHasAbstract() && eddaPublication.getHasPdf()) {
					summaryTargets.add(eddaPublication);
				}
			}
			
		}
	}
	
	private String trimApostrophes(String src) {
		String tgt = StringUtils.remove(src,"\"");
		return tgt;
	}
	
	private boolean convertToBoolean(String booleanStringValue) {
		boolean result = (new Boolean(booleanStringValue)).booleanValue();
		return result;
	}
	
	private String extractAuthDateFromPdfPath(String src) {
		int slashIdx = StringUtils.indexOf(src, '/');
		String tgt = src.substring(slashIdx+1);
		tgt = extractAuthDateFromFileName(tgt);
		return tgt;
		
	}
	
	private String extractAuthDateFromFileName(String src) {
		return src.substring(0, Math.min(15, src.length()));
	}
	
	private String extractLinkIdentifierFilePath(String src) {
		int slashIdx = StringUtils.indexOf(src, '/');
		String tgt = src.substring(0, slashIdx);
		return tgt;
	}
	
	private String extractAuthDateFromPdfPath2(String src) {
		String tgt = null;
		Pattern pattern = Pattern.compile("\\w[\\w-]+\\-\\d{4}");
		Matcher matcher = pattern.matcher(src);
		if (matcher.find()) {
			tgt = matcher.group(0);
			tgt = tgt.substring(1, tgt.length());
		}
		if (tgt == null) {
			System.err.println("extractAuthDateFromPdfPath Failed to parse: " + src);
		}
		return tgt;
	}
	
	private String extractAuthDateFromFileName2(String src) {
		String tgt = null;
		Pattern pattern = Pattern.compile("^\\w[\\w-]+\\-\\d{4}");
		Matcher matcher = pattern.matcher(src);
		if (matcher.find()) {
			tgt = matcher.group(0);
		}
		if (tgt == null) {
			System.err.println("extractAuthDateFromFileName Failed to parse: " + src);
		}
		return tgt;
	}

	private void tryWalkDirectory() throws IOException {	
		IOFileFilter allFiles = FileFilterUtils.trueFileFilter();
		IOFileFilter allDirectories = FileFilterUtils.directoryFileFilter();
		File summaryDirectory = new File(summaryDirectoryPath);
		List<File> summaryFiles = (List<File>) FileUtils.listFiles(summaryDirectory, allFiles, allDirectories);
		resolvePublicationsToSummaries(summaryFiles);
	}
	
	private Iterator<File> sortSummaryFiles(List<File> summaryFiles) {
		final TreeSet<File> sortedFiles = new TreeSet<File>(new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return o1.getName().compareTo(o2.getName());
			}});
		sortedFiles.addAll(summaryFiles);
		return sortedFiles.iterator();
	}

	private void resolvePublicationsToSummaries(List<File> summaryFiles) throws IOException {
		Iterator<EddaPublication> iterOne = summaryTargets.iterator();
		Iterator<File> iterTwo = sortSummaryFiles(summaryFiles);
		EddaPublication p = null;
		File f = null;
		String authOne = null;
		String authTwo = null;
		int numberOfMatches = 0;
		File outputDirectory = new File("C:\\Users\\kjm84\\Desktop\\galacto\\fortyfour");
		FileUtils.forceMkdir(outputDirectory);
		while (iterTwo.hasNext())  {
			f = iterTwo.next();
			authTwo = extractAuthDateFromFileName(f.getName());
			if (p == null) {
				if (iterOne.hasNext()) {
					p = iterOne.next();
					authOne = extractAuthDateFromPdfPath(p.getPdfPath());
				}
			}
			if (authOne.equals(authTwo)) {
				outputSummary(outputDirectory, p, f);
				numberOfMatches++;
				p = null;
			}
		}
		System.out.println("Number of missing abstracts with pdfs " + summaryTargets.size());
		System.out.println("Number of matches found is " + numberOfMatches);
	}

	private void outputSummary(File outputDirectory, EddaPublication p, File f) throws IOException {
		String fileName = this.extractLinkIdentifierFilePath(p.getPdfPath());
		File outputFile = new File(outputDirectory, fileName + ".txt");
		FileUtils.write(outputFile, "TI - " + p.getTitle() + "\n");
		FileUtils.write(outputFile, "AB - " + FileUtils.readFileToString(f) + "\n", true /* append */);
	}

}
