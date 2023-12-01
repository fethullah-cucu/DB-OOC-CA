/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.ooc.ca;

/**
 *
 * @author zhiya
 */
public class Customer {
    private String name;
    private int customerID;
    private int currentID = 1;
    private int phone;
    private int gross;
    private int taxRate;
    private int taxOwned;

    public Customer(String name, int phone, int gross) {
        customerID = currentID;
        this.name = name;
        this.phone = phone;
        this.gross = gross;
        currentID++;
    }
    
    
    
    
    
}
