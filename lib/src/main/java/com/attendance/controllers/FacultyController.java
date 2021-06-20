package com.attendance.controllers;

 

import java.util.List;

 

import javax.validation.Valid;

 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.attendance.entities.Faculty;
import com.attendance.entities.UserEntity;
import com.attendance.exception.FacultyException;
import com.attendance.serviceImplementation.FacultyService;
import com.attendance.serviceImplementation.UserEntityService;

 


@RestController
@RequestMapping("attendancemanagement/admin")
public class FacultyController {
    
    @Autowired
    private UserEntityService userService;
    
    @Autowired
    private FacultyService facultyService;
    
    Logger logger = LoggerFactory.getLogger(FacultyController.class);

 

    
    //Faculty 
      @PostMapping("/addFaculty")
        public ResponseEntity<Faculty> addFaculty(@Valid @RequestBody Faculty faculty) {
            
          Faculty facultyData =  facultyService.saveFaculty(faculty);

 

             if(facultyData==null)
                {
                 logger.error("Controller: Failed to save faculty");
                 throw new FacultyException("faculty not added");
                }        
             logger.info("*** Controller : facullty aadded successfully. ***");
            return new ResponseEntity<Faculty>(facultyData, HttpStatus.OK);
          
        
        } 
        @GetMapping("/facultyList")     
            public ResponseEntity<List<Faculty>> getFacultyList() {
            List<Faculty> Facultylist=facultyService.getFaculties();
                return new ResponseEntity<List<Faculty>>(Facultylist, HttpStatus.OK);     
        }

 

    
        
        @PutMapping("/updateFaculty")
        public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
            
              Faculty facultyData =  facultyService.updateFaculty(faculty);

 

                 if(facultyData==null)
                    {
                     logger.error("Controller: Failed to update faculty");
                     throw new FacultyException("faculty not updated");
                    }
                
                 logger.info("*** Controller : facullty updated successfully. ***");
                return new ResponseEntity<Faculty>(facultyData, HttpStatus.OK);
              
        
            
        }

 

        @DeleteMapping("/deleteFaculty/{id}")
        public ResponseEntity<Faculty> deleteFaculty(@PathVariable int id) {
            logger.warn("Controller: Removing Faculty");
                
                Faculty facultyData = facultyService.deleteFaculty(id);
                 if (facultyData == null) { 
                     logger.error("Controller: Faculty Not Found For given id : " + id);
                     throw new FacultyException("No Faculty for given Id "+id );
                     }
                 logger.info("*** Controller : faculty removed. ***");
            
                    return new ResponseEntity<Faculty>(facultyData, HttpStatus.OK);
        }
//        @DeleteMapping("/deleteFaculty/{id}")
//        public String deleteFaculty(@PathVariable int id) {
//            return facultyService.deleteFaculty(id);
//        }
//        
        
        @GetMapping("/viewFacultyById{id}")   
            public ResponseEntity<Faculty> getFaculty(@PathVariable int id) {
                Faculty facultydata = facultyService.getFaculty(id);
                
                 if (facultydata == null) { 
                     logger.error("Controller: Faculty not found.");
                     throw new FacultyException("No faculty for given Id "+id );
                     }
                 
                logger.info("*** Controller : Displaying faculty record . ***");
                return new ResponseEntity<Faculty>(facultydata, HttpStatus.OK);
        }
        
        
    
        

 

}