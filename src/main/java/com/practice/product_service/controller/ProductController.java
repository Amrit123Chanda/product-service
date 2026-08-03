package com.practice.product_service.controller;

import com.practice.product_service.dto.ProductRequest;
import com.practice.product_service.dto.ProductResponse;
import com.practice.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/getbyName/{name}")
    public ProductResponse getProduct(@PathVariable String name){
        return productService.getProduct(name);
    }

    @PatchMapping("/update/{id}")
    public ProductResponse updateProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id){
        return productService.updateProduct(productRequest,id);
    }

    @GetMapping("/get/allProducts/{categoryId}")
    public Page<ProductResponse> getProductListforCategoryId(@PathVariable Long categoryId,
                                                             @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return productService.getProductListforCategoryId(categoryId,page,size);
    }

    @GetMapping("/getbyId/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

}
