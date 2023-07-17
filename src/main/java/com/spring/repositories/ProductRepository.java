package com.spring.repositories;

import com.spring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findBySlug(String name);
    @Query("SELECT p FROM Product p WHERE lower(p.name) LIKE lower(concat('%', ?1,'%'))")
    List<Product> SearchProducts(String keyword);

    List<Product> findAllByOrderByPriceAsc();

    List<Product> findAllByOrderByPriceDesc();

    List<Product> findAllByOrderByCreatedAtAsc();

    List<Product> findAllByOrderByCreatedAtDesc();

    List<Product> findAllByIdNot(Long id);
}
