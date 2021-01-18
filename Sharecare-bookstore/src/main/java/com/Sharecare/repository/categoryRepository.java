package com.Sharecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sharecare.model.Category;

public interface categoryRepository extends JpaRepository<Category, Integer> {

	
}
