package com.virtusa.spring.daotest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when; 

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.virtusa.spring.dao.DeveloperDAO;
import com.virtusa.spring.model.FileUpload;

public class DeveloperDAOTest {
	
	private DeveloperDAO mockedDeveloperDAO;
	@Mock
	private FileUpload file;
	private int fileId;
	private byte[] fileData;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception { 
		mockedDeveloperDAO=mock(DeveloperDAO.class);
		file=new FileUpload(fileId, fileData);
		when(mockedDeveloperDAO.setStatus(file)).thenReturn(0);
//		when(mockedDeveloperDAO.uploadfile(file)).thenReturn(0);
	}
	@Test
	public void testSetStatus() {
		assertEquals(0,mockedDeveloperDAO.setStatus(file));
		
	}
	/*@Test
	public void testUploadFile() {
		assertEquals(0,mockedDeveloperDAO.uploadfile(file));
	}*/
	
}
