/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package db.ooc.ca;

/**
 *
 * @author canif
 */
public class DBOOCCA {
    public static void main(String[] args) {
    double tax;
    Customer c1 = new Customer("feto",12345,60000);
        tax = c1.calculateTax(30000);
        
        System.out.println(tax);
    
    
    
    }
}

