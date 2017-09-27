package com.virtusa.service;

import com.virtusa.DAO.UserDao;
import com.virtusa.bean.User;

public class Service {
	
	UserDao userdao=new UserDao();
	public void service(User user)
	{
		userdao.create(user);
	}

}
