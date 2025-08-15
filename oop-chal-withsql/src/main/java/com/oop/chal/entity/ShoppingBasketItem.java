package com.oop.chal.entity;

public class ShoppingBasketItem {
    private int id;    
    private int basketId;    
    private int productId;
    private Product product;
    private int quantity;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getBasketId() { return basketId; }
    public void setBasketId(int basketId) { this.basketId = basketId; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public ShoppingBasketItem() { 

    }

    public ShoppingBasketItem(Product product, int quantity) { 
        this.product = product; 
        this.productId = product.getId(); 
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
