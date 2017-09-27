package com.virtusa.routebuilder;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MessageTranslator {

	public static void main(String[] args) throws Exception {
		CamelContext context=new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("file://c:/tmp?fileName=inbox.txt&noop=true")
//				.process(new OrderToCSVProcessor())
				//.bean(new CSVBean())
				.transform(body().regexReplaceAll("f","99"))
				.to("file://c:/tmp?fileName=csvfile.txt");
				
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
	}
}
