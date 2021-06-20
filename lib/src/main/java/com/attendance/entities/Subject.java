package com.attendance.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Subject {
	@Id
	private int subjectid;

	@NotEmpty(message = "Subject name must not be empty ")
	private String name;

	@NotEmpty(message = "subject code name must not be empty ")
	@Pattern(regexp = "^[1-9]+[A-Z]+[0-9]", message = "subject code id is invalid")
	private String subjectcode;

	@NotEmpty(message = "semester name must not be empty ")
	private String semester;

	@ManyToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name="Courseid")
	private Course course;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Subject")
	private List<AssignFaculty> assfaculty;

	public String getSubjectcode() {
		return subjectcode;
	}

	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}
}