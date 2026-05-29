package com.practice.product_service.controller;

import com.practice.product_service.dto.CategoryRequest;
import com.practice.product_service.dto.CategoryResponse;
import com.practice.product_service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public CategoryResponse createCategory(CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }
    @PatchMapping("/update/{id}")
    public CategoryResponse updateCategory(CategoryRequest categoryRequest,@PathVariable Long id){
       return categoryService.updateCategory(categoryRequest,id);
    }
}
