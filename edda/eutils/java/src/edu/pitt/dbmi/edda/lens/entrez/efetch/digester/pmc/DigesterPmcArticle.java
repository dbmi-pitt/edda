package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pmc;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.PersistenceException;

import org.apache.commons.digester3.Digester;
import org.apache.commons.io.FileUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import edu.pitt.dbmi.edda.lens.entrez.DigesterEutilsInf;

public class DigesterPmcArticle implements DigesterEutilsInf {

	private String inputXml;

	private final Collection<Article> articles = new ArrayList<Article>();
	
	public static void main(String[] args) {
		try {
			DigesterPmcArticle digesterEfetch = new DigesterPmcArticle();
			digesterEfetch.setXmlAsString(getTestOneInput());
			digesterEfetch.execute();
			Object objGraph = digesterEfetch.getObjGraph();
			if (objGraph instanceof Collection<?>) {
				@SuppressWarnings("unchecked")
				Collection<Article> articles = (Collection<Article>) digesterEfetch.getObjGraph();
				for (Article article : articles) {
					System.out.println(article.getArticleMeta().getArticleTitle());
					System.out.println("pmc = " + article.getArticleMeta().getPmcId());
					System.out.println("doi = " + article.getArticleMeta().getDoiId());
					System.out.println("pmid = " + article.getArticleMeta().getPubmedId());
				}
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getTestOneInput() throws IOException {
		File inputXmlFile = new File("C:\\Users\\mitchellkj\\Desktop\\efetchResults.xml");
		return FileUtils.readFileToString(inputXmlFile);
	}
	
	public DigesterPmcArticle() {
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

	private void tryExecute() throws IOException, SAXException {
		Digester digester = new Digester();
		digester.setValidating(false);
		digester.addObjectCreate("pmc-articleset/article", Article.class);
		digester.addObjectCreate("pmc-articleset/article/front/article-meta", ArticleMeta.class);	
		digester.addObjectCreate("pmc-articleset/article/front/article-meta/article-id", ArticleId.class);
		digester.addSetProperties("pmc-articleset/article/front/article-meta/article-id", "pub-id-type", "pubIdType");
		digester.addBeanPropertySetter("pmc-articleset/article/front/article-meta/article-id", "pubId");
		digester.addSetNext("pmc-articleset/article/front/article-meta/article-id", "addArticleId");
		digester.addBeanPropertySetter("pmc-articleset/article/front/article-meta/title-group/article-title", "articleTitle");
		digester.addSetNext("pmc-articleset/article/front/article-meta", "setArticleMeta");
		digester.addSetNext("pmc-articleset/article", "addArticle");
		digester.push(this);
		InputSource is = new InputSource(new ByteArrayInputStream(inputXml.getBytes()));
		is.setEncoding("ISO-8859-1");
		digester.parse(is);
	}

	@Override
	public void setXmlAsString(String xmlAsString) {
		inputXml = xmlAsString;
	}

	@Override
	public Object getObjGraph() {
		return articles;
	}


}