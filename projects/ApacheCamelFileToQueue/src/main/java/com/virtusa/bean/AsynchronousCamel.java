package com.virtusa.bean;

import java.io.File;
import java.util.concurrent.ExecutorService;

import org.apache.camel.AsyncProcessor;
import org.apache.camel.Component;
import org.apache.camel.Consumer;
import org.apache.camel.Exchange;
import org.apache.camel.Producer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.ThreadPoolBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.sun.istack.logging.Logger;

public class AsynchronousCamel extends CamelTestSupport {
	
	AsyncProcessor p;
	Component e;
	Producer p1;
	Consumer e1;
	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				/*ExecutorService lowPool = new ThreadPoolBuilder(context)
				.poolSize(0).maxPoolSize(5).build("LowPool");*/
				/* from("seda:start")
				.to("log:A")
				.threads(5,10)
				.to("log:B") 
				;*/
				/*from("direct:start")
				.log("inside the direct start route")
				.wireTap("direct:second",lowPool)
				.wireTap("direct:third",lowPool)
				.log("after wiretap send message")
				;
				from("direct:second")
				.log("inside the direct second")
				.to("mock:abcd")
				;
				from("direct:third")
				.log("inside the third route")
				;*/
				/*from("file://target/inbox?noop=true")
				.log("inside the file route")
				.split(body().tokenize("/n"))
				.log("after split")
				//.to("direct:second")
				;*/
				/*from("direct:second")
				.log("")
				;*/
				/*from("direct:portal")
				.multicast().parallelProcessing()
				.to("direct:first")
				.to("direct:Second")
				.to("direct:Third")
				.to("direct:Fourth")
				;
				from("direct:first")
				.to("log:A")
				;
				from("direct:Second")
				.to("log:B")
				;
				from("direct:Third")
				.to("log:C")
				;
				from("direct:Fourth")
				.to("log:D")
				;*/
				
				from("seda:start")
//				.threads(0)
				.wireTap("direct:start1")
				.transform().constant("OK")
				.log("ok is the data response")
				;
				from("direct:start1")
				.log("incoming data is the ${body}")
				.delay(3000)
				.log("processing done for output ${body}");
			}
		};
	}

	@Test
	public void testMoveFile() throws Exception {
//		System.out.println("before send to the route");
		log.info("inside the test case");
		/*template.sendBodyAndHeader("file://target/inbox", "Hello World/n",
				Exchange.FILE_NAME, "hello.txt");*/
//		Object object=template.requestBody("seda:start","HelloWorld");
		template.sendBody("seda:start", "HelloWorld");
//		System.out.println("afetr send to the route");
		log.info("after the test case");
//		log.info("response from the route"+object);
		Thread.sleep(1000);
	}
}
