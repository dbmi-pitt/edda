package edu.pitt.dbmi.edda.lens.embase;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.ajax.JSON;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import edu.pitt.dbmi.edda.lens.traverser.XmlFormatter;
import edu.pitt.dbmi.edda.rdbms.DataSourceManager;
import edu.pitt.dbmi.edda.rdbms.pojo.Publication;

public class EmbaseSearcher {

	private static final String UTF_8 = "UTF-8";

	public static final String[] standardFields = { "prism:url",
			"dc:identifier", "dc:title", "prism:publicationName", "prism:isbn",
			"prism:issn", "prism:volume", "prism:issueIdentifier",
			"prism:startingPage", "prism:endingPage", "prism:coverDate",
			"dc:creator", "authors", "prism:doi", "pii", "scopus-id", "subtype" };

	public static final String CONST_EMBASE_PATH = "https://www.embase.com/searchQuery";
	public static final String CONST_API_KEY = "c9e7653405e0c92eb79e15fce7738a30";
	public static final String CONST_ELSEVIER_SCOPUS_QUERY = "http://api.elsevier.com/content/search/index:SCOPUS?query=";
	public static final String CONST_ELSEVIER_SCIDIR_QUERY = "http://api.elsevier.com/content/search/index:SCIDIR?query=";
	public static final String CONST_ELSEVIER_QUERY = "http://api.elsevier.com/content/search/index:";
	public static final String CONST_AND_TERMS = "TITLE(aspergilloma)%20AND%20TITLE(laboratory)%20AND%20TITLE(pulmonary)%20AND%20TITLE(diagnosis)%20AND%20AUTHLASTNAME(kobayashi)%20AND%20AUTHLASTNAME(miyazaki)";
	public static final String CONST_COMMA_TERMS = "heart+attack%20AND%20text(liver)";
	public static final String CONST_HEART_TERMS = "heart:ti";
	public static final String CONST_AUTHENTICATION = "http://api.elsevier.com/authenticate?platform=SCOPUS&apiKey=c9e7653405e0c92eb79e15fce7738a30";
	public static final String CONST_AUTHENTICATION_HEADER = "http://api.elsevier.com/authenticate?platform=SCOPUS";
	public static final String CONST_HEART_QUERY = "heart:ti&field=dc:title,dc:creator,prism:publicationName,prism:coverDate,dc:description,prism:doi";
    public static final String CONST_GENERIC_DOI = "http://dx.doi.org/";
	
	private DataSourceManager dataSourceManager;

	private PostMethod postMethod;
	private GetMethod getMethod;

	private String apiKey = CONST_API_KEY;
	private String authToken;

	public static void main(String[] args) {
		EmbaseSearcher searcher = new EmbaseSearcher();
		searcher.executeAuthorize();
		searcher.executeSearch();
	}

	public EmbaseSearcher() {
		initializeDataSourceManager();
	}

	private void initializeDataSourceManager() {
		dataSourceManager = new DataSourceManager();
		dataSourceManager
				.setHibernateConnectionUrl("jdbc:mysql://localhost:3306/pdfg");
		dataSourceManager.setHibernateShowSql("true");
		dataSourceManager.setHibernateUserName("edda");
		dataSourceManager.setHibernateUserPassword("edda");
		dataSourceManager.setHibernateHbm2ddlAuto("update");
	}

