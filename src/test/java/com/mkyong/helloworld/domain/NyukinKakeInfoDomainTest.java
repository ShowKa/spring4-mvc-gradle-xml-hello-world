package com.mkyong.helloworld.domain;

import org.junit.Test;

import junit.framework.TestCase;

public class NyukinKakeInfoDomainTest extends TestCase {
	@Test
	public void test_01() {
		NyukinKakeInfoDomain e = NyukinKakeInfoDomain.EMPTY;
		System.out.println(e.getNyukinYoteiDate(null));
	}

}
