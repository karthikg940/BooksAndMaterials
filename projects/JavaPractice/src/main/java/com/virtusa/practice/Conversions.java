package com.virtusa.practice;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;

class Test3 {

	int x, y;
}

class ColoredPoint extends Test3 {
	int color;

	public ColoredPoint(int color) {
		this.color = color;
	}
}

public class Conversions {
	static int x;
	public static void main(String[] args) {
		//int x=x;
		long[] l = new long[100];
		int[] i = new int[100];
		String[] s = new String[10];
		Object o = l;
		System.out.println(l.toString());
		System.out.println(i);
		System.out.println(s);
		// List l=new ArrayList<E>();

		/*
		 * Object o1=l[1]; System.out.println(o); System.out.println(o1);
		 * Test3[] t3=new Test3[100]; ColoredPoint[] cp=new ColoredPoint[199];
		 * t3=cp;
		 * 
		 * byte b=-100; // byte b1=+b; char ch=(char)b; System.out.println(ch);
		 * char ch1='\u0001'; System.out.println(ch1); String s;
		 */
	}
}

class StringCheese {

	public static void main(String args[]) {

		byte bytes[] = new byte[256];

		for (int i = 0; i < 256; i++)

			bytes[i] = (byte) i;

		String str = new String(bytes);

		for (int i = 0, n = str.length(); i < n; i++)

			System.out.print((int) str.charAt(i) + " ");

	}

}

class PT<TV1, TV2> {

}

class Main {

	public static void main(String[] args) {
		PT<String, String> x = null;
	}
}

class Shadow{
	void m1()
	{
		int i;
		int j=i;
	}
	void m2(int k){
		int formal=k;
	}
}
