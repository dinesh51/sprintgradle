package com.attendance.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.attendance.entities.Faculty;
import com.attendance.entities.UserEntity;
import com.attendance.repository.FacultyRepository;

@Service
public class FacultyService {

	
	
	@Autowired
	public FacultyRepository facultyRepository;
	
	public Faculty saveFaculty(Faculty faculty) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
		String encodedPassword = bCryptPasswordEncoder.encode(faculty.getPassword());
		faculty.setPassword(encodedPassword);
		faculty.setConfirmPassword(encodedPassword);
		return	facultyRepository.save(faculty);
		
}
	
	
	
	public  List<UserEntity> getFaculty(){
		
		return	facultyRepository.findAllFaculties();
			
	}
	   public  Faculty updateFaculty(Faculty faculty){
	    	
	    	Faculty existing=facultyRepository.findById((int) faculty.getId()).orElse(null);
	    	existing.setName(faculty.getName());
	    	existing.setMobileNo(faculty.getMobileNo());
	    	existing.setRoleId(faculty.getRoleId());
	    	
	    	existing.setGender(faculty.getGender());
	    	existing.setPassword(faculty.getPassword());
	    	existing.setConfirmPassword(faculty.getConfirmPassword());

	    	existing.setSubject(faculty.getSubject());
	    	return facultyRepository.save(existing);	
	    }
	   
	   public  String deleteFaculty(int id){
			
		   facultyRepository.deleteById(id);	
			return "faculty removed successsfully";
	}



	
	   
}
