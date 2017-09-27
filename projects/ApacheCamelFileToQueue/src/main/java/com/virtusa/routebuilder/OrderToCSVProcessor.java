package com.virtusa.routebuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class OrderToCSVProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		 
		String custom=exchange.getIn().getBody(String.class);
		String id=custom.substring(0,9);
		String customId=custom.substring(10,19);
		String date=custom.substring(20,29);
		String item=custom.substring(30);
		StringBuilder sb = new StringBuilder();
		sb.append(id.trim());
		sb.append(",").append(customId.trim());
		sb.append(",").append(date.trim());
		sb.append(",").append(item.trim());
		exchange.getIn().setBody(sb);
		
	}

}
