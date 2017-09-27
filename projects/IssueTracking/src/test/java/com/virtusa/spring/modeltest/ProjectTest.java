package com.virtusa.spring.modeltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.virtusa.spring.model.Project;

public class ProjectTest {
	 
	private Project mockProject;
	@Mock
	private Project project1;
	@Mock
	private Project project2;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	 
	@Before
	public void setUp() throws Exception {
		mockProject=mock(Project.class); 
		project1=new Project();
		project2=new Project(100,"Issue Tracking");
	}
	@Test
	public void testGetProjectId() {
		project2.setProjectId(100);
		when(mockProject.getProjectId()).thenReturn(100);
		 assertEquals(100, project2.getProjectId());
	}
	@Test
	public void testGetProjectName() {
		project2.setProjectName("Issue Tracking");
		when(mockProject.getProjectName()).thenReturn("Issue Tracking");
		 assertEquals("Issue Tracking", project2.getProjectName());
	}
	@Test
	public void testToString() {
		 when(mockProject.toString()).thenReturn("Project[projectId=100,projectName=Issue Tracking]");
		 assertEquals(51, project2.toString().length());
	}
	
}
