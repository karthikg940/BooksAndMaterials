package com.virtusa.morepoints;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

import com.virtusa.morepoints.Author.Level;

 class ColoredPoint {

}
 public class Point extends ColoredPoint{
	public static void main(String[] args) {
		
		Point[] p=new Point[10];
		ColoredPoint[] cp=p;
		System.out.println(cp[1] == null);
		try {
			cp[2]=new ColoredPoint();
			Object obj;
			System.out.println("object created is success");
		} catch (Exception e) {
			System.out.println("not allowed such kind of creation");
		}	
		
		int ia[]={1,2};
		int ja[]=ia.clone();
		System.out.println(ia == ja);
		System.out.println(ia.equals(ja));
		System.out.println(ia.getClass());
		System.out.println(ia.getClass().getSuperclass());
		System.out.println(p.getClass());
		System.out.println(p.getClass().getSuperclass());
		System.out.println(ia.getClass().getInterfaces());
	}
}
 
 interface A<T>
 {
	 //public void m1() throws Exception
	 int i=9999;
 }
 
 interface B<K>{
	 
 }
 
 class D //implements A<String>{
 {
	 //void m1();
	 Object object;
	 public static void main(String[] args) {
		System.out.println(A.i);
	}
 }
 
 //call stack
 
 class E<T>{
	 
	 T a;
	 public void m1(T a){
		 
	 }
 }
 
 @Foo( id = 8020630)
 @Author(value = @Name(firstName = "", lastName = ""), level = Level.a)
 class F{
	// public T void m1(E<T> e){}
 }
 
 //@Repeatable(value = null)
 @Target({ElementType.TYPE_USE,ElementType.FIELD})
 @interface Foo{
	 String author() default "abcd";
	 int id() default 8020630;
	// Foo value() default "abcd";
 }
 @interface Author{
	 String a=null;
	 enum Level{GOOD,SUPER,a}
	
	 Name value();
	 Level level() ;
 }
 
 @interface Name{
	 String firstName();
	 String lastName();
 }
 
 
 //@Inherited
 //@Target(ElementType.TYPE)
 @Repeatable(value = TC.class)
 @interface T{
	 
 }
 
 //@Documented
 @Target(ElementType.ANNOTATION_TYPE)
 @interface TC{
	 T[] value();
 }
 
@T @T
 @interface Z1{
	 
 }

@interface Pretty{
	 Class<? extends Pretty> value();
}
 
class D1 implements Pretty{

	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	public Class<? extends Pretty> value() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

@Pretty(value = D1.class)
class D2{
	
	@Foo int a;
	int @Foo[];
}
 
 
 
 
 
 
 
 
 