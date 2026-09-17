package com.willgarage.api.service;

import com.willgarage.api.entity.Product;
import com.willgarage.api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listarProductos() {
        return productRepository.findAll();
    }

    public Product crearProducto(Product product) {

    if (productRepository.existsBySku(product.getSku())) {
        throw new IllegalArgumentException("Ya existe un producto con el SKU: " + product.getSku());
    }
    return productRepository.save(product);
    }

}