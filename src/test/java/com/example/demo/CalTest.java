package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalTest {

	@Test
	public void testAdd() {
		Cal cal = new Cal();
		int rs = cal.add(3,4);
		assertNotNull(rs);
		assertEquals(7, rs);
		assertTrue(rs > 1);
		assertFalse(rs < 1);
	}

	@Test
	public void testConStr() {
		Cal cal = new Cal();
		String rs = cal.conStr("one", "two");
		assertEquals("onetwo", rs);
	}

	@Test
	public void testDivide() {
		Cal cal = new Cal();
		assertThrows(ArithmeticException.class, () -> {
			cal.divide(12, 0);
		});
	}
	
}
