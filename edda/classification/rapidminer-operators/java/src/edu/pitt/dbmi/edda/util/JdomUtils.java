
package edu.pitt.dbmi.edda.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Utilities for JDOM for CaTIES.
 * 
 * @author mitchellkj@upmc.edu
 * @version $Id
 * @since 1.4.2_04
 */
public class JdomUtils {

	/**
	 * Method convertDocumentToString.
	 * 
	 * @param doc
	 *            org.jdom.Document
	 * @param format
	 *            Format
	 * 
	 * @return String
	 */
	public static String convertDocumentToString(org.jdom.Document doc,
			Format format) {
		String result = "";
		try {
			XMLOutputter outputDocument = new XMLOutputter();
			if (format != null) {
				outputDocument.setFormat(format);
			}
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			outputDocument.output(doc, byteArrayOutputStream);
			result = byteArrayOutputStream.toString();

		} catch (Exception x) {
			;
		}

		return result;

	}

	/**
	 * Method convertDocumentToString.
	 * 
	 * @param doc
	 *            org.jdom.Document
	 * @param format
	 *            Format
	 * 
	 * @return String
	 */
	public static void writeDocument(org.jdom.Document doc, Format format,
			OutputStream os) {
		try {
			XMLOutputter outputDocument = new XMLOutputter();
			if (format != null) {
				outputDocument.setFormat(format);
			}
			outputDocument.output(doc, os);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public static String convertElementToString(Element element, Format format) {
		Element elementClone = (Element) element.clone() ;
		if (elementClone.getParent() != null) {
			elementClone.getParent().removeContent(elementClone) ;
		}
		org.jdom.Document doc = new org.jdom.Document();
		doc.addContent(elementClone);
		String result = convertDocumentToString(doc, format);
		return result;
	}

	public static Document convertXmlToDocument(String payLoadXml) {
		Document doc = null;
		SAXBuilder builder = new SAXBuilder();
		try {
			doc = builder
					.build(new ByteArrayInputStream(payLoadXml.getBytes()));
		}
		catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return doc;
	}

}
