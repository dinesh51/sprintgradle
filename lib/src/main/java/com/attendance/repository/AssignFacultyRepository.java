package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendance.entities.AssignFaculty;

@Repository
public interface AssignFacultyRepository extends JpaRepository<AssignFaculty,Integer> {

	
}


