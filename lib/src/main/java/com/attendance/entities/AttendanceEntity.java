package com.attendance.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AttendanceEntity")
public class AttendanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attendance_id;
	private long subjectId;

//	private long studentId;
	private String studentName;
	private String semester;
	private Date date;
	private String totalClass;
	private long total;
	private String percentage;
	private long courseId;
	
    @ManyToOne
	private StudentEntity student;
	
	
	public StudentEntity getStudent() {
		return student;
	}
	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	
	

	
	public AttendanceEntity() {
		super();
	}
	public int getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTotalClass() {
		return totalClass;
	}
	public void setTotalClass(String totalClass) {
		this.totalClass = totalClass;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	
	
//	@ManyToOne
//	private StudentEntity student;
//	
//	public StudentEntity getStudent() {
//		return student;
//	}
//
//	public void setStudent(StudentEntity student) {
//		this.student = student;
//	}

	
}
