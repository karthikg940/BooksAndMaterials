package com.virtusa.lilly.resource;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.PATCH;

@Path("/virtusa")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public interface MockServiceInterface {
	 
	@GET
	@Path("/{id}")
	public String get(@PathParam("id") Long id);
	
	
	@Path("/lilly")
	public String getAll();
	
	 
	
}
