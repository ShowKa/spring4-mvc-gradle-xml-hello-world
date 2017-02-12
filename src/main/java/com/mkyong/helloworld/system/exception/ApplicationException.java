package com.mkyong.helloworld.system.exception;

public class ApplicationException extends RuntimeException {
	/**
	 * SID.
	 */
	private static final long serialVersionUID = 7911381036041646154L;

	private String message;

	public ApplicationException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
