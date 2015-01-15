package edu.pitt.dbmi.edda.lens.entrez.einfo.digester;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.PersistenceException;

import org.apache.commons.digester3.Digester;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DigesterEinfo {

	private String inputXml;

	private final Collection<DbName> dbNames = new ArrayList<DbName>();
	private final Collection<DbInfo> dbInfos = new ArrayList<DbInfo>();

	public static void main(String[] args) {
		DigesterEinfo digesterEinfo = new DigesterEinfo();
		digesterEinfo.setInputXml(getTestOneInput());
		digesterEinfo.execute();
		Collection<DbName> dbNames = digesterEinfo.getDbNames();
		for (DbName dbName : dbNames) {
			System.out.println(dbName);
		}
	}
	
	public static void checkDbInfos(DigesterEinfo digesterEinfo) {
		Collection<DbInfo> dbInfos = digesterEinfo.getDbInfos();
		for (DbInfo dbInfo : dbInfos) {
			System.out.println(dbInfo);
			System.out.println("There are " + dbInfo.getFieldList().size() + " fields");
			System.out.println("There are " + dbInfo.getLinkList().size() + " fields");
		}
	}
	
	public static String getTestOneInput() {
		StringBuffer sb = new StringBuffer();
		sb.append("<eInfoResult>\n");
		sb.append("   <DbList>\n");
		sb.append("       <DbName>pubmed</DbName>\n");
		sb.append("       <DbName>protein</DbName>\n");
		sb.append("       <DbName>nuccore</DbName>\n");
		sb.append("       <DbName>nucleotide</DbName>\n");
		sb.append("       <DbName>nucgss</DbName>\n");
		sb.append("       <DbName>nucest</DbName>\n");
		sb.append("       <DbName>structure</DbName>\n");
		sb.append("    </DbList>\n");
		sb.append("</eInfoResult>\n");
		return sb.toString();
	}
	
	public static String getTestTwoInput() {
		StringBuffer sb = new StringBuffer();
		sb.append("<eInfoResult><DbInfo>\n");
		sb.append("  <DbName>protein</DbName>\n");
		sb.append("  <MenuName>Protein</MenuName>\n");
		sb.append("  <Description>Protein sequence record</Description>\n");
		sb.append("  <DbBuild>Build141009-0946m.1</DbBuild>\n");
		sb.append("  <Count>151811778</Count>\n");
		sb.append("  <LastUpdate>2014/10/09 22:03</LastUpdate>\n");
		sb.append("  <FieldList>\n");
		sb.append("     <Field>\n");
		sb.append("          <Name>ALL</Name>\n");
		sb.append("          <FullName>All Fields</FullName>\n");
		sb.append("          <Description>All terms from all searchable fields</Description>\n");
		sb.append("          <TermCount>790779373</TermCount>\n");
		sb.append("          <IsDate>N</IsDate>\n");
		sb.append("          <IsNumerical>N</IsNumerical>\n");
		sb.append("          <SingleToken>N</SingleToken>\n");
		sb.append("          <Hierarchy>N</Hierarchy>\n");
		sb.append("          <IsHidden>N</IsHidden>\n");
		sb.append("     </Field>\n");
		sb.append("  </FieldList>\n");
		sb.append("  <LinkList>\n");
		sb.append("     <Link>\n");
		sb.append("           <Name>nuccore_protein_wp</Name>\n");
		sb.append("           <Menu>Links to autonomous proteins</Menu>\n");
		sb.append("           <Description>Autonomous protein records</Description>\n");
		sb.append("           <DbTo>nuccore</DbTo>\n");
		sb.append("     </Link>\n");
		sb.append("     <Link>\n");
		sb.append("           <Name>protein_bioproject</Name>\n");
		sb.append("           <Menu>BioProject Links</Menu>\n");
		sb.append("           <Description>Proteins related to BioProjects</Description>\n");
		sb.append("           <DbTo>bioproject</DbTo>\n");
		sb.append("     </Link>\n");
		sb.append("   </LinkList>\n");
		sb.append("</DbInfo></eInfoResult>\n");
		return sb.toString();
	}

	public DigesterEinfo() {
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
		digester.addObjectCreate("eInfoResult/DbList/DbName", DbName.class);
		digester.addBeanPropertySetter("eInfoResult/DbList/DbName", "name");
		digester.addSetNext("eInfoResult/DbList/DbName", "addDbName");
		digester.addObjectCreate("eInfoResult/DbInfo", DbInfo.class);
		digester.addObjectCreate("eInfoResult/DbInfo/FieldList/Field", Field.class);
		digester.addObjectCreate("eInfoResult/DbInfo/LinkList/Link", Link.class);
		digester.addBeanPropertySetter("eInfoResult/DbInfo/DbName", "dbName");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/MenuName", "menuName");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/Description", "description");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/DbBuild", "dbBuild");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/Count", "count");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/LastUpdate", "lastUpdate");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/FieldList/Field/Name", "name");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/FieldList/Field/FullName", "fullName");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/FieldList/Field/Description", "description");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/FieldList/Field/TermCount", "termCount");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/FieldList/Field/IsDate", "isDate");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/FieldList/Field/IsNumerical", "isNumerical");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/FieldList/Field/SingleToken", "singleToken");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/FieldList/Field/Hierarchy", "hierarchy");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/FieldList/Field/IsHidden", "isHidden");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/LinkList/Link/Name", "name");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/LinkList/Link/Menu", "menu");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/LinkList/Link/Description", "description");
		digester.addBeanPropertySetter("eInfoResult/DbInfo/LinkList/Link/DbTo", "dbTo");
		digester.addSetNext("eInfoResult/DbInfo/FieldList/Field", "addField");
		digester.addSetNext("eInfoResult/DbInfo/LinkList/Link", "addLink");
		digester.addSetNext("eInfoResult/DbInfo", "addDbInfo");
		digester.push(this);
		InputSource is = new InputSource(new ByteArrayInputStream(inputXml.getBytes()));
		is.setEncoding("ISO-8859-1");
		digester.parse(is);
	}

	public void addDbInfo(DbInfo id) {
		dbInfos.add(id);
	}
	
	public Collection<DbInfo> getDbInfos() {
		return dbInfos;
	}

	public String getInputXml() {
		return inputXml;
	}

	public void setInputXml(String inputXml) {
		this.inputXml = inputXml;
	}
	
	public void addDbName(DbName dbName) {
		dbNames.add(dbName);
	}

	public Collection<DbName> getDbNames() {
		return dbNames;
	}

	

}