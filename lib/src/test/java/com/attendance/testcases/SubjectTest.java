package com.attendance.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.attendance.demo.AttendanceApplication;
import com.attendance.entities.Course;
import com.attendance.entities.Subject;
import com.attendance.repository.SubjectRepository;
import com.attendance.serviceImplementation.SubjectService;



@SpringBootTest(classes=AttendanceApplication.class)
public class SubjectTest {

	@Autowired
	private SubjectService subjectService;
	
	@MockBean
	SubjectRepository subjectRepository;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void testAddSubject() {
		Subject subject= getSubject();
		
		Mockito.when(subjectRepository.save(subject)).thenReturn(subject);
		Subject result=subjectService.addSubject(subject);
		assertEquals(subject,result);
		
	}
	
    // test case for getting Subject by id
	@Test
	public void testGetSubject() {
		Subject subject = getSubject();
		subjectService.getSubject(subject.getSubjectid());
		verify(subjectRepository, times(1)).findById(subject.getSubjectid()); // Verify that the correct methods of our
																			// mock objects were invoked
	}
	
	// test case for removing Subject by id
	@Test
	public void testRemoveSubject() {
		Subject subject = getSubject();
		subjectService.removeSubject(subject.getSubjectid());
		verify(subjectRepository, times(1)).findById(subject.getSubjectid());
	}

	// test case for fetching all Doctors
	@Test
	public void testGetSubjectList() {
		when(subjectRepository.findAll()).thenReturn(Stream.of(getSubject()).collect(Collectors.toList()));
		assertEquals(1, subjectService.getSubjectList().size());
	}
	
	private Course getCourse() {
		Course course=new Course();
		
		course.setId(12);
		course.setName("ISE");
		
		return course;
	}
	private Subject getSubject() {
		Subject subject=new Subject();
		
		subject.setSubjectid(12);
		subject.setSubjectcode("15CS89");
		subject.setName("Java");
		subject.setSemester("4");
		subject.setCourse(getCourse());
		
		return subject;
	}
	
}
