package com.virtusa.bean;

import java.io.File;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.Properties;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelRouteJavaDSLTest extends CamelTestSupport {

	private String inboxDir;
	private String outboxDir;
	
	@Override
	protected CamelContext createCamelContext() throws Exception {
		CamelContext context=super.createCamelContext();
		PropertiesComponent prop=context.getComponent("properties",PropertiesComponent.class);
		prop.setLocation("classpath:external.properties");
		return context;
	}
	
	@EndpointInject(uri="{{file.inbox}}")
	private ProducerTemplate template;
	
	public void setUp() throws Exception {
		super.setUp();
		inboxDir=context.resolvePropertyPlaceholders("{{file.inbox}}");
		outboxDir=context.resolvePropertyPlaceholders("{{file.outbox}}");
		deleteDirectory(inboxDir);
		deleteDirectory(outboxDir);
	};
	
	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
					from("{{file.inbox}}")
					.to("{{file.outbox}}");
				
			}
		};
		
	}
	@Test
	public void testMoveFile() throws Exception{
		template.sendBodyAndHeader("Hello new join World welcome",
				Exchange.FILE_NAME, "hello.txt");
				Thread.sleep(1000);
				File target = new File("target/outbox/hello.txt");
				assertTrue("File not moved", target.exists());
		
	}
	
	//MockEndpoint
}
