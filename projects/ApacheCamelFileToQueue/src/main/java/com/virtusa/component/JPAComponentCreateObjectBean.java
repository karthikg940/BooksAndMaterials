package com.virtusa.component;

import org.apache.camel.Handler;

public class JPAComponentCreateObjectBean {

	@Handler
	public JPAPurchaseOrderBean createBeanObject(){
		System.out.println("entered into the JPA Component bean class");
		return new JPAPurchaseOrderBean(9999,"firstName","123456789");
	}
}
