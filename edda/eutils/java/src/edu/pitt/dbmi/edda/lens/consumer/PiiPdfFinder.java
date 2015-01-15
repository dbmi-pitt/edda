package edu.pitt.dbmi.edda.lens.consumer;

public class PiiPdfFinder extends RestConsumer {
	

	private final String CONST_PII_BASE = "http://www.goodmedical.org/links/record/";
	
	public String findPii(String pii) {
		StringBuffer requestBuffer = new StringBuffer();
		requestBuffer.append( CONST_PII_BASE);
		requestBuffer.append(pii);
		String requestUrl = requestBuffer.toString();
		setRequest(requestUrl);
		setUrlSanitizer(new PassThruUrlSanitizer());
		executeQuery();
		System.out.println(getResponse());
		return getResponse();
	}


}
