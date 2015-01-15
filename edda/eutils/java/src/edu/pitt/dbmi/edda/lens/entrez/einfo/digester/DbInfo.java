package edu.pitt.dbmi.edda.lens.entrez.einfo.digester;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DbInfo {
	
	private String dbName;
	private String menuName;
	private String description;
	private String dbBuild;
	private String count;
	private String lastUpdate;
	private final Collection<Field> fieldList = new ArrayList<Field>() ;
	private final Collection<Link> linkList = new ArrayList<Link>();
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDbBuild() {
		return dbBuild;
	}
	public void setDbBuild(String dbBuild) {
		this.dbBuild = dbBuild;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Collection<Field> getFieldList() {
		return fieldList;
	}
	public Collection<Link> getLinkList() {
		return linkList;
	}
	
	public void addField(Field field) {
		fieldList.add(field);
	}
	
	public void addLink(Link link) {
		linkList.add(link);
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
