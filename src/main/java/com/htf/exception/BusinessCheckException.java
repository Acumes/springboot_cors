package com.htf.exception;

public class BusinessCheckException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8538654597385347086L;

	public BusinessCheckException() {
		super();
	}

	public BusinessCheckException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessCheckException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessCheckException(String message) {
		super(message);
	}

	public BusinessCheckException(Throwable cause) {
		super(cause);
	}

	
	
	
}
