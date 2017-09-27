package com.virtusa.bean;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.BindyType;

import com.virtusa.routebuilder.BindyBean;
import com.virtusa.routebuilder.BindyProcessor;
import com.virtusa.routebuilder.TransformXMLProcessor;

public class CamelBeanProcess {
	public static void main(String[] args) throws Exception {
		CamelContext context=new DefaultCamelContext();
		//HelloBean hellobean = new HelloBean();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("file://c:/tmp?fileName=inbox.txt&noop=true")
				.process(new TransformXMLProcessor())
				//.beanRef("hellobean","hello");
				.bean(HelloBean.class,"helloNew");
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
	}
}

