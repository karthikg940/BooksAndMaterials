package com.virtusa.spring.servicetest;

import static org.junit.Assert.assertEquals;
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
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.virtusa.spring.dao.UserDAO;
import com.virtusa.spring.exceptions.UserException;
import com.virtusa.spring.model.Category;
import com.virtusa.spring.model.FileUpload;
import com.virtusa.spring.model.Priority;
import com.virtusa.spring.model.Project;
import com.virtusa.spring.model.Role;
import com.virtusa.spring.model.Status;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;
import com.virtusa.spring.service.UserService;

public class UserServiceTest {

	
	private UserService userService;
	@Mock
	private UserDAO userDAO;
	@Mock
	private User user;
	@Mock
	private User user1;
	@Mock
	private User user2;
	@Mock
	private Role role;
	@Mock
	private Category category1;
	@Mock
	private Category category2;
	@Mock
	private Project project;
	@Mock
	private Project project1;
	@Mock
	private Project project2;
	@Mock
	private Status status;
	@Mock
	private Ticket ticket;
	@Mock
	private Ticket ticket1;
	@Mock
	private Priority priority;
	@Mock
	private FileUpload file1;
	@Mock
	private FileUpload file2;
	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws SQLException {
	MockitoAnnotations.initMocks(this);
	userService = new UserService();
	userService.setUserdao(userDAO);
	
	role=new Role(102, "user");
	user1=new User("karthik","abcded@gmail.com","Karthik123", "password",90522, role);
	User user3=new User("karthik","abcded@gmail.com","Karthik123", "password",90522, role);
	user3.setUserId(100);
	user2=new User("karthik1","abcded@gmail.com","Karthik1232", "password",90522, role);
	category1=new Category(201,"ui");
	category2=new Category(202,"h/w");
	Set<Category>set=new HashSet<Category>();
	set.add(category1);
	set.add(category2);
	project=new Project(10, "tracking");
	status=new Status(700,"pending");
	priority=new Priority(601,"high");
	ticket=new Ticket(project, "description1", user1, new Date(), priority,null, status,new Date());
	Ticket ticket3=new Ticket(project, "description1", user3, new Date(), priority,null, status,new Date());
	ticket3.setTicketId(100);
	ticket.setCategory(set);
	ticket1=new Ticket(project, "description2", user2, new Date(), priority,null, status,new Date());
	ticket1.setCategory(set);
	ticket.setTicketId(1);
	/*file1.setTicket(ticket);
	file2.setTicket(ticket);
	file1.setFileId(1);*/
	file1=new FileUpload(10, "fileData".getBytes());
	file1.setTicket(ticket);
	file2=new FileUpload(20, "fileData".getBytes());
	
	ticket1.setTicketId(2);
	file2.setTicket(ticket1);
	when(userDAO.getUser()).thenReturn(Arrays.asList(user1, user2));
	when(userDAO.getCategory()).thenReturn(Arrays.asList(category1,category2));
	when(userDAO.getUser(2)).thenReturn(user1);
	when(userDAO.getCategory(201)).thenReturn(category1);
	when(userDAO.getProject(10)).thenReturn(project);
	when(userDAO.getStatus(700)).thenReturn(status);
	when(userDAO.ticketDetails(ticket)).thenReturn(ticket);
	when(userDAO.getTicket(100)).thenReturn(ticket3);
	when(userDAO.getTicket()).thenReturn(Arrays.asList(ticket,ticket1));
	when(userDAO.getRole(102)).thenReturn(role);
	when(userDAO.getProjects()).thenReturn(Arrays.asList(project1,project2));
	when(userDAO.getFileData()).thenReturn(Arrays.asList(file1,file2));
	 
	
	}
	@Test
	public void getLoginTest() throws UserException {
	//System.out.println("test");
	user= userService.addLogin("Karthik123", "password");
	assertEquals("Karthik123",user.getUserName());
	}
	@Test
	public void getCategoryTest() throws UserException {
	//System.out.println("test");
		List<Category>categoryList= userService.getCategory();
		assertEquals(2,categoryList.size());
		
	}
	@Test
	public void getUserTest() throws UserException {
	//System.out.println("test");
		User user= userService.getUser(2);
		assertEquals("karthik",user.getFullName());
	}
	@Test
	public void Test_Ticket_Details() throws SQLException
	{
		System.out.println("in ticket details");
		Ticket ticket2=userService.ticketDetails(user1, 201, 10,"discription1");
		assertEquals(null,ticket2);
	}
	@Test
	public void Test_view_tickets_byId() throws SQLException
	{
		 
		System.out.println("in ticket details");
		Ticket ticket=userService.viewTicketById(100,100);
		
		assertEquals("description1",ticket.getDescription());
	}
	@Test
	public void viewAllTicketsTest() throws UserException {
	//System.out.println("test");
		List<Ticket>ticketList= userService.viewAllTickets(0);
		assertEquals(2,ticketList.size());
	}
	@Test
	public void viewAllTicketsByCategoryTest() throws UserException {
	//System.out.println("test");
		List<Ticket>ticketList= userService.viewTicketByCategory(201, 0);
		assertEquals(2,ticketList.size());
	}
	
	@Test
	public void testregistration()
	{
		userService.getUserdao();
		user.setRole(role);
		user.setUserName("abcd");
		when(userDAO.addUser(user)).thenReturn(user);
		
		user1.setUserName("abcd1");
		
		boolean actual=userService.registration(user);
		assertEquals(true, actual);
		
	}
	
	@Test
	public void testgetProjects()
	{
		List<Project> project=userService.getProjects();
		assertEquals(2, project.size());
	}
	
	@Test
	public void  testgetdownLoadData()
	{
		//ticket.setTicketId(1);
		List fileUpload=userService.getdownLoadData();
		assertEquals(2,fileUpload.size());
	}
	@Test
	public void testgetFileData()
	{
		byte[] a=userService.getFileData(1);
		assertEquals(8, a.length);
	}
}