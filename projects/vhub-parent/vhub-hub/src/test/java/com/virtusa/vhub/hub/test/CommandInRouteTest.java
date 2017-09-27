package com.virtusa.vhub.hub.test;

import java.util.Map;

import javax.xml.bind.JAXBContext;

import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.DataFormatDefinition;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.virtusa.vhub.entity.Command;
import com.virtusa.vhub.entity.Receive;
import com.virtusa.vhub.entity.ResponseList;
import com.virtusa.vhub.hub.Aggregator;


public class CommandInRouteTest extends CamelTestSupport {

		@Override
		public boolean isCreateCamelContextPerClass() {
			return true;
		}

		
		 @Override
		    protected boolean useJmx() {
		        return false;
		    }

		    @Produce(uri = "direct:commandRequestFromPartner")
		    private ProducerTemplate producerTemplate;
		    
		    @Produce(uri = "direct:vhub1")
		    private ProducerTemplate hubTemplate1;
		    
		    @Produce(uri = "direct:vhub2")
		    private ProducerTemplate hubTemplate2;
		    
		    @Produce(uri = "direct:vhub3")
		    private ProducerTemplate hubTemplate3;
		    
		    @Produce(uri = "direct:vhub4")
		    private ProducerTemplate hubTemplate4;
		    
		    @Produce(uri = "direct:consumer_1")	
		    private ProducerTemplate consumer_1_Template;
		    
		    @Produce(uri = "direct:consumer_2")	
		    private ProducerTemplate consumer_2_Template;
		    
		    @Produce(uri = "direct:consumer_3")	
		    private ProducerTemplate consumer_3_Template;
		   
		    @Test
		    public void testIfCommandTypeIsCommand1() throws Exception {
		        getMockEndpoint("mock:consumer1Endpoint").expectedBodiesReceived("Dummy Body");
		        producerTemplate.sendBodyAndHeader("Dummy Body", "CommandType", "COMMAND1");
		        assertMockEndpointsSatisfied();
		    }

		    @Test
		    public void testIfCommandTypeIsNotCommand1() throws Exception {
		        getMockEndpoint("mock:consumer1Endpoint").expectedMessageCount(0);
		        producerTemplate.sendBodyAndHeader("Dummy Body", "CommandType", "COMMAND123");
		        assertMockEndpointsSatisfied();
		    }

		    @Test
		    public void testIfCommandTypeIsCommand2() throws Exception {
		        getMockEndpoint("mock:consumer2Endpoint").expectedMessageCount(1);
		        producerTemplate.sendBodyAndHeader("Dummy Body", "CommandType", "COMMAND2");
		        assertMockEndpointsSatisfied();
		    }

		    @Test
		    public void testIfCommandTypeIsNotCommand2() throws Exception {
		        getMockEndpoint("mock:consumer2Endpoint").expectedMessageCount(0);
		        producerTemplate.sendBodyAndHeader("Dummy Body", "CommandType", "COMMAND123");
		        assertMockEndpointsSatisfied();
		    }

		    @Test
		    public void testIfCommandTypeIsCommand3() throws Exception {
		        getMockEndpoint("mock:consumer2Endpoint").expectedMessageCount(1);
		        getMockEndpoint("mock:consumer3Endpoint").expectedMessageCount(1);
		        producerTemplate.sendBodyAndHeader("Dummy Body", "CommandType", "COMMAND3");
		        assertMockEndpointsSatisfied();
		    }

		    @Test
		    public void testIfCommandTypeIsNotCommand3() throws Exception {
		        getMockEndpoint("mock:consumer2Endpoint").expectedMessageCount(0);
		        getMockEndpoint("mock:consumer3Endpoint").expectedMessageCount(0);
		        producerTemplate.sendBodyAndHeader("Dummy Body", "CommandType", "COMMAND123");
		        assertMockEndpointsSatisfied();
		    }
		    
			@Test
			public void testForInitialResponse1() throws InterruptedException {
				
				Command command=new Command("COMMAND1",1,"String");
				hubTemplate1.sendBodyAndHeader("direct:vhub1",ExchangePattern.InOut,command, "CommandType", "COMMAND1");
				getMockEndpoint("mock:req_queue_1").expectedHeaderReceived("CommandType","COMMAND1");
				getMockEndpoint("mock:consumer_1").expectedHeaderReceived("CommandType","COMMAND1");
				getMockEndpoint("mock:res_queue_1").expectedHeaderReceived("CommandType","COMMAND1");
				assertMockEndpointsSatisfied();
				 
			}
			
			@Test
			public void testForInitialResponse2() throws InterruptedException {
				
				Command command=new Command("COMMAND2",2,"String");
				hubTemplate2.sendBodyAndHeader("direct:vhub2",ExchangePattern.InOut,command, "CommandType", "COMMAND2");
				getMockEndpoint("mock:req_queue_2").expectedHeaderReceived("CommandType","COMMAND2");
				getMockEndpoint("mock:consumer_2").expectedHeaderReceived("CommandType","COMMAND2");
				getMockEndpoint("mock:res_queue_2").expectedHeaderReceived("CommandType","COMMAND2");
				getMockEndpoint("mock:res_queue_2").expectedMessageCount(1);
				assertMockEndpointsSatisfied();
				 
			}
			
