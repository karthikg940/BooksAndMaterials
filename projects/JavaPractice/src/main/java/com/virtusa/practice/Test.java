package com.virtusa.practice;

public class Test {

	public static <T> void main(String[] args) {
		/*
		 * for(int i=0;i<args.length;i++) { System.out.println(i==0 ? args[i] :
		 * "" + args[i]); }
		 */
		/*
		 * int a=-10; byte b=127; long c=20; Long d=a+c; int f = 0;
		 * System.out.println(f);
		 */
		//String s="abcd//"
		// int i=1000000;
		// System.out.println(i*i);
		// long l=i;
		// System.out.println(l*l);
		// //System.out.println(4000/(l-i));
		// float j=0/0;
		// System.out.println(j);

		// double d=1e308;
		// System.out.println(d);
		// System.out.println(d + "*10 == "+(d*10));//0E308*10 ==
		// Infinity//example of overflow
		// d=1e-305 * Math.PI;
		// System.out.println(d);
		// System.out.println(d=0.0/0.0);//NaN
		// int a=(int) d;
		// System.out.println(a);//0
		// double b=1.9;
		// int c=(int)b;
		// System.out.println(c);//1.9
		// double h=-1.0/-1.0;
		// System.out.println(h);
		// Point p = null;
		// Point p2=new Point();
		// Point p3=new Point();
		// System.out.println("object of the p1" + p);
		// System.out.println("object of the p2"+p2);
		// System.out.println("object of the p3"+p3);
		// System.out.println(Point.origin);

		// Point p1[]={p, new Point(1,4)};
		// System.out.println("data inside the p1"+p1);
		// System.out.println("data inside the p1[0]"+p1[0]);
		// System.out.println(p1[1]);
		// System.out.println(p1[2]);

		// Point p=new Point();
		// Point p2=new Point();
		// Point p3=new Point();
		// System.out.println(p2.equals(p3));
		// System.out.println(p2 == p3);
		//
		// p.x=9;
		// Point p1=p;
		// System.out.println(p1 == p );
		// System.out.println(p1.equals(p));
		// p1.x=21;
		// System.out.println(p.toString()+"    "+p1);
		// System.out.println(p.x);
		// System.out.println(p1.x);
		// Class obj=p.getClass();
		// System.out.println(obj.getClass());
		// System.out.println(obj.getCanonicalName());
		// System.out.println(obj.getClasses());
		// System.out.println(p.equals(p2));

	}

	Demo1<String> x = null;

	public Test(Demo1<String> c) {
	}
	void m1(Demo1<String> x) {
		Demo1<String> y = new Demo1<String>();
	}
}

class Demo1<String> {
	int i = 9;

}
