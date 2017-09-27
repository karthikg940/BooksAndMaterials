package com.virtusa.spring.modeltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.virtusa.spring.model.Functions;

public class FunctionsTest {

	private Functions functions;
	@Mock
	private Functions functions1;
	@Mock
	private Functions functions2;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	 
	@Before
	public void setUp() throws Exception { 
		functions=mock(Functions.class);
		functions1=new Functions();
		functions2=new Functions(1, "raise ticket");
	}
	@Test
	public void testGetFunctionId() { 
		functions2.setFunctionId(1);
		when(functions.getFunctionId()).thenReturn(1);
		 assertEquals(1, functions2.getFunctionId());
	}
	@Test
	public void testGetFunctionName() { 
		functions2.setFunctionName("raise ticket");
		when(functions.getFunctionName()).thenReturn("raise ticket");
		 assertEquals("raise ticket", functions2.getFunctionName());
	}
	@Test
	public void testToString() {
		 when(functions.toString()).thenReturn("Functions[FunctionId=1,FunctionName=raise ticket]");
		 assertEquals(51, functions2.toString().length());
	}
}
