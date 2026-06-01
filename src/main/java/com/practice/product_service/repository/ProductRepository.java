package com.practice.product_service.repository;

import com.practice.product_service.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select p from Product p where p.name Like %:name%")
    Optional<Product> findProductByName(@Param("name") String name);

    @Query("select p from Product p where p.category.id=:categoryId")
    Page<Product> findProductsforCatId(@Param("categoryId") Long categoryId, Pageable pageable);
}
