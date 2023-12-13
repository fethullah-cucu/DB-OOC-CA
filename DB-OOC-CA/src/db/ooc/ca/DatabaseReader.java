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

public class DatabaseReader {
    private static final String DB_URL = "your_database_url";
    private static final String USER = "your_database_user";
    private static final String PASSWORD = "your_database_password";
    private static final String TABLE_NAME = "your_table_name";

    public ArrayList<Customer> getAllData() {
        ArrayList<Customer> customerList = new ArrayList<>();

        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet results = stmt.executeQuery(String.format("SELECT * FROM %s;", TABLE_NAME));

            // Iterate through the result set and create Customer objects
            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");

                // Assuming Customer has a constructor that takes id and name as parameters
                Customer customer = new Customer(id, name);
                
                // Add the customer to the list
                customerList.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return the list of customers
        return customerList;
    }

    // Assuming Customer class has a constructor like this
    private static class Customer {
        private int id;
        private String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}