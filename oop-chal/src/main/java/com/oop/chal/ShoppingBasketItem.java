package com.oop.chal;

public class ShoppingBasketItem {
    private Product product;
    private int quantity;

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public ShoppingBasketItem(Product product, int quantity) { 
        this.product = product; 
        this.quantity = quantity; 
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public void decrementQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
        }
    }

    @Override
    public String toString() {
        return String.format("Product: %s | Quantity: %d", product.getName(), quantity);
    }

}
