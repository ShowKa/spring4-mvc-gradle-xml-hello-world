package com.mkyong.helloworld.value;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public abstract class AbstractValue {
	/**
	 * 空チェック
	 * 
	 * @return 値オブジェクトとして意味をなさない状態ならtrue
	 */
	abstract public boolean isEmpty();

	/**
	 * 同値判定
	 * 
	 * @param other
	 * @return
	 */
	protected abstract boolean equals(AbstractValue other);

	/**
	 * 同値判定
	 * 
	 * @param other
	 * @return
	 */
	public final boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (other instanceof AbstractValue) {
			return equals((AbstractValue) other);
		}
		return false;
	}

	/**
	 * 文字列化
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
