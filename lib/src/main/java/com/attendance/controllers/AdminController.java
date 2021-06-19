package com.attendance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.entities.Faculty;
import com.attendance.entities.UserEntity;
import com.attendance.serviceImplementation.FacultyService;
import com.attendance.serviceImplementation.UserEntityService;

@RestController
public class AdminController {
	@Autowired
	private UserEntityService userService;
	
	@Autowired
	private FacultyService facultyService;
	
	  @PostMapping("/addAdmin")
		public UserEntity addAdmin(@RequestBody UserEntity user) {
			
			return userService.saveAdmin(user);
		}
	
	  
	   @GetMapping("/adminList")
	    public List<UserEntity> adminList() {
	        return userService.getAdminList();
	    }
	  
	  
	    @PutMapping("/updateAdmin")
	    public UserEntity updateAdmin(@RequestBody UserEntity user) {
	        return userService.updateAdmin(user);
	    }
	   
	    

	    @DeleteMapping("/deleteAdmin/{id}")
	    public String deleteAdmin(@PathVariable int id) {
	        return userService.deleteAdmin(id);
	    }
	
	   
	   
	  
	  @PostMapping("/addFaculty")
		public Faculty addFaculty(@RequestBody Faculty faculty) {
			
			return facultyService.saveFaculty(faculty);
		}
	
	  
	    @GetMapping("/Faculty")
	    public List<UserEntity> getFacultyList() {
	        return facultyService.getFaculty();
	    }

	
	    
	    @GetMapping("/updateFaculty")
	    public Faculty updateFaculty(@RequestBody Faculty faculty) {
	    	return facultyService.updateFaculty(faculty);
	    }

	    @DeleteMapping("/deleteFaculty/{id}")
	    public String deleteFaculty(@PathVariable int id) {
	        return facultyService.deleteFaculty(id);
	    }
	    

	    @PutMapping("/changePassword/{email}/{oldPasssword}/{newPassword}")
	    public String changePassword(@PathVariable String email,String oldPassword,String newPassword) {
	        return userService.ChangePassword(email,oldPassword,newPassword);
	    }
	    
	    @GetMapping("/viewAdminById{id}")
	    public UserEntity getUser(@PathVariable int id ) {
	        return userService.getUser(id);
	    }
	    
	  
}
