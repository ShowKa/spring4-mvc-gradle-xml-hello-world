package com.mkyong.helloworld.domain;

import org.junit.Test;

import com.mkyong.helloworld.domain.builder.KokyakuDomainBuilder;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;

import junit.framework.TestCase;

public class KokyakuDomainTest extends TestCase {
	@Test
	public void test_IsKojin_01() {
		KokyakuDomain kokyakuDomain = new KokyakuDomainBuilder().withKokyakuKubun(KokyakuKubun.個人)
				.withGenteiKubun(GenteiKubun.限定)
				.build();

		assertEquals(true, kokyakuDomain.isKojinGentei());
	}

	@Test
	public void test_IsKojin_02() {
		KokyakuDomain kokyakuDomain = new KokyakuDomainBuilder().withKokyakuKubun(KokyakuKubun.法人)
				.withGenteiKubun(GenteiKubun.限定)
				.build();

		assertEquals(false, kokyakuDomain.isKojinGentei());
	}

	@Test
	public void test_IsKojin_03() {
		KokyakuDomain kokyakuDomain = new KokyakuDomainBuilder().withKokyakuKubun(KokyakuKubun.個人)
				.withGenteiKubun(GenteiKubun.限定しない)
				.build();

		assertEquals(false, kokyakuDomain.isKojinGentei());
	}
}
