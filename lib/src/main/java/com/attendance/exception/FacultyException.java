package com.attendance.exception;

public class FacultyException extends RuntimeException{
	
	String message;

	public FacultyException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;

	}
}
