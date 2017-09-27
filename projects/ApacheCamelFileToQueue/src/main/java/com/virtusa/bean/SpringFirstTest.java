package com.virtusa.bean;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFirstTest extends CamelSpringTestSupport{

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		 
		 return new ClassPathXmlApplicationContext("OSGI-INF/blueprint/camel.xml");
	}
	
	@Test
	public void testMoveFile() throws Exception{
		template.sendBodyAndHeader("file://target/inbox", "Hello World",
				Exchange.FILE_NAME, "hello.txt");
				Thread.sleep(1000);
				File target = new File("target/outbox/hello.txt");
				assertTrue("File not moved", target.exists());
		
	}

}
