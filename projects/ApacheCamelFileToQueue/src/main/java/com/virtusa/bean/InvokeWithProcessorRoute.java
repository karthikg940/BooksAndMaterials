package com.virtusa.bean;

import java.rmi.registry.Registry;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.bean.BeanProcessor;

public class InvokeWithProcessorRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		 
		from("direct:hello")
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				String name=exchange.getIn().getBody(String.class);
				HelloBean hello=new  HelloBean();
				String answer=hello.hello(name);
				exchange.getOut().setBody(answer);
			}
		});
	}
	//org.apache.camel.spi.Registry
}
