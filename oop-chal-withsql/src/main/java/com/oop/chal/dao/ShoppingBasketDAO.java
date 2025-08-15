package com.oop.chal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import com.oop.chal.config.DatabaseConfig;
import com.oop.chal.entity.Product;
import com.oop.chal.entity.ShoppingBasket;
import com.oop.chal.entity.ShoppingBasketItem;

public class ShoppingBasketDAO {
    

    public int insertBasket(ShoppingBasket basket) throws SQLException {
        String sql = "INSERT INTO ShoppingBaskets (Owner, SavedTime, Processed) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getUrl(), 
                DatabaseConfig.getUsername(), 
                DatabaseConfig.getPassword());
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, "bob");
            pstmt.setTimestamp(2, Timestamp.valueOf(basket.getSavedTime()));
            pstmt.setBoolean(3, false);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        basket.setId(generatedId);
                        return generatedId;
                    }
                }
            }
            return -1;
        }
        
    }

    public int updateBasket(ShoppingBasket basket) throws SQLException {
        String sql = "UPDATE ShoppingBaskets SET SavedTime = ?, Processed = ? WHERE Id = ?";
        
        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getUrl(), 
                DatabaseConfig.getUsername(), 
                DatabaseConfig.getPassword());
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setTimestamp(1, Timestamp.valueOf(basket.getSavedTime()));
            pstmt.setBoolean(2, basket.getProcessed());
            pstmt.setInt(3, basket.getId());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        basket.setId(generatedId);
                        return generatedId;
                    }
                }
            }
            return -1;
        }
        
    }

    public ShoppingBasket findById(int basketId) throws SQLException {
        String sql = "SELECT * FROM ShoppingBaskets WHERE Id = ?";
        
        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getUrl(), 
                DatabaseConfig.getUsername(), 
                DatabaseConfig.getPassword());
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, basketId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ShoppingBasket basket = new ShoppingBasket();

                    basket.setId(rs.getInt("Id"));
                    basket.setSavedTime(rs.getTimestamp("SavedTime").toLocalDateTime());
                    basket.setOwner(rs.getString("Owner"));
                    basket.setProcessed(rs.getBoolean("Processed"));

                    ShoppingBasketItemDAO itemDAO = new ShoppingBasketItemDAO();
                    List<ShoppingBasketItem> items = itemDAO.getItemsByBasketId(basketId);
                    ProductDAO productDAO = new ProductDAO();

                    for (ShoppingBasketItem item : items) {
                        Product product = productDAO.findById(item.getProductId());
                        item.setProduct(product);
                    }

                    basket.setItems(items);

                    return basket;
                }
            }
        }
        return null;
    }
}
