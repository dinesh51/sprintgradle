package com.attendance.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class Faculty extends UserEntity {
	
	private String 	subject;

	
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faculty(String name, String password, String confirmPassword, String mobileNo, int roleId,
			String gender,String subject,String email) 
	{
		super( name, password, confirmPassword, mobileNo, roleId, gender,email);
		this.subject=subject;
	}
	
	
	
	
	
	
	
//	@ManyToMany(cascade = { CascadeType.ALL })
//	    @JoinTable(
//	        name = "Faclty_Subject",
//	        joinColumns = { @JoinColumn(name="Facultyid") },
//	        inverseJoinColumns = { @JoinColumn(name = "Subjectid") }
//	    )
//	 Set<Subject> subjects;
//	
//	public AssignFacultyEntity(long id, String name, String password, String confirmPassword, String mobileNo,
//			int roleId, String gender) {
//		super(id, name, password, confirmPassword, mobileNo, roleId, gender);
//		// TODO Auto-generated constructor stub
//	}
//	public Set<Subject> getSubjects() {
//		return subjects;
//	}
//	public void setSubjects(HashSet<Subject> subjects) {
//		this.subjects = subjects;
//	}
//	public AssignFacultyEntity() {
//		super();
//	}

}
