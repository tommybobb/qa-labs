package com.oop.chal.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.oop.chal.dao.ProductDAO;
import com.oop.chal.dao.ShoppingBasketDAO;
import com.oop.chal.dao.ShoppingBasketItemDAO;
import com.oop.chal.entity.Product;
import com.oop.chal.entity.ShoppingBasket;
import com.oop.chal.entity.ShoppingBasketItem;
import com.oop.chal.utils.Result;

public class ShoppingBasketService  {
    
    private final ShoppingBasketDAO basketDAO = new ShoppingBasketDAO();
    private final ShoppingBasketItemDAO itemDAO = new ShoppingBasketItemDAO();
    private final ProductDAO productDAO = new ProductDAO();

    public Result<ShoppingBasket> createBasket() {
        try {
            ShoppingBasket basket = new ShoppingBasket(new ArrayList<>(), LocalDateTime.now());
            int basketId = basketDAO.insertBasket(basket);
            
            if (basketId == -1) {
                return Result.failure("Failed to create basket in database");
            }
            
            return Result.success(basket);
            
        } catch (SQLException e) {
            return Result.failure("Database error: " + e.getMessage());
        }
    }


    public Result<Void> addItemToBasket(int basketId, int productId, int quantity) {
        try {
            ShoppingBasket basket = basketDAO.findById(basketId);
            if (basket == null) {
                return Result.failure("Basket not found");
            }
            
            if (basket.getProcessed()) {
                return Result.failure("Cannot modify processed basket");
            }
            
            Product product = productDAO.findById(productId);
            if (product == null) {
                return Result.failure("Product not found");
            }


            ShoppingBasketItem existingItem = basket.getItems().stream()
                .filter(item -> item.getProductId() == productId)
                .findFirst()
                .orElse(null);

            if(existingItem != null){

                existingItem.setQuantity(existingItem.getQuantity() + quantity);
                itemDAO.updateItem(existingItem);

            } else {

                ShoppingBasketItem newItem = new ShoppingBasketItem();
                newItem.setBasketId(basketId);
                newItem.setProductId(productId);
                newItem.setQuantity(quantity);
                
                int itemId = itemDAO.insertItem(newItem, basketId);
                if (itemId == -1) {
                    return Result.failure("Failed to save item to database");
                }

            }
            
            
            basketDAO.updateBasket(basket);
            
            return Result.success(null);
            
        } catch (SQLException e) {
            return Result.failure("Database error: " + e.getMessage());
        } catch (Exception e) {
            return Result.failure("Error: " + e.getMessage());
        }
    }



    public String getFormattedBasketItems(int basketId)  {
        StringBuilder formatted = new StringBuilder();
        
        try {
            ShoppingBasket basket = basketDAO.findById(basketId);
            if (basket == null) {
                return "Basket not found.";
            }
            
            if (basket.getItems().isEmpty()) {
                return "Basket is empty.";
            }
            
            formatted.append("Shopping Basket Items (ID: ").append(basketId).append(")\n");
            formatted.append("Owner: ").append(basket.getOwner()).append("\n");
            formatted.append("Created: ").append(basket.getSavedTime()).append("\n");
            formatted.append("Processed: ").append(basket.getProcessed() ? "Yes" : "No").append("\n\n");
            
            formatted.append("Items:\n");
            formatted.append("-".repeat(60)).append("\n");
            
            BigDecimal totalValue = BigDecimal.ZERO;
            
            for (ShoppingBasketItem item : basket.getItems()) {
                Product product = productDAO.findById(item.getProductId());
                if (product != null) {
                    BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
                    totalValue = totalValue.add(itemTotal);
                    
                    formatted.append(String.format("%-30s | Qty: %3d | Price: £%8.2f | Total: £%8.2f%n",
                        product.getName(),
                        item.getQuantity(),
                        product.getPrice(),
                        itemTotal));
                }
            }
            
            formatted.append("-".repeat(60)).append("\n");
            formatted.append(String.format("Total Basket Value: £%.2f%n", totalValue));
            
        } catch (SQLException e) {
            return "Error retrieving basket items: " + e.getMessage();
        }
        
        return formatted.toString();
    }

}
