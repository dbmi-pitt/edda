package edu.pitt.dbmi.edda.summarization.examples;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFToTextConverter {
	
	private static PDFToTextConverter singleton = null;
	
	private PDDocument doc = null;

	public static void main(String[] args) {
		PDFToTextConverter loader = PDFToTextConverter.getInstance();
		System.out.println(loader.convertPDFToText("C:\\Users\\kjm84\\Desktop\\HelloWorld.pdf"));
	}
	
	public static PDFToTextConverter getInstance() {
		if (singleton == null) {
			singleton = new PDFToTextConverter();
		}
		return singleton;
	}

	private PDFToTextConverter() {
	}
	
	public String convertPDFToText(String pdfFilePath) {
		String pdfAsText = null;
        try {  
        	doc = PDDocument.load(pdfFilePath);  
        	PDFTextStripper stripper = new PDFTextStripper();  
        	pdfAsText = stripper.getText(doc);  
        } catch (IOException e) {
			e.printStackTrace();
		} finally {  
			closePdfDocument();
        }  
        return pdfAsText;
	}
	
	private void closePdfDocument() {
		  if (doc != null) {  
            try {
					doc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}  
        }  
	}
	
}
