package com.virtusa.lilly.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/lilly")
public class EmpService {
	
	@GET
	public Employee get()
	{
		Employee emp1=new Employee(1,"abcd1");
		return emp1;
	}
	 
	@GET
	@Path("/address")
	public Address getAll()
	{
		Address address =new Address("abcd");
		return address;
	}
	
	
}
