package com.Sharecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sharecare.model.Donation;

public interface DonationRepository  extends JpaRepository<Donation, Integer>{

	
}
