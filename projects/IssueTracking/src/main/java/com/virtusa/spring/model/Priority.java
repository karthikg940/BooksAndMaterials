package com.virtusa.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PRIORITY")
public class Priority {
	@Id
	@GeneratedValue
	@Column(name="PRIORITY_ID")
	private int priorityId;
	@Column(name="PRIORITY_NAME")
	private String priorityName;
	
	public Priority() {
		super();
	}

	public Priority(int priorityId, String priorityName) {
		super();
		this.priorityId = priorityId;
		this.priorityName = priorityName;
	}

	public int getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	@Override
	public String toString() {
		return "Priority [priorityId=" + priorityId + ", priorityName="
				+ priorityName + "]";
	}
	
}