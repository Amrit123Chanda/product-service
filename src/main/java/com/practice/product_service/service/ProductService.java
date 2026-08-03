package com.practice.product_service.service;

import com.practice.product_service.dto.ProductRequest;
import com.practice.product_service.dto.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse getProduct(String name);

    ProductResponse updateProduct(ProductRequest productRequest, Long id);

    Page<ProductResponse> getProductListforCategoryId(Long categoryId, int page, int size);

    ProductResponse getProductById(Long id);
}
