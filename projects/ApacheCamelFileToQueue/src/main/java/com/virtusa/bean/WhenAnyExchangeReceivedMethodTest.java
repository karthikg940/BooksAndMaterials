package com.virtusa.bean;

import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class WhenAnyExchangeReceivedMethodTest extends CamelTestSupport {

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		
		return new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				 from("direct:file")
				 .process(new OrderQueryProcessor())
				 .to("mock:mirenda")
				 .process(new OrderResponseProcessor());	
			}
		};
	}
	
	@Test
	public void testMiranda() throws Exception
	{
		MockEndpoint mock = getMockEndpoint("mock:mirenda");
		mock.expectedMessageCount(1);
		mock.whenAnyExchangeReceived(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				 exchange.getOut().setBody("Id=123456 this is the message from the method");
				
			}
		});
		template.sendBodyAndHeader("direct:file","abcd","id",123456);
		assertMockEndpointsSatisfied();
	}
//	Component
	
}
