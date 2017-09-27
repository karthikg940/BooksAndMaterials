package com.virtusa.custom.component;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;


public class MyComponent extends DefaultComponent{

	@Override
	protected Endpoint createEndpoint(String uri, String remaining,
			Map<String, Object> parameters) throws Exception {
		 
		Endpoint endPoint =  new MyEndPoint(uri,this);
		return null;
	}

}
