/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.ooc.ca;

import java.util.Scanner;

/**
 *
 * @author canif
 */
public class UserType { 
    Scanner input = new Scanner(System.in);
    
    public UserType(int userType){
        
        
      while (true){ 
          try{
              
              
        switch (userType){
            
            case 1:
                System.out.println("1-list all \n2-add user \n3-modify by id number \n4-remove user");
                int userChoise = input.nextInt();
                switch(userChoise){
                    case 1:
                        DatabaseReader databaseReader = new DatabaseReader();
                        for (Customer customer : databaseReader.getAllData()){
                            System.out.println(customer);
                        }

                        break;
                    case 2:
                        System.out.println("name of the costumer");
                        String name = input.nextLine();
                        System.out.println("customer phone namber");
                        int phone = input.nextInt();
                        System.out.println("customer gross salary");
                        int gross = input.nextInt();
                            
                        
                        
                            Customer customer = new Customer(name,phone,gross);
                        DatabaseWriter databaseWriter = new DatabaseWriter();
                            databaseWriter.addPatient(customer);
                        
                        break;
                    case 3:
                        
                        System.out.println("what is ID of the user");
                        int userID = input.nextInt();
                        System.out.println("what is the column name you want to change?");
                        String COLUMN_NAME = input.nextLine();
                        System.out.println("what is new value of the column ?");
                        String userValue = input.nextLine();
                        
                        
                        DatabaseUpdate databaseUpdate = new DatabaseUpdate(userID,COLUMN_NAME,userValue);
                        System.out.println("user updated");
                        
                        break;
                    case 4:
                        System.out.println("what is the id of the customer you want to remove?");
                        int userId = input.nextInt();
                        DatabaseRemover databaseRemover = new DatabaseRemover(userId);
                        System.out.println("it deleted");
                        break;

                }

                break;
            case 2:
                System.out.println("1-new user\n2-modify account ");
                
                // burdan devam et
                
                break;
        
        
        }
          }catch (Exception e){
              System.out.println("we get an error. pls try again. ");
              System.out.println(e);
              
          
          }
      }
    
    
    
    
    }
    
    
    
    
    
}
