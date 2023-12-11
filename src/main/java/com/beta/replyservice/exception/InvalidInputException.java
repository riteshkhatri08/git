package com.beta.replyservice.exception;

public class InvalidInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 26664342459602640L;

	private String message;

	public InvalidInputException(String message) {
		super(message);
		this.message = message;
	}

	public InvalidInputException() {
	}
}
