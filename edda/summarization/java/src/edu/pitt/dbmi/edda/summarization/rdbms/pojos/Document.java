package edu.pitt.dbmi.edda.summarization.rdbms.pojos;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="DOCUMENT")
@Proxy(lazy = true)
public class Document {
	
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
	
	@Column(name = "URL", columnDefinition="TEXT", length = 65535)
	protected String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name = "SEQUENCE")
	private Integer sequence = -1;
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
	@Column(name = "CLUSTER")
	private Integer cluster = -1;
	public Integer getCluster() {
		return cluster;
	}
	public void setCluster(Integer cluster) {
		this.cluster = cluster;
	}
	
	
	@Column(name = "CONTENT", columnDefinition="LONGTEXT")
//	@Column(name = "CONTENT", columnDefinition="TEXT", length = 65535)
	protected String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@OneToMany(targetEntity = Sentence.class, cascade = {CascadeType.ALL})
	@JoinColumn(name = "DOCUMENT_ID")
	private Collection<Sentence> sentenceCollection = new HashSet<Sentence>();
	public Collection<Sentence> getSentenceCollection() {
		return sentenceCollection;
	}
	public void setSentenceCollection(
			Collection<Sentence> sentenceCollection) {
		this.sentenceCollection = sentenceCollection;
	}
	public void addSentence(Sentence sentence) {
		this.sentenceCollection.add(sentence);
		sentence.setDocument(this);
	}
	
	@OneToMany(targetEntity = NounPhraseMention.class, cascade = {CascadeType.ALL})
	@JoinColumn(name = "DOCUMENT_ID")
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
		nounPhraseMention.setDocument(this);
	}
	
	@OneToMany(targetEntity = WordMention.class, cascade = {CascadeType.ALL})
	@JoinColumn(name = "DOCUMENT_ID")
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
		wordMention.setDocument(this);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getName() + "\n");
		sb.append("\turl => " + getUrl() + "\n");
		sb.append("\tsequence => " + getSequence() + "\n");
		sb.append("\tcluster => " + getCluster() + "\n");
		return sb.toString();
	}
	
}
