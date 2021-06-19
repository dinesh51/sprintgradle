package com.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.entities.Course;
import com.attendance.entities.UserEntity;
import com.attendance.serviceImplementation.CourseService;

@RestController
public class Coursecontroller {

	
	@Autowired
	private CourseService couseserv;
	
	  @PostMapping("/addcourse")
			public Course addAdmin(@RequestBody Course course) {
				
				return couseserv.saveCourse(course);
			}
}
