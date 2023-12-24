/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.ooc.ca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author zhiya
 */

public class DatabaseReader extends Database{
    
    public ArrayList<Customer> getAllData() {
        ArrayList<Customer> customerList = new ArrayList<>();

        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet results = stmt.executeQuery(String.format("SELECT * FROM %s;", TABLE_NAME));

            // Iterate through the result set and crea

            // Iteratete Customer objects
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                int phone = results.getInt("phone");
                int gross = results.getInt("gross");
                int taxOwned = results.getInt("taxowned");
                
                
                
                
                // Assuming Customer has a constructor that takes id and name as parameters
                Customer customer = new Customer(id,name,phone,gross,taxOwned);
                
                // Add the customer to the list
                customerList.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        
        return customerList; 

    }

    
}