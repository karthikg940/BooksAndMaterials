package com.virtusa.vhub.hub;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.virtusa.vhub.entity.Command;

@Path("api")
public interface CommandRouter {
	@POST
	@Path("/commandrouter")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Command router(Command command);
}
