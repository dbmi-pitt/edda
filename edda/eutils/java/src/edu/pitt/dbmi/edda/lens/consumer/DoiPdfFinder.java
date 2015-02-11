package edu.pitt.dbmi.edda.lens.consumer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.StringUtils;

public class DoiPdfFinder extends RestConsumer {
	
	private final String CONST_DOI_URI = "http://dx.doi.org/";
	
	private final String CONST_INFORMA_HEALTH_CARE_URI = "http://informahealthcare.com/doi/";
	private final String CONST_WILEY_URI = "http://onlinelibrary.wiley.com/doi/";
	private final String CONST_JNS_URI = "http://thejns.org/doi/abs/";
	private final String CONST_ELSEVIER_URI = "http://linkinghub.elsevier.com";
	private final String CONST_NATURE_URI = "http://www.nature.com/";
	private final String CONST_NEJM_URI = "http://www.nejm.org/";
	
	private final String[] CONST_PDF_SOURCES = {
			CONST_JNS_URI
	};
	
	public String findDoi(String doi) throws UnsupportedEncodingException {
		if (doi.equals("10.1002/(SICI)1097-0347(199611/12)18:6<538::AID-HED8>3.0.CO;2-3")) {
			return "UNKNOWN";
		}
		
		String pdfUrl = "UNKNOWN";
		StringBuffer requestBuffer = new StringBuffer();
		requestBuffer.append( CONST_DOI_URI);
		requestBuffer.append(URLEncoder.encode(doi, "utf-8"));
		String requestUrl = requestBuffer.toString();
		setRequest(requestUrl);
		setUrlSanitizer(new OpenEyeUrlSanitizer());
		executeQuery();
		pdfUrl = extractPdfUrlFromHttpPayLoad();
		if (pdfUrl.equals("UNKNOWN")) {
			pdfUrl = extractPdfFromMetaData();
		}
		if (pdfUrl.equals("UNKNOWN")) {
			if (getRedirectedUri().startsWith(CONST_INFORMA_HEALTH_CARE_URI)) {
				pdfUrl = getRedirectedUri().replaceFirst("abs", "pdf");
			}
			else if (getRedirectedUri().startsWith(CONST_JNS_URI)) {
				pdfUrl = getRedirectedUri().replaceFirst("abs", "pdf");
			}
			else if (getRedirectedUri().startsWith(CONST_WILEY_URI)) {
				pdfUrl = CONST_WILEY_URI + doi + "/pdf";
			}
			else if (getRedirectedUri().startsWith(CONST_NATURE_URI)) {
				pdfUrl = getRedirectedUri().replaceFirst("full", "pdf");
				pdfUrl = pdfUrl.replaceAll("\\.html$", ".pdf");
			}
			else if (getRedirectedUri().startsWith(CONST_ELSEVIER_URI)) {
				pdfUrl = "UNKNOWN_ELSEVIER";
			}
		}
		return pdfUrl;
	}
	
	private String extractPdfUrlFromHttpPayLoad() {
		String pdfUrl = "UNKNOWN";
		if (!StringUtils.isNullOrEmpty(getResponse())) {
			Pattern pdfPattern = Pattern.compile("\\bhttp\\S*\\.pdf\\b");
			Matcher matcher = pdfPattern.matcher(getResponse());
			if (matcher.find()) {
				pdfUrl = matcher.group(0);
			}
		}
		return pdfUrl;
	}
	
	private String extractPdfFromMetaData() {
		String pdfUrl = "UNKNOWN";
		Pattern pdfPattern = Pattern.compile("\\<meta name\\=\\\"citation_pdf_url\\s*\\\"\\s*content\\s*\\=\\\"(.+)\\\"");
		if (!StringUtils.isNullOrEmpty(getResponse())) {
			Matcher matcher = pdfPattern.matcher(getResponse());
			if (matcher.find()) {
				pdfUrl = matcher.group(1);
			}
		}
		return pdfUrl;	
	}

}
