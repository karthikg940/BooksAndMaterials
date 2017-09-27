package com.virtusa.lilly.resource;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class MockServiceImpl implements MockServiceInterface {
	
	
	public MockServiceImpl() {
		super();
	}

	public Response create(String xmlData) {
		System.out.println("entered");
		if (xmlData.isEmpty()) {
			return Response.status(Status.BAD_REQUEST).entity("bad request")
					.build();
		} else {
			return Response.status(Status.CREATED).entity("created").build();
		}
	}

	public String get(Long id) {
		return "Hello World";
	}

	public String getAll() {
		return "HelloWorld";
	}

	public Response update(String xmlData) {
		if (xmlData.isEmpty()) {
			return Response.status(Status.BAD_REQUEST).entity("bad request")
					.build();
		} else {
			return Response.status(Status.OK)
					.entity("updated successfully").build();
		}

	}

	public Response update(String xmlData, Long id) {
		if (xmlData.isEmpty()) {
			return Response.status(Status.BAD_REQUEST).entity("bad request")
					.build();
		} else {
			return Response.status(Status.OK)
					.entity("updated successfully").build();
		}

	}

	public Response delete(Long id) {

			return Response.status(Status.NO_CONTENT).build();
		
	}

	 
	
	

}
