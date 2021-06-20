package com.attendance.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entities.Course;
import com.attendance.repository.CourseRepository;
import com.attendance.service.CourseServices;

@Service
public class CourseService implements CourseServices {
	@Autowired
	private CourseRepository courseRepo;

	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}

	public Course updateCourse(Course course, int id) {
		Course newCourse = courseRepo.findById(id).orElse(null);
		newCourse.setName(course.getName());
		newCourse.setDescription(course.getDescription());
		return courseRepo.save(newCourse);
	}

	public String deleteCourse(int id) {
		courseRepo.deleteById(id);
		return "Deleted";
	}

	public Course findByName(String name) {
		return courseRepo.findByName(name);
	}

	public Course findById(int id) {
		return courseRepo.findById(id).get();
	}

	@Override
	public Course updateCourse(Course course, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCourse(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
//	public List<Course> findAll() {
//		return courseRepo.findAll();
//	}

	

	

	
}
