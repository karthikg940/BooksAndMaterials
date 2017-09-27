package com.virtusa.custom.component;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.ScheduledPollConsumer;

public class MyConsumer extends ScheduledPollConsumer {
	private final MyEndPoint endpoint;

	public MyConsumer(MyEndPoint endpoint, Processor processor) {
		super(endpoint, processor);
		this.endpoint = endpoint;
	}

	@Override
	protected int poll() throws Exception {
		Exchange exchange = endpoint.createExchange();
		Date now = new Date();
		exchange.getIn().setBody("Hello World! The time is " + now);
		try {
			getProcessor().process(exchange);
		} finally {
			if (exchange.getException() != null) {
				getExceptionHandler().handleException(
						"Error processing exchange", exchange,
						exchange.getException());
			}
		}
		return 0;
	}
}


class Foo<T,N extends Number>{
	
	public  void m(T t){}
	public  void m(N n){}
	public  void m1(){
		
	}
}


class A{
	public static void main(String[] args) {
		Foo f= new Foo<Integer,Integer>();
		Object object;
		ClassLoader l;
		
	}
}

@FunctionalInterface
interface A1{
	void m1();
	//void m2();
	public boolean equals(Object obj);
	default public void m3(){
		System.out.println("entered into the m3 method");
	}
}

@FunctionalInterface
interface A2 extends A1{
	void m1();
	default public void m3(){
		System.out.println("entered into the m3 method");
	}
}

interface Z{
	void m1(Iterable<Integer> i);
	
}
interface Z1{
	//void m1(Iterable<String> i);
}
interface Z2 extends Z,Z1{
	
}


