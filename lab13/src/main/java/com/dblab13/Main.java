package com.dblab13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {

    
   public static void main(String[] args) {
        //new MSSQLExample().read();

        int result = new MSSQLExample().write();
        
        System.out.println(result);

        new MSSQLExample().read();
   }
}




class MSSQLExample {
    
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=qastore;user=bob;password=password1;encrypt=false;";

    public int write(){

        StringBuilder out = new StringBuilder() ;
        
        try (Connection conn = DriverManager.getConnection(url)) {
            
            int companyNo = 5000;
            String companyName = "Bob Ross Ltd";
            String tel = "+447123456789";
            String county = "suffolk";
            String postcode = "IP1 6FH";

            String sql = "INSERT INTO company (company_no, company_name, tel, county, post_code) VALUES (?, ?, ?, ?, lik?)";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, companyNo);
                pstmt.setString(2, companyName);
                pstmt.setString(3, tel);
                pstmt.setString(4, county);
                pstmt.setString(5, postcode);
                
                return pstmt.executeUpdate();
            }   

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        

    }

    public void read() {
        
        // PART 1
        //  try (Connection conn = DriverManager.getConnection(url); 
        //      Statement stmt = conn.createStatement()) {
        //     String query = "SELECT emp_no, description FROM sale WHERE emp_no = 60";
        //     ResultSet rs = stmt.executeQuery(query);
        //     while (rs.next()) {
        //         System.out.println(rs.getString(1)+ "," + rs.getString("description"));
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }


        //PART 2
        // StringBuilder out = new StringBuilder() ;
        
        // try (Connection conn = DriverManager.getConnection(url); //, user, password);
        //      Statement stmt = conn.createStatement()) {

        //     String query = "SELECT * FROM company where county='London'";
        //     ResultSet rs = stmt.executeQuery(query);
            
        //     while (rs.next()) {
        //     	int id = rs.getInt(1);
        //     	String name = rs.getString(2);
        //     	out.append(String.format("No: %-7d| Company name:%-25s|\n",id,name) );
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        
        // System.out.println(out.toString());


        //PART 3
        StringBuilder out = new StringBuilder() ;
        
        try (Connection conn =         
               DriverManager.getConnection(url); 
             Statement stmt = conn.createStatement()) {

        String sql = "select company_no, company_name, post_code, county " + "from company " ;

        PreparedStatement ps = conn.prepareStatement(sql) ;
        //ps.setString(1,"London"); 	// the first ?     (city)	
        //ps.setString(2,"N%");		     // second ?	 (contactName)
        
        ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            out.append(String.format("No: %-7d| Company name:%-25s|\n",id,name) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(out.toString());
    }



    
}
