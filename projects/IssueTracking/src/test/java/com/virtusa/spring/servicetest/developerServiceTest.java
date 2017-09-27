package com.virtusa.spring.servicetest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.virtusa.spring.dao.DeveloperDAO;
import com.virtusa.spring.dao.UserDAO;
import com.virtusa.spring.model.FileUpload;
import com.virtusa.spring.model.Priority;
import com.virtusa.spring.model.Role;
import com.virtusa.spring.model.Status;
import com.virtusa.spring.model.Ticket;
import com.virtusa.spring.model.User;
import com.virtusa.spring.service.DeveloperService;


public class developerServiceTest {
	
	private DeveloperService developerService;
	@Mock
	private UserDAO userdao;
	@Mock
	private DeveloperDAO developerDao;
	/*@Mock
	private CommonsMultipartFile[] file1;*/
	@Mock
	private FileUpload file;
	@Mock
	private User user;
	@Mock
	private Status status1;
	@Mock
	private Status status2;
	@Mock
	private Role role;
	@Mock
	private Ticket ticket;
	@Mock
	private Ticket ticket1;
	@Mock
	private Priority priority;
	@Mock
	private Status status;
	@Mock
	private Set<Ticket> set;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
 
	@Before
	public void setUp() throws SQLException, IOException {
		
		MockitoAnnotations.initMocks(this);
	developerService = new DeveloperService();
	developerService.setUserdao(userdao);
	developerService.setDeveloperDao(developerDao);
	user=new User("karthik","abcded@gmail.com","Karthik123", "password",90522, role);
	ticket=new Ticket(null, "description1", user, new Date(),priority,null,status,new Date());
	ticket1=new Ticket(null, "description2", user, new Date(), null,null, null,new Date());
    set=new HashSet<Ticket>();
	set.add(ticket);
	set.add(ticket1);
	user.setDeveloperTickets(set);
	
	 
    
	when(userdao.getStatus()).thenReturn(Arrays.asList(status1,status2));
	when(userdao.getStatus(702)).thenReturn(status1);
	//when(developerDao.setStatus(file)).thenReturn(0);
	}
	@Test
	public void testGetDeveloperTickets(){
       Set<Ticket> ticket=developerService.viewAllTickets(user);
		assertEquals(2,ticket.size());
	}
	@Test
	public void getStatusTest(){
		List<Status> status=developerService.getStatus();
		assertEquals(2,status.size());
	}
	 
	 
}
