package com.virtusa.vhub.partner1.resource.interfac;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/commandResponseHandler")
public interface FinalResponseHandlerResource {

	@POST
	void processFinalResponse(String commandResponseEntity);
}
