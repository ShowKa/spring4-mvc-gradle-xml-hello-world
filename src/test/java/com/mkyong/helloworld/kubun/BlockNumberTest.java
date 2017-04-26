package com.mkyong.helloworld.kubun;

import org.junit.Test;

import com.mkyong.helloworld.kubun.i.Kubun;
import com.mkyong.helloworld.system.exception.SystemException;

import junit.framework.TestCase;

public class BlockNumberTest extends TestCase {
	@Test
	public void test01() {
		BlockNumber bn = Kubun.get(BlockNumber.class, "ZZ");
		assertTrue(bn == BlockNumber.ZZ);
	}

	@Test
	public void test02() {
		BlockNumber bn = Kubun.get(BlockNumber.class, "");
		assertTrue(bn == BlockNumber.未設定);
	}

	@Test
	public void test03() {
		BlockNumber bn = Kubun.get(BlockNumber.class, null);
		assertTrue(bn == BlockNumber.未設定);
	}

	@Test
	public void test04() {
		try {
			Kubun.get(BlockNumber.class, "abcdefg");
		} catch (SystemException e) {
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}

	@Test
	public void test05() {
		assertTrue(BlockNumber.ZZ.isHuteiki());
	}

	@Test
	public void test06() {
		assertTrue(!BlockNumber.未設定.isHuteiki());
	}

}
