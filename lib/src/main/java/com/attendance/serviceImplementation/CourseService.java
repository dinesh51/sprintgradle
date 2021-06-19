package com.attendance.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entities.Course;
import com.attendance.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	public CourseRepository courser;
	
public Course saveCourse(Course course) {
		
		return	courser.save(course);
}
	
	
}
