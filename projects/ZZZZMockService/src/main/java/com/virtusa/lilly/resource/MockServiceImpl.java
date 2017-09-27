package com.virtusa.lilly.resource;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class MockServiceImpl implements MockServiceInterface {
	
	
	public MockServiceImpl() {
		super();
	}

	
	public String get(Long id) {
		return "Hello World"+id;
	}

	public String getAll() {
		
		EmpService emp=new EmpService();
		return emp.toString();
	}

	 

}
