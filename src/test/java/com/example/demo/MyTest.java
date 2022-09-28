package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTest {

	@BeforeEach
	public void testBeforeEach() {
		System.out.println("do @BeforeEach");
	}
	
	@AfterEach
	public void testAfterEach() {
		System.out.println("do @AfterEach");
	}
	
	@BeforeAll
	public static void testBeforeAll() {
		System.out.println("do @BeforeAll");
	}
	
	@AfterAll
	public static void testAfterAll() {
		System.out.println("do @AfterAll");
	}
	
	@Test
	public void test1() {
		System.out.println("do test1");
	}
	
	@Test
	public void test2() {
		System.out.println("do test2");
	}
}
