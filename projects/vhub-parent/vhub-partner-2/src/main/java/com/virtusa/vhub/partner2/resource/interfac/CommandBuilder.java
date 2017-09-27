package com.virtusa.vhub.partner2.resource.interfac;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.virtusa.vhub.entity.Receive;

@Path("partner")
public interface CommandBuilder {

	@POST
	@Path("/{name}")
	@Produces("application/xml")
	public String build(@PathParam("name") String name);
}
