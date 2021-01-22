package com.Sharecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Sharecare.model.Book;
import com.Sharecare.model.Donation;
import com.Sharecare.model.User;
import com.Sharecare.repository.DonationRepository;
import com.Sharecare.service.DonationService;

@RestController
public class DonationController {

	@Autowired
	private DonationService donationservice;
	
	@Autowired
	private DonationRepository donationrepo;
	
	@PostMapping("/donate")
	@CrossOrigin(origins = "http://localhost:4200")
	public Donation donate(@RequestBody Donation donation) throws Exception {
		
//		Donation donationobj;
//		donationobj=donationservice.saveDonation(donation);
//		return donationobj;
		return donationrepo.save(donation);
		
	}
	
//	@RequestMapping(value="/donationlist", method = RequestMethod.GET)
//	@CrossOrigin(origins = "http://localhost:4200")
//	public ResponseEntity<List<Donation>> getAllDonation(){
//		List<Donation> donation =donationservice .findAllDonation();
//		
//		if(donation.isEmpty()){
//			return new ResponseEntity<List<Donation>>(HttpStatus.NO_CONTENT);
//		}
//		
//		return new ResponseEntity<List<Donation>>(donation, HttpStatus.OK);
//	}
	
	@GetMapping(value = "donationlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Donation> getUserList(){
		return donationrepo.findAll();
	}
	
}
