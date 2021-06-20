package com.attendance.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.attendance.demo.AttendanceApplication;
import com.attendance.entities.StudentEntity;
import com.attendance.exception.DuplicateRecordException;
import com.attendance.exception.RecordNotFoundException;
import com.attendance.repository.StudentRepository;
import com.attendance.serviceImplementation.StudentService;

@SpringBootTest(classes=AttendanceApplication.class)
public class StudentTest {
	@Autowired
	private StudentService studentService;
	@MockBean
	private StudentRepository studentRepo;

	@Test
	public void testAddStudent() throws DuplicateRecordException, ParseException {
		StudentEntity student = getStudent();
		when(studentRepo.save(student)).thenReturn(student);
		assertEquals(studentService.add(student), student);
		// assertEquals(true, true);
	}

	@Test
	public void testUpdateStudent() throws RecordNotFoundException, ParseException {
		StudentEntity student = getStudent();
		when(studentRepo.save(student)).thenReturn(student);
		assertEquals(studentService.update(student), student);
		// assertEquals(true, true);
	}

	@Test
	public void testRemoveStudent() throws ParseException, RecordNotFoundException {
		StudentEntity student = getStudent();
		studentService.delete(student);
		verify(studentRepo, times(1)).existsById(student.getStudentid());
	}

	@Test
	public void testGetStudent() throws ParseException {
		StudentEntity student = getStudent();
		studentService.findByPk(student.getStudentid());
		verify(studentRepo, times(1)).findById(student.getStudentid()); // Verify that the correct methods of our
																		// mock objects were invoked
	}
	// @Test
//	public void testGetStudentByName(){
//		StudentEntity student = getStudent();
//		//studentService.findByName(student.getFirstName());
//		//verify(studentRepo, times(1)).findByFirstName(student.getFirstName()); // Verify that the correct methods of our
//		Mockito.when(studentService.findByName(student.getFirstName())).thenReturn(student);
//		assertEquals(studentRepo.findByFirstName(student.getFirstName(),student);// mock objects were invoked
//	}

	@Test
	public void testGetRoll() throws ParseException {
		StudentEntity student = getStudent();
		studentService.findByRollNo(student.getRollNo());
		verify(studentRepo, times(1)).findByRollNo(student.getRollNo()); // Verify that the correct methods of our
																			// mock objects were invoked
	}

	private StudentEntity getStudent() throws ParseException {
		StudentEntity student = new StudentEntity();
		student.setStudentid(1);
		student.setRollNo(34);
		student.setName("natasha");
		student.setGender("male");
		student.setMobileNo("4785757545");
		student.setCourseId(234);
		student.setSubjectId(74);
		student.setSemester("A4");
		student.setEmailId("rohan@gmail.com");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		student.setSubjectId(10);
		student.setCourseId(20);

		return student;
	}
}
