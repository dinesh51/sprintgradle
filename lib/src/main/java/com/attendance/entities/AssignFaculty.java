package com.attendance.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "AssignFaculty")
public class AssignFaculty {

	//facultyid;
	//subject entity object
	//id

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
		@ManyToOne(cascade = CascadeType.ALL)
	    private Subject Subject; 

		private int totalclasses;
	
	
	
	
		public Subject getSubject() {
			return Subject;
		}
		public int getTotalclasses() {
			return totalclasses;
		}
		public void setSubject(Subject subject) {
			Subject = subject;
		}
		public void setTotalclasses(int totalclasses) {
			this.totalclasses = totalclasses;
		}
		

		@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)		
		  private Faculty faculty;
	
		
		public AssignFaculty() {
			super();
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	

		public Faculty getFaculty() {
			return faculty;
		}
	
		public void setFaculty(Faculty faculty) {
			this.faculty = faculty;
		}


		
	
	

	
	
	
}
