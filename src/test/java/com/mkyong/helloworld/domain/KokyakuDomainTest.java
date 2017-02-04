package com.mkyong.helloworld.domain;

import org.junit.Test;

import com.mkyong.helloworld.entity.MKokyaku;
import com.mkyong.helloworld.kubun.GenteiKubun;
import com.mkyong.helloworld.kubun.KokyakuKubun;

import junit.framework.TestCase;

public class KokyakuDomainTest extends TestCase {
	@Test
	public void test_IsKojin_01() {
		MKokyaku k = new MKokyaku();
		k.setKokyakuKubun(KokyakuKubun.個人.getCode());
		k.setGenteiKubun(GenteiKubun.限定.getCode());
		KokyakuDomain kokyakuDomain = new KokyakuDomain(k);

		assertEquals(true, kokyakuDomain.isKojinGentei());
	}

	@Test
	public void test_IsKojin_02() {
		MKokyaku k = new MKokyaku();
		k.setKokyakuKubun(KokyakuKubun.法人.getCode());
		k.setGenteiKubun(GenteiKubun.限定.getCode());
		KokyakuDomain kokyakuDomain = new KokyakuDomain(k);

		assertEquals(false, kokyakuDomain.isKojinGentei());
	}

	@Test
	public void test_IsKojin_03() {
		MKokyaku k = new MKokyaku();
		k.setKokyakuKubun(KokyakuKubun.個人.getCode());
		k.setGenteiKubun(GenteiKubun.限定しない.getCode());
		KokyakuDomain kokyakuDomain = new KokyakuDomain(k);

		assertEquals(false, kokyakuDomain.isKojinGentei());
	}
}
