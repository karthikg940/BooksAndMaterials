package com.virtusa.spring.daotest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.spring.dao.AdminDAO;
import com.virtusa.spring.model.Priority;
import com.virtusa.spring.model.Project;
import com.virtusa.spring.model.Role;
import com.virtusa.spring.model.Status;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;

public class AdminDAOTest {

	private AdminDAO mockedAdminDAO;
	private Priority priority;
	private Ticket ticket;
	private Project project;
	private Status status;
	private User user;
	private Role role;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		mockedAdminDAO=mock(AdminDAO.class);
		priority=new Priority(601,"high");
		role=new Role(102, "user");
		ticket=new Ticket(project, "description1", user, new Date(), priority,null, status,new Date());
		user=new User("karthik","abcded@gmail.com","Karthik123", "password",90522, role);
		
		when(mockedAdminDAO.assignPriority(ticket,ticket.getPriority())).thenReturn(0);
		when(mockedAdminDAO.setDeveloper(user)).thenReturn(0);
	}
	@Test
	public void testAssignPriority() {
		int i=mockedAdminDAO.assignPriority(ticket,priority);
		assertEquals(0,i);
	}
	@Test
	public void testSetDeveloper() {
		int i=mockedAdminDAO.setDeveloper(user);
		assertEquals(0,i);
	}
	
}
