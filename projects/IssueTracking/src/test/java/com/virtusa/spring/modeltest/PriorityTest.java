package com.virtusa.spring.modeltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.virtusa.spring.model.Priority;

public class PriorityTest {
	
	private Priority priority;
	@Mock
	private Priority priority1;
	@Mock
	private Priority priority2;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	  
	@Before
	public void setUp() throws Exception {
		priority=mock(Priority.class);
		priority1=new Priority();
		priority2=new Priority(1,"high");
	}
	@Test
	public void testGetPriorityId() {
		priority2.setPriorityId(1);
		when(priority.getPriorityId()).thenReturn(1);
		 assertEquals(1, priority2.getPriorityId());
	}
	@Test
	public void testGetPriorityName() {
		priority2.setPriorityName("high");
		when(priority.getPriorityName()).thenReturn("high");
		 assertEquals("high", priority2.getPriorityName());
	}
	@Test
	public void testToString() {
		 when(priority.toString()).thenReturn("Priority[PriorityId=1,PriorityName=high]");
		 assertEquals(42, priority2.toString().length());
	} 
	
}
