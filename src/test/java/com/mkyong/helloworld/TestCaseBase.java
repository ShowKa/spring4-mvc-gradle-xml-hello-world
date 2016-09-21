package com.mkyong.helloworld;


import org.junit.Before;
import org.mockito.MockitoAnnotations;

import junit.framework.TestCase;

public class TestCaseBase extends TestCase {
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
}
