package com.virtusa.routebuilder;

import java.io.Serializable;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.Link;


@CsvRecord(separator="," ,isOrdered=true)
public class BindyBean implements Serializable {

	@DataField(pos=1)
	private int id;
	@DataField(pos=2)
	private String name;
//	@Link
//	private OrderBean orderBean;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BindyBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public BindyBean() {
		super();
	}
	
	
	
}
