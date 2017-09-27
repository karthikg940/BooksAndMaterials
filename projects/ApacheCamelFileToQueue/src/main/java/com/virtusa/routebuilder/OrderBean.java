package com.virtusa.routebuilder;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.camel.dataformat.bindy.annotation.Link;

//@Link
@XmlRootElement(name = "OrderBean")
public class OrderBean {

	private int id;
	private String name;
	private double amount;

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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public OrderBean(int id, String name, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}

	public OrderBean() {
		super();
	}

	@Override
	public String toString() {
		return "id:" + this.id + ", name:" + this.name + ", amount:"
				+ this.amount;
	}

}
