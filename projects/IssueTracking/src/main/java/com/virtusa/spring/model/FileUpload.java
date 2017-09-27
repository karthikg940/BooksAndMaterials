package com.virtusa.spring.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="TICKET_FILE")
public class FileUpload {

	@Column(name="FILE_ID")
	@Id
	@GeneratedValue
	int fileId;
	@Lob
	@Column(name="FILE_DATA")
	private byte[] fileData;
 
	@OneToOne(/*cascade = CascadeType.ALL*/)
	@JoinColumn(name="TICKET_ID",referencedColumnName="TICKET_ID")
	private Ticket ticket;
	public FileUpload(int fileId, byte[] fileData) {
		super();
		this.fileId = fileId;
		this.fileData = fileData;
	}

	
	public FileUpload() {
		super();
	}


	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}


	public Ticket getTicket() {
		return ticket;
	}


	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}


	@Override
	public String toString() {
		return "FileUpload [fileId=" + fileId + ", fileData="
				+ Arrays.toString(fileData) + ", ticket=" + ticket + "]";
	}
	
	
}
