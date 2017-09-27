package com.virtusa.service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	
	 public static void main( String[] args )
	    {
	    	AbstractApplicationContext ctx = new ClassPathXmlApplicationContext
						("applicationContext-camel.xml");
	    	ctx.start();
	    	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	System.out.println("Entered>>>>>");
	    	ctx.stop();
	    }
}
