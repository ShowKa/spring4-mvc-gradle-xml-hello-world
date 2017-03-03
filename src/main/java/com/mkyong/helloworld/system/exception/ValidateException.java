package com.mkyong.helloworld.system.exception;

public class ValidateException extends ApplicationException {

	/**
	 * SID.
	 */
	private static final long serialVersionUID = 2652435245081204638L;

	/**
	 * コンストラクタ
	 * 
	 * @param message
	 */
	public ValidateException(String message) {
		super(message);
	}

}
