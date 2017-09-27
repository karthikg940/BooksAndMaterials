package com.virtusa.practice;

public class HibernateMain {

	public static void main(String[] args) {
		
		HiberanteInher hi=new HiberanteInher();
		hi.setId(1);
		System.out.println("value is the super class"+hi.getId());
		Object object;
	}
}
