/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject15;


public class Order {
   public static int NumberOfOrders=0;
      static String orderName;
     static double orderPrice; 
    
   public Order(String orderName,double orderPrice){
           this.orderName=orderName;
           this.orderPrice=orderPrice;
           NumberOfOrders++;
   }
   
   public String getorderName(){
           return orderName;}
   
   public double orderPrice(){
           return orderPrice;}
  
}
