package com.virtusa.bean;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

 

public class FirstTest extends CamelTestSupport {
	
	
	
	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		// TODO Auto-generated method stub
		return  new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				 
				from("file://target/inbox?noop=true")
				.to("file://target/outbox");
				
			}
		};
	}
	
	@Test
	public void testMoveFile() throws Exception{
		template.sendBodyAndHeader("file://target/inbox", "Hello World",
				Exchange.FILE_NAME, "hello.txt");
				Thread.sleep(1000);
				File target = new File("target/outbox/hello.txt");
				assertTrue("File not moved", target.exists());
		
	}
	
	 

	
	/*CamelContext context=new DefaultCamelContext();
//	ConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
//	context.addComponent("JMS", JmsComponent.jmsComponentAutoAcknowledge(factory));
	context.addRoutes(new RouteBuilder() {
		
		@Override
		public void configure() throws Exception {
			 
			from("file://target/inbox")
			.to("file://target/outbox");
			
		}
	});
	
	context.start();
	Thread.sleep(10000);
	context.stop();
}*/

}
