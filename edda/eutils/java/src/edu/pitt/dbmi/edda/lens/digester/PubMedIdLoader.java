package edu.pitt.dbmi.edda.lens.digester;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.xml.sax.SAXException;

import edu.pitt.dbmi.edda.lens.traverser.XmlFormatter;

public class PubMedIdLoader {

	private DigesterLoader digesterLoader;
	private Digester digester;
	private RulesEsearch digestionRules;

	private String inputXml;

	private final List<Id> ids = new ArrayList<Id>();

	public PubMedIdLoader() {
	}

	public void execute() {
		try {
			tryExecute();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	private void tryExecute() throws IOException, SAXException,
			PersistenceException, SecurityException {
		digestionRules = new RulesEsearch();
		digesterLoader = DigesterLoader.newLoader(digestionRules);
		performDigestion();
	}

	private void performDigestion() throws IOException, SAXException {
		try {
//			displayFormattedXml(inputXml);
			digester = digesterLoader.newDigester();
			digester.setValidating(false);
			digester.push(this);
			ByteArrayInputStream bis = new ByteArrayInputStream(
					inputXml.getBytes());
			digester.parse(bis);
		} catch (Exception x) {
			x.printStackTrace();	
		}
	}

	@SuppressWarnings("unused")
	private void displayFormattedXml(String inputXml) {
		XmlFormatter formatter = new XmlFormatter();
		System.out.println(formatter.format(inputXml));
	}

	public void addId(Id id) {
		ids.add(id);
	}

	public String getInputXml() {
		return inputXml;
	}

	public void setInputXml(String inputXml) {
		this.inputXml = inputXml;
	}

	public List<Id> getIds() {
		return ids;
	}

}