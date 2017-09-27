package com.virtusa.lly.karafcxf.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ext.Provider;

//Maps for the `say` in the URL

@Path("say")
public interface HelloResource {

	@GET
	@Path("hello/{name}")
	// Maps for the `hello/John` in the URL
	public String handleGet(@PathParam("name") String name);
	
	@POST
	@Path("hello/")
	
	public String create();

}
