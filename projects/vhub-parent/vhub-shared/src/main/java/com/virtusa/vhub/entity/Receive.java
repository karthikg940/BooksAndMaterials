package com.virtusa.vhub.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Receive {

	private String status;
	private String statusCode;
	private String statusDescription;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Receive(String status, String statusCode, String statusDescription
			 ) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.statusDescription = statusDescription;
	}

	public Receive() {
		super();
	}

	@Override
	public String toString() {
		return "Receive [status=" + status + ", statusCode=" + statusCode
				+ ", statusDescription=" + statusDescription + "]";
	}
	
	

}
