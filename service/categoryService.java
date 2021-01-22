package com.Sharecare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sharecare.model.Category;
import com.Sharecare.repository.categoryRepository;

@Service
public class categoryService {

	@Autowired
	private categoryRepository categoryrepository;
	 
	public  List<Category> findAllCategory() {
		return categoryrepository.findAll();
	}

	public Category saveCategoryDetails(Category category) {
		return categoryrepository.save(category);
	}

	
        
}
