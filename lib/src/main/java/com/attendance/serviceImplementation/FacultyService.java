package com.attendance.serviceImplementation;

 

import java.util.List;

 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

 

import com.attendance.controllers.AdminController;
import com.attendance.entities.Faculty;
import com.attendance.entities.UserEntity;
import com.attendance.repository.FacultyRepository;
import com.attendance.service.IFacultyService;

 

@Service
public class FacultyService implements IFacultyService{

 

    Logger logger = LoggerFactory.getLogger(FacultyService.class);

 

    
    @Autowired
    public FacultyRepository facultyRepository;
    
    public Faculty saveFaculty(Faculty faculty) {    
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
        String encodedPassword = bCryptPasswordEncoder.encode(faculty.getPassword());
        faculty.setPassword(encodedPassword);
        faculty.setRoleId(1);
        return    facultyRepository.save(faculty);
        
}
    
    
    
    public  List<Faculty> getFaculties(){
        
             List<Faculty> FacultyList=facultyRepository.findAllFaculties();
             return FacultyList;
    }
       public  Faculty updateFaculty(Faculty faculty){
            
            Faculty existing=facultyRepository.findById((int) faculty.getId()).orElse(null);
            existing.setName(faculty.getName());
            existing.setMobileNo(faculty.getMobileNo());
            existing.setRoleId(faculty.getRoleId());
            existing.setEmail(faculty.getEmail());
            existing.setGender(faculty.getGender());
            existing.setPassword(faculty.getPassword());

 

            existing.setSubject(faculty.getSubject());
            logger.info("*** Service : faculty removed. ***");
            return facultyRepository.save(existing);
        }
       
       public Faculty  deleteFaculty(int id){
           Faculty faculty = facultyRepository.findById(id).orElse(null);
           logger.warn("*** Removing faculty. ***");
            if (facultyRepository.existsById(id)) {
                facultyRepository.deleteById(id);
                logger.info("*** Service : faculty removed. ***");
            }

 

           return faculty;
    }
       
       
        public Faculty getFaculty(int id) {
            // TODO Auto-generated method stub
            Faculty faculty = facultyRepository.findById(id).orElse(null);
            logger.info("*** Service : Displaying faculty information. ***");
            return faculty;
        }
       
       
       

 

    
       
}