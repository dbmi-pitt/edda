package edu.pitt.dbmi.edda.lens.consumer;

public class OpenEyeUrlSanitizer implements UrlSanitizerInt {

	@Override
	public String sanitize(String srcUrl) {
		String tgtUrl = srcUrl;
		if (srcUrl.indexOf("[") != -1) {
			tgtUrl = tgtUrl.replaceAll("\\[", "%5B");
			tgtUrl = tgtUrl.replaceAll("\\]", "%5D");
		}
		return tgtUrl;
	}

}
