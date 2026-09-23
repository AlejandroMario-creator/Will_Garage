package com.willgarage.api.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willgarage.api.entity.Product;

public interface  ProductRepository extends JpaRepository<Product, Long> {
    boolean existsBySku(String sku);
    List<Product> findByActiveTrue();
    Optional<Product> findByIdAndActiveTrue(Long id);
}
