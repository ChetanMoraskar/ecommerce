package com.test.ecomerce.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ecomerce.model.Product;
import com.test.ecomerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		return productService.getAllProduct();
	}
	
	@GetMapping("/category/{id}")
	public List<Product> getAllProducts(@PathVariable int id){
		return productService.getByCatId(id);
	}
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product){
		return productService.addProduct(product);
	}
	
	@GetMapping("/id")
	public Product getById(@PathVariable int id){
		return productService.getProductById(id);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product){
		return productService.updateById(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public Product deleteProduct(@PathVariable int id){
	return productService.deleteById(id);	
	}
}
