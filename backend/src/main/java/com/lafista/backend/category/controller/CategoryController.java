package com.lafista.backend.category.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lafista.backend.category.dto.CategoryDto;
import com.lafista.backend.category.model.Category;
import com.lafista.backend.category.service.CategoryService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Category deleteCategory(@PathVariable(name = "categoryId") String categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    
    @PutMapping("/{categoryId}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Category updateCategory(@PathVariable String categoryId, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(categoryId, categoryDto.categoryName());
    }
    
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable(name = "categoryId") String categoryId) {
        return categoryService.getCategoryById(categoryId);
    }
}
