package com.oop.chal;

import com.oop.chal.entity.ShoppingBasket;
import com.oop.chal.service.ShoppingBasketService;
import com.oop.chal.utils.Result;

public class MainSql {
    

    public static void main(String[] args) {
        
        ShoppingBasketService basketService = new ShoppingBasketService();

        Result<ShoppingBasket> basketResult = basketService.createBasket();
        if(basketResult.isFailure()){
            System.out.println("Failed to create basked: " + basketResult.getError());
            return;
        }

        ShoppingBasket basket = basketResult.getValue();

        int basketId = basket.getId();
        System.err.println("Basket Created with ID: " + basketId);


        Result item1 = basketService.addItemToBasket(basketId, 1,2);
        if(item1.isFailure()){
            System.out.println("Unable to add item into basket: " + item1.getError());
        }

        Result item12 = basketService.addItemToBasket(basketId, 3,5);
        if(item12.isFailure()){
            System.out.println("Unable to add item into basket: " + item1.getError());
        }


        Result item13 = basketService.addItemToBasket(basketId, 2,1);
        if(item13.isFailure()){
            System.out.println("Unable to add item into basket: " + item1.getError());
        }


        Result item14 = basketService.addItemToBasket(basketId, 2,8);
        if(item14.isFailure()){
            System.out.println("Unable to add item into basket: " + item1.getError());
        }



        String basketDisplay = basketService.getFormattedBasketItems(basketId);
        System.out.println(basketDisplay);

    }


}
