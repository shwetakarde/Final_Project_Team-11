package com.Sharecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sharecare.model.Artistic;
import com.Sharecare.model.User;
import com.Sharecare.service.ArtisticService;

@RestController
public class ArtisticController {
	@Autowired
	private ArtisticService artisticservice;
	
	@PostMapping("/creativity")
	@CrossOrigin(origins = "http://localhost:4200")

	public Artistic addCreativity(@RequestBody Artistic artistic) throws Exception {
		
		Artistic artisticobj=null;
		artisticobj=artisticservice.saveContent(artistic);
		return artisticobj;
	}
	
	@GetMapping(value = "/creativitylist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Artistic> getUserList(){
		return artisticservice.getAllCreativity();
	}
}
