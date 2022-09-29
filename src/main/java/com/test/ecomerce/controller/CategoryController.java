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

import com.test.ecomerce.model.Category;
import com.test.ecomerce.service.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService catService;
	
	@GetMapping("/all")
	public List<Category> getAllCat(){
		return catService.getAllCategories();
		
	}
	
	@PostMapping("/add")
	public Category addCategory(@RequestBody Category category) {
		return catService.addCategory(category);
	}
	
	@GetMapping("/{id}")
	public Category findCategory(@PathVariable int id) {
		return catService.getCategoryById(id);
		
	}
	
	@PutMapping("/update")
	public Category updateCategory(@RequestBody Category category) {
		return catService.updateCategoryById(category);
	}
	
	@DeleteMapping("/delete/{id}")
	public Category deleteCategory(@PathVariable int id) {
		return catService.deleteById(id);
	}
}
