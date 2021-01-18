package com.Sharecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sharecare.model.Admin;

public interface AdminRepository  extends JpaRepository<Admin,Integer>{

	public Admin findByAdminEmailAndAdminPassword(String adminEmail,String adminPassword);

}
