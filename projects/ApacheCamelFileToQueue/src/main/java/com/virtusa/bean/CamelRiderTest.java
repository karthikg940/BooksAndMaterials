package com.virtusa.bean;

import java.io.File;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelRiderTest  extends CamelSpringTestSupport{

	private String inboxDir;
	private String outboxDir;
	
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
	protected AbstractApplicationContext createApplicationContext() {
		 return new ClassPathXmlApplicationContext(new String[] {"OSGI-INF/blueprint/camel.xml"});
	}
	
 
	@Test
	public void testMoveFile() throws Exception{
		template.sendBodyAndHeader("Hello new  join World",
				Exchange.FILE_NAME, "hello.txt");
				Thread.sleep(1000);
				File target = new File("target/outbox/hello.txt");
				assertTrue("File not moved", target.exists());
		
	}

}
