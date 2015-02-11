package edu.pitt.dbmi.edda.lens.entrez.einfo.digester;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Link {
	
	private String name;
	private String menu;
	private String description;
	private String dbTo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDbTo() {
		return dbTo;
	}
	public void setDbTo(String dbTo) {
		this.dbTo = dbTo;
	}
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
