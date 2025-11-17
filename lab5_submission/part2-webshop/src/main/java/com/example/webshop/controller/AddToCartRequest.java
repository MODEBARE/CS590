package com.example.webshop.controller;

public class AddToCartRequest {
    private String productNumber;
    private int quantity;

    public AddToCartRequest() {
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
