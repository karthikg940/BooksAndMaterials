package com.virtusa.spring.modeltest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.virtusa.spring.model.Category;

public class CategoryTest {
 
	private Category mockCategory;
	@Mock
	private Category category1;
	@Mock
	private Category category2;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	} 
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	  
	@Before
	public void setUp() throws Exception {
		mockCategory=mock(Category.class);
		category1=new Category();
		category2=new Category(1,"UI");
		
	} 
	@Test
	public void testGetCategoryId() {
		category2.setCategoryId(1);
		when(mockCategory.getCategoryId()).thenReturn(1);
		 assertEquals(1, category2.getCategoryId());
		
	}
	@Test
	public void testGetCategoryName() {
		category2.setCategoryName("UI");
		when(mockCategory.getCategoryName()).thenReturn("UI");
		 assertEquals("UI", category2.getCategoryName());
	}
	@Test
	public void testToString() {
		 when(mockCategory.toString()).thenReturn("Category[categoryId=1,categoryName=UI]");
		 assertEquals(40, category2.toString().length());
	}
}
