package edu.pitt.dbmi.edda.lens.entrez.einfo;

import java.util.ArrayList;
import java.util.Collection;

import edu.pitt.dbmi.edda.lens.consumer.PassThruUrlSanitizer;
import edu.pitt.dbmi.edda.lens.entrez.EntrezDatabaseSearcher;
import edu.pitt.dbmi.edda.lens.entrez.HttpSearcher;
import edu.pitt.dbmi.edda.lens.entrez.einfo.digester.DbInfo;
import edu.pitt.dbmi.edda.lens.entrez.einfo.digester.DbName;
import edu.pitt.dbmi.edda.lens.entrez.einfo.digester.DigesterEinfo;

public class EntrezSearcherEinfo implements EntrezDatabaseSearcher {
	
	private HttpSearcher httpSearcher;
	
	public static void main(String args[]) {
		EntrezSearcherEinfo eInfoSearcher = new EntrezSearcherEinfo();
		eInfoSearcher.execute();
	}
	
	public EntrezSearcherEinfo() {
		;
	}
	
	public void execute() {
		HttpSearcher httpSearcher = new HttpSearcher();
		httpSearcher.setRequest("http://eutils.ncbi.nlm.nih.gov/entrez/eutils/einfo.fcgi");
		httpSearcher.setUrlSanitizer(new PassThruUrlSanitizer());
		httpSearcher.executeQuery();
		String xmlResponse = httpSearcher.getResponse();
		DigesterEinfo eInfoDigester = new DigesterEinfo();
		eInfoDigester.setInputXml(xmlResponse);
		eInfoDigester.execute();
		Collection<DbName> dbNames = eInfoDigester.getDbNames();
		for (DbName dbName : dbNames) {
			String url = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/einfo.fcgi?db=" + dbName;
			httpSearcher = new HttpSearcher();
			httpSearcher.setRequest(url);
			httpSearcher.setUrlSanitizer(new PassThruUrlSanitizer());
			httpSearcher.executeQuery();
			xmlResponse = httpSearcher.getResponse();
			eInfoDigester = new DigesterEinfo();
			eInfoDigester.setInputXml(xmlResponse);
			eInfoDigester.execute();
			Collection<DbInfo> dbInfos = eInfoDigester.getDbInfos();
			for (DbInfo dbInfo : dbInfos) {
				System.out.print(dbInfo.getDbName() + " ");
				System.out.println(dbInfo.getDescription() + " ");
			}
		}
	}


	@Override
	public HttpSearcher getHttpSearcher() {
		return httpSearcher;
	}

	@Override
	public void setHttpSearcher(HttpSearcher httpSearcher) {
		this.httpSearcher = httpSearcher;
	}

}
