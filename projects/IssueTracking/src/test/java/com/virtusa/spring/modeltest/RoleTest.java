package com.virtusa.spring.modeltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.virtusa.spring.model.Functions;
import com.virtusa.spring.model.Role;

public class RoleTest {

	private Role mockRole;
	@Mock
	private Role role1;
	@Mock
	private Role role2;
	@Mock
	private List<Functions>functions;
	@Mock
	private Functions function1;
	@Mock
	private Functions function2;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	 
	@Before
	public void setUp() throws Exception {
		mockRole=mock(Role.class);
		role1=new Role();
		role2=new Role(1, "user");
		function1=new Functions(1,"raise ticket");
		function2=new Functions(2,"upload patchfiles");
		functions=new ArrayList<Functions>();
		functions.add(function1);
		functions.add(function2);
	} 
	@Test
	public void testGetRoleId() {
		role2.setRoleId(1);
		when(mockRole.getRoleId()).thenReturn(1);
		 assertEquals(1, role2.getRoleId());
	}
	@Test
	public void testGetRoleName() {
		role2.setRoleName("user");
		when(mockRole.getRoleName()).thenReturn("user");
		 assertEquals("user", role2.getRoleName());
	}
	@Test
	public void testGetFunctions() {
		role2.setFunctions(functions);
		when(mockRole.getFunctions()).thenReturn(functions);
		 assertEquals(functions, role2.getFunctions());
	}
	@Test
	public void testToString() {
		 when(mockRole.toString()).thenReturn("Role[eoleId=1,roleName=user]");
		 assertEquals(44, role2.toString().length());
	}
}
