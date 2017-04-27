package com.mkyong.helloworld;

import java.util.UUID;

import org.junit.Test;

import junit.framework.TestCase;

public class TestSample extends TestCase {

	@Test
	public void test01() {
		System.out.println(UUID.randomUUID().hashCode());
	}
}
