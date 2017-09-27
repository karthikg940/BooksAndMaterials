package com.virtusa.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATUS")
public class Status {
	@Id
	@GeneratedValue
	@Column(name="STATUS_ID")
	private int statusId;
	@Column(name="STATUS_NAME")
	private String statusName;
	public Status() {
		super();
	}
	public Status(int statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusName=" + statusName
				+ "]";
	}
	
}
