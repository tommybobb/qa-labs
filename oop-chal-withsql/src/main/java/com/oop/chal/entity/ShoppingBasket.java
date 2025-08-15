package com.oop.chal.entity;

import java.time.LocalDateTime;
import java.util.List;

public class ShoppingBasket {
    private int id;
    private List<ShoppingBasketItem> items;
    private LocalDateTime savedTime;
    private boolean processed;
    private String owner;

    public ShoppingBasket() {

    }

    public ShoppingBasket(List<ShoppingBasketItem> items, LocalDateTime savedTime) {
        this.items = items;
        this.savedTime = savedTime;
        this.processed = false;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public List<ShoppingBasketItem> getItems() { return items; }
    public void setItems(List<ShoppingBasketItem> items) { this.items = items; }
    public LocalDateTime getSavedTime() { return savedTime; }
    public void setSavedTime(LocalDateTime savedTime) { this.savedTime = savedTime; }
    public boolean getProcessed() {return processed;}
    public void setProcessed(boolean processed) {this.processed = processed;}
    public String getOwner() {return owner;}
    public void setOwner(String owner) {this.owner = owner;}

    public void addItem(Product product, int quantity){
        
        for (ShoppingBasketItem item : items) {
            if (item.getId() == product.getId()) {
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
