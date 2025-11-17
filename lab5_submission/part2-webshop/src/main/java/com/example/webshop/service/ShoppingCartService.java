package com.example.webshop.service;

import com.example.webshop.domain.ShoppingCart;
import com.example.webshop.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository cartRepo;
    private final ProductService productService;

    public ShoppingCartService(ShoppingCartRepository cartRepo,
                               ProductService productService) {
        this.cartRepo = cartRepo;
        this.productService = productService;
    }

    public ShoppingCart addToShoppingCart(String cartId, String productNumber, int quantity) {
        productService.getProduct(productNumber);

        ShoppingCart cart = cartRepo.findById(cartId)
                .orElseGet(() -> new ShoppingCart(cartId));

        cart.addToCart(productNumber, quantity);
        return cartRepo.save(cart);
    }

    public ShoppingCart getShoppingCart(String cartId) {
        return cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }
}
