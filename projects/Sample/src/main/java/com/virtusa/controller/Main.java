package com.virtusa.controller;

import com.virtusa.bean.User;
import com.virtusa.service.Service;

public class Main {

	public static void main(String[] args) {
		
		Service service=new Service();
		User user=new User("abc","xyz");
		User user1=new User("abc1","xyz1");
		service.service(user);
		System.out.println();
	}
}
