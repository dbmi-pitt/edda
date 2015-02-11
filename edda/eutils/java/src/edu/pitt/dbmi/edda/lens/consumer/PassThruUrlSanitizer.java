package edu.pitt.dbmi.edda.lens.consumer;

public class PassThruUrlSanitizer implements UrlSanitizerInt {

	@Override
	public String sanitize(String srcUrl) {
		return srcUrl;
	}

}
