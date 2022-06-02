/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.retailautomation;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;
/**
 *
 * @author koust
 */
public class StockManupulate {
    Scanner sc=new Scanner(System.in);
    Stock obj;
    int quantity;
    ArrayList<Purchase> purchase=new ArrayList<>();
    public LinkedList<Stock> stock =new LinkedList<>();
    public StockManupulate(){
        
        Stock s1=new Stock("Apple",25,25,179);
        
        
        Stock s2=new Stock("Mango",17,23.5, 73.75);
        
        
        Stock s3=new Stock("Banana",12,0, 50);
        
        
        Stock s4=new Stock("Kiwi",29,0,110);
        
        
        Stock s5=new Stock("Watermelon",9,0,20.75);
        
        
        Stock s6=new Stock("Jackfruit",13,0,29);
        
        
        Stock s7=new Stock("Orange",13,12,109);
        
        
        Stock s8=new Stock("Lemon",5,0,300);
        
        
        
        stock.add(s1);
        stock.add(s2);
        stock.add(s3);
        stock.add(s4);
        stock.add(s5);
        stock.add(s6);
        stock.add(s7);
        stock.add(s8);
        
        
        
        
        
        
    }
    public String display(){
        String s="";
        for(Stock i: stock){
            s=s+i.disp()+"\n";
            
        }
        return s;
    }
    public void makePurchase(String Product,String quantity){
        
        String name=Product;
        int quan=Integer.parseInt(quantity);
        
        
        Purchase p=new Purchase(name,quan);
        for(Stock i : stock){
            if(i.getProduct().equals(p.getProduct()) && i.getStock_left()>=p.getQuantity()){
                purchase.add(p);
                break;
            }
            
        }
        
        
        
    }
    public String cartDisplay(){
        String s="";
        for(Purchase i:purchase){
            s=s+i.getProduct()+" "+i.getQuantity()+"\n";
        }
        return s;
    }
    
    public void updateCart(String product){
        int index=0;
        UpdateCart update=new UpdateCart(product);
        for(Purchase i:purchase){
            if(i.getProduct().equals(update.getProduct())){
                index=purchase.indexOf(i);
                
            }
        }
        purchase.remove(index);
    }
    public String billing(String cust, String num){
        String s="--------------------------------------------------\n";
        String customer=cust;
        String number=num;
        
        double cost=0;
        double finalcost=0;
        double discount=0;
        for(Purchase i:purchase){
            for(Stock j:stock){
                
                if(i.getProduct().equals(j.getProduct())){
                    j.update(i.getQuantity());
                    cost=i.getQuantity()*j.getPrice();
                    
                    
                    if(j.getDiscount()>0){
                        discount=cost-((j.getDiscount()/100)*cost);
                        
                    }else{
                        discount=cost;
                        
                        
                    }break;
                }
            }finalcost=finalcost+discount;
                
        }
        s=s+"Customer Name: "+customer+"\n";
        s=s+"Phone Number: "+number+"\n";
        s=s+"Purchase Details"+"\n";
        for(Purchase i: purchase){
            s=s+"Product: "+i.getProduct()+" X "+i.getQuantity()+"\n";
        }
        s=s+"Total: "+finalcost+"\n";
        s=s+"Thankyou "+customer+" for shopping with us!"+"\n";
        s=s+"--------------------------------------------------";
//        
        return s;
    } 
    public void checkStock(){
        for(Stock i:stock){
            i.disp();
            System.out.println("");
        }
    }
    
}
