package edu.pitt.dbmi.edda.lens.consumer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncoderSanitizer implements UrlSanitizerInt {

	@Override
	public String sanitize(String srcUrl) {	
		String tgtUrl = srcUrl;
		String[] srcParts = srcUrl.split("\\?");
		String srcPrefix = srcParts[0];
		String srcSuffix = srcParts[1];
		try {
			tgtUrl = srcPrefix + "?" + URLEncoder.encode(srcSuffix, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return tgtUrl;
	}

}
