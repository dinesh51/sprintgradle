package com.attendance.exception;

public class LoginException extends RuntimeException {
	
	String message;

	public LoginException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;

	}

}
