package com.virtusa.routebuilder;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.spi.DataFormat;

public class CustomDataFormat {
	public static void main(String[] args) throws Exception {
		CamelContext context=new DefaultCamelContext();
		
		/*ConnectionFactory factory = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");
		context.addComponent("JMS",
				JmsComponent.jmsComponentAutoAcknowledge(factory));*/
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("file://c:/tmp?fileName=inbox.txt&noop=true")
				.marshal(new ReverseDataFormat())
				.to("log:reverse?showAll=true&level=INFO");
				 
				/*.to("log:unmarshall?showAll=true&level=INFO")
				.to("JMS:queue:LLY.TRAINING.EMAIL.IN?username=admin&password=admin");*/
		
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
	}
}
