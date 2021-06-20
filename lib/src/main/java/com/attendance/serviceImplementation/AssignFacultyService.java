package com.attendance.serviceImplementation;

import java.util.List;
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
	
	   }
	 public void delete(AssignFaculty entity) {
		 assignrepo.delete(entity);
	}
	 public List<AssignFaculty> findall() {
			return assignrepo.findAll();
		}
	 public boolean update(AssignFaculty entity) {
			AssignFaculty entity1 = assignrepo.findById(entity.getId()).orElse(null);
			//entity1.setCourseName(entity.getCourseName());
			//entity1.setSemester(entity.getSemester());
			entity1.setSubject(entity.getSubject());
			//entity1.setSubjectName(entity.getSubjectName());
			//entity1.setUserId(entity.getUserId());
			entity1.setFaculty(entity.getFaculty());
			entity1.setTotalclasses(entity.getTotalclasses());
			assignrepo.save(entity1);
			return true;
		}
	 
	 
}

