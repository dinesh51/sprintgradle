package com.attendance.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entities.Course;
import com.attendance.repository.CourseRepository;

@Service
public class CourseService {
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

//	public List<Course> findAll() {
//		return courseRepo.findAll();
//	}

	

	

	
}
