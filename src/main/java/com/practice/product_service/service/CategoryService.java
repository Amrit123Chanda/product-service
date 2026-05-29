package com.practice.product_service.service;

import com.practice.product_service.dto.CategoryRequest;
import com.practice.product_service.dto.CategoryResponse;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);

    CategoryResponse updateCategory(CategoryRequest categoryRequest, Long id);
}
