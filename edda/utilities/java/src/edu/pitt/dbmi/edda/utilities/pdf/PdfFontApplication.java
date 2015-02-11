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

public class PdfFontApplication {

	  public static void main(String[] args) throws Exception {
	        String[] docs = new String[]{"T://EDDA//DATA//GALACTOMANNAN//ENL_for_ReferenceFiler//Galacto_Enriched_March20-with-PDFs.Data//PDF//0003585778//Cabral-2003-Production of the ac.pdf"};
	        PDDocument dDocument = PDDocument.load(new File("T://EDDA//DATA//GALACTOMANNAN//ENL_for_ReferenceFiler//Galacto_Enriched_March20-with-PDFs.Data//PDF//0003585778//Cabral-2003-Production of the ac.pdf"));
	        List dPages = dDocument.getDocumentCatalog().getAllPages();
	        PDFTextStripper dFTextStripper = new PDFTextStripper();
	        PrintTextLocationsTokens printTextLocations = new PrintTextLocationsTokens();
			System.out.println("TOTAL # OF PAGES: "
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
				int displayedTokens = 0;
				for (Object tokenObj : printTextLocations.getBufferTokens()) {
					Token token = (Token) tokenObj;
					if (displayedTokens % 1000 == 0) {
						System.out.println(token);
					}
					displayedTokens++;
				}
				System.out.println("PAG ---------------END----------" + i);
			}
	    }	

}




