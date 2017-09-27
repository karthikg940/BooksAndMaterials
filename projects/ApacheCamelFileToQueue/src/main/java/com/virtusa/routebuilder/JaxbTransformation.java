package com.virtusa.routebuilder;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;

public class JaxbTransformation {
	
	//DataFormat jaxb=(DataFormat) new JaxbDataFormat();
	public static void main(String[] args) throws Exception {
		CamelContext context=new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file://c:/tmp?fileName=inbox.txt&noop=true")
//				.marshal().ja
				.to("file://c:/tmp?fileName=xmltojava.txt");
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
			}
	}