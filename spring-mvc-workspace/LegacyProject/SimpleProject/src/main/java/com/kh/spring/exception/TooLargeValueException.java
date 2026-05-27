package com.kh.spring.exception;

public class TooLargeValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TooLargeValueException(String message) {
		super(message);
	}
	
}
