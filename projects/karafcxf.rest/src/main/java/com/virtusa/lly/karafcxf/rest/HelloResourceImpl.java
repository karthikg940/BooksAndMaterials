package com.virtusa.lly.karafcxf.rest;

import com.virtusa.lly.karafcxf.service.impl.HelloService;

public class HelloResourceImpl implements HelloResource {

	private HelloService helloService;

	public String handleGet(String name) {

		return helloService.sayHello(name);

	}

	public HelloResourceImpl() {
	}

	public HelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}

	@Override
	public String create(Long id) {
		 
		return null;
	}

}
