package com.practice.product_service.repository;

import com.practice.product_service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("Select c from Category c where c.id=:id")
    Optional<Category> findCategoryById(@Param("id") Long categoryId);

    @Query("Select c from Category c where c.name Like %:name%")
    Optional<Category> findCategoryByName(@Param("name") String categoryName);
}
