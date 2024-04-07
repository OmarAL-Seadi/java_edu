/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject11;

import java.util.Scanner;

/**
 *
 * @author Omar_Lord_War
 */
public class Mavenproject11 {

    public static void main(String[] args) {
        System.out.println("enter number pf students:");
       Scanner input=new Scanner (System.in);
       int num= input.nextInt();
       String name;
       int D=0;
       int max=0;
       for(int i=0;i<num;i++){
              System.out.println("enter sc num students:" + (i+1));
               D= input.nextInt();
              name=input.next();
          
                    if (D > max)
               {
                   max=D;
                   System.out.println(max);
               }
                     
       }
           System.out.println(max);
      

         
         
         
         
         
         
         
        
        
        
       
       
       
       
       
       
        
        
    }
}
