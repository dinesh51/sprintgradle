package com.attendance.exception;

public class LoginException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	String message;

	public LoginException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}
}
