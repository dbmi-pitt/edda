package edu.pitt.dbmi.edda.lens.digester;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.xml.sax.SAXException;

public class ArticleLoader {

	private DigesterLoader digesterLoader;
	private Digester digester;
	private RulesEfetch digestionRules;

	private String inputXml;

	private final List<ArticleId> articleIds = new ArrayList<ArticleId>();

	public ArticleLoader() {
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
		digestionRules = new RulesEfetch();
		digesterLoader = DigesterLoader.newLoader(digestionRules);
		performDigestion();
	}

	private void performDigestion() throws IOException,
			SAXException {
		digester = digesterLoader.newDigester();
		digester.push(this);
		inputXml = inputXml.replaceAll("IdType", "articleIdType");
		ByteArrayInputStream bis = new ByteArrayInputStream(inputXml.getBytes("utf-8"));
		digester.parse(bis);
	}
	

	public List<ArticleId> getArticleIds() {
		return articleIds;
	}
	
	public void addArticleId(ArticleId articleId) {
		articleIds.add(articleId);
	}


	public String getInputXml() {
		return inputXml;
	}

	public void setInputXml(String inputXml) {
		this.inputXml = inputXml;
	}


}