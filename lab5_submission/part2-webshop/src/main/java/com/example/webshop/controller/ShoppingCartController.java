package com.example.webshop.controller;

import com.example.webshop.domain.ShoppingCart;
import com.example.webshop.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingcarts")
public class ShoppingCartController {

    private final ShoppingCartService service;

    public ShoppingCartController(ShoppingCartService service) {
        this.service = service;
    }

    @PostMapping("/{cartId}/items")
    public ShoppingCart addToShoppingCart(@PathVariable String cartId,
                                          @RequestBody AddToCartRequest request) {
        return service.addToShoppingCart(cartId, request.getProductNumber(), request.getQuantity());
    }

    @GetMapping("/{cartId}")
    public ShoppingCart getShoppingCart(@PathVariable String cartId) {
        return service.getShoppingCart(cartId);
    }
}
