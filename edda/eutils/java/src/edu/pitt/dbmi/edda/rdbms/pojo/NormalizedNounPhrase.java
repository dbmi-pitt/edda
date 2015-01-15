package edu.pitt.dbmi.edda.rdbms.pojo;

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

import org.hibernate.annotations.Index;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="NORMALIZED_NOUN_PHRASE")
@Proxy(lazy = true)
public class NormalizedNounPhrase {
	
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
		
	@Index(name = "NORM_NOUN_CONTENT_IDX")
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
	
	@OneToMany(targetEntity = NounPhraseMention.class, cascade = {CascadeType.ALL})
	@JoinColumn(name = "NORMALIZED_WORD_ID")
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
		nounPhraseMention.setNormalizedNounPhrase(this);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getName() + "\n");
		sb.append(getContent());
		return sb.toString();
	}
	
}
