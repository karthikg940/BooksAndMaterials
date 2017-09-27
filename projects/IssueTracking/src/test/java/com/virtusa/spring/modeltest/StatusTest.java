package com.virtusa.spring.modeltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.virtusa.spring.model.Status;

public class StatusTest {
	
	private Status mockStatus;
   @Mock
	private Status status1;
   @Mock
	private Status status2;
   @BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	  
	
	@Before
	public void setUp() throws Exception {
		mockStatus=mock(Status.class);
		status1=new Status();
		status2=new Status(1, "pending");
	}
	@Test
	public void testGetStatusId() {
		status2.setStatusId(1);
		when(mockStatus.getStatusId()).thenReturn(1);
		 assertEquals(1, status2.getStatusId());
	} 
	@Test
	public void testGetStatusName() {
		 status2.setStatusName("pending");
		when(mockStatus.getStatusName()).thenReturn("pending");
		 assertEquals("pending", status2.getStatusName());
	}
	@Test
	public void testToString() {
		 when(mockStatus.toString()).thenReturn("Status[statusId=1,statusName=pending]");
		 assertEquals(39, status2.toString().length());
	}
}
