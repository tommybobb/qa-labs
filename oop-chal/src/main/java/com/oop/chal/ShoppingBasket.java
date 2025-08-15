package com.oop.chal;

import java.time.LocalDateTime;
import java.util.List;

public class ShoppingBasket {
    private List<ShoppingBasketItem> items;
    private LocalDateTime savedTime;

    public ShoppingBasket(List<ShoppingBasketItem> items, LocalDateTime savedTime) {
        this.items = items;
        this.savedTime = savedTime;
    }

    public List<ShoppingBasketItem> getItems() { return items; }
    public void setItems(List<ShoppingBasketItem> items) { this.items = items; }
    public LocalDateTime getSavedTime() { return savedTime; }
    public void setSavedTime(LocalDateTime savedTime) { this.savedTime = savedTime; }

    public void addItem(Product product, int quantity){
        
        for (ShoppingBasketItem item : items) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        items.add(new ShoppingBasketItem(product, quantity));
    }

    public void removeItem(Product product) {

        for (ShoppingBasketItem item : items) {
            if (item.getProduct().equals(product)) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                } else {
                    items.remove(item);
                }
                return;
            }
        }

        throw new IllegalArgumentException("Product not found in basket.");
    }

    public void clearBasket(){
        if(items.isEmpty()){
            throw new IllegalArgumentException("Basket is empty already!");
        }

        items.clear();
    }

    public void saveBasket(){
        this.savedTime = LocalDateTime.now();

        System.out.println("Basket saved at:" + this.savedTime);
    }

    public boolean isPriceValid() {
        
        if (this.savedTime == null) {
            throw new IllegalArgumentException("Basket hasnt been updated yet");
        }

        return LocalDateTime.now().minusDays(1).isBefore(this.savedTime);
    }


}
