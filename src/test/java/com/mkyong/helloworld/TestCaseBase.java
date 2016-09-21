package com.mkyong.helloworld;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class TestCaseBase extends TestCase {
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
}
