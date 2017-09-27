package com.virtusa.routebuilder;

import javax.jms.ConnectionFactory;
import javax.xml.bind.JAXBContext;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.impl.DefaultCamelContext;

public class CSVToObject {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");
		context.addComponent("JMS",
				JmsComponent.jmsComponentAutoAcknowledge(factory));
		
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {

				from("file://c:/tmp?fileName=inbox.txt&noop=true")
						.process(new TransformXMLProcessor())
						.marshal()
						.jaxb("com.virtusa.routebuilder")
						.to("file://c:/tmp?fileName=xmltojava1.txt")
						.to("JMS:queue:LLY.TRAINING.EMAIL.IN?username=admin&password=admin");

				from(
						"JMS:queue:LLY.TRAINING.EMAIL.IN?username=admin&password=admin")
						.unmarshal()
						.jaxb("com.virtusa.routebuilder")
						.process(new Processor() {
							@Override
							public void process(Exchange exchange)
									throws Exception {
								System.out.println(exchange.getIn().getBody(
										OrderBean.class));
							}
						})
						.to("JMS:queue:LLY.TRAINING.EMAIL.OUT?username=admin&password=admin");
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
	}
}