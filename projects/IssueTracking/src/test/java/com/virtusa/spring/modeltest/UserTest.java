package com.virtusa.spring.modeltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.virtusa.spring.model.Role;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;

public class UserTest {
	
	private User mockeuser;
	@Mock
	private User user1;
	
	@Mock
	private User user2;
	@Mock
	Role role;
	@Mock
	Set<Ticket> ticket;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		mockeuser = mock(User.class);
		role=new Role(1,"admin");
		user1 = new User();
		user2 =new User("abcd","abcd", "abcd","abcd",1234, role);
	}
	
	@Test
	public void testgetUserId()
	{
		user2.setUserId(1);
		when(mockeuser.getUserId()).thenReturn(1);
		 assertEquals(1,user2.getUserId());
	}
	
	@Test
	public void testgetFullName()
	{
		user2.setFullName("abcd");
		when(mockeuser.getFullName()).thenReturn("abcd");
		assertEquals("abcd", user2.getFullName());
	}
	
	@Test
	public void testgetEmail()
	{
		user2.setEmail("abcd");
		when(mockeuser.getEmail()).thenReturn("abcd");
		assertEquals("abcd", user2.getEmail());
	}
	
	@Test
	public void testgetUserName()
	{
		user2.setUserName("abcd");
		when(mockeuser.getUserName()).thenReturn("abcd");
		assertEquals("abcd", user2.getUserName());
	}
	
	@Test
	public void testgetPassword()
	{
		user2.setPassword("abcd");
		when(mockeuser.getPassword()).thenReturn("abcd");
		assertEquals("abcd", user2.getPassword());
	}
	
	@Test
	public void testgetPhoneNumber()
	{
		user2.setPhoneNumber(1234);
		when(mockeuser.getPhoneNumber()).thenReturn((long) 1234);
		assertEquals(1234, user2.getPhoneNumber());
	}
	
	@Test
	public void testgetRole() {
		user2.setRole(role);
		when(mockeuser.getRole()).thenReturn(role);
		assertEquals(role,user2.getRole());
		
	}
	
	@Test
	public void testgetDeveloperTickets()  {
		user2.setDeveloperTickets(ticket) ;
		when(mockeuser.getDeveloperTickets()).thenReturn(ticket);
		assertEquals(ticket,user2.getDeveloperTickets());
		
	}
	
	@Test
	public void testtoString()
	{
		user2.toString();
		when(mockeuser.toString()).thenReturn("User [userId=0, fullName=abcd, email=abcd, userName=abcd, password=abcd, phoneNumber=1234, role=Role [roleId=1, roleName=admin, functions=[]]]");
		assertEquals(142,user2.toString().length());
	}
	
	
	
	
	

}
