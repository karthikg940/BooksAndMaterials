package com.virtusa.vhub.consumer3;

import java.io.Serializable;

import javax.jms.Destination;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.activemq.command.Command;


@XmlRootElement
public class CommandMessages implements Serializable {

	private Command command;
	private String response;
	private Destination replyTo;
	private String corelationId;
	private String commandCallbackUrl;

	
	public CommandMessages() {
		super();
	}
	 
	public CommandMessages(Command command, String response,
			Destination replyTo, String corelationId, String commandCallbackUrl) {
		super();
		this.command = command;
		this.response = response;
		this.replyTo = replyTo;
		this.corelationId = corelationId;
		this.commandCallbackUrl = commandCallbackUrl;
	}

	public String getCorelationId() {
		return corelationId;
	}
	public void setCorelationId(String corelationId) {
		this.corelationId = corelationId;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Destination getReplyTo() {
		return replyTo;
	}
	public void setReplyTo(Destination replyTo) {
		this.replyTo = replyTo;
	}

	public String getCommandCallbackUrl() {
		return commandCallbackUrl;
	}

	public void setCommandCallbackUrl(String commandCallbackUrl) {
		this.commandCallbackUrl = commandCallbackUrl;
	}
	
}
