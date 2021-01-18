package com.Sharecare.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sharecare.model.Artistic;
import com.Sharecare.model.User;
import com.Sharecare.repository.RegistrationRepository;
import com.Sharecare.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService regservice;
	@Autowired
	private RegistrationRepository regrepo;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")

	public User registerUser(@RequestBody User user) throws Exception {
	
		String tempEmailId=user.getEmail();
		
		if(tempEmailId != null && !"".equals(tempEmailId)) {
		
			User userObj=regservice.fetchUserByEmailId(tempEmailId);
			if(userObj!= null) {
				throw new Exception("User With" +tempEmailId+ "already exist");
			}
		}
		
		User userObj=null;
		userObj=regservice.saveuser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		
		String tempEmail=user.getEmail();
		String tempPassword=user.getPassword();
		
		User userObj=null;
		User userAdminObj=null;
		
		if(tempEmail=="admin@gmail.com" && tempPassword=="admin") {
			return userAdminObj;
		}
		else if(tempEmail != null && tempPassword !=null) {
			userObj=regservice.fetchUserByEmailIdAndPassword(tempEmail, tempPassword);
		}
		
		if(userObj == null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}
	
	
}
