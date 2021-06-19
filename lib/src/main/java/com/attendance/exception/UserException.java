package com.attendance.exception;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String message;

	public UserException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}

	
	
}
