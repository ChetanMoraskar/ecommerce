package com.ecomerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecomerce.model.Category;
import com.ecomerce.model.Product;
import com.ecomerce.repository.CategoryRepository;
import com.ecomerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	

	// get all product
	public List<Product> getAllProduct() {
		List<Product> list = productRepository.findAll();
		return list;
	}

	// add product
	public Product addProduct(Product product) {
		productRepository.save(product);
		return product;
	}

	// get by Id
	public Product getProductById(int id) {
		Product product = productRepository.getById(id);
		if (product != null) {
			return product;
		}
		return null;
	}

	//update by id
	public Product updateById(Product product) {
		Product product1 = productRepository.findById(product.getId()).get();
		if (product1 != null) {
			productRepository.save(product);
			return product;
		}
		return null;
	}

	// Delete by Id
	public Product deleteById(int id) {
		Product product1 = productRepository.findById(id).get();
		if (product1 != null) {
			System.out.println("DELETE METHOD CALL");
			productRepository.delete(product1);
			return product1;
		}
		return null;
	}
	
	
	public List<Product> getByCatId(int id){
		Category category = categoryRepository.findById(id).get();
		if(category == null) {
			return null;
		}
		List<Product> list = productRepository.findByCategory(category);
		if(!list.isEmpty()) {
			return list;
		}
		return null;
	}

	public List<Product> getAllProductPage(Pageable page) {
		Page<Product> pageRepo = productRepository.findAll(page);
		List<Product> list = pageRepo.getContent();
		return list;
	}
	
	
}
