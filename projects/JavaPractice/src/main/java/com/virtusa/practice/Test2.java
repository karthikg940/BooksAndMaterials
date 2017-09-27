package com.virtusa.practice;

 class Example {
	//public static void main(String[] args) {
		
////		int a='97';
//		char ch=255;
////		int i=
////		char 
//		System.out.println(ch);
//		byte b=97;
//		byte e=98;
//		byte f=99 + 9;
//		short s=98+99;
//		float h=99;
		
	//}
	void m1()
	{
		System.out.println("m1 method");
	}

}

class Test1 extends Example{
	void m2()
	{
		System.out.println("m2 method");
	}
}
public class Test2{
	static void m3(Example e)
	{
		e.m1();
	}
	
	public static void main(String[] args) {
		m3(new Example());
		m3(new Test1());
	}
}