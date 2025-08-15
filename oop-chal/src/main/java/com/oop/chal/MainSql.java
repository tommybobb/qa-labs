package com.oop.chal;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainSql {
    

    public static void main(String[] args) {
        
        try {
            ShoppingBasket basket = createBasket();

            if (basket == null) {
                System.out.println("Unable to create basket");
            }
            

            System.out.println("All done basketid = " + basket.getId());

            
            
        } catch (Exception e) {
            System.err.println("Application error: " + e.getMessage());
        }


    }

    private static ShoppingBasket createBasket() {
        try {
            ShoppingBasket basket = new ShoppingBasket(new ArrayList<>(), LocalDateTime.now());
            int basketId = basket.insertBasketIntoDb(basket);
            
            if (basketId == -1) {
                System.err.println("Failed to create basket");
                return null;
            }
            
            System.out.println("Basket created with ID: " + basketId);
            return basket;
            
        } catch (SQLException e) {
            System.err.println("Database error creating basket: " + e.getMessage());
            return null;
        }
    }
}
