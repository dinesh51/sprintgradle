package com.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.entities.StudentEntity;
import com.attendance.entities.Subject;
import com.attendance.serviceImplementation.StudentService;
import com.attendance.serviceImplementation.SubjectService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	  @PostMapping("/addstudent")
			public StudentEntity addAdmin(@RequestBody StudentEntity student) {
				
				return studentservice.savestudent(student);
			}
	
}
