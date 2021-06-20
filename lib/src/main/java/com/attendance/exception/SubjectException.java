package com.attendance.exception;

public class SubjectException extends RuntimeException{

	
	String message;

	public SubjectException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;

	}
}
