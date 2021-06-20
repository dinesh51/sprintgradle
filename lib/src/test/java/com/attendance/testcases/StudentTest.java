//package com.attendance.testcases;
//
//
//import org.junit.jupiter.api.Test;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import com.attendance.entities.StudentEntity;
//import com.attendance.repository.StudentRepository;
//import com.attendance.serviceImplementation.StudentService;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class StudentTest {
//	@InjectMocks
//	private StudentService studentService;
//	@Mock
//	private StudentRepository studentRepo;
//	
////	@Test
//	@ContextConfiguration(classes = ElastSearchBootApplication.class)
//	public void testAddStudent() throws DuplicateRecordException, ParseException {
//		StudentEntity student = getStudent();
//		when(studentRepo.save(student)).thenReturn(student);
//		assertEquals(studentService.savestudent(student), student);
//		//assertEquals(true, true);
//	}
////	@Test
////	public void testUpdateStudent() throws RecordNotFoundException, ParseException {
////		StudentEntity student = getStudent();
////		when(studentRepo.save(student)).thenReturn(student);
////		assertEquals(studentService.update(student), student);
////		//assertEquals(true, true);
////	}
////	@Test
////	public void testRemoveAdmin() throws ParseException, RecordNotFoundException {
////		StudentEntity student = getStudent();
////		studentService.delete(student);
////		verify(studentRepo, times(1)).existsById(student.getId());
////	}
//	private StudentEntity getStudent() throws ParseException {
//		StudentEntity student = new StudentEntity();
//		student.setStudentid(1);
//		student.setRollNo(34);
//		student.setName("natasha");
//	
//		student.setGender("male");
//		student.setMobileNo("4785757545");
//		student.setCourseId(234);
//		student.setSubjectId(74);
//		student.setSemester("A4");
//		student.setEmailId("rohan@gmail.com");
//		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
//		return student;
//	}
//}
//
//

