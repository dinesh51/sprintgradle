package com.attendance.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.entities.Course;
import com.attendance.entities.UserEntity;
import com.attendance.exception.NotCreatedException;
import com.attendance.repository.CourseRepository;
import com.attendance.serviceImplementation.CourseService;


@RestController
public class Coursecontroller {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepo;
	
	Logger log = LoggerFactory.getLogger(SubjectController.class);


	@PostMapping("/addCourse")
	public ResponseEntity<ResponseDTO> addCourse(@RequestBody Course course) {
		try {
			Course savedCourse = courseService.addCourse(course);
			if (savedCourse != null) {
				log.info("course saved successfully");

				return new ResponseEntity<>(new ResponseDTO("course added Success", "true"), HttpStatus.OK);
			} else {
				log.info("Course not saved");
				return new ResponseEntity<>(new ResponseDTO("course not added Successfully", "false"),
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error while adding course", e);
			throw new NotCreatedException("Not created");
		}

	}

	@PutMapping("/updateCourse/{id}")
	public ResponseEntity<ResponseDTO> updateCourse(@RequestBody Course course, @PathVariable("id") int id) {
		try {
			 Course course1 = courseRepo.findById(id).get();
			 Course updatedCourse = null;
			if(course1.getId() == id) {				
				updatedCourse = courseService.updateCourse(course, id);
			}else {
				return new ResponseEntity<>(new ResponseDTO("course with given id is not present", "false"), HttpStatus.OK);
			}
			if (updatedCourse != null) {
				log.info("course updated successfully");

				return new ResponseEntity<>(new ResponseDTO("course updated Success", "true"), HttpStatus.OK);
			} else {
				log.info("Course not saved");
				return new ResponseEntity<>(new ResponseDTO("course not updated Successfully", "false"),
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error while upating course", e);
			throw new NotCreatedException("Not updated");
		}
	}

	@DeleteMapping("/deleteCourse/{id}")
	public ResponseEntity<ResponseDTO> deleteCourse(@PathVariable("id") int id) {
		try {
			 Course course1 = courseRepo.findById(id).get();
			 String deletedCourse = null;
			if(course1.getId() == id) {	
				deletedCourse = courseService.deleteCourse(id);
			}else {
				return new ResponseEntity<>(new ResponseDTO("course with given id is not present", "false"), HttpStatus.OK);
			}			
			if (deletedCourse != null) {
				log.info("course deleted successfully");

				return new ResponseEntity<>(new ResponseDTO("course deleted Success", "true"), HttpStatus.OK);
			} else {
				log.info("Course not saved");
				return new ResponseEntity<>(new ResponseDTO("course not deleted Successfully", "false"),
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error while deleting course", e);
			throw new NotCreatedException("Not deleted");
		}
		
	}

	@GetMapping("/getByName/{id}")
	public ResponseEntity<ResponseDTO> findByName(@PathVariable("name") String name) {
		try {
			 Course course1 = courseRepo.findByName(name);
			 Course getCourse = null;
			if(course1.getName().equals(name)) {	
				getCourse = courseService.findByName(name);
			}else {
				return new ResponseEntity<>(new ResponseDTO("course with given id is not present", "false"), HttpStatus.OK);
			}
			
			if (getCourse != null) {
				log.info("course successfully received");

				return new ResponseEntity<>(new ResponseDTO("course received Success", "true"), HttpStatus.OK);
			} else {
				log.info("Course not saved");
				return new ResponseEntity<>(new ResponseDTO("course not received Successfully", "false"),
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error while receiving course", e);
			throw new NotCreatedException("Not received");
		}
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<ResponseDTO> findBypK(@PathVariable("id") int id) {
		try {
			Course Course = courseService.findById(id);
			if (Course != null) {
				log.info("course successfully received");

				return new ResponseEntity<>(new ResponseDTO("course received Success", "true"), HttpStatus.OK);
			} else {
				log.info("Course not saved");
				return new ResponseEntity<>(new ResponseDTO("course not received Successfully", "false"),
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error while receiving course", e);
			throw new NotCreatedException("Not received");
		}

	}
	
//	@GetMapping("/search")
//	public ResponseEntity<ResponseDTO> findByAll() {
//		try {			
//			List<Course> Course = courseService.findAll();
//			if (Course != null) {
//				log.info("course successfully received");
//
//				return new ResponseEntity<>(new ResponseDTO("course received Success", "true"), HttpStatus.OK);
//			} else {
//				log.info("Course not saved");
//				return new ResponseEntity<>(new ResponseDTO("course not received Successfully", "false"),
//						HttpStatus.BAD_REQUEST);
//			}
//		} catch (Exception e) {
//			log.error("Error while receiving course", e);
//			throw new NotCreatedException("Not received");
//		}
//
//	}
	
}
