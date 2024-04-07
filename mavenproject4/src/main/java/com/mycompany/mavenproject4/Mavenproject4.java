package com.mycompany.mavenproject4;

import java.util.Scanner;


public class Mavenproject4 {

    public static void main(String[] args) {
     
        
        int g=4,h=0;
          
        
          double result =DIV(g,h) ;
           System.out.println("Result of division: " + result);
    }
    
          public static double DIV (int g,int h){
boolean Right=false;

        do{
        try {
            
            
            double result = g / h; 
              System.out.println("Result of division: " + result);
             Right=true;
             return result;
              } 
        
                catch (ArithmeticException error) {
           System.err.println("Cant Divide by zero:" + error );
           System.out.println("Agin Enter Number (denominator) !! ");
           return -1;
           
           
                           }
        } while(!Right);
       
    }
}
  