package edu.pitt.dbmi.edda.lens.entrez.einfo.digester;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Field {
	
	private String name;
	private String fullName;
	private String description;
	private String termCount;
	private String isDate;
	private String isNumerical;
	private String singleToken;
	private String hierarchy;
	private String isHidden;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTermCount() {
		return termCount;
	}
	public void setTermCount(String termCount) {
		this.termCount = termCount;
	}
	public String getIsDate() {
		return isDate;
	}
	public void setIsDate(String isDate) {
		this.isDate = isDate;
	}
	public String getIsNumerical() {
		return isNumerical;
	}
	public void setIsNumerical(String isNumerical) {
		this.isNumerical = isNumerical;
	}
	public String getSingleToken() {
		return singleToken;
	}
	public void setSingleToken(String singleToken) {
		this.singleToken = singleToken;
	}
	public String getHierarchy() {
		return hierarchy;
	}
	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}
	public String getIsHidden() {
		return isHidden;
	}
	public void setIsHidden(String isHidden) {
		this.isHidden = isHidden;
	}
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
