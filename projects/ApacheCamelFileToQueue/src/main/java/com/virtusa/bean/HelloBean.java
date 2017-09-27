package com.virtusa.bean;

import org.apache.camel.Handler;
import org.apache.camel.language.XPath;

import com.sun.xml.txw2.Document;

public class HelloBean {
	
	public String hello(String name)
	{
		System.out.println("hello bean");
		return "hello"+name;
	}
	
	
	public String hello1(@XPath("/OrderBean/name/text()") String name )
	{
		System.out.println(name);
		System.out.println("hello1 bean");
		return "hello1";
	}
	@Handler
	public String helloNew(){
		System.out.println("entered");
		return "Hello";
	}
	
	/*@Handler
	public String hello1(@Headers Map name,@Body OrderBean order)
	{
		System.out.println("hello1 bean");
		System.out.println(name);
		System.out.println(order);
		return "hello1"+name;
	}*/

}
