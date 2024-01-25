package com.lafista.backend.category.service;


import java.util.List;

import com.lafista.backend.category.dto.CategoryDto;
import com.lafista.backend.category.model.Category;

public interface CategoryService {
    Category addCategory(Category category);

    Category deleteCategory(String categoryId);

    Category updateCategory(String categoryId, String categoryName);

    List<Category> getAllCategories();

    Category getCategoryById(String categoryId);
}
