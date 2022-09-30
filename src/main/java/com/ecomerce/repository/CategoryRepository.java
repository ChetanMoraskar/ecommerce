package com.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomerce.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
