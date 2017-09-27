package com.virtusa.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class OrderQueryProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		String body="message inside the OrderQueryProcessor ";
		String id=exchange.getIn().getHeader("id",String.class);
		exchange.getIn().setBody("ID="+id);

	}

}
