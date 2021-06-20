package com.attendance.testcases;

public class DuplicateRecordException extends Exception {
	private static final long serialVersionUID = 1L;
	String message;

	public DuplicateRecordException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}
}
