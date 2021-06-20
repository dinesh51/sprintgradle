package com.attendance.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entities.StudentEntity;
import com.attendance.repository.StudentRepository;
import com.attendance.service.StudentServices;

@Service
public class StudentService implements StudentServices{
	@Autowired
	private StudentRepository stuRepo;

	
		public StudentEntity add(StudentEntity entity)  {
			// TODO Auto-generated method stub
//			Optional<StudentEntity> stuEntity = stuRepo.findByRollNo(entity.getRollNo());
//			if(stuEntity.isPresent()) {
//				//throw new DuplicateRecordException("Duplicate Record found in DataBase");
//			}
			return stuRepo.save(entity);
		}

		
		public StudentEntity update(StudentEntity entity)  {
			// TODO Auto-generated method stub
		// Optional<StudentEntity> stuEntity = stuRepo.findByRollNo(entity.getRollNo());
//		 System.out.println(stuEntity.get());
//			System.out.println(entity.getRollNo());
//			if(!stuEntity.isPresent()) {
//				throw new RecordNotFoundException("No record found in the DataBase");
//			}
			return stuRepo.save(entity);
		}

	
		public StudentEntity delete(StudentEntity entity) {
			// TODO Auto-generated method stub
//			Optional<StudentEntity> stuEntity = stuRepo.findById(entity.getId());
//			if(!stuEntity.isPresent()) {
//				throw new RecordNotFoundException("No record found in the DataBase");
//			}
			//stuRepo.delete(entity);
			//return entity;
			StudentEntity student = stuRepo.findById(entity.getStudentid()).orElse(null);
			if (stuRepo.existsById(entity.getStudentid())) {
				stuRepo.deleteById(entity.getStudentid());
			}

			return student;
		}

		public List<StudentEntity> getAllStudents() {
			// TODO Auto-generated method stub
			return stuRepo.findAll();
		}

		public Optional<StudentEntity> findByPk(int id) {
			// TODO Auto-generated method stub
			return stuRepo.findById(id);
		}

//		public StudentEntity findByName(String name) {
//			// TODO Auto-generated method stub
//	return stuRepo.findByFirstName(name).get();
//		}

		public Optional<StudentEntity> findByRollNo(long roll) {
			// TODO Auto-generated method stub
			return stuRepo.findByRollNo(roll);
		}

		
}
