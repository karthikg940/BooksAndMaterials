package com.virtusa.routebuilder;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class TransformingXML {
	public static void main(String[] args) throws Exception {
		
		CamelContext context=new DefaultCamelContext();
		ConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		context.addComponent("JMS", JmsComponent.jmsComponentAutoAcknowledge(factory));
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file://c:/tmp?fileName=inbox.txt&noop=true")
//				from("file://c:/tmp?fileName=xmltojava.xml&noop=true")
				.process(new TransformXMLProcessor())
				.marshal().xstream()
				.to("JMS:queue:LLY.TRAINING.EMAIL.REQ?username=admin&password=admin");
				
				 /*from("JMS:queue:LLY.TRAINING.EMAIL.RES?username=admin&password=admin")
				.unmarshal().xstream(PurchaseOrder.class)
				.process(new Processor() {
					
					@Override
					public void process(Exchange exchange) throws Exception {
						System.out.println(exchange);
						
					}
				})
				.to("file://c:/tmp?fileName=javatoxml.txt");*/
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
			}
	}

//"com.virtusa.routebuilder.PurchaseOrder"