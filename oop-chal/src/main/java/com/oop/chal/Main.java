package com.oop.chal;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ShoppingBasket basket = new ShoppingBasket(new ArrayList<>(), LocalDateTime.now());
        ProductCatalog catalog = new ProductCatalog();

        Product prod1 = catalog.getProducts().get(0);
        Product prod2 = catalog.getProducts().get(1);
        Product prod3 = catalog.getProducts().get(2);

        basket.addItem(prod1, 1);
        basket.addItem(prod2, 1);
        basket.addItem(prod3, 2);

        printBaskedContents(basket);

        basket.addItem(prod3, 1);

        printBaskedContents(basket);

        basket.removeItem(prod2);

        printBaskedContents(basket);

        basket.saveBasket();

        System.out.println("Basket valid? : " + basket.isPriceValid());



    }

    static void printBaskedContents(ShoppingBasket basket){

        System.out.println("-".repeat(25));

        System.out.println("    BASKET CONTENTS    \n");

        for (ShoppingBasketItem item : basket.getItems()) {
            System.out.println(item.toString());
        }

        System.out.println("\n" + "-".repeat(25) + "\n");


    }
}