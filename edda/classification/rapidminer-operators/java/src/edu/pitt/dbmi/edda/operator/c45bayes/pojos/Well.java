package edu.pitt.dbmi.edda.operator.c45bayes.pojos;

import java.io.Serializable;

public class Well implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static long wellIndex = 0L ;
	private static Object newWellObject = new Object();
	public static Well newWell() {
		synchronized(newWellObject) {
			Well well = new Well() ;
			well.setId(wellIndex);
			wellIndex++;
			return well;
		}
	}
	
	private Long id;
	private double averageValue;
	private String nominalValue;
	private String key;
	
	private Well() {
		;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAverageValue() {
		return averageValue;
	}

	public void setAverageValue(double averageValue) {
		this.averageValue = Math.max(averageValue, 1.0e-4);
	}

	public String getNominalValue() {
		return nominalValue;
	}

	public void setNominalValue(String nominalValue) {
		this.nominalValue = nominalValue;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
