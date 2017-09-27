package com.virtusa.spring.servicetest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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

import com.virtusa.spring.dao.AdminDAO;
import com.virtusa.spring.dao.UserDAO;
import com.virtusa.spring.model.Category;
import com.virtusa.spring.model.Priority;
import com.virtusa.spring.model.Project;
import com.virtusa.spring.model.Role;
import com.virtusa.spring.model.Status;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;
import com.virtusa.spring.service.AdminService;

public class AdminServiceTest {
	
	AdminService adminService;
	
	@Mock
	AdminDAO adminDao;
	@Mock
	UserDAO userdao;
	@Mock
	Ticket ticket;
	@Mock
	Ticket ticket1;
	@Mock
	Ticket ticket2;
	@Mock
	Project project;
	@Mock
	User user;
	@Mock
	Priority priority;
	@Mock
	Set<User> assignDeveloper;
	@Mock
	Status status;
	@Mock
	Category category;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		adminService = new AdminService();
		adminService.setAdminDao(adminDao);
		adminService.setUserdao(userdao);
		priority=null;
		Role role1=new Role(101,"admin");
		Priority priority1=new Priority(1,"high");
		Priority priority2=new Priority(2,"low");
		ticket1=new Ticket(project,"description",user,new Date(),priority,assignDeveloper,status,new Date());
		ticket2=new Ticket(project, "description1", user, new Date(), priority, assignDeveloper, status, new Date());
		Ticket ticket3=new Ticket(project, "description3", user, new Date(), priority1, assignDeveloper, status, new Date());
		Ticket ticket4=new Ticket(project,"description4",user,new Date(),priority2,assignDeveloper,status,new Date());
		ticket1.setTicketId(2);
		Category category1=new Category(2,"ui");
		Category category2=new Category(3,"h/w");
		Set<Category>category=new HashSet<Category>();
		category.add(category1);
		ticket1.setCategory(category);
		 
		User user1=new User();
		User user2=new User();
		user1.setRole(role1);
		user2.setRole(role1);
		/*Set<Ticket> ticketSet=new HashSet<Ticket>();
		ticketSet.add(ticket3);
		ticketSet.add(ticket4);
		user1.setDeveloperTickets(ticketSet);
		user2.setDeveloperTickets(ticketSet);*/
		
		
		
		when(userdao.getTicket()).thenReturn(Arrays.asList(ticket1,ticket2));
		when(userdao.getTicket(2)).thenReturn(ticket1);
		when(userdao.getCategory()).thenReturn(Arrays.asList(category1,category2));
		when(userdao.getPriority()).thenReturn(Arrays.asList(priority1,priority2));
		when(userdao.getPriority(2)).thenReturn(priority1);
		when(adminDao.assignPriority(ticket1, priority1)).thenReturn(1);
//		when(userdao.getTicket()).thenReturn(Arrays.asList(ticket3, ticket4));
		when(userdao.getUser()).thenReturn(Arrays.asList(user1, user2));
		when(adminDao.setDeveloper(user)).thenReturn(0);

	}
	
	@Test
	public void viewAllTicketsTest()
	{
		List<Ticket>ticket=adminService.viewAllTickets();
		assertEquals(2,ticket.size());
	}
	@Test
	public void viewTicketByIdTest()
	{
		Ticket ticket=adminService.viewTicketById(2);
		assertEquals("description",ticket.getDescription());
	}
	
	
	@Test
	public void viewTicketsByCategoryTest()
	{
		List<Ticket>tickets=adminService.viewTicketByCategory(2);
		Ticket ticket=tickets.get(0);
		assertEquals(ticket1,ticket);
	}
	@Test
	public void getCategoryTest()
	{
		List<Category> category=adminService.getCategory();
		Category category1=category.get(0);
		assertEquals(2, category1.getCategoryId());
	}
	
	@Test
	public void getPriorityTest()
	{
		List<Priority> priority=adminService.getPriority();
		assertEquals(2,priority.size());
	}
	@Test
	public void assignPriorityTest()
	{
		int i=adminService.assignPriority(2, 1);
		assertEquals(1, 1);;
	}
	@Test 
	public void viewAllTicketsWithPriorityTest()
	{
		List<Ticket> ticket=adminService.viewAllTicketsWithPriority();
 		 
		assertEquals(0,ticket.size());
		
	}
	
	@Test
	public void  getDevelopersTest()
	{
		 List<User> userList=adminService.getDevelopers();
		 assertEquals(2, userList.size());;
		
	}
	@Test
	public void setDeveloperTest()
	{
		int actual=adminService.setDeveloper(ticket, user);
		assertEquals(0, actual);
	}
}
