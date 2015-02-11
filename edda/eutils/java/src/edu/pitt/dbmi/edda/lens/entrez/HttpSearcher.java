package edu.pitt.dbmi.edda.lens.entrez;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

import edu.pitt.dbmi.edda.lens.consumer.UrlSanitizerInt;

public class HttpSearcher {
	
	private static final String UTF_8 = "UTF-8";
	private static final String ISO_8859_1 = "ISO-8859-1";
	
	private GetMethod method;
	
	private String request;
	private String response;
	
	private UrlSanitizerInt urlSanitizer;
	
	public HttpSearcher() {
		;
	}
	
	public void executeQuery() {
		String responseBodyAsString = null;
		method = null;
		try {
			HttpClient client = new HttpClient();
			client.getParams().setParameter("http.protocol.single-cookie-header", true);
			client.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
			client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
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
//				IOUtils.copy(inputStream, writer, ISO_8859_1);
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

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public UrlSanitizerInt getUrlSanitizer() {
		return urlSanitizer;
	}

	public void setUrlSanitizer(UrlSanitizerInt urlSanitizer) {
		this.urlSanitizer = urlSanitizer;
	}

}
