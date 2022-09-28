package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalTest {

	@Test
	public void testAdd() {
		Cal cal = new Cal();
		int rs = cal.add(3,4);
		assertEquals(7,rs);
	}

	@Test
	public void testConStr() {
		Cal cal = new Cal();
		String rs = cal.conStr("one", "two");
		assertEquals("onetwo", rs);
	}

}
