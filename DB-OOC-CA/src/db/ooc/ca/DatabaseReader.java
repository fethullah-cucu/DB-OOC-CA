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

            // Iterate through the result set and crea

            // Iteratete Customer objects
            while (results.next()) { //while : it is a loop. loops stop till conditions (paranteses) return "false". next() method is reading lines from files
                                                //if there is no "next line" it return false. when it return false, loop stops. 
                int id = results.getInt("id"); //we are taking id part of the line and assign the value to id variable.
                String name = results.getString("name"); // same with above comment.
                int phone = results.getInt("phone");
                int gross = results.getInt("gross");
                int taxOwned = results.getInt("taxowned");
                String customerPassword = results.getString("password");
                
                
                
                // Assuming Customer has a constructor that takes id and name as parameters
                Customer customer = new Customer(id,name,phone,gross,taxOwned,customerPassword); 
                                                                                            // we are creating customer object and add the information we got
                                                                                                            //from file by loop. 
                
                // Add the customer to the list
                customerList.add(customer); // we are adding all of customer objects into a customer object list. 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return customerList; // when we run this mehtod, it will return the list we got from the file. 
    }

    
}