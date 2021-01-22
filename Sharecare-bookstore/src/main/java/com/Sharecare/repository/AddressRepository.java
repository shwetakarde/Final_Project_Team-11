package com.Sharecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sharecare.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
}
