package com.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.entities.AssignFaculty;
import com.attendance.entities.Faculty;
import com.attendance.entities.Subject;
import com.attendance.repository.AssignFacultyRepository;
import com.attendance.repository.FacultyRepository;
import com.attendance.repository.SubjectRepository;
import com.attendance.serviceImplementation.AssignFacultyService;




@RestController
public class AssignFacultyController {

	@Autowired
	private AssignFacultyService assignserv;
	

	
	  @PostMapping("/addassignfaculty")
			public AssignFaculty assignfaculty(@RequestBody AssignFaculty assfac) {
				
				return assignserv.createassignfaculty(assfac);
			}
	  

	  
	  		
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
//	   @PutMapping("/{id}/assignfaculty/{subjectid}")
//	   AssignFaculty addfacultyToSubject(
//	            @PathVariable Integer id,
//	            @PathVariable Integer subjectid
//	    ) {
//		   AssignFaculty faculty = assignrepo.findById(get)
//		   Subject subj = SubjectRepo.findById(subjectid).get();
//		   faculty.enrolledsubject.add(subj);
//	        return SubjectRepo.save(assignfaculty);
//	    }
//	  
	  /*  @PutMapping("/{subjectId}/students/{studentId}")
   Subject addStudentToSubject(
           @PathVariable Long subjectId,
           @PathVariable Long studentId
   ) {
       Subject subject = subjectRepository.findById(subjectId).get();
       Student student = studentRepository.findById(studentId).get();
       subject.enrolledStudents.add(student);
       return subjectRepository.save(subject);
   }*/
	  
	  
}
