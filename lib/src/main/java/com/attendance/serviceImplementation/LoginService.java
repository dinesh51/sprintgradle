package com.attendance.serviceImplementation;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

 

import com.attendance.entities.UserEntity;
import com.attendance.repository.UserEntityRepository;
import com.attendance.service.ILoginService;

 

@Service
public class LoginService implements ILoginService {

 

    
    @Autowired
    public UserEntityRepository userRepository;
    
//    public UserEntity getUser(int id) {
//        
//        UserEntity user = userRepository.findById(id).orElse(null);
//        return user;
//    }

 

    
    public UserEntity validateuser(String email, String password) {
        UserEntity user = userRepository.validateUser(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(password, user.getPassword()))
            return user;
        else
            return null;
    }
    
}







