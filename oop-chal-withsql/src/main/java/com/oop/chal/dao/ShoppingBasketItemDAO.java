package com.oop.chal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oop.chal.config.DatabaseConfig;
import com.oop.chal.entity.ShoppingBasketItem;

public class ShoppingBasketItemDAO {

    public int insertItem(ShoppingBasketItem item, int basketId) throws SQLException {
        String sql = "INSERT INTO ShoppingBasketItems (BasketId, ProductId, Quantity) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getUrl(), 
                DatabaseConfig.getUsername(), 
                DatabaseConfig.getPassword());
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setInt(1, basketId);
            pstmt.setInt(2, item.getProductId());
            pstmt.setInt(3, item.getQuantity());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        item.setId(generatedId);
                        return generatedId;
                    }
                }
            }
            return -1;
        }
    }

    public List<ShoppingBasketItem> getItemsByBasketId(int basketId) throws SQLException {
        String sql = "SELECT * FROM ShoppingBasketItems WHERE BasketId = ?";
        List<ShoppingBasketItem> items = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getUrl(), 
                DatabaseConfig.getUsername(), 
                DatabaseConfig.getPassword());
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, basketId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    items.add(mapResultSetToShoppingBasketItem(rs));
                }
            }
        }
        return items;
    }

    private ShoppingBasketItem mapResultSetToShoppingBasketItem(ResultSet rs) throws SQLException {
        ShoppingBasketItem item = new ShoppingBasketItem();
        item.setId(rs.getInt("Id"));
        item.setBasketId(rs.getInt("BasketId"));
        item.setProductId(rs.getInt("ProductId"));
        item.setQuantity(rs.getInt("Quantity"));
        return item;
    }

    public boolean updateItem(ShoppingBasketItem item) throws SQLException {
        String sql = "UPDATE ShoppingBasketItems SET Quantity = ? WHERE Id = ?";
        
        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, item.getQuantity());
            pstmt.setInt(2, item.getId());
            
            return pstmt.executeUpdate() > 0;
        }
    }

}
