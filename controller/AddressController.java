package com.Sharecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sharecare.model.Address;
import com.Sharecare.model.Book;
import com.Sharecare.repository.AddressRepository;


@RestController
public class AddressController {
	
	@Autowired
	private AddressRepository addRepo;
	
	@PostMapping("/addAddress")
	@CrossOrigin(origins = "http://localhost:4200")
	public Address addAddress(@RequestBody Address address) throws Exception {

		
		return addRepo.save(address);
	}

}
