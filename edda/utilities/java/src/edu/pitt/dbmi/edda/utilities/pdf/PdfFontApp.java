package edu.pitt.dbmi.edda.utilities.pdf;

import java.io.File;
import java.util.List;

import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.examples.util.PrintTextLocations;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 * Hello world!
 * 
 */
public class PdfFontApp {

	public static void main(String[] args) throws Exception {
		String[] docs = new String[] { "/home/silvia/Escritorio/apuntes_sistemas/uoc/arquitectura_computadoras.pdf" };
		PDDocument dDocument = PDDocument
				.load(new File(
						"/home/silvia/Escritorio/apuntes_sistemas/uoc/arquitectura_computadoras.pdf"));
		List dPages = dDocument.getDocumentCatalog().getAllPages();

		// PrintDocumentMetaData documentMetaData=
		// dDocument.getPageFormat(1).getPaper()

		PDFTextStripper dFTextStripper = new PDFTextStripper();
		/*
		 * PDFText2HTML dFText2HTML = new PDFText2HTML();
		 * dFText2HTML.setStartPage(1); dFText2HTML.setEndPage(3);
		 * 
		 * StringWriter stringWriter = new StringWriter();
		 * dFText2HTML.writeText(dDocument, stringWriter);
		 */
		// System.out.println(stringWriter.toString());

		PrintTextLocation printTextLocations = new PrintTextLocations();

		System.out.println("PAG ---------------BEGIN-----------"
				+ dPages.size());
		for (int i = 0; i < dPages.size(); i++) {
			System.out.println("PAG ---------------BEGIN-----------" + i);
			PDPage pDPage = (PDPage) dPages.get(i);
			PDResources resources = pDPage.findResources();
			COSStream cosStream = pDPage.getContents().getStream();
			PDRectangle drawingSize = pDPage.getMediaBox();
			int rotation = 0;
			printTextLocations.processStream(resources, cosStream, drawingSize,
					rotation);
			System.out.println("PAG ---------------END----------" + i);
		}
	}

}
