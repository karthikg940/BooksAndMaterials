package com.virtusa.component;

import org.apache.camel.Handler;

public class JDBCComponentBeanTOSQL {

	@Handler
	public String tosql() {
		System.out.println("entered into the tosql method");
		String query="insert into user(id,firstName,lastName) values(9999,'qwerty',789999);";
				return query;
	}
}
