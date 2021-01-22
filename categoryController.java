package com.Sharecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Sharecare.model.Book;
import com.Sharecare.model.Category;
import com.Sharecare.service.BookService;
import com.Sharecare.service.categoryService;

@RestController
public class categoryController {

	@Autowired
	private categoryService categoryservice;
	
	@Autowired
	private BookService bookservice;
	
	@RequestMapping(value="/categorylist", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getAllCategories(){
		List<Category> categories = categoryservice.findAllCategory();
		if(categories.isEmpty()){
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
	
	
	@PostMapping("/addCategory")
	@CrossOrigin(origins = "http://localhost:4200")
	public Category addCategory(@RequestBody Category category) throws Exception {
		category=categoryservice.saveCategoryDetails(category);
		return category;
	}
	

	
	
	
	
}
