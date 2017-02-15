package com.mkyong.helloworld.kubun.i;

public interface Kubun {

	String getCode();

	default boolean eq(String value) {
		return getCode().equals(value);
	}

	default boolean notEq(String value) {
		return !getCode().equals(value);
	}

	default boolean isIncludedIn(String... values) {
		for (String v : values) {
			if (getCode().equals(v)) {
				return true;
			}
		}
		return false;
	}
}
