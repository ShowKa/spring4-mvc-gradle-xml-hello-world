package com.mkyong.helloworld.system;

import org.junit.Test;

import com.mkyong.helloworld.domain.BushoDateDomain;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.NyukinKakeInfoDomain;
import com.mkyong.helloworld.kubun.BushoKubun;

import junit.framework.TestCase;

public class EmptyProxyTest extends TestCase {

	@Test
	public void test01() {
		BushoDomain e1 = EmptyProxy.domain(BushoDomain.class);
		BushoDomain e2 = EmptyProxy.domain(BushoDomain.class);
		assertTrue(e1 == e2);
	}

	@Test
	public void test02() {
		BushoDomain e = EmptyProxy.domain(BushoDomain.class);
		assertEquals(BushoKubun.EMPTY, e.getBushoKubun());
	}

	@Test
	public void test03() {
		BushoDomain e = EmptyProxy.domain(BushoDomain.class);
		String name = EmptyProxy.domain(BushoDateDomain.class).getClass().getSimpleName();
		assertEquals(name, e.getBushoDateDomain().getClass().getSimpleName());
	}

	@Test
	public void test04() {
		NyukinKakeInfoDomain e = EmptyProxy.domain(NyukinKakeInfoDomain.class);
		assertEquals(new Integer(0), e.getNyukinDate());
	}

	@Test
	public void test05() {
		KokyakuDomain e = EmptyProxy.domain(KokyakuDomain.class);
		assertTrue(e.isEmpty());
		assertTrue(!e.isHojin());
		assertTrue(!e.isKojin());
		assertEquals("", e.getName());
	}

}
