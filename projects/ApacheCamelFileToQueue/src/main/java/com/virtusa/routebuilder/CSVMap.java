package com.virtusa.routebuilder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CSVMap implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		 
		/*Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("first", "abcd");
		map.put("second",1234);
		Map<String,Object> map1=new LinkedHashMap<String,Object>();
		map.put("first1", "abcd1");
		map.put("second1",12345);
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list.add(map);
		list.add(map1);*/
		OrderBean list = new OrderBean(1,"abcd",99);
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("first", list);
		exchange.getOut().setBody(map);
	}

}
