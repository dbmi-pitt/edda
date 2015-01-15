package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.persistence.PersistenceException;

import org.apache.commons.digester3.Digester;
import org.apache.commons.io.FileUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import edu.pitt.dbmi.edda.lens.entrez.DigesterEutilsInf;

public class DigesterEfetch implements DigesterEutilsInf {

	private String inputXml;

	private PubmedArticleSet pubmedArticleSet;
	
	public static void main(String[] args) {
		try {
			DigesterEfetch digesterEfetch = new DigesterEfetch();
			digesterEfetch.setXmlAsString(getTestOneInput());
			digesterEfetch.execute();
			PubmedArticleSet pubmedArticleSet = digesterEfetch.getPubmedArticleSet();
			Collection<PubmedArticle> pubmedArticleCollection = pubmedArticleSet.getPubmedArticles();
			for (PubmedArticle pubmedArticle : pubmedArticleCollection) {
				for (AbstractText abstractText : pubmedArticle.getArticleAbstract().getAbstractTexts()) {
					String s = String.format(" label = %s nlmCategory = %s %n", abstractText.getNlmCategory(),
							abstractText.getLabel());
					System.out.println(s);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getTestOneInput() throws IOException {
		File inputXmlFile = new File("C:\\Users\\kjm84\\Desktop\\junk.xml");
		return FileUtils.readFileToString(inputXmlFile);
	}
	
	public DigesterEfetch() {
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
		digester.addObjectCreate("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/Abstract", Abstract.class);
		digester.addObjectCreate("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/Abstract/AbstractText", AbstractText.class);
		digester.addObjectCreate("PubmedArticleSet/PubmedArticle/PubmedData/ArticleIdList/ArticleId", ArticleId.class);
		digester.addObjectCreate("PubmedArticleSet/PubmedArticle/PubmedData/ArticleIdList", ArticleIdList.class);
		digester.addObjectCreate("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/ArticleTitle", ArticleTitle.class);
		digester.addObjectCreate("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList/MeshHeading/DescriptorName", DescriptorName.class);
		digester.addObjectCreate("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/ELocationID", ElectronicLocationId.class);
		digester.addObjectCreate("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList/MeshHeading", MeshHeading.class);
		digester.addObjectCreate("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList", MeshHeadingList.class);
		digester.addObjectCreate("PubmedArticleSet/PubmedArticle", PubmedArticle.class);
		digester.addObjectCreate("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList/MeshHeading/QualifierName", QualifierName.class);
		
		digester.addBeanPropertySetter("PubmedArticleSet/PubmedArticle/MedlineCitation/PMID", "pmid");
		digester.addBeanPropertySetter("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/Language", "language");
		digester.addBeanPropertySetter("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/ArticleTitle", "title");
		digester.addSetProperties("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList/MeshHeading/DescriptorName", "MajorTopicYN", "majorTopicYN");
		digester.addBeanPropertySetter("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList/MeshHeading/DescriptorName", "content");
		digester.addSetProperties("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList/MeshHeading/QualifierName", "MajorTopicYN", "majorTopicYN");
		digester.addBeanPropertySetter("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList/MeshHeading/QualifierName", "content");
		digester.addSetProperties("PubmedArticleSet/PubmedArticle/PubmedData/ArticleIdList/ArticleId", "IdType", "idType");
		digester.addBeanPropertySetter("PubmedArticleSet/PubmedArticle/PubmedData/ArticleIdList/ArticleId", "content");
		digester.addSetProperties("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/Abstract/AbstractText", "NlmCategory", "nlmCategory");
		digester.addSetProperties("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/Abstract/AbstractText", "Label", "label");
		digester.addBeanPropertySetter("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/Abstract/AbstractText", "content");
		
		digester.addSetProperties("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/ELocationID", "EIdType", "eIdType");
		digester.addSetProperties("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/ELocationID", "ValidYN", "validYN");
		digester.addBeanPropertySetter("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/ELocationID", "content");
		
		digester.addSetNext("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/Abstract", "setArticleAbstract");
		digester.addSetNext("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/Abstract/AbstractText", "addAbstractText");		
		digester.addSetNext("PubmedArticleSet/PubmedArticle/PubmedData/ArticleIdList/ArticleId", "addArticleId");
		digester.addSetNext("PubmedArticleSet/PubmedArticle/PubmedData/ArticleIdList", "setArticleIdList");
		digester.addSetNext("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/ArticleTitle", "setArticleTitle");
		digester.addSetNext("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList/MeshHeading/DescriptorName", "setDescriptorName");
		digester.addSetNext("PubmedArticleSet/PubmedArticle/MedlineCitation/Article/ELocationID", "setElectronicLocationId");
		digester.addSetNext("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList/MeshHeading", "addMeshHeading");
		digester.addSetNext("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList", "setMeshHeadingList");
		digester.addSetNext("PubmedArticleSet/PubmedArticle", "addPubmedArticle");
		digester.addSetNext("PubmedArticleSet/PubmedArticle/MedlineCitation/MeshHeadingList/MeshHeading/Qualifier", "addQualifierName");
		
		pubmedArticleSet = new PubmedArticleSet();
		digester.push(pubmedArticleSet);
		InputSource is = new InputSource(new ByteArrayInputStream(inputXml.getBytes()));
		is.setEncoding("ISO-8859-1");
		digester.parse(is);
	}

	public PubmedArticleSet getPubmedArticleSet() {
		return pubmedArticleSet;
	}

	public void setPubmedArticleSet(PubmedArticleSet pubmedArticleSet) {
		this.pubmedArticleSet = pubmedArticleSet;
	}

	@Override
	public void setXmlAsString(String xmlAsString) {
		this.inputXml = xmlAsString;
	}

	@Override
	public Object getObjGraph() {
		return pubmedArticleSet;
	}


}