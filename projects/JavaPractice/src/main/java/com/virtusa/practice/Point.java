package com.virtusa.practice;

public class Point {

	int x;
	int y;
	
	static Point origin = new Point(0,0);
	
	 Point() {
		System.out.println("inside default constructor");
	}
	 Point(int x, int y) {
		super();
		System.out.println("inside parameter constructor");
		System.out.println("x"+x+""+"y"+y);
		this.x = x;
		this.y = y;
	}
	 
	
	
	
	
	 /*void point() {
		System.out.println("inside default constructor");

	}
	 
	 void point(int x,int y)
	 {
		 System.out.println("inside parameter constructor");
		 this.x=x;
		 this.y=y;
	 }*/
	
	 
	
	
}
