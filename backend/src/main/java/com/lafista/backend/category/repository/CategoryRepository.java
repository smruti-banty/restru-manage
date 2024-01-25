package com.lafista.backend.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lafista.backend.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{
    
}
