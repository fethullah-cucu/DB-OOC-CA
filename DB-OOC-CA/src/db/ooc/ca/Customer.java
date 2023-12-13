/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.ooc.ca;

import java.util.Scanner;

/**
 *
 * @author zhiya
 */
public class Customer {
    String name;
    private int customerID;
    private int currentID = 1;
    private int phone;
    private int gross;
    private int taxRate;
    private double taxOwned;
        //         customer enter his name,phone,grass income
    public Customer(String name, int phone, int gross) {
        customerID = currentID;
        this.name = name;
        this.phone = phone;
        this.gross = gross;
        currentID++;
       
        
        
        //you are assign grass income into purchaseAmount. if user enter 70.000$ , gross equal to 70.000 and 
        //purchaseAmount will equal to 70.000 as well
        double purchaseAmount = gross;

        
        //change the ownedTax according to gross income (purchaseAmount)
        taxOwnedCalculator(purchaseAmount);
        
        
       

        
        
        // you are calculating how much customer will paid according to his salary and his tax rate.
        double taxAmount = calculateTax(purchaseAmount);
        
        
       taxOwned = taxOwned - taxAmount; 
       
       
       
       
       if (taxOwned<0 ){
           System.out.println("I have to pay to you " + taxOwned );
       }else if (taxOwned > 0){
           System.out.println("you have to pay me" + taxOwned);
       }


    }  
    
private void taxOwnedCalculator(double purchaseAmount) {
    if (purchaseAmount > 50000) {
        taxOwned = 5000;
    } else {
        taxOwned = 3000;
    }
}

    
    
    // Method to calculate tax based on income
    private double calculateTax(double income) {
                                     //the variable in the bracket it is using in the curry bracket and it represnt the variable
                                     // of the user entered. so you dedicating what you gonna do with the variable give you.
                                     //in this method, "incom" is variable user give you. 
        if (income <= 0) {
            return 0;
        } else if (income <= 50000) {
            return income * 0.2; // 20% tax for income up to 10,000
        } else {
            return income * 0.3;
                    
                    }
        
     
    }
    
    
}


