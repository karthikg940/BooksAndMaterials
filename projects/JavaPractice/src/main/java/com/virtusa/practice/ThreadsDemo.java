package com.virtusa.practice;

 class TDemo1 extends Thread {

	private int c=0;
	
	public void increment(){
		  c++;
	}
	
	public void decrement(){
		  c--;
	}
	
	public int value(){
		return c;
	}
	public void run(){
		increment();
		System.out.println("value of the c"+c);
		decrement();
		System.out.println("value of the c"+c);
	}
}

public class ThreadsDemo{
	
	public static void main(String[] args) {
		
		TDemo1 d1=new TDemo1();
		d1.start();
		TDemo1 d2=new TDemo1();
		d2.start();
		
	}
}
