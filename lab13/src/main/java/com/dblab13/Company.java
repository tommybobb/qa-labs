package com.dblab13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Company {
    private int companyNo;
    private String companyName;
    private String tel;
    private String county;
    private String postCode;

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=qastore;user=bob;password=password1;encrypt=false;";

    public Company() {}
    
    public Company(int companyNo, String companyName, String tel, String county, String postCode) {
        this.companyNo = companyNo;
        this.companyName = companyName;
        this.tel = tel;
        this.county = county;
        this.postCode = postCode;
    }

    public int getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(int companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }



    public boolean insert() {
        String sql = "INSERT INTO company (company_no, company_name, tel, county, post_code) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, this.companyNo);
            pstmt.setString(2, this.companyName);
            pstmt.setString(3, this.tel);
            pstmt.setString(4, this.county);
            pstmt.setString(5, this.postCode);
            
            int result = pstmt.executeUpdate();
            return result > 0;
            
        } catch (SQLException e) {
            System.err.println("Error inserting company: " + e.getMessage());
            return false;
        }
    }

    public boolean update() {
        String sql = "UPDATE company SET company_name = ?, tel = ?, county = ?, post_code = ? WHERE company_no = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, this.companyName);
            pstmt.setString(2, this.tel);
            pstmt.setString(3, this.county);
            pstmt.setString(4, this.postCode);
            pstmt.setInt(5, this.companyNo);
            
            int result = pstmt.executeUpdate();
            return result > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updating company: " + e.getMessage());
            return false;
        }
    }

    public boolean delete() {
        String sql = "DELETE FROM company WHERE company_no = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, this.companyNo);
            
            int result = pstmt.executeUpdate();
            return result > 0;
            
        } catch (SQLException e) {
            System.err.println("Error deleting company: " + e.getMessage());
            return false;
        }
    }

    public static Company findByCompanyNo(int companyNo) {
        String sql = "SELECT * FROM company WHERE company_no = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, companyNo);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Company(
                        rs.getInt("company_no"),
                        rs.getString("company_name"),
                        rs.getString("tel"),
                        rs.getString("county"),
                        rs.getString("post_code")
                    );
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error finding company: " + e.getMessage());
        }
        
        return null;
    }

    
}