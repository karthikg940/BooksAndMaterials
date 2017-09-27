package com.virtusa.training.startup.osgi.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("say")
public class HelloWorldService {

	HelloWorld hello;

	
	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	
	

	@GET
	@Path("hello/{name}")
	public void init(@PathParam("name") String name)
	{
		System.out.println(hello.sayHello(name));
	}
}
