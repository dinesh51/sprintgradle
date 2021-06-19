//package com.attendance.testcases;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.attendance.entities.Faculty;
//import com.attendance.repository.UserEntityRepository;
//import com.attendance.serviceImplementation.FacultyService;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
////import static org.mockito.Mockito.when;
////
////import static org.junit.jupiter.api.Assertions.assertEquals;
////import static org.mockito.Mockito.times;
////import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
////
////import org.junit.jupiter.api.Test;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.boot.test.mock.mockito.MockBean;
////
////import com.attendance.demo.AttendanceTestApplication;
////import com.attendance.entities.Faculty;
////import com.attendance.repository.UserEntityRepository;
////import com.attendance.serviceImplementation.FacultyService;
//
//
//@SpringBootTest 
//public class FacultyTest {
//
//	
//	@Autowired
//	private FacultyService facultyService;
//	
//	@MockBean
//	UserEntityRepository facultyRepository;
//	
//	@Test
//	public void testAddFaculty() {
//	
//		Faculty faculty = getFaculty();
//		
//		when(facultyRepository.save(faculty)).thenReturn(faculty);
//		assertEquals(facultyService.saveFaculty(faculty), faculty);
//
//	}
//	
//	private Faculty getFaculty() {
//		Faculty fa=new Faculty();
//		fa.setId(0);
//		fa.setConfirmPassword("p@abcd");
//		fa.setEmail("thakurdineshprasad@gmail.com");
//		fa.setName("dinesh");
//		fa.setMobileNo("9949178159");
//		fa.setRoleId(2);
//		fa.setPassword("p@abcd");
//		fa.setSubject("java");
//		
//		return fa;
//	}
//	
//
//	
//}
