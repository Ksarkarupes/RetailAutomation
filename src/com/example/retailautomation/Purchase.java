/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.retailautomation;

/**
 *
 * @author koust
 */
public class Purchase {
    String product;
    int quantity;
    public Purchase(String product, int quantity){
        this.product=product;
        this.quantity=quantity;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
}
