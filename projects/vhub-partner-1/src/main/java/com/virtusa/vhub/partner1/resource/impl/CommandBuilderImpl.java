package com.virtusa.vhub.partner1.resource.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.virtusa.vhub.entity.Command;
import com.virtusa.vhub.partner1.resource.interfac.CommandBuilder;

public class CommandBuilderImpl implements CommandBuilder {

	Command cmdRequest = new Command();
	
	private enum CommandCatalog {
		TRIGGER_JOB1(1, "COMMAND1"), TRIGGER_JOB2(2, "COMMAND2"), TRIGGER_JOB3(
				3, "COMMAND3");
		private CommandCatalog(final int id,final String type) {
			this.id = id;
			this.type = type;

		}

		public int getId() {
			return id;
		}

		public String getType() {
			return type;
		}

		private final int id;
		private final String type;
	}

	@Override
	public String build(final String commandName) {
		System.out.println(commandName);
		
		if(commandName.equals("TRIGGER_JOB1") || commandName.equals("TRIGGER_JOB2") || commandName.equals("TRIGGER_JOB3"))
		{
	    CommandCatalog commandCatalog = CommandCatalog.valueOf(commandName);
		System.out.println("after commandcatalog");
//		if(commandCatalog != null)
//		{
		cmdRequest.setId(commandCatalog.getId());
		cmdRequest.setCommand(commandName);
		cmdRequest.setType(commandCatalog.getType());
		}
//		}
		else
		{
			cmdRequest.setId(0);
			cmdRequest.setCommand(commandName);
			cmdRequest.setType(null);
		}
        System.out.println("before jaxrs client"  + cmdRequest);
		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client
				.target("http://localhost:8181/cxf/vhub/api/commandrouter");
		Entity<Command> commandRequestEntity = Entity
				.xml(cmdRequest);
		Builder builder = target.request();
		builder.accept(MediaType.APPLICATION_XML);
		builder.header("CommandType", cmdRequest.getType());
		System.out.println(cmdRequest.getType());
		builder.header("CommandCallbackUrl",
				"localhost:8181/cxf/command/api/commandResponseHandler");
//		builder.header("PreAuthenticated","true");
		System.out.println("after callback url");
		Response response = builder.post(commandRequestEntity);
		String value = response.readEntity(String.class);
		return value;
	}

}
