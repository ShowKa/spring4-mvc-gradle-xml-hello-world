package com.mkyong.helloworld.system.exception;

import lombok.Getter;

@Getter
public class EmptyException extends ValidateException {

	/**
	 * SID.
	 */
	private static final long serialVersionUID = -1183953047533837162L;

	/**
	 * 存在しないものの名称
	 */
	private String target;

	public EmptyException(String target) {
		super(target + "を設定する必要があります。");
		this.target = target;
	}

}
