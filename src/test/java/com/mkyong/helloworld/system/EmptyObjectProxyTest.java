package com.mkyong.helloworld.system;

import org.junit.Test;

import com.mkyong.helloworld.domain.BushoDomain;

import junit.framework.TestCase;

public class EmptyObjectProxyTest extends TestCase {
	@Test
	public void test01() {
		BushoDomain e1 = EmptyObjectProxy.get(BushoDomain.class);
		BushoDomain e2 = EmptyObjectProxy.get(BushoDomain.class);
		assertTrue(e1 == e2);
	}
}
