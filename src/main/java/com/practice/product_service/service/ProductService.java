package com.practice.product_service.service;

import com.practice.product_service.dto.ProductRequest;
import com.practice.product_service.dto.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
}
