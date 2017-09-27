package com.virtusa.vhub.hub;

import com.virtusa.vhub.entity.Receive;

public class ExceptionWrapper {
	public static Receive getException(Exception exception)
	{
		System.out.println(exception);
		Receive receive=new Receive("Exception1","400","Invalid Command");
		return receive;
	}
}
