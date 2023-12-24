/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.ooc.ca;

import static db.ooc.ca.Database.TABLE_NAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author canif
 */
public class DatabaseWriter extends Database{
    
    public boolean addCostumer(Customer customer) throws SQLException {
        try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ){
            System.out.println("addCostumer try worked");
                                                                                                                //with that way, we are specify the column names with variables.
            String sql = String.format("INSERT INTO " + TABLE_NAME + " (name, phone, gross, taxOwned,password) VALUES ('%s', '%d', '%d', '%f','%s');",
    customer.getName(), customer.getPhone(), customer.getGross(), customer.getTaxOwned(),customer.getCustomerPassword());

            stmt.execute(sql);
            String columnName = "id";
            ResultSet results = stmt.executeQuery(String.format("SELECT %s FROM "
                    + "%s ORDER BY %s DESC LIMIT 1;",
                    columnName,TABLE_NAME, columnName));
            
            
            if (results.next()) {
                int lastId = results.getInt(columnName);
                System.out.println("Customer user ID: " + lastId);
            } else {
                System.out.println("No data found.");
            }
            
            System.out.println("add addCostumer finished.");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    
    
    
}
