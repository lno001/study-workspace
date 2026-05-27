package com.lim.spring.exception;

public class InvalidPageException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidPageException(String msg) {
		super(msg);
	}
}
