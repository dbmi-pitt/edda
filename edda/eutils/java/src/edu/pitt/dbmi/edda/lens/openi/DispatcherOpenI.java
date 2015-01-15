package edu.pitt.dbmi.edda.lens.openi;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

public class DispatcherOpenI {

	private static final String UTF_8 = "UTF-8";
	
	public static final String CONST_ENTREZ_PATH = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/";
	private static final String CONST_URL1 = CONST_ENTREZ_PATH + "esearch.fcgi?db=pubmed&term=science[journal]+AND+oral+squamous+cell+carcinoma+AND+2008[pdat]&rettype=count";
	private static final String CONST_URL2 = CONST_ENTREZ_PATH + "esearch.fcgi?db=pubmed&term=science[journal]+AND+oral+squamous+cell+carcinoma+AND+2008[pdat]&rettype=uilist";
	private static final String CONST_URL3 = "http://rest.bioontology.org/bioportal/ontologies?apikey=24e1af42-54e0-11e0-9d7b-005056aa3316";
	private static final String CONST_URL4 = "http://openi.nlm.nih.gov/retrieve.php?query=DOC[Article]AREA[PMID]20398291";

	public static void main(String[] args) {
		DispatcherOpenI dispatcherOpenI = new DispatcherOpenI();
		dispatcherOpenI.executeQuery(CONST_URL1);
		dispatcherOpenI.executeQuery(CONST_URL2);
		dispatcherOpenI.executeQuery(CONST_URL3);
		dispatcherOpenI.executeQuery(CONST_URL4);
	}

	public DispatcherOpenI() {
	}
	
	public String executeQuery(String urlPath) {
		String responseBodyAsString = null;
		GetMethod method = null;
		try {
			HttpClient client = new HttpClient();
			client.getParams().setParameter("http.protocol.single-cookie-header", true);
			client.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
			method = new GetMethod(buildUrlForOpenI(urlPath));
			method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(3, false));
			int statusCode = client.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			} else {
				InputStream inputStream = method.getResponseBodyAsStream();
				StringWriter writer = new StringWriter();
				IOUtils.copy(inputStream, writer, UTF_8);
				responseBodyAsString = writer.toString();
			}
		} catch (HttpException e) {
			System.err.println("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (method != null) {
				method.releaseConnection();
			}
		}
		return responseBodyAsString;
	}
	
	private String buildUrlForOpenI(String srcUrlPath)
			throws UnsupportedEncodingException {
		String tgtUrlPath = srcUrlPath;
		if (srcUrlPath.indexOf("[") != -1) {
			tgtUrlPath = tgtUrlPath.replaceAll("\\[", "%5B");
			tgtUrlPath = tgtUrlPath.replaceAll("\\]", "%5D");
			System.out.println(tgtUrlPath);
		}
		return tgtUrlPath;
	}

}
