package com.attendance.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.attendance.entities.AssignFaculty;
import com.attendance.entities.Course;
import com.attendance.entities.Faculty;
import com.attendance.entities.Subject;
import com.attendance.repository.AssignFacultyRepository;
import com.attendance.repository.CourseRepository;
import com.attendance.repository.FacultyRepository;
import com.attendance.repository.SubjectRepository;
@Service
	public class AssignFacultyService  {
	
	@Autowired
	private AssignFacultyRepository assignrepo;
	
	
	@Autowired
	public SubjectRepository SubjectRepo;
	
	@Autowired
	public FacultyRepository repof;
	
	 
	 public   AssignFaculty createassignfaculty(AssignFaculty assfaculty) {
	     
		 int k=assfaculty.getSubject().getSubjectid();
		 int f=assfaculty.getFaculty().getId();
	
		 Optional<Subject> op=	SubjectRepo.findById(k);
		 Optional<Faculty> op1= repof.findById(f);
		 
			if(op.isEmpty()&&op1.isEmpty())//throws exception
			 {
				
			}
			else 
				assfaculty.setFaculty(op1.get());  
			assfaculty.setSubject(op.get());
			
				return	assignrepo.save(assfaculty);
		 
		 /*	long k= subject.getCourse().getCourseid();
	int i=(int) k;
	Optional<Course> op= courser.findById(i);
	
	if(op.isEmpty())//throws exception
	 {
		
	}
	else 
	    subject.setCourse(op.get());  
		return	SubjectRepo.save(subject);
     */
		 
		 
	
     
	   }
	 
	 
	 
}

