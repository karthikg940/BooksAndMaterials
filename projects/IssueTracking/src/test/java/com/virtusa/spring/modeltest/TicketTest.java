package com.virtusa.spring.modeltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Set;

import org.apache.jasper.tagplugins.jstl.core.When;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.virtusa.spring.model.Category;
import com.virtusa.spring.model.Priority;
import com.virtusa.spring.model.Project;
import com.virtusa.spring.model.Status;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;

public class TicketTest {

	@Mock
	private Ticket mockticket;
	
	@Mock
	private Ticket ticket1;
	@Mock
	private Ticket ticket2;
	@Mock
	private Project project;
	@Mock
	private User user;
	@Mock
	private Priority priority;
	@Mock
	private Set<User> assignDeveloper;
	@Mock
	private Set<Category> category;
	@Mock
	private Status status;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		
		mockticket=mock(Ticket.class);
		ticket1=new Ticket();
		ticket2=new Ticket(project,"description", user,new Date(), priority, assignDeveloper, status, new Date());
	}
	
	@Test
	public void testgetTicketId()
	{
		ticket1.setTicketId(1);
		when(mockticket.getTicketId()).thenReturn(1);
		assertEquals(1,ticket1.getTicketId());
	}
	
	@Test
	public void testgetProject()
	{
		ticket1.setProject(project);
		when(mockticket.getProject()).thenReturn(project);
		assertEquals(project,ticket1.getProject());
	}
	
	@Test
	public void testgetDescription()
	{
		ticket2.setDescription("description");
		when(mockticket.getDescription()).thenReturn("description");
		assertEquals("description",ticket2.getDescription());
	}
	@Test
	public void testgetUser()
	{
		ticket1.setUser(user);
		when(mockticket.getUser()).thenReturn(user);
		assertEquals(user,ticket1.getUser());
		
	}
	@Test
	public void testgetRiseDate()
	{
		ticket1.setRiseDate(new Date());
		when(mockticket.getRiseDate()).thenReturn(new Date());
		assertEquals(new Date(),ticket1.getRiseDate());
	}
	
	@Test
	public void testgetPriority() 
	{
		ticket1.setPriority(priority);
		when(mockticket.getPriority()).thenReturn(priority);
		assertEquals(priority,ticket1.getPriority());
	}
	
	@Test
	public void testgetAssignDeveloper()
	{
		ticket1.setAssignDeveloper(assignDeveloper);
		when(mockticket.getAssignDeveloper()).thenReturn(assignDeveloper);
		assertEquals(assignDeveloper,ticket1.getAssignDeveloper());
	}
	
	@Test
	public void testgetStatus() 
	{
		ticket1.setStatus(status);
		when(mockticket.getStatus() ).thenReturn(status);
		assertEquals(status,ticket1.getStatus());
	}
	
	@Test
	public void testgetResolveDate()
	{
		ticket1.setResolveDate(new Date());
		when(mockticket.getResolveDate()).thenReturn(new Date());
		assertEquals(new Date(),ticket1.getResolveDate());
	}
	
	@Test
	public void  testgetCategory()
	{
		ticket1.setCategory(category);
		when(mockticket.getCategory()).thenReturn(category);
		assertEquals(category,ticket1.getCategory());
	}
	
	@Test
	public void testtoString()
	{
		ticket1.toString();
		when(mockticket.toString()).thenReturn("");
		assertEquals(156,ticket1.toString().length());
	}
	
}
