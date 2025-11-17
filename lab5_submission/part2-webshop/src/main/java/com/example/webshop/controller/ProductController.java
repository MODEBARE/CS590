package com.example.webshop.controller;

import com.example.webshop.domain.Product;
import com.example.webshop.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping("/{productNumber}")
    public Product getProduct(@PathVariable String productNumber) {
        return service.getProduct(productNumber);
    }
}
