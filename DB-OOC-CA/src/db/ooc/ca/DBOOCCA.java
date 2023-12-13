/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package db.ooc.ca;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author canif
 */
public class DBOOCCA {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    
    DatabaseSetup db = new DatabaseSetup();
    
    DatabaseSetup.databaseSetup();
        
         //Scanner input = new Scanner(System.in);
         //System.out.println("which type of user are you ? \n 1-Admin \n2-Regular");
         //int userChoise = input.nextInt();

        //UserType user = new UserType(userChoise);
        
    
    
    }
}

