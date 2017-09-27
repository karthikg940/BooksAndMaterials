package com.virtusa.component;


import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.commons.dbcp2.BasicDataSource;

public class JDBCComponent {
	
	static final String JDBC_Driver="com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/abc";//abc is the database name
	static final String User="root";
	static final String password="root";
	
	public static void main(String[] args) throws Exception {
		//DataSource datasource=new 
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setUrl(DB_URL);
		dataSource.setDriverClassName(JDBC_Driver);
		dataSource.setUsername(User);
		dataSource.setPassword(password);
		
		SimpleRegistry registry=new SimpleRegistry();
		registry.put("myDataSource",dataSource);
		
		CamelContext context=new DefaultCamelContext(registry);
		ConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		context.addComponent("JMS", JmsComponent.jmsComponentAutoAcknowledge(factory));
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				 
				//from("JMS:queue:Practice?username=admin&password=admin")
				from("file://c:/tmp?fileName=inbox.txt&noop=true")
				.bean(JPAComponentCreateObjectBean.class)
				.to("jdbc:myDataSource");
				
			}
			
			 
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
	}

}
