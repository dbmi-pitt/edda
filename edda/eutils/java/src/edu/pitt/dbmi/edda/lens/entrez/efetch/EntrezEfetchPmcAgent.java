package edu.pitt.dbmi.edda.lens.entrez.efetch;

import java.util.Collection;

import edu.pitt.dbmi.edda.lens.consumer.PassThruUrlSanitizer;
import edu.pitt.dbmi.edda.lens.entrez.DigesterEutilsInf;
import edu.pitt.dbmi.edda.lens.entrez.EntrezDatabaseSearcher;
import edu.pitt.dbmi.edda.lens.entrez.HttpSearcher;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.idlist.DigesterIdList;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.idlist.Id;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.idlist.IdList;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pmc.Article;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pmc.DigesterPmcArticle;

// http://eutils.ncbi.nlm.nih.gov/entrez/eutils/
// esearch.fcgi?db=<database>&term=<query>
//
// http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&term=22158106[uid] 

public class EntrezEfetchPmcAgent implements EntrezDatabaseSearcher {
	
	private HttpSearcher httpSearcher;
	
	private DigesterEutilsInf eFetchDigestor;
	
	private final String CONST_ENTREZ_ESEARCH = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?";

	private String database;
	private String webEnv;
	private String queryKey;
	private String retStart;
	private String retMax;
	private String retType;
	private String retMode;
	
	private Collection<Id> ids;
	
	private Collection<Article> articles;
	
	public static void main(String args[]) {
		EntrezEfetchPmcAgent eFetchAgent = new EntrezEfetchPmcAgent();
		HttpSearcher httpSearcher = new HttpSearcher();
		eFetchAgent.setHttpSearcher(httpSearcher);
		eFetchAgent.execute();
	}
	
	public EntrezEfetchPmcAgent() {
		;
	}
	
	public void execute() {
		String efetchUrl = buildUrl();
		httpSearcher.setRequest(efetchUrl);
		httpSearcher.setUrlSanitizer(new PassThruUrlSanitizer());
		httpSearcher.executeQuery();
		String xmlResponse = httpSearcher.getResponse();
		eFetchDigestor = new DigesterIdList();
		eFetchDigestor.setXmlAsString(xmlResponse);
		eFetchDigestor.execute();
		setIds((IdList) eFetchDigestor.getObjGraph());
	}
	
	@SuppressWarnings("unchecked")
	public void executeArticles() {
		String efetchUrl = buildUrl();
		httpSearcher.setRequest(efetchUrl);
		httpSearcher.setUrlSanitizer(new PassThruUrlSanitizer());
		httpSearcher.executeQuery();
		String xmlResponse = httpSearcher.getResponse();
		eFetchDigestor = new DigesterPmcArticle();
		eFetchDigestor.setXmlAsString(xmlResponse);
		eFetchDigestor.execute();
		if (eFetchDigestor.getObjGraph() != null) {
			if (eFetchDigestor.getObjGraph() instanceof Collection<?>) {
				setArticles((Collection<Article>) eFetchDigestor.getObjGraph());
			}
			else if (eFetchDigestor.getObjGraph() instanceof edu.pitt.dbmi.edda.lens.entrez.efetch.digester.idlist.IdList) {
				setIds((edu.pitt.dbmi.edda.lens.entrez.efetch.digester.idlist.IdList) eFetchDigestor.getObjGraph());
			}
		}
		
	}
	
	private String buildUrl() {
		String efetchUrl = CONST_ENTREZ_ESEARCH;
		efetchUrl += "db=" + getDatabase();
		efetchUrl += "&WebEnv=" + getWebEnv();
        efetchUrl += "&query_key=" + getQueryKey();
        efetchUrl +=  "&retstart=" + getRetStart();
        efetchUrl +=  "&retmax=" + getRetMax();
        if (getRetType() != null) {
        	efetchUrl +=  "&rettype=" + getRetType();
        }      
        efetchUrl +=  "&retmode=" + getRetMode();
        return efetchUrl;
	}


	@Override
	public HttpSearcher getHttpSearcher() {
		return httpSearcher;
	}

	@Override
	public void setHttpSearcher(HttpSearcher httpSearcher) {
		this.httpSearcher = httpSearcher;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getWebEnv() {
		return webEnv;
	}

	public void setWebEnv(String webEnv) {
		this.webEnv = webEnv;
	}

	public String getQueryKey() {
		return queryKey;
	}

	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}

	public String getRetStart() {
		return retStart;
	}

	public void setRetStart(String retStart) {
		this.retStart = retStart;
	}

	public String getRetMax() {
		return retMax;
	}

	public void setRetMax(String retMax) {
		this.retMax = retMax;
	}

	public String getRetType() {
		return retType;
	}

	public void setRetType(String retType) {
		this.retType = retType;
	}

	public String getRetMode() {
		return retMode;
	}

	public void setRetMode(String retMode) {
		this.retMode = retMode;
	}

	public Collection<Id> getIds() {
		return ids;
	}

	public void setIds(IdList idList) {
		this.ids = idList.getIds();
	}

	public Collection<Article> getArticles() {
		return articles;
	}

	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}

	public Collection<Article> getUis() {
		return null;
	}
	

	public DigesterEutilsInf geteFetchDigestor() {
		return eFetchDigestor;
	}

	public void seteFetchDigestor(DigesterEutilsInf eFetchDigestor) {
		this.eFetchDigestor = eFetchDigestor;
	}


}
