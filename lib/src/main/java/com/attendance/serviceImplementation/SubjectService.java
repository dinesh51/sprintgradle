package com.attendance.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entities.Course;
import com.attendance.entities.Subject;
import com.attendance.exception.SubjectException;
import com.attendance.repository.CourseRepository;
import com.attendance.repository.SubjectRepository;
import com.attendance.service.SubjectServices;


@Service
public class SubjectService implements SubjectServices {


	@Autowired
	public SubjectRepository subjectRepository;

	@Autowired
	public CourseRepository courserepositor;

	Logger logger = LoggerFactory.getLogger(SubjectService.class);

	// Method to add Subject
	// INPUT : Subject
	// OUTPUT : added Subject details

	public Subject addSubject(Subject subject) {

		
//		long k = subject.getCourse().getCourseid();
//		int i = (int) k;
//		Optional<Course> op = courserepositor.findById(i);
//
//		if (op.isEmpty() && subject.getCourse().equals(null))// throws exception
//		{
//			throw new SubjectException("Course not find ");
//		} else
//			subject.setCourse(op.get());
		logger.info("*** Service :  Subject added successfully. ***");
		return subjectRepository.save(subject);
	}

	// Method to update Subject
	// INPUT : Subject
	// OUTPUT : updated Subject details
	
	public Subject updateSubject(int subjectId, Subject subject) {
		Subject existing = subjectRepository.findById(subjectId).orElse(null);
		existing.setName(subject.getName());
		existing.setSemester(subject.getSemester());
		existing.setSubjectcode(subject.getSubjectcode());
		logger.info("*** Service :  Subject updated successfully. ***");
		return subjectRepository.save(existing);
	}

	// Method to get all Subject
	// OUTPUT : List of all Subject
	
	public Subject removeSubject(int id) {

		Subject subject = subjectRepository.findById(id).orElse(null);

		logger.info("*** Service : Subject removed ***");
		return subject;
	}

	// Method to get all Subject
	// OUTPUT : List of all Subject
	
	public List<Subject> getSubjectList() {

		logger.info("*** Service : Displaying Subject information ***");
		return subjectRepository.findAll();
	}
	
	
	// Method to get subject by subjectId
	// INPUT : subjectId
	// OUTPUT : subject by subjectId

	public Subject getSubject(int subjectId) {

		if (subjectRepository.existsById(subjectId)) {
			logger.info("*** Service : Displaying Subject with id ***" + subjectId);

		}

		return subjectRepository.findById(subjectId).orElse(null);

	}
	
	//Method to get subjects in course
	//INPUT : courseId
	//OUPUT:
	
//	public List<Subject> getSubjects(int courseId) {
//		return subjectRepository.findByCourseId(courseId);
//	}


}
