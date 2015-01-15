package edu.pitt.dbmi.edda.lens.entrez.efetch.digester.pubmed;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class MeshHeadingList {
	
	private Collection<MeshHeading> meshHeadings = new ArrayList<MeshHeading>();

	public Collection<MeshHeading> getMeshHeadings() {
		return meshHeadings;
	}

	public void setMeshHeadings(Collection<MeshHeading> meshHeadings) {
		this.meshHeadings = meshHeadings;
	}
	
	public void addMeshHeading(MeshHeading meshHeading) {
		meshHeadings.add(meshHeading);
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


}
