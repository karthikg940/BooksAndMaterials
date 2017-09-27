package com.virtusa.practice;

 class Example1 {

	 public void m1()
	 {
		 System.out.println("inside m1 method");
	 }
}
 class Sample extends Example1{
	 
	 public void m2(){
		 System.out.println("inside m2 method");
	 }
 }
 
 
 interface F{}
 class A implements F{}
 class B extends A{}
 
 class Members extends B
 {
	 static void m3(Object m)
	 {
		//m.m1();
		//m.m2();
//		 if(m instanceof Sample)
//		 {
//			 Example1 e=(Example1)m;
//			 e.m1();
//		 }
	 
		Sample s=(Sample)m;
		s.m2();
	 
		// Sample s=(Sample)m;
	 }
	 public static void main(String[] args) {
		// Members.m3(new Example1());
		 //Members.m3(new Sample());
		// Members.m3(new Object());
		/* char ch='a'+'b';
		 int i=ch;
//		 int i='a';
//		 char c=ch+'a';
		 System.out.println(i);
		 B b=new B();
		 A a=b;
		 F f=(A)b;
		 F f=(Members)b;
		 B b1=(B)(A)b;*/
//		 char ch='a'+'b';
		// byte i=(byte)ch;
//		 char i='a';
		 //System.out.println(i);
		/* byte b=10;
		 int i=b;
		 byte b1=(byte)i;
		 System.out.println(b1);
//		 int i1=(int)true;
		 int i2=254;
		 byte b2=(byte)i2;
		 System.out.println(b2);
		 int i3=97;
//		 char ch=i3;
		 char ch1=(char)i3;
		 System.out.println(ch1);
		 float f=20l;
		 float f1=20.0f;
		 double d=20l;
		 long l=(long)f;
//		 System.out.println();*/
		
		// Integer i4;
		 int i11='a';
		 System.out.println(i11);
		 
		 
	}
 }
