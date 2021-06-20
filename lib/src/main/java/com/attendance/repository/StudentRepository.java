package com.attendance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

//	public long add(StudentEntity entity);
//	public void update(StudentEntity entity);
//	public void delete(StudentEntity entity);
	//public Optional<StudentEntity> findByFirstName(String name);
//	public StudentEntity findByPk(long id);
//	public List<StudentEntity> search(StudentEntity entity, long pageNo, int pageSize);
//	public List<StudentEntity> search(StudentEntity entity);	
	public Optional<StudentEntity> findByRollNo(long roll);
}
