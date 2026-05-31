package com.practice.product_service.controller;

import com.practice.product_service.dto.ProductRequest;
import com.practice.product_service.dto.ProductResponse;
import com.practice.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }

    @GetMapping("/get/{name}")
    public ProductResponse getProduct(@PathVariable String name){
        return productService.getProduct(name);
    }

    @PatchMapping("/update/{id}")
    public ProductResponse updateProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id){
        return productService.updateProduct(productRequest,id);
    }

}
