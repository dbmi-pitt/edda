package edu.pitt.dbmi.edda.lens.entrez.esearch;

import edu.pitt.dbmi.edda.lens.consumer.OpenEyeUrlSanitizer;
import edu.pitt.dbmi.edda.lens.consumer.PassThruUrlSanitizer;
import edu.pitt.dbmi.edda.lens.entrez.EntrezDatabaseSearcher;
import edu.pitt.dbmi.edda.lens.entrez.HttpSearcher;
import edu.pitt.dbmi.edda.lens.entrez.einfo.digester.DigesterEinfo;
import edu.pitt.dbmi.edda.lens.entrez.esearch.digester.DigesterEsearch;
import edu.pitt.dbmi.edda.lens.entrez.esearch.digester.EsearchResult;
import edu.pitt.dbmi.edda.lens.traverser.XmlFormatter;

// http://eutils.ncbi.nlm.nih.gov/entrez/eutils/
// esearch.fcgi?db=<database>&term=<query>

// "2009/10/12"[PubDate] : "2014/10/10"[PubDate] AND "humans"[MeSH Terms] AND "open access"[filter] AND Acknowledgments[Title]
// (("2009/10/12"[PubDate] : "2014/10/10"[PubDate] AND "humans"[MeSH Terms] AND "open access"[filter])) AND Acknowledgments[Title]
public class EntrezEsearchAgent implements EntrezDatabaseSearcher {
	
	private final String CONST_ENTREZ_ESEARCH = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi";
	
	private HttpSearcher httpSearcher;
	private String database;
	private String query;
	private boolean isUsingHistory = false;
	private EsearchResult eSearchResult;
	
	public static void main(String args[]) {
		EntrezEsearchAgent eSearchAgent = new EntrezEsearchAgent();
		eSearchAgent.setHttpSearcher(new HttpSearcher());
		eSearchAgent.setDatabase("pmc");
		eSearchAgent.setQuery("science[journal]+AND+breast+cancer+AND+2008[pdat]");
// 		String breastCancerQuery = "science[journal]+AND+breast+cancer+AND+2008[pdat]";
//		String tanjaPmcQuery = "2009/10/12[PubDate]:2014/10/10[PubDate]+AND+humans+[MeSH+Terms]+AND+open+access+[filter]";
//		String tanjaPmcQuery = "2009/10/12[PubDate]:2014/10/10[PubDate]+AND+humans+[MeSH+Terms]+AND+open+access+[filter]";
		String tanjaPmcQuery  = "2009/10/12[PubDate]:2014/10/10[PubDate]+AND+humans[MeSH Terms]+AND+open+access[filter]+AND+Acknowledgments[Title]";
		eSearchAgent.setQuery(tanjaPmcQuery);
		eSearchAgent.setUsingHistory(true);
		eSearchAgent.execute();
	}
	
	public EntrezEsearchAgent() {
		;
	}
	
	public void execute() {
		String requestQuery = buildQuery();
		httpSearcher.setRequest(requestQuery);
		httpSearcher.setUrlSanitizer(new OpenEyeUrlSanitizer());
		httpSearcher.executeQuery();
		String xmlResponse = httpSearcher.getResponse();
		DigesterEsearch eInfoDigester = new DigesterEsearch();
		eInfoDigester.setInputXml(xmlResponse);
		eInfoDigester.execute();
		setEsearchResult(eInfoDigester.getEsearchResult());
	}
	
	private String buildQuery() {
		String requestQuery = CONST_ENTREZ_ESEARCH;
		requestQuery += "?db=" + getDatabase() + "&term=" + getQuery();
		if (isUsingHistory()) {
			requestQuery += "&usehistory=y";
		}
		return requestQuery;
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public boolean isUsingHistory() {
		return isUsingHistory;
	}

	public void setUsingHistory(boolean isUsingHistory) {
		this.isUsingHistory = isUsingHistory;
	}

	public EsearchResult getEsearchResult() {
		return eSearchResult;
	}

	public void setEsearchResult(EsearchResult eSearchResult) {
		this.eSearchResult = eSearchResult;
	}

}
