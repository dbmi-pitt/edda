package edu.pitt.dbmi.edda.utilities.pdf;

import java.awt.Font;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptor;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.util.PDFTextStripper;

public class Pdf2Box {

	private static final String pdfPath = "C:\\Users\\kjm84\\Desktop\\galacto\\somepdfs\\test004.pdf";

	private PDDocument pdfDocument;

	public static void main(String args[]) {
		Pdf2Box pdf2Box = new Pdf2Box();
		try {
			pdf2Box.execute1();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Pdf2Box() {

	}

	private void loadPdfDocument() throws IOException {
		pdfDocument = PDDocument.load(pdfPath);
	}

	@SuppressWarnings("unchecked")
	public void execute() throws IOException {
		loadPdfDocument();
		List<PDPage> pages = pdfDocument.getDocumentCatalog().getAllPages();
		int startPageValue = 1;
		int endPageValue = pages.size();
		boolean force = true;
		boolean sort = true;
		boolean separateBeads = true;
		final String encoding = "utf-8";
		PDFTextStripper textStripper = new PDFTextStripper(encoding);		
		textStripper.setForceParsing(force);		
		textStripper.setSortByPosition(sort);	
		textStripper.setShouldSeparateByBeads(separateBeads);		
		textStripper.setStartPage(startPageValue);
		textStripper.setEndPage(endPageValue);
		String pdfAsText = textStripper.getText(pdfDocument);
		Map<String, PDFont> fontMap = textStripper.getFonts();
		displayFontMap(fontMap, pdfAsText);
		pdfDocument.close();
	}

	public void execute1() throws IOException {
		loadPdfDocument();
		PDFTextStripper textStripper = new PDFTextStripper();
		String pdfAsText = textStripper.getText(pdfDocument);
		List<PDPage> pages = pdfDocument.getDocumentCatalog().getAllPages();
		for (PDPage page : pages) {
			Map<String, PDFont> pageFonts = page.getResources().getFonts();
			displayFontMap(pageFonts, pdfAsText);
		}

		Map<String, PDFont> fontMap = textStripper.getResources().getFonts();
		displayFontMap(fontMap, pdfAsText);
		pdfDocument.close();
	}

	private void displayFontMap(Map<String, PDFont> fontMap, String pdfAsText)
			throws IOException {
		for (String key : fontMap.keySet()) {
			StringBuffer sb = new StringBuffer();
			PDType0Font fontObject = (PDType0Font) fontMap.get(key);
			final String displayString = displayPDType0Font(fontObject,
					pdfAsText);
			if (displayString.length() > 0) {
				System.out.println(displayString);
			}
//			Font awtFont = fontObject.getFontDescriptor().get.getawtFont();
			// String fontName = awtFont.getFontName();
			// sb.append(key + " ==> " + fontName);

		}
	}

	private String displayPDType0Font(PDType0Font fontObject, String pdfAsText)
			throws IOException {
		StringBuffer sb = new StringBuffer();
		int sPos = fontObject.getFirstChar();
		int lPos = fontObject.getLastChar();
		if (sPos >= 0) {
			sb.append("(" + sPos + "," + lPos + ") ==> "
					+ pdfAsText.substring(sPos, lPos) + "\n");
		}
		final float avgFontWidth = fontObject.getAverageFontWidth();
		if (avgFontWidth >= 0.0d) {
			sb.append("average font width is " + avgFontWidth + "\n");
		}
		final PDFontDescriptor fontDescriptor = fontObject.getFontDescriptor();
		if (fontDescriptor != null) {
			String fontName = fontDescriptor.getFontName();
			String fontFamily = fontDescriptor.getFontFamily();
			
		}
		return sb.toString();
	}
	
	@SuppressWarnings("unused")
	private void processBoundingBox(PDType0Font fontObject) throws IOException {
		PDRectangle boundingBox = fontObject.getFontBoundingBox();
		if (boundingBox != null) {
			float lowerLeftX = boundingBox.getLowerLeftX();
			float lowerLeftY = boundingBox.getLowerLeftY();
			float upperRightX = boundingBox.getUpperRightX();
			float upperRightY = boundingBox.getUpperRightY();
		}
	}

}
