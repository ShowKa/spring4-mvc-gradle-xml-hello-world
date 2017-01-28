package com.mkyong.helloworld.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTestCaseBase extends TestCase {
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void dummy() {
		assertEquals(true, true);
	}
}
