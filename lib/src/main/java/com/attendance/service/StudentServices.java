package com.attendance.service;

import java.util.List;
import java.util.Optional;

import com.attendance.entities.StudentEntity;

public interface StudentServices {
	public StudentEntity add(StudentEntity entity);
	 public StudentEntity update(StudentEntity entity);
	  public StudentEntity delete(StudentEntity entity);
	  public List<StudentEntity> getAllStudents();
	  public Optional<StudentEntity> findByPk(int id);
	  //public StudentEntity findByName(String name);
	  public Optional<StudentEntity> findByRollNo(long roll);

}
