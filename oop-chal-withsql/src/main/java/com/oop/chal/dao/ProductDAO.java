package com.oop.chal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oop.chal.config.DatabaseConfig;
import com.oop.chal.entity.Product;

public class ProductDAO {
    

    public Product findById(int productId) throws SQLException {
        String sql = "SELECT * FROM Products WHERE Id = ?";
        
        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword());
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, productId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Product product = new Product();

                    product.setId(rs.getInt("Id"));
                    product.setName(rs.getString("Name"));
                    product.setPrice(rs.getBigDecimal("Price")); 

                    return product;
                }
            }
        }
        return null;
    }


}
