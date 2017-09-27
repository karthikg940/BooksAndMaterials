package com.virtusa.vhub.hub;

import java.util.logging.Logger;
//
//import org.apache.activemq.camel.component.ActiveMQComponent;
//import org.apache.camel.CamelContext;
//import org.apache.camel.ProducerTemplate;
//import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.impl.DefaultCamelContext;

import com.virtusa.vhub.entity.Command;

public class CommandRouterImpl {

	// JmsComponent jms;

	Logger LOGGER = Logger.getLogger(CommandRouterImpl.class.getName());

	public Command router(Command command) {
		// TODO Auto-generated method stub
		//System.out.println(command);
		return command;
	}

}
