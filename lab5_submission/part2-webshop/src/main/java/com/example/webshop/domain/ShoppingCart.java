package com.example.webshop.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "shoppingcarts")
public class ShoppingCart {

    @Id
    private String shoppingcartNumber;
    private List<CartLine> lines = new ArrayList<>();

    public ShoppingCart() {
    }

    public ShoppingCart(String shoppingcartNumber) {
        this.shoppingcartNumber = shoppingcartNumber;
    }

    public String getShoppingcartNumber() {
        return shoppingcartNumber;
    }

    public void setShoppingcartNumber(String shoppingcartNumber) {
        this.shoppingcartNumber = shoppingcartNumber;
    }

    public List<CartLine> getLines() {
        return lines;
    }

    public void setLines(List<CartLine> lines) {
        this.lines = lines;
    }

    public void addToCart(String productNumber, int quantity) {
        for (CartLine line : lines) {
            if (line.getProductNumber().equals(productNumber)) {
                line.setQuantity(line.getQuantity() + quantity);
                return;
            }
        }
        lines.add(new CartLine(productNumber, quantity));
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingcartNumber='" + shoppingcartNumber + '\'' +
                ", lines=" + lines +
                '}';
    }
}
