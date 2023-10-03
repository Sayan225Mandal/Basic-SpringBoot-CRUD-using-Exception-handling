package com.authorservice.exception;

public class AuthorNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthorNotFoundException(String message) {
		super(message);
	}

}
