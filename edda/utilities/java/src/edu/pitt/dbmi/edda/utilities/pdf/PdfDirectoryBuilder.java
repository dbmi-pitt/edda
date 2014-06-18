package edu.pitt.dbmi.edda.utilities.pdf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class PdfDirectoryBuilder {
	
	private ArrayList<String> noAbstractCodes = new ArrayList<String>();

	public static void main(String[] args) {
		PdfDirectoryBuilder builder = new PdfDirectoryBuilder();
		try {
			builder.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void execute() throws IOException {
		File noAbstractDirectory = new File("C:\\Users\\kjm84\\Desktop\\galacto\\fortythree");
		File[] noAbstractFiles = noAbstractDirectory.listFiles();
		for (File noAbstractFile : noAbstractFiles) {
			noAbstractCodes.add(StringUtils.substringBefore(noAbstractFile.getName(), "."));
		}

		File srcPdfDirectory = new File("T:\\EDDA\\DATA\\GALACTOMANNAN\\ENL_for_ReferenceFiler\\Galacto_Enriched_March20-with-PDFs.Data\\PDF");
	    File tgtPdfDirectory = new File("C:\\Users\\kjm84\\Desktop\\galacto\\fortythree_full");
	    if (!tgtPdfDirectory.exists()) {
	    	tgtPdfDirectory.mkdir();
	    }
		File[] srcCodeDirectories = srcPdfDirectory.listFiles();
		for (File srcCodeDirectory : srcCodeDirectories) {
			String srcCode = srcCodeDirectory.getName();
			if (noAbstractCodes.contains(srcCode)) {
				File codedPdfFile = srcCodeDirectory.listFiles()[0];
				String tgtPdfFileName = srcCode + "_" + codedPdfFile.getName();
				File tgtPdfFile = new File(tgtPdfDirectory, tgtPdfFileName);
				FileUtils.copyFile(codedPdfFile, tgtPdfFile);
			}
		}
	}

}
