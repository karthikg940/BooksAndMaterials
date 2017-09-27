package com.virtusa.vhub.partner2.resource.interfac;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/api/commandResponseHandler")
public interface FinalResponseHandlerResource {

	@POST
	void processFinalResponse(String commandResponseEntity);
}
