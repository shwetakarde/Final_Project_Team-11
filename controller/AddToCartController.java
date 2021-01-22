package com.Sharecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sharecare.model.AddToCart;
import com.Sharecare.repository.AddToCartRepository;

@RestController
public class AddToCartController {

	
	@Autowired
	private AddToCartRepository cartrepo;
	
	
	
	@GetMapping("/showCart/{id}")
	@CrossOrigin
	public List<AddToCart> findCart(@PathVariable int id){
		return cartrepo.findById(id);
	}

	@PostMapping("/cart")
	@CrossOrigin
	public AddToCart createCart(@RequestBody AddToCart cart) {
		return cartrepo.save(cart);
	}

	
	
}
