package com.practice.product_service.service;

import com.practice.product_service.dto.CategoryRequest;
import com.practice.product_service.dto.CategoryResponse;
import com.practice.product_service.entity.Category;
import com.practice.product_service.mapper.CategoryMapper;
import com.practice.product_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {

        Category category = CategoryMapper.toCategory(categoryRequest);
        Category savedCategory = categoryRepository.save(category);
        CategoryResponse savedCategoryResponse = CategoryMapper.toCategoryResponse(savedCategory);

        return savedCategoryResponse;

    }

    @Override
    public CategoryResponse updateCategory(CategoryRequest categoryRequest, Long id) {

        Category category=categoryRepository.findCategoryById(id).orElseThrow(()->new RuntimeException("Category not found with id: "+id));
        category.setName(categoryRequest.getName());
        Category updatedCategory=categoryRepository.save(category);
        CategoryResponse updatedCategoryResponse = CategoryMapper.toCategoryResponse(updatedCategory);

        return updatedCategoryResponse;
    }
}
