package com.virtusa.routebuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.BasicConfigurator;

public class FileToQueue {
	
	public static void main(String[] args) throws Exception {
		
		ExecutorService executor= Executors.newFixedThreadPool(16);
		CamelContext context=new DefaultCamelContext();
		ConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		context.addComponent("JMS", JmsComponent.jmsComponentAutoAcknowledge(factory));
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("file://c:/tmp?fileName=inbox.txt&noop=true")
				//.process(new Order)
				.wireTap("file://c:/tmp?fileName=outbox.txt")
				.filter().xpath("id/value = 'Helloworld'")
				.process(new Processor() {
					
					@Override
					public void process(Exchange exchange) throws Exception {
						
						System.out.println("exchange output message"+exchange.getIn().getBody(String.class));
						
					}
				})
				.to("file://c:/tmp?fileName=otbox.txt");
				/*.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						System.out.println(exchange.getIn().getBody().toString());
						System.out.println(exchange.getIn().getHeaders());
						
					}
				})*/
				/*.choice()
				.when(header("CamelFileName").endsWith(".xml"))
				.to("JMS:queue:LLY.TRAINING.EMAIL.IN?username=admin&password=admin")
				.when(header("CamelFileName").endsWith(".txt"))
				.to("JMS:queue:LLY.TRAINING.EMAIL.OUT?username=admin&password=admin")
				.to("file://c:/tmp?fileName=outbox.xml")
				.otherwise()*/
				//.to("JMS:queue:LLY.TRAINING.EMAIL.OUT?username=admin&password=admin");
				/*.end();*/
				
			/*	from("JMS:queue:LLY.TRAINING.EMAIL.OUT?username=admin&password=admin")
				.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						System.out.println(exchange.getIn().getBody());
						
					}
				})
				
				.multicast().executorService(executor).parallelProcessing()
				.to("JMS:queue:LLY.TRAINING.EMAIL.RES?username=admin&password=admin")
				.to("file://c:/tmp?fileName=outbox.txt","file://c:/tmp?fileName=otbox.txt")
				;	 */
		
				
				
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
	}

}
