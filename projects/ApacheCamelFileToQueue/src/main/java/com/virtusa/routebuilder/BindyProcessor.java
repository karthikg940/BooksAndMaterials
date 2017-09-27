package com.virtusa.routebuilder;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class BindyProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		//OrderBean order=new OrderBean(1, "abcd", 99)
		BindyBean bindy=new BindyBean(1,"abcd");
		BindyBean bindy1=new BindyBean(2,"abcde");
		BindyBean bindy2=new BindyBean(3,"abcdf");
		BindyBean bindy3=new BindyBean(4,"abcdg");
		BindyBean bindy4=new BindyBean(5,"abcdh");
		List list = new ArrayList();
		list.add(bindy);
		list.add(bindy1);
		list.add(bindy2);
		list.add(bindy3);
		list.add(bindy4);
		exchange.getOut().setBody(list);
		
	}

}
