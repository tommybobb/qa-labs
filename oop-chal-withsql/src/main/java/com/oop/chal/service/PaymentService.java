package com.oop.chal.service;

import com.oop.chal.entity.ShoppingBasket;

public class PaymentService {
    public boolean validateBasket(ShoppingBasket basket) {
        return basket != null && !basket.getItems().isEmpty() && basket.isPriceValid();
    }

    public void processPayment(ShoppingBasket basket) {

        if (!validateBasket(basket)) {
            throw new IllegalArgumentException ("Payment failed: Basket is invalid.");
        }

        System.out.println("Payment successful for basket with " + basket.getItems().size() + " items.");

    }
}
