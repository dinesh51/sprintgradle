package com.attendance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.attendance.entities.Subject;
import com.attendance.serviceImplementation.SubjectService;

@RestController
public class SubjectController {

	
	
	@Autowired
	private SubjectService subjectservice;
	
	  @PostMapping("/addsubject")
			public Subject addAdmin(@RequestBody Subject subject) {
				
				return subjectservice.saveSubject(subject);
			}
	  

	//  @PostMapping("/subjectlist/{coursename}")
//			public List<Subject> get(@RequestBody Subject subject) {
//				
//				//return subjectservice.saveSubject(subject);
		//	}
	  
	  
	  
}
