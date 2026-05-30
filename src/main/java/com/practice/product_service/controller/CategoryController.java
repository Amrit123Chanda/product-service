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

    @GetMapping("/get/{categoryName}")
    public CategoryResponse getCategory(@PathVariable String categoryName){
        return categoryService.getCategory(categoryName);
    }

    @PostMapping("/save")
    public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }
    @PatchMapping("/update/{id}")
    public CategoryResponse updateCategory(@RequestBody CategoryRequest categoryRequest,@PathVariable Long id){
       return categoryService.updateCategory(categoryRequest,id);
    }
}
