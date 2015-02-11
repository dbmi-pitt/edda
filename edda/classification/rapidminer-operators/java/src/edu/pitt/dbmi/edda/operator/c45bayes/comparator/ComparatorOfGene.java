package edu.pitt.dbmi.edda.operator.c45bayes.comparator;

import java.util.Comparator;

import edu.pitt.dbmi.edda.operator.c45bayes.pojos.Gene;

public class ComparatorOfGene implements Comparator<Gene> {
	
	public int compare(Gene gene0, Gene gene1) {
		return gene0.getName().compareTo(gene1.getName());
	}

}
