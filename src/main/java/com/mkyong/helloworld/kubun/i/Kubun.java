package com.mkyong.helloworld.kubun.i;

import com.mkyong.helloworld.system.exception.SystemException;

public interface Kubun {

	public String getCode();

	@SuppressWarnings("unchecked")
	public static <T extends Kubun> T get(Class<T> enumType, String code) {

		String _code = code == null ? "" : code;

		Kubun[] constants = enumType.getEnumConstants();
		for (Kubun k : constants) {
			if (k.getCode().equals(_code)) {
				return (T) k;
			}
		}

		throw new SystemException("存在しないコードが引数に指定されました : " + code);
	}

	default boolean eq(String code) {
		return getCode().equals(code);
	}

	default boolean notEq(String code) {
		return !getCode().equals(code);
	}

	default boolean isIncludedIn(String... codes) {
		for (String c : codes) {
			if (getCode().equals(c)) {
				return true;
			}
		}
		return false;
	}

}
