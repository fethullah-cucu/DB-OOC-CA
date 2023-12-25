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
        ArrayList<Customer> customerList = new ArrayList<>(); // we are creating 

        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet results = stmt.executeQuery(String.format("SELECT * FROM %s;", TABLE_NAME));


            //call the costumers from database and assign into variables.
            while (results.next()) { 
                int id = results.getInt("id"); 
                String name = results.getString("name"); 
                int phone = results.getInt("phone");
                int gross = results.getInt("gross");
                int taxOwned = results.getInt("taxowned");
                String customerPassword = results.getString("password");

                Customer customer = new Customer(id,name,phone,gross,taxOwned,customerPassword); 
                                                                                            
                
                // Add the customers into ArrayList
                customerList.add(customer); // we are adding all of customer objects into a customer object list. 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return customerList; // when we run this mehtod, it will return the list we got from the file. 
    }

    
}