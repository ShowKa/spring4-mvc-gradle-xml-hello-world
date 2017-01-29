package com.mkyong.helloworld.kubun;

public interface Kubun {
	String getLabel();

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
