package com.virtusa.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class OrderResponseProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		 
		String body = exchange.getIn().getBody(String.class);
		System.out.println(body);

	}

}
