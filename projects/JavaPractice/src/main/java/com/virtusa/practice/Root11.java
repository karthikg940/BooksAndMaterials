package com.virtusa.practice;


class Super{
	static  int i=9999;
	public Super(){
		System.out.println("inside the constructor of Super");
	}
	static{
		
		System.out.println("inside the class Super"+i);
	}
	
	
}

class One{
	static {
		System.out.println("inside the One class");
	}
}

class Two extends Super{

	public Two(){
		System.out.println("inside the Two constructor");
	}
	static{
		System.out.println("inside the class two");
	}
}

public class Root11{
	public static void main(String[] args) {
		One one=null;
		Two two = new Two();
		System.out.println(Two.i);
		//Root11 two=new Root11();
		//Two two=new Two();
		//System.out.println((Object)one == (Object)two);
	}
}
