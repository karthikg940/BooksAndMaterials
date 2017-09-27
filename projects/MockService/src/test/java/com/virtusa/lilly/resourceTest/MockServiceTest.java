package com.virtusa.lilly.resourceTest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.lilly.resource.MockServiceImpl;
import com.virtusa.lilly.resource.MockServiceInterface;

public class MockServiceTest extends Assert {
	
	private final static String END_POINT="http://localhost:8181/cxf/api" ;
	private static Server server;
	
	@BeforeClass
	public static void initialize() throws Exception
	{
		startServer();
	}
	
	public static void startServer() throws Exception
	{
		JAXRSServerFactoryBean sf=new JAXRSServerFactoryBean();
		sf.setResourceClasses(MockServiceImpl.class);
		/*List<Object> providers = new ArrayList<Object>();
		sf.setProvider(providers);*/
		sf.setResourceProvider(MockServiceImpl.class, new SingletonResourceProvider(new MockServiceImpl(),true));
		sf.setAddress(END_POINT);
		server=sf.create();
		
	}
	
	/*@AfterClass
	public static void destroy() throws Exception
	{
		server.stop();
		server.destroy();
	}*/
	
	@Test
	public void testGet()
	{
		 WebClient client=WebClient.create(END_POINT);
		 client.accept(MediaType.APPLICATION_XML);
		 client.path("/mockapi");
		 MockServiceInterface mockServiceImpl=client.get(MockServiceInterface.class); 
		 assertEquals("Helloworld",mockServiceImpl.getAll());
	}

	@Test
	public void testCreate() {
		MockServiceInterface client = JAXRSClientFactory.create(END_POINT, MockServiceInterface.class);
		Response response = client.create("xmldata");
		assertEquals(Status.CREATED,response);
	}
}
