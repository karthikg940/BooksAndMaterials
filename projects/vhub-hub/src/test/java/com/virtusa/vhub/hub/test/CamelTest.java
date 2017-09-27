package com.virtusa.vhub.hub.test;

import java.util.Collections;
import java.util.Map;

import javax.xml.bind.JAXBContext;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.DataFormat;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.DataFormatDefinition;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.json.simple.JSONObject;
import org.junit.Test;

import com.virtusa.vhub.entity.Command;
import com.virtusa.vhub.entity.Receive;
import com.virtusa.vhub.entity.ResponseList;

public class CamelTest extends CamelTestSupport {

	@Override
	public boolean isCreateCamelContextPerClass() {
		return true;
	}

	
	 @Override
	    protected boolean useJmx() {
	        return false;
	    }
	/*
	 * @BeforeClass public static void setUpClass() throws Exception {
	 * BrokerService service= new BrokerService();
	 * service.setBrokerName("Test Broker");
	 * service.addConnector("tcp://localhost:61616"); service.start(); }
	 */

	@EndpointInject(uri = "mock:consumer1-in")
	protected MockEndpoint mockEndPoint1;

	@EndpointInject(uri = "mock:consumer2-in")
	protected MockEndpoint mockEndPoint2;

	@EndpointInject(uri = "mock:consumer3-in")
	protected MockEndpoint mockEndPoint3;

	@EndpointInject(uri = "mock:req-queue-1")
	protected MockEndpoint mockReqQueue1;
	
	@EndpointInject(uri = "mock:req-queue-2")
	protected MockEndpoint mockReqQueue2;
	
	@EndpointInject(uri = "mock:req-queue-3")
	protected MockEndpoint mockReqQueue3;

	@EndpointInject(uri = "mock:res-queue-1")
	protected MockEndpoint mockResQueue1;
	
	@EndpointInject(uri = "mock:res-queue-2")
	protected MockEndpoint mockResQueue2;
	
	@EndpointInject(uri = "mock:res-queue-3")
	protected MockEndpoint mockResQueue3;

	@EndpointInject(uri = "mock:CallBackUrl")
	protected MockEndpoint mockCallBackUrl;

	@Produce(uri = "direct:req-queue-1")
	protected ProducerTemplate template_req_queue1;
	
	@Produce(uri = "direct:req-queue-2")
	protected ProducerTemplate template_req_queue2;
	
	@Produce(uri = "direct:req-queue-3")
	protected ProducerTemplate template_req_queue3;

	@Produce(uri = "direct:res-queue-1")
	protected ProducerTemplate template_res_queue1;
	
	@Produce(uri = "direct:res-queue-2")
	protected ProducerTemplate template_res_queue2;
	
	@Produce(uri = "direct:res-queue-3")
	protected ProducerTemplate template_res_queue3;

	/*
	 * @Produce(uri="direct:cxfs2") protected ProducerTemplate template2;
	 */
	@Produce(uri = "direct:cxfs")
	protected ProducerTemplate template;

	@Test
	public void testIfCommand1TypeIsTrue() throws InterruptedException {
		mockEndPoint1.expectedBodiesReceived("dummy body");
		template.sendBodyAndHeader("dummy body", "CommandType", "COMMAND1");
		mockEndPoint1.assertIsSatisfied();
	}

	@Test
	public void testIfCommand1TypeIsFalse() throws InterruptedException {
		mockEndPoint1.expectedHeaderReceived("CommandType", "COMMAND1");
		template.sendBodyAndHeader("dummy body", "CommandType", "COMMAND1234");
		mockEndPoint1.assertIsSatisfied();
	}

	@Test
	public void testIfCommand2TypeIsTrue() throws InterruptedException {
		mockEndPoint2.expectedBodiesReceived("dummy body");
		template.sendBodyAndHeader("dummy body", "CommandType", "COMMAND2");
		mockEndPoint2.assertIsSatisfied();
	}

	@Test
	public void testIfCommand2TypeIsFalse() throws InterruptedException {
		mockEndPoint2.expectedHeaderReceived("CommandType", "COMMAND2");
		template.sendBodyAndHeader("dummy body", "CommandType", "COMMAND1234");
		mockEndPoint2.assertIsSatisfied();
	}

	@Test
	public void testIfCommand3TypeIsTrue() throws InterruptedException {
		mockEndPoint3.expectedBodiesReceived("dummy body");
		template.sendBodyAndHeader("dummy body", "CommandType", "COMMAND3");
		mockEndPoint3.assertIsSatisfied();
	}

	@Test
	public void testIfCommand3TypeIsFalse() throws InterruptedException {
		mockEndPoint3.expectedHeaderReceived("CommandType", "COMMAND3");
		template.sendBodyAndHeader("dummy body", "CommandType", "COMMAND1234");
		mockEndPoint3.assertIsSatisfied();
	}

	/*
	 * @Test public void testToSendForRequest1() throws InterruptedException {
	 * 
	 * mockEndPoint4.expectedBodiesReceived("command");
	 * //template1.sendBody("command"); template1.requestBody("command");
	 * //template2.sendBody(mockEndPoint4); //
	 * mockEndPoint5.expectedBodiesReceived("command"); //
	 * mockEndPoint5.assertIsSatisfied(); mockEndPoint4.assertIsSatisfied(); }
	 */

