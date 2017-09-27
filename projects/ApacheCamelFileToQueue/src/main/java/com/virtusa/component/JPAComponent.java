package com.virtusa.component;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class JPAComponent {
	
	public static void main(String[] args) throws Exception {
		
		CamelContext context=new DefaultCamelContext();
		ConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		context.addComponent("JMS", JmsComponent.jmsComponentAutoAcknowledge(factory));
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
			 
			//	from("JMS:queue:Practice?username=admin&password=admin")
				from("file://c:/tmp?fileName=inbox.txt&noop=true")
				//.process(new JPAComponentCreateBeanObjectProcessor())
				.bean(JPAComponentCreateObjectBean.class)
				.to("jpa:com.virtusa.component.JPAPurchaseOrderBean");
				
			}
		});
		
		context.start();
		Thread.sleep(10000);
		context.stop();
	}

}
