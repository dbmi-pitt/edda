package edu.pitt.dbmi.edda.lens.consumer;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class RestConsumer {

	private static final String UTF_8 = "UTF-8";
	
	public static final String CONST_ENTREZ_PATH = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/";
	public static final String CONST_ESEARCH_PATH = CONST_ENTREZ_PATH + "esearch.fcgi";
	private static final String CONST_URL1 = CONST_ENTREZ_PATH + "esearch.fcgi?db=pubmed&term=science[journal]+AND+breast+cancer+AND+2008[pdat]";
	private static final String CONST_URL2 = CONST_ENTREZ_PATH + "esearch.fcgi?db=pubmed&term=science[journal]+AND+oral+cancer";
	private static final String CONST_URL3 = "http://rest.bioontology.org/bioportal/ontologies?apikey=24e1af42-54e0-11e0-9d7b-005056aa3316";
	private static final String CONST_URL4 = "http://openi.nlm.nih.gov/retrieve.php?query=DOC[Article]AREA[PMID]20398291";

	private GetMethod method;
	
	private PostMethod postMethod;
	
	private String redirectedUri;
	
	private String request;
	private String response;
	
	private UrlSanitizerInt urlSanitizer;
	
	public static void main(String[] args) {
		RestConsumer restConsumer = new RestConsumer();
		testPost(restConsumer);
		testUrl(restConsumer, CONST_URL1, new OpenEyeUrlSanitizer());
		testUrl(restConsumer, CONST_URL2, new OpenEyeUrlSanitizer());
		testUrl(restConsumer, CONST_URL3, new PassThruUrlSanitizer());
		testUrl(restConsumer, CONST_URL4, new OpenEyeUrlSanitizer());
	}
	
	private static void testPost(RestConsumer restConsumer) {
		restConsumer.setRequest(CONST_ESEARCH_PATH);
		restConsumer.executePost();
		System.out.println(restConsumer.getResponse());
	}

	private static void testUrl(RestConsumer restConsumer, String requestUrl, UrlSanitizerInt sanitizer) {
		restConsumer.setRequest(requestUrl);
		restConsumer.setUrlSanitizer(sanitizer);
		restConsumer.executeQuery();
		System.out.println(restConsumer.getResponse());
	}

	public RestConsumer() {
	}
	
	public void executeQuery() {
		String responseBodyAsString = null;
		method = null;
		try {
			HttpClient client = new HttpClient();
			client.getParams().setParameter("http.protocol.single-cookie-header", true);
			client.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
//			client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			String methodUrl = getUrlSanitizer().sanitize(getRequest());
			method = new GetMethod(methodUrl);
			method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(3, false));
			int statusCode = client.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			} else {	
//				establishRedirectedUri();
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
		setResponse(responseBodyAsString);
	}
	
	public void executePost() {
		String responseBodyAsString = null;
		postMethod = null;
		try {
			String terms = StringUtils.substringAfterLast(getRequest(), "=");
			HttpClient client = new HttpClient();
			client.getParams().setParameter("http.protocol.single-cookie-header", true);
			client.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
			postMethod = new PostMethod("http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi");
			postMethod.addParameter("db", "pubmed");
			postMethod.addParameter("term", terms);
			postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(3, false));
			int statusCode = client.executeMethod(postMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + postMethod.getStatusLine());
			} else {	
//				establishRedirectedUri();
				InputStream inputStream = postMethod.getResponseBodyAsStream();
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
			if (postMethod != null) {
				postMethod.releaseConnection();
			}
		}
		setResponse(responseBodyAsString);
	}
	
	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public UrlSanitizerInt getUrlSanitizer() {
		return urlSanitizer;
	}

	public void setUrlSanitizer(UrlSanitizerInt urlSanitizer) {
		this.urlSanitizer = urlSanitizer;
	}
	
	private void establishRedirectedUri() {
		try {
			setRedirectedUri(method.getURI().getURI());
		} catch (URIException e) {
			e.printStackTrace();
		}
	}

	public String getRedirectedUri() {
		return redirectedUri;
	}

	public void setRedirectedUri(String redirectedUri) {
		this.redirectedUri = redirectedUri;
	}
	
	public String getUri() {
		String uri = null;
		try {
			uri = method.getURI().getPath();
		} catch (URIException e) {
			e.printStackTrace();
		}
		return uri;
	}


}
