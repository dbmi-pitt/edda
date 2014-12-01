package edu.pitt.dbmi.edda.rulebase;

import java.io.Serializable;

public class Identifiable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static int idGenerator = 0;
	
	protected Integer id;
	protected Integer isActivated;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Integer isActivated) {
		this.isActivated = isActivated;
	}

	public Identifiable() {
		id = idGenerator++;
		isActivated = 1;
	}

}
