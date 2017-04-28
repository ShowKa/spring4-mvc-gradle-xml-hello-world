package com.mkyong.helloworld;

import java.util.UUID;

import org.junit.Test;

import com.mkyong.helloworld.value.Kakaku;

import junit.framework.TestCase;

public class TestSample extends TestCase {

	@Test
	public void test01() {
		System.out.println(UUID.randomUUID().hashCode());

		Kakaku a = Kakaku.EMPTY;
		System.out.println(a.isEmpty());

		Kakaku b = new Kakaku(100, 0.05);
		System.out.println(b.isEmpty());
		System.out.println(a.add(b, a, b).getZeikomiKakakuFormatted());

	}
}
