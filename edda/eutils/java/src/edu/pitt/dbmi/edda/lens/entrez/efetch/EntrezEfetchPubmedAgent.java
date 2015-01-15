package edu.pitt.dbmi.edda.lens.entrez.efetch;

import edu.pitt.dbmi.edda.lens.consumer.PassThruUrlSanitizer;
import edu.pitt.dbmi.edda.lens.entrez.EntrezDatabaseSearcher;
import edu.pitt.dbmi.edda.lens.entrez.HttpSearcher;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed.DigesterEfetch;
import edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed.PubmedArticleSet;

// http://eutils.ncbi.nlm.nih.gov/entrez/eutils/
// esearch.fcgi?db=<database>&term=<query>

public class EntrezEfetchPubmedAgent implements EntrezDatabaseSearcher {
	
	private HttpSearcher httpSearcher;
	
	private final String CONST_ENTREZ_ESEARCH = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?";

	private String database;
	private String webEnv;
	private String queryKey;
	private String retStart;
	private String retMax;
	private String retType;
	private String retMode;
	private String xmlResponse;
	
	private PubmedArticleSet pubmedArticleSet;
	
	public static void main(String args[]) {
		EntrezEfetchPubmedAgent eFetchAgent = new EntrezEfetchPubmedAgent();
		HttpSearcher httpSearcher = new HttpSearcher();
		eFetchAgent.setHttpSearcher(httpSearcher);
		eFetchAgent.execute();
	}
	
	public EntrezEfetchPubmedAgent() {
		;
	}
	
	public void execute() {
		String efetchUrl = buildUrl();
		httpSearcher.setRequest(efetchUrl);
		httpSearcher.setUrlSanitizer(new PassThruUrlSanitizer());
		httpSearcher.executeQuery();
		xmlResponse = httpSearcher.getResponse();
		DigesterEfetch eFetchDigestor = new DigesterEfetch();
		eFetchDigestor.setXmlAsString(xmlResponse);
		eFetchDigestor.execute();
		setPubmedArticleSet(eFetchDigestor.getPubmedArticleSet());
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

	public String getXmlResponse() {
		return xmlResponse;
	}

	public void setXmlResponse(String xmlResponse) {
		this.xmlResponse = xmlResponse;
	}

	public PubmedArticleSet getPubmedArticleSet() {
	return pubmedArticleSet;
	}

	public void setPubmedArticleSet(PubmedArticleSet pubmedArticleSet) {
		this.pubmedArticleSet = pubmedArticleSet;
	}

}
