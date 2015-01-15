package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class MeshEvaluator {
	
	private int numberWithMesh;
	private int numberWithNoMesh;
	
	private boolean hasMeshHeadings = false;

	private String headingOne = "NA";
	private String headingTwo = "NA";
	
	private final HashSet<String> majorHeaders = new HashSet<String>();
	private final HashSet<String> minorHeaders = new HashSet<String>();
	private Iterator<String> majorHeadersIterator;
	private Iterator<String> minorHeadersIterator;
	
	public void evaluate(PubmedArticle pubmedArticle) {
	
		clearCache();

		if (pubmedArticle.getMeshHeadingList().getMeshHeadings().size() > 0) {
			for (MeshHeading meshHeading : pubmedArticle.getMeshHeadingList().getMeshHeadings()) {
				DescriptorName descriptorName = meshHeading.getDescriptorName();
				cacheDescriptorName(descriptorName);
				Collection<QualifierName> qualifierNames = meshHeading.getQualifierNames();
				for (QualifierName qualifierName : qualifierNames) {
					cacheQualifierName(qualifierName);
				}
			} 
		}
		if (majorHeaders.size() + minorHeaders.size() > 0) {
			hasMeshHeadings = true;
		}
		majorHeadersIterator = majorHeaders.iterator();
		minorHeadersIterator = minorHeaders.iterator();
		headingOne = nextHeader();
		headingTwo = nextHeader();
		
		numberWithMesh = hasMeshHeadings() ? numberWithMesh + 1
				: numberWithMesh;
		numberWithNoMesh = !hasMeshHeadings() ? numberWithNoMesh + 1
				: numberWithNoMesh;
	}
	
	private void clearCache() {
		hasMeshHeadings = false;
		majorHeaders.clear();
		minorHeaders.clear();
		majorHeadersIterator = null;
		minorHeadersIterator = null;
		headingOne = "NA";
		headingTwo = "NA";
	}

	private void cacheQualifierName(QualifierName qualifierName) {
		String majorTopicYN = qualifierName.getMajorTopicYN();
		String content = qualifierName.getContent();
		majorTopicYN = (majorTopicYN == null) ? "N" : majorTopicYN;
		content = (content == null) ? "NA" : content;
		switch (majorTopicYN) {
		case "Y":
			majorHeaders.add(content);
			break;
		case "N":
		default:
			minorHeaders.add(content);
			break;
		}
	}

	private void cacheDescriptorName(DescriptorName descriptorName) {
		String majorTopicYN = descriptorName.getMajorTopicYN();
		String content = descriptorName.getContent();
		majorTopicYN = (majorTopicYN == null) ? "N" : majorTopicYN;
		content = (content == null) ? "NA" : content;
		switch (majorTopicYN) {
		case "Y":
			majorHeaders.add(content);
			break;
		case "N":
		default:
			minorHeaders.add(content);
			break;
		}
	}

	private String nextHeader() {
		String result = "NA";
		if (majorHeadersIterator.hasNext()) {
			result = majorHeadersIterator.next();
		}
		else if (minorHeadersIterator.hasNext()) {
			result = minorHeadersIterator.next();
		}
		return result;
	}
	
	public boolean hasMeshHeadings() {
		return hasMeshHeadings;
	}

	public String getHeadingOne() {
		return headingOne;
	}

	public String getHeadingTwo() {
		return headingTwo;
	}
	
	public int getNumberWithMesh() {
		return numberWithMesh;
	}

	public int getNumberWithNoMesh() {
		return numberWithNoMesh;
	}
	
	public String toString() {
		return String.format(
				"hasMesh=%s,majorKeyword=%s,minorKeyword=%s%n",
				hasMeshHeadings(),
				getHeadingOne(),
				getHeadingTwo());
	}

	
	

}
