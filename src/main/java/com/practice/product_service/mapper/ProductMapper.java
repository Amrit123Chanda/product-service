package com.practice.product_service.mapper;

import com.practice.product_service.dto.ProductRequest;
import com.practice.product_service.dto.ProductResponse;
import com.practice.product_service.entity.Category;
import com.practice.product_service.entity.Product;

public class ProductMapper {

    public static Product toProduct(ProductRequest productRequest, Category category) {

        Product product = new Product();

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setCategory(category);
        return product;
    }

    public static ProductResponse toProductResponse(Product product)
    {
        ProductResponse productResponse=new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setStock(product.getStock());
        productResponse.setCategoryName(product.getCategory().getName());
        return productResponse;

    }
}
