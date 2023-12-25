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
    private int customerID;
    private  String name;
    private int phone;
    private int gross;
    private double taxOwned;

    private String customerPassword;
    
    public Customer(String name, int phone, int gross,String customerPassword) {
        
        this.name = name;
        this.phone = phone;
        this.gross = gross;
        this.customerPassword = customerPassword;
        


       
        double purchaseAmount = gross;

        
        
        taxOwnedCalculator(purchaseAmount);

        
        double taxAmount = calculateTax(purchaseAmount);
        
        
       taxOwned = taxOwned - taxAmount; 
       
       
       
       
       if (taxOwned<0 ){
           System.out.println("Goverment will pay you " + taxOwned + "$");
       }else if (taxOwned > 0){
           System.out.println("You need to pay" + taxOwned + "$ more");
       }


    }  
    
    public Customer(int id,String name, int phone, int gross,double taxOwned) {
        id = this.customerID;
        name = this.name;
        phone = this.phone;
        gross = this.gross;
        taxOwned = this.taxOwned;
                
            
    
    
    
    }
    
    
    
    
    
    
    
private void taxOwnedCalculator(double purchaseAmount) {
    if (purchaseAmount > 50000) {
        taxOwned = 5000;
    } else {
        taxOwned = 3000;
    }
}


    private double calculateTax(double income) {
                                     
        if (income <= 0) {
            return 0;
        } else if (income <= 50000) {
            return income * 0.2; 
        } else {
            return income * 0.3;
                    
                    }
        
     
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getGross() {
        return gross;
    }

    public void setGross(int gross) {
        this.gross = gross;
    }

    public double getTaxOwned() {
        return taxOwned;
    }

    public void setTaxOwned(double taxOwned) {
        this.taxOwned = taxOwned;
    }
    
    
    
    
    
    
}


