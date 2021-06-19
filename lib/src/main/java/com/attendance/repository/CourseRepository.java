package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendance.entities.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

	

}
