package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.idlist;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.persistence.PersistenceException;

import org.apache.commons.digester3.Digester;
import org.apache.commons.io.FileUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import edu.pitt.dbmi.edda.lens.entrez.DigesterEutilsInf;

public class DigesterIdList implements DigesterEutilsInf {

	private String inputXml;

	private IdList idList;
	
	public static void main(String[] args) {
		try {
			DigesterIdList d = new DigesterIdList();
			d.setXmlAsString(getTestOneInput());
			d.execute();
			Object objGraph = d.getObjGraph();
			if (objGraph instanceof IdList) {
				IdList ids = (IdList) d.getObjGraph();
				for (Id id : ids.getIds()) {
					System.out.println(id);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getTestOneInput() throws IOException {
		File inputXmlFile = new File("C:\\Users\\kjm84\\Desktop\\idlist.xml");
		return FileUtils.readFileToString(inputXmlFile);
	}
	
	public DigesterIdList() {
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
		digester.addObjectCreate("IdList", IdList.class);
		digester.addObjectCreate("IdList/Id", Id.class);	
		digester.addBeanPropertySetter("IdList/Id", "value");
		digester.addSetNext("IdList/Id", "addId");
		digester.addSetNext("IdList", "setIdList");
		digester.push(this);
		InputSource is = new InputSource(new ByteArrayInputStream(inputXml.getBytes()));
		is.setEncoding("ISO-8859-1");
		digester.parse(is);
	}
	
	public void setIdList(IdList idList) {
		this.idList = idList;
	}
	

	@Override
	public void setXmlAsString(String xmlAsString) {
		inputXml = xmlAsString;
	}

	@Override
	public Object getObjGraph() {
		return idList;
	}


}