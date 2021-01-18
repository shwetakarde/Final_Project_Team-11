package com.Sharecare.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sharecare.model.Admin;
import com.Sharecare.model.User;
import com.Sharecare.repository.AdminRepository;
import com.Sharecare.repository.RegistrationRepository;


@Service
public class AdminService {

	private int e=1;
	 @Autowired
	 private AdminRepository adminrepo;
	
	 @Autowired
	 private RegistrationRepository regrepo;
	 
	 public Admin fetchAdminByEmailIdAndPassword(String adminEmail,String adminPassword) {
		 return adminrepo.findByAdminEmailAndAdminPassword(adminEmail,adminPassword);

	 }

	public List<User> getAllUser(){
		return regrepo.findAll();

	}

	public void removeUser(int id) {
		  regrepo.deleteById(id);
	}

	
	 
}
