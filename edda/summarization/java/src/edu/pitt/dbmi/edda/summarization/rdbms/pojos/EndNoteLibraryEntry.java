package edu.pitt.dbmi.edda.summarization.rdbms.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="dumped")
@Proxy(lazy = true)
public class EndNoteLibraryEntry {
	
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
	
	@Column(name = "RECORD_NUMBER")
	private Integer recordNumber;
	public Integer getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(Integer recordNumber) {
		this.recordNumber = recordNumber;
	}
	
	@Column(name = "RECORD_TEXT", columnDefinition="TEXT", length = 65535)
	private String recordText;
	public String getRecordText() {
		return recordText;
	}
	public void setRecordText(String recordText) {
		this.recordText = recordText;
	}

	
}
