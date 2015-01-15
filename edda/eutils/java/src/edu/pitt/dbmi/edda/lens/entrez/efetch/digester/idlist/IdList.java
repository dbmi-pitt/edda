package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.idlist;

import java.util.ArrayList;
import java.util.Collection;

public class IdList {

	private final Collection<Id> ids = new ArrayList<Id>();

	public Collection<Id> getIds() {
		return ids;
	}
	
	public void addId(Id id) {
		ids.add(id);
	}

}
