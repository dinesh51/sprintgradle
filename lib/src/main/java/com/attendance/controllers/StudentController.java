package com.attendance.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.entities.StudentEntity;
import com.attendance.entities.Subject;
import com.attendance.exception.DuplicateRecordException;
import com.attendance.exception.RecordNotFoundException;
import com.attendance.serviceImplementation.StudentService;
import com.attendance.serviceImplementation.SubjectService;

@RestController
public class StudentController {

	@Autowired
	private StudentService stuService;

	@GetMapping("/getStudents")
	public List<StudentEntity> getStudents() {
		return stuService.getAllStudents();
	}

	@PostMapping("/addStudent")
	public ResponseEntity<StudentEntity> addStudent(@Valid @RequestBody StudentEntity entity)
			throws DuplicateRecordException {

		Optional<StudentEntity> stuEntity = stuService.findByRollNo(entity.getRollNo());
		if (stuEntity.isPresent()) {
			throw new DuplicateRecordException("Duplicate Record found in DataBase");
		}
		StudentEntity student = stuService.add(entity);
		return new ResponseEntity<StudentEntity>(student, HttpStatus.OK);
	}

	@PutMapping("/updateStudent")
	public ResponseEntity<StudentEntity> updateStudent(@Valid @RequestBody StudentEntity entity)
			throws RecordNotFoundException {

		Optional<StudentEntity> stuEntity = stuService.findByRollNo(entity.getRollNo());

		if (!stuEntity.isPresent()) {
			throw new RecordNotFoundException("No record found in the DataBase");
		}
		StudentEntity student = stuService.update(entity);
		return new ResponseEntity<StudentEntity>(student, HttpStatus.OK);

	}

	@GetMapping("/deleteStudent/{id}")
	public ResponseEntity<StudentEntity> deleteStudent(@PathVariable("id") int id) throws RecordNotFoundException {
		StudentEntity entity = stuService.findByPk(id).get();

		Optional<StudentEntity> stuEntity = stuService.findByPk(entity.getStudentid());
		if (!stuEntity.isPresent()) {
			throw new RecordNotFoundException("No record found in the DataBase");
		}
		StudentEntity student = stuService.delete(entity);
		return new ResponseEntity<StudentEntity>(student, HttpStatus.OK);

	}

//	@GetMapping("/getbyname/{name}")
//	public ResponseEntity<StudentEntity> getByName(@PathVariable("name") String name) {
//		System.out.println(name);
//		return new ResponseEntity<StudentEntity>(stuService.findByName(name), HttpStatus.OK);
//	}

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<StudentEntity> getStudent(@PathVariable("id") int id) {

		return new ResponseEntity<StudentEntity>(stuService.findByPk(id).get(), HttpStatus.OK);
	}
}
