package com.Sharecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Sharecare.model.Donation;
import com.Sharecare.repository.DonationRepository;

@Service
public class DonationService {

	private DonationRepository donationrepo;
	
	public Donation saveDonation(Donation donation) {
		return donationrepo.save(donation);
	}

	public List<Donation> findAllDonation() {
		return (List<Donation>)donationrepo.findAll();
	}

}