	/*
	 * @Test public void testToSendForRequest1() throws InterruptedException {
	 * // JSONObject obj = new JSONObject(); // obj.put("commandName",
	 * "command1"); Object obj="command";
	 * mockReqQueue1.expectedBodiesReceived(obj); Object object =
	 * template_req_queue1.sendBodyAndHeader( "direct:req-queue-1",
	 * ExchangePattern.InOut, obj.toString(), "CommandType", "COMMAND1");
	 * mockResQueue1.expectedBodiesReceived(object);
	 * template_res_queue1.sendBodyAndHeader("direct:res-queue-1",
	 * ExchangePattern.InOut, object, "CommandType", "COMMAND1");
	 * mockReqQueue1.assertIsSatisfied(); mockResQueue1.assertIsSatisfied(); }
	 */

	/*
	 * @Test public void testToSendForRequest3() throws InterruptedException {
	 * Object body="command";
	 * getMockEndpoint("mock:req-queue-3").expectedBodiesReceived("command");
	 * template3.sendBody(body); assertMockEndpointsSatisfied(); }
	 */

	@Test
	public void testToSendForRequest1() throws InterruptedException {

		JSONObject obj = new JSONObject();
		obj.put("commandName", "command1");
		mockReqQueue1.expectedBodiesReceived(obj);
		template_req_queue1.sendBodyAndHeader("direct:req-queue-1",
				ExchangePattern.InOut, obj, "CommandType", "COMMAND1");
		mockReqQueue1.assertIsSatisfied();
	}

	@Test
	public void testToSendForResponse1() throws InterruptedException {

		// Object obj="command";
		Receive receive = new Receive("received", "201", "initial response");
		mockResQueue1.expectedHeaderReceived( "AckType",  "Otherwise");
		template_res_queue1.sendBodyAndHeader("direct:res-queue-1",
				ExchangePattern.InOut, receive, "AckType", "Otherwise");
		mockResQueue1.assertIsSatisfied();
	}

	@Test
	public void testAcktypeResponse1() throws InterruptedException {
		Receive receive = new Receive("received", "201", "initial response");
		mockCallBackUrl.expectedHeaderReceived("AckType","FINAL");
		template_res_queue1.sendBodyAndHeader("direct:res-queue-1",
				ExchangePattern.InOut, receive, "AckType", "FINAL");
		mockCallBackUrl.assertIsSatisfied();
	}
	

	@Test
	public void testToSendForRequest2() throws InterruptedException {

		JSONObject obj = new JSONObject();
		obj.put("commandName", "command2");
		mockReqQueue2.expectedBodiesReceived(obj);
		template_req_queue2.sendBodyAndHeader("direct:req-queue-2",
				ExchangePattern.InOut, obj, "CommandType", "COMMAND2");
		mockReqQueue2.assertIsSatisfied();
	}

	@Test
	public void testToSendForResponse2() throws InterruptedException {

		// Object obj="command";
		Receive receive = new Receive("received", "201", "initial response");
		mockResQueue2.expectedHeaderReceived( "AckType",  "Otherwise");
		template_res_queue2.sendBodyAndHeader("direct:res-queue-2",
				ExchangePattern.InOut, receive, "AckType", "Otherwise");
		mockResQueue2.assertIsSatisfied();
	}

	@Test
	public void testAcktypeResponse2() throws InterruptedException {
		Receive receive = new Receive("received", "201", "initial response");
		mockCallBackUrl.expectedHeaderReceived("AckType","FINAL");
		template_res_queue2.sendBodyAndHeader("direct:res-queue-1",
				ExchangePattern.InOut, receive, "AckType", "FINAL");
		mockCallBackUrl.assertIsSatisfied();
	}
	
	

	@Override
	protected CamelContext createCamelContext() throws Exception {
		CamelContext context = super.createCamelContext();
		JAXBContext jaxbContext = JAXBContext.newInstance(Command.class,
				Receive.class, ResponseList.class);
		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat(jaxbContext);
		DataFormatDefinition dataFormatDefinition = new DataFormatDefinition(
				jaxbDataFormat);
		Map<String, DataFormatDefinition> dataFormats = context
				.getDataFormats();
		dataFormats.put("jaxbDataFormat", dataFormatDefinition);
		return context;
	}

	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {
				from("direct:cxfs").choice().when()
						.simple("${header.CommandType} == 'COMMAND1'")
						.to("mock:consumer1-in").when()
						.simple("${header.CommandType} == 'COMMAND2'")
						.to("mock:consumer2-in").when()
						.simple("${header.CommandType} == 'COMMAND3'")
						.multicast().to("mock:consumer2-in")
						.to("mock:consumer3-in").end().endChoice();

				from("direct:req-queue-1").to(mockReqQueue1);
				from("direct:res-queue-1").marshal("jaxbDataFormat").choice()
						.when().simple("${header.AckType} == 'FINAL'")
						.to(mockCallBackUrl).unmarshal("jaxbDataFormat")
						.otherwise().to(mockResQueue1)
						.unmarshal("jaxbDataFormat").end();
				
				from("direct:req-queue-2").to(mockReqQueue2);
				from("direct:res-queue-2").marshal("jaxbDataFormat").choice()
						.when().simple("${header.AckType} == 'FINAL'")
						.to(mockCallBackUrl).unmarshal("jaxbDataFormat")
						.otherwise().to(mockResQueue2)
						.unmarshal("jaxbDataFormat").end();
				
				/*from("direct:req-queue-3").to(mockReqQueue3);
				from("direct:res-queue-3").marshal("jaxbDataFormat").choice()
						.when().simple("${header.AckType} == 'FINAL'")
						.to(mockCallBackUrl).unmarshal("jaxbDataFormat")
						.otherwise().to(mockResQueue3)
						.unmarshal("jaxbDataFormat").end();*/
			}

		};
	}
}