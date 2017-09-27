package com.virtusa.routebuilder;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class PollEnrich {

	public static void main(String[] args) throws Exception {
		CamelContext context=new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file://c:/tmp?fileName=inbox.txt&noop=true")
				.pollEnrich("file://c:/tmp?fileName=csvfile.txt&noop=true",new AggregationStrategy() {
					
					@Override
					public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
						 if(newExchange == null)
						 {
							 return oldExchange;
						 }
						 else
						 {
							 String http = oldExchange.getIn().getBody(String.class);
							 String ftp = newExchange.getIn().getBody(String.class);
							 String body = http+"\n"+ftp;
							 oldExchange.getIn().setBody(body);
							 return oldExchange;
						 }
					}
				})
				.to("file://c:/tmp?fileName=pollfile.txt");
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
			}
	}

