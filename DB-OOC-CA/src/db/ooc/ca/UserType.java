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
public class UserType { //class starts.
    private Scanner input = new Scanner(System.in);
    private boolean exit = false;
    private int mainChoice;
    public int userType;
    
    public void UserType(){ // constructer method starts.
        
        while (!exit){ 
        System.out.println("what kind of user are you ?\n1-Admin\n2-Regular");
        userType = input.nextInt();
        input.nextLine();//to stop loop bug
        
       userTypeCheck();
        
          try{
              
        switch (userType){
            
            case 1: //admin menu
                System.out.println("1-list all \n2-add user \n3-modify by id number \n4-remove user ");
                int userChoise = input.nextInt();
                input.nextLine();
                
                
                
                    switch(userChoise){
                        case 1: //List all user
                            DatabaseReader databaseReader = new DatabaseReader();
                            for (Customer customer : databaseReader.getAllData()){
            System.out.println(customer.getCustomerID() + " - " 
                    + customer.getName() + " - " 
                    + customer.getPhone() + " - " 
                    + customer.getGross() + " - "
                    +customer.getTaxOwned() + " - "
                    +customer.getCustomerPassword()
                                    );  
            }   

                            System.out.println("do you want to get in main menu ? \n1-yes\n 2-no");
                            mainChoice = input.nextInt();
                            if (mainChoice == 1){
                                continue;
                            
                            }else if (mainChoice == 2){
                                exit = true;
                            }
                            
                            break;
                        
                        
                        case 2: //Add user
                            
                            System.out.println("name of the costumer");
                            String name = input.nextLine();
                            
                            System.out.println("what is the password of the user?");
                            String password = input.nextLine();
                            System.out.println("phone number of the customer");
                            int phone = input.nextInt();
                            System.out.println("customer gross salary");
                            int gross = input.nextInt();
                            
                        
                        
                            Customer customer = new Customer(name,phone,gross,password);
                        DatabaseWriter databaseWriter = new DatabaseWriter();
                            databaseWriter.addCostumer(customer);
                            
                        System.out.println("do you want to get in main menu ? \n1-yes\n 2-no");
                            mainChoice = input.nextInt();
                            if (mainChoice == 1){
                                continue;
                            
                            }else if (mainChoice == 2){
                                exit = true;
                            }
                        break;
                    case 3: //Modify User
                        
                        System.out.println("what is ID of the user");
                            int userID = input.nextInt();
                            input.nextLine();
                        System.out.println("what is the column name you want to change?id , name, phone , gross, password");
                            String COLUMN_NAME = input.nextLine();
                        System.out.println("what is new value of the column ?");
                            String userValue = input.nextLine();
                        
                        
                        DatabaseUpdate databaseUpdate = new DatabaseUpdate(userID,COLUMN_NAME,userValue);
                        System.out.println("user updated");
                        System.out.println("do you want to get in main menu ? \n1-yes\n 2-no");
                            mainChoice = input.nextInt();
                            if (mainChoice == 1){
                                continue;
                            
                            }else if (mainChoice == 2){
                                exit = true;
                            }
                        break;
                    case 4:// remove User
                        System.out.println("what is the id of the customer you want to remove?");
                            int userId = input.nextInt();
                        DatabaseRemover databaseRemover = new DatabaseRemover(userId);
                        System.out.println("it deleted");
                        System.out.println("do you want to get in main menu ? \n1-yes\n 2-no");
                            mainChoice = input.nextInt();
                            if (mainChoice == 1){
                                continue;
                            
                            }else if (mainChoice == 2){
                                exit = true;
                            }
                        break;

                                    
                }

                break;
            case 2://regular user 
                System.out.println("1-new user\n2-modify account ");
                int userChoise3 = input.nextInt();
                input.nextLine();
                switch (userChoise3){
                    case 1: // add new user 
                        System.out.println("name of the costumer");
                            String name = input.nextLine();
                        System.out.println("what is the password of the user?");
                            String password = input.nextLine();
                        System.out.println("phone number of the customer");
                            int phone = input.nextInt();
                        System.out.println("customer gross salary");
                            int gross = input.nextInt();
                
                        Customer customer = new Customer(name,phone,gross,password);
                            DatabaseWriter databaseWriter = new DatabaseWriter();
                            databaseWriter.addCostumer(customer);
                  System.out.println("do you want to get in main menu ? \n1-yes\n 2-no");
                            mainChoice = input.nextInt();
                            if (mainChoice == 1){
                                continue;
                            
                            }else if (mainChoice == 2){
                                exit = true;
                            }        
                  break;
                    case 2:// modify user 
                        
                        Integer userID = userTypeCheck2();
                        
                        
                        System.out.println("what is the column name you want to change?");
                        String COLUMN_NAME = input.nextLine();
                        
                        System.out.println("what is new value of the column ?");
                        String userValue = input.nextLine();
                        
                        
                        DatabaseUpdate databaseUpdate = new DatabaseUpdate(userID,COLUMN_NAME,userValue);
                        System.out.println("user updated");
                        
                        
                        
                        System.out.println("do you want to get in main menu ? \n1-yes\n 2-no");
                            mainChoice = input.nextInt();
                            if (mainChoice == 1){
                                continue;
                                
                            }else if (mainChoice == 2){
                                exit = true;
                            }     
                            break;
                    
                }
                
                
                exit = true;
                break;
        
        
        }
          }catch (Exception e){
              System.out.println("we get an error. pls try again. ");
              System.out.println(e);
          }
      }
    }
    
    
    
