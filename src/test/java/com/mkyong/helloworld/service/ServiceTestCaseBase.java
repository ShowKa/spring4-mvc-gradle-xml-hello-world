package com.mkyong.helloworld.service;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import junit.framework.TestCase;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public abstract class ServiceTestCaseBase extends TestCase {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

}
