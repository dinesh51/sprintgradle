package com.attendance.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

 

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course") 
    private List<Subject> Subject; 

//	@OneToMany(cascade = CascadeType.ALL)  
//	@JoinColumn(name="cs_id")  
//    private List<Subject> subjects;  
//    
//    
//    public List<Subject> getSubjects() {
//		return subjects;
//	}
//	public void setSubjects(List<Subject> subjects) {
//		this.subjects = subjects;
//	}
	public Course() {
       
    }
    public int getCourseid() {
        return courseid;
    }
    public void setCourseid(int courseid) {
    	this.courseid = courseid;
    }
//    public List<Subject> getSubject() {
//		return Subject;
//	}
//	public void setSubject(List<Subject> subject) {
//		Subject = subject;
//	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
