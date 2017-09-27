package com.virtusa.morepoints;

import java.util.concurrent.ExecutorService;



interface A1
{
	
}
abstract   class B {
	int a;
	public B(){
		System.out.println("inside the abstract class");
	}

}

public class A extends B{
	public A()
	{
		System.out.println("inside the class B");
	}
	public static void main(String[] args) {
		
	}
}

class C{
	public class  D{
		final static int a=10;
	}
}

class F{
	
}
class E{
	int[] a;
	F[] b= new F[100];
	
	ExecutorService e;
}
