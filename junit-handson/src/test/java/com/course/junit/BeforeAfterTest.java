package com.course.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeforeAfterTest {
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Running before class");
	}


	@Before
	public void setup() {
		System.out.println("Before Test");
	}
	
	@Test
	public void test1() {
		System.out.println("test1 executed");	
	}
	
	@Test
	public void test2() {
		System.out.println("test2 executed");	
	}
	
	@After
	public void teardown() {
		System.out.println("After test");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Running after class");
	}

}
