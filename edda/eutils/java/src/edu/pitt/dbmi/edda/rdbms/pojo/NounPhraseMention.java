package edu.pitt.dbmi.edda.rdbms.pojo;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="NOUN_PHRASE_MENTION")
@Proxy(lazy = true)
public class NounPhraseMention {
	
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
//	@Column(name = "CONTENT", columnDefinition="TEXT", length = 65535)
	@Column(name = "CONTENT", columnDefinition="TEXT", length = 16777215)
	protected String content;
	public String getContent() {
		return content;
	}
	public void setContent(String nounPhraseText) {
		this.content = nounPhraseText;
	}
	
//	@Column(name = "STEMMED_CONTENT", length = 255)
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
	
	@ManyToOne(targetEntity = NormalizedNounPhrase.class)
	@JoinColumn(name = "NORMALIZED_NOUN_PHRASE_ID")
	private NormalizedNounPhrase normalizedNounPhrase;
	public NormalizedNounPhrase getNormalizedNounPhrase() {
		return normalizedNounPhrase;
	}
	public void setNormalizedNounPhrase(NormalizedNounPhrase normalizedNounPhrase) {
		this.normalizedNounPhrase = normalizedNounPhrase;
	}
	
	@OneToMany(targetEntity = WordMention.class, cascade = {CascadeType.ALL})
	@JoinColumn(name = "NOUN_PHRASE_MENTION_ID")
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
		wordMention.setNounPhraseMention(this);
	}
	
	@Column(name = "SCORE")
	protected Double score;
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getName() + "\n");
		sb.append(getContent());
		return sb.toString();
	}
	
}
