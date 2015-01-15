package edu.pitt.dbmi.edda.rdbms.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="parsed")
@Proxy(lazy = true)
public class EndNoteLibraryOutput {
	
	@Id
	@GeneratedValue(generator="nativeGenerator")
	@GenericGenerator(name = "nativeGenerator", strategy = "native")
	private Long id;
	public Long getId() {
	    return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "REFERENCE_TYPE", length = 255)
	private String referenceType;
	public String getReferenceType() {
		return referenceType;
	}
	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}
	
	@Column(name = "RECORD_NUMBER")
	private Integer recordNumber;
	public Integer getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(Integer recordNumber) {
		this.recordNumber = recordNumber;
	}
	
	@Column(name = "AUTHOR", columnDefinition="TEXT", length = 65535)
	private String author;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name = "AUTHOR_ADDRESS", columnDefinition="TEXT", length = 65535)
	private String authorAddress;
	public String getAuthorAddress() {
		return authorAddress;
	}
	public void setAuthorAddress(String authorAddress) {
		this.authorAddress = authorAddress;
	}
	
	@Column(name = "YEAR")
	private Integer year;
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	@Column(name = "TITLE", columnDefinition="TEXT", length = 65535)
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "JOURNAL", columnDefinition="TEXT", length = 65535)
	private String journal;
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	
	@Column(name = "ORIGINAL_PUBLICATION", columnDefinition="TEXT", length = 65535)
	private String originalPublication;
	public String getOriginalPublication() {
		return originalPublication;
	}
	public void setOriginalPublication(String originalPublication) {
		this.originalPublication = originalPublication;
	}
	
	@Column(name = "VOLUME", length = 255)
	private String volume;
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	@Column(name = "ISSUE", length = 255)
	private String issue;
	public String getIssue() {
		return issue;
	}
	public void setIssue(String Issue) {
		this.issue = Issue;
	}
	
	@Column(name = "PAGES", length = 255)
	private String pages;
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	
	@Column(name = "SHORT_TITLE", columnDefinition="TEXT", length = 65535)
	private String shortTitle;
	public String getShortTitle() {
		return shortTitle;
	}
	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}
	
	@Column(name = "ISSN", length = 255)
	private String issn;
	public String getIssn() {
		return issn;
	}
	public void setIssn(String issn) {
		this.issn = issn;
	}
	
	@Column(name = "KEYWORDS", columnDefinition="TEXT", length = 65535)
	private String keywords;
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	@Column(name = "ENTRY_ABSTRACT", columnDefinition="TEXT", length = 65535)
	private String entryAbstract  = "UNKNOWN";
	public String getEntryAbstract() {
		return entryAbstract;
	}
	public void setEntryAbstract(String entryAbstract) {
		this.entryAbstract = entryAbstract;
	}
	
	@Column(name = "URL", columnDefinition="TEXT", length = 65535)
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
//	Epub Date:
	@Column(name = "EPUB_DATE", length = 255)
	private String ePubDate;
	public String getEpubDate() {
		return ePubDate;
	}
	public void setEpubDate(String ePubDate) {
		this.ePubDate = ePubDate;
	}
	
//	Date:
	@Column(name = "ENTRY_DATE", length = 255)
	private String entryDate;
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	
//	Accession Number
	@Column(name = "ACCESSION_NUMBER", length = 255)
	private String accessionNumber;
	public String getAccessionNumber() {
		return accessionNumber;
	}
	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}
	
//	Notes:
	@Column(name = "NOTES", columnDefinition="TEXT", length = 65535)
	private String notes  = "UNKNOWN";
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
//	Database Provider:
	@Column(name = "DATABASE_PROVIDER", length = 255)
	private String databaseProvider;
	public String getDatabaseProvider() {
		return databaseProvider;
	}
	public void setDatabaseProvider(String databaseProvider) {
		this.databaseProvider = databaseProvider;
	}
	
//	Language:
	@Column(name = "LANGUAGE", length = 255)
	private String language;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "DOI", columnDefinition="TEXT", length = 65535)
	private String doi = "UNKNOWN";
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	
	@Column(name = "INTERNAL_PDF", columnDefinition="TEXT", length = 65535)
	private String internalPdf = "UNKNOWN";
	public String getInternalPdf() {
		return internalPdf;
	}
	public void setInternalPdf(String internalPdf) {
		this.internalPdf = internalPdf;
	}
	
	@Column(name = "PMCID", length = 255)
	private String pmcid = "UNKNOWN";
	public String getPmcid() {
		return pmcid;
	}
	public void setPmcid(String pmcid) {
		this.pmcid = pmcid;
	}
	
	@Column(name = "PDF_TEXT", columnDefinition="TEXT", length = 16777215)
	protected String pdfText = "UNKNOWN";
	public String getPdfText() {
		return pdfText;
	}
	public void setPdfText(String pdfText) {
		this.pdfText = pdfText;
	}
	
	@Column(name = "HUMAN_PDF", columnDefinition="TEXT", length = 16777215)
	protected String humanPdf = "UNKNOWN";
	public String getHumanPdf() {
		return humanPdf;
	}
	public void setHumanPdf(String humanPdf) {
		this.humanPdf = humanPdf;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getName() + "\n");
//		sb.append("\tdomain => " + getDomain() + "\n");
//		sb.append("\tpartition => " + getPartition() + "\n");
//		sb.append("\tclassification => " + getClassification() + "\n");
		sb.append("\tauthors => " + getAuthor() + "\n");
		sb.append("\ttitle => " + getTitle() + "\n");
		sb.append("\tabstract => " + getEntryAbstract() + "\n");
		return sb.toString();
	}
	
	
}
