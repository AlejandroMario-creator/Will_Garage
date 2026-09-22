package com.willgarage.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willgarage.api.entity.Product;

public interface  ProductRepository extends JpaRepository<Product, Long> {
    boolean existsBySku(String sku);
}
