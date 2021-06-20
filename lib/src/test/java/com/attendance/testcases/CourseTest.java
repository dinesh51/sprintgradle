//package com.attendance.testcases;
//
//
//
//
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
// 
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.opentest4j.AssertionFailedError;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
// 
//
//import com.attendance.controller.CourseController;
//import com.attendance.entity.Course;
//import com.attendance.repository.CourseRepository;
//import com.attendance.service.CourseService;
//import com.attendance.util.ResponseDTO;
//
// 
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CourseTest {
//
// 
//
//    @Autowired
//    MockMvc mockMvc;
//
// 
//
//    @InjectMocks
//    private CourseController courseController;
//
// 
//
//    @Mock
//    private CourseService courseService;
//
// 
//
//    @Mock
//    private CourseRepository courseRepo;
//
// 
//
//    @Test
//    public void addCourseTest() {
//        Course course = new Course();
//        course.setId(1L);
//        course.setName("Java");
//        course.setDescription("It is a programming language");
//        Mockito.when(courseService.addCourse(course)).thenReturn(course);
//        assertEquals(course.getName(), "Java");
//        ResponseEntity<ResponseDTO> rr = courseController.addCourse(course);
//        assertEquals(rr.getStatusCode(), HttpStatus.OK);
//    }
//
// 
//
//    @Test
//    public void addCourseNegativeTest() {
//        Course course = new Course();
//        course.setId(1L);
//        course.setName("Java");
//        course.setDescription("It is a programming language");
//        Mockito.when(courseService.addCourse(course)).thenReturn(course);
//        assertNotEquals(course.getName(), "Java1");
//        Course course1 = new Course();
//        ResponseEntity<ResponseDTO> rr = courseController.addCourse(course1);
//        assertEquals(rr.getStatusCode(), HttpStatus.BAD_REQUEST);
//    }
//
// 
//
//    @Test(expected = AssertionError.class)
//    public void addCourseNullTest() {
//        Course course = new Course();
//        Mockito.when(courseService.addCourse(course)).thenReturn(null);
//        assertEquals(course, null);
//    }
//
// 
//
//    @Test
//    public void updateCourseTest() {
//        Course course = new Course();
//        course.setId(1L);
//        course.setName("Java");
//        course.setDescription("It is a programming language");
//        Mockito.when(courseService.updateCourse(course, 1L)).thenReturn(course);
//        assertEquals(course.getName(), "Java");
//    }
//
// 
//
//    @Test
//    public void updateCourseNegativeTest() {
//        Course course = new Course();
//        course.setId(1L);
//        course.setName("Java");
//        course.setDescription("It is a programming language");
//        Mockito.when(courseService.updateCourse(course, 1L)).thenReturn(course);
//        assertNotEquals(course.getName(), "Java1");
//    }
//
// 
//
//    @Test(expected = AssertionFailedError.class)
//    public void updateCourseNullTest() {
//        Course course = new Course();
//        Mockito.when(courseService.updateCourse(course, 0L)).thenReturn(null);
//        assertEquals(course, null);
//    }
//
// 
//
//    @Test(expected = AssertionError.class)
//    public void deleteCourse() {
//        Course course = new Course();
//        course.setId(1L);
//        course.setName("Java");
//        course.setDescription("It is a programming language");
//        Mockito.when(courseService.deleteCourse(1L)).thenReturn("Deleted");
//        assertEquals(course, null);
//        ResponseEntity<ResponseDTO> rr = courseController.deleteCourse(1L);
//        assertEquals(rr.getStatusCode(), HttpStatus.OK);
//
// 
//
//    }
//
// 
//
//    @Test
//    public void deleteCourseNegative() {
//        Course course = new Course();
//        course.setId(1L);
//        course.setName("Java");
//        course.setDescription("It is a programming language");
//        Mockito.when(courseService.deleteCourse(0L)).thenReturn("Deleted");
//        assertNotEquals(course, null);
//    }
//
// 
//
//    @Test
//    public void findByNameTest() {
//        Course course = new Course();
//        course.setId(1L);
//        course.setName("Java");
//        course.setDescription("It is a programming language");
//        Mockito.when(courseService.findByName("Java")).thenReturn(course);
//        assertEquals(course.getName(), "Java");
//    }
//
// 
//
//    @Test
//    public void findByNameNegativeTest() {
//        Course course = new Course();
//        course.setId(1L);
//        course.setName("Java");
//        course.setDescription("It is a programming language");
//        Mockito.when(courseService.findByName("Java")).thenReturn(course);
//        assertNotEquals(course.getName(), "Java1");
//    }
//
// 
//
//    @Test
//    public void findByPkTest() {
//        Course course = new Course();
//        course.setId(1L);
//        course.setName("Java");
//        course.setDescription("It is a programming language");
//        Mockito.when(courseService.findById(1L)).thenReturn(course);
//        assertEquals(course.getName(), "Java");
//        ResponseEntity<ResponseDTO> rr = courseController.findBypK(1L);
//        assertEquals(rr.getStatusCode(), HttpStatus.OK);
//    }
//
// 
//
//    @Test
//    public void findByPkNegtiveTest() {
//        Course course = new Course();
//        course.setId(1L);
//        course.setName("Java");
//        course.setDescription("It is a programming language");
//        Mockito.when(courseService.findById(0L)).thenReturn(course);
//        assertEquals(course.getName(), "Java");
//        ResponseEntity<ResponseDTO> rr = courseController.findBypK(0L);
//        assertEquals(rr.getStatusCode(), HttpStatus.OK);
//    }
//
// 
//
//}