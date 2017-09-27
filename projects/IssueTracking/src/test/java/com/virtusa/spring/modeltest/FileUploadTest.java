package com.virtusa.spring.modeltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.virtusa.spring.model.FileUpload;
import com.virtusa.spring.model.Ticket;

public class FileUploadTest {
	
	private FileUpload fileUpload;
	@Mock
	private FileUpload fileUpload1;
	@Mock
	private FileUpload fileUpload2;
	@Mock
	private Ticket ticket;
	@Mock
	private byte[] fileData;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	 
	@Before
	public void setUp() throws Exception {
		fileUpload=mock(FileUpload.class);
		fileData=new byte[10];
		fileUpload1=new FileUpload();
		fileUpload2=new FileUpload(1, "string".getBytes());
		 ticket=new Ticket(null,"hello",null,new Date(),null,null,null, new Date());
		
	}
	@Test
	public void testGetFileId() {
		fileUpload2.setFileId(1);
		when(fileUpload.getFileId()).thenReturn(1);
		 assertEquals(1, fileUpload2.getFileId());
	}
	@Test
	public void testGetTicket() {
		fileUpload2.setTicket(ticket);
		when(fileUpload.getTicket()).thenReturn(ticket);
		 assertEquals(ticket, fileUpload2.getTicket());
	}
	@Test
	public void testGetFileData() {
		fileUpload2.setFileData(fileData);
		when(fileUpload.getFileData()).thenReturn(fileData);
		 assertEquals(fileData, fileUpload2.getFileData());
	}
	@Test
	public void testToString() {
		 when(fileUpload.toString()).thenReturn("FileUpload [fileId=1, fileData=fileData,ticket=ticket]");
		 assertEquals(75, fileUpload2.toString().length());
	} 
}
