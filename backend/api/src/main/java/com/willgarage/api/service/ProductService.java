package com.willgarage.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.willgarage.api.entity.Product;
import com.willgarage.api.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listarProductos() {
        return productRepository.findAll();
    }

    public Product listarPorId(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Producto no encontrado con id: " + id
                        )
                );
    }

    public Product crearProducto(Product product) {

        if (productRepository.existsBySku(product.getSku())) {
            throw new IllegalArgumentException(
                    "Ya existe un producto con el SKU: " + product.getSku()
            );
        }

        return productRepository.save(product);
    }

    public Product actualizarProducto(Long id, Product datos) {

        Product producto = listarPorId(id);

        if (!producto.getSku().equals(datos.getSku())
                && productRepository.existsBySku(datos.getSku())) {

            throw new IllegalArgumentException(
                    "Ya existe un producto con el SKU: " + datos.getSku()
            );
        }

        producto.setName(datos.getName());
        producto.setSku(datos.getSku());
        producto.setDescription(datos.getDescription());
        producto.setPrice(datos.getPrice());
        producto.setStock(datos.getStock());

        return productRepository.save(producto);
    }


}