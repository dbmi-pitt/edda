package edu.pitt.dbmi.edda.lens.entrez.esearch.digester;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;

import javax.persistence.PersistenceException;

import org.apache.commons.digester3.Digester;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DigesterEsearch {

	private String inputXml;
	
	private EsearchResult eSearchResult;

	public static void main(String[] args) {
		DigesterEsearch digesterEinfo = new DigesterEsearch();
		digesterEinfo.setInputXml(getTestOneInput());
		digesterEinfo.execute();
		System.out.println(digesterEinfo.getEsearchResult());
		Collection<Id> ids = digesterEinfo.getEsearchResult().getIds();
		System.out.print(digesterEinfo);
		for (Id id : ids) {
			System.out.println(id);
		}
	}

	public static String getTestOneInput() {
		StringBuffer sb = new StringBuffer();
		sb.append("<eSearchResult>\n");
		sb.append("  <Count>179738</Count>\n");
		sb.append("  <RetMax>20</RetMax>\n");
		sb.append("  <RetStart>0</RetStart>\n");
		sb.append("  <QueryKey>1</QueryKey>\n");
		sb.append("  <WebEnv>NCID_1_254977721_130.14.22.215_9001_1413476983_1134260902_0MetA0_S_MegaStore_F_1</WebEnv>\n");
		sb.append("  <IdList>\n");
		sb.append("    <Id>4182985</Id>\n");
		sb.append("    <Id>4182983</Id>\n");
		sb.append("    <Id>4182981</Id>\n");
		sb.append("    <Id>4182979</Id>\n");
		sb.append("    <Id>4182977</Id>\n");
		sb.append("    <Id>4182975</Id>\n");
		sb.append("    <Id>4182973</Id>\n");
		sb.append("    <Id>4182971</Id>\n");
		sb.append("    <Id>4182969</Id>\n");
		sb.append("    <Id>4182967</Id>\n");
		sb.append("    <Id>4182965</Id>\n");
		sb.append("    <Id>4193672</Id>\n");
		sb.append("    <Id>4188043</Id>\n");
		sb.append("    <Id>4188042</Id>\n");
		sb.append("    <Id>4171747</Id>\n");
		sb.append("    <Id>4171746</Id>\n");
		sb.append("    <Id>4166696</Id>\n");
		sb.append("    <Id>4166677</Id>\n");
		sb.append("    <Id>4166676</Id>\n");
		sb.append("    <Id>4165308</Id>\n");
		sb.append("  </IdList>\n");
		sb.append("</eSearchResult>\n");
		return sb.toString();
	}

	public DigesterEsearch() {
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
		digester.addObjectCreate("eSearchResult", EsearchResult.class);
		digester.addBeanPropertySetter("eSearchResult/Count", "count");
		digester.addBeanPropertySetter("eSearchResult/RetMax", "retMax");
		digester.addBeanPropertySetter("eSearchResult/RetStart", "retStart");
		digester.addBeanPropertySetter("eSearchResult/QueryKey", "queryKey");
		digester.addBeanPropertySetter("eSearchResult/WebEnv", "webEnv");
		digester.addSetNext("eSearchResult", "setEsearchResult");
		digester.addObjectCreate("eSearchResult/IdList/Id", Id.class);
		digester.addBeanPropertySetter("eSearchResult/IdList/Id", "value");
		digester.addSetNext("eSearchResult/IdList/Id", "addId");
		digester.push(this);
		InputSource is = new InputSource(new ByteArrayInputStream(inputXml.getBytes()));
		is.setEncoding("ISO-8859-1");
		digester.parse(is);
	}

	public String getInputXml() {
		return inputXml;
	}

	public void setInputXml(String inputXml) {
		this.inputXml = inputXml;
	}

	public EsearchResult getEsearchResult() {
		return eSearchResult;
	}

	public void setEsearchResult(EsearchResult eSearchResult) {
		this.eSearchResult = eSearchResult;
	}
	

}