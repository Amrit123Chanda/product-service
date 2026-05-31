package com.practice.product_service.service;

import com.practice.product_service.dto.ProductRequest;
import com.practice.product_service.dto.ProductResponse;
import com.practice.product_service.entity.Category;
import com.practice.product_service.entity.Product;
import com.practice.product_service.exception.ResourceNotFoundException;
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
       Category category=optionalCategory.orElseThrow(()->new ResourceNotFoundException("Category not found with id: "+productRequest.getCategoryId()));

       Product product=ProductMapper.toProduct(productRequest,category);
       Product savedProduct= productRepository.save(product);
       ProductResponse savedProductResponse = ProductMapper.toProductResponse(savedProduct);

        return  savedProductResponse;
    }

    @Override
    public ProductResponse getProduct(String name) {
      Optional<Product> optionalProduct= productRepository.findProductByName(name);
      Product recievedProduct= optionalProduct.orElseThrow(()->new ResourceNotFoundException("Product not found with name: "+name));
      ProductResponse productResponse=ProductMapper.toProductResponse(recievedProduct);
      return productResponse;
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest, Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product existingProduct = optionalProduct.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        if (productRequest.getName() != null) {
            existingProduct.setName(productRequest.getName());
        }
        if (productRequest.getPrice() != null) {
            existingProduct.setPrice(productRequest.getPrice());
        }
        if (productRequest.getStock() != null) {
            existingProduct.setStock(productRequest.getStock());
        }
        if (productRequest.getCategoryId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findCategoryById(productRequest.getCategoryId());
            Category category = optionalCategory.orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + productRequest.getCategoryId()));
            existingProduct.setCategory(category);
        }

        Product updatedProduct = productRepository.save(existingProduct);
        return ProductMapper.toProductResponse(updatedProduct);

    }
}
