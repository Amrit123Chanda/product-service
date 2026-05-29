package com.practice.product_service.controller;

import com.practice.product_service.dto.CategoryRequest;
import com.practice.product_service.dto.CategoryResponse;
import com.practice.product_service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryResponse createCategory(CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }
}
