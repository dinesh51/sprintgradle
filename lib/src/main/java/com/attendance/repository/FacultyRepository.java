package com.attendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.attendance.entities.Faculty;
import com.attendance.entities.UserEntity;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Integer> {

	@Query("SELECT u FROM UserEntity u WHERE u.roleId = 1")
	List<UserEntity> findAllFaculties();

	
	
}