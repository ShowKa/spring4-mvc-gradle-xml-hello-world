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
		System.out.println(a.getZeikomiKakakuFormatted());

		System.out.println(a.add(new Kakaku(1, 1)) == Kakaku.EMPTY);

		Kakaku b = new Kakaku(100l, 0.05);
		System.out.println(b.isEmpty());

	}
}
