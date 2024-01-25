package com.lafista.backend.category.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lafista.backend.category.dto.CategoryDto;
import com.lafista.backend.category.model.Category;
import com.lafista.backend.category.repository.CategoryRepository;
import com.lafista.backend.category.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        category.setAllItems(new ArrayList<>());
        return categoryRepository.save(category);
    }

    @Override
    public Category deleteCategory(String categoryId) {
        var category = getCategoryById(categoryId);
        categoryRepository.deleteById(categoryId);
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(String categoryId) {
        var category = categoryRepository.findById(categoryId);
        return category.orElseThrow(() -> new RuntimeException("Category id not found"));
    }

    @Override
    public Category updateCategory(String categoryId, String categoryName) {
        var Category = getCategoryById(categoryId);
        Category.setCategoryName(categoryName);
        return categoryRepository.save(Category);
    }
    
}
