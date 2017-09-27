package com.virtusa.routebuilder;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class CSVMarshallUnMarshall {

	public static void main(String[] args) throws Exception {
		CamelContext context=new DefaultCamelContext();
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");
		context.addComponent("JMS",
				JmsComponent.jmsComponentAutoAcknowledge(factory));
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("file://c:/tmp?fileName=inbox.txt&noop=true")
				.process(new CSVMap())
				.marshal().csv()
				.to("JMS:queue:foo.bar?username=admin&password=admin")
				.to("file://c:/tmp?fileName=javatocvsfile.csv&noop=true");
				
				from("JMS:queue:foo.bar?username=admin&password=admin")
				.unmarshal().csv()
				.to("JMS:queue:ActiveMQ.DLQ?username=admin&password=admin");
				
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
	}
}


