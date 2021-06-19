package com.attendance.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entities.AttendanceEntity;
import com.attendance.entities.Course;
import com.attendance.entities.StudentEntity;
import com.attendance.repository.AttendanceRepository;
import com.attendance.repository.StudentRepository;

@Service
public class AttendanceService {

	
	
	@Autowired
	private AttendanceRepository attendancerepo;
	
	@Autowired
	public StudentRepository studentrepo;
	
	
		public AttendanceEntity saveAttendance(AttendanceEntity attendance) {	
		int k=attendance.getStudent().getStudentid();
		Optional<StudentEntity> op= studentrepo.findById(k);
		
		if(op.isEmpty())//throws exception
		 {
			
		}
		else 
			attendance.setStudent(op.get());
		    return	attendancerepo.save(attendance);
		}
	
	
}
