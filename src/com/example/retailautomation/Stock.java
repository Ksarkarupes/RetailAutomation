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
public class Stock {
	private static int count;
    private int id;
    private String product;
    private int stock_left;
    private double Discount;
    private double price;
    public Stock(String product, int stock_left, double Discount, double price){
    	count++;
        this.product=product;
        this.stock_left=stock_left;
        this.Discount=Discount;
        this.id=count;
        this.price=price;
    }

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public int getStock_left() {
        return stock_left;
    }

    public double getDiscount() {
        return Discount;
    }
    public double getPrice(){
        return price;
    }
    
    void update(int quantity){
       this.stock_left=stock_left-quantity;
    }
    String disp(){
        String s="ID: "+id+" Product: "+product+" Discount: "+Discount+"% Price /Kg: Rs. "+price+"\n";
        return s;
    }
    
    
}
