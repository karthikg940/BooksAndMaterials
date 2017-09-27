package com.virtusa.vhub.partner1.resource.interfac;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.virtusa.vhub.entity.Receive;

@Path("partner")
public interface CommandBuilder {

	@POST
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_XML)
	public String build(@PathParam("name") String name);
}
