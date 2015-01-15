package edu.pitt.dbmi.edda.rdbms.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="ARTICLE_IDENTIFIER")
@Proxy(lazy = true)
public class ArticleIdentifier {
	
	@Id
	@GeneratedValue(generator="nativeGenerator")
	@GenericGenerator(name = "nativeGenerator", strategy = "native")
	protected Long id;
	public Long getId() {
	    return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "ID_TYPE", length = 255)
	protected String idType = "UNKNOWN";
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	
	@Column(name = "ID_VALUE", length = 255)
	protected String idValue = "UNKNOWN";
	public String getIdValue() {
		return idValue;
	}
	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}
	
	@ManyToOne(targetEntity = Publication.class)
	@JoinColumn(name = "PUBLICATION_ID")
	private Publication publication;
	public Publication getPublication() {
		return publication;
	}	
	public void setPublication(Publication publication) {
		this.publication = publication;
	}


}
