package edu.pitt.dbmi.edda.summarization.lens.enlreader;

import java.util.Comparator;
import java.util.HashMap;

public class Annotation {
	
	private String annotationType;
	private Integer sPos;
	private Integer ePos;
	private String underLyingText;
	private HashMap<String, String> features = new HashMap<String, String>();
	
	public static final Comparator<Annotation> annotationComparator = new Comparator<Annotation>() {
		@Override
		public int compare(Annotation o1, Annotation o2) {
			int result = o1.sPos - o2.sPos;
			result = (result == 0) ? o1.ePos - o2.ePos : result;
			return result; 
		}};

	public Annotation(String annotationType, Integer sPos, Integer ePos, String underLyingText) {
		this.setAnnotationType(annotationType);
		this.sPos = sPos;
		this.ePos = ePos;
		this.setUnderLyingText(underLyingText);
	}

	public String getAnnotationType() {
		return annotationType;
	}

	public void setAnnotationType(String annotationType) {
		this.annotationType = annotationType;
	}
	
	public Integer getsPos() {
		return sPos;
	}

	public void setsPos(Integer sPos) {
		this.sPos = sPos;
	}

	public Integer getePos() {
		return ePos;
	}

	public void setePos(Integer ePos) {
		this.ePos = ePos;
	}

	public String getUnderLyingText() {
		return underLyingText;
	}

	public void setUnderLyingText(String underLyingText) {
		this.underLyingText = underLyingText;
	}

	public HashMap<String, String> getFeatures() {
		return features;
	}

	public void addFeature(String key, String value) {
		features.put(key, value);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getAnnotationType() + " (");
		sb.append(getsPos() + ", " + getePos() + ") : ");
		sb.append(getUnderLyingText());
		return sb.toString();
	}

}
