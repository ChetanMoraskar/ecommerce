package com.test.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.ecomerce.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
