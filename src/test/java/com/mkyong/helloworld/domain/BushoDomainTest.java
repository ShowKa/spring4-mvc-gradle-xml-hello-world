package com.mkyong.helloworld.domain;

import org.junit.Test;

import junit.framework.TestCase;

public class BushoDomainTest extends TestCase {

	@Test
	public void test_01() {
		BushoDomain emp = BushoDomain.EMPTY;
		assertTrue(emp.isEmpty());
		assertFalse(emp.isHanbaiJigyoBusho());
	}
}