	public void executeAuthorize() {
		String responseBodyAsString = null;
		getMethod = null;
		try {
			HttpClient client = new HttpClient();
			getMethod = new GetMethod(CONST_AUTHENTICATION_HEADER);
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(3, false));
			getMethod.setRequestHeader("X-ELS-APIKey", CONST_API_KEY);
			int statusCode = client.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ getMethod.getStatusLine());
			} else {
				InputStream inputStream = getMethod.getResponseBodyAsStream();
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
			if (getMethod != null) {
				getMethod.releaseConnection();
			}
		}
		extractAuthTokenFromResponse(responseBodyAsString);
	}

	@SuppressWarnings("unchecked")
	private void extractAuthTokenFromResponse(String responseBodyAsString) {
		System.out.println(responseBodyAsString);
		Object jsonObj = JSON.parse(responseBodyAsString);
		System.out.println(jsonObj.getClass().getName());
		HashMap<String, Object> jsonMap = (HashMap<String, Object>) JSON
				.parse(responseBodyAsString);
		jsonMap = (HashMap<String, Object>) jsonMap
				.get("authenticate-response");
		authToken = (String) jsonMap.get("authtoken");
		
	}

	@SuppressWarnings("unchecked")
	public void executeSearch() {
		Criteria crit = dataSourceManager.getSession().createCriteria(
				Publication.class);
		crit.add(Restrictions.and(Restrictions.eq("pubMedId", "MISSING"),
				Restrictions.eq("publicationAbstract", "UNKNOWN")));
		List<Publication> publications = crit.list();
		for (Publication publication : publications) {
			String elsevierTerms = translateQueryToElsevier(publication);
			String scopusXml = executeDocumentSearch("SCOPUS", elsevierTerms);
			String doi = extractDoiFromXml(scopusXml);
			if (!doi.equals("UNKNOWN")) {
				System.out.println("Found doi = " + doi);
				String scidirXml = executeElsevierDoiSearch(doi);
				System.out.println(scidirXml);
			}
			
		}
	}
	
	private String executeElsevierDoiSearch(String doi) {
		String responseBodyAsString = null;
		GetMethod getMethod = null;
		int statusCode = HttpStatus.SC_NOT_ACCEPTABLE;
		try {
			HttpClient client = new HttpClient();
			String queryUri = "http://api.elsevier.com/content/article/doi/{doi}";
			queryUri = queryUri.replaceFirst("\\{doi\\}", doi);
			System.out.println(queryUri);
			getMethod = new GetMethod(queryUri);
			client.getParams().setParameter("http.protocol.single-cookie-header", true);
			client.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
			client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(3, false));
			getMethod.setRequestHeader("X-ELS-APIKey", CONST_API_KEY);
			getMethod.setRequestHeader("X-ELS-Authroken", authToken);
			getMethod.setRequestHeader("Accept", "text/xml, application/json, application/pdf, image/png, plain/text, text/html, application/epub+zip, application/x-mobipocket-ebook, application/rdf+xml");
			statusCode = client.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ getMethod.getStatusLine());
			} else {
				responseBodyAsString = unPackResponse(getMethod
						.getResponseBodyAsStream());
			}
		} catch (HttpException e) {
			System.err.println("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (getMethod != null) {
				getMethod.releaseConnection();
			}
		}
		String pdfUrl = extractPdfUrlFromResponse(responseBodyAsString);
		System.out.println(pdfUrl);
		return pdfUrl;
	}
	
	private String executeDoiSearch(String indexSource, String doi) {
		String responseBodyAsString = null;
		GetMethod getMethod = null;
		int statusCode = HttpStatus.SC_NOT_ACCEPTABLE;
		try {
			HttpClient client = new HttpClient();
			String queryUri = "http://dx.doi.org/{doi}";
			queryUri = queryUri.replaceFirst("\\{doi\\}", doi);
			System.out.println(queryUri);
			getMethod = new GetMethod(queryUri);
			client.getParams().setParameter("http.protocol.single-cookie-header", true);
			client.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
			client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(3, false));
			statusCode = client.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ getMethod.getStatusLine());
			} else {
				responseBodyAsString = unPackResponse(getMethod
						.getResponseBodyAsStream());
			}
		} catch (HttpException e) {
			System.err.println("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (getMethod != null) {
				getMethod.releaseConnection();
			}
		}
		String pdfUrl = extractPdfUrlFromResponse(responseBodyAsString);
		System.out.println(pdfUrl);
		return pdfUrl;
	}

	private String extractPdfUrlFromResponse(String responseBodyAsString) {
		Pattern pattern = Pattern.compile("\\bhttps?://\\S+\\.pdf");
		Matcher matcher = pattern.matcher(responseBodyAsString);
		String thePdfUrl = "UNKNOWN";
		if (matcher.find()) {
			thePdfUrl = matcher.group(0);
		}
		return thePdfUrl;
		
	}

	private String extractDoiFromXml(String scopusXml) {
		String doi = "UNKNOWN";
		Pattern pattern = Pattern.compile("<prism:doi>(.+)</prism:doi>");
		Matcher matcher = pattern.matcher(scopusXml);
		if (matcher.find()) {
			doi = matcher.group(1);
		}
		return doi;
	}

	private String translateQueryToElsevier(Publication publication) {
		String pubMedFormat = publication.getUriSearcher();
		Pattern pattern = Pattern.compile("\\w+\\[[auti]{2}\\]");
		Matcher matcher = pattern.matcher(pubMedFormat);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String searchComponent = matcher.group(0);
			if (sb.length() > 0) {
				sb.append("%20AND%20");
			}
			if (searchComponent.endsWith("[ti]")) {
				sb.append("TITLE(" + StringUtils.substringBefore(searchComponent, "[") + ")");
			}
			else if (searchComponent.endsWith("[au]")) {
				sb.append("AUTHLASTNAME(" + StringUtils.substringBefore(searchComponent, "[") + ")");
			}
		}
		return sb.toString();
	}

	public String executeDocumentSearch(String indexSource, String elsevierTerms) {
		String responseBodyAsString = null;
		getMethod = null;
		try {
			HttpClient client = new HttpClient();
			String queryUri = CONST_ELSEVIER_QUERY;
			queryUri += indexSource + "?query=";
			// queryUri = CONST_ELSEVIER_SCIDIR_QUERY;
			queryUri += elsevierTerms;
			queryUri += "&view=COMPLETE";
			System.out.println(queryUri);
			getMethod = new GetMethod(queryUri);
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(3, false));
			getMethod.setRequestHeader("X-ELS-APIKey", CONST_API_KEY);
			getMethod.setRequestHeader("X-ELS-Authroken", authToken);
			getMethod.setRequestHeader("Accept", "application/xml");
			int statusCode = client.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ getMethod.getStatusLine());
			} else {
				responseBodyAsString = unPackResponse(getMethod
						.getResponseBodyAsStream());
			}
		} catch (HttpException e) {
			System.err.println("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (getMethod != null) {
				getMethod.releaseConnection();
			}
		}
		String formattedResponse = (new XmlFormatter())
				.format(responseBodyAsString);
