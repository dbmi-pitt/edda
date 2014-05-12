package edu.pitt.dbmi.edda.operator.c45bayes.pojos;

import java.io.Serializable;

public class Gene implements Comparable<Gene>, Serializable {

	private static final long serialVersionUID = 1L;
	private static long geneIndex = 0L ;
	private static Object newGeneObject = new Object();
	public static Gene newGene() {
		synchronized(newGeneObject) {
			Gene gene = new Gene() ;
			gene.setId(geneIndex);
			geneIndex++;
			return gene;
		}
	}
	
	private Long id;
	private String name;

	private Gene() {
		;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append("Gene " + this.name + ":\n") ;
		return sb.toString();
		
	}

	@Override
	public int compareTo(Gene o) {
		return name.compareTo(o.getName());
	}


	
}
