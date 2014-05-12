package edu.pitt.dbmi.edda.summarization.rdbms.pojos;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="SENTENCE")
@Proxy(lazy = true)
public class Sentence {
	
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
	private Integer documentSPos;
	public Integer getDocumentSPos() {
		return documentSPos;
	}
	public void setDocumentSPos(Integer documentSPos) {
		this.documentSPos = documentSPos;
	}
	
	@Column(name = "DOCUMENT_EPOS")
	private Integer documentEPos;
	public Integer getDocumentEPos() {
		return documentEPos;
	}
	public void setDocumentEPos(Integer documentEPos) {
		this.documentEPos = documentEPos;
	}
	
	@Column(name = "SENTENCE_SEQ")
	private Integer sentenceSeq;
	public Integer getSentenceSeq() {
		return sentenceSeq;
	}
	public void setSentenceSeq(Integer sentenceSeq) {
		this.sentenceSeq = sentenceSeq;
	}

//	@Column(name = "CONTENT", columnDefinition="TEXT", length = 65535)
	@Column(name = "CONTENT", columnDefinition="MEDIUMTEXT")
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@OneToMany(targetEntity = NounPhraseMention.class, cascade = {CascadeType.ALL})
	@JoinColumn(name = "SENTENCE_ID")
	private Collection<NounPhraseMention> nounPhraseMentionCollection = new HashSet<NounPhraseMention>();
	public Collection<NounPhraseMention> getNounPhraseMentionCollection() {
		return nounPhraseMentionCollection;
	}
	public void setNounPhraseMentionCollection(
			Collection<NounPhraseMention> nounPhraseMentionCollection) {
		this.nounPhraseMentionCollection = nounPhraseMentionCollection;
	}
	public void addNounPhraseMention(NounPhraseMention nounPhraseMention) {
		this.nounPhraseMentionCollection.add(nounPhraseMention);
		nounPhraseMention.setSentence(this);
	}
	
	@OneToMany(targetEntity = WordMention.class, cascade = {CascadeType.ALL})
	@JoinColumn(name = "SENTENCE_ID")
	private Collection<WordMention> wordMentionCollection = new HashSet<WordMention>();
	public Collection<WordMention> getWordMentionCollection() {
		return wordMentionCollection;
	}
	public void setWordMentionCollection(
			Collection<WordMention> wordMentionCollection) {
		this.wordMentionCollection = wordMentionCollection;
	}
	public void addWordMention(WordMention wordMention) {
		this.wordMentionCollection.add(wordMention);
		wordMention.setSentence(this);
	}
	
	@Column(name = "IS_ACTIVE")
	private java.lang.Boolean isActive = false;
	public java.lang.Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(java.lang.Boolean isActive) {
		this.isActive = isActive;
	}
	
	@Column(name = "CLUSTER")
	private Integer cluster = -1;
	public Integer getCluster() {
		return cluster;
	}
	public void setCluster(Integer cluster) {
		this.cluster = cluster;
	}
	
	@Column(name = "WORD_COUNT")
	private Double wordCount = 0.0d;
	public Double getWordCount() {
		return wordCount;
	}
	public void setWordCount(Double wordCount) {
		this.wordCount = wordCount;
	}
	
	@Column(name = "SCORE")
	private Double score = 0.0d;
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	
	@Column(name = "RELATIVE_SCORE")
	private Double relativeScore = 0.0d;
	public Double getRelativeScore() {
		return relativeScore;
	}
	public void setRelativeScore(Double relativeScore) {
		this.relativeScore = relativeScore;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getName() + "\n");
		sb.append("\t(" + getDocumentSPos() + ", " + getDocumentEPos() + ") ");
		sb.append(getContent());
		return sb.toString();
	}
	
}
