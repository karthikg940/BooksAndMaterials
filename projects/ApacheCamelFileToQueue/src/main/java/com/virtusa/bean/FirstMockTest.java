package com.virtusa.bean;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class FirstMockTest  extends CamelTestSupport{

//	@Consume(uri="mock:efgh")
//	ConsumerTemplate consume;
	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		 
		return new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				 
				from("direct:file1")
				//from("file://inbox")
				.to("mock:abcd");
				
			}
		};
	}
	
	@Test
	public void testabcd() throws Exception{
		MockEndpoint mock=getMockEndpoint("mock:abcd");
		//mock.expectedMessageCount(1);
		//mock.expectedBodiesReceived("message","message1");
		//mock.message(0).body().contains("message");
		mock.allMessages().body().contains("message");
		template.sendBody("direct:file1","message");
		template.sendBody("direct:file1","message1");
		//mock.assertIsSatisfied();
		assertMockEndpointsSatisfied();
		/*List<Exchange> list=mock.getReceivedExchanges();
		String object1=list.get(0).getIn().getBody(String.class);
		String object2=list.get(1).getIn().getBody(String.class);
		assertTrue(object1.contains("message"));
		assertTrue(object2.contains("message1"));*/
		
	}
}
