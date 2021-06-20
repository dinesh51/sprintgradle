package com.attendance.controllers;


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
import org.springframework.web.bind.annotation.RestController;

 

import com.attendance.entities.UserEntity;
import com.attendance.exception.LoginException;
import com.attendance.serviceImplementation.LoginService;
import com.attendance.serviceImplementation.UserEntityService;

 

 

@RestController
public class LoginController 
{
    @Autowired
    private LoginService loginservice;
    

 

    Logger logger = LoggerFactory.getLogger(AdminController.class);

 


//    @PostMapping("/login/{name}/{password}")
//    public String login(@PathVariable String name,String password) {
//        String s=loginservice.validateuser(name,password);
//        return s;
//    }
//    
    
    @PostMapping("/login")
    public ResponseEntity<UserEntity> validateAdmin(String userName, String password) {    
        UserEntity userData = loginservice.validateuser(userName, password);
        if (userData == null) {
            logger.error("* Controller : Invalid Credentials *");
            throw new LoginException("Invalid Credentials");
        }
        logger.info("* Controller : Successfull Login *");
        return new ResponseEntity<UserEntity>(userData, HttpStatus.OK);

 

    }
    
//    @PutMapping("/logout")
//    public String logOut() {
//        String s=userService.logout();
//        return s;
//    }
//    
    
    
    
    
    

 

}
 








