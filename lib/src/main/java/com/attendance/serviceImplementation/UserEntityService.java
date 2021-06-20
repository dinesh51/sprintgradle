package com.attendance.serviceImplementation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.attendance.entities.UserEntity;
import com.attendance.repository.UserEntityRepository;
@Service
public class UserEntityService {

	@Autowired
	public UserEntityRepository userRepository;
	
	public UserEntity saveAdmin(UserEntity user) {
//		
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
//		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
//		user.setConfirmPassword(encodedPassword);
		return	userRepository.save(user);
			
	}
	
	
	public  List<UserEntity> getAdminList(){
		
		return	userRepository.findAllAdmins();
			
	}
	
	
	public  UserEntity updateAdmin(UserEntity user){
		
		UserEntity existing=userRepository.findById(user.getId()).orElse(null);
		existing.setName(user.getName());
		existing.setMobileNo(user.getMobileNo());
		existing.setRoleId(user.getRoleId());
		existing.setGender(user.getGender());
		existing.setPassword(user.getPassword());
		existing.setConfirmPassword(user.getConfirmPassword());
		return userRepository.save(existing);
		
		
	}
	
	public  String deleteAdmin(int id){
		
		userRepository.deleteById(id);	
		return "Admin deleted Successfully";
}


	public String login(String name, String password) {
		UserEntity user= userRepository.findByEmail(name);
		 if (user == null) {
	           return "please enter correct details";
	        }

		 else
		 {
//			 String name1 = request.getParameter("name");
//			 String password2 = request.getParameter("password");
//			 
//			 HttpServletRequest request = null;
//				HttpSession session=request.getSession();
//				session.setAttribute("usname",name);
//				session.setAttribute("uspass",password);
				return "You have logged in succesfully";
		 }
		
	
		 
		
		
	}
	
	public String ChangePassword(String email,String oldPassword, String newPassword) {
//		UserEntity user= userRepository.findByEmail(email);			
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
//		String oldEncodedPassword = bCryptPasswordEncoder.encode(oldPassword);
//		String encodedNewPassword = bCryptPasswordEncoder.encode(newPassword);	
//		
//		String dbEncodedPassword = user.getPassword();
//		
//		if(oldEncodedPassword.equals(dbEncodedPassword)) {
//			
//			user.setPassword(encodedNewPassword);
//			user.setConfirmPassword(encodedNewPassword);
//			 userRepository.save(user);
			 return "updated succesfully";		}
		
//		else {
//			return "no password";
//		}
//		 
//		 }


	public String logout() {
		
		//session.invalidate();
			String s="succesfully loggedout";

		return s;
	}


	public UserEntity getUser(int id) {
		
		UserEntity user = userRepository.findById(id).orElse(null);
		return user;
	}


	
	
}
