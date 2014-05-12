package edu.pitt.dbmi.edda.summarization.rdbms.pojos;

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
@Table(name="WORD_MENTION")
@Proxy(lazy = true)
public class WordMention {
	
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
		
//	@Column(name = "CONTENT", length = 255)
	@Column(name = "CONTENT",  columnDefinition="TEXT", length = 16777215)
	protected String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "STEMMED_CONTENT", columnDefinition="TEXT", length = 16777215)
	protected String stemmedContent;
	public String getStemmedContent() {
		return stemmedContent;
	}
	public void setStemmedContent(String stemmedContent) {
		this.stemmedContent = stemmedContent;
	}
	
	@ManyToOne(targetEntity = Document.class)
	@JoinColumn(name = "DOCUMENT_ID")
	private Document document;
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	
	@Column(name = "DOCUMENT_SPOS")
	protected Integer documentSPos;
	public Integer getDocumentSPos() {
		return documentSPos;
	}
	public void setDocumentSPos(Integer documentSPos) {
		this.documentSPos = documentSPos;
	}
	
	@Column(name = "DOCUMENT_EPOS")
	protected Integer documentEPos;
	public Integer getDocumentEPos() {
		return documentEPos;
	}
	public void setDocumentEPos(Integer documentEPos) {
		this.documentEPos = documentEPos;
	}
	
	@Column(name = "CLUSTER")
	private Integer cluster = -1;
	public Integer getCluster() {
		return cluster;
	}
	public void setCluster(Integer cluster) {
		this.cluster = cluster;
	}
	
	@ManyToOne(targetEntity = Sentence.class)
	@JoinColumn(name = "SENTENCE_ID")
	private Sentence sentence;
	public Sentence getSentence() {
		return sentence;
	}
	public void setSentence(Sentence sentence) {
		this.sentence = sentence;
	}
	
	@Column(name = "SENTENCE_SPOS")
	protected Integer sentenceSPos;
	public Integer getSentenceSPos() {
		return sentenceSPos;
	}
	public void setSentenceSPos(Integer sentenceSPos) {
		this.sentenceSPos = sentenceSPos;
	}
	
	@Column(name = "SENTENCE_EPOS")
	protected Integer sentenceEPos;
	public Integer getSentenceEPos() {
		return sentenceEPos;
	}
	public void setSentenceEPos(Integer sentenceEPos) {
		this.sentenceEPos = sentenceEPos;
	}
	
	@Column(name = "IS_STOP_WORD")
	private java.lang.Boolean isStopWord = false;
	public java.lang.Boolean getIsStopWord() {
		return isStopWord;
	}
	public void setIsStopWord(java.lang.Boolean isStopWord) {
		this.isStopWord = isStopWord;
	}
	
	@ManyToOne(targetEntity = NormalizedWord.class)
	@JoinColumn(name = "NORMALIZED_WORD_ID")
	private NormalizedWord normalizedWord;
	public NormalizedWord getNormalizedWord() {
		return normalizedWord;
	}
	public void setNormalizedWord(NormalizedWord normalizedWord) {
		this.normalizedWord = normalizedWord;
	}
	
	@ManyToOne(targetEntity = NounPhraseMention.class)
	@JoinColumn(name = "NOUN_PHRASE_MENTION_ID")
	private NounPhraseMention nounPhraseMention;
	public NounPhraseMention getNounPhraseMention() {
		return nounPhraseMention;
	}
	public void setNounPhraseMention(NounPhraseMention nounPhraseMention) {
		this.nounPhraseMention = nounPhraseMention;
	}
	
	@Column(name = "IS_KEYWORD")
	private java.lang.Boolean isKeyword = false;
	public java.lang.Boolean getIsKeyword() {
		return isKeyword;
	}
	public void setIsKeyword(java.lang.Boolean isKeyword) {
		this.isKeyword = isKeyword;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getName() + "\n");
		sb.append(getContent());
		return sb.toString();
	}
	
}
