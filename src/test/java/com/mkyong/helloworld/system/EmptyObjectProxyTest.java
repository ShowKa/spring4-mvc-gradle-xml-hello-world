package com.mkyong.helloworld.system;

import org.junit.Test;

import com.mkyong.helloworld.domain.BushoDateDomain;
import com.mkyong.helloworld.domain.BushoDomain;
import com.mkyong.helloworld.domain.KokyakuDomain;
import com.mkyong.helloworld.domain.NyukinKakeInfoDomain;
import com.mkyong.helloworld.kubun.BushoKubun;

import junit.framework.TestCase;

public class EmptyObjectProxyTest extends TestCase {

	@Test
	public void test01() {
		BushoDomain e1 = EmptyObjectProxy.domain(BushoDomain.class);
		BushoDomain e2 = EmptyObjectProxy.domain(BushoDomain.class);
		assertTrue(e1 == e2);
	}

	@Test
	public void test02() {
		BushoDomain e = EmptyObjectProxy.domain(BushoDomain.class);
		assertEquals(BushoKubun.EMPTY, e.getBushoKubun());
	}

	@Test
	public void test03() {
		BushoDomain e = EmptyObjectProxy.domain(BushoDomain.class);
		String name = EmptyObjectProxy.domain(BushoDateDomain.class).getClass().getSimpleName();
		assertEquals(name, e.getBushoDateDomain().getClass().getSimpleName());
	}

	@Test
	public void test04() {
		NyukinKakeInfoDomain e = EmptyObjectProxy.domain(NyukinKakeInfoDomain.class);
		assertEquals(new Integer(0), e.getNyukinDate());
	}

	@Test
	public void test05() {
		KokyakuDomain e = EmptyObjectProxy.domain(KokyakuDomain.class);
		assertTrue(e.isEmpty());
		System.out.println(e.toString());
	}

}
