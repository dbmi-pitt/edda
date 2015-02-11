/*
 *  Edda - RegExReader
 *
 *  Copyright (C) 2013 by Univesity of Pittsburgh DBMI Edda Project.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with RapidMiner.  If not, see http://www.gnu.org/licenses/.
 */
package edu.pitt.dbmi.edda.operator.regexop.regex;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RegExReader {

	final RegularExpressionList regularExpressions = new RegularExpressionList();

	private String regularExpressionXmlFilePath;

	private DocumentBuilder dBuilder;

	private int totalNumberOfRegularExpressions = 0;

	public RegExReader() {
	}

	public RegularExpressionList readRegularExpressionFromFile(
			String regularExpressionXmlFilePath) {
		NodeList regExNodeList;
		try {
			this.regularExpressionXmlFilePath = regularExpressionXmlFilePath;
			regularExpressions.clear();
			regExNodeList = openXmlFileAndExtractNodeList();
			cacheRegularExpressionsFromXmlNodes(regExNodeList);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return regularExpressions;
	}

	private NodeList openXmlFileAndExtractNodeList()
			throws ParserConfigurationException, SAXException, IOException {
		File regularExpressionXmlFile = openXmlFile();
		establishDocumentBuilder();
		Document doc = dBuilder.parse(regularExpressionXmlFile);
		doc.getDocumentElement().normalize();
		final NodeList regExNodeList = doc.getElementsByTagName("regex");
		return regExNodeList;

	}

	private void establishDocumentBuilder() throws ParserConfigurationException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
	}

	private File openXmlFile() {
		return new File(regularExpressionXmlFilePath);
	}

	private void cacheRegularExpressionsFromXmlNodes(NodeList regExNodeList) {
		for (int idx = 0; idx < regExNodeList.getLength(); idx++) {
			Node regExNode = regExNodeList.item(idx);
			if (regExNode.getNodeType() == Node.ELEMENT_NODE) {
				Element regExElement = (Element) regExNode;
				String regularExpressionName = getTagValue("name", regExElement);
				String regularExpressionValue = getTagValue("value",
						regExElement);

				RegularExpression regularExpression = new RegularExpression(
						regularExpressionName, regularExpressionValue,
						totalNumberOfRegularExpressions++);
				regularExpressions.add(regularExpression);
			}
		}
	}

	private String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
}
