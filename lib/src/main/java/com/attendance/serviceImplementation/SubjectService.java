package com.attendance.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entities.Course;
import com.attendance.entities.Subject;
import com.attendance.repository.CourseRepository;
import com.attendance.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	public SubjectRepository SubjectRepo;
	
	@Autowired
	public CourseRepository courser;
	
public Subject saveSubject(Subject subject) {
	
	long k= subject.getCourse().getCourseid();
	int i=(int) k;
	Optional<Course> op= courser.findById(i);
	
	if(op.isEmpty())//throws exception
	 {
		
	}
	else 
	    subject.setCourse(op.get());  
		return	SubjectRepo.save(subject);
     
	
		/*
		 * 
		 * 
		 * */
		
		

}

}
