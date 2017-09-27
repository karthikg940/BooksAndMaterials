package com.virtusa.vhub.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CommandWrapper")
public class Command {
	private String command;
	private int id;
	private String type;

	public Command(String command, int id, String type) {
		super();
		this.command = command;
		this.id = id;
		this.type = type;
	}

	public Command() {
		super();
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Command [command=" + command + ", id=" + id + ", type=" + type
				+ "]";
	}
}
