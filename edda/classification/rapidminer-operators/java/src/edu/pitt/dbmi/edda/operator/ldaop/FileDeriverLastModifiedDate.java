package edu.pitt.dbmi.edda.operator.ldaop;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class FileDeriverLastModifiedDate {
	
	private final static Logger logger = Logger.getLogger(FileDeriverLastModifiedDate.class .getName()); 
	
	private Date lastModifiedDate;
	private String formattedLastModifiedDate;

	public static void main(String[] args) {
		FileDeriverLastModifiedDate deriver = new FileDeriverLastModifiedDate();
		deriver.deriveLastModifiedDate(args[0]);	
		logger.info("After Format : " + deriver.getFormattedLastModifiedDate());
	}

	public FileDeriverLastModifiedDate() {
	}

	public Date deriveLastModifiedDate(String filePath) {
		File file = new File(filePath);
		Long lastModifiedDateAsLong = file.lastModified();
		lastModifiedDate = new Date(lastModifiedDateAsLong);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		setFormattedLastModifiedDate(sdf.format(lastModifiedDateAsLong));
		return lastModifiedDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getFormattedLastModifiedDate() {
		return formattedLastModifiedDate;
	}

	public void setFormattedLastModifiedDate(String formattedLastModifiedDate) {
		this.formattedLastModifiedDate = formattedLastModifiedDate;
	}

}