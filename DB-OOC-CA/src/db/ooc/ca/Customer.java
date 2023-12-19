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
    // AUTO SONRASIprivate int currentID = 1;
        //         customer enter his name,phone,grass income
    public Customer(String name, int phone, int gross,String customerPassword) {
        // AUTO SONRASI customerID = currentID;
        this.name = name;
        this.phone = phone;
        this.gross = gross;
        this.customerPassword = customerPassword;
        //AUTO SONRASIcurrentID++; some changes.    

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

        System.out.println(" customer class (1. constructer) worked.");
    }  
    
    public Customer(int id,String name, int phone, int gross,double taxOwned , String customerPassword) {
    this.customerID = id;
    this.name = name;
    this.phone = phone;
    this.gross = gross;
    this.taxOwned = taxOwned;
    this.customerPassword = customerPassword;

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

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
    
    
    
    
    
    
    
    
}


