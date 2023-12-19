/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.ooc.ca;

import static db.ooc.ca.Database.DB_URL;
import static db.ooc.ca.Database.PASSWORD;
import static db.ooc.ca.Database.TABLE_NAME;
import static db.ooc.ca.Database.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author canif
 */
public class DatabaseUpdate extends Database{
    
    private static String password;
    public DatabaseUpdate(int userID ,String COLUMN_NAME,String userValue) throws SQLException{
        
        String userIDString = Integer.toString(userID);
        
        DatabaseReader databaseReader = new DatabaseReader();
        for(Customer customer : databaseReader.getAllData()){
            if (customer.getCustomerPassword().equals(password)){
                continue;
            
            }else{
            
                System.out.println("password is wrong");
            
            }
                    
            }
        
        
        
        
        
    try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
        int results = stmt.executeUpdate(String.format("UPDATE %s.%s "
                + "SET %s = '%s' "
                + "WHERE id = '%s';",
                DB_NAME, TABLE_NAME, COLUMN_NAME, userValue, userIDString));

    }

    
    }
}
