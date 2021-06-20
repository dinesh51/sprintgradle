package com.attendance.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import com.attendance.entities.Subject;
import com.attendance.exception.SubjectException;
import com.attendance.repository.CourseRepository;
import com.attendance.serviceImplementation.SubjectService;

@RestController
public class SubjectController {

	@Autowired
	private SubjectService subjectservice;
	
	@Autowired
	public CourseRepository courserepositor;

	Logger logger = LoggerFactory.getLogger(SubjectController.class);

	// Method to add Subject
	@PostMapping("/addSubject")
	public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
		long k = subject.getCourse().getId();
     	int i = (int) k;
    	Optional<Course> op = courserepositor.findById(i);

		if (op.isEmpty() && subject.getCourse().equals(null))
		{
			throw new SubjectException("Course not find ");
		} else { 
			subject.setCourse(op.get());
	    }
		Subject subjectData = subjectservice.addSubject(subject);
		if (subjectData == null) {
			logger.error("Controller: Failed to add subject");
			throw new SubjectException("Subject not add");
		}
		
		logger.info("*** Controller : Subject added successfully. ***");
		return new ResponseEntity<Subject>(subjectData, HttpStatus.OK);
	}

	// Method to UpdateSubjectByid
	@PutMapping("/updateSubject/{id}")
	public ResponseEntity<Subject> updateSubject(@Valid @RequestBody Subject subject, @PathVariable int id) {
		Subject subjectData = subjectservice.updateSubject(id, subject);

		if (subjectData == null) {
			logger.error("Controller: Failed to update subject");
			throw new SubjectException("Subject not updated");

		}

		logger.info("*** Controller : Subject updated successfully. ***");
		return new ResponseEntity<Subject>(subjectData, HttpStatus.OK);
	}

	// Method to delete Subject by id
	@DeleteMapping("/deleteSubject/{id}")
	public ResponseEntity<Subject> deleteSubject(@PathVariable int id) {

		Subject subjectData = subjectservice.removeSubject(id);

		if (subjectData == null) {
			logger.error("Controller: Subject Not Found For given id : " + id);
			throw new SubjectException("No Subject present with the given id " + id);
		}

		logger.info("*** Controller : Subject removed. ***");
		return new ResponseEntity<Subject>(subjectData, HttpStatus.OK);
	}

	// Method to get all Subject
	@GetMapping("/getSubjectList")
	public ResponseEntity<List<Subject>> selectAllSubjects() {
		List<Subject> subjectsList = subjectservice.getSubjectList();

		if (subjectsList.size() == 0) {
			logger.error("Controller: Subject not found.");
			throw new SubjectException("No Subject in the database ");
		}

		logger.info("*** Controller : Displaying Subject list. ***");
		return new ResponseEntity<List<Subject>>(subjectsList, HttpStatus.OK);
	}

	// Method to get Subject by id
	@GetMapping("/getSubject/{id}")
	public ResponseEntity<Subject> getSubject(@PathVariable int id) {

		Subject subjectData = subjectservice.getSubject(id);

		if (subjectData == null) {
			logger.error("Controller: Subject Not Found For given id : " + id);
			throw new SubjectException("No Subject present with the given id " + id);
		}

		logger.info("*** Controller : Displaying Subject ***");
		return new ResponseEntity<Subject>(subjectData, HttpStatus.OK);
	}
//	@GetMapping("/getSubject/{id}")
//	public ResponseEntity<List<Subject>> findByCourseId(@PathVariable int id){
//		List<Subject> subjectsList = subjectservice.getSubjects(id);
//		return new ResponseEntity<List<Subject>>(subjectsList, HttpStatus.OK);
//	}
}
