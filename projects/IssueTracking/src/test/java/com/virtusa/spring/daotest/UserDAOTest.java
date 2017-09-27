package com.virtusa.spring.daotest;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.spring.dao.UserDAO;
import com.virtusa.spring.model.Category;
import com.virtusa.spring.model.Priority;
import com.virtusa.spring.model.Project;
import com.virtusa.spring.model.Role;
import com.virtusa.spring.model.Status;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;

public class UserDAOTest {

	
	private UserDAO mockedUserDAO;
	private User user1;
	private User user2;
	private Role role;
	private Category category1;
	private Category category2;
	private Project project;
	private Priority priority;
	private Status status;
	private Ticket ticket1;
	private Ticket ticket2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		mockedUserDAO=mock(UserDAO.class);
		role=new Role(102, "user");
		user1=new User("karthik","abcded@gmail.com","Karthik123", "password",90522, role);
		user2=new User("karthik1","abcded@gmail.com","Karthik1232", "password",90522, role);
		category1=new Category(201,"ui");
		category2=new Category(202,"h/w");
		project=new Project(10, "tracking");
		priority=new Priority(601,"high");
		status=new Status(701,"pending");
		ticket1=new Ticket(project, "description1", user1, new Date(), priority,null, status,new Date());
		ticket2=new Ticket(project, "description2", user2, new Date(), priority,null, status,new Date());
		
		when(mockedUserDAO.getUser()).thenReturn(Arrays.asList(user1,user2));
		when(mockedUserDAO.getUser(2)).thenReturn(user1);
		when(mockedUserDAO.getRole(102)).thenReturn(role);
		when(mockedUserDAO.getCategory()).thenReturn(Arrays.asList(category1,category2));
		when(mockedUserDAO.getCategory(201)).thenReturn(category1);
		when(mockedUserDAO.getProject(10)).thenReturn(project);
		when(mockedUserDAO.getPriority(601)).thenReturn(priority);
		when(mockedUserDAO.getStatus(701)).thenReturn(status);
		when(mockedUserDAO.getTicket()).thenReturn(Arrays.asList(ticket1,ticket2));
		when(mockedUserDAO.getTicket(100)).thenReturn(ticket2);
		when(mockedUserDAO.ticketDetails(ticket1)).thenReturn(ticket1);
		when(mockedUserDAO.addUser(user1)).thenReturn(user1);
	}
	@Test
	public void testCreateUser() {
		user1=new User("karthik","abcded@gmail.com","Karthik123", "password",90522, role);
		assertEquals("karthik", user1.getFullName());
	}

	@Test
	public void testListAllEmp() throws SQLException {
		List<User>allUsers=mockedUserDAO.getUser();
		assertEquals(2, allUsers.size());
	}
	@Test
	public void testGetUserById() throws SQLException {
		int userId = 2;
		User user1 = mockedUserDAO.getUser(userId);
		assertEquals("Karthik123",user1.getUserName());
	}
	@Test
	public void testRoleById() throws SQLException {
		int roleId = 102;
		Role role = mockedUserDAO.getRole(roleId);
		assertEquals(102,role.getRoleId());
	}
	@Test
	public void testAllCategory()
	{
		List<Category> allCategory=mockedUserDAO.getCategory();
		assertEquals(2,allCategory.size());
	}
	@Test
	public void testCategory()
	{
		Category category=mockedUserDAO.getCategory(201);
		assertEquals("ui", category.getCategoryName());
	}
	
	@Test
	public void testProject()
	{
		Project project=mockedUserDAO.getProject(10);
		assertEquals("tracking", project.getProjectName());
	}
	@Test
	public void testPriority()
	{
		Priority priority=mockedUserDAO.getPriority(601);
		assertEquals(601, priority.getPriorityId());
	}
	@Test
	public void testGetStatus()
	{
		Status status=mockedUserDAO.getStatus(701);
		assertEquals(701,status.getStatusId());
	}
	@Test
	public void testAllTickets()
	{
		List<Ticket> allTickets=mockedUserDAO.getTicket();
		assertEquals(2,allTickets.size());
	}
	@Test
	public void testGetTicketById() {
		int ticketId = 100;
		Ticket ticket1= mockedUserDAO.getTicket(ticketId);
		assertEquals("description2",ticket1.getDescription());
	}
	@Test
	public void testAdd_Ticket_Details() {
		Ticket ticket= mockedUserDAO.ticketDetails(ticket1);
		assertEquals("description1",ticket.getDescription());
	}
	@Test
	public void testAdd_User_Details() {
		User user= mockedUserDAO.addUser(user1);
		assertEquals("Karthik123",user.getUserName());
	}
}
