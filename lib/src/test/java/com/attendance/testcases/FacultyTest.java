package com.attendance.testcases;

 


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

 

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

 

import com.attendance.controllers.FacultyController;
import com.attendance.demo.AttendanceApplication;
import com.attendance.entities.Faculty;
import com.attendance.repository.FacultyRepository;
import com.attendance.serviceImplementation.FacultyService;

 

 

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes=AttendanceApplication.class)
public class FacultyTest {

 

    @Autowired
    MockMvc mockMvc;

 

    @InjectMocks
    //private CourseController courseController;
    private FacultyController facultyController;

 


    @Mock
    //private CourseService courseService;
    private FacultyService facultyService;
    
    
    @Mock
//    private CourseRepository courseRepo;
    private FacultyRepository facultyRepo;

 

    @Test
    public void testAddFaculty() {
          Faculty fa=new Faculty();
            fa.setId(0);
            fa.setEmail("thakurdineshprasad@gmail.com");
            fa.setName("dinesh");
            fa.setMobileNo("9949178159");
            fa.setRoleId(2);
            fa.setPassword("p@abcd");
            fa.setSubject("java");
        Mockito.when(facultyService.saveFaculty(fa)).thenReturn(fa);
        assertEquals(fa.getName(), "dinesh");
        ResponseEntity<Faculty> rr = facultyController.addFaculty(fa);
        assertEquals(rr.getStatusCode(), HttpStatus.OK);
    }

 

    @Test
    public void testAddFacultyNegativeTest() {
          Faculty fa=new Faculty();
            fa.setId(0);
            fa.setEmail("thakurdineshprasad@gmail.com");
            fa.setName("dinesh");
            fa.setMobileNo("9949178159");
            fa.setRoleId(2);
            fa.setPassword("p@abcd");
            fa.setSubject("java");
            Mockito.when(facultyService.saveFaculty(fa)).thenReturn(fa);
        assertNotEquals(fa.getName(), "dinesh1");
//        Faculty faculty1 = new Faculty();
//        ResponseEntity<Faculty> rr = facultyController.addFaculty(faculty1);
//        assertEquals(rr.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

 

    @Test(expected = AssertionError.class)
    public void AddFacultyNullTest() {
          Faculty fa=new Faculty();
        Mockito.when(facultyService.saveFaculty(fa)).thenReturn(null);
        assertEquals(fa, null);
    }

 

    @Test
    public void testupdateFaculty() {
          Faculty fa=new Faculty();
          fa.setId(0);
            fa.setEmail("thakurdineshprasad@gmail.com");
            fa.setName("dinesh");
            fa.setMobileNo("9949178159");
            fa.setRoleId(2);
            fa.setPassword("p@abcd");
            fa.setSubject("java");
        Mockito.when(facultyService.updateFaculty(fa)).thenReturn(fa);
        assertEquals(fa.getName(), "dinesh");
    }

 

    @Test
    public void updateFacultyNegativeTest() {
          Faculty fa=new Faculty();
          fa.setId(0);
            fa.setEmail("thakurdineshprasad@gmail.com");
            fa.setName("dinesh");
            fa.setMobileNo("9949178159");
            fa.setRoleId(2);
            fa.setPassword("p@abcd");
            fa.setSubject("java");
            Mockito.when(facultyService.updateFaculty(fa)).thenReturn(fa);
        assertNotEquals(fa.getName(), "Java1");
    }

 

    @Test(expected = AssertionFailedError.class)
    public void updateFacultyNullTest() {
         Faculty fa=new Faculty();
        Mockito.when(facultyService.updateFaculty(fa)).thenReturn(null);
        assertEquals(fa, null);
    }

 

    @Test(expected = AssertionError.class)
    public void deleteFacultyTest() {
         Faculty faculty=new Faculty();
          faculty.setId(0);
          faculty.setEmail("thakurdineshprasad@gmail.com");
          faculty.setName("dinesh");
          faculty.setMobileNo("9949178159");
          faculty.setRoleId(2);
          faculty.setPassword("p@abcd");
          faculty.setSubject("java");
        
        Mockito.when(facultyService.deleteFaculty(1)).thenReturn(faculty);
        assertEquals(faculty, null);
        ResponseEntity<Faculty> rr = facultyController.deleteFaculty(1);
        assertEquals(rr.getStatusCode(), HttpStatus.OK);

 

    }

 

    @Test
    public void deleteFacultyTestNegative() {
        Faculty faculty=new Faculty();
          faculty.setId(0);
          faculty.setEmail("thakurdineshprasad@gmail.com");
          faculty.setName("dinesh");
          faculty.setMobileNo("9949178159");
          faculty.setRoleId(2);
          faculty.setPassword("p@abcd");
          faculty.setSubject("java");
          Mockito.when(facultyService.deleteFaculty(1)).thenReturn(faculty);
        assertNotEquals(faculty, null);
    }

 


    @Test
    public void getFacultybyIdTest() {
        Faculty faculty=new Faculty();
          faculty.setId(0);
          faculty.setEmail("thakurdineshprasad@gmail.com");
          faculty.setName("dinesh");
          faculty.setMobileNo("9949178159");
          faculty.setRoleId(2);
          faculty.setPassword("p@abcd");
          faculty.setSubject("java");
        Mockito.when(facultyService.getFaculty(1)).thenReturn(faculty);
        assertEquals(faculty.getName(), "dinesh");
        ResponseEntity<Faculty> rr = facultyController.getFaculty(1);
        assertEquals(rr.getStatusCode(), HttpStatus.OK);
    }
    
    
//    @Test
//    public void testGetAllAppointments() {
//        Faculty appointment = getfaculty();
//        when(facultyRepo.findAll())
//                .thenReturn(Stream.of(getfaculty()).collect(Collectors.toList()));
//        assertEquals(1, facultyService.getFaculties().size());
//    }

 

    
    public Faculty getfaculty() {
        Faculty faculty=new Faculty();
          faculty.setId(0);
          faculty.setEmail("thakurdineshprasad@gmail.com");
          faculty.setName("dinesh");
          faculty.setMobileNo("9949178159");
          faculty.setRoleId(2);
          faculty.setPassword("p@abcd");
          faculty.setSubject("java");
          return faculty;
        
    }
    
    
/*    @Test
    public void findByPkNegtiveTest() {
        Course course = new Course();
        course.setId(1L);
        course.setName("Java");
        course.setDescription("It is a programming language");
        Mockito.when(courseService.findById(0L)).thenReturn(course);
        assertEquals(course.getName(), "Java");
        ResponseEntity<ResponseDTO> rr = courseController.findBypK(0L);
        assertEquals(rr.getStatusCode(), HttpStatus.OK);
    }
*/
}