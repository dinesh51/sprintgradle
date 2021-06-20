package com.attendance.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
//	@Autowired
//	private AssignFacultyRepository assignrepo;
//	
//	
    @Autowired
	public SubjectRepository SubjectRepo;
	
	@Autowired
	public FacultyRepository repof;

	@PostMapping("/addassignfaculty")
	public AssignFaculty assignfaculty(@RequestBody AssignFaculty assfaculty) {
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

		return assignserv.createassignfaculty(assfaculty);
	}

	@PutMapping("/updateAssignFaculty")
	public String update(@RequestBody AssignFaculty entity) {
		assignserv.update(entity);
		return "AssignFaculty update";
	}

	@GetMapping("/deleteAssignFaculty")
	public String delete(@RequestBody AssignFaculty entity) {
		assignserv.delete(entity);
		return "AssignFaculty deleted";
	}

	@GetMapping("/search")
	public List<AssignFaculty> Findall() {
		return assignserv.findall();
	}

}
