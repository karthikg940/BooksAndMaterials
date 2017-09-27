package com.virtusa.vhub.partner2.resource.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.virtusa.vhub.entity.Command;
import com.virtusa.vhub.partner2.resource.interfac.CommandBuilder;

public class CommandBuilderImpl implements CommandBuilder {

	
	private enum CommandCatalog {
		TRIGGER_JOB1(1, "COMMAND1"), TRIGGER_JOB2(2, "COMMAND1"), TRIGGER_JOB3(
				1, "COMMAND2"), TRIGGER_JOB4(1, "COMMAND3");
		private CommandCatalog(int id, String type) {
			this.id = id;
			this.type = type;

		}

		public int getId() {
			return id;
		}

		public String getType() {
			return type;
		}

		private int id;
		private String type;
	}

	@Override
	public String build(String commandName) {
		CommandCatalog commandCatalog = CommandCatalog.valueOf(commandName);

		Command cmdRequest = new Command();
		cmdRequest.setId(commandCatalog.getId());
		cmdRequest.setCommand(commandName);
		cmdRequest.setType(commandCatalog.getType());

		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client
				.target("http://localhost:8181/cxf/vhub/api/commandrouter");
		Entity<Command> commandRequestEntity = Entity
				.xml(cmdRequest);
		Builder builder = target.request();
		builder.accept(MediaType.APPLICATION_XML);
		builder.header("CommandType", cmdRequest.getType());
		builder.header("CommandCallbackUrl",
				"localhost:8181/cxf/command2/api/commandResponseHandler");
		Response response = builder.post(commandRequestEntity);
		String value = response.readEntity(String.class);
		return value;
		 
	}

	 

}
