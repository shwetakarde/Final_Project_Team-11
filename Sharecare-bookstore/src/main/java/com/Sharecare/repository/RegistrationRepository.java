package com.Sharecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sharecare.model.Artistic;
import com.Sharecare.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {

	
	public User findByemail(String email);
	public User findByemailAndPassword(String email,String password);
	//public Artistic save(Artistic artistic);
//	public Artistic save(Artistic artistic);
 
    
}
