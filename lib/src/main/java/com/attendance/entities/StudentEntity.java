package com.attendance.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Students")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int Studentid;
	@Digits(integer = 5, fraction = 0)
	private long rollNo;
	@NotEmpty(message = "First Name is required")
	private String Name;
	private String gender;
	@NotEmpty(message = "Mobile number is required")
	@Pattern(regexp = "\\d{10}", message = "Contact number is Invalid")
	private String mobileNo;
	private long courseId;

	private long subjectId;

	private String semester;
	@NotEmpty(message = "Email is required")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+[@][a-zA-Z]+[.][a-zA-Z]+", message = "Email id is invalid")
	private String emailId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<AttendanceEntity> attendance;

	public StudentEntity() {
		super();
	}

	public int getStudentid() {
		return Studentid;
	}

	public void setStudentid(int studentid) {
		Studentid = studentid;
	}

	public long getRollNo() {
		return rollNo;
	}

	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
