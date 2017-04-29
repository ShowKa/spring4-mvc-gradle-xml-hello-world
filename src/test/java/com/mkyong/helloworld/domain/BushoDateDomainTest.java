package com.mkyong.helloworld.domain;

import org.junit.Test;

import junit.framework.TestCase;

public class BushoDateDomainTest extends TestCase {

	@Test
	public void test_01() {
		BushoDateDomain emp = BushoDateDomain.EMPTY;
		assertTrue(emp.isEmpty());
		System.out.println(emp.eigyoDateEqualsKeiyoDate());
	}

}
