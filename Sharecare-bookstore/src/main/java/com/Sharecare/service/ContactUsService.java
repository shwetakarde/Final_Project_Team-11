package com.Sharecare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sharecare.model.ContactUs;
import com.Sharecare.repository.ContactUsRepository;

@Service
public class ContactUsService {

	@Autowired
	private ContactUsRepository contactusrepo;
	
	public ContactUs saveContent(ContactUs contactus1) {
		return contactusrepo.save(contactus1); 
		
	}

}
