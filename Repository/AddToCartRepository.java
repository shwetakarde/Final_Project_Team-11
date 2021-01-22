package com.Sharecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sharecare.model.AddToCart;
import com.Sharecare.model.Book;

@Repository
public interface AddToCartRepository extends JpaRepository<AddToCart, Integer> {

	public List<AddToCart> findById(int id);

}