    public void userTypeCheck(){

        
        boolean exit2= false;
        String adminName = "CCT";
        String adminPassword = "Dublin";
        while(!exit2){
            if ( userType == 1){
                System.out.println("what is the name of admin account? if you don't know, write 'no' fot go to main menu.");
                String adminNameCheck = input.nextLine();
                
                if(adminNameCheck.equals("no")){
                
                UserType();
                }
                
                System.out.println("what is the password of admin account? ");
                String adminPasswordCheck = input.nextLine();
                    
                if (adminNameCheck.equals(adminName) && adminPasswordCheck.equals(adminPassword)){
                    exit2= true;
                    
                }else {
                    System.out.println("admin id or password is wrong. try again pls.");
                    
                }}else{
                            break;}
            
        }
        
        
        exit2= true;
        if ( userType == 2){
            
            
                while(!exit2){
                System.out.println("what is  id ?");
                int customerIDCheck = input.nextInt();
                input.nextLine();
                
                
                System.out.println("what is  password?");
                String customerPasswordCheck = input.nextLine();
                
                    DatabaseReader databaseReader = new DatabaseReader();
                    
                for (Customer customer : databaseReader.getAllData()){
                                if (customer.getCustomerID() == customerIDCheck && customer.getCustomerPassword() == customerPasswordCheck){
                                    
                                    exit2=true;
                                    
                                }else{
                                    System.out.println("password or id is wrong. try again.");
                                }
                            }
                        }
                exit2= true;
                    }}
        
        private boolean exit3 = false;
        public int userTypeCheck2(){
        
                while(!exit3){
                     System.out.println("what is ID of the user");
                        Integer userID = input.nextInt();
                        input.nextLine();
                        
                        System.out.println("what is your password? ");
                        String userPassword = input.nextLine();
                
                    DatabaseReader databaseReader = new DatabaseReader();

                for (Customer customer : databaseReader.getAllData()){
                                if (userID.equals(customer.getCustomerID() ) &&  userPassword.equals(customer.getCustomerPassword())){
                                    System.out.println("id/password correct");
                                    exit3=true;
                                    return userID;
                                }          
                }
                if (!exit3) {
                        System.out.println("password is wrong");
                        
                                        }           

                        }
                exit3= true;
return 0;
        }

            }
    
    
    
    
    
    
    
    

