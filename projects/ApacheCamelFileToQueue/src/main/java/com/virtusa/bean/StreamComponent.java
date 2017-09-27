package com.virtusa.bean;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class StreamComponent {

	public static void main(String[] args) throws Exception {
		
		CamelContext context=new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				 
				from("stream:in?promptMessage=Enter something:")
				.to("stream:out");
				
			}
			
			 
		});
		context.start();
		Thread.sleep(1000);
		context.stop();
	}
}
