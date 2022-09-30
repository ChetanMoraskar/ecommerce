package com.test.ecomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.ecomerce.model.Category;
import com.test.ecomerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(Category category);
	
}
