package com.virtusa.camel;
	 

	import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

	public class CamelDemo {
		public static void main(String[] args) throws Exception {
			 
			CamelContext context = new DefaultCamelContext();
			try {
				 ActiveMQComponent component = ActiveMQComponent.activeMQComponent("tcp://localhost:61616"); 
			        component.setUserName("karaf"); 
			        component.setPassword("karaf"); 
				context.addComponent("activemq",component);
				
				System.out.println("after local host");
				context.addRoutes(new RouteBuilder() {
					@Override
					public void configure() throws Exception {
						System.out.println("enterd into configure()");
						from("activemq:queue:LLY.TRAINING.EMAIL.IN")
						.process(new Processor() {
							
							@Override
							public void process(Exchange exchange) throws Exception {
								System.out.println(exchange);
								
							}
						})
						.to("stream:out");
						System.out.println("end of conf()");
					}
				});
				ProducerTemplate template = context.createProducerTemplate();
				System.out.println("end of template");
				context.start();
				System.out.println("end of start");
				 
				template.sendBody("activemq:LLY.TRAINING.EMAIL.IN", "Hello World");
				System.out.println("after send body");
				//Thread.sleep(2000);
			} finally {
				context.stop();
			}
		}
	}

