package com.practice.product_service.repository;

import com.practice.product_service.entity.Category;
import com.practice.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select p from Product p where p.name Like %:name%")
    Optional<Product> findProductByName(@Param("name") String name);
}
