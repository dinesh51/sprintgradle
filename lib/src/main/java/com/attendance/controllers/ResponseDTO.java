package com.attendance.controllers;


import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

	private String message;
	private String status;
	private Object result;

	
	public ResponseDTO(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}

	

	

}
