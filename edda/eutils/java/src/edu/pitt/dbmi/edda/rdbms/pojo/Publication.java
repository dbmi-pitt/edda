package edu.pitt.dbmi.edda.rdbms.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="PUBLICATION")
@Proxy(lazy = true)
public class Publication {
	
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
	
	@Column(name = "TITLE", columnDefinition="TEXT", length = 65535)
	protected String title = "UNKNOWN";
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "AUTHORS", columnDefinition="TEXT", length = 65535)
	protected String authors = "UNKNOWN";
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	@Column(name = "URI_SEARCHER", columnDefinition="TEXT", length = 65535)
	protected String uriSearcher = "UNKNOWN";
	public String getUriSearcher() {
		return uriSearcher;
	}
	public void setUriSearcher(String uriSearcher) {
		this.uriSearcher = uriSearcher;
	}
	
	@Column(name = "URI_PDF", columnDefinition="TEXT", length = 65535)
	protected String uriPdf = "UNKNOWN";
	public String getUriPdf() {
		return uriPdf;
	}
	public void setUriPdf(String uriPdf) {
		this.uriPdf = uriPdf;
	}
	
	@Column(name = "URI_DOI", columnDefinition="TEXT", length = 65535)
	protected String uriDoi = "UNKNOWN";
	public String getUriDoi() {
		return uriDoi;
	}
	public void setUriDoi(String uriDoi) {
		this.uriDoi = uriDoi;
	}
	
	@Column(name = "ABSTRACT", columnDefinition="TEXT", length = 65535)
	protected String publicationAbstract  = "UNKNOWN";
	public String getPublicationAbstract() {
		return publicationAbstract;
	}
	public void setPublicationAbstract(String publicationAbstract) {
		this.publicationAbstract = publicationAbstract;
	}
	
	@Column(name = "DOMAIN", length = 255)
	protected String domain = "UNKNOWN";
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	@Column(name = "DATASET", length = 255)
	protected String partition  = "UNKNOWN";
	public String getPartition() {
		return partition;
	}
	public void setPartition(String partition) {
		this.partition = partition;
	}
	
	@Column(name = "CLASSIFICATION", length = 255)
	protected String classification = "UNKNOWN";
	public String getClassification() {
		return classification;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	@Column(name = "PUBMED_ID", length = 255)
	protected String pubMedId;
	public String getPubMedId() {
		return pubMedId;
	}
	
	public void setPubMedId(String pubMedId) {
		this.pubMedId = pubMedId;
	}
	
	
	@Column(name = "FNAME", columnDefinition="TEXT", length = 65535)
	protected String fileName = "UNKNOWN";
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(name = "FTEXT", columnDefinition="TEXT", length = 16777215)
	protected String fileText = "UNKNOWN";
	public String getFileText() {
		return fileText;
	}
	public void setFileText(String fileText) {
		this.fileText = fileText;
	}

	@Column(name = "EFETCH_XML", columnDefinition="TEXT", length = 16777215)
	protected String efetchXml = "UNKNOWN";
	public String getEfetchXml() {
		return efetchXml;
	}
	public void setEfetchXml(String efetchXml) {
		this.efetchXml = efetchXml;
	}
	
	@OneToMany(targetEntity = ArticleIdentifier.class, cascade = {CascadeType.ALL})
	@JoinColumn(name = "PUBLICATION_ID")
	private java.util.Collection<ArticleIdentifier> articleIdentifierCollection = new java.util.HashSet<ArticleIdentifier>();
	public java.util.Collection<ArticleIdentifier> getArticleIdentifierCollection() {
		return articleIdentifierCollection;
	}
	public void setArticleIdentifierCollection(
			java.util.Collection<ArticleIdentifier> articleIdentifierCollection) {
		this.articleIdentifierCollection = articleIdentifierCollection;
	}
	public void addArticleIdentifier(ArticleIdentifier articleIdentifier) {
		this.articleIdentifierCollection.add(articleIdentifier);
		articleIdentifier.setPublication(this);
	}

//	@Column(name = "CONTENT", columnDefinition="TEXT", length = 16777215)
//	@Column(name = "CONTENT", columnDefinition="TEXT", length = 65535)

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getName() + "\n");
		sb.append("\tdomain => " + getDomain() + "\n");
		sb.append("\tpartition => " + getPartition() + "\n");
		sb.append("\tclassification => " + getClassification() + "\n");
		sb.append("\tauthors => " + getAuthors() + "\n");
		sb.append("\ttitle => " + getTitle() + "\n");
		sb.append("\tabstract => " + getPublicationAbstract() + "\n");
		sb.append("\tpubMedId => " + getPubMedId() + "\n");
		return sb.toString();
	}

	
}
