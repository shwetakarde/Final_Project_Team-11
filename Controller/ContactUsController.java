package com.Sharecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Sharecare.model.ContactUs;
import com.Sharecare.service.ContactUsService;

@RestController
public class ContactUsController {
	
		@Autowired
		private  ContactUsService contactusservice;;
		
		@PostMapping("/contactus")
		@CrossOrigin(origins = "http://localhost:4200")

		public ContactUs addMessage(@RequestBody ContactUs contactus1) throws Exception {
//			contactus1=null;
			contactus1=contactusservice.saveContent(contactus1);
			return contactus1;
		}

	
}
