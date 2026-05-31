package com.practice.product_service.service;

import com.practice.product_service.dto.CategoryRequest;
import com.practice.product_service.dto.CategoryResponse;
import com.practice.product_service.entity.Category;
import com.practice.product_service.exception.ResourceNotFoundException;
import com.practice.product_service.mapper.CategoryMapper;
import com.practice.product_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

        Category category=categoryRepository.findCategoryById(id).orElseThrow(()->new ResourceNotFoundException("Category not found with id: "+id));
        if(categoryRequest.getName()!=null){
            category.setName(categoryRequest.getName());
        }
        if (categoryRequest.getDescription()!=null){
            category.setDescription(categoryRequest.getDescription());
        }

        Category updatedCategory=categoryRepository.save(category);
        CategoryResponse updatedCategoryResponse = CategoryMapper.toCategoryResponse(updatedCategory);

        return updatedCategoryResponse;
    }

    @Override
    public CategoryResponse getCategory(String categoryName) {
       Optional<Category> optCategory= categoryRepository.findCategoryByName(categoryName);
       Category recievedCategory=optCategory.orElseThrow(()->new ResourceNotFoundException("Category not found with name: "+categoryName));
       CategoryResponse categoryResponse = CategoryMapper.toCategoryResponse(recievedCategory);

       return categoryResponse;
    }
}
