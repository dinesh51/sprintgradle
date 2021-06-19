package com.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.entities.UserEntity;
import com.attendance.serviceImplementation.UserEntityService;

@RestController
public class LoginController 
{
	@Autowired
	private UserEntityService userService;
	
	

    @PostMapping("/login/{name}/{password}")
    public String login(@PathVariable String name,String password) {
    	String s=userService.login(name,password);
        return s;
    }
    
    @PutMapping("/logout")
    public String logOut() {
    	String s=userService.logout();
        return s;
    }
    

}
