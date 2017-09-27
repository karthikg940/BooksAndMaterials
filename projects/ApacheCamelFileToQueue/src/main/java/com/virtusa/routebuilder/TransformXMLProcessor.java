package com.virtusa.routebuilder;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class TransformXMLProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		
		OrderBean order=new OrderBean(1,"company1",99);
		/*OrderBean order1=new OrderBean(1,"company1",99);
		OrderBean order2=new OrderBean(1,"company1",99);
		OrderBean order3=new OrderBean(1,"company1",99);
		List list=new ArrayList();
		list.add(order);
		list.add(order1);
		list.add(order2);
		list.add(order3);*/
		
		/*Map map=new LinkedHashMap();
		map.put("header1", 1);
		map.put("header2", 2 );
		exchange.getOut().setHeader("header",map);*/
		exchange.getOut().setBody(order);	
		
	}

}
