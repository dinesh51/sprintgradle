package com.attendance.exception;

public class FacultyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String message;

	public FacultyException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}
}
