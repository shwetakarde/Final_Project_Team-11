package com.Sharecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.Sharecare.model.User;

public interface RegistrationRepository extends CrudRepository<User, Integer>{

	
	public User findByemail(String email);
	public User findByemailAndPassword(String email,String password);
	public User findById(int id);
	//public Artistic save(Artistic artistic);
//	public Artistic save(Artistic artistic);
 
    
}
