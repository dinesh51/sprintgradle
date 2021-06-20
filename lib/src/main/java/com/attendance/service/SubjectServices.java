package com.attendance.service;

import java.util.List;

import com.attendance.entities.Subject;

public interface SubjectServices {
  
	public Subject addSubject(Subject subject);
	public Subject updateSubject(int subjectId, Subject subject);
	public Subject removeSubject(int id);
	public List<Subject> getSubjectList();
	public Subject getSubject(int subjectId);
	
}
