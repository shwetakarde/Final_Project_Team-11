package com.Sharecare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sharecare.model.Artistic;
import com.Sharecare.model.User;
import com.Sharecare.repository.RegistrationRepository;



@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repo;
	
	public User saveuser(User user) {
		return repo.save(user);
	}

	public User fetchUserByEmailId(String email) {
		
		 return repo.findByemail(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		
		 return repo.findByemailAndPassword(email,password);
	}
	
}
