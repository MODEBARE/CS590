package com.example.webshop.client;

import com.example.webshop.controller.AddToCartRequest;
import com.example.webshop.domain.Product;
import com.example.webshop.domain.ShoppingCart;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClientRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "http://localhost:8080";

        // 1. Add new product
        Product newProduct = new Product("P100", "Test Product", 19.99);
        Product created = restTemplate.postForObject(baseUrl + "/products", newProduct, Product.class);
        System.out.println("Created product: " + created);

        // 2. Get product and print
        Product fetched = restTemplate.getForObject(baseUrl + "/products/P100", Product.class);
        System.out.println("Fetched product: " + fetched);

        // 3. Add product to cart
        String cartId = "CART1";
        AddToCartRequest request = new AddToCartRequest();
        request.setProductNumber("P100");
        request.setQuantity(2);

        ShoppingCart cart = restTemplate.postForObject(
                baseUrl + "/shoppingcarts/" + cartId + "/items",
                request,
                ShoppingCart.class
        );
        System.out.println("Cart after adding item: " + cart);

        // 4. Get cart and print
        ShoppingCart fetchedCart =
                restTemplate.getForObject(baseUrl + "/shoppingcarts/" + cartId, ShoppingCart.class);
        System.out.println("Fetched cart: " + fetchedCart);
    }
}
