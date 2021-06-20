package com.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.entities.AttendanceEntity;
import com.attendance.entities.StudentEntity;
import com.attendance.serviceImplementation.AttendanceService;
import com.attendance.serviceImplementation.StudentService;

@RestController
public class AttendanceController {
	@Autowired
	private AttendanceService attendService;
	
	  @PostMapping("/addattendance")
			public AttendanceEntity addattendance(@RequestBody AttendanceEntity attendance) {
				
		    return attendService.saveAttendance(attendance);
			}
	  @PutMapping("/updateAttendance")
	  public String updateAttendance(@RequestBody AttendanceEntity entity) {
	  attendService.update(entity);
	  return "Attendance updated successfully";
	  }
	  @GetMapping("/deleteAttendance/{id}")
	  public String deleteAttendance(@PathVariable("id") int id) {
	  	AttendanceEntity entity = attendService.findByPk(id);
	  	attendService.delete(entity);
	  	return "Attendance deleted successfully";
	  }
	  @GetMapping("/getAttendance/{id}")
	  public AttendanceEntity  getattendance(@PathVariable("id") int id) {
	  	
	  	return  attendService.findByPk(id); 
	  }
	
	
}
