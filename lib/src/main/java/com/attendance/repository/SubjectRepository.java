package com.attendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.attendance.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {
//
//	@Query("SELECT s FROM Subject s  WHERE s.course_courseid = ?1")
//	public List<Subject> findByCourseId(int id);
}
