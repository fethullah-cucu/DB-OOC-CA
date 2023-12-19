/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.ooc.ca;

import static db.ooc.ca.Database.DB_BASE_URL;
import static db.ooc.ca.Database.DB_NAME;
import static db.ooc.ca.Database.PASSWORD;
import static db.ooc.ca.Database.USER;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author canif
 */
public class DatabaseSetup extends Database{
    
    
 
    
   public static boolean databaseSetup() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        System.out.println("Connecting to database...");

        try(
                Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
                

                Statement stmt = conn.createStatement();
            ){
            System.out.println("try worked.");
            
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
            stmt.execute("USE " + DB_NAME + ";");
            String sql = 
                    "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + "id INT(10) PRIMARY KEY AUTO_INCREMENT ,"
                    + "name VARCHAR(255),"
                    + "phone INT(10),"
                    + "gross INT(10),"
                    + "taxowned INT(10),"
                    + "password VARCHAR(50)"
                    + ");";
            stmt.execute(sql);
            System.out.println("Table created successfully.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
