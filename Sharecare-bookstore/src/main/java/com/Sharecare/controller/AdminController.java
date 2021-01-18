package com.Sharecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

import com.Sharecare.model.Admin;
import com.Sharecare.model.User;
import com.Sharecare.service.AdminService;
import com.Sharecare.service.RegistrationService;


@RestController

public class AdminController {

	@Autowired
	private AdminService adminservice;
	
	@PostMapping("/adminlogin")
	@CrossOrigin(origins = "http://localhost:4200")
	public Admin adminLogin(@RequestBody Admin admin) throws Exception {
		
	String tempEmail=admin.getAdminEmail();
		String tempPassword=admin.getAdminPassword();
		
		Admin adminObj=null;
		
		if(tempEmail != null && tempPassword !=null) {
			adminObj=adminservice.fetchAdminByEmailIdAndPassword(tempEmail, tempPassword);
		}
		
		if(adminObj == null) {
			throw new Exception("Bad Credentials");
		}
		return adminObj;
	}
	
	
	@GetMapping(value = "userlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<User> getUserList(){
		return adminservice.getAllUser();
	}
	
	
	@DeleteMapping(value = "deleteUser/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String deleteUser(@PathVariable int id) {
		adminservice.removeUser(id);
		return "success";
	}
	
	
	
}
