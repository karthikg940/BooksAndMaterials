package com.virtusa.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FUNCTIONS")
public class Functions {
	
	@Id
	@GeneratedValue
	@Column(name="FUNCTION_ID")
	private int functionId;
	
	@Column(name="FUNCTION_NAME")
	private String functionName;

	public Functions() {
		super();
	}

	public Functions(int functionId, String functionName) {
		super();
		this.functionId = functionId;
		this.functionName = functionName;
	}

	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Override
	public String toString() {
		return "Functions [functionId=" + functionId + ", functionName="
				+ functionName + "]";
	}
	
}
