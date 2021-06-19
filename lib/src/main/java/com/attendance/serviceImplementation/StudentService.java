package com.attendance.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entities.StudentEntity;
import com.attendance.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	public StudentRepository studentrepo;


	public StudentEntity savestudent(StudentEntity student) {
	
	return	studentrepo.save(student);
	}

	
}
