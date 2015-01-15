package edu.pitt.dbmi.edda.operator.ldaop;

import javax.activation.FileDataSource;

public class FileDeriverMimeType {
	public static void main(String[] args) {
		FileDeriverMimeType mimeTypeDeriver = new FileDeriverMimeType();
		mimeTypeDeriver.deriveMimeType(args[0]);
	}

	public FileDeriverMimeType() {
	}

	public String deriveMimeType(String filePath) {
		FileDataSource ds = new FileDataSource(filePath);
		String contentType = ds.getContentType();
		return contentType;
	}
	
}