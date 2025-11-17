package com.example.webshop.service;

import com.example.webshop.domain.Product;
import com.example.webshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product getProduct(String productNumber) {
        return repo.findById(productNumber)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