			@Test
			public void testForInitialResponse3() throws InterruptedException {
				
				Command command=new Command("COMMAND3",3,"String");
				hubTemplate3.sendBodyAndHeader("direct:vhub3",ExchangePattern.InOut,command, "CommandType", "COMMAND3");
				getMockEndpoint("mock:req_queue_3").expectedHeaderReceived("CommandType","COMMAND3");
				getMockEndpoint("mock:consumer_2").expectedHeaderReceived("CommandType","COMMAND3");
				getMockEndpoint("mock:consumer_3").expectedHeaderReceived("CommandType","COMMAND3");
				assertMockEndpointsSatisfied();
				 
			}
			
			@Test
			public void testAcktypeResponse1() throws InterruptedException {
				Receive receive = new Receive("received", "201", "initial response");
				consumer_1_Template.sendBodyAndHeader("direct:consumer_1",
						ExchangePattern.InOut, receive, "AckType", "FINAL");
				getMockEndpoint("mock:sendFinalResToCallBackUrl").expectedHeaderReceived("AckType","FINAL");
				assertMockEndpointsSatisfied();
			}
			
			@Test
			public void testAcktypeResponse2() throws InterruptedException {
				Receive receive = new Receive("received", "201", "initial response");
				consumer_2_Template.sendBodyAndHeader("direct:consumer_1",
						ExchangePattern.InOut, receive, "AckType", "FINAL");
				getMockEndpoint("mock:sendFinalResToCallBackUrl").expectedHeaderReceived("AckType","FINAL");
				assertMockEndpointsSatisfied();
			}
			
			@Test
			public void testAcktypeResponse3() throws InterruptedException {
				Receive receive = new Receive("received", "201", "initial response");
				consumer_3_Template.sendBodyAndHeader("direct:consumer_1",
						ExchangePattern.InOut, receive, "AckType", "FINAL");
				getMockEndpoint("mock:sendFinalResToCallBackUrl").expectedHeaderReceived("AckType","FINAL");
				assertMockEndpointsSatisfied();
			}
			
			@Test
			public void testForAggregation() throws InterruptedException
			{
				Command command=new Command("COMMAND3",3,"String");
				hubTemplate3.sendBodyAndHeader("direct:vhub3",ExchangePattern.InOut,command, "CommandType", "COMMAND4");
				hubTemplate3.sendBodyAndHeader("direct:vhub3",ExchangePattern.InOut,command, "CommandType", "COMMAND3");
				getMockEndpoint("mock:req_queue_3").expectedMessageCount(2);
				assertMockEndpointsSatisfied();
				
			}
			
		    @Override
			protected CamelContext createCamelContext() throws Exception {
				CamelContext context = super.createCamelContext();
				JAXBContext jaxbContext = JAXBContext.newInstance(Command.class,
						Receive.class, ResponseList.class,Aggregator.class);
				JaxbDataFormat jaxbDataFormat = new JaxbDataFormat(jaxbContext);
				DataFormatDefinition dataFormatDefinition = new DataFormatDefinition(
						jaxbDataFormat);
				Map<String, DataFormatDefinition> dataFormats = context
						.getDataFormats();
				dataFormats.put("jaxbDataFormat", dataFormatDefinition);
				return context;
			}
		    
		    @Override
		    protected RouteBuilder createRouteBuilder() throws Exception {
		        return new RouteBuilder() {
		            @Override
		            public void configure() throws Exception {
		                from("direct:commandRequestFromPartner").choice().when().simple("${header.CommandType} == 'COMMAND1'")
		                                .to("mock:consumer1Endpoint").when().simple("${header.CommandType} == 'COMMAND2'")
		                                .to("mock:consumer2Endpoint").when().simple("${header.CommandType} == 'COMMAND3'")
		                                .multicast().to("mock:consumer2Endpoint").to("mock:consumer3Endpoint").end()
		                                .endChoice();
		                
		                from("direct:vhub1").marshal("jaxbDataFormat").to("mock:req_queue_1").to("mock:consumer_1").to("mock:res_queue_1").unmarshal("jaxbDataFormat");
		                from("direct:vhub2").marshal("jaxbDataFormat").to("mock:req_queue_2").to("mock:consumer_2").to("mock:res_queue_2").unmarshal("jaxbDataFormat");
		                from("direct:vhub3").marshal("jaxbDataFormat").to("mock:req_queue_3").multicast().to("mock:consumer_2").to("mock:consumer_3").unmarshal("jaxbDataFormat");
		                from("direct:vhub4").aggregate(new Aggregator()).header("CommandType").completionInterval(50).to("mock:req_queue_3");
		                
		                from("direct:consumer_1").marshal("jaxbDataFormat").filter(header("AckType").isEqualTo("FINAL"))
						.to("mock:sendFinalResToCallBackUrl").unmarshal("jaxbDataFormat");
		                
		                from("direct:consumer_2").marshal("jaxbDataFormat").filter(header("AckType").isEqualTo("FINAL"))
						.to("mock:sendFinalResToCallBackUrl").unmarshal("jaxbDataFormat");
						
		                from("direct:consumer_3").marshal("jaxbDataFormat").filter(header("AckType").isEqualTo("FINAL"))
						.to("mock:sendFinalResToCallBackUrl").unmarshal("jaxbDataFormat");
		            }
		        };
		    }
	
}
