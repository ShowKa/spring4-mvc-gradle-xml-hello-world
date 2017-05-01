package com.mkyong.helloworld.system.exception;

public class SystemException extends RuntimeException {
	/**
	 * SID.
	 */
	private static final long serialVersionUID = 7911381036041646154L;

	private String message;

	private Throwable cause;

	public SystemException(String message) {
		this.message = message;
	}

	public SystemException(String message, Throwable cause) {
		this.message = message;
		this.cause = cause;
	}

	public String getMessage() {
		return this.message;
	}

	public Throwable getCause() {
		return this.cause;
	}

}
