package com.virtusa.bean;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class JMSComponent {
	
	public static void main(String[] args) throws Exception {
		
		CamelContext context=new DefaultCamelContext();
		ConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		context.addComponent("JMS", JmsComponent.jmsComponentAutoAcknowledge(factory));
		context.addRoutes(new RouteBuilder()   {
			
			@Override
			public void configure() throws Exception {
				from("JMS:queue:LLY.TRAINING.EMAIL.REQ").to("JMS:queue:Practice")
				.bean(JMSComponentBean.class,"response");
				
			}
		});
		context.start();
		Thread.sleep(1000);
		context.stop();
	}

}