//		System.out.println(formattedResponse);
		return formattedResponse;
	}

	private String specifyAllFields() {
		String queryUri = "&field=";
		for (String field : standardFields) {
			if (!queryUri.endsWith("=")) {
				queryUri += ",";
			}
			queryUri += field;
		}
		return queryUri;
	}

	private String unPackResponse(InputStream inputStream) throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputStream, writer, UTF_8);
		return writer.toString();
	}

	public void executePost() {
		String responseBodyAsString = null;
		postMethod = null;
		try {
			String terms = "aspergilloma:ti AND laboratory:ti AND pulmonary:ti AND diagnosis:ti AND kobayashi:au AND miyazaki:au";
			HttpClient client = new HttpClient();
			client.getParams().setParameter(
					"http.protocol.single-cookie-header", true);
			client.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
			postMethod = new PostMethod(CONST_EMBASE_PATH);
			postMethod.addParameter("searchField", terms);
			postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(3, false));
			int statusCode = client.executeMethod(postMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: "
						+ postMethod.getStatusLine());
			} else {
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
		System.out.println(responseBodyAsString);
	}

	/*
	 * HttpClient provides full support for HTTP over Secure Sockets Layer (SSL)
	 * or IETF Transport Layer Security (TLS) protocols by leveraging the Java
	 * Secure Socket Extension (JSSE). JSSE has been integrated into the Java 2
	 * platform as of version 1.4 and works with HttpClient out of the box. On
	 * older Java 2 versions JSSE needs to be manually installed and configured.
	 * Installation instructions can be found here Standard SSL in HttpClient.
	 * Once you have JSSE correctly installed, secure HTTP communication over
	 * SSL should be as simple as plain HTTP communication.
	 */

	@SuppressWarnings("unused")
	private void exampleHttpsGetCall() {
		HttpClient httpclient = new HttpClient();
		GetMethod httpget = new GetMethod("https://www.verisign.com/");
		try {
			httpclient.executeMethod(httpget);
			System.out.println(httpget.getStatusLine());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpget.releaseConnection();
		}
	}

	/*
	 * HTTPS communication via an authenticating proxy server is also no
	 * different from plain HTTP communication. All the low-level details of
	 * establishing a tunneled SSL connection are handled by HttpClient:
	 */

	@SuppressWarnings({ "unused", "deprecation" })
	private void exampleHttpsAuthenticatingProxy() {
		HttpClient httpclient = new HttpClient();
		httpclient.getHostConfiguration().setProxy("www.embase.com", 8080);
		httpclient.getState().setProxyCredentials(
				"my-proxy-realm",
				" myproxyhost",
				new UsernamePasswordCredentials("www.embase.com",
						"my-proxy-password"));
		GetMethod httpget = new GetMethod("https://www.verisign.com/");
		try {
			httpclient.executeMethod(httpget);
			System.out.println(httpget.getStatusLine());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpget.releaseConnection();
		}
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

}
