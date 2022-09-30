package com.test.ecomerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.test.ecomerce.model.Category;
import com.test.ecomerce.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	
	public List<Category> findallCategoriesByPage(Pageable pageable) {
		Page<Category> pageCate = categoryRepository.findAll(pageable);	
		List<Category> list = pageCate.getContent();
		return list;
		
	}
	
	

	// get all categories
	public List<Category> getAllCategories() {
		List<Category> list = categoryRepository.findAll();
		return list;
	}

	// add category
	public Category addCategory(Category category) {
		categoryRepository.save(category);
		return category;
	}

	// get category by id
	public Category getCategoryById(int id) {
		Category category = categoryRepository.findById(id).get();
		if (category != null) {
			return category;
		}
		return null;
	}

	public Category updateCategoryById(Category cat) {
		Category category = categoryRepository.findById(cat.getId()).get();
		if (category != null) {
			categoryRepository.save(cat);
			return cat;
		}
		return null;
	}

	// delete By Id
	public Category deleteById(int id) {
		Category category = categoryRepository.findById(id).get();
		if (category != null) {
			categoryRepository.deleteById(id);

			return category;
		}
		return null;
	}



	public List<Category> getAllCategoriesPage(org.springframework.data.domain.Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
