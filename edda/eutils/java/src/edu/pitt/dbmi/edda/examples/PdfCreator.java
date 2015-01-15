package edu.pitt.dbmi.edda.examples;

import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PdfCreator {

	public static void main(String[] args) {
		PdfCreator pdfCreator = new PdfCreator();
		try {
			pdfCreator.execute();
		} catch (COSVisitorException | IOException e) {
			e.printStackTrace();
		}

	}

	public PdfCreator() {
		;
	}

	public void execute() throws COSVisitorException, IOException {
		// Create a new empty document
		PDDocument document = new PDDocument();

		// Create a new blank page and add it to the document
		PDPage blankPage = new PDPage();
		document.addPage(blankPage);

		// Save the newly created document
		document.save("C:\\Users\\kjm84\\Desktop\\BlankPage.pdf");

		// finally make sure that the document is properly
		// closed.
		document.close();
	}

}
