package com.practice.product_service.service;

import com.practice.product_service.dto.ProductRequest;
import com.practice.product_service.dto.ProductResponse;
import com.practice.product_service.entity.Category;
import com.practice.product_service.entity.Product;
import com.practice.product_service.mapper.ProductMapper;
import com.practice.product_service.repository.CategoryRepository;
import com.practice.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {

       Optional<Category> optionalCategory = categoryRepository.findCategoryById(productRequest.getCategoryId());
       Category category=optionalCategory.orElseThrow(()->new RuntimeException("Category not found with id: "+productRequest.getCategoryId()));

       Product product=ProductMapper.toProduct(productRequest,category);
       Product savedProduct= productRepository.save(product);
       ProductResponse savedProductResponse = ProductMapper.toProductResponse(savedProduct);

        return  savedProductResponse;
    }
}
