package edu.pitt.dbmi.edda.lens.traverser;

import java.util.Comparator;

public class EddaPublication {
	
	public static final Comparator<EddaPublication> eddaPublicationComparator = new Comparator<EddaPublication>() {
		public int compare(EddaPublication o1, EddaPublication o2) {
			String p1 = o1.getPdfPath();
			String p2 = o2.getPdfPath();
			p1 = p1.substring(p1.indexOf("/")+1);
			p2 = p2.substring(p2.indexOf("/")+1);
			return p1.compareTo(p2);
		}
	};
	
	private String authors;
	private String title;
	private boolean hasAbstract = false;
	private boolean hasPdf = false;
	private String pdfPath = "NA";
	private String dataSet = "train";
	private String classification = "exclude";
	private String publicationType = "UNKNOWN";
	private int year = 2001;
	
	public EddaPublication() {
		;
	}
	
	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean getHasAbstract() {
		return hasAbstract;
	}

	public void setHasAbstract(boolean hasAbstract) {
		this.hasAbstract = hasAbstract;
	}

	public boolean getHasPdf() {
		return hasPdf;
	}

	public void setHasPdf(boolean hasPdf) {
		this.hasPdf = hasPdf;
	}
	
	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}
	
	public String getDataSet() {
		return dataSet;
	}

	public void setDataSet(String dataSet) {
		this.dataSet = dataSet;
	}
	
	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public String getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}


	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	


	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[" + getAuthors() + "], ");
		sb.append("[" + getTitle() + "], ");
		sb.append("[" + getHasAbstract() + "], ");
		sb.append("[" + getHasPdf() + "], ");
		sb.append("[" + getPdfPath() + "], ");
		sb.append("[" + getDataSet() + "], ");
		sb.append("[" + getClassification() + "], ");
		sb.append("[" + getPublicationType() + "], ");
		sb.append("[" + getYear() + "] ");
		return sb.toString();
	}

	






	

}
