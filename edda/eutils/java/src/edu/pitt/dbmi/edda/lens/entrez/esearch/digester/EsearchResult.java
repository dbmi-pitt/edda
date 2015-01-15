package edu.pitt.dbmi.edda.lens.entrez.esearch.digester;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class EsearchResult {

	private String count;
	private String retMax;
	private String retStart;
	private String queryKey;
	private String webEnv;
	private final Collection<Id> ids = new ArrayList<Id>();

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getRetMax() {
		return retMax;
	}

	public void setRetMax(String retMax) {
		this.retMax = retMax;
	}

	public String getRetStart() {
		return retStart;
	}

	public void setRetStart(String retStart) {
		this.retStart = retStart;
	}

	public String getQueryKey() {
		return queryKey;
	}

	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}

	public String getWebEnv() {
		return webEnv;
	}

	public void setWebEnv(String webEnv) {
		this.webEnv = webEnv;
	}

	public void addId(Id id) {
		ids.add(id);
	}

	public Collection<Id> getIds() {
		return ids;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
