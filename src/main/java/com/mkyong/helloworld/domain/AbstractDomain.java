package com.mkyong.helloworld.domain;

public abstract class AbstractDomain {

	/**
	 * ドメインが空で、意味をなさないオブジェクトであるか判定。
	 * 
	 * @return 空ならtrue
	 * 
	 */
	public abstract boolean isEmpty();
}
