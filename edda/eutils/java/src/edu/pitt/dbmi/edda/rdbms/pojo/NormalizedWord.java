package edu.pitt.dbmi.edda.rdbms.pojo;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="NORMALIZED_WORD")
@Proxy(lazy = true)
public class NormalizedWord {
	
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
		
	@Index(name = "NORM_WORD_CONTENT_IDX")
	@Column(name = "CONTENT", length = 255)
	protected String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "FREQ")
	protected Double freq;
	public Double getFreq() {
		return freq;
	}
	public void setFreq(Double freq) {
		this.freq = freq;
	}
	
	@Column(name = "RELATIVE_FREQ")
	protected Double relativeFreq;
	public Double getRelativeFreq() {
		return relativeFreq;
	}
	public void setRelativeFreq(Double relativeFreq) {
		this.relativeFreq = relativeFreq;
	}
	
	@OneToMany(targetEntity = WordMention.class, cascade = {CascadeType.ALL})
	@JoinColumn(name = "NORMALIZED_WORD_ID")
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
		wordMention.setNormalizedWord(this);
	}
	
	@Column(name = "IS_ACTIVE")
	private java.lang.Boolean isActive = true;
	public java.lang.Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(java.lang.Boolean isActive) {
		this.isActive = isActive;
	}
	
	@Column(name = "IS_KEYWORD")
	private java.lang.Boolean isKeyword = false;
	public java.lang.Boolean getIsKeyword() {
		return isKeyword;
	}
	public void setIsKeyword(java.lang.Boolean isKeyword) {
		this.isKeyword = isKeyword;
	}
	
	@Column(name = "CLUSTER")
	private Integer cluster = -1;
	public Integer getCluster() {
		return cluster;
	}
	public void setCluster(Integer cluster) {
		this.cluster = cluster;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getName() + "\n");
		sb.append(getContent() + " " + getFreq());
		return sb.toString();
	}
	
}
